# Day 8 — Access Modifiers
**Topic:** Kaun kya dekh sakta hai — `private`, `default`, `protected`, `public`.
**Date:** 17 May 2026

---

## Core Concept

**Access Modifier** = decide karta hai ki ek field/method/class kahan se accessible hai.

Encapsulation ka foundation yahi hai — sahi cheez ko sahi jagah se hi access milni chahiye.

---

## 4 Access Modifiers

| Modifier | Same Class | Same Package | Subclass (alag package) | Anywhere |
|----------|:----------:|:------------:|:-----------------------:|:--------:|
| `private` | YES | NO | NO | NO |
| `default` (koi keyword nahi) | YES | YES | NO | NO |
| `protected` | YES | YES | YES | NO |
| `public` | YES | YES | YES | YES |

---

## `private` — Sabse Strict

Sirf us class ke andar accessible. Bahar se koi direct access nahi.

```java
class BankAccount {
    private double balance;      // sirf BankAccount class ke andar
    private String accountNo;

    public double getBalance() {
        return balance;          // class ke andar — OK
    }
}

BankAccount acc = new BankAccount();
// acc.balance = 5000;   // COMPILE ERROR — private hai
acc.getBalance();        // OK — public method se access
```

**Kab use karein:** Fields hamesha private rakho — encapsulation ka basic rule.

---

## `default` — Package-Private

Koi keyword nahi likhte toh default hota hai. Sirf same package mein accessible.

```java
class Helper {
    int value = 10;        // default — same package mein accessible
    void show() { }        // default method
}

// Same package mein:
Helper h = new Helper();
h.value = 20;    // OK — same package

// Alag package mein:
// h.value = 20;  // COMPILE ERROR
```

**Kab use karein:** Package-internal utility classes/methods — bahar expose nahi karna.

---

## `protected` — Family Access

Same package + subclasses (chahe alag package mein hoon).

```java
class Animal {
    protected String name;         // subclasses access kar sakti hain
    protected void breathe() {
        System.out.println(name + " is breathing");
    }
}

class Dog extends Animal {
    void display() {
        System.out.println(name);  // OK — subclass hai, protected access milta hai
        breathe();                 // OK
    }
}
```

**Kab use karein:** Jab parent class kuch cheez sirf child classes ke liye expose karna chahti ho.

---

## `public` — Sabke Liye Open

Kahi se bhi accessible — same class, same package, subclass, alag package.

```java
public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}

// Kisi bhi class se, kisi bhi package se:
Calculator c = new Calculator();
c.add(5, 3);   // OK — public hai
```

**Kab use karein:** APIs, getters/setters, aur wo methods jo bahar se use honi chahiye.

---

## Real Example — BankAccount

```java
class BankAccount {
    private String owner;        // sirf is class mein
    private double balance;      // sirf is class mein
    private String accountNo;    // sirf is class mein

    public BankAccount(String owner, String accountNo, double initialBalance) {
        this.owner = owner;
        this.accountNo = accountNo;
        this.balance = initialBalance;
    }

    // Public getters — controlled read access
    public String getOwner()     { return owner; }
    public double getBalance()   { return balance; }
    public String getAccountNo() { return accountNo; }

    // Public methods — controlled operations
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount + " | New balance: " + balance);
        } else {
            System.out.println("Invalid amount!");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + " | New balance: " + balance);
            return true;
        }
        System.out.println("Withdrawal failed!");
        return false;
    }

    public void display() {
        System.out.println("Account: " + accountNo + " | Owner: " + owner + " | Balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount acc = new BankAccount("Ashish", "SBI001", 10000);

        acc.display();
        acc.deposit(5000);
        acc.withdraw(3000);
        acc.withdraw(20000);   // fail karega

        // acc.balance = 99999;  // COMPILE ERROR — private
        System.out.println(acc.getBalance());  // OK — public getter
    }
}
```

---

## Access Modifier + Class

Class pe bhi modifier lagta hai:

```java
public class MainApp { }      // kisi bhi package se use ho sakti hai
class HelperUtil { }           // sirf same package mein accessible (default)
```

**Rule:** Ek `.java` file mein sirf ek `public` class ho sakti hai — aur uska naam file ke naam se match karna chahiye.

---

## Common Mistakes

**Mistake 1 — Field public rakhna:**
```java
class Student {
    public int marks;   // galat — koi bhi invalid value set kar sakta hai
}
student.marks = -500;   // valid ho jaata hai — koi rokne wala nahi
```

**Mistake 2 — Getter ke saath setter bhi dena jab zaroorat nahi:**
```java
class Circle {
    private double radius;
    // area derived hai — setter banana galat hoga
    public double getArea() { return Math.PI * radius * radius; }
    // public void setArea() — ye banana hi nahi chahiye
}
```

**Mistake 3 — `protected` ko `public` samajhna:**
`protected` alag package ki random class se accessible nahi hota — sirf subclass se.

---

## Interview Questions & Answers

---

### Q1. 4 access modifiers kaunse hain? Strictest se loosest order mein bolo.

**Answer:**

`private` → `default` → `protected` → `public`

- `private`: sirf same class
- `default`: same package
- `protected`: same package + subclasses
- `public`: everywhere

---

### Q2. Fields private kyun rakhte hain?

**Answer:**

Public field mein koi validation possible nahi — koi bhi koi bhi value set kar sakta hai.

```java
student.marks = -500;   // public field — koi rok nahi
```

Private field + setter se validation possible hai:
```java
public void setMarks(int marks) {
    if (marks >= 0 && marks <= 100) this.marks = marks;
}
```

Aur future mein logic change karna ho toh sirf setter change karo — baaki code affect nahi hota.

---

### Q3. `default` aur `protected` mein kya farak hai?

**Answer:**

`default` = sirf same package — subclass bhi alag package mein ho toh access nahi milti.
`protected` = same package + subclasses chahe kisi bhi package mein hoon.

```java
// Parent package: com.animals
class Animal {
    protected String name;   // subclasses access kar sakti hain
    String sound;            // default — sirf com.animals package
}

// Child package: com.pets
class Dog extends Animal {
    void show() {
        System.out.println(name);   // OK — protected
        // System.out.println(sound); // ERROR — default, alag package
    }
}
```

---

### Q4. Kya constructor private ho sakta hai?

**Answer:**

Haan. Private constructor ka matlab — bahar se `new` karke object nahi bana sakte.

**Use case: Singleton pattern**
```java
class Config {
    private static Config instance;

    private Config() { }   // bahar se new nahi ho sakta

    public static Config getInstance() {
        if (instance == null) instance = new Config();
        return instance;
    }
}
```

---

### Q5. `public` class aur `default` class mein kya farak hai?

**Answer:**

`public class` = kisi bhi package se import aur use ho sakti hai.
`default class` = sirf same package mein accessible, bahar import nahi ho sakti.

Ek `.java` file mein sirf ek `public` class allowed hai — uska naam file ke naam se same hona chahiye.

---

## Practice Problems

**Problem 1 — BankAccount**

`BankAccount` class banao — `private` fields: `owner` (String), `balance` (double), `accountNo` (String).
- Parameterized constructor
- Public getters sirf `owner` aur `balance` ke liye (`accountNo` ka getter mat banana — security)
- `deposit(double amount)` — negative amount block karo
- `withdraw(double amount)` — negative aur insufficient balance dono block karo, `boolean` return karo
- `display()` — owner aur balance print karo, accountNo mat dikhao
- Main mein: valid deposit, valid withdrawal, invalid withdrawal (insufficient), invalid deposit (negative) try karo

---

**Problem 2 — Student with Validation**

`Student` class banao — `private` fields: `name` (String), `rollNo` (int), `marks` (int).
- Parameterized constructor with validation:
  - `marks` 0-100 ke beech hona chahiye, warna 0 set karo
  - `name` null ya empty nahi hona chahiye, warna "Unknown" set karo
- Getters: `getName()`, `getRollNo()`, `getMarks()`
- Setters: `setMarks(int)` with same validation, `setName(String)` with same validation
- `display()` method
- Main mein: valid student, invalid marks (150), invalid name ("") try karo

---

**Problem 3 — Access Error dekho**

Yeh class likho:

```java
class Secret {
    private int pin = 1234;
    private String code = "XYZ";

    public void showHint() {
        System.out.println("Pin has " + String.valueOf(pin).length() + " digits");
    }
}
```

- Main mein `Secret s = new Secret()` banao
- `s.pin` directly access karne ki koshish karo — compile error note karo
- `s.code` directly change karne ki koshish karo — compile error note karo
- `s.showHint()` call karo — ye kaam karega
- Comment mein likho: error message kya aaya aur kyun

---

## Quick Revision — One-liners

- `private` = sirf same class — encapsulation ka base
- `default` = same package — koi keyword nahi likhte
- `protected` = same package + subclasses (chahe alag package)
- `public` = everywhere
- Fields hamesha `private` — access sirf getters/setters se
- Private constructor = bahar se object nahi ban sakta (Singleton)
- Ek `.java` file mein ek hi `public` class — naam file ke naam se match kare
- `protected` ne `default` se zyada access hai — subclass ko bhi milti hai
