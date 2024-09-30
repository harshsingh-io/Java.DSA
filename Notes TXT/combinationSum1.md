![Recursion Tree](https://lh4.googleusercontent.com/U5JtSW7Y521CQwZ88XkFdkY10h6uWeLVGNt9p6qTE4YpAWUwZhSzrThEg5iGs6EMVCgpE00Q0ilJY_Plu8CIalZ33zwu1hS0645TIE70h4LTKGisF9dx2lA6jzMykPG5NbD6SPmo)

![Second Option](https://lh5.googleusercontent.com/Twqm92pZ90YWndETQxdFF4_1ycJ9OYBHUbGXXSY5ofhx1cV28EJ8YIfgmaUOWZ0pmYl1C_l6SkAsKYp7FAFC_7EQyhxSTrG34599mc7_MBbj5ip9tlTxgf6eJgow7taijc6Sj7nY)

```
class Solution {
    /**
     * Recursive method to find all unique combinations in arr that add up to the target sum.
     * 
     * @param arr the array of candidates numbers to use in combinations
     * @param target the remaining target sum after choosing some candidates
     * @param i the current index in the array to consider for inclusion in the current combination
     * @param current the current combination of numbers that adds up to the original target minus the remaining target
     * @param ans the list of all unique combinations that sum up to the original target
     */
    public void combSum(int[] arr, int target, int i, List<Integer> current, List<List<Integer>> ans) {
        // Base case: if we've considered all elements
        if (i == arr.length) {
            // If the remaining target is 0, current combination is valid
            if (target == 0) {
                ans.add(new ArrayList<>(current)); // Add a copy of the current list to the results
                return;
            } else {
                return; // Current path does not lead to a solution, return
            }
        }

        // Recursive case: try to include arr[i] in the combination if it does not exceed the remaining target
        if (arr[i] <= target) {
            current.add(arr[i]); // Include the current element in the combination
            // Recurse with reduced target and the same index (i) to consider the element multiple times
            combSum(arr, target - arr[i], i, current, ans);
            // Backtrack: remove the last element added and try the next possibility
            current.remove(current.size() - 1);
        }

        // Move to the next element in the array
        combSum(arr, target, i + 1, current, ans);
    }

    /**
     * Public method to return all unique combinations in candidates that sum up to the target.
     * 
     * @param candidates array of numbers that candidates can use to form combinations
     * @param target target sum for the combinations
     * @return list of all unique combinations that sum to the target
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>(); // Initialize the list of results
        // Start recursive combination search
        combSum(candidates, target, 0, new ArrayList<Integer>(), ans);
        return ans; // Return all found combinations
    }
}

```