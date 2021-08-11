/**
 * 增加一个虚拟头结点
 * @param <E>
 */
public class LinkedList2<E>  extends AbstractList<E>{

    private Node<E> first;
    public LinkedList2()
    {
        first = new Node<>(null,null);
    }



    private static class Node<E>
    {
        E element;
        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }



    //获取index处的元素
    public E get(int index)
    {
        return findNode(index).element;
    }


    //设置index处的元素,返回原先的元素
    public E set(int index,E element)
    {
        Node<E> node = findNode(index);
        E old = node.element;
        node.element = element;
        return old;
    }

    //清空数组
    public void clear()
    {
        first = null;
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
        Node<E> prev = (index == 0) ? first: findNode(index - 1);
        Node<E> newNode = new Node<>(element,prev.next);
        prev.next = newNode;
        size++;
    }

    //查看元素的索引
    public int IndexOf(E element)
    {
        if(element == null)
        {
            Node<E> node = first.next;
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
            Node<E> node = first.next;
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


    //打印
    public void print()
    {
        Node<E> node = first.next;
        System.out.print("size = " + size + " [");
        for (int i = 0; i < size; i++) {
            if(i >= 1)
            {
                System.out.print(",");
            }
            System.out.print(node.element);
            node = node.next;
        }
        System.out.println("]");
    }


    //删除index处元素
    public E remove(int index)
    {
        rangeCheck(index);
        //index-1处的节点指向index+1处的节点
        Node<E> prev = (index == 0) ? first : findNode(index - 1);
        Node<E> node = prev.next;
        prev.next = node.next;
        size--;
        return node.element;
    }

    //删除数组中element
    public E remove(E element)
    {

        return remove(IndexOf(element));
    }

    //根据索引找到节点,并返回节点
    public Node<E> findNode(int index)
    {
        rangeCheck(index);
        Node<E> node = first.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

}
