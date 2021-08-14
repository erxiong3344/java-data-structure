public class Queue<E> {
    private List<E> list = new LinkedList<>();

    public void clear()
    {
        list.clear();
    }

    public int size()
    {
        return  list.size();
    }

    public E deQueue()
    {
        return list.remove(0);
    }

    public void enQueue(E element)
    {
        list.add(element);
    }

    public boolean isEmpty()
    {
        return  list.isEmpty();
    }

    public E front()
    {
        return list.get(0);
    }
}
