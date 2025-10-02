# Bitwise Operators and Number Systems: Study Notes

## Bitwise Operators

**Bitwise operators** perform operations on the binary representations of integers (bit by bit). Unlike arithmetic or logical operators that work on whole values or boolean logic, bitwise operators directly manipulate individual bits of the operands. Common bitwise operators include AND, OR, XOR, NOT, and the shift operators. These are fundamental in low-level programming and efficient algorithms (e.g. for arithmetic tricks or optimizing computations).

### Bitwise AND (&)

* **Definition:** Takes two bits and returns 1 if *both* bits are 1, otherwise returns 0\. In other words, the result bit is 1 *only when* the first AND second bit are 1 (truth table: 1&1=1; 1&0=0; 0&1=0; 0&0=0).

* **Effect on integers:** a & b will produce a number that has 1-bits only in positions where *both* a and b have 1-bits. All other bit positions become 0\. This is often used as a *masking* operation to zero-out certain bits.

* **Example – Checking odd/even:** A useful trick is to check if an integer is odd or even using bitwise AND. Any integer n is **odd** if n & 1 \= 1 (meaning the least significant bit is 1), and **even** if n & 1 \= 0. For example, 5 (0101₂) & 1 (0001₂) \= 0001₂ (1), so 5 is odd; 8 (1000₂) & 1 \= 0000₂ (0), so 8 is even. This uses the fact that in binary the last bit indicates parity.

* **Other uses:** AND is used to **extract bits** (by ANDing with an appropriate mask, e.g. x & 0xFF to get the lower 8 bits), and to **clear bits** (AND with 0 at a position forces that bit to 0). For instance, x & (\~(1 \<\< k)) clears the k-th bit of x.

### Bitwise OR (|)

* **Definition:** Returns 1 if *either* of the two bits is 1 (or if both are 1). The result bit is 0 only when both input bits are 0 (truth table: 1|1=1; 1|0=1; 0|1=1; 0|0=0).

* **Effect on integers:** a | b produces a number that has 1-bits in any position where *either* a or b (or both) has a 1-bit. It essentially combines the set bits of two numbers.

* **Usage:** OR is commonly used to **set bits** in a number. For example, to set the 3rd bit of a number x to 1, one can do x | (1 \<\< 2\) (assuming 0-indexed bit positions). This will leave all other bits of x unchanged and ensure the specified bit is 1\.

* **Example:** Suppose a \= 6 (0110₂) and b \= 9 (1001₂). Then a | b \= 1111₂ (which is 15 in decimal). Each bit of the result is 1 because each bit position in the two numbers had at least one 1.

### Bitwise XOR (^) (Exclusive OR)

* **Definition:** Returns 1 if *exactly one* of the two bits is 1 (bits are different), and 0 if the bits are the same (both 0 or both 1). Essentially, XOR outputs 1 for a bit position if the number of 1s in that position of the operands is odd (truth table: 1^0=1; 0^1=1; 1^1=0; 0^0=0).

* **Effect on integers:** a ^ b will have 1s in positions where a and b differ, and 0s where they have the same bit. XOR is often thought of as a bitwise *difference* operation.

* **Notable properties:** XOR has some useful algebraic properties: any number XOR itself is 0 (x ^ x \= 0 for any x, since all bits cancel out), and any number XOR 0 is itself (x ^ 0 \= x). Also, XOR is commutative and associative, which means the order of XOR operations doesn’t matter and can be regrouped.

* **Uses and examples:**

* **Flipping bits:** XOR with a mask of all 1s (i.e., ^ 0xFFFFFFFF in 32-bit) will flip all bits (though typically one would use NOT for that – see Bitwise NOT below).

* **Swapping variables:** A classic trick to swap two integer variables without using extra space uses XOR:

* // Given two numbers in x and y  
  x \= x ^ y    
  y \= x ^ y  // (which is original x ^ y ^ y, yielding original x)    
  x \= x ^ y  // (which is original x ^ y ^ original x, yielding original y)  

* After these steps, x and y are swapped. This works because XORing out the information twice restores it (due to the properties above).

* **Finding unique items:** XOR is very useful in finding a unique element in a collection of duplicates. For example, if an array contains pairs of identical numbers and one single number that is unpaired, XORing all the numbers together will cancel out all pairs and leave the unique number. *Illustration:* Suppose we have numbers \[7, 3, 5, 3, 5\]. XORing them all: 7 ^ 3 ^ 5 ^ 3 ^ 5 – the duplicate pairs (3^3 and 5^5) each result in 0, so the result reduces to 7 ^ 0 ^ 0 which is 7. This principle was emphasized in one of the problems, where **the number that appears only once** in a list of duplicates can be found with XOR.

* **Bit toggling:** XOR with 1 at a certain bit position will toggle that bit (change 0 to 1 or 1 to 0), since 1^0 \= 1 and 1^1 \= 0\. For example, y ^ (1 \<\< k) will flip the k-th bit of y.

### Bitwise NOT (\~) (Bitwise Complement)

* **Definition:** This is a **unary** operator (takes one operand) that flips each bit of the operand: 1 becomes 0, and 0 becomes 1\. It produces the 1’s complement of a number’s binary representation.

* **Effect on integers:** If x is an integer, \~x results in a number where every bit of x has been inverted. For example, if x \= 5 (00000101₂ in 8 bits), then \~x \= 11111010₂. In a signed integer representation (two’s complement), \~x is equivalent to \-x \- 1 because inverting all bits and then adding 1 gives the two’s complement negative (this relationship comes from how negative numbers are represented, see **Negative Binary Numbers** below).

* **Usage:** Bitwise NOT is commonly used to quickly compute the 1’s complement, or to assist in creating masks. For instance, if you have a mask for bits you want to keep, applying NOT to it gives a mask for bits you want to clear. e.g. mask \= 0b00001111 (keep low 4 bits); \~mask \= 0b11110000 can be used to clear those low 4 bits of a number by ANDing: x & \~mask would zero-out the bottom 4 bits of x.

### Bitwise Shift Operators (\<\< and \>\>)

* **Definition:** Shift operators move the bits of a number left or right by a specified number of positions. Each shift effectively multiplies or divides the number by powers of two (with some caveats on sign for right shifts).

* **Left Shift (\<\<):** Shifts all bits to the left, and fills the new rightmost bits with 0s. Shifting left by 1 position multiplies the number by 2 (assuming no overflow beyond the fixed size of the integer). For example, 3 (0011₂) \<\< 1 \= 0110₂, which is 6 in decimal. In general, x \<\< k yields x \* 2^k (as long as the result fits in the bit-width and we’re dealing with unsigned or non-overflowing values).

* **Right Shift (\>\>):** Shifts all bits to the right. The behavior for filling the leftmost bits depends on the type of shift: most languages use **arithmetic right shift** for signed integers (fills with the sign bit to preserve the number’s sign, essentially dividing by 2 and flooring) and **logical right shift** for unsigned integers (fills with 0s). For positive numbers, a right shift by 1 position divides the number by 2, discarding any remainder (e.g., 5 (0101₂) \>\> 1 \= 0010₂, which is 2). For negative numbers in two’s complement, an arithmetic right shift will round toward negative infinity (e.g., \-5 \>\> 1 \= \-3 in many systems, as the sign bit 1 is replicated).

* **Usage and examples:**

* Left shifts are used for quick multiplication by powers of two. For instance, n \<\< 3 multiplies n by 8\. This was highlighted as a fast operation at the binary level. For example, shifting 7 (00000111₂) left by 2 gives 00011100₂ which is 28, confirming that 7\*4=28.

* Right shifts are used for fast division by powers of two or for bit-manipulation tasks like extracting parts of a number. For example, (x \>\> 4\) discards the lowest 4 bits of x (effectively floor-dividing by 16). This can be useful in scenarios like extracting the high-order bits or performing integer division by 2^k quickly.

* **Important:** Bits that are shifted out of range are lost. For a left shift, the leftmost bits may overflow and be dropped if the number is too large. For a right shift, the rightmost bits are discarded (e.g., odd numbers will lose the 1 and effectively get floored when dividing by 2).

### Common Uses and Tricks with Bitwise Ops

Bitwise operations enable many neat programming tricks and efficient algorithms. The transcript covered several **key examples and problems** that utilize bitwise concepts:

* **Checking if a number is odd or even:** *As mentioned above in AND*, use n & 1. If result is 1 → odd; if 0 → even. This avoids slower operations like modulo.

* **Checking if a number is a power of two:** A classic bit trick is to exploit the binary pattern of powers of two. A power of two in binary looks like 1000...0 (one 1-bit followed by all 0s). If n is a power of two (and n \> 0), then n & (n-1) \= 0. For example, 8 (1000₂) is a power of 2; 8-1 \= 7 (0111₂) and indeed 1000₂ & 0111₂ \= 0000₂. If n is not a power of 2, this AND will produce a non-zero result. *(This trick was demonstrated in one of the problems: it relies on the fact that subtracting 1 flips all bits after the last set bit, thus if there was more than one set bit, some 1 remains after the AND.)*

* **Swapping two numbers (XOR swap):** Using XOR as described in the XOR section above. This was featured as an elegant solution in the lecture, showing how three XOR operations can swap values without a temporary variable. It leverages XOR’s reversible nature.

* **Finding a unique element in a pairwise list:** When every element in a list appears twice except one element, XOR of the entire list yields that single appearing element. This is because pairs cancel out to 0 and 0 XOR *X* \= *X*. The video showcased this as a simple and powerful use of XOR. For instance, in an array \[2, 5, 2, 8, 5\], XORing all gives (2^2) ^ (5^5) ^ 8 \= 0 ^ 0 ^ 8 \= 8.

* **Finding a unique element where others appear thrice:** A more complex scenario discussed was when every element appears **three times** except one that appears once. In this case, a simple XOR won’t directly work (because XOR of thrice occurrences leaves one copy). The noted solution uses bitwise counting: count the sum of bits in each position modulo 3\. Essentially, bits that belong to numbers that appear three times will sum to a multiple of 3, and the remaining bits (not divisible by 3\) must come from the unique number. By constructing the number from these “leftover” bits (bits where the count % 3 \= 1), we obtain the unique element. This method was outlined as a clever application of bit operations to handle a problem where XOR isn’t sufficient. It demonstrates the power of analyzing binary representations for problem solving.

* **“Magic Number” problem (Amazon example):** A special problem discussed where so-called *magic numbers* are formed using powers of 5\. The **n-th magic number** is defined by interpreting the binary representation of n as coefficients for powers of 5 and summing them. In simpler terms, you generate the magic number by taking the binary digits of n from least significant to most, and for each 1 bit, adding the corresponding power of 5\. For example, n=3 has binary 11₂. Using that, 3rd magic number \= 5^1 \+ 5^2 \= 5 \+ 25 \= **30**. Similarly, 1st magic number (n=1₂) \= 5^1 \= **5**; 2nd (n=10₂) \= 5^2 \= **25**. This technique shows a direct interplay between binary representation and arithmetic in another base. The solution to this problem utilized bit shifts and additions: essentially iterating through bits of n (using n & 1 to check each bit, then shifting n right) and accumulating powers of 5\. It’s a great example of how understanding binary helps solve problems in other number systems quickly.

Each of the above examples highlights how bitwise operations can be used to achieve results with very little computational overhead. These tricks are often used in optimized code and were emphasized as important concepts.

---

## Number Systems

In computing and mathematics, a **number system** is a writing scheme for expressing numbers using digits or symbols in a consistent manner. Each system is characterized by its **base (radix)** – the number of unique digits it uses. The video reviewed various number systems, since understanding them (especially binary) is crucial for grasping bitwise operations. The main number systems discussed were:

* **Decimal (Base-10):** This is the standard system we use in daily life, with digits 0-9. Base-10 means each place value is a power of 10\. For example, the decimal number \` 407 \` means 4102+0101+7100=400+0+7 . Decimal was referred to as the familiar system we learned as children (counting 1,2,3,…). It has ten symbols (0 through 9).

* **Binary (Base-2):** Uses only two digits: 0 and 1. Each binary place value is a power of 2\. For example, binary 1010₂ represents 123+022+121+020=8+0+2+0=10 in decimal. The video stressed that computers operate in binary – all data and instructions ultimately convert to binary (machine code). Binary numbers were illustrated (e.g., counting in binary: 0001₂ is 1, 0010₂ is 2, 0011₂ is 3, 0100₂ is 4, etc.). It was noted that binary’s base (2) implies each digit is a bit that can only be 0 or 1 (often interpreted as False/True or Off/On in logical terms).

* **Octal (Base-8):** Uses digits 0-7. Each place is a power of 8\. Octal used to be more common in early computing. It groups binary digits into groups of three (since 8 \= 2^3, one octal digit represents exactly three binary bits). For example, binary 11010110₂ can be grouped as 11 010 110 (from right, pad leftmost with 0 if needed) \= 3 2 6 in octal, meaning the binary number equals 326₈. The transcript briefly touched on octal; for instance, numbers like 021₈ or 307₈ might have been mentioned, and it may have been noted that some programming languages denote octal with a leading 0\. Octal is less commonly used today but is conceptually similar to hex in grouping bits.

* **Hexadecimal (Base-16):** Uses digits 0-9 and letters A-F (where A\=10, B\=11, ... F\=15). Each hex digit corresponds to a 4-bit binary group (since 16 \= 2^4). This makes hex a convenient shorthand for binary data. For example, the binary 1111 1010₂ can be written as FA₁₆ (F for 1111 and A for 1010). The video mentioned that programming and computer science often use base-16 for representing large binary values succinctly (such as memory addresses or color codes). It likely described how 0x prefix is used in code (e.g., 0x1A3 for a hex literal), and that **16 total symbols** are used (0-9, A-F).

**Key point:** All these systems represent the *same numbers* but with different bases. For example, the decimal number 15 can be represented as 17₈ in octal, F₁₆ in hex, or 1111₂ in binary. The transcript reinforced understanding binary in particular, since bitwise operations require comfort with binary digits. It also pointed out that **leading zeros** don’t change a number’s value (e.g., 0123₁₀ is the same as 123₁₀), which applies to all bases.

## Number System Conversion

Being able to convert numbers between different bases is an important skill. The session provided methods to convert between decimal and other bases (especially binary). Key conversion techniques include:

* **Converting from Decimal to Binary (or any other base):**  
  Use the **repeated division and remainder method**:

* Divide the decimal number by the target base (2 for binary, 8 for octal, 16 for hex, etc.).

* Record the **remainder** – this will be the least significant digit in the new base.

* Divide the quotient again by the base, record the remainder as the next digit.

* Continue this process until the quotient becomes 0\. The base-n digits of the number are the remainders collected, read in **reverse order** (from last division to first).  
  *Example (Decimal to Binary):* Convert 👉 **19 (decimal) to binary**.

* 19 ÷ 2 \= 9 remainder **1** (LSB)

* 9 ÷ 2 \= 4 remainder **1**

* 4 ÷ 2 \= 2 remainder **0**

* 2 ÷ 2 \= 1 remainder **0**

* 1 ÷ 2 \= 0 remainder **1** (MSB)  
  Now read remainders from bottom to top: **10011₂**. Indeed, $1\\\*2^4 \+ 0\\\*2^3 \+ 0\\\*2^2 \+ 1\\\*2^1 \+ 1\\\*2^0 \= 16+0+0+2+1 \= 19$ . The transcript stepped through such an example (dividing and tracking remainders) to demonstrate binary conversion.  
  *Example (Decimal to Hex):* Convert 👉 **255 (decimal) to hex**.

* 255 ÷ 16 \= 15 remainder **15**. (Remainder 15 in hex is F.)

* 15 ÷ 16 \= 0 remainder **15**.  
  Reading remainders backward gives **FF₁₆**. Indeed 0xFF is 255 decimal.  
  This method works for any base: use 8 for octal, etc., always reading the remainders in reverse. The video likely worked through at least a binary example using this algorithm.

* **Converting from Binary/Other Base to Decimal:**  
  Use the **positional value method**:

* Write down the digits of the number in the original base.

* Starting from the least significant digit (rightmost), multiply each digit by the base raised to the power of its position index (counting from 0).

* Sum all these values to get the decimal equivalent.  
  *Example (Binary to Decimal):* Convert 👉 **10011₂ to decimal**.

* Starting from rightmost bit: 120=1 .

* Next bit (from right): 121=2 .

* Next: 022=0 .

* Next: 023=0 .

* Next (leftmost): 124=16 .  
  Sum \= 16+0+0+2+1=19 . So 10011₂ \= 19₁₀.  
  *Example (Hex to Decimal):* Convert 👉 **7A₁₆ to decimal**.

* A in hex \= 10 in decimal. So A160=101=10 .

* 7 is 7\. So 7161=716=112 .  
  Sum \= 112+10=122 . Thus 7A₁₆ \= 122₁₀.  
  This positional expansion method was illustrated in the talk to ensure understanding of what each digit means in a given base (e.g., why in decimal the number 305 means 3102+0101+5100 ).

* **Converting Directly Between Binary and Hex/Octal:**  
  Although not heavily emphasized, it’s useful to know that conversion between bases that are powers of each other is quick:

* **Binary ⟷ Octal:** Group binary in sets of 3 bits (since 23=8 ). For example, 101011₁₂ can be grouped as 010 101 1 (pad left with 0 if needed to form groups of 3: 010 101 001) \= 2 5 1 in octal, so 101011₂ \= 251₈.

* **Binary ⟷ Hex:** Group binary in sets of 4 bits (since 24=16 ). e.g., 10110110₂ grouped as 1011 0110 \= B6₁₆ (since 1011₂ \= B and 0110₂ \= 6). This gives a quick way to interpret binary in hex or vice versa without doing long division.  
  The transcript likely noted how computers often use hexadecimal as a human-friendly representation of binary (each hex digit neatly represents 4 bits).

**Important points to remember:** The conversion methods above are general. A tip highlighted was that **to convert from any base to any other base, one reliable approach is to first convert to decimal (as an intermediate), then from decimal to the target base**. This two-step method works for arbitrary bases if you don’t have a direct technique. However, direct base conversions can be optimized when bases are related (like binary/octal/hex). The session included practice questions on conversion to ensure these concepts were clear.

## Negative Binary Numbers

When the concept of **negative numbers** in binary was introduced, the key challenge addressed was how to represent a negative value using only 0s and 1s. In ordinary arithmetic we use a minus sign, but in binary computer systems, we need a way to encode negativity in the bit pattern itself. The solution used universally in modern computers is the **two’s complement** representation. The video emphasized understanding two’s complement, as it’s crucial for how computers store signed integers and for how bitwise operations behave on negative numbers.

* **Sign Bit:** In a fixed-width binary representation (e.g., 8-bit, 16-bit, etc.), the **most significant bit (MSB)** is dedicated as a **sign bit** in signed representations. Typically, by convention:  
  0 in the MSB indicates the number is **positive** (or zero),  
  1 in the MSB indicates the number is **negative**.  
  For example, in an 8-bit two’s complement system, 0110 0101₂ (MSB 0\) is \+101, whereas 1110 0101₂ (MSB 1\) would represent a negative number. The transcript highlighted this crucial point: *if the leftmost bit is 1, the number is considered negative, if 0, it’s non-negative*.

* **Two’s Complement Representation:** To get the binary for a negative integer, two’s complement defines a method:

* **Start with the positive version** of the number in binary (absolute magnitude). e.g., for \-10, start with \+10. \+10 in an 8-bit binary is 0000 1010₂.

* **Invert all the bits** (flip 0→1 and 1→0). This gives the one’s complement. For 00001010₂, the one’s complement is 1111 0101₂.

* **Add 1** to this inverted result. That final result is the two’s complement (negative representation). Continuing the example: 1111 0101₂ \+ 1₂ \= **1111 0110₂**. This is the 8-bit two’s complement representation of \-10.  
  The video went through an example like the above, showing step-by-step how a negative binary number is obtained. The resulting binary for \-10 (11110110₂ in 8 bits) was presented and verified. One can check that this works by adding it to \+10’s binary: 00001010₂ \+ 11110110₂ yields 1 0000 0000₂ (which in 9 bits looks like 512, but in 8-bit arithmetic the overflow is discarded, resulting in 0 – indicating that 11110110₂ indeed behaves as \-10).

* **Interpreting a Two’s Complement Number:** The value of a binary number with sign bit 1 can be found by the formula: for an N-bit number, if the MSB is 1, the value \= −2N−1+ (value of the remaining bits). For instance, 11110110₂ in 8 bits can be calculated as −27+1\*26+1\*25+1\*24+0\*23+1\*22+1\*21+0\*20 . This equals −128+64+32+16+0+4+2+0=−128+118=−10 . This matches the result we got by construction. The transcript pointed out that the **most significant bit carries a negative weight** in two’s complement, which is why the range of negatives goes one further than positives (since \-128 can be represented but \+128 cannot in 8 bits – more on range below).

* **Advantages of Two’s Complement:** The video likely mentioned why two’s complement is used over other methods (like sign-magnitude or one’s complement): arithmetic operations become simpler at the hardware level. For example, addition and subtraction can use the same binary adder circuit for both positive and negative values, and there’s only one representation of zero (no “+0” and “-0” separate issues). In two’s complement, 0000 0000₂ is zero, and if you invert and add one you get the same back, so there’s no distinct \-0; **zero has a unique representation**. (In contrast, a simple sign-bit representation would have two zeros, which is undesirable.)

* **Observation – Sign Extension:** If you increase the bit-width of a two’s complement number (say from 8-bit to 16-bit), you must **extend the sign bit** (fill the new left bits with copies of the original MSB) to keep the value the same. For example, \-10 (8-bit 11110110₂) in 16-bit becomes 1111 1111 1111 0110₂. This is called sign extension and ensures the number’s value doesn’t change with more bits. If you mistakenly filled with 0s, the number would turn positive. This concept is important when moving between data types, though it might have been only briefly touched upon.

In summary, **two’s complement** is the standard for representing negative binary numbers. The session’s key takeaways were knowing how to compute it (invert bits, add one) and understanding that the leftmost bit denotes sign (1 \= negative). A demonstration confirmed, for example, that when you add a negative and its corresponding positive binary, the result correctly wraps around (due to overflow) to zero, validating the representation.

## Range of Representable Numbers (and Overflow)

With a fixed number of bits, there are limits to the integers that can be represented. The lecture addressed this by giving formulas and examples for the range of values for unsigned and signed integers in N bits:

* **Unsigned N-bit integer:** Can represent values from **0** up to 2N−1 . This range includes only non-negative numbers. For example, with 8 bits, you get 28=256 distinct values, ranging 0 through 255\. In binary that’s 0000 0000₂ (0) to 1111 1111₂ (255). All combinations are used for non-negative values.

* **Signed N-bit integer (two’s complement):** Can represent values from −2N−1 up to 2N−1−1 . This splits the 2^N combinations into roughly half negative and half non-negative (with one extra skew toward negatives because of the asymmetry of having only one zero). For example, with 8 bits:

* The **minimum** representable value is −27=−128 (binary 1000 0000₂).

* The **maximum** representable value is 27−1=127 (binary 0111 1111₂).  
  That gives 128 negative numbers (from \-128 up to \-1) and 128 non-negatives (0 up to 127), totaling 256 combinations as expected. The transcript explicitly enumerated this for 8 bits: it mentioned something along the lines of “128 numbers on the negative side and 128 on the positive side (including zero)”. It was stressed that if you try to go beyond these limits, **overflow** occurs (the value wraps around mod 2^N). For instance, 127 \+ 1 in 8-bit arithmetic wraps to \-128. This is why 8-bit signed can’t represent 128 – adding 1 to 127 (01111111₂) yields 10000000₂, which is \-128 in two’s complement.

* **General formulas:** The lecture provided a formula to find the range quickly:

* **Max positive:** 2N−1−1

* **Min negative:** −2N−1  
  This formula was highlighted as something to remember. For example, for 16-bit signed: min \= \-32768, max \= 32767\. For a 32-bit signed int: min \= \-2,147,483,648, max \= 2,147,483,647. One can double-check by noting one more negative than positive count (because of the zero issue).

* **Why the asymmetry?** Because zero is counted in with positives in two’s complement. There’s no “+0” and “-0” separately, so the negative side gets an extra number. Using 8-bit again, negatives: \-128...-1 (128 values), positives: 1...127 plus zero (127 \+ 1 values \= 128 values). So total 256\. The video pointed this out when explaining the distribution.

Understanding these ranges is important to avoid overflow errors. The session likely gave an example scenario or interview question asking for the range or what happens on overflow. For instance, one could be asked: “What’s the result of adding 1 to the maximum 8-bit signed number?” (Answer: it wraps to \-128 due to overflow). The notes reinforced that in two’s complement, arithmetic seamlessly wraps around modulo 2^N (which is convenient for hardware, though it can be a logic bug in programming if you’re not careful). Knowing the representable range allows one to detect overflow conditions or reason about bitwise limits.
