public class SumOfSubArray {
    public static void printSumOfSubArrays(int numbers[]){
        // in outerloop we take starting point of subarray
        int sum = 0; //for sum of subarrays
        int compare = 0;
        int temp =0;
        for(int i = 0; i<numbers.length; i++){
            int start = i;
            for(int j = i; j<numbers.length; j++){
                int end = j;
                 // printing sub arrays from start to end in 'k' loop
                 for(int k = start;k<=end;k++ ){
                    System.out.print(numbers[k] + " ");
                }
                // printing sum of individual sub arrays from start to end in 'l' loop
                for(int l = start;l<=end;l++ ){
                    // here we add integers of sub array one by one
                    sum = sum + numbers[l];
                    //compare = sum;
                //for maximum and minimum
                    if(temp < sum){
                        compare = sum;
                    }
                    
                }
                //here we printed the sum which is derived from loop 'l'
            System.out.print("= " + sum);

            /*because the integer of previous sub array was getting added in the new one we made the sum variable zero
            so that we can add integer of current array initially*/
                sum = 0;
                System.out.println();
            }
            System.out.println();

        }
        System.out.println(compare);
    }
    public static void main(String[] args) {
        int numbers[] = {2,4,6,8,10};
        printSumOfSubArrays(numbers);
    }
}
