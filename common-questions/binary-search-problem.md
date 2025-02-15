# Binary Search Problems Categorized

## Type 1 (Some ad-hoc Binary Search Problems)

* [Order-agnostic Binary Search](https://www.geeksforgeeks.org/order-agnostic-binary-search/)
* [Search Insert Position](https://leetcode.com/problems/search-insert-position/)
* [Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/)
* [Sqrt(x)](https://leetcode.com/problems/sqrtx/)
* [Two Sum II - Input array is sorted (IMP)](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
* [Two Sum Less Than K](https://leetcode.com/problems/two-sum-less-than-k/)
* [Count Numbers with Difference between Number and Digit Sum Greater Than Specific Value](https://www.geeksforgeeks.org/count-numbers-difference-number-digit-sum-greater-specific-value/)
* [Median of Two Sorted Arrays (HARD)](https://leetcode.com/problems/median-of-two-sorted-arrays/)

---

## Type 2 (Understanding Lower Bound and Upper Bound)

Implement lower_bound and upper_bound functions of C++ on your own.  
Problems:  
* [First Bad Version](https://leetcode.com/problems/first-bad-version/)
* [Find First and Last Position of Element in Sorted Array](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)
* [Ceiling in a Sorted Array](https://www.geeksforgeeks.org/ceiling-in-a-sorted-array/)
* [H-Index II](https://leetcode.com/problems/h-index-ii/)

---

## Type 3 (Find the pivot first, and then search)

**N.B** - Whenever there is a rotated or a mountain array and we need to search in that array. First find the inflection point i.e the peak element in case of mountain array or min element or pivot in case of rotated array. This makes our search much easier though we have to do two binary searches.  
Problems:  
* [Find Peak Element](https://leetcode.com/problems/find-peak-element/)
* [Find in Mountain Array](https://leetcode.com/problems/find-in-mountain-array/)
* [Find Minimum in Rotated Sorted Array](https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
* [Search in Rotated Sorted Array](https://leetcode.com/problems/search-in-rotated-sorted-array/)

---

## Type 4 (Binary Search on a row-wise sorted Matrix)

Problems:  
* [Search a 2D Matrix II](https://leetcode.com/problems/search-a-2d-matrix-ii/)
* [Find Median in a Row-wise Sorted Matrix](https://www.geeksforgeeks.org/find-median-row-wise-sorted-matrix/)

---

## Type 5 (Minimizing the Maximum or maximizing the minimum)

Problems:  
* [Capacity to Ship Packages Within D Days](https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/)
* [Split Array Largest Sum](https://leetcode.com/problems/split-array-largest-sum/)
* [Divide Chocolate](https://leetcode.com/problems/divide-chocolate/)
* [Painter's Partition Problem](https://www.interviewbit.com/problems/painters-partition-problem/)
* [Allocate Minimum Number of Pages](https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1/)
* [Aggressive Cows](https://www.spoj.com/problems/AGGRCOW/)
* [Minimize Max Distance to Gas Station](https://leetcode.com/problems/minimize-max-distance-to-gas-station/)
* [Path With Minimum Effort](https://leetcode.com/problems/path-with-minimum-effort/)
* [Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/)

---

### Some things to remember

* While finding mid, always use `lo + (hi - lo) / 2`, and not `(hi + lo) / 2`.
* Normally Binary Search is done on Arrays, and not LinkedLists.
* Be careful of TLE. (if your implementation is faulty)
