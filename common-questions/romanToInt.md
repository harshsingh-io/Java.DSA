

The loop logic in the Roman to Integer solution works by checking each character's value against the next character to determine if subtraction is needed. Here's a step-by-step explanation using the example **"MCMXCIV"** (which converts to 1994):

### Loop Logic Explanation

*   **Lookup Table**: Maps each Roman character to its value (e.g., `'I'` = 1, `'M'` = 1000).
    
*   **Result Accumulation**: The result starts at 0 and is adjusted during each iteration based on the current and next characters.
    

### Example Walk-Through

<table>
   <thead>
      <tr>
         <th>Index (i)</th>
         <th>Current Character</th>
         <th>Next Character</th>
         <th>Current Value (Current)</th>
         <th>Next Value (Next)</th>
         <th>Logic</th>
         <th class="">Result Update</th>
      </tr>
   </thead>
   <tbody>
      <tr>
         <td class="">0</td>
         <td class=""><code data-v-d3e67ab0="" data-v-010c3103="" class="segment-code-inline">M</code></td>
         <td class=""><code data-v-d3e67ab0="" data-v-010c3103="" class="segment-code-inline">C</code></td>
         <td class="">1000</td>
         <td class="">100</td>
         <td class="">1000 &gt; 100 → <strong class="">Add</strong> 1000</td>
         <td class="">1000</td>
      </tr>
      <tr>
         <td class="">1</td>
         <td class=""><code data-v-d3e67ab0="" data-v-010c3103="" class="segment-code-inline">C</code></td>
         <td class=""><code data-v-d3e67ab0="" data-v-010c3103="" class="segment-code-inline">M</code></td>
         <td class="">100</td>
         <td class="">1000</td>
         <td class="">100 &lt; 1000 → <strong class="">Subtract</strong> 100</td>
         <td class="">900</td>
      </tr>
      <tr>
         <td class="">2</td>
         <td class=""><code data-v-d3e67ab0="" data-v-010c3103="" class="segment-code-inline">M</code></td>
         <td class=""><code data-v-d3e67ab0="" data-v-010c3103="" class="segment-code-inline">X</code></td>
         <td>1000</td>
         <td class="">10</td>
         <td class="">1000 &gt; 10 → <strong class="">Add</strong> 1000</td>
         <td class="">1900</td>
      </tr>
      <tr>
         <td class="">3</td>
         <td class=""><code data-v-d3e67ab0="" data-v-010c3103="" class="segment-code-inline">X</code></td>
         <td class=""><code data-v-d3e67ab0="" data-v-010c3103="" class="segment-code-inline">C</code></td>
         <td class="">10</td>
         <td class="">100</td>
         <td class="">10 &lt; 100 → <strong class="">Subtract</strong> 10</td>
         <td class="">1890</td>
      </tr>
      <tr>
         <td class="">4</td>
         <td class=""><code data-v-d3e67ab0="" data-v-010c3103="" class="segment-code-inline">C</code></td>
         <td class=""><code data-v-d3e67ab0="" data-v-010c3103="" class="segment-code-inline">I</code></td>
         <td class="">100</td>
         <td class="">1</td>
         <td class="">100 &gt; 1 → <strong class="">Add</strong> 100</td>
         <td class="">1990</td>
      </tr>
      <tr>
         <td class="">5</td>
         <td class=""><code data-v-d3e67ab0="" data-v-010c3103="" class="segment-code-inline">I</code></td>
         <td class=""><code data-v-d3e67ab0="" data-v-010c3103="" class="segment-code-inline">V</code></td>
         <td class="">1</td>
         <td class="">5</td>
         <td class="">1 &lt; 5 → <strong class="">Subtract</strong> 1</td>
         <td class="">1989</td>
      </tr>
      <tr>
         <td class="">6</td>
         <td class=""><code data-v-d3e67ab0="" data-v-010c3103="" class="segment-code-inline">V</code></td>
         <td class="">-</td>
         <td class="">5</td>
         <td>-</td>
         <td class="">No next → <strong class="">Add</strong> 5</td>
         <td class="">1994</td>
      </tr>
   </tbody>
</table>

### Key Insights

1.  **Subtraction Check**: For each character, compare its value with the next character's value.
    
    *   If the current value is **less than** the next, it means a subtractive pair (e.g., `IV` → 4), so **subtract** the current value.
        
    *   Otherwise, **add** the current value.
        
2.  **Accumulation**:
    
    *   Subtraction is handled by **subtracting** the current value (temporarily reducing the result), which is later **compensated** by adding the next (larger) value.
        
    *   For example, `IV` → subtract 1 (result becomes -1), then add 5 (result becomes 4).
        
3.  **Efficiency**: The loop processes each character once, resulting in **O(n)** time complexity with **O(1)** space complexity.
    

This approach ensures that all subtractive pairs (like `CM`, `XC`, `IV`) are handled implicitly without explicit conditionals for each case, leading to cleaner and more maintainable code.