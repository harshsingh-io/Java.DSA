public class OofNSortedArray {
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void sortedArray(int[] arr){
        for(int i = 0; i<arr.length;i++){
            if (arr[i] == i + 1) {
                i++;
            }

        }
    }
    public static void main(String[] args) {
        int[] arr = {5,4,1,3,2};
        printArray(arr);
    }
}
