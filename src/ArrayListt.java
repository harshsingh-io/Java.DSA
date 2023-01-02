import java.util.ArrayList;

public class ArrayListt {
    public static void main(String[] args) {
        /*
        Basic Implementation
        ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1); list1.add(2);
        mainlist.add(list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(3); list2.add(4);
        mainlist.add(list2);
        for (int i = 0; i<mainlist.size();i++){
            ArrayList<Integer> currentlist = mainlist.get(i);
            for (int j = 0; j<currentlist.size();j++){
                System.out.print(currentlist.get(j)+ " ");
            }
            System.out.println();
        }
        System.out.println(mainlist);
         */
        ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();
        for (int i = 1;i <= 5; i++){
            list1.add(i*2);
            list2.add(i*3);
            list3.add(i*5);
        }
        mainlist.add(list1);
        mainlist.add(list2);
        mainlist.add(list3);
//        to remove elements
        list2.remove(3);
        list3.remove(2);
//        System.out.println(mainlist);
//        nested loop
        for (int i = 0; i < mainlist.size();i++){
            ArrayList<Integer> currentList = mainlist.get(i);
            for (int j = 0; j < currentList.size(); j++){
                System.out.print(currentList.get(j)+" ");
            }
            System.out.println();
        }
    }
}
