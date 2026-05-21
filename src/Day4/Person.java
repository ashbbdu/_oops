package Day4;

public class Person {
    private String name;
    private int age;

    public String getName () {
        return this.name;
    }
    public void setName (String name) {
        this.name = name;
    }

    public int getAge () {
        return age;
    }

    public void setAge (int age) {
        if(age > 0) {
            this.age = age;
        } else {
            System.out.println("Age should be greater than 0 !");
        }
    }
}
