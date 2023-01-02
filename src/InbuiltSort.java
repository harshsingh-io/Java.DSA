import java.util.Arrays;

public class InbuiltSort {
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] array = {9,7,9,5,2,5,3,4};
//        array sorting in ascending order
//        Arrays.sort(array);
        printArray(array);
        Arrays.sort(array, 0,4);
        printArray(array);

    }
}
