package Day6;

public class Student {
    private String name;
    private int marks;

    Student (String name , int marks ) {
        this.name = name;
        this.marks = marks;
    }

    Student (Student other) {
        this.name = other.name;
        this.marks = other.marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }






}
