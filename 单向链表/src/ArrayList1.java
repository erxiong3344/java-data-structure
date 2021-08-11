//动态数组缩容
public class ArrayList1<E>  extends AbstractList<E>{
    private static final int DEFAULT_CAPACITY = 4;


    private E[] elements; //所有元素

    public ArrayList1() {
        this(DEFAULT_CAPACITY);
    }


    public ArrayList1(int capacity) {
        capacity = (capacity > DEFAULT_CAPACITY) ? capacity : DEFAULT_CAPACITY;
        elements = (E[])new Object[capacity];
    }



    //获取index处的元素
    public E get(int index)
    {
        rangeCheck(index);
        return elements[index];
    }

    //设置index处的元素,返回原先的元素
    public E set(int index,E element)
    {
        rangeCheck(index);
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    //查看元素的索引
    public int IndexOf(E element) {
        if(element == null)
        {
            for (int i = 0; i < size; i++) {
                if(elements[i] == null)
                    return i;
            }
        }
        else
        {
            for (int i = 0; i < size; i++) {
                if(element.equals(elements[i]))
                {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    //清空数组
    public void clear()
    {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
        if(elements != null && elements.length > DEFAULT_CAPACITY)
        {
            elements = (E[])new Object[DEFAULT_CAPACITY];
        }
    }

    public void ensureCapacity(int requiredCapacity)
    {
        int oldCapacity = elements.length;
        int newCapacity = 0;
        if(oldCapacity >= requiredCapacity)
        {
            return;
        }
        //新容量为旧容量的1.5倍
        newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        System.out.println("扩容成功,旧的容量为" + oldCapacity
                + "新的容量为" + newCapacity);
        elements = newElements;
    }

    //添加元素
    public void add(E element)
    {
        add(size,element);
    }

    public void add(int index,E element)
    {
        rangeCheckForAdd(index);
        ensureCapacity(size + 1);
        for (int i = size; i > index ; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }




    public void print()
    {
        System.out.print("size = " + size + " [");
        for (int i = 0; i < size; i++) {
            if(i >= 1)
            {
                System.out.print(",");
            }
            System.out.print(elements[i]);
        }
        System.out.println("]");
    }

    private void trim()
    {
        int capacity = elements.length;
        if(size > (capacity >> 1) || capacity <= DEFAULT_CAPACITY)
        {
            return;
        }
        int newCapacity = capacity >> 1;
        E[] newElements = (E[])new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        System.out.println("原容量为" + capacity + "缩容后的容量为" + newCapacity);
    }

    //删除index处元素
    public E remove(int index)
    {
        rangeCheck(index);
        E old = elements[index];
        for(int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
        trim();
        return old;
    }

    //删除数组中element
    public E remove(E element)
    {
        return remove(IndexOf(element));

    }
}
