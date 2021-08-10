public class Main {
    public static void main(String[] args) {

        ArrayList<Person> arrayList = new ArrayList<>();
        arrayList.add(new Person("jack",12));
        arrayList.add(new Person("tom",15));
        arrayList.add(null);
        arrayList.add(new Person("avril",16));
        arrayList.add(null);
        arrayList.add(new Person("diamond",18));
        arrayList.printArr();
        arrayList.remove(2);
        arrayList.printArr();
        System.out.println(arrayList.IndexOf(null));
        arrayList.clear();
        System.gc();
    }
}
