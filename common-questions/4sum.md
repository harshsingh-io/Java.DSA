### Notes: 4Sum Problem Solution 

#### **Problem Statement**

*   **Goal**:
    
    *   Given an array of integers, find **all unique quadruplets** (4 indices) whose sum equals a target value.
        
    *   Example:
        
        *   Array: `[-1, 0, 1, 2, -1, -4]`, Target: `0`.
            
        *   Valid quadruplets: `[-1, -1, 2, 0]`, `[0, 0, -1, 1]`, etc.
            
    *   Constraints:
        
        *   Indices must be unique.
            
        *   Return all unique quadruplets (sorted).
            

* * *

#### **Brute Force Approach**

*   **Method**:
    
    *   Use **4 nested loops** to generate all possible quadruplets.
        
    *   Store valid quadruplets in a **set** to avoid duplicates.
        
*   **Code Steps**:
    
    *   Iterate over all combinations of indices `i, j, k, l`.
        
    *   Calculate the sum: `nums[i] + nums[j] + nums[k] + nums[l]`.
        
    *   If sum equals target, store the sorted quadruplet in a set.
        
*   **Complexity**:
    
    *   **Time**: O(n4) (4 nested loops).
        
    *   **Space**: O(n) (set for storing quadruplets).
        

* * *

#### **Better Approach**

*   **Optimization**:
    
    *   Reduce complexity by fixing 3 indices (`i, j, k`) and using a **hash set** to find the 4th element.
        
*   **Steps**:
    
    *   Iterate with 3 loops for `i, j, k`.
        
    *   Calculate the required 4th element: `target - (nums[i] + nums[j] + nums[k])`.
        
    *   Use a hash set to check if the 4th element exists in the subarray `j+1` to `k-1`.
        
*   **Complexity**:
    
    *   **Time**: O(n3) (3 loops + hash lookups).
        
    *   **Space**: O(n) (hash set + result storage).
        

* * *

#### **Optimal Approach**

*   **Two-Pointer Technique**:
    
    *   **Sort the array** first to handle duplicates and enable two-pointer traversal.
        
    *   Fix `i` and `j`, then use two pointers (`k` and `l`) to find the remaining two elements.
        
*   **Handling Duplicates**:
    
    *   Skip duplicate values by comparing with previous elements for `i`, `j`, `k`, and `l`.
        
*   **Steps**:
    
    1.  Sort the array.
        
    2.  Iterate `i` from `0` to `n-4`.
        
    3.  For each `i`, iterate `j` from `i+1` to `n-3`.
        
    4.  Initialize `k = j+1` and `l = n-1`.
        
    5.  While `k < l`:
        
        *   Calculate sum: `nums[i] + nums[j] + nums[k] + nums[l]`.
            
        *   If sum == target, add `[nums[i], nums[j], nums[k], nums[l]]` to the result.
            
        *   Move `k` and `l` pointers while skipping duplicates.
            
    6.  Return the result.
        
*   **Complexity**:
    
    *   **Time**: O(n3) (3 nested loops + two-pointer traversal).
        
    *   **Space**: O(1) (in-place, excluding result storage).
        

* * *

#### **Code Implementation**

*   **Key Code Snippets**:
    
    ```java
    import java.util.*;

    public class tUf {
        public static List<List<Integer>> fourSum(int[] nums, int target) {
            int n = nums.length; // size of the array
            List<List<Integer>> ans = new ArrayList<>();

            // sort the given array:
            Arrays.sort(nums);

            // calculating the quadruplets:
            for (int i = 0; i < n; i++) {
                // avoid the duplicates while moving i:
                if (i > 0 && nums[i] == nums[i - 1]) continue;
                for (int j = i + 1; j < n; j++) {
                    // avoid the duplicates while moving j:
                    if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                    // 2 pointers:
                    int k = j + 1;
                    int l = n - 1;
                    while (k < l) {
                        long sum = nums[i];
                        sum += nums[j];
                        sum += nums[k];
                        sum += nums[l];
                        if (sum == target) {
                            List<Integer> temp = new ArrayList<>();
                            temp.add(nums[i]);
                            temp.add(nums[j]);
                            temp.add(nums[k]);
                            temp.add(nums[l]);
                            ans.add(temp);
                            k++;
                            l--;

                            // skip the duplicates:
                            while (k < l && nums[k] == nums[k - 1]) k++;
                            while (k < l && nums[l] == nums[l + 1]) l--;
                        } else if (sum < target) k++;
                        else l--;
                    }
                }
            }

            return ans;
        }

        public static void main(String[] args) {
            int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
            int target = 9;
            List<List<Integer>> ans = fourSum(nums, target);
            System.out.println("The quadruplets are: ");
            for (List<Integer> it : ans) {
                System.out.print("[");
                for (int ele : it) {
                    System.out.print(ele + " ");
                }
                System.out.print("] ");
            }
            System.out.println();
        }
    }
    ```

* * *

#### **Complexity Analysis**

*   **Brute Force**:
    
    *   Time: O(n4), Space: O(n).
        
*   **Better Approach**:
    
    *   Time: O(n3), Space: O(n).
        
*   **Optimal Approach**:
    
    *   Time: O(n3), Space: O(1).
        

* * *

#### **Final Notes**

*   **Key Takeaways**:
    
    *   Sorting the array is critical for optimizing and avoiding duplicates.
        
    *   Two-pointer technique reduces complexity from O(n4) to O(n3).
        
    *   Always skip duplicates by comparing with previous elements.
        
*   **Next Steps**:
    
    *   Practice similar problems (e.g., 3Sum, 5Sum).
        
