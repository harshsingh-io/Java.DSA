import java.util.Arrays;
import java.util.Collections;
public class InbuiltReverse {
    public static void printArray(Integer[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Integer[] array = {5,6,4,3,6,3,2,1};
//        Arrays.sort(array, Collections.reverseOrder());
        printArray(array);
        Arrays.sort(array,1,4, Collections.reverseOrder());
        printArray(array);

    }
}
