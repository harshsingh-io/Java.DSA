class Solution {
    public int[] selectionSort(int[] nums) {
        /*
        Selection sort is a sorting algorithm that sorts an array by repeatedly finding
        the minimum element from the unsorted part and putting it at the beginning.
        
        Approach:
        1. Run an outer loop with a pointer 'i' from the start to the second-to-last
           element. This pointer 'i' marks the boundary of the sorted part of the array.
        2. Assume the element at the current position 'i' is the smallest in the
           unsorted part. So, we'll create a variable 'min_idx' and store 'i' in it.
        3. Now, run an inner loop with a pointer 'j' from the next element (i + 1)
           to the end of the array. This loop will search for the actual smallest element.
        4. Inside the inner loop, compare the element at 'j' with the element at 'min_idx'.
        5. If the element at 'j' is smaller, it means we have found a new minimum. So,
           we update 'min_idx' to hold the index 'j'.
        6. After the inner loop finishes, 'min_idx' will point to the smallest element
           in the unsorted part of the array.
        7. Finally, swap the element at position 'i' with the element at 'min_idx'. This
           moves the smallest element to its correct, sorted position.
        8. The outer loop continues, and the sorted part of the array grows by one
           element in each step.

        Dry Run with [7, 4, 1, 5, 3]:
        ----------------------------------
        i = 0: min_idx starts as 0.
          j=1: nums[1](4) < nums[0](7) -> true. min_idx becomes 1.
          j=2: nums[2](1) < nums[1](4) -> true. min_idx becomes 2.
          j=3: nums[3](5) < nums[2](1) -> false.
          j=4: nums[4](3) < nums[2](1) -> false.
        Inner loop ends. min_idx is 2. Swap nums[0] with nums[2].
        Array is now: [1, 4, 7, 5, 3]
        ---
        i = 1: min_idx starts as 1.
          j=2: nums[2](7) < nums[1](4) -> false.
          j=3: nums[3](5) < nums[1](4) -> false.
          j=4: nums[4](3) < nums[1](4) -> true. min_idx becomes 4.
        Inner loop ends. min_idx is 4. Swap nums[1] with nums[4].
        Array is now: [1, 3, 7, 5, 4]
        ---
        i = 2: min_idx starts as 2.
          j=3: nums[3](5) < nums[2](7) -> true. min_idx becomes 3.
          j=4: nums[4](4) < nums[3](5) -> true. min_idx becomes 4.
        Inner loop ends. min_idx is 4. Swap nums[2] with nums[4].
        Array is now: [1, 3, 4, 5, 7]
        ---
        i = 3: min_idx starts as 3.
          j=4: nums[4](7) < nums[3](5) -> false.
        Inner loop ends. min_idx is 3. Swap nums[3] with nums[3] (no change).
        Array is now: [1, 3, 4, 5, 7]
        ---
        Outer loop finishes. Array is sorted.
        */

        for (int i = 0; i < nums.length - 1; i++) {
            // Assume the current element is the minimum
            int min_idx = i;
            
            // Find the index of the actual minimum element in the rest of the array
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min_idx]) {
                    min_idx = j;
                }
            }
            
            // Swap the found minimum element with the current element
            int temp = nums[i];
            nums[i] = nums[min_idx];
            nums[min_idx] = temp;
        }
        return nums;
    }
}