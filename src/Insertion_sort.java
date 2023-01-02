public class Insertion_sort {
    public static void printArray(int[] arr){
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void insertionSort(int[] array){
        int temp;
        for(int i=1; i < array.length; i++){
            temp = array[i];
            /* By using forloop
            int j;
            for(j = i-1; j>=0 && array[j] > temp ; j--){
                    array[j+1] = array[j];
            }
             */
//            By using while loop
            int j= i-1;
            while(j>=0 && array[j] > temp ){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }
    }
    public static void main(String[] args) {
    int[] array = {8,4,1,5,9,2};
    printArray(array);
    System.out.println("After shorting array's element by Insertion Sorting");
    insertionSort(array);
    printArray(array);

    }
}
