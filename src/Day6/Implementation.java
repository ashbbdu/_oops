package Day6;

public class Implementation {
    public static void main(String[] args) {
        Student s = new Student("Ashish" , 90);
        Student t = new Student(s);

        System.out.println( s.getName());
        System.out.println(t.getName());

        t.setName("Test");

        System.out.println();
        System.out.println( s.getName());
        System.out.println(t.getName());
    }
}
