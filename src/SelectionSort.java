public class SelectionSort {
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void swap(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void selectionSort(int[] array){
        for(int i = 0; i < array.length-1; i++){
            int min = i;
            for(int j = i+1;j <array.length; j++){
                if (array[j]<array[min]){
                    min = j;
                }
            }
            if(min!=i){
                swap(array, min, i);
            }
        }
    }
    public static void main(String[] args) {
    int[] array = {4,1,9,2,3,6};
    printArray(array);
    selectionSort(array);
    printArray(array);
    }
}
