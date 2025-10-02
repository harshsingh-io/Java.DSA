public class Solution {
    /*
     * Merge Sort Algorithm
     * 
     * Merge Sort is a classic "Divide and Conquer" algorithm. It works in two main
     * phases:
     * splitting the array into smaller pieces and then merging them back together
     * in sorted order.
     * 
     * ---
     * 
     * 1. The Divide Phase
     * The array is recursively split in half until each sub-array contains only a
     * single element.
     * An array with one item is, by definition, already sorted.
     * 
     * Example with [5, 3, 4, 1, 2]:
     * - [5, 3, 4, 1, 2] is split into [5, 3, 4] and [1, 2]
     * - [5, 3, 4] is split into [5, 3] and [4]
     * - [5, 3] is split into [5] and [3]
     * - [1, 2] is split into [1] and [2]
     * - At the end of this phase, we have: [5] [3] [4] and `[1] [2]
     * 
     * [5, 3, 4, 1, 2]
     * / \
     * / \
     * [5, 3, 4] [1, 2]
     * / \ / \
     * / \ / \
     * [5, 3] [4] [1] [2]
     * / \
     * / \
     * [5] [3]
     * ---
     * 
     * 2. The Conquer (Merge) Phase
     * Now, we merge the sub-arrays back together. During the merge, we sort the
     * elements.
     * This is done by comparing the first elements of two adjacent sub-arrays and
     * placing
     * the smaller one into a temporary array.
     * 
     * Tracing the merge steps:
     * 
     * - Merge [5] and [3]:
     * - Compare 5 and 3. 3 is smaller.
     * - The result is the sorted array [3, 5].
     * 
     * - Merge [1] and [2]:
     * - Compare 1 and 2. 1 is smaller.
     * - The result is the sorted array [1, 2].
     * 
     * - Merge [3, 5] and [4]:
     * - Compare 3 (from the first array) and 4 (from the second). 3 is smaller.
     * - Compare 5 and 4. 4 is smaller.
     * - The first array has one remaining element, 5, which is added to the end.
     * - The result is [3, 4, 5].
     * 
     * - Final Merge: [3, 4, 5] and [1, 2]:
     * - Compare 3 and 1. 1 is smaller. Temp array: [1]
     * - Compare 3 and 2. 2 is smaller. Temp array: [1, 2]
     * - The second array is now empty. The rest of the first array [3, 4, 5] is
     * added.
     * - Final sorted array: [1, 2, 3, 4, 5]
     */
    public static int[] mergerSortHelper(int start, int end, int[] nums) {
        if (start == end) {
            return new int[] { nums[start] };
        }
        int mid = (start + end) / 2;
        // Left subtree
        int[] left = mergerSortHelper(start, mid, nums);

        // Right subtree
        int[] right = mergerSortHelper(mid + 1, end, nums);

        int[] result = merge(left, right, start, end);
        return result;
    }

    public static int[] merge(int[] left, int[] right, int start, int end) {
        int leftPointer = 0;
        int rightPointer = 0;
        int[] temp = new int[left.length + right.length];
        int tempIdx = 0;
        while (leftPointer < left.length && rightPointer < right.length) {
            if (left[leftPointer] < right[rightPointer]) {
                temp[tempIdx] = left[leftPointer];
                leftPointer++;
            } else {
                temp[tempIdx] = right[rightPointer];
                rightPointer++;
            }
            tempIdx++;
        }
        while (rightPointer < right.length) {
            temp[tempIdx] = right[rightPointer];
            rightPointer++;
            tempIdx++;
        }
        while (leftPointer < left.length) {
            temp[tempIdx] = left[leftPointer];
            leftPointer++;
            tempIdx++;
        }
        return temp;
    }

    public static int[] mergeSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        return mergerSortHelper(0, nums.length - 1, nums);
    }

    public static void main(String[] args) {
        int[] nums = { 5, 3, 4, 1, 2 };
        nums = mergeSort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
}