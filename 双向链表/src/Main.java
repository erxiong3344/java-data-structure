public class Main {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(0,20);
        list.add(40);
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(list.size(),30);
        list.print();
        list.remove(1);
        list.remove(1);
        list.remove(list.size() - 1);

        list.print();
    }
}
