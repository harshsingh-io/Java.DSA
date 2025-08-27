class Solution {
    /*
    Explanation:
    Bubble Sort is a simple sorting algorithm that works by repeatedly stepping through the
    list to be sorted, comparing each pair of adjacent items, and swapping them if they
    are in the wrong order. The pass through the list is repeated until no swaps are
    needed, which indicates that the list is sorted. The algorithm gets its name because
    the largest elements "bubble" up to their correct position at the end of the array.

    Approach:
    1. Set up an outer loop ('i') that runs from the end of the array backwards to the
       second element. This loop controls how many passes we make over the array. After
       each pass, the largest element for that pass is in its final sorted position.
    2. Set up an inner loop ('j') that runs from the start of the array up to the 'i-1'.
       The boundary 'i' shrinks with each outer loop pass because the elements after 'i'
       are already sorted and in their final place.
    3. Inside the inner loop, compare the adjacent elements at 'j' and 'j+1'.
    4. If the element at 'j' is greater than the element at 'j+1', it means they are
       out of order. Swap them using a temporary variable.
    5. The inner loop completes one full pass, bubbling the largest element in the
       unsorted part to the boundary 'i'.
    6. The outer loop then continues with a smaller range, repeating the process until
       the entire array is sorted.

    DRY RUN:
    [7, 4, 1, 5, 3], n = 5
    i = 4, j = 0; 7>4 true: swap[4, 7, 1, 5, 3]
    i = 4, j = 1; 7>1 true: swap[4, 1, 7, 5, 3]
    i = 4, j = 2; 7>5 true: swap[4, 1, 5, 7, 3]
    i = 4, j = 3; 7>3 true: swap[4, 1, 5, 3, 7]

    [4, 1, 5, 3, 7]
    i = 3, j = 0, 4>1 true: swap[1, 4, 5, 3, 7]
    i = 3, j = 1, 4>5 false: noswap[1, 4, 5, 3, 7]
    i = 3, j = 2, 5>3 true: swap[1, 4, 3, 5, 7]

    [1, 4, 3, 5, 7]
    i = 2, j = 0, 1>4 false: noswap[1, 4, 3, 5, 7]
    i = 2, j = 1, 4>3 false: swap[1, 3, 4, 5, 7]

    [1, 3, 4, 5, 7]
    i = 1, j = 0, 1>3 false: noswap[1, 3, 4, 5, 7]   
    
    */
    public int[] bubbleSort(int[] nums) {
        for(int i = nums.length-1; i>0; i--) {
            boolean swapped = false; // Flag to check for swaps
            for(int j = 0; j < i; j++){
                if(nums[j]>nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    swapped = true; 
                }   
            }
            // If no swaps happened in this entire pass, the array is sorted.
            if (!swapped) {
                break;
            }
        }
        return nums;
    }
}