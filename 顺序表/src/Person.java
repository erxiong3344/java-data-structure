public class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("Person -- finalize");
    }

    public boolean equals(Object obj)
    {
        if(obj == null)
        {
            return false;
        }
        if(!(obj instanceof Person))
        {
            return false;
        }
        Person person = (Person)obj;
        return this.name.equals(person.name) && this.age == person.age;
    }
}
