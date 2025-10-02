## Detailed Transcript Notes: Bitwise Operators and Number Systems

### I. Introduction and Foundational Concepts

*   **Topic Focus:** Bitwise operators and prime numbers.
*   **Relevance:** Bitwise operations are an important topic in competitive programming and frequently appear in interviews.
*   **Computer Internals:** Every programming language is internally converted into machine language, which consists of binary digits (0s and 1s). Internally, all numbers and calculations are performed in binary form.

### II. Number Systems

The number system conversion is a fundamental skill [4, 14:17].

| System | Base | Digits Used | Examples |
| :--- | :--- | :--- | :--- |
| **Decimal** | 10 | 0 to 9 | Used in daily life. |
| **Binary** | 2 | 0 and 1 | Used internally by computers. Example: 7 (decimal) is 111 (binary). |
| **Octal** | 8 | 0 to 7 | Example: 9 (decimal) is 11 (octal). |
| **Hexadecimal**| 16 | 0-9 and A-F (A=10, F=15) | Example: 10 (decimal) is A (hex). |

#### A. Number System Conversion Rules

Two basic steps allow conversion between any two bases:

1.  **Decimal to Base B (e.g., Decimal to Binary):**
    *   **Method:** Keep dividing the decimal number by the base (B). Write down the remainders in the opposite (reverse) order.
    *   **Example:** 17 (base 10) converted to base 2 is 10001 (base 2).
2.  **Base B to Decimal:**
    *   **Method:** Start from the rightmost digit (position 0). Multiply each digit by the base raised to its position power ($B^0, B^1, B^2, \dots$) and sum the results.
    *   **Example:** $10001_{2} = (1 \times 2^4) + (0 \times 2^3) + (0 \times 2^2) + (0 \times 2^1) + (1 \times 2^0) = 16 + 1 = 17$.

### III. Bitwise Operators

Bitwise operators work on the individual bits of numbers.

| Operator | Symbol | Name | Description/Rule |
| :--- | :--- | :--- | :--- |
| **AND** | `&` | Bitwise AND | Result is 1 (True) only if *both* bits are 1 (True). |
| **OR** | `|` | Bitwise OR | Result is 1 (True) if *at least one* bit is 1 (True). |
| **XOR** | `^` | Exclusive OR | Result is 1 (True) if *only one* bit is 1 (True). If both are the same, result is 0. |
| **NOT** | `~` | Complement | Flips every bit (0 becomes 1, 1 becomes 0). |

#### A. XOR Properties (Key Observations)

*   `N ^ 0` equals N.
*   `N ^ 1` equals the complement of N.
*   `N ^ N` equals 0.
*   XOR operations are commutative (order does not matter).

#### B. Shift Operators

| Operator | Symbol | Name | Description | Equivalent Arithmetic Operation |
| :--- | :--- | :--- | :--- | :--- |
| **Left Shift** | `<<` | Left Shift | Shifts bits to the left by N positions. Zeros are appended to the right. | $Number \times 2^N$. |
| **Right Shift**| `>>` | Right Shift | Shifts bits to the right by N positions. The rightmost bit(s) are discarded. | $Number / 2^N$ (integer division). |

### IV. Negative Binary Numbers (2’s Complement)

Negative numbers are typically stored using **2’s Complement**. The size (e.g., 1 byte = 8 bits) is important.

*   **Most Significant Bit (MSB):** The leftmost bit. If MSB is 0, the number is positive. If MSB is 1, the number is negative.
*   **Calculating -N using 2’s Complement:**
    1.  Take the 1’s Complement (invert all bits of N).
    2.  Add 1 to the result.
*   **Range of Signed Numbers (N bits):**
    *   One bit is reserved for the sign. The number range is determined by $N-1$ bits.
    *   **Formula:** The range is from $-2^{N-1}$ to $2^{N-1} - 1$.
    *   **Example (1 byte, 8 bits):** The range is $-2^7$ ($-128$) to $2^7 - 1$ ($127$).

### V. Interview Questions and Bitwise Solutions

#### Q1: Check for Odd or Even (Parity)
*   **Concept:** In binary representation, the rightmost bit (Least Significant Bit or LSB) represents $2^0 = 1$. If this bit is 1, the number is Odd; if 0, it is Even.
*   **Solution:** Use the Bitwise AND operator with 1.
    *   If `(N & 1) == 1`, the number is Odd [40:42, 34].
    *   If `(N & 1) == 0`, the number is Even.

#### Q2: Find the Single Unique Number (Duplicates appear Twice)
*   **Scenario:** Given an array where every number appears twice except one.
*   **Solution:** XOR all elements together.
    *   Since $N \wedge N = 0$, all duplicate pairs cancel out, leaving only the unique number (Unique $\wedge 0$).
*   **Complexity:** $O(N)$ time, $O(1)$ space.

#### Q4: Find the I-th Bit
*   **Goal:** Find the value (0 or 1) of the bit at position $I$.
*   **Solution:** Create a mask with only the $I$-th bit set, and then use Bitwise AND.
    *   Mask: `(1 << I)`
    *   Result: `N & (1 << I)`. If the result is non-zero, the bit is 1.

#### Q5: Set the I-th Bit
*   **Goal:** Change the $I$-th bit to 1, regardless of its current value.
*   **Solution:** Use Bitwise OR with a mask.
    *   Mask: `(1 << I)`
    *   Result: `N | (1 << I)`. (Since $1 \mid 0 = 1$ and $1 \mid 1 = 1$).

#### Q6: Reset the I-th Bit
*   **Goal:** Change the $I$-th bit to 0, regardless of its current value.
*   **Solution:** Use Bitwise AND with a negated (complemented) mask.
    *   Mask: `~(1 << I)` (This creates a mask with 0 at position $I$ and 1 everywhere else).
    *   Result: `N & (~(1 << I))`.

#### Q7: Find the Position of the Rightmost Set Bit
*   **Goal:** Return a number where only the rightmost set bit is 1, and all other bits are 0.
*   **Solution:** Requires 2’s complement.
    *   Result: `N & (-N)`.

#### Q8: Find the Single Unique Number (Duplicates appear M times)
*   **Scenario:** Every number appears $M$ times (e.g., 3), except one unique number.
*   **Solution:** Count the total number of set bits (1s) at each position across all numbers in the array.
    *   If the total count of 1s at a position modulo $M$ is not 0 (i.e., Count $\% M \ne 0$), then the unique number must have a 1 at that position.
    *   These remaining bits reconstruct the unique number.

#### Q10: Find Number of Digits in Base B
*   **Goal:** Find the total number of digits required to represent number $N$ in base $B$ (e.g., how many bits in base 2).
*   **Iterative Method:** Keep right shifting $N$ (or dividing by $B$) and count the number of iterations until $N=0$. Complexity is $O(\log N)$.
*   **Formula (Efficient):** Use logarithms.
    *   Number of Digits = $ \lfloor \log_{B}(N) \rfloor + 1$.
    *   If using base 10 logs: $ \lfloor \frac{\log_{10}(N)}{\log_{10}(B)} \rfloor + 1$.

#### Q12: Check if a Number is a Power of Two
*   **Goal:** Determine if $N$ has only one set bit in its binary representation.
*   **Solution:** Use the Bitwise AND property of `N` and `N - 1`.
    *   If `(N & (N - 1)) == 0` (and $N > 0$), then $N$ is a power of 2.

#### Q13: Calculate A^B (Power) Efficiently
*   **Goal:** Calculate $A$ raised to the power $B$ ($A^B$).
*   **Algorithm (Binary Exponentiation/Modular Exponentiation):** Runs in $O(\log B)$ time.
    *   Initialize `Answer = 1`.
    *   Loop while $B > 0$:
        1.  Check the last bit of $B$ (`B & 1`). If it is 1, update `Answer = Answer * Base`.
        2.  Square the base: `Base = Base * Base`.
        3.  Right shift the power: `B = B >> 1` [99, 1:50:26].

#### Q14: Find Number of Set Bits (Count Set Bits)
*   **Goal:** Count the number of 1s in the binary representation of $N$ [1:51:09].
*   **Efficient Solution (Brian Kernighan's Algorithm):** Complexity is proportional to the number of set bits.
    *   Loop until $N=0$:
        1.  Reset the rightmost set bit: `N = N & (N - 1)`.
        2.  Increment count.

#### Q15: Find XOR of Numbers from 0 to N
*   **Goal:** Calculate $0 \wedge 1 \wedge 2 \wedge \dots \wedge N$ [2:00:01].
*   **Solution:** Observe the repeating pattern every 4 numbers [2:02:00, 108].
    *   If $N \% 4 = 0$, Result is $N$ [2:02:18].
    *   If $N \% 4 = 1$, Result is $1$ [2:02:39].
    *   If $N \% 4 = 2$, Result is $N+1$ [2:02:44].
    *   If $N \% 4 = 3$, Result is $0$ [2:03:01].

#### Q16: Find XOR of Numbers in Range A to B
*   **Goal:** Calculate $A \wedge (A+1) \wedge \dots \wedge B$ [2:03:18].
*   **Solution:** Use the pattern established in Q15 to define a function $f(X)$ which calculates the XOR sum from $0$ to $X$.
    *   Result: $f(B) \wedge f(A-1)$ [114, 2:08:14].

#### Q17 (Google): Flipping an Image (Matrix)
*   **Task:** Flip a 2D array (image) horizontally (reverse each row) and then invert the values (0 becomes 1, 1 becomes 0) [2:09:38, 2:09:59].
*   **Solution Steps:**
    1.  **Reverse Rows:** Iterate through each row and swap elements horizontally to reverse the row order [2:11:21, 2:13:54].
    2.  **Invert:** After reversal, invert every element [2:11:26]. This can be achieved by $1 - element$ or using XOR: `element ^ 1` [2:11:13, 2:15:37, 2:15:42].