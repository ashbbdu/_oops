package Day4;

public class Student {
    private String name;
    private int grade;

    Student (String name , int grade) {
        this.name = name;
        this.grade = grade;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setGrade (int grade) {
        if(grade >= 0 && grade <= 100) {
            this.grade = grade;
        } else {
            System.out.println("Grade should be in between 0 and 100");
        }
    }
}
