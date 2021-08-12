public class Stack<E> {
    private List<E> list = new LinkedList<>();
    public int size()
    {
        return list.size();
    }
    public E pop()
    {
        return list.remove(list.size() - 1);
    }

    public E top()
    {
        return list.get(list.size() - 1);
    }

    public void push(E element)
    {
        list.add(list.size(),element);
    }

    public boolean isEmpty()
    {
        return list.isEmpty();
    }

   public void clear()
 {
	list.clear();
 }
}
