public interface List<E>{
    public static final int ELEMENT_NOT_FOUND = -1;
    //返回元素个数
    int size();

    //判断是否为空
    boolean isEmpty();

    //获取index处的元素
     E get(int index);


    //设置index处的元素,返回原先的元素
    E set(int index,E element);

    //查看元素的索引
     int IndexOf(E element);

    //清空数组
     void clear();




    //添加元素
     void add(E element);

     void add(int index,E element);



    //查看是否包含某个元素
    boolean contains(E element);

    //打印
     void print();


    //删除index处元素
    E remove(int index);

    //删除数组中element
     E remove(E element);
}
