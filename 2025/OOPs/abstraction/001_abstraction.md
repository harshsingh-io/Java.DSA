## 1. Background Concepts (Assumed Knowledge)

Before understanding `abstract`, you should already know:

* What a **class** is
* What an **object** is
* **Inheritance**
* **Method overriding**
* **Dynamic method dispatch**

---

## 2. Problem Statement: Why Abstract Is Needed

### Example: `Car` class

A `Car` conceptually:

* **Can drive**
* **Can play music**

```java
class Car {
    void drive() {
        // no implementation
    }

    void playMusic() {
        System.out.println("Playing music");
    }
}
```

### Issues with this approach:

* `drive()` exists but does **nothing**
* Object creation is allowed:

  ```java
  Car obj = new Car();
  obj.drive();       // does nothing
  obj.playMusic();   // works
  ```
* This is **syntactically valid**, but **conceptually wrong**
* Like selling a phone with features that don’t work

👉 If you don’t know how to implement `drive`, **why allow object creation at all?**

---

## 3. Declaring a Method Without Defining It

Instead of defining `drive()`, you **declare** it:

```java
void drive();
```

* Declaring = method signature + semicolon
* Means: *“This feature must exist, but I don’t know how to implement it yet”*
* Java throws an error ❌

Why?

* A method without a body **must be abstract**

---

## 4. Abstract Methods

### Syntax

```java
public abstract void drive();
```

### Rules:

* Abstract methods:

  * Have **no body**
  * Must be declared using `abstract`
* Abstract methods **cannot exist in a normal class**

---

## 5. Abstract Class

To fix the error, the class itself must be abstract:

```java
abstract class Car {
    public abstract void drive();

    void playMusic() {
        System.out.println("Playing music");
    }
}
```

### Key Meaning:

* `Car` is now an **abstract concept**
* Represents *what a car should have*, not *how it works*

---

## 6. Real-World Mapping

* You don’t buy a “Car”
* You buy:

  * WagonR
  * BMW
  * Fortuner

So:

* `Car` → **abstract concept**
* `WagonR`, `BMW` → **real implementations**

---

## 7. Implementing Abstract Methods (Subclass Responsibility)

```java
class WagonR extends Car {
    @Override
    public void drive() {
        System.out.println("Driving WagonR");
    }
}
```

### Rules:

* Any class extending an abstract class **must implement all abstract methods**
* Otherwise → compile-time error

---

## 8. Object Creation Rules

### ❌ Not allowed:

```java
Car obj = new Car();   // ERROR
```

### ✅ Allowed:

```java
Car obj = new WagonR();
```

* Reference type → abstract class
* Object type → concrete subclass
* Method calls use **dynamic method dispatch**

  * `drive()` → WagonR’s implementation
  * `playMusic()` → inherited from Car

---

## 9. Multiple Abstract Methods

```java
abstract class Car {
    abstract void drive();
    abstract void fly();

    void playMusic() {
        System.out.println("Playing music");
    }
}
```

### Subclass must implement **ALL** abstract methods:

```java
class WagonR extends Car {
    void drive() {
        System.out.println("Driving");
    }

    void fly() {
        System.out.println("Flying");
    }
}
```

---

## 10. What If Subclass Can’t Implement All Methods?

If a subclass does **not** implement all abstract methods:

* That subclass **must also be abstract**

```java
abstract class WagonR extends Car {
    void drive() {
        System.out.println("Driving");
    }
    // fly() not implemented
}
```

### Then:

* You **still cannot create its object**
* Need another subclass:

```java
class UpdatedWagonR extends WagonR {
    void fly() {
        System.out.println("Flying");
    }
}
```

---

## 11. Abstract Class vs Concrete Class

| Type           | Can have abstract methods | Can create object |
| -------------- | ------------------------- | ----------------- |
| Abstract Class | Yes / No                  | ❌ No              |
| Concrete Class | ❌ No                      | ✅ Yes             |

* A **concrete class**:

  * Implements all abstract methods
  * Can be instantiated

---

## 12. Important Rules Summary

### Abstract Keyword Rules

1. `abstract` can be used with:

   * Classes
   * Methods
2. Abstract methods:

   * Have no body
   * Must belong to an abstract class
3. Abstract class:

   * May have:

     * Only abstract methods
     * Only normal methods
     * Both
4. Object creation:

   * ❌ Cannot create object of abstract class
   * ✅ Can use abstract class as a reference
5. Subclasses:

   * Must implement **all** abstract methods
   * Otherwise, they must also be abstract

---

## 13. Why Abstract Is Useful

* Enforces **structure**
* Ensures **mandatory features**
* Prevents misuse (incomplete implementations)
* Enables **polymorphism + clean design**

