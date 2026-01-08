# Anonymous Inner Class with Abstract Class

## 1. Recap: Abstract Class Rule

* An **abstract class cannot be instantiated**

```java
abstract class A {
    abstract void show();
}
```

❌ Not allowed:

```java
A obj = new A();   // compile-time error
```

---

## 2. Traditional Solution: Concrete Subclass

```java
class B extends A {
    @Override
    void show() {
        System.out.println("in B show");
    }
}
```

Usage:

```java
A obj = new B();
obj.show();   // in B show
```

✔ Works
❌ Extra class created only to implement one method

---

## 3. Problem with Creating a Separate Class

* Class `B`:

  * Exists only to implement `show()`
  * Used only once
  * Creates an extra `.class` file
* This is unnecessary when implementation is **one-time use**

---

## 4. Solution: Anonymous Inner Class for Abstract Class

Instead of creating `B`, implement the abstract method **at the point of object creation**.

### Syntax

```java
A obj = new A() {
    @Override
    void show() {
        System.out.println("in new show");
    }
};
```

Usage:

```java
obj.show();   // in new show
```

✔ No separate class
✔ No instantiation of abstract class
✔ Clean and concise

---

## 5. Important Concept (Very Important ⚠️)

Even though it looks like:

```java
new A()
```

👉 You are **NOT creating an object of abstract class `A`**

What actually happens:

* A **new unnamed subclass of `A`** is created
* Abstract methods are implemented inside it
* Object is created of that **anonymous subclass**

This is why it compiles and runs.

---

## 6. Using Multiple Abstract Methods

```java
abstract class A {
    abstract void show();
    abstract void config();
}
```

Anonymous inner class implementation:

```java
A obj = new A() {
    void show() {
        System.out.println("in show");
    }

    void config() {
        System.out.println("in config");
    }
};
```

✔ All abstract methods must be implemented
✔ Works perfectly

---

## 7. Rules to Remember

1. You **cannot** instantiate an abstract class directly
2. Anonymous inner class:

   * Creates a **concrete subclass**
   * Provides implementations immediately
3. All abstract methods **must be implemented**
4. Very useful when:

   * Implementation is needed **only once**

---

## 8. Where This Is Commonly Used

* Abstract classes
* Interfaces
* Event handling
* Callbacks
* Pre-Lambda Java
* Android listeners

👉 Anonymous inner classes are a bridge between:

* **Abstract classes / Interfaces**
* **Lambda expressions**

---

## 9. Mental Model (Best Way to Remember)

Think of this:

```java
A obj = new A() { ... };
```

As:

> “Create a temporary concrete subclass of `A`, implement all abstract methods, don’t name it, and give me its object.”

---

## 10. Final Summary

* Abstract class + anonymous inner class = **one-time concrete implementation**
* Avoids unnecessary named subclasses
* Clean, readable, and powerful
* Foundation for **interfaces and lambdas**

