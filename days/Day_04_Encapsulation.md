# Day 4 — Encapsulation
**Topic:** Data hide karna, controlled access dena — OOP ka pehla pillar.
**Date:** 13 May 2026

---

## Core Concept

**Encapsulation** = Fields ko `private` karo + methods ke through controlled access do.

Analogy: ATM machine — balance directly nahi dekh sakte, sirf `checkBalance()` button se.

**2 Steps:**
1. Fields ko `private` banao — direct access band
2. Public getters/setters banao — controlled access do

```java
class Person {
    private String name;   // direct access band
    private int age;

    // Getter — value padhna
    public String getName() {
        return name;
    }

    // Setter — value set karna
    public void setName(String name) {
        this.name = name;
    }
}

Person p = new Person();
// p.name = "Ashish";  // ERROR — private hai
p.setName("Ashish");   // OK — setter se
System.out.println(p.getName()); // OK — getter se
```

---

## Access Modifiers

| Modifier | Same Class | Same Package | Subclass | Anywhere |
|----------|-----------|--------------|----------|----------|
| `private` | YES | NO | NO | NO |
| `default` (no keyword) | YES | YES | NO | NO |
| `protected` | YES | YES | YES | NO |
| `public` | YES | YES | YES | YES |

```java
class Example {
    private int a = 1;    // sirf is class ke andar
    int b = 2;            // same package mein
    protected int c = 3;  // same package + subclasses
    public int d = 4;     // sab jagah
}
```

---

## Getters aur Setters

**Getter** — field ki value return karta hai:
```java
public String getName() {
    return name;
}
```

**Setter** — field ki value set karta hai (validation bhi kar sakte ho):
```java
public void setAge(int age) {
    if (age >= 0) {
        this.age = age;      // this = current object ka reference
    } else {
        System.out.println("Age cannot be negative!");
    }
}
```

**Naming Convention (JavaBeans):**
- Getter: `getFieldName()` — boolean ke liye `isFieldName()`
- Setter: `setFieldName(value)`

---

## `this` keyword in Setters

Setter mein parameter aur field ka naam same hota hai — `this.field` se field access karo:

```java
class Student {
    private String name;

    public void setName(String name) {
        this.name = name;  // this.name = field, name = parameter
    }
}
```

---

## Why Encapsulation?

```java
// Bina Encapsulation — koi bhi kuch bhi kar sakta hai
class BankAccount {
    int balance = 1000;
}
BankAccount acc = new BankAccount();
acc.balance = -99999;  // valid! Koi rok nahi

// Encapsulation ke saath — validation possible
class BankAccount {
    private double balance;

    public void deposit(double amount) {
        if (amount > 0) balance += amount;  // negative deposit block
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;  // insufficient balance block
    }
}
```

---

## Interview Questions & Answers

---

### Q1. Encapsulation kya hai? Real-world example do.

**Answer:**

Encapsulation = data (fields) aur behaviour (methods) ko ek class mein band karna, aur fields ko `private` karke sirf methods ke through access dena.

Real-world: Capsule (medicine) — andar ka content direct nahi chhoo sakte, sirf capsule ke through body mein jaata hai.

Java mein: private fields + public getters/setters.

---

### Q2. Getter/Setter ki jagah field public kyun nahi kar dete?

**Answer:**

Public field mein koi validation nahi hoti — koi bhi koi bhi value set kar sakta hai.

```java
// Public field — koi control nahi
student.age = -100;  // valid ho jaata hai, wrong!

// Setter mein validation
public void setAge(int age) {
    if (age > 0 && age < 150) this.age = age;
    // invalid value silently ignore ya error
}
```

Setter se: validation, logging, future changes — sab possible.

---

### Q3. Encapsulation aur Abstraction mein kya difference hai?

**Answer:**

| | Encapsulation | Abstraction |
|--|---------------|-------------|
| Kya karta hai | Data hide karta hai | Complexity hide karta hai |
| Kaise | private fields + getters/setters | Abstract class / Interface |
| Focus | "Kaise store karna hai" hide karo | "Kaise kaam karta hai" hide karo |

Encapsulation: ATM ka balance private hai — kaise store hota hai pata nahi.
Abstraction: ATM ka button press karo — andar kya hota hai pata nahi.

---

### Q4. Kya sirf getter ho sakta hai bina setter ke?

**Answer:**

Haan — **read-only field** banana ke liye sirf getter likho, setter mat likho.

```java
class Circle {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() { return radius; }    // getter
    // koi setter nahi — radius change nahi ho sakta

    public double getArea() {                        // derived value
        return Math.PI * radius * radius;
    }
}
```

`getArea()` ke liye setter nahi banate — ye derived value hai, directly set nahi hoti.

---

## Full Example — All Concepts Together

```java
class BankAccount {
    private String owner;
    private double balance;

    BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    public String getOwner() { return owner; }
    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            return true;
        }
        System.out.println("Invalid withdrawal!");
        return false;
    }

    public void display() {
        System.out.println(owner + " | Balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Ashish", 1000);
        acc.display();

        acc.deposit(500);
        acc.withdraw(200);
        acc.withdraw(5000);  // Invalid withdrawal!

        System.out.println("Final: " + acc.getBalance()); // 1300.0
    }
}
```

---

## Practice Problems

**Problem 1 — Person class**
`Person` class banao — private fields: `name` (String), `age` (int).
- Getters aur setters dono
- `setAge()` mein validation: age < 0 allow mat karo
- `display()` method
- Main mein valid aur invalid age dono try karo

---

**Problem 2 — BankAccount class**
`BankAccount` class banao — private fields: `owner` (String), `balance` (double).
- Parameterized constructor
- `getOwner()`, `getBalance()` — sirf getters (owner/balance directly set nahi hoga)
- `deposit(double amount)` — negative amount block karo
- `withdraw(double amount)` — negative aur insufficient balance dono block karo
- `display()` method

---

**Problem 3 — Student class**
`Student` class banao — private fields: `name` (String), `grade` (int).
- Getters aur setters
- `setGrade()` mein validation: sirf 0–100 allow karo
- `display()` method
- Main mein valid (85) aur invalid (150, -10) grades try karo

---

## Quick Revision — One-liners

- Encapsulation = private fields + public getters/setters
- `private` = sirf same class ke andar accessible
- Getter = value return karta hai, setter = value set karta hai (with validation)
- `this.field` = current object ka field (setter mein name conflict solve karta hai)
- Sirf getter = read-only field
- Setter mein validation = invalid data block karna
- `public` > `protected` > `default` > `private` — access order
