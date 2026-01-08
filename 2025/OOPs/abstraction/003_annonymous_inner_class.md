# Anonymous Inner Class (Java)

## 1. What does “Anonymous” mean?

* **Anonymous** = *no name*
* An **anonymous inner class**:

  * Is a class **without a name**
  * Is created **inside another class**
  * Is typically used **only once**

---

## 2. Base Example: Normal Class and Method

```java
class A {
    public void show() {
        System.out.println("in A show");
    }
}
```

Usage:

```java
A obj = new A();
obj.show();   // prints: in A show
```

✔ Works as expected.

---

## 3. Requirement: Change Method Behavior

### Goal

* Change the behavior of `show()` **without modifying class A**
* Means: override `show()`

---

## 4. Traditional Way: Create a Subclass

```java
class B extends A {
    public void show() {
        System.out.println("in B show");
    }
}
```

Usage:

```java
A obj = new B();
obj.show();   // prints: in B show
```

### Problem with this approach

* Creates an **extra `.class` file** (`B.class`)
* Class `B` exists **only to override one method**
* Used **only once**
* Adds unnecessary clutter

👉 Overkill for one-time usage.

---

## 5. Solution: Anonymous Inner Class

Instead of creating a separate class, define the new behavior **at the time of object creation**.

### Syntax

```java
A obj = new A() {
    public void show() {
        System.out.println("in new show");
    }
};
```

Usage:

```java
obj.show();   // prints: in new show
```

✔ The original `show()` in `A` is NOT called
✔ The overridden version is used instead

---

## 6. What’s Actually Happening?

* You are:

  * Creating an object of `A`
  * At the same time, **overriding its method**
* This creates:

  * A **new unnamed subclass of `A`**
  * Used immediately
  * Never reused

---

## 7. Why Is It Called an Anonymous *Inner* Class?

### Anonymous

* No class name
* Compiler assigns an internal name (like `Demo$1.class`)

### Inner

* Defined **inside another class**
* Not a top-level class

After compilation:

* You’ll see something like:

  * `Demo.class`
  * `Demo$1.class`
* `$1`, `$2`, etc. are auto-generated names

---

## 8. Key Characteristics

| Feature                        | Anonymous Inner Class      |
| ------------------------------ | -------------------------- |
| Has a class name               | ❌ No                       |
| Used more than once            | ❌ No                       |
| Overrides methods              | ✅ Yes                      |
| Creates separate `.class` file | ✅ Yes (compiler-generated) |
| Defined at object creation     | ✅ Yes                      |

---

## 9. When Should You Use It?

Use anonymous inner classes when:

* You need to:

  * Override a method
  * Use it **only once**
* You want:

  * Less boilerplate
  * Cleaner code
* Very common with:

  * Interfaces
  * Event listeners
  * Functional interfaces
  * Pre-Lambda Java code

---

## 10. Mental Model (Very Important)

Think of this line:

```java
A obj = new A() { ... };
```

As:

> “Create a subclass of `A`, override some methods, don’t name it, and give me its object.”

---

## 11. Preview: Why This Matters Later

Anonymous inner classes are heavily used in:

* **Interfaces**
* **Functional interfaces**
* **Lambda expressions**
* **Android callbacks**
* **Thread & Runnable implementations**

👉 Lambdas are basically a *shorter replacement* for many anonymous inner classes.

---

## 12. Quick Summary

* Anonymous inner class = unnamed class + one-time use
* Defined at object creation
* Used to override behavior without creating a new class
* Reduces unnecessary class files
* Foundation for understanding **lambdas**

---
