class Solution {
    /*
    Recursive Approach:
    1. Base Case (Outer Loop): The main recursion stops when our pointer 'i'
       goes past the end of the array. This means sorting is complete.
    2. Finding the Minimum (Inner Loop): Instead of a for-loop, the function calls
       itself to check the next element. 'j' moves forward (j+1) in each call
       to scan the rest of the array.
    3. Updating the Minimum: In each "inner" call, we check if the element at 'j'
       is smaller than our current minimum at 'min_idx'. If it is, we update
       'min_idx' to be the new 'j'.
    4. End of Inner Scan: When 'j' finally goes past the end of the array, our
       search for the minimum is over for this pass.
    5. Swap: Now that we have the final 'min_idx', we swap the element at the
       current outer position 'i' with the element at 'min_idx'.
    6. Next Pass (Outer Loop): We make one last recursive call to start the whole
       process over for the next element, 'i+1'.

    ---

    Dry Run with [7, 4, 1, 5, 3]:
    ----------------------------------
    i = 0: Initial call is selectionSort(0, 1, 0, arr).
      - Recursion for 'j' starts:
        - j=1: 4 < 7 is true. min_idx becomes 1. Calls with (i=0, j=2, min_idx=1).
        - j=2: 1 < 4 is true. min_idx becomes 2. Calls with (i=0, j=3, min_idx=2).
        - j=3: 5 < 1 is false. min_idx stays 2. Calls with (i=0, j=4, min_idx=2).
        - j=4: 3 < 1 is false. min_idx stays 2. Calls with (i=0, j=5, min_idx=2).
      - Now j=5, which is >= arr.length. The inner search ends.
      - Swap arr[0] (value 7) with arr[min_idx] which is arr[2] (value 1).
    Array is now: [1, 4, 7, 5, 3]
    - Make recursive call for the next outer pass: selectionSort(1, 1, 1, arr).
    ---
    i = 1: Current call is selectionSort(1, 1, 1, arr).
      - Recursion for 'j' starts:
        - j=1: 4 < 4 is false. min_idx stays 1.
        - ... j keeps increasing ...
        - j=4: 3 < 4 is true. min_idx becomes 4.
      - Now j=5, which is >= arr.length. The inner search ends.
      - Swap arr[1] (value 4) with arr[min_idx] which is arr[4] (value 3).
    Array is now: [1, 3, 7, 5, 4]
    - Make recursive call for the next outer pass: selectionSort(2, 2, 2, arr).
    ---
    i = 2:
      - Inner recursion finds the minimum value (4) at index 4. min_idx becomes 4.
      - Swap arr[2] (value 7) with arr[4] (value 4).
    Array is now: [1, 3, 4, 5, 7]
    - Make recursive call for the next outer pass: selectionSort(3, 3, 3, arr).
    ---
    i = 3:
      - Inner recursion finds the minimum value (5) is already at index 3. min_idx stays 3.
      - Swap arr[3] with arr[3]. (No change).
    Array is now: [1, 3, 4, 5, 7]
    ---
    The recursion continues until 'i' goes out of bounds, and the sorted array is returned.

    */
    public void selectionSort(int i, int j, int min_idx, int[] arr) {
        //Base Condition for the whole process (outer loop)
        if(i > arr.length-1) {
            return;
        }

        // When 'j' has scanned the whole array, do the swap and move to the next 'i'
        if(j >= arr.length) {
            int temp = arr[i];
            arr[i] = arr[min_idx];
            arr[min_idx] = temp;
            
            // Recursive call for the next outer pass
            selectionSort(i+1, i+1, i+1, arr);
            return;
        }

        // Check for new minimum
        if(arr[j] < arr[min_idx]) {
            min_idx = j;
            // Recursive call to continue scanning with 'j+1' (inner loop)
            selectionSort(i, j+1, min_idx, arr);
        } else {
            // Recursive call to continue scanning with 'j+1' (inner loop)
            selectionSort(i, j+1, min_idx, arr);
        }
    }
    
    public int[] sortArray(int[] nums) {
        // Initial call to start the process at i=0
        selectionSort(0, 1, 0, nums);
        return nums;
    }
}