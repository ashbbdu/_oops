# Day 3 — Constructors (Default + Parameterized)
**Topic:** Constructor kya hota hai, default vs parameterized, aur kyun zaroori hai.
**Date:** 12 May 2026

---

## Core Concept

**Constructor** = Ek special method jo object banate waqt **automatically** call hota hai.

Kaam: Object ke fields ko **initialize** karna (starting values dena).

**3 Rules yaad rakho:**
1. Constructor ka naam **class ke naam jaisa** hota hai (exact match, capital bhi)
2. Constructor ka **koi return type nahi** hota (`void` bhi nahi)
3. `new` keyword likhte hi **automatically** call ho jaata hai

```java
class Student {
    String name;
    int age;

    // Ye constructor hai
    Student(String n, int a) {
        name = n;
        age = a;
    }
}

Student s = new Student("Ashish", 20);
//                       ↑ ye values constructor ko jaati hain
```

---

## Types of Constructors

### 1. Default Constructor (No-arg Constructor)

Koi parameter nahi leta. Sirf "empty" object banata hai.

```java
class Car {
    String brand;
    int speed;

    // Default constructor
    Car() {
        brand = "Unknown";
        speed = 0;
        System.out.println("Car object created!");
    }
}

Car c = new Car();  // Car() constructor call hoga
System.out.println(c.brand); // Unknown
```

**Important:** Agar tum koi bhi constructor nahi likhte, Java khud ek **invisible default constructor** deta hai. Jaise hi tum koi constructor likhte ho, Java ka woh automatic wala **band ho jaata hai**.

---

### 2. Parameterized Constructor

Values lekar object ko directly initialize karta hai.

```java
class Car {
    String brand;
    int speed;

    // Parameterized constructor
    Car(String b, int s) {
        brand = b;
        speed = s;
    }
}

Car c1 = new Car("Honda", 120);
Car c2 = new Car("BMW", 200);

System.out.println(c1.brand); // Honda
System.out.println(c2.speed); // 200
```

---

### 3. Dono saath — Default + Parameterized

Ek class mein dono ho sakte hain (Constructor Overloading — Day 4 mein detail mein):

```java
class Student {
    String name;
    int age;

    // Default
    Student() {
        name = "Unknown";
        age = 0;
    }

    // Parameterized
    Student(String n, int a) {
        name = n;
        age = a;
    }

    void display() {
        System.out.println(name + " | Age: " + age);
    }
}

Student s1 = new Student();              // default
Student s2 = new Student("Ashish", 20); // parameterized

s1.display(); // Unknown | Age: 0
s2.display(); // Ashish | Age: 20
```

---

## Interview Questions & Answers

---

### Q1. Constructor kya hota hai? Method se kaise alag hai?

**Answer:**

Constructor ek special block hai jo object create hote waqt **automatically** call hota hai. Iska kaam fields ko initialize karna hai.

| Feature | Constructor | Method |
|---------|-------------|--------|
| Naam | Class ke naam jaisa | Kuch bhi |
| Return type | Koi nahi (void bhi nahi) | Hona chahiye (void ya kuch) |
| Call kab hota hai | `new` se automatically | Explicitly call karna padta hai |
| Purpose | Object initialize karna | Koi kaam karna |

```java
class Box {
    int side;

    Box(int s) {       // Constructor — return type nahi
        side = s;
    }

    int volume() {     // Method — return type hai
        return side * side * side;
    }
}
```

---

### Q2. Java ka default constructor kya hota hai? Kab milta hai?

**Answer:**

Agar tum apni class mein **koi bhi constructor nahi likhte**, tab Java compiler khud ek no-argument constructor add kar deta hai. Ise **compiler-provided default constructor** kehte hain.

```java
class Dog {
    String name;
    // koi constructor nahi likha
}

Dog d = new Dog(); // ye kaam karta hai — Java ne default diya
```

Lekin jaise hi tum **apna koi constructor likhte ho** (even parameterized), Java ka automatic wala **band ho jaata hai**:

```java
class Dog {
    String name;

    Dog(String n) {   // humne ye likha
        name = n;
    }
}

Dog d = new Dog();        // ERROR! Default constructor nahi hai ab
Dog d = new Dog("Bruno"); // Ye chalega
```

**Fix:** Agar dono chahiye to dono explicitly likho.

---

### Q3. Constructor overloading kya hoti hai? (Preview)

**Answer:**

Ek class mein **multiple constructors** hona, different parameters ke saath — ye Constructor Overloading hai.

```java
class Circle {
    double radius;

    Circle() {          // no-arg
        radius = 1.0;
    }

    Circle(double r) {  // parameterized
        radius = r;
    }
}

Circle c1 = new Circle();     // radius = 1.0
Circle c2 = new Circle(5.5);  // radius = 5.5
```

Detail: Day 4 mein `this()` ke saath.

---

### Q4. Kya constructor `return` statement use kar sakta hai?

**Answer:**

Constructor mein **`return value` nahi** hota. Lekin empty `return;` allowed hai (early exit ke liye, rare case):

```java
class Validator {
    int value;

    Validator(int v) {
        if (v < 0) {
            value = 0;
            return;  // early exit — allowed
        }
        value = v;
    }
}
```

`return 5;` jaisa kuch likhne par **compile error** aayega.

---

### Q5. Constructor chaining kya hoti hai? (`this()` — Day 4 preview)

**Answer:**

Ek constructor ke andar **doosra constructor** call karna — `this()` se. Ye Day 4 ka main topic hai, ek simple example abhi:

```java
class Rectangle {
    int length, width;

    Rectangle() {
        this(1, 1); // calls 2-arg constructor
    }

    Rectangle(int l, int w) {
        length = l;
        width = w;
    }
}
```

---

## Full Example — All Concepts Together

```java
class Book {
    String title;
    String author;
    double price;

    // Default constructor
    Book() {
        title = "Untitled";
        author = "Unknown";
        price = 0.0;
    }

    // Parameterized constructor
    Book(String t, String a, double p) {
        title = t;
        author = a;
        price = p;
    }

    // Only title and author, price defaults to 99.0
    Book(String t, String a) {
        title = t;
        author = a;
        price = 99.0;
    }

    void display() {
        System.out.println("\"" + title + "\" by " + author + " — ₹" + price);
    }
}

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("Clean Code", "Robert Martin", 599.0);
        Book b3 = new Book("Atomic Habits", "James Clear");

        b1.display(); // "Untitled" by Unknown — ₹0.0
        b2.display(); // "Clean Code" by Robert Martin — ₹599.0
        b3.display(); // "Atomic Habits" by James Clear — ₹99.0
    }
}
```

---

## Practice Problems

**Problem 1 — Book class (Warm-up)**
`Book` class banao — fields: `title`, `author`, `price`.
- Default constructor: sab fields ko "N/A" / 0.0 set karo
- Parameterized constructor: teeno fields set karo
- `display()` method: details print karo
- Main mein ek default Book aur ek parameterized Book banao

---

**Problem 2 — Employee class**
`Employee` class banao — fields: `empId` (int), `name` (String), `salary` (double).
- Sirf parameterized constructor (teeno fields lo)
- `display()` method
- Main mein 3 employees banao aur display karo

---

**Problem 3 — Point class (Maths wala)**
`Point` class banao — fields: `x` (double), `y` (double).
- Default constructor: point at origin (0, 0)
- Parameterized constructor: given x, y
- `distanceFromOrigin()` method — formula: `Math.sqrt(x*x + y*y)`
- `distanceTo(Point other)` method — formula: `Math.sqrt((x-other.x)^2 + (y-other.y)^2)`
- Main mein 2 points banao, dono distances print karo

---

## Quick Revision — One-liners

- Constructor = special method, object banate waqt auto call hota hai
- Return type nahi hota (void bhi nahi), naam = class ka naam
- Default constructor = Java deta hai jab koi constructor nahi likha
- Ek baar apna constructor likha = Java ka default band
- Same class mein multiple constructors = Constructor Overloading
- `new` keyword → memory allocate → constructor call → reference return
