/* Bubble shorting is basically large element of an array come to the end of array by swapping with adjacent element
Bubble shorting can be done in ascending and descending order
array =5,4,1,3,2 and its size is n=5 and we will take no. turns which is 0,1,2,3(n-1)
in each turn we will go we will go from 0 index to n-1+turn index of array for checking
in 0th turn first element of the array will be compared with other elements adjacent \\ 5vs4\\5vs1\\5vs3\\5vs2
here in 0th turn array will become array = 4,1,3,2,5
in turn 1st first element of new array will be compared with other elements adjacent \\4vs1\\4vs3\\4vs2
here in 1st turn array will become array = 1,3,2,4,5
in turn 2nd first element of new array will be compared with other elements adjacent \\1vs3\\3vs2
here in 2nd turn array will become array = 1,2,3,4,5
in turn 3rd first element of new array will be compared with other elements adjacent \1vs2
here in 3rd turn array will become array = 1,2,3,4,5
for no. of turns we will create a loop which will start for 0 to n-2
for swapping in each turn adjacently we will create a inner loop from j=0 to n-2-turns
 */
public class BubbleShorting {
    public static void bubbleShort(int[] arr){
        for(int turn = 0 ; turn < arr.length-1; turn++){
//            to check the element is alreaady at right place and for better optimization of code we will
//            create a boolean and check if swapping doesn't happen then break;
            boolean swapped = false;
            for(int j = 0 ; j <= arr.length-2-turn; j++){
                if (arr[j] > arr[j+1]){
                    //swap
                    swapped = true;
                    swap(arr, j,j+1);
                }
            }
            if (!swapped){
                break;
            }
        }
    }
    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
    int arr[] = {5,4,1,3,2};
    printArray(arr);
    bubbleShort(arr);
    System.out.println("After shorting array's element by Bubble Shorting");
    printArray(arr);
    }
}
