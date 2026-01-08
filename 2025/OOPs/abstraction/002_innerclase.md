# Inner classes (class inside a class)

## 1. Concept / Why use inner classes

* Use an inner class when a class is **only needed for a specific outer class** — it keeps related code grouped and expresses tight coupling.
* Example scenario: class `A` has data & methods, and a helper class `B` is meaningful **only** inside `A`.

## 2. Basic structure (non-static inner class)

```java
class A {
    int age;
    void show() {
        System.out.println("in Show");
    }

    class B {
        void config() {
            System.out.println("in config");
        }
    }
}
```

* `A` has variable(s), method(s), and an inner class `B`.
* `B` belongs to `A` — it is not visible as a top-level type.

## 3. How to instantiate and call methods

### Calling outer methods/fields

```java
A obj = new A();
obj.show();          // works
```

### Instantiating non-static inner class `B`

* You **cannot** directly do `new B()` from outside `A`. `B` is scoped inside `A`.
* Correct way (non-static inner class) requires an *instance* of `A`:

```java
A a = new A();
A.B b = a.new B();
b.config();
```

* Reason: `B` is tied to an instance of the outer class (non-static), so you need the outer instance to create `B`.

## 4. Compilation note — class files

* When you compile, you get separate `.class` files:

  * `A.class`
  * `A$B.class`  (the `$` denotes nested/inner class belonging to `A`)
* This is expected and normal.

## 5. Static nested class (a static inner class)

* If you declare the inner class `static`, you **do not** need an instance of the outer class to create it:

```java
class A {
    static class B {
        void config() { ... }
    }
}

// instantiate:
A.B b = new A.B();
b.config();
```

* Key rule: `static` modifier for classes is **only allowed on nested (inner) classes**, not on top-level classes.

  * Top-level classes cannot be `static` (compile-time error).

## 6. Differences & practical implications

* **Non-static inner class**

  * Requires an outer instance to instantiate (`a.new B()`).
  * Can access non-static members of outer instance directly.
  * Useful when `B` logically depends on a specific `A` instance.
* **Static nested class**

  * No outer instance needed (`new A.B()`).
  * Behaves like a regular top-level class scoped inside `A`.
  * Can only directly access static members of `A`.

## 7. When to use which

* Use **non-static inner class** when the nested class needs to reference the specific outer instance or its non-static members.
* Use **static nested class** when the nested class does not depend on a particular outer instance — keeps namespace tidy without outer-instance coupling.

## 8. Short checklist / summary

* Inner class useful for classes with narrow, local use.
* Non-static inner class: instantiate with `outerInstance.new Inner()`.
* Static nested class: instantiate with `new Outer.Inner()`.
* Compiles to `Outer.class` and `Outer$Inner.class`.
* `static` allowed only for nested classes, not for top-level classes.

---
