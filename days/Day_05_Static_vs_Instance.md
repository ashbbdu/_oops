# Day 5 — Static vs Instance
**Topic:** Class-level vs Object-level — Variables aur Methods ka farak.
**Date:** 17 May 2026

---

## Core Concept

**Instance variable/method** — Har object ka apna alag copy hota hai.
**Static variable/method** — Ek hi copy, saare objects share karte hain. Class ke naam se access hoti hai.

Analogy:
- Instance variable = Har student ka apna roll number (alag-alag)
- Static variable = School ka naam (sab ke liye same)

---

## Instance Variables

Har object bante waqt apna alag copy banta hai — ek object ki value doosre ko affect nahi karti.

```java
class Student {
    String name;   // instance variable — har student ka apna naam
    int marks;     // instance variable — har student ke apne marks

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }
}

Student s1 = new Student("Ashish", 90);
Student s2 = new Student("Rahul", 75);

// s1 aur s2 ke paas alag-alag name aur marks hain
System.out.println(s1.name);  // Ashish
System.out.println(s2.name);  // Rahul
```

---

## Static Variables

Class level pe ek hi copy hoti hai. Koi bhi object se access karo, value same hi rahegi.

```java
class Counter {
    static int count = 0;  // static — shared across all objects
    int id;                // instance — har object ka apna

    Counter() {
        count++;       // shared counter badhao
        id = count;    // is object ka id set karo
    }
}

Counter c1 = new Counter();
Counter c2 = new Counter();
Counter c3 = new Counter();

System.out.println(Counter.count);  // 3 — class ke naam se access
System.out.println(c1.id);          // 1
System.out.println(c2.id);          // 2
System.out.println(c3.id);          // 3
```

**Access kaise karein:**
- Static variable: `ClassName.variable` (recommended) ya `object.variable` (avoid)
- Instance variable: `object.variable`

---

## Static Methods

Object banaye bina call ho sakti hain — `ClassName.method()` se.

```java
class MathHelper {
    // Static method — object ki zaroorat nahi
    static int square(int n) {
        return n * n;
    }

    static boolean isEven(int n) {
        return n % 2 == 0;
    }
}

// Object banaye bina call karo
int result = MathHelper.square(5);    // 25
boolean check = MathHelper.isEven(4); // true
```

**Java mein already dekha hai:** `Math.sqrt()`, `Math.abs()`, `Arrays.sort()` — sab static methods hain.

---

## `this` keyword Static Method mein kyun nahi hota?

`this` = current object ka reference. Static method kisi object se connected nahi hota — object exist hi nahi karta jab static method call hoti hai.

```java
class Example {
    int x = 10;          // instance variable
    static int y = 20;   // static variable

    void instanceMethod() {
        System.out.println(this.x); // OK — object hai, this works
        System.out.println(y);      // OK — static variable access
    }

    static void staticMethod() {
        // System.out.println(this.x); // ERROR — 'this' cannot be used in static
        System.out.println(y);          // OK — static variable access
        // System.out.println(x);       // ERROR — instance variable nahi access ho sakti
    }
}
```

**Rule yaad karo:**
- Static method → static variables aur static methods access kar sakti hai
- Static method → instance variables/methods access NAHI kar sakti (bina object ke)
- Instance method → dono access kar sakti hai

---

## Static Block

Class load hote waqt ek baar run hota hai — static variables initialize karne ke liye.

```java
class Config {
    static String appName;
    static int maxUsers;

    static {
        // Ye block class ke load hone par ek baar chalega
        appName = "MyApp";
        maxUsers = 100;
        System.out.println("Config loaded!");
    }
}
```

---

## Instance vs Static — Side by Side

```java
class BankAccount {
    // Static — sabhi accounts ka total
    static int totalAccounts = 0;
    static double totalDeposits = 0;

    // Instance — har account ka apna data
    String owner;
    double balance;

    BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
        totalAccounts++;              // class level counter
        totalDeposits += initialBalance;
    }

    // Instance method — specific account pe kaam karta hai
    void deposit(double amount) {
        balance += amount;
        totalDeposits += amount;
    }

    // Static method — class level info
    static void showStats() {
        System.out.println("Total accounts: " + totalAccounts);
        System.out.println("Total deposits: " + totalDeposits);
    }

    void display() {
        System.out.println(owner + " | Balance: " + balance);
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("Ashish", 5000);
        BankAccount a2 = new BankAccount("Rahul", 3000);

        a1.deposit(1000);

        a1.display();               // Ashish | Balance: 6000.0
        a2.display();               // Rahul  | Balance: 3000.0
        BankAccount.showStats();    // Total accounts: 2 | Total deposits: 9000.0
    }
}
```

---

## Interview Questions & Answers

---

### Q1. Static aur Instance variable mein kya farak hai?

**Answer:**

| | Instance Variable | Static Variable |
|--|-------------------|-----------------|
| Memory | Har object ka apna copy | Ek hi copy, class level pe |
| Access | `object.variable` | `ClassName.variable` |
| Lifecycle | Object ke saath banta/khathm | Class load hone se program khatam tak |
| `this` se | Access hoti hai | Access nahi hoti (static context) |

Example: Student class — name instance hai (har student ka apna), schoolName static hai (sab ka ek).

---

### Q2. Static method mein `this` kyun nahi hota?

**Answer:**

`this` = current object ka reference. Static method object se linked nahi hoti — call karte waqt koi specific object exist nahi karta (`ClassName.method()` se call hoti hai). Toh `this` ka koi matlab nahi hoga. Isliye Java allow nahi karta.

```java
class Foo {
    int x;
    static void bar() {
        // this.x  // ERROR — kaunsa object ka x?
    }
}
```

---

### Q3. `main()` method static kyun hoti hai?

**Answer:**

JVM ko program start karte waqt `main()` call karni hoti hai — lekin tab tak koi bhi object nahi bana hota. Static hone ki wajah se JVM bina object banaye `main()` call kar sakta hai.

---

### Q4. Static method instance method ko call kar sakti hai?

**Answer:**

Nahi — seedha nahi. Pehle object banana padega, phir us object se call karo.

```java
class Example {
    void instanceMethod() { System.out.println("instance"); }

    static void staticMethod() {
        // instanceMethod();          // ERROR
        Example e = new Example();
        e.instanceMethod();          // OK — object banake call karo
    }
}
```

---

### Q5. Static variable kab use karein?

**Answer:**

Jab value **sabhi objects ke liye same** ho ya **shared state** rakhna ho:
- Counter (kitne objects bane)
- Constants (`static final PI = 3.14159`)
- Singleton pattern (ek hi instance)
- Shared configuration

---

## Full Example — All Concepts Together

```java
class Employee {
    // Static — class level
    static int totalEmployees = 0;
    static final String COMPANY = "TechCorp";  // constant

    // Instance — object level
    int empId;
    String name;
    double salary;

    Employee(String name, double salary) {
        totalEmployees++;
        this.empId = totalEmployees;
        this.name = name;
        this.salary = salary;
    }

    // Instance method
    void giveRaise(double percent) {
        salary += salary * percent / 100;
        System.out.println(name + " ki salary: " + salary);
    }

    // Static method
    static void showCompanyInfo() {
        System.out.println("Company: " + COMPANY);
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Static utility method
    static double annualSalary(double monthly) {
        return monthly * 12;
    }

    void display() {
        System.out.println("ID:" + empId + " | " + name + " | " + salary);
    }
}

public class Main {
    public static void main(String[] args) {
        Employee e1 = new Employee("Ashish", 50000);
        Employee e2 = new Employee("Priya", 60000);
        Employee e3 = new Employee("Rahul", 45000);

        e1.display();  // ID:1 | Ashish | 50000.0
        e2.display();  // ID:2 | Priya  | 60000.0
        e3.display();  // ID:3 | Rahul  | 45000.0

        e1.giveRaise(10);  // 55000.0

        Employee.showCompanyInfo();
        // Company: TechCorp
        // Total Employees: 3

        System.out.println("Annual: " + Employee.annualSalary(50000));  // 600000.0
    }
}
```

---

## Practice Problems

**Problem 1 — BankAccount class**
`BankAccount` class banao — `private static int totalAccounts`, `private double balance`.
- Har naya account bante waqt `totalAccounts` badhao
- `static int getTotalAccounts()` method
- `deposit()`, `withdraw()`, `getBalance()` instance methods
- Main mein 3 accounts banao, kuch transactions karo, `getTotalAccounts()` print karo

---

**Problem 2 — MathHelper class**
`MathHelper` class banao — sirf static methods:
- `factorial(int n)` — n! return karo
- `isPrime(int n)` — true/false
- `fibonacci(int n)` — nth fibonacci number

Koi instance variable nahi, koi constructor nahi — pure utility class.

---

**Problem 3 — AppConfig (Singleton preview)**
`AppConfig` class banao jisme sirf ek hi object ban sake:
- `private static AppConfig instance`
- `private` constructor (bahar se `new` nahi kar sakte)
- `static AppConfig getInstance()` — agar instance null hai toh banao, warna existing return karo
- `String appName`, `int maxRetries` — getter/setter
- Main mein `getInstance()` do baar call karo — same object milta hai (`==` se verify karo)

---

## Quick Revision — One-liners

- Instance variable = har object ka apna copy, `object.var` se access
- Static variable = ek hi copy sab ke liye, `ClassName.var` se access
- Static method = object ke bina call ho sakti hai, `ClassName.method()`
- Static method mein `this` nahi — koi specific object nahi hota
- Static method → sirf static cheezein access kar sakti hai directly
- Instance method → static aur instance dono access kar sakti hai
- `main()` static hai kyunki JVM bina object ke call karta hai
- Constants: `static final` — ek baar set, kabhi change nahi
- Static block — class load hote waqt ek baar chalta hai
