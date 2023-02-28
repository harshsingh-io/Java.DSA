public class LinkedList {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
        public Node head;
        public static Node tail;
        public static int size;

        public void addFirst(int data) {
//            step 1 : create new node
            Node newNode = new Node(data);
            size++;
            if (head == null) {
                head = tail = newNode;
                return;
            }
//            step 2 : newNode next = head
            newNode.next = head;
//            step 3 : head = newNode
            head = newNode;
        }

        public void addLast(int data) {
            Node newNode = new Node(data);
            size++;
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }
        public void print(){
            if(head == null){
                System.out.println("LL is empty");
                return;
            }
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.println("null");
        }
        public void add(int idx, int data){
            if (idx == 0){
                addFirst(data);
                return;
            }
            Node newNode = new Node(data);
            size++;
            Node temp = head;
            int i = 0;
            while (i< idx-1){
                temp = temp.next;
                i++;
            }
//            i = idx-1, temp -> prev
            newNode.next = temp.next;
            temp.next = newNode;
        }
        public int removeFirst(){
            if (size == 0){
                System.out.println("LL is empty");
                return Integer.MIN_VALUE;
            } else if (size==1) {
                int val = head.data;
                head = tail = null;
                size= 0;
                return val;
            }

            int val = head.data;
            head = head.next;
            size--;
            return val;
        }
        public int removeLast(){
            if (size == 0){
                System.out.println("LL is empty");
                return Integer.MIN_VALUE;
            } else if (size==1) {
                int val = head.data;
                head = tail = null;
                size= 0;
                return val;
            }
            Node prev = head;
            for (int i = 0 ; i < size-2; i++){
                prev = prev.next;
            }
             int val = tail.data; //previous.next.data
            prev.next = null;
            tail = prev;
            size--;
            return val;
        }
        public int search(int key){//O(n)
            int idx=0;
            Node temp = head;
            while(temp !=null){
                idx++;
                if (temp.data == key){
                    return idx;
                }
                temp = temp.next;
            }
            return -1;
        }

        public int recursiveSearchHelper(Node head , int key){ //O(n)
//            base case
            if (head == null){
                return -1;
            }
            if (head.data == key){
                return 0;
            }
            int idx = recursiveSearchHelper(head.next, key);
            if (idx == -1){
                return -1;
            }
            return idx+1;
        }
        public int recursiveSearch(int key){
            return recursiveSearchHelper(head, key);
        }
        public void reverse(){
            Node prev = null;
            Node curr = tail = head;
            Node next;
            while (curr!= null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
        }
        public void deleteFromLastToN(int n){
            int sz = 0;
            Node temp = head;
            while(temp!=null){
                temp = temp.next;
                sz++;
            }
            if (n == size){
                head = head.next;
                return;
            }
            Node prev = head;
            int i = 1;
            int toFind = sz-n;
            while(i < toFind){
                prev = prev.next;
                i++;
            }
            prev.next = prev.next.next;
            return;
        }
//        Slow-fast Approach to find middle
    public Node findMidSF(Node head){
            Node slow = head;
            Node fast = head;
            while (fast!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
    }
    public boolean checkPalindrome(){
            if (head == null || head.next == null){
                return true;
            }
//            step 1 - to find mid node
        Node midNode = findMidSF(head);
//            step 2 reverse the 2nd half of linkedlist
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
//        step 3 : check left half & right half
        Node right = prev;
        Node left = head;
        while (right!= null){
            if (left.data!=right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public boolean detectLoop(){ //Floyd's CFA
            Node slow = head;
            Node fast = head;
            while (fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if (slow==fast){
                    return true; //cycle present
                }
            }
            return false; // cycle not present
    }
     //remove a cycle from a linked list
     public void removeLoop(){
         Node slow = head;
         Node fast = head;
         boolean cycle = false;
         while (fast != null && fast.next != null){
             slow = slow.next;
             fast = fast.next.next;
             if (slow==fast){
                 cycle = true;
                 break;
             }
         }
         if (cycle == false){
             return;
         }
//         finding meeting point
         slow = head;
         Node prev = null;
         while (slow != fast) {
             prev = fast;
             slow = slow.next;
             fast = fast.next;
         }
//         removing cycle
         prev.next = null;
     }
    public static Node findMidMergeS(Node head){
        Node slow = head;
        Node fast = head.next;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public static Node merge(Node leftHead, Node rightHead){
            Node neww = new Node(-1);
            Node temp = neww;
            while (leftHead!=null && rightHead!=null){
                if (leftHead.data<rightHead.data){
                    temp.next=leftHead;
                    leftHead=leftHead.next;
                    temp=temp.next;
                }
                else {//(rightHead.data<leftHead.data)
                    temp.next=rightHead;
                    rightHead=rightHead.next;
                    temp=temp.next;
                }
            }
            while (leftHead!=null){
                temp.next=leftHead;
                leftHead=leftHead.next;
                temp=temp.next;
            }
            while (rightHead!=null) {
                temp.next = rightHead;
                rightHead = rightHead.next;
                temp = temp.next;
            }
            return neww.next;
    }
    static Node mergeSort(Node head){
//            base case
        if (head==null || head.next!=null){
            return head;
        }
//            find mid
        Node mid = findMidMergeS(head);
//        left and right mergesort
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeftHead = mergeSort(head);
        Node newRighthead = mergeSort(rightHead);
//        merge lefthead and righthead
        return merge(newLeftHead,newRighthead);
    }
    public void zigZag(){
//            find mid
        Node slow = head;
        Node fast = head.next;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

//      reverse 2nd half
        Node curr = mid.next;
        mid.next=null;
        Node prev = null;
        Node next;
        while (curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL,nextR;

//        alternatively merging - zig-zag
        while (left != null && right != null){
            //zigzag
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;
//          upgrade
            left = nextL;
            right = nextR;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(2);
        ll.addLast(1);
//        ll.add(2,3);
//        ll.print(); //1->2->3->4->5
//        System.out.println(ll.size);
        ll.removeFirst();
//        ll.print();
//        System.out.println(ll.size);
        ll.removeLast();
//        ll.print();
//        System.out.println(ll.size);
//        System.out.println(ll.search(4));
//        System.out.println(ll.search(7));
//        System.out.println(ll.recursiveSearch(4));
//        ll.reverse();
//        ll.print();
//        ll.deleteFromLastToN(3);

//        ll.print();
//        System.out.println(ll.checkPalindrome());
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addFirst(8);
        ll.addFirst(5);
        ll.print();
//        head.next.next.next.next = head.next ; // 1->2->2->1->2(head.next)
//        System.out.println(ll.detectLoop());
//        ll.removeLoop();
//        ll.print();
//        System.out.println(ll.detectLoop());
//        ll.head= mergeSort(ll.head);
//        ll.print();
        ll.zigZag();
        ll.print();
    }
}