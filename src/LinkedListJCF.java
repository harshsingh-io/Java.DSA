import java.util.LinkedList;

public class LinkedListJCF {
    public static void main(String[] args) {
//        creation of linkedlist
        LinkedList<Integer> ll = new LinkedList<>();

//        adding elements in linked list
        ll.addLast(1);
        ll.addLast(2);
        ll.addFirst(0);
//        0->1->2
        System.out.println(ll);
//        remove element
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);

    }
}