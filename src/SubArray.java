public class SubArray {
    public static void printSubArrays(int numbers[]){
        // in outerloop we take starting point of subarray
        for(int i = 0; i<numbers.length; i++){
            int start = i;
            for(int j = i; j<numbers.length; j++){
                int end = j;
                // printing sub arrays from start to end in 'k' loop
                for(int k = start;k<=end;k++ ){
                    System.out.print(numbers[k] + " ");
                }
                System.out.println();
            }
            System.out.println();

        }
    }
    public static void main(String[] args) {
        int num[] = {2,4,6,8,10};
        printSubArrays(num);
    }
}