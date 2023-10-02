import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumAndValue {
    //function ot find the max and value
    public static int maxAND (int[] arr, int N) {
        int ans=0;
        //iterating bit by bit from left to right(MSB to LSB)
        for(int i=18;i>=0;i--){
            //Setting each bit of answer to 1 and checking in the array
            // have the same bit set at that i-th position
            int x=ans|(1<<i);// setting i-th bit to 1
            int c=check(arr,N,x); // counting the number of elements that have the same bit set

            // If at least two elements have the i-th bit set to 1, update the answer
            if(c>=2){
                ans=x;
            }
        }

        return ans;
    }

    //function to count the number of elements in the array with same bit set
    public static int check(int[] arr,int n,int num) {
        int count = 0;
        //iterating through each element in the array
        for (int i = 0; i < n; i++) {
            if ((arr[i] & num) == num) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        // using buffered reader to deal with large number of test cases
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine().trim());// reading the number of test cases
        // iterating through each test case
        while(t-->0){
            //input size of the array
            int n = Integer.parseInt(bufferedReader.readLine());
            String[] inputLine = bufferedReader.readLine().trim().split(" ");
            int[] arr = new int[n];
            //write the elements inside the array
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            //printing the final output
            System.out.println(maxAND(arr,arr.length));


        }


    }
}
