# Day 6 — Copy Constructor + Object as Parameter/Return
**Topic:** Object ki copy banana, object pass karna, Java ka pass-by-value truth.
**Date:** 17 May 2026

---

## Core Concept

**Copy Constructor** = ek existing object ki exact copy banana using another constructor.

Java mein default copy constructor nahi hota (C++ se alag). Khud likhna padta hai.

---

## Copy Constructor

```java
class Student {
    String name;
    int marks;

    // Normal constructor
    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // Copy constructor — doosra Student object leta hai
    Student(Student other) {
        this.name = other.name;
        this.marks = other.marks;
    }

    void display() {
        System.out.println(name + " | Marks: " + marks);
    }
}

Student s1 = new Student("Ashish", 90);
Student s2 = new Student(s1);  // copy constructor

s2.name = "Rahul";             // s2 ka naam change karo

s1.display();  // Ashish | Marks: 90  — s1 unchanged
s2.display();  // Rahul  | Marks: 90
```

---

## Shallow Copy vs Deep Copy

Yahan pe tricky part hai. Primitive fields (`int`, `double`) copy hoti hain properly. But object fields (jaise `Address`) mein sirf **reference copy** hoti hai — dono objects ek hi cheez point karte hain.

**Shallow Copy — Problem:**

```java
class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}

class Student {
    String name;
    Address address;   // object field

    Student(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    // Shallow copy constructor
    Student(Student other) {
        this.name = other.name;
        this.address = other.address;  // same Address object ka reference copy
    }
}

Address addr = new Address("Delhi");
Student s1 = new Student("Ashish", addr);
Student s2 = new Student(s1);  // shallow copy

s2.address.city = "Mumbai";    // s2 ka city change kiya

System.out.println(s1.address.city);  // Mumbai — s1 bhi badal gaya! BUG!
System.out.println(s2.address.city);  // Mumbai
```

**Deep Copy — Fix:**

```java
// Deep copy constructor — naya Address object banao
Student(Student other) {
    this.name = other.name;
    this.address = new Address(other.address.city);  // naya object!
}

s2.address.city = "Mumbai";

System.out.println(s1.address.city);  // Delhi — s1 safe hai
System.out.println(s2.address.city);  // Mumbai
```

**Simple Rule:**
- Shallow copy = references copy hote hain (same object dono point karte hain)
- Deep copy = naye objects banate hain (completely independent copies)

---

## Object as Parameter

Java mein object pass karte waqt **reference ki copy** jaati hai — original object ke fields change ho sakte hain.

```java
class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

static void addBonus(Student s, int bonus) {
    s.marks += bonus;  // original object ke marks change ho jaate hain
}

Student s1 = new Student("Ashish", 80);
addBonus(s1, 10);
System.out.println(s1.marks);  // 90 — original change hua
```

---

## Object as Return Type

Method ek naya object return kar sakti hai — original ko touch kiye bina.

```java
static Student withBonus(Student original, int bonus) {
    // original ko mat chhuo — naya object banao
    Student updated = new Student(original.name, original.marks + bonus);
    return updated;
}

Student s1 = new Student("Ashish", 80);
Student s2 = withBonus(s1, 10);

System.out.println(s1.marks);  // 80 — unchanged
System.out.println(s2.marks);  // 90 — new object
```

---

## Java Pass-by-Value — The Real Story

**Java mein hamesha pass-by-value hota hai** — lekin object ke case mein *reference ki value* pass hoti hai.

```java
// Primitive — seedha value copy
static void changeInt(int x) {
    x = 100;  // sirf local copy change hoti hai
}

int a = 5;
changeInt(a);
System.out.println(a);  // 5 — unchanged

// Object — reference ki copy pass hoti hai
static void changeName(Student s) {
    s.name = "Rahul";  // original object ka field change hota hai
}

static void replaceObject(Student s) {
    s = new Student("New", 0);  // sirf local reference change hota hai
}

Student st = new Student("Ashish", 90);
changeName(st);
System.out.println(st.name);  // Rahul — field change hua

replaceObject(st);
System.out.println(st.name);  // Rahul — object replace nahi hua!
```

**Interview ke liye yaad karo:**
> "Java always pass-by-value hai. Primitive ke liye value copy hoti hai. Object ke liye reference ki copy hoti hai — isliye fields change ho sakte hain, lekin original reference replace nahi hoti."

---

## Interview Questions & Answers

---

### Q1. Java mein pass-by-value hai ya pass-by-reference?

**Answer:**

Hamesha **pass-by-value**. Lekin object pass karte waqt reference ki value copy hoti hai. Isliye:
- Object ke **fields** change ho sakte hain method ke andar
- Original **reference** replace nahi hoti (method ke andar `s = new Student()` bahar affect nahi karta)

C++ mein actual pass-by-reference hoti hai — Java mein nahi.

---

### Q2. Copy constructor kya hota hai? Java mein default kyun nahi hota?

**Answer:**

Copy constructor = ek existing object ko parameter mein lekar uski copy banane wala constructor.

Java mein default copy constructor nahi hota kyunki Java ko nahi pata shallow copy chahiye ya deep copy — ye decision developer ka hai. C++ mein default shallow copy constructor hota hai.

```java
Student(Student other) {
    this.name = other.name;   // developer decide karta hai kya copy karna hai
    this.marks = other.marks;
}
```

---

### Q3. Shallow copy aur Deep copy mein kya farak hai?

**Answer:**

| | Shallow Copy | Deep Copy |
|--|--------------|-----------|
| Primitive fields | Properly copy hote hain | Properly copy hote hain |
| Object fields | Same reference copy hoti hai | Naya object banta hai |
| Independence | Dono share karte hain | Completely independent |
| Risk | Ek mein change dono mein dikhta hai | Safe |

Jab class mein object fields hoon (jaise `Address`, `int[]`) toh deep copy zaroori hai.

---

### Q4. `swapStudents(Student a, Student b)` Java mein kyun kaam nahi karta?

**Answer:**

Pass-by-value ki wajah se. Method ko reference ki copy milti hai — method ke andar references swap karne se bahar koi effect nahi hota.

```java
static void swapStudents(Student a, Student b) {
    Student temp = a;
    a = b;
    b = temp;
    // sirf local references swap hue — original variables pe koi effect nahi
}

Student s1 = new Student("Ashish", 90);
Student s2 = new Student("Rahul", 75);
swapStudents(s1, s2);
System.out.println(s1.name);  // Ashish — swap nahi hua!
```

Workaround: fields swap karo, references nahi.

```java
static void swapFields(Student a, Student b) {
    String tempName = a.name;
    int tempMarks = a.marks;
    a.name = b.name;
    a.marks = b.marks;
    b.name = tempName;
    b.marks = tempMarks;
}
```

---

## Practice Problems

**Problem 1 — Address + Student Deep Copy**

`Address` class banao — `String city`, `String state` fields.
`Student` class banao — `String name`, `int marks`, `Address address` fields.

- Normal constructor dono mein
- `Student` mein **deep copy constructor** likho
- Main mein: `s1` banao Delhi address ke saath, `s2 = copy of s1`, `s2.address.city = "Mumbai"` karo
- Verify: `s1.address.city` abhi bhi "Delhi" hai

---

**Problem 2 — Marks Boost (Object as Return)**

`Student` class — `name`, `marks` fields, normal constructor.

Method `boostedStudent(Student s, int percent)` likho:
- Original student ko touch mat karo
- Marks mein `percent`% badhake **naya Student object** return karo
- Main mein: original aur boosted dono display karo, verify karo original unchanged hai

---

**Problem 3 — Swap Challenge**

`Student` class — `name`, `marks` fields.

Pehle ye karo aur observe karo:
```java
static void badSwap(Student a, Student b) {
    Student temp = a;
    a = b;
    b = temp;
}
```
- Kya swap hua? Kyun nahi hua? Comment mein explain karo.

Phir `goodSwap(Student a, Student b)` likho jo **fields swap** kare — ye kaam karega. Verify karo.

---

## Quick Revision — One-liners

- Copy constructor = existing object ko parameter mein lekar copy banana
- Java mein default copy constructor nahi hota — khud likhna padta hai
- Shallow copy = object fields ke references copy hote hain (risky)
- Deep copy = object fields ke liye naye objects bante hain (safe)
- Java = always pass-by-value; objects mein reference ki value pass hoti hai
- Object fields change ho sakte hain method ke andar — replace nahi hota original reference
- Swap references bahar effect nahi karta — fields swap karo references nahi
