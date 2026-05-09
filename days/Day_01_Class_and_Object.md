# Day 1 — Class and Object
**Topic:** What is a Class? What is an Object?
**Date:** 9 May 2026

---

## Core Concept

**Class** = A blueprint or template. It defines what properties and behaviors an object will have.
**Object** = An actual instance created from that blueprint.

> Analogy: Class is like a **house blueprint**. The blueprint itself is not a house — but you can build multiple houses from it. Each house (object) is separate and independent.

---

## Interview Questions & Answers

---

### Q1. What is the difference between a Class and an Object? Give a real-life example.

**Answer:**

A **class** is a blueprint or template that defines the structure — what data it holds (fields) and what it can do (methods). A class does not occupy memory on its own.

An **object** is a real instance created from that class. Each object has its own copy of fields and occupies memory in the heap.

**Real-life example:**
- Class = Design/blueprint of a Car (defines: brand, speed, accelerate())
- Object = An actual car: Honda City, Maruti Swift — each is separate with its own brand and speed

```java
class Car {
    String brand;
    int speed;

    void accelerate() {
        System.out.println(brand + " is accelerating!");
    }
}

// Objects
Car c1 = new Car();   // Honda City
Car c2 = new Car();   // Maruti Swift
```

---

### Q2. What does the `new` keyword do internally?

**Answer:**

The `new` keyword does three things:
1. **Allocates memory** on the heap for the new object
2. **Calls the constructor** to initialize the object
3. **Returns a reference** (memory address) which is stored in the variable

```java
Car c1 = new Car();
//         ^^^
//  1. Heap me memory allocate hui
//  2. Car() constructor call hua
//  3. us memory ka reference c1 me store hua
```

> `c1` does not hold the object itself — it holds the **address/reference** of where the object lives in memory.

---

### Q3. How many objects can be created from one class?

**Answer:**

As many as needed — there is **no limit**. Every time you write `new ClassName()`, a new independent object is created on the heap.

```java
Car c1 = new Car();
Car c2 = new Car();
Car c3 = new Car();
// All three are separate objects, each with their own fields
```

---

### Q4. What is the difference between Fields and Methods?

**Answer:**

| | Fields | Methods |
|---|---|---|
| What | Variables that store data | Functions that define behaviour |
| Also called | Instance variables, attributes, properties | Functions, behaviours |
| Example | `String brand`, `int speed` | `void accelerate()` |

```java
class Student {
    String name;    // field — stores data
    int marks;      // field — stores data

    void display() {          // method — defines behaviour
        System.out.println(name + ": " + marks);
    }
}
```

---

### Q5. Do two objects of the same class share their field values?

**Answer:**

**No.** Each object gets its **own separate copy** of instance fields. Changing one object's field does not affect another object.

```java
Car c1 = new Car();
c1.brand = "Honda";
c1.speed = 100;

Car c2 = new Car();
c2.brand = "Maruti";
c2.speed = 80;

System.out.println(c1.brand);  // Honda  — unaffected
System.out.println(c2.brand);  // Maruti — unaffected
```

Each object is **independent** in memory.

---

## Full Example — Putting it all together

```java
class Student {
    String name;
    int rollNo;
    int marks;

    void display() {
        System.out.println("Name: " + name + " | Roll: " + rollNo + " | Marks: " + marks);
    }
}

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "Ashish";
        s1.rollNo = 101;
        s1.marks = 85;

        Student s2 = new Student();
        s2.name = "Rahul";
        s2.rollNo = 102;
        s2.marks = 90;

        Student s3 = new Student();
        s3.name = "Priya";
        s3.rollNo = 103;
        s3.marks = 78;

        s1.display();  // Name: Ashish | Roll: 101 | Marks: 85
        s2.display();  // Name: Rahul  | Roll: 102 | Marks: 90
        s3.display();  // Name: Priya  | Roll: 103 | Marks: 78
    }
}
```

---

## Practice Problems

1. Create a `BankAccount` class — fields: `accountHolder`, `balance`. Method: `showBalance()` that prints both.
2. Create a `Rectangle` class — fields: `length`, `width`. Methods: `area()` and `perimeter()` that print the result.
3. Create a `Phone` class — fields: `brand`, `model`, `price`. Method: `describe()` that prints all three. Create 2 phone objects.

---

## Quick Revision — One-liners

- Class = blueprint, Object = instance created from blueprint
- `new` = allocate heap memory + call constructor + return reference
- One class → unlimited objects
- Fields = data, Methods = behaviour
- Each object has its own independent copy of fields
