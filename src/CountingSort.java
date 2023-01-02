public class CountingSort {
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void countingSort(int[] array){
        int largest = Integer.MAX_VALUE;
        for (int i = 0 ; i<array.length;i++){
            largest = Math.max(largest,array[i]);

        }
        int count[] = new int[largest+1];
        for (int i=0;i<array.length;i++){
            count[array[i]]++;
        }
        //sorting
        int j = 0;
        for (int i = 0; i<array.length;i++){

        }
    }
    public static void main(String[] args) {
        int[] array = {5,6,4,3,1,2};
        countingSort(array);
        printArray(array);
    }
}
