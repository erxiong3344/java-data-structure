public class ArrayList<E>{
    private static final int DEFAULT_CAPACITY = 2;
    private static final int ELEMENT_NOT_FOUND = -1;
    private int size; //元素数量
    private E[] elements; //所有元素

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }


    public ArrayList(int capacity) {
        capacity = (capacity > DEFAULT_CAPACITY) ? capacity : DEFAULT_CAPACITY;
        elements = (E[])new Object[capacity];
    }

    public void rangeCheckForAdd(int index)
    {
        if(index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("index:" + index + "size:" + size);
        }
    }

    public void rangeCheck(int index)
    {
        if(index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("index:" + index + "size:" + size);
        }
    }

    public boolean isEmpty()
    {
        return size == 0;
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


    //查看是否包含某个元素
    public boolean contains(E element)
    {
        return IndexOf(element) != ELEMENT_NOT_FOUND;
    }

    public void printArr()
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

    //删除index处元素
    public E remove(int index)
    {
        rangeCheck(index);
        E old = elements[index];
        for(int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }

        elements[--size] = null;
        return old;
    }

    //删除数组中element
    public E remove(E element)
    {
        return remove(IndexOf(element));

    }

}
