import com.sun.deploy.security.SelectableSecurityManager;

public class LinkedList<E> extends AbstractList<E>{

    private Node<E> first;
    private Node<E> last;

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
            last = new Node<>(element,last,null);
            if(oldLast == null) //链表中添加第一个元素
            {
                first = last;

            }
            else
            {
                oldLast.next = last;
            }
        }
        else
        {
            Node<E> next = findNode(index);
            Node<E> prev = next.prev;
            Node<E> node = new Node<>(element,prev,next);
            if(prev == null) //第一个节点
            {
                first = node;
            }
            else{
                prev.next = node;
            }
            next.prev = node;
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
        Node<E> node = findNode(index);
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        if(prev == null) //index = 0
        {
            first = next;
        }
        else
        {
            prev.next = next;
        }
       if(next == null) //index = size - 1
       {
            last = prev;
       }
       else
       {
           next.prev = prev;
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


}
