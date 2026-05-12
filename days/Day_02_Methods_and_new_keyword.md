# Day 2 — Methods and the `new` Keyword
**Topic:** Methods deep dive — return types, parameters, method types. What `new` does internally.
**Date:** 10 May 2026

---

## Core Concept

A **method** is a block of code inside a class that defines the **behaviour** of an object.

Every method has:
1. **Return type** — what it gives back (`int`, `double`, `String`, `void` for nothing)
2. **Name** — what you call it
3. **Parameters** — inputs it takes (can be zero or more)
4. **Body** — the actual logic

```
returnType methodName(parameter1, parameter2) {
    // logic
    return value; // only if return type is not void
}
```

---

## Interview Questions & Answers

---

### Q1. What is a method? What are its four parts?

**Answer:**

A method is a named block of code inside a class that defines what an object can do. Every method has four parts:

1. **Return type** — the data type of the value it returns. Use `void` if it returns nothing.
2. **Method name** — how you call it (camelCase convention).
3. **Parameters** — inputs the method needs to do its job (can be empty).
4. **Body** — the logic block inside `{ }`.

```java
//  return type
//  |      name
//  |      |        parameters
//  ↓      ↓        ↓
   int   add  (int a, int b) {
       return a + b;   // ← body
   }
```

---

### Q2. What is the difference between a `void` method and a method with a return type?

**Answer:**

- A `void` method **performs an action** but does not return any value to the caller.
- A method with a return type **computes and returns a value** that the caller can use.

```java
class Calculator {
    // void — just prints, returns nothing
    void printSum(int a, int b) {
        System.out.println("Sum: " + (a + b));
    }

    // int return type — gives value back to caller
    int getSum(int a, int b) {
        return a + b;
    }
}

Calculator c = new Calculator();
c.printSum(3, 4);          // prints "Sum: 7", can't store result

int result = c.getSum(3, 4);  // result = 7, can use it further
System.out.println(result * 2); // 14
```

> Rule of thumb: If the caller needs the computed value for further use → return type. If the method just does something (print, save, update) → void.

---

### Q3. What happens step-by-step when you write `Car c = new Car()`?

**Answer:**

Four things happen in order:

1. The JVM finds the `Car` class definition.
2. **Memory is allocated** on the **heap** for a new Car object.
3. The **constructor is called** to initialize the object's fields.
4. The **memory address (reference)** of that object is stored in the variable `c`.

```java
Car c = new Car();
// c does NOT hold the object
// c holds the ADDRESS of where the object lives in heap memory
```

> This is why when you do `Car c2 = c`, both `c` and `c2` point to the **same object** in memory. Changing `c2.brand` also changes what you see via `c`.

```java
Car c1 = new Car();
c1.brand = "Honda";

Car c2 = c1;         // c2 points to same object as c1
c2.brand = "BMW";

System.out.println(c1.brand); // BMW — not Honda!
```

---

### Q4. What is method overloading? (Preview — covered in detail on Day 22)

**Answer:**

Method overloading means having **multiple methods with the same name** in the same class, but with **different parameters** (different type, number, or order).

The compiler decides which method to call based on the arguments you pass.

```java
class Printer {
    void print(int n)    { System.out.println("Int: " + n); }
    void print(String s) { System.out.println("String: " + s); }
    void print(int a, int b) { System.out.println(a + ", " + b); }
}

Printer p = new Printer();
p.print(5);        // calls first method
p.print("hello");  // calls second method
p.print(3, 7);     // calls third method
```

> Key rule: **Return type alone cannot distinguish overloaded methods.** Parameters must differ.

---

### Q5. What is the difference between parameters and arguments?

**Answer:**

- **Parameters** are the variables defined in the method signature — they are placeholders.
- **Arguments** are the actual values you pass when calling the method.

```java
// a and b are PARAMETERS
int add(int a, int b) {
    return a + b;
}

// 5 and 3 are ARGUMENTS
int result = add(5, 3);
```

Think of it this way: parameters are in the **definition**, arguments are in the **call**.

---

### Q6. Can a method call another method of the same class?

**Answer:**

Yes. A method can call any other method of the same class directly by name (no object needed).

```java
class Circle {
    double radius;

    double area() {
        return Math.PI * radius * radius;
    }

    double diameter() {
        return 2 * radius;
    }

    void describe() {
        // calling other methods of same class directly
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + area());       // calling area()
        System.out.println("Diameter: " + diameter()); // calling diameter()
    }
}
```

---

## Full Example — Methods in Action

```java
class Calculator {
    // No parameters, no return
    void greet() {
        System.out.println("Welcome to Calculator!");
    }

    // Parameters, with return
    int add(int a, int b) {
        return a + b;
    }

    double divide(double a, double b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero!");
            return 0;
        }
        return a / b;
    }

    // Method calling another method
    void showAddResult(int a, int b) {
        int result = add(a, b);  // calling add() from within same class
        System.out.println(a + " + " + b + " = " + result);
    }
}

public class Main {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        calc.greet();
        System.out.println(calc.add(5, 3));       // 8
        System.out.println(calc.divide(10, 3));    // 3.3333...
        calc.showAddResult(7, 4);                  // 7 + 4 = 11
    }
}
```

---

## Practice Problems

1. Create a `Circle` class — field: `radius`. Methods: `area()` returns `double`, `circumference()` returns `double`. In `main`, create a circle with radius 7 and print both. (Use `Math.PI`)

2. Create a `Temperature` class. Methods:
   - `celsiusToFahrenheit(double c)` — returns `double` (formula: `c * 9/5 + 32`)
   - `fahrenheitToCelsius(double f)` — returns `double` (formula: `(f - 32) * 5/9`)
   - Test with 100°C and 212°F.

3. Create a `StringHelper` class with these static-style methods (for now, make them regular methods):
   - `reverse(String s)` — returns reversed string
   - `isPalindrome(String s)` — returns `boolean`
   - `countVowels(String s)` — returns `int`
   - Test with "madam", "hello", "racecar".

---

## Quick Revision — One-liners

- Method = name + return type + parameters + body
- `void` = returns nothing, return type = gives value back
- `new` = allocate heap memory + call constructor + return reference
- Same name, different parameters = method overloading
- Parameters = in definition, Arguments = in call
- A method can call other methods of the same class directly
