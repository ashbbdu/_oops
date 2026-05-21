# Day 7 — Week 1 Revision + Mini Project
**Topic:** Week 1 ke saare concepts ek jagah + Student Grade System banana.
**Date:** 17 May 2026

---

## Week 1 — Quick Revision

### Day 1: Class aur Object
- Class = blueprint, Object = us blueprint se bani real cheez
- Object heap pe banta hai, `new` keyword se
- Fields = data, Methods = behaviour

```java
class Car { String brand; void drive() { } }
Car c = new Car();  // object
```

---

### Day 2: Methods aur `new` keyword
- `new` heap pe memory allocate karta hai
- Method = class ke andar function — return type, parameters
- Ek class ke multiple objects ban sakte hain, sab independent

```java
class Calculator {
    int add(int a, int b) { return a + b; }
}
```

---

### Day 3: Constructors
- Object banate waqt automatically call hota hai
- Default constructor: no parameters
- Parameterized constructor: values pass karo
- Constructor ka naam = class ka naam, koi return type nahi

```java
Student() { }                          // default
Student(String name, int marks) { }    // parameterized
```

---

### Day 4: Constructor Overloading + `this`
- Same class mein multiple constructors — different parameters
- `this.field` = current object ka field (name conflict solve)
- `this()` = ek constructor se doosra constructor call karna (chaining)

```java
Box() { this(1, 1, 1); }           // this() — chaining
Box(double l, double w, double h) {
    this.length = l;               // this.field — conflict resolve
}
```

---

### Day 5: Static vs Instance
- Instance variable = har object ka apna copy
- Static variable = ek copy, sabhi share karte hain, class level
- Static method = object ke bina call hoti hai, `this` nahi hota

```java
static int count = 0;    // shared
int id;                  // per object
static void show() { }   // ClassName.show()
```

---

### Day 6: Copy Constructor + Pass-by-Value
- Copy constructor = existing object se naya object banana
- Shallow copy = references copy (risky), Deep copy = naye objects (safe)
- Java = hamesha pass-by-value; object ke case mein reference ki copy jaati hai
- Object fields change ho sakte hain method mein, reference replace nahi hota

```java
Student(Student other) {
    this.name = other.name;
    this.address = new Address(other.address.city);  // deep copy
}
```

---

## Week 1 — Concept Map

```
Class & Object
    └── Fields + Methods
    └── new keyword → Heap allocation

Constructor
    └── Default / Parameterized
    └── Overloading (multiple constructors)
    └── this() → Constructor chaining
    └── this.field → name conflict resolve

Static vs Instance
    └── Static → class level, shared, no 'this'
    └── Instance → object level, per object

Copy Constructor
    └── Shallow copy → reference copy (bug prone)
    └── Deep copy → new object (safe)
    └── Pass-by-value → reference ki copy, fields change ho sakti hain
```

---

## Mini Project — Student Grade System

**Requirements:**
- `Student` class: `name`, `rollNo`, `int[] marks` (5 subjects)
- Constructor se initialize karo
- Methods: `totalMarks()`, `average()`, `grade()`, `display()`
- Main mein 3 students banao, sab ki report card print karo
- **Bonus:** `topper()` — static method, sabse zyada marks wala student

---

### Step 1 — Student Class

```java
class Student {
    String name;
    int rollNo;
    int[] marks;  // 5 subjects

    // Constructor
    Student(String name, int rollNo, int[] marks) {
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }

    // Total marks
    int totalMarks() {
        int total = 0;
        for (int m : marks) {
            total += m;
        }
        return total;
    }

    // Average
    double average() {
        return (double) totalMarks() / marks.length;
    }

    // Grade based on average
    String grade() {
        double avg = average();
        if (avg >= 90) return "A";
        if (avg >= 75) return "B";
        if (avg >= 60) return "C";
        if (avg >= 40) return "D";
        return "F";
    }

    // Full report card
    void display() {
        System.out.println("==========================");
        System.out.println("Name    : " + name);
        System.out.println("Roll No : " + rollNo);
        System.out.print("Marks   : ");
        for (int i = 0; i < marks.length; i++) {
            System.out.print("S" + (i + 1) + ":" + marks[i]);
            if (i < marks.length - 1) System.out.print(" | ");
        }
        System.out.println();
        System.out.println("Total   : " + totalMarks() + "/500");
        System.out.println("Average : " + average());
        System.out.println("Grade   : " + grade());
        System.out.println("==========================");
    }

    // Bonus — static method: topper kaun hai
    static Student topper(Student[] students) {
        Student best = students[0];
        for (Student s : students) {
            if (s.totalMarks() > best.totalMarks()) {
                best = s;
            }
        }
        return best;
    }
}
```

---

### Step 2 — Main Class

```java
public class Main {
    public static void main(String[] args) {

        Student s1 = new Student("Ashish", 101, new int[]{85, 90, 78, 92, 88});
        Student s2 = new Student("Priya",  102, new int[]{70, 65, 80, 75, 72});
        Student s3 = new Student("Rahul",  103, new int[]{55, 60, 50, 45, 58});

        Student[] students = {s1, s2, s3};

        // Sab ki report card print karo
        for (Student s : students) {
            s.display();
        }

        // Topper announce karo
        Student best = Student.topper(students);
        System.out.println("TOPPER: " + best.name + " with " + best.totalMarks() + "/500");
    }
}
```

---

### Expected Output

```
==========================
Name    : Ashish
Roll No : 101
Marks   : S1:85 | S2:90 | S3:78 | S4:92 | S5:88
Total   : 433/500
Average : 86.6
Grade   : B
==========================
==========================
Name    : Priya
Roll No : 102
Marks   : S1:70 | S2:65 | S3:80 | S4:75 | S5:72
Total   : 362/500
Average : 72.4
Grade   : C
==========================
==========================
Name    : Rahul
Roll No : 103
Marks   : S1:55 | S2:60 | S3:50 | S4:45 | S5:58
Total   : 268/500
Average : 53.6
Grade   : D
==========================
TOPPER: Ashish with 433/500
```

---

## Week 1 — Interview Questions Recap

---

### Q1. Class aur Object mein kya difference hai?

**Answer:**

Class = blueprint / template — memory mein nahi hota.
Object = us blueprint se bani actual cheez — heap pe memory allocate hoti hai.

```java
class Dog { }          // blueprint — no memory
Dog d = new Dog();     // object — heap pe memory
```

Ek class se multiple objects ban sakte hain, sab independent.

---

### Q2. Constructor aur Method mein kya difference hai?

**Answer:**

| | Constructor | Method |
|--|-------------|--------|
| Naam | Class ke naam jaisa | Kuch bhi |
| Return type | Koi nahi (void bhi nahi) | Hota hai (void bhi ho sakta) |
| Call | `new` ke saath automatic | Manually call karna padta hai |
| Purpose | Object initialize karna | Behaviour define karna |

---

### Q3. `this` keyword ke kya uses hain?

**Answer:** 3 uses:

1. **Field vs parameter conflict resolve:** `this.name = name`
2. **Constructor chaining:** `this(1, 1, 1)` — ek constructor se doosra call karna
3. **Current object return karna:** `return this` — method chaining ke liye

---

### Q4. Static aur Instance mein kya difference hai?

**Answer:**

Instance = har object ka apna — alag-alag copy, object ke saath banta/khatam hota.
Static = class level — ek hi copy, sabhi share karte hain, class load hone se program khatam tak.

Static method mein `this` nahi hota kyunki koi specific object exist nahi karta.

---

### Q5. Java mein pass-by-value hai ya pass-by-reference?

**Answer:**

Hamesha **pass-by-value**.

- Primitive: value ki copy jaati hai — original unchanged.
- Object: reference ki copy jaati hai — fields change ho sakte hain, lekin original reference replace nahi hoti.

```java
void change(Student s) {
    s.name = "New";      // original ka naam badlega
    s = new Student();   // sirf local reference badla, bahar koi effect nahi
}
```

---

## Practice Problems

**Problem 1 — Grade System Extend karo**

Upar wale Student Grade System mein yeh add karo:
- `isPass()` method — average >= 40 toh `true`
- `topSubject()` — sabse zyada marks wale subject ka number return karo (1-5)
- `lowestSubject()` — sabse kam marks wale subject ka number
- `display()` mein in dono ko bhi print karo

---

**Problem 2 — Copy Constructor add karo**

`Student` class mein copy constructor add karo:
- `int[] marks` ek array hai — shallow copy mat karna, deep copy karo (naya array banao)
- Verify karo: copied student ke marks change karne se original affect na ho

```java
Student copy = new Student(s1);  // copy constructor
copy.marks[0] = 0;               // s1.marks[0] change nahi hona chahiye
```

---

**Problem 3 — Static counter add karo**

`Student` class mein:
- `static int totalStudents` — har naya Student bante waqt badhao
- `static void showStats(Student[] students)` — total students, class average, topper ka naam print karo
- Main ke end mein `Student.showStats(students)` call karo

---

## Quick Revision — Week 1 Ek Nazar Mein

| Concept | Key Point |
|---------|-----------|
| Class | Blueprint — no memory |
| Object | `new` se banta hai — heap pe |
| Constructor | Automatic call, naam = class naam, no return type |
| `this` | Current object — 3 uses: conflict, chaining, return |
| Static | Class level, shared, no `this` |
| Instance | Per object, independent |
| Copy Constructor | Khud likhna padta hai, deep copy prefer karo |
| Pass-by-value | Java mein hamesha — object mein reference ki copy |
