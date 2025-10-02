class Solution {
    /*
    Explanation:
    This is a recursive version of the Bubble Sort algorithm. Instead of using two nested
    'for' loops, this approach uses the function's call stack to simulate the same process.
    One level of recursion handles the inner loop (comparing adjacent elements), and another
    level handles the outer loop (making multiple passes over the array). The largest
    elements still "bubble" up to the end with each complete pass.

    Recursive Approach:
    1. Base Case (Outer Loop): The main recursion stops when 'i' reaches 0. This means
       all passes over the array are complete, and the array is fully sorted.
    2. Inner Loop Recursion: The function calls itself with 'j+1' to move to the next
       pair of elements. This simulates the inner loop's job of comparing and swapping
       all adjacent elements in a single pass.
    3. End of a Pass (Inner Loop Base Case): When 'j' becomes equal to or greater than 'i',
       it means one full pass is complete. The largest element in that range is now at
       position 'i'.
    4. Next Pass (Outer Loop Recursion): After a pass is finished, the code starts the
       next pass by making a recursive call with 'i-1' (shrinking the unsorted part
       of the array) and resetting 'j' back to 0.

    DRY RUN:
    [7, 4, 1, 5, 3]
    ---
    i = 4: Initial call is bubbleSortHelper(4, 0, arr).
      - A series of "inner" recursive calls are made with j = 0, 1, 2, 3.
      - j=0: 7>4 -> swap. Array: [4, 7, 1, 5, 3]. Calls with j=1.
      - j=1: 7>1 -> swap. Array: [4, 1, 7, 5, 3]. Calls with j=2.
      - j=2: 7>5 -> swap. Array: [4, 1, 5, 7, 3]. Calls with j=3.
      - j=3: 7>3 -> swap. Array: [4, 1, 5, 3, 7]. Calls with j=4.
      - Now j=4. The condition 'j >= i' is met. This pass ends.
    Array is now: [4, 1, 5, 3, 7]
    - An "outer" recursive call is made for the next pass: bubbleSortHelper(3, 0, arr).
    ---
    i = 3:
      - The inner calls swap elements until the next largest (5) is at index 3.
    Array is now: [1, 4, 3, 5, 7]
    - An "outer" call is made: bubbleSortHelper(2, 0, arr).
    ---
    i = 2:
      - The inner calls continue.
    Array is now: [1, 3, 4, 5, 7]
    - An "outer" call is made: bubbleSortHelper(1, 0, arr).
    ---
    i = 1:
      - The inner calls find no swaps are needed.
    Array is now: [1, 3, 4, 5, 7]
    - An "outer" call is made: bubbleSortHelper(0, 0, arr).
    ---
    i = 0: The base case 'i == 0' is met, and the recursion stops.
    */
    public void bubbleSortHelper(int i, int j, int nums[]) {
        // Base Case for the outer loop: when all passes are done.
        if(i == 0) {
            return;
        }

        // When one full pass is complete, start the next pass.
        if(j >= i) {
            // "Outer" recursive call for the next pass (i-1).
            bubbleSortHelper(i-1, 0, nums);
            return;
        }

        // Compare adjacent elements and swap if needed.
        if(nums[j] > nums[j+1]) {
            int temp = nums[j];
            nums[j] = nums[j+1];
            nums[j+1] = temp;
        }
        
        // "Inner" recursive call to check the next pair (j+1).
        bubbleSortHelper(i, j+1, nums);
    }

    public void bubbleSort(int[] arr) {
        // Initial call to start the recursive process.
        bubbleSortHelper(arr.length-1, 0, arr);
    }
}