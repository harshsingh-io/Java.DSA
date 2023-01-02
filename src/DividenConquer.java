public class DividenConquer {
    public static void printArray(int[]arr){
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void mergeSort(int[]array,int si,int ei){
//        base condition
        if (si>=ei){
            return;
        }
//        kaam
        int mid = si+(ei-si)/2; //(si+ei)/2
        mergeSort(array,si,mid); //left part of array
        mergeSort(array,mid+1,ei); //right part of array
        merge(array,si,mid,ei);
    }
    public static void merge(int[]arr, int si,int mid, int ei){
        int[] temp = new int[ei-si+1];
        int i = si; //iterator&pointer start from left part
        int j = mid+1; //iterator&pointer start from mid+1 part
        int k = 0; //iterator&pointer of temp arr[]
        while(i<=mid && j<=ei){
            if(arr[i]<=arr[j]){
//                temp[k++] = arr[i++]; can be written like this
                temp[k] = arr[i];
                i++;
            } else {
                temp[k]=arr[j];
                j++;
            }
            k++;
        }
        //if right array is exhausted then put left array elements

        while (i<=mid){ //adding remaining element of left array to temp array
            temp[k++]=arr[i++];
        }
        //if left array is exhausted then put right array elements
        while(j<=ei){//adding remaining element of right array to temp array
            temp[k++]=arr[j++];
        }

        //copy temp to original arr
        for (i=si;i<temp.length;i++){
            arr[i]=temp[i];
        }
    }
    public static int search(int[]arr,int tar,int si,int ei){
//        Base Case
        if (si>ei){
            return -1;
        }
//        kaam
        int mid = si+(ei-si)/2;
//        when target found on mid
        if (arr[mid]==tar){
            return mid;
        }
//        when mid is on Line 1
        if (arr[si]<=arr[mid]){
//            case a : left
            if (arr[si]<=tar&&tar<=arr[mid]){
                return search(arr,tar,si,mid-1);
            }
//            case b : right
            else{
                return search(arr,tar,mid+1,ei);
            }
        }
//        when mid is on Line 2
        else{
//            case c : right
            if (arr[mid+1]<=tar&&tar<=arr[ei]){
                return search(arr,tar,mid+1,ei);
            }
//            case d : left
            else {
                return search(arr,tar,si,mid-1);
            }
        }
    }
    public static void main(String[] args) {
//        int[] arr1 = {6, 3, 9, 5, 2, 8};
//        int[] arr = {9,4,7,6,3,1,5};
//        mergeSort(arr,0,arr.length-1);
//        printArray(arr);
        int[] array = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(array,target,0,array.length-1));

    }
}
