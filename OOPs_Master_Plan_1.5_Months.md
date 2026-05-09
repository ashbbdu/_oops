# OOPs in Java — 1.5 Month Placement Prep Master Plan
**Duration:** 45 Days | **Daily Time:** 1 Hour | **Goal:** Placement / Interview Prep

---

## Ashish ke liye Special Tips (Pehle Padho!)

1. **Roz code likho** — sirf padhna kaam nahi karega. Minimum 20 mins coding har din.
2. **"Why" samjho, "What" nahi** — interview me concept ka reason puchha jaata hai.
3. **Ek concept ache se, 10 concepts adhe se better hai** — rush mat karo.
4. **Week 6 ke baad mock interviews do** — Leetcode, GFG, InterviewBit pe.
5. **Revision key hai** — har Sunday purey week ka revision karo, 15 mins.

---

## PHASE 1 — Foundation (Week 1–2) : Classes, Objects & Constructors

### Week 1: Class aur Object ki Duniya

#### Day 1 — Class aur Object kya hota hai?
**Concept:**
- Class = Blueprint (design), Object = Real cheez us blueprint se bani
- Analogy: Class = Car ka design, Object = Actual Maruti Swift, Honda City
- Class ke andar: **fields** (data) + **methods** (behaviour)

```java
class Car {
    String brand;   // field
    int speed;      // field

    void accelerate() {   // method
        System.out.println(brand + " is accelerating!");
    }
}

public class Main {
    public static void main(String[] args) {
        Car c1 = new Car();   // object creation
        c1.brand = "Honda";
        c1.speed = 100;
        c1.accelerate();
    }
}
```

**Practice Problems:**
1. `Student` class banao — name, rollNo, marks fields rakho. 3 students ke objects banao aur unki details print karo.
2. `BankAccount` class banao — accountHolder, balance fields. `showBalance()` method likho.
3. `Rectangle` class banao — length, width. `area()` aur `perimeter()` methods likho.

**Interview Question:** "Class aur Object me kya difference hai?"

---

#### Day 2 — Methods aur `new` keyword deep dive
**Concept:**
- `new` keyword heap pe memory allocate karta hai
- Method = class ke andar defined function
- Return type, parameters samjho

```java
class Calculator {
    int add(int a, int b) {
        return a + b;
    }

    double divide(double a, double b) {
        if (b == 0) return 0;
        return a / b;
    }
}
```

**Practice Problems:**
1. `Circle` class — radius field, `area()` aur `circumference()` methods (Math.PI use karo).
2. `Temperature` class — `celsiusToFahrenheit(double c)` aur `fahrenheitToCelsius(double f)` methods.
3. `StringUtils` class — `reverse(String s)`, `isPalindrome(String s)`, `countVowels(String s)` methods.

---

#### Day 3 — Constructors (Default + Parameterized)
**Concept:**
- Constructor = Object banate waqt automatically call hone wala special method
- Default constructor: koi parameter nahi
- Parameterized constructor: values deke object banao
- Constructor ka naam class ke naam jaisa hota hai, return type nahi hota

```java
class Student {
    String name;
    int age;

    // Default constructor
    Student() {
        name = "Unknown";
        age = 0;
    }

    // Parameterized constructor
    Student(String n, int a) {
        name = n;
        age = a;
    }

    void display() {
        System.out.println(name + " - " + age);
    }
}

Student s1 = new Student();           // default
Student s2 = new Student("Ashish", 20); // parameterized
```

**Practice Problems:**
1. `Book` class — title, author, price. Default aur parameterized dono constructors banao.
2. `Employee` class — empId, name, salary. Parameterized constructor se 3 employees banao, display karo.
3. `Point` class — x, y coordinates. Constructor se point banao, `distanceFromOrigin()` method likho.

**Interview Question:** "Constructor aur Method me kya difference hai?"

---

#### Day 4 — Constructor Overloading + `this` keyword
**Concept:**
- Constructor Overloading = same class me multiple constructors, different parameters
- `this` = current object ka reference
- `this()` = ek constructor se doosra constructor call karna

```java
class Box {
    double length, width, height;

    Box() {
        this(1, 1, 1); // calls 3-param constructor
    }

    Box(double side) {
        this(side, side, side);
    }

    Box(double l, double w, double h) {
        this.length = l;
        this.width = w;
        this.height = h;
    }

    double volume() {
        return length * width * height;
    }
}
```

**Practice Problems:**
1. `Cylinder` class — radius, height. 3 constructors: no-arg (default 1,1), one-arg (radius only), two-arg.
2. `Person` class — name, age, city. `this` keyword use karo har field assign karne ke liye.
3. Upar wale Box class ko extend karo — `surfaceArea()` method add karo.

**Interview Question:** "`this` keyword ke kya uses hain?" (3 uses: field vs param conflict, constructor chaining, return current object)

---

#### Day 5 — Static vs Instance (Variables + Methods)
**Concept:**
- **Instance variable:** Har object ka apna copy hota hai
- **Static variable:** Sabhi objects share karte hain, class level pe hota hai
- **Static method:** Object ke bina call ho sakta hai, `ClassName.method()`
- Static method me `this` nahi hota

```java
class Counter {
    static int count = 0;  // shared across all objects
    int id;                // each object ka apna

    Counter() {
        count++;
        id = count;
    }

    static void showCount() {
        System.out.println("Total objects: " + count);
    }
}

Counter c1 = new Counter();
Counter c2 = new Counter();
Counter.showCount(); // Output: Total objects: 2
```

**Practice Problems:**
1. `BankAccount` class — static `totalAccounts` counter, instance `balance`. Har new account pe counter badhao.
2. `MathHelper` class — sirf static methods: `factorial(n)`, `isPrime(n)`, `fibonacci(n)`.
3. `Singleton` pattern preview: `AppConfig` class jisme sirf ek object ban sake (static variable use karo).

**Interview Question:** "Static aur Instance methods me kya difference hai? Static method me `this` kyu nahi hota?"

---

#### Day 6 — Copy Constructor + Object as Parameter/Return
**Concept:**
- Copy Constructor = ek existing object ki copy bnana
- Java me default copy constructor nahi hota (C++ se alag)
- Shallow copy vs Deep copy ka concept

```java
class Student {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // Copy Constructor
    Student(Student other) {
        this.name = other.name;
        this.marks = other.marks;
    }
}

Student s1 = new Student("Ashish", 90);
Student s2 = new Student(s1); // copy
```

**Practice Problems:**
1. `Address` class banao. `Student` class me Address field rakho — copy constructor likho.
2. Method banao jo `Student` object le aur marks 10% badhake naya `Student` return kare.
3. `swapStudents(Student a, Student b)` — Java me kyu kaam nahi karta? Explain karo (pass by value concept).

**Interview Question:** "Java me pass by value hai ya pass by reference?" (Trick question! Always value, but for objects — reference copy hoti hai)

---

#### Day 7 — Week 1 Revision + Mini Project
**Mini Project: Student Grade System**
```
- Student class: name, rollNo, int[] marks (5 subjects)
- Constructor se initialize karo
- Methods:
  - totalMarks()
  - average()
  - grade() — A/B/C/D/F
  - display() — full report card print karo
- Main me 3 students banao, sab ki report card print karo
- Bonus: topper kaun hai? (static method)
```

**Week 1 Interview Questions Recap:**
1. Class vs Object
2. Constructor vs Method
3. `this` keyword ke uses
4. Static vs Instance
5. Java pass by value or reference?

---

### Week 2: Encapsulation — Data Hiding ki Art

#### Day 8 — Access Modifiers
**Concept:**
| Modifier | Same Class | Same Package | Subclass | Anywhere |
|----------|-----------|--------------|----------|----------|
| `private` | YES | NO | NO | NO |
| `default` | YES | YES | NO | NO |
| `protected` | YES | YES | YES | NO |
| `public` | YES | YES | YES | YES |

```java
class BankAccount {
    private double balance;      // sirf is class me accessible
    private String accountNo;

    public double getBalance() { return balance; }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
```

**Practice Problems:**
1. Upar wala BankAccount implement karo — private fields, public methods.
2. `Student` class — private name, marks. Getters/setters likho with validation (marks 0-100).
3. Ek class banao jisme ek field `private` ho aur direct access karne ki koshish karo — compilation error dekho.

---

#### Day 9 — Getters, Setters aur Encapsulation ka "Why"
**Concept:**
- Encapsulation = Data + Methods ko ek capsule me band karna
- Direct access kyun nahi dete? — Validation, control, security
- JavaBeans convention: `getFieldName()`, `setFieldName(value)`

```java
class Person {
    private String name;
    private int age;

    public String getName() { return name; }

    public void setName(String name) {
        if (name != null && !name.isEmpty())
            this.name = name;
    }

    public int getAge() { return age; }

    public void setAge(int age) {
        if (age > 0 && age < 150)
            this.age = age;
    }
}
```

**Practice Problems:**
1. `Temperature` class — private double celsius. Getter `getCelsius()`, `getFahrenheit()`, `getKelvin()`. Setter me validation (>= -273.15).
2. `Username` class — private String value. Setter me rule: min 6 chars, no spaces, max 20 chars.
3. `Circle` class — private radius. Setter me radius > 0 check. Getters for area, circumference (no setters for derived values — why?)

**Interview Question:** "Encapsulation ke kya fayde hain real world me?"

---

#### Day 10 — `final` keyword
**Concept:**
- `final` variable = constant (value change nahi ho sakti)
- `final` method = override nahi ho sakti
- `final` class = extend nahi ho sakti (e.g., String class)

```java
class Circle {
    final double PI = 3.14159; // constant

    double area(double r) {
        return PI * r * r;
    }
}

final class ImmutablePoint {
    final int x, y;

    ImmutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
```

**Practice Problems:**
1. `MathConstants` class — `PI`, `E`, `GOLDEN_RATIO` as final static fields.
2. `ImmutableStudent` class — final name, rollNo. Sirf getter, koi setter nahi. Kyu useful hai?
3. Final variable assign karna constructor me — `blank final` concept try karo.

---

#### Day 11 — Packages aur Imports
**Concept:**
- Package = folder for organizing classes
- `import` = doosre package ki class use karna
- `java.lang` auto-import hoti hai (String, Math, Integer etc.)

```java
package com.ashish.banking;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount acc) {
        accounts.add(acc);
    }
}
```

**Practice Problems:**
1. `com.ashish.shapes` package banao — Circle, Rectangle, Triangle classes.
2. `com.ashish.main` me Main class — shapes package import karo, objects banao.
3. `java.util.Scanner` use karke user input lo, Student objects banao runtime pe.

---

#### Day 12 — toString(), equals(), hashCode()
**Concept:**
- `toString()` — object ko String me represent karna (print karte waqt auto-call)
- `equals()` — do objects logically equal hain? (`==` reference compare karta hai)
- `hashCode()` — HashMap/HashSet ke liye

```java
class Student {
    String name;
    int rollNo;

    @Override
    public String toString() {
        return "Student{name='" + name + "', rollNo=" + rollNo + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Student)) return false;
        Student s = (Student) obj;
        return rollNo == s.rollNo && name.equals(s.name);
    }
}
```

**Practice Problems:**
1. `Product` class — id, name, price. `toString()`, `equals()` (id pe based) likho.
2. `==` vs `.equals()` difference: String ke saath demonstrate karo.
3. Do Student objects banao same data se — `==` vs `equals()` ka output compare karo.

**Interview Question:** "`==` aur `.equals()` me kya difference hai?"

---

#### Day 13 — Varargs + Method Chaining
**Concept:**
- Varargs = variable number of arguments
- Method Chaining = `object.method1().method2().method3()`

```java
// Varargs
int sum(int... numbers) {
    int total = 0;
    for (int n : numbers) total += n;
    return total;
}
sum(1, 2, 3, 4, 5); // works!

// Method Chaining (Builder pattern preview)
class QueryBuilder {
    private String query = "SELECT ";

    QueryBuilder select(String cols) { query += cols; return this; }
    QueryBuilder from(String table) { query += " FROM " + table; return this; }
    QueryBuilder where(String cond) { query += " WHERE " + cond; return this; }
    String build() { return query; }
}

String q = new QueryBuilder()
    .select("name, age")
    .from("students")
    .where("age > 18")
    .build();
```

**Practice Problems:**
1. `Statistics` class — `average(double... nums)`, `max(int... nums)`, `min(int... nums)` using varargs.
2. `StringBuilder`-style `MyStringBuilder` class — `append()`, `prepend()`, `reverse()` with method chaining.

---

#### Day 14 — Week 2 Revision + Mini Project
**Mini Project: Library Management**
```
- Book class: id, title, author, price (private fields, getters/setters)
- toString() override
- Library class: books ArrayList, addBook(), removeBook(id), findByAuthor(), displayAll()
- Main: 5 books add karo, author se search karo, ek remove karo, display karo
```

---

## PHASE 2 — Core OOPs Pillars (Week 3–4)

### Week 3: Inheritance — "IS-A" Relationship

#### Day 15 — Inheritance Basics + `extends`
**Concept:**
- Inheritance = Child class parent class ki properties/methods inherit karta hai
- `extends` keyword use hota hai
- IS-A relationship: Dog IS-A Animal ✓ | Car IS-A Engine ✗
- Java me single inheritance (ek class sirf ek class extend kar sakti hai)
- Code reuse + hierarchy

```java
class Animal {
    String name;
    int age;

    void eat() {
        System.out.println(name + " is eating");
    }

    void sleep() {
        System.out.println(name + " is sleeping");
    }
}

class Dog extends Animal {
    String breed;

    void bark() {
        System.out.println(name + " says: Woof!");
    }
}

Dog d = new Dog();
d.name = "Bruno";
d.eat();   // inherited from Animal
d.bark();  // Dog ka apna method
```

**Practice Problems:**
1. `Vehicle` → `Car`, `Bike`, `Truck` hierarchy. Vehicle: speed, fuel. Car: numDoors. Bike: hasSidecar. Each has `describe()`.
2. `Shape` → `Circle`, `Rectangle`, `Triangle`. Shape: color. Each shape has `area()` aur `perimeter()`.
3. `Employee` → `Manager`, `Developer`, `Intern`. Common: name, salary. Manager: teamSize. Developer: programmingLanguage. Intern: stipend.

**Interview Question:** "Java me multiple inheritance kyun nahi hoti classes me? (Diamond problem)"

---

#### Day 16 — `super` keyword + Constructor Chaining in Inheritance
**Concept:**
- `super` = parent class ka reference
- `super()` = parent class ka constructor call karna (pehli line honi chahiye)
- `super.method()` = parent class ka method call karna

```java
class Animal {
    String name;

    Animal(String name) {
        this.name = name;
        System.out.println("Animal created: " + name);
    }

    void makeSound() {
        System.out.println("Some sound...");
    }
}

class Dog extends Animal {
    String breed;

    Dog(String name, String breed) {
        super(name); // Animal constructor call
        this.breed = breed;
        System.out.println("Dog created: " + breed);
    }

    @Override
    void makeSound() {
        super.makeSound(); // parent method call
        System.out.println("Woof!");
    }
}
```

**Practice Problems:**
1. `Person` → `Student`. Person: name, age (constructor). Student: rollNo, college. `super()` use karo.
2. `Shape` → `ColoredShape`. Shape: dimensions. ColoredShape: color, borderWidth. Constructor chaining.
3. Upar wala Animal-Dog likho aur constructor call order trace karo (output dekhke samjho).

---

#### Day 17 — Method Overriding + `@Override`
**Concept:**
- Overriding = Child class parent ka same method apne tarike se implement kare
- Same name, same parameters, same return type (or covariant)
- `@Override` annotation — compile-time check
- Private aur static methods override nahi ho sakte

```java
class Shape {
    double area() {
        return 0;
    }

    String describe() {
        return "I am a shape";
    }
}

class Circle extends Shape {
    double radius;

    Circle(double r) { this.radius = r; }

    @Override
    double area() {
        return Math.PI * radius * radius;
    }

    @Override
    String describe() {
        return "I am a circle with radius " + radius;
    }
}
```

**Practice Problems:**
1. `Animal` → `Cat`, `Dog`, `Cow` — sab `makeSound()` override karein.
2. `Employee` → `Manager` — `calculateBonus()` override (Manager ko 20% extra milta hai).
3. Kya `static` method override ho sakta hai? Try karo aur observe karo — method hiding concept.

**Interview Question:** "Overriding aur Overloading me kya difference hai?" (bahut common interview question!)

---

#### Day 18 — Types of Inheritance + Object class
**Concept:**
- **Single:** A → B
- **Multilevel:** A → B → C
- **Hierarchical:** A → B, A → C
- **Multiple:** Java me classes ke liye NOT allowed (Interfaces se hota hai)
- `Object` class = sabhi classes ki parent (toString, equals, hashCode yahan se aate hain)

```java
// Multilevel
class LivingBeing { void breathe() { } }
class Animal extends LivingBeing { void eat() { } }
class Dog extends Animal { void bark() { } }

// Hierarchical
class Shape { double area() { return 0; } }
class Circle extends Shape { }
class Square extends Shape { }
```

**Practice Problems:**
1. Multilevel: `Vehicle` → `Car` → `ElectricCar`. Har level pe ek naya field/method add karo.
2. Hierarchical: `Account` → `SavingsAccount`, `CurrentAccount`, `FDAccount`. Different interest rates.
3. `Object` class ke methods explore karo — `getClass()`, `hashCode()` call karo kisi bhi object pe.

---

#### Day 19 — Upcasting aur Downcasting
**Concept:**
- **Upcasting:** Child → Parent reference (automatic, safe)
- **Downcasting:** Parent → Child reference (manual, can throw ClassCastException)
- `instanceof` operator — type check before downcast

```java
Animal a = new Dog("Bruno", "Labrador"); // Upcasting (automatic)

// a.bark(); — ERROR! Animal reference me bark() nahi

if (a instanceof Dog) {
    Dog d = (Dog) a; // Downcasting (manual)
    d.bark(); // Now works!
}
```

**Practice Problems:**
1. `Shape` array banao jisme Circle aur Rectangle objects rakho (upcasting). Sab ka area print karo.
2. Parent reference se child ke specific method call karo (downcast karo, instanceof check karo).
3. Wrong downcast karo deliberately — `ClassCastException` dekho aur samjho.

**Interview Question:** "Upcasting automatically kyun hoti hai lekin downcasting manually kyun karni padti hai?"

---

#### Day 20 — `instanceof` + Pattern Matching (Java 16+)
**Concept:**
- `instanceof` = type check
- Modern Java (16+) me pattern matching: `if (a instanceof Dog d) { d.bark(); }`

```java
void processShape(Shape s) {
    if (s instanceof Circle c) {
        System.out.println("Circle area: " + c.area());
    } else if (s instanceof Rectangle r) {
        System.out.println("Rectangle area: " + r.area());
    }
}
```

**Practice Problems:**
1. `processAnimal(Animal a)` method likho — type ke hisaab se different output.
2. Mixed array of shapes → sirf Circles ko identify karo aur unka total area nikalo.
3. `instanceof` chain likho bina pattern matching ke, phir refactor karo with pattern matching.

---

#### Day 21 — Week 3 Revision + Mini Project
**Mini Project: Zoo Management System**
```
- Animal (base): name, age, sound
- Lion, Elephant, Parrot (extends Animal)
  - Lion: mane color, roar()
  - Elephant: trunkLength, trumpet()
  - Parrot: canTalk, talk()
- Zoo class: Animal[] animals
  - addAnimal(), removeAnimal()
  - makeAllSounds() — upcasting use karo
  - listByType(String type) — instanceof use karo
- Main: Zoo create karo, animals add karo, demonstrate karo
```

---

### Week 4: Polymorphism — Ek Interface, Anek Implementations

#### Day 22 — Compile-time Polymorphism (Method Overloading)
**Concept:**
- Same method name, different parameters (type/number/order)
- Compile time pe decide hota hai — "Static Dispatch"
- Return type change karna overloading nahi hai!

```java
class Printer {
    void print(int n) { System.out.println("Int: " + n); }
    void print(double d) { System.out.println("Double: " + d); }
    void print(String s) { System.out.println("String: " + s); }
    void print(int a, int b) { System.out.println("Two ints: " + a + ", " + b); }
}
```

**Practice Problems:**
1. `Calculator` class — `add(int,int)`, `add(double,double)`, `add(int,int,int)`, `add(String,String)` (concatenation).
2. `Display` class — `show(int)`, `show(int[])`, `show(String)`, `show(boolean)`.
3. Overloading trap: kya sirf return type change karna overloading hai? Try karo, error dekho.

---

#### Day 23 — Runtime Polymorphism (Dynamic Method Dispatch)
**Concept:**
- Parent reference → child object → method call at runtime pe decide hota hai
- Virtual method table (vtable) ka concept
- Foundation of OOPs ka most powerful feature

```java
Animal[] animals = {
    new Dog("Bruno"),
    new Cat("Whiskers"),
    new Cow("Daisy")
};

for (Animal a : animals) {
    a.makeSound(); // Runtime pe decide hoga kaun sa makeSound()
}
// Output:
// Woof!
// Meow!
// Moo!
```

**Practice Problems:**
1. `Shape[]` array — Circle, Rectangle, Triangle. Loop me `area()` call karo — runtime polymorphism!
2. `Employee[]` — Manager, Developer, Intern. `calculateSalary()` each ke liye different. Loop me call karo.
3. Same parent reference — different child objects assign karo ek-ek karke. Method call behavior observe karo.

**Interview Question:** "Runtime polymorphism kaise kaam karta hai internally?" (vtable, late binding)

---

#### Day 24 — Polymorphism ke Real-world Use Cases
**Concept:**
- Payment processing system
- Notification system
- Renderer system — UI ka concept

```java
abstract class PaymentMethod {
    abstract boolean processPayment(double amount);

    void sendReceipt() {
        System.out.println("Receipt sent!");
    }
}

class CreditCard extends PaymentMethod {
    boolean processPayment(double amount) {
        System.out.println("Processing " + amount + " via Credit Card");
        return true;
    }
}

class UPI extends PaymentMethod {
    boolean processPayment(double amount) {
        System.out.println("Processing " + amount + " via UPI");
        return true;
    }
}

// Polymorphic usage
PaymentMethod pm = new UPI();
pm.processPayment(500); // Runtime decide karega
```

**Practice Problems:**
1. `Notification` (base) → `SMS`, `Email`, `Push`. Each has `send(String message)`. Loop me sab ko send karo.
2. `Discount` (base) → `FlatDiscount`, `PercentageDiscount`, `BuyOneGetOne`. `apply(double price)` method.
3. Design karo: `Logger` → `FileLogger`, `ConsoleLogger`, `DatabaseLogger`. Same `log(String msg)` method.

---

#### Day 25 — Overloading vs Overriding — Full Comparison
**Concept:**

| Feature | Overloading | Overriding |
|---------|-------------|------------|
| Class | Same class | Parent-Child |
| Parameters | Different | Same |
| Return type | Can differ | Same (or covariant) |
| Resolved at | Compile time | Runtime |
| Static methods | Yes | No (hiding) |
| Access modifier | Any | Can't be more restrictive |

**Practice Problems:**
1. Ek class likho jisme dono hoon — method overloading bhi, parent class ka override bhi.
2. Access modifier restriction: parent me `public`, child me `private` karo — error dekho.
3. Covariant return type: parent returns `Animal`, child returns `Dog` — valid kyu?

**Interview Question:** "Static method override ho sakta hai?" (No — method hiding hoti hai)

---

#### Day 26 — Operator Overloading Java me kyu nahi hai?
**Concept:**
- Java deliberately operator overloading support nahi karta (C++ se alag)
- Reason: readability, simplicity, `+` String me already "overloaded" hai (special case)
- `Comparable` aur `Comparator` — objects compare karna

```java
class Student implements Comparable<Student> {
    String name;
    int marks;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student other) {
        return this.marks - other.marks; // ascending by marks
    }
}

List<Student> students = new ArrayList<>();
// ...add students...
Collections.sort(students); // Comparable use karega
```

**Practice Problems:**
1. `Student` list ko marks se sort karo using Comparable.
2. `Comparator` use karo name se sort karne ke liye (lambda version bhi try karo).
3. Custom sort: pehle grade by marks, same marks me name se.

---

#### Day 27 — Day Off / Buffer Day
**Karo agar peeche ho:**
- Week 3-4 ka koi bhi pending problem solve karo.

**Aage ho toh:**
- LeetCode easy problems: "Design Parking System", "Design HashMap" — OOPs design problems.

---

#### Day 28 — Week 4 Revision + Mini Project
**Mini Project: E-commerce Order System**
```
- Product: id, name, price
- Discount (abstract): apply(double price)
  - PercentDiscount(10%), FlatDiscount(50 off), NoDiscount
- Order: Product[], Discount discount
  - addProduct(), totalPrice() (applies discount), displayOrder()
- Payment (abstract): pay(double amount)
  - CashPayment, CardPayment, UPIPayment
- Main: Order banao, discount lagao, payment karo — polymorphism throughout!
```

---

## PHASE 3 — Advanced OOPs (Week 5–6)

### Week 5: Abstraction — "What" not "How"

#### Day 29 — Abstract Classes
**Concept:**
- Abstract class = incomplete class, directly instantiate nahi kar sakte
- `abstract` method = sirf declaration, koi body nahi
- Abstract class me concrete methods bhi ho sakte hain
- Use when: common base with some shared implementation

```java
abstract class Shape {
    String color;

    Shape(String color) {
        this.color = color;
    }

    abstract double area();    // har shape apna area calculate kare
    abstract double perimeter();

    void display() {           // shared implementation
        System.out.println(color + " shape, Area: " + area());
    }
}

class Circle extends Shape {
    double radius;

    Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    @Override
    double area() { return Math.PI * radius * radius; }

    @Override
    double perimeter() { return 2 * Math.PI * radius; }
}
```

**Practice Problems:**
1. `Animal` abstract class — `makeSound()` abstract. Dog, Cat, Lion implement karein.
2. `Vehicle` abstract — `fuelType()` abstract, `start()` concrete. Car (petrol), Bike (petrol), Tesla (electric).
3. Abstract class ka object directly banane ki koshish karo — error observe karo.

**Interview Question:** "Abstract class aur Concrete class me kya difference hai? Kab use karte hain?"

---

#### Day 30 — Interfaces — Part 1 (Basics)
**Concept:**
- Interface = pure abstraction (traditionally)
- Sirf abstract methods (before Java 8)
- Implement karne wali class saare methods provide kare
- `implements` keyword
- Multiple interfaces implement ho sakti hain (solves multiple inheritance!)

```java
interface Flyable {
    void fly();
    void land();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    @Override
    public void fly() { System.out.println("Duck flying"); }

    @Override
    public void land() { System.out.println("Duck landing"); }

    @Override
    public void swim() { System.out.println("Duck swimming"); }
}
```

**Practice Problems:**
1. `Drawable` interface (`draw()`), `Resizable` interface (`resize(double factor)`). `Square` class dono implement kare.
2. `Printable` (`print()`), `Saveable` (`save(String filename)`). `Document` class dono implement kare.
3. Interface variable: `Flyable f = new Duck()` — kya methods call ho sakti hain?

---

#### Day 31 — Interfaces — Part 2 (Default + Static Methods, Java 8+)
**Concept:**
- Java 8+: Default methods (interface me body wale methods)
- Java 8+: Static methods in interfaces
- Java 9+: Private methods in interfaces
- Interface variables are `public static final` by default

```java
interface Greeting {
    String greet(String name); // abstract

    default String greetWithTime(String name) { // default method
        return "Good day, " + name + "! Time: " + java.time.LocalTime.now();
    }

    static Greeting createFormal() { // static factory method
        return name -> "Good day, " + name + ".";
    }
}
```

**Practice Problems:**
1. `Sortable` interface — `sort()` abstract, `isSorted()` default method.
2. `Validatable` interface — `validate()` abstract, `isValid()` default (calls validate, catches exception).
3. Functional interface + lambda preview: `Runnable`, `Comparator` as lambda.

---

#### Day 32 — Abstract Class vs Interface — The Big Comparison
**Concept (Interview Goldmine!):**

| Feature | Abstract Class | Interface |
|---------|---------------|-----------|
| Instantiate | No | No |
| Constructor | Yes | No |
| Fields | Any type | Only constants |
| Methods | Abstract + Concrete | Abstract + Default + Static |
| Inheritance | Single extend | Multiple implement |
| Access modifiers | Any | Public only (traditionally) |
| When to use | IS-A with shared code | CAN-DO capability |

**Analogy:**
- Abstract Class: "Unfinished blueprint" — Dog IS-AN Animal
- Interface: "Contract / Capability" — Bird CAN fly, Duck CAN fly AND CAN swim

**Practice Problems:**
1. `AbstractLogger` (abstract class) vs `ILogger` (interface) — dono banao, difference feel karo.
2. `Vehicle` abstract class + `Electric` interface. `Tesla implements Electric extends Vehicle`.
3. Diamond problem: Interface ke saath — kaise resolve hota hai? Default method conflict demonstrate karo.

**Interview Question (Most Common):** "Abstract class aur Interface me kab kya use karein?"

---

#### Day 33 — Functional Interfaces + Lambda (OOPs meets Functional)
**Concept:**
- Functional Interface = exactly 1 abstract method
- Lambda = anonymous function shorthand
- `@FunctionalInterface` annotation
- Common: `Runnable`, `Comparator`, `Predicate`, `Function`, `Consumer`

```java
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

// Lambda expressions
MathOperation add = (a, b) -> a + b;
MathOperation multiply = (a, b) -> a * b;

System.out.println(add.operate(5, 3));      // 8
System.out.println(multiply.operate(5, 3)); // 15
```

**Practice Problems:**
1. `Predicate<Integer>` use karo — even numbers filter karo from list.
2. `Function<String, Integer>` — String ki length return karo.
3. `Comparator` lambda — Student list ko name se sort karo.

---

#### Day 34 — Inner Classes aur Anonymous Classes
**Concept:**
- **Inner class:** Class ke andar class
- **Static nested class:** Outer object ke bina accessible
- **Anonymous class:** Name ke bina ek-time-use class
- **Local class:** Method ke andar class

```java
// Anonymous class (interview favorite!)
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Running anonymously!");
    }
};

// Same as lambda:
Runnable r2 = () -> System.out.println("Running with lambda!");
```

**Practice Problems:**
1. Anonymous class se `Comparator` implement karo (bina lambda).
2. Inner class example: `LinkedList` → inner `Node` class.
3. Anonymous → Lambda refactor: pehle anonymous likho, phir lambda se replace karo.

---

#### Day 35 — Week 5 Revision + Mini Project
**Mini Project: Shape Drawing App**
```
- Shape (abstract): color, draw() abstract, area() abstract
- Drawable interface: render(int x, int y)
- Circle, Rectangle, Triangle extends Shape implements Drawable
- ShapeFactory (static methods): createCircle(), createRectangle()
- Canvas class: Shape[] shapes, addShape(), renderAll(), totalArea()
- Anonymous class demo: custom sort shapes by area
```

---

### Week 6: Design Patterns + Interview Prep

#### Day 36 — SOLID Principles (Interview Must-Know)
**Concept:**
- **S**ingle Responsibility: Ek class, ek kaam
- **O**pen/Closed: Extension ke liye open, modification ke liye closed
- **L**iskov Substitution: Child object parent ki jagah kaam kare
- **I**nterface Segregation: Mote interfaces mat banao
- **D**ependency Inversion: Abstractions pe depend karo, concretions pe nahi

```java
// Bad: God class
class UserManager {
    void createUser() { }
    void sendEmail() { } // SRP violation!
    void generateReport() { } // SRP violation!
}

// Good: SRP
class UserService { void createUser() { } }
class EmailService { void sendEmail() { } }
class ReportService { void generateReport() { } }
```

**Practice Problems:**
1. Ek "God class" identify karo (khud banao) aur SRP ke hisaab se refactor karo.
2. Open/Closed: `AreaCalculator` class jo naye shapes ke liye modify na ho.
3. SOLID violations dhundho — code review exercise.

---

#### Day 37 — Singleton Design Pattern
**Concept:**
- Guarantee: sirf ek hi object bane poori application me
- Use cases: Database connection, Logger, Config manager
- Thread-safe Singleton: `synchronized` ya `volatile`

```java
class DatabaseConnection {
    private static DatabaseConnection instance;
    private String connectionString;

    private DatabaseConnection() {  // private constructor
        connectionString = "jdbc:mysql://localhost/mydb";
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void query(String sql) {
        System.out.println("Executing: " + sql);
    }
}

// Usage
DatabaseConnection db1 = DatabaseConnection.getInstance();
DatabaseConnection db2 = DatabaseConnection.getInstance();
System.out.println(db1 == db2); // true! Same object
```

**Practice Problems:**
1. `Logger` singleton — `log(String level, String message)` method.
2. `AppConfig` singleton — key-value settings store karo.
3. Thread-safe version banao (double-checked locking).

---

#### Day 38 — Factory Design Pattern
**Concept:**
- Object creation ko centralize karna
- Client ko nahi pata kaun sa class instantiate ho raha hai
- OCP follow karta hai

```java
interface Animal {
    void makeSound();
}

class Dog implements Animal {
    public void makeSound() { System.out.println("Woof!"); }
}

class Cat implements Animal {
    public void makeSound() { System.out.println("Meow!"); }
}

class AnimalFactory {
    public static Animal create(String type) {
        return switch (type.toLowerCase()) {
            case "dog" -> new Dog();
            case "cat" -> new Cat();
            default -> throw new IllegalArgumentException("Unknown: " + type);
        };
    }
}

Animal a = AnimalFactory.create("dog");
a.makeSound(); // Woof!
```

**Practice Problems:**
1. `ShapeFactory` — "circle", "rectangle", "triangle" string se Shape object banao.
2. `NotificationFactory` — "sms", "email", "push" se Notification object.
3. Factory + Singleton combine karo — `ConnectionFactory` jo sirf ek connection deta hai.

---

#### Day 39 — Builder Design Pattern
**Concept:**
- Complex objects step-by-step banane ke liye
- Telescoping constructor problem solve karta hai
- Method chaining use karta hai

```java
class Pizza {
    private String size, crust, sauce;
    private boolean cheese, pepperoni, mushrooms;

    private Pizza() { }

    static class Builder {
        private Pizza pizza = new Pizza();

        Builder size(String s) { pizza.size = s; return this; }
        Builder crust(String c) { pizza.crust = c; return this; }
        Builder sauce(String s) { pizza.sauce = s; return this; }
        Builder cheese() { pizza.cheese = true; return this; }
        Builder pepperoni() { pizza.pepperoni = true; return this; }

        Pizza build() { return pizza; }
    }
}

Pizza myPizza = new Pizza.Builder()
    .size("Large")
    .crust("Thin")
    .cheese()
    .pepperoni()
    .build();
```

**Practice Problems:**
1. `Computer` builder — CPU, RAM, storage, GPU, OS (optional).
2. `HttpRequest` builder — URL, method, headers, body, timeout.

---

#### Day 40 — Observer Design Pattern
**Concept:**
- One-to-many dependency: ek object change ho toh sab ko notify karo
- Event system, notification system me use hota hai
- Java ka `java.util.Observer` deprecated hai — khud banao

```java
interface Observer {
    void update(String event);
}

interface Subject {
    void subscribe(Observer o);
    void unsubscribe(Observer o);
    void notifyObservers(String event);
}

class EventSystem implements Subject {
    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer o) { observers.add(o); }
    public void unsubscribe(Observer o) { observers.remove(o); }

    public void notifyObservers(String event) {
        for (Observer o : observers) o.update(event);
    }

    public void triggerEvent(String event) {
        System.out.println("Event: " + event);
        notifyObservers(event);
    }
}
```

**Practice Problems:**
1. Stock price system — investors (observers) ko price change notify karo.
2. Chat room — users subscribe karein, message send karo → sab ko milta hai.

---

#### Day 41 — Top 30 OOPs Interview Questions
**Must-Know Questions + Answers:**

1. OOPs ke 4 pillars kya hain?
2. Abstraction vs Encapsulation?
3. Abstract class vs Interface?
4. Method Overloading vs Overriding?
5. `this` vs `super` keyword?
6. Static vs non-static methods?
7. `final` keyword ke uses?
8. Multiple inheritance Java me kyun nahi?
9. Constructor chaining kya hai?
10. Polymorphism ke types kya hain?
11. `instanceof` operator kya karta hai?
12. IS-A vs HAS-A relationship?
13. Pass by value vs pass by reference Java me?
14. `==` vs `.equals()`?
15. `toString()` kab override karna chahiye?
16. Covariant return type kya hai?
17. Method hiding vs Method overriding?
18. SOLID principles kya hain?
19. Design patterns kyu use karte hain?
20. Singleton pattern thread-safe kaise banate hain?
21. Factory vs Builder pattern?
22. Immutable class kaise banate hain?
23. `Comparable` vs `Comparator`?
24. Functional interface kya hai?
25. Anonymous class vs Lambda?
26. Inner class ke types kya hain?
27. Default method interface me kyu add hua Java 8 me?
28. Constructor overloading vs method overloading?
29. Object class ke important methods?
30. Copy constructor kya hai? Shallow vs Deep copy?

**Har question ka ek solid example ke saath answer practice karo.**

---

#### Day 42-45 — Final Revision + Mock Interviews

**Day 42 — Full OOPs Revision**
- Saare concepts ek baar revisit karo (notes/mind map banao)
- Har pillar: ek example program likho bina dekhe

**Day 43 — Coding Problems**
1. Design a Parking Lot (classic OOPs design)
2. Design a Library Management System
3. Design a Banking System

**Day 44 — LeetCode OOPs Problems**
- Design HashMap (LeetCode 706)
- Design Linked List (LeetCode 707)
- Design Parking System (LeetCode 1603)
- LRU Cache (LeetCode 146)

**Day 45 — Mock Interview**
- Kisi friend se ya Pramp.com se mock interview lo
- Saare 30 questions verbally explain karo
- Ek complete OOPs design problem solve karo on paper/whiteboard

---

## Tools aur Resources

### Coding Platforms
- **Practice Problems:** GFG (geeksforgeeks.org/java) — OOPs section
- **Interview Prep:** InterviewBit → Java OOPs
- **LeetCode:** "Design" tag ke problems
- **HackerRank:** OOP track

### Revision Strategy
- **Feynman Technique:** Concept kisi aur ko (ya khud ko) samjhao — gaps pata chalenge
- **Spaced Repetition:** Week ke end me purey week ka 15-min revision
- **Code without looking:** Har concept ek baar bina notes dekhe likho

### Week-wise Milestones
| Week | Topic | Milestone |
|------|-------|-----------|
| 1 | Classes, Objects, Constructors | Student Grade System project |
| 2 | Encapsulation | Library Management project |
| 3 | Inheritance | Zoo Management project |
| 4 | Polymorphism | E-commerce Order project |
| 5 | Abstraction + Interfaces | Shape Drawing App |
| 6 | Design Patterns + Interview | Mock interview ready |

---

## Ashish ke liye Special Advice

### Concepts Jo Kabhi Nahi Bhoologe (Agar Ye Karo):
1. **Analogies banao apni** — Car-Highway, House-Blueprint, etc. Apni life se connect karo.
2. **Draw karo** — UML diagrams haath se — boxes, arrows, IS-A HAS-A relationships.
3. **"Kyu" poochho** — Har rule ke peeche ek reason hai. Wo reason yaad raha toh rule kabhie nahi bhulogey.
4. **Mini projects banao** — Sirf problems solve karne se zyada, full systems design karo.
5. **Galti karo intentionally** — Wrong code likho — compilaton error/runtime error dekho — phir fix karo. Galtiyan best teacher hain.

### Interview Me Ye Mat Karo:
- Sirf definition mat bolo — **example daalo hamesha**
- "I know this concept but can't explain" — ye nahi chalega, **practice verbal explanation**
- Rushed answers — **slow down, structured answer do**: define → example → when to use

---

*Plan created: 9 May 2026 | Goal: Placement Interview Ready | Duration: 45 Days*
