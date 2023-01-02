public class Array {
    public static void printArray(int arr[]) {
        for(int i = 0 ; i < arr.length ; i ++){
            System.out.print(arr[i] + " ");
        }
    }
    public static int order(String menu[] , String wish) {
        for(int i=0; i<= menu.length; i++)
        {
            if(menu[i] == wish){
                return i;
            }
        }
        return -1;
    }
    public static void swapArray(int arr []) {
        int first = 0;
        int  last = arr.length-1;
        while(first<last){
            int temp = arr[last];
            arr[last] = arr[first];
            arr[first] = temp;
            first++;
            last--;
        }
    }
    public static void printPairs(int num[]) {
        int tp =0;
        for(int i = 0; i < num.length ; i++){
            int current = num[i];
            for(int j = i+1; j<num.length ; j++){
                System.out.print("(" + current + ", " + num[j] + ")");
                tp++;
            }
            System.out.println();
        }
        System.out.println("Total Pairs : " + tp);
    }

    public static void main(String[] args) {
        /*
        String menu[] = {"dosa" , "badapaw" , "samosa" , "fruity" , "maaza" , "cholebhature"};
        printArray(menu);
        String wish = "samosa";
        System.out.println(wish);
        int index = order(menu, wish);
        if(index == -1)
        {
            System.out.println("Not Found");
        }
        else{
            System.out.println(index+1);
        }
        */

        int number [] = {10,9,8,6,5};
        // swapArray(number);

        printPairs(number);
        printArray(number);
    }
}
