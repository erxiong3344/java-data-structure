public class LinkedList<E> extends AbstractList<E>{

    private Node<E> first;
    private Node<E> last;
    private Node<E> current;

    private static class Node<E>
    {
        E element;
        Node<E> prev;
        Node<E> next;
        public Node(E element,Node<E> prev,Node<E> next)
        {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            String str = "";
            if(prev != null)
            {
                str += prev.element;
            }
           str += "_";
            str += element;
            str += "_";
            if(next != null)
            {
                str += next.element;
            }
            return str;
        }
    }



    //获取index处的元素
    public E get(int index)
    {
        Node<E> node = findNode(index);
        return node.element;
    }


    //设置index处的元素,返回原先的元素
    public E set(int index,E element)
    {
        Node<E> node = findNode(index);
        E old = node.element;
        node.element = element;
        return old;
    }


    //清空双向链表
    public void clear()
    {
        first = null;
        last = null;
        size = 0;
    }




    //添加元素
    public void add(E element)
    {
        add(size,element);
    }

    public void add(int index,E element)
    {
        rangeCheckForAdd(index);
        if(index == size)
        {
            Node<E> oldLast = last;
            Node<E> node = new Node<>(element,oldLast,first);
            last = node;
            if(oldLast == null) //链表中添加第一个元素
            {
                first = last;
                first.next = first;
                first.prev = first;
            }
            else{
                oldLast.next = last;
                first.prev = last;
            }

        }
        else
        {
            Node<E> next = findNode(index); //新添加节点的后一个节点
            Node<E> prev = next.prev; //新添加的节点的前一个节点
            Node<E> node = new Node<>(element,prev,next);
            next.prev = node;
            prev.next = node;
            if(next == first) //index == 0 / next == first
            {
                first = node;
            }


        }
        size++;
    }

    //打印
    public void print()
    {
        Node<E> node = first;
        System.out.print("size = " + size + " [");
        for (int i = 0; i < size; i++) {
            if(i >= 1)
            {
                System.out.print(",");
            }
            System.out.print(node);
            node = node.next;
        }
        System.out.println("]");
    }


    //删除index处元素
    public E remove(int index)
    {
        rangeCheck(index);
        return remove(findNode(index));

    }



   private E remove(Node<E> node)
   {
       if(size == 1)
       {
           first = null;
           last = null;
       }
       else
       {
           Node<E> next = node.next;
           Node<E> prev = node.prev;
           prev.next = next;
           next.prev = prev;
           if(prev == last) //index = 0
           {
               first = next;
           }

           if(next == first) // index = size - 1
           {
               last = prev;
           }
       }
       size--;
       return node.element;
   }

    //删除数组中element
    public E remove(E element)
    {
        return remove(IndexOf(element));
    }

    public Node<E> findNode(int index) {
        if(index > (size >> 1))
        {
            //从后向前找
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
            return node;

        }
        else{
            //从前向后找
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
    }

    //查看元素的索引
    public int IndexOf(E element)
    {
        if(element == null)
        {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if(node.element == null)
                {
                    return i;
                }
                node = node.next;
            }
        }
        else
        {
            Node<E> node = first;
            for (int i = 0; i < size; i++) {
                if(element.equals(node.element))
                {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }


    //将current指向头结点first
    public void reset()
    {

        current = first;
    }

    //current向后走一步,即current = current.next
    public E next()
    {
        if(current == null) return null;
        current = current.next;
        return current.element;
    }
    //删除current指向的节点,删除成功后,让current指向下一个节点
    public E remove()
    {
        if(current == null) return null;
        Node<E> next = current.next;
        E element = remove(current);
        if(size == 0)
        {
            current = null;
        }
        else
        {
            current = next;

        }
        return element;

    }


}
