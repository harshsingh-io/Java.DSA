![Logic](https://lh5.googleusercontent.com/f1diRM3f00UrQ5WvMCk2dgpAqvRUzDKA12KD9ofKACDADXYy7bVccUUyR5wpem_Ox1OWRIwaKts6c_WimDQDJ5swY3JNU3LyT3KrS5sYqZgqNGv6xCOjq-2naESqNTdwJfpHX3yR)

![Recursive Call](https://lh6.googleusercontent.com/xsb46oCfbNclHzkzuOZqiGDcST0giAlFSAjWC-FcXA4oYidD7n6DHq3qj4oJ4_qqSk4dzrozFM1V1yF5N237h5oo2rbQo3Y752QRDtZhyTGsEAz0_cEafV0V5uVF6kZmRpQbgetd)

```
class Solution {
    /**
     * Helper method to recursively find all unique combinations in the array that sum to the target.
     *
     * @param ind the current index in the array from which to consider elements for the current combination
     * @param arr the array of candidate numbers sorted to handle duplicates and facilitate the breaking condition
     * @param target the current target sum after choosing some elements
     * @param ans the list of all unique combinations that meet the target sum criteria
     * @param ds the current combination being built
     */
    static void findCombinations(int ind, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        // Base case: if the current combination meets the target, add a copy of it to the answer list and return
        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return;
        }

        // Explore the decision tree by considering all elements starting from the index 'ind'
        for (int i = ind; i < arr.length; i++) {
            // Skip duplicates to avoid generating duplicate combinations
            if (i > ind && arr[i] == arr[i - 1]) continue;
            // If the current element is greater than the remaining target, no need to proceed further
            if (arr[i] > target) break;

            ds.add(arr[i]); // Choose the current element
            // Recur to consider next elements starting from the next index
            findCombinations(i + 1, arr, target - arr[i], ans, ds);
            ds.remove(ds.size() - 1); // Backtrack to explore the next possible combination
        }
    }

    /**
     * Public method to find all unique combinations that sum up to a given target, where each number in candidates
     * may only be used once in the combination.
     *
     * @param candidates array of numbers that can be used to form combinations
     * @param target the target sum for the combinations
     * @return list of all unique combinations that sum to the target, considering each number can be used once
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>(); // Initialize the list of results
        Arrays.sort(candidates); // Sort the candidates array to facilitate the skipping of duplicates and early termination
        // Start recursive combination search with an empty decision list
        findCombinations(0, candidates, target, ans, new ArrayList<>());
        return ans; // Return all found combinations
    }
}

```