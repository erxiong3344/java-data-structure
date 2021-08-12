public abstract class AbstractList<E> implements List<E> {
    protected int size;//线性表中元素个数

    protected void rangeCheckForAdd(int index)
    {
        if(index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("index:" + index + "size:" + size);
        }
    }

    protected void rangeCheck(int index)
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

    public int size()
    {
        return size;
    }

    //查看是否包含某个元素
    public boolean contains(E element)
    {
        return IndexOf(element) != ELEMENT_NOT_FOUND;
    }
}
