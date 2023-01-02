public class DoublyLL {
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;
//    addFirst
    public void addFirst(int data){
        Node newNode = new Node(data);
        size++;
        if (head == null){
            head=tail=newNode;

            return;
        }
        newNode.next=head;
        head.prev = newNode;
        head = newNode;

    }
//    add last
    public void addLast(int data){
        Node newNode = new Node(data);
        if (head==null){
            head=tail=newNode;
        }
        Node temp = head;
        while(temp.next!=null){
            temp=temp.next;
        }
        newNode.prev = temp;
        temp.next = newNode;
    }
//    removeFirst
    public int removeFirst(){
        if (head==null){
            System.out.println("LinkedList is empty");
            return Integer.MIN_VALUE;
        }
        if (size==1){
            int val = head.data;
            head=tail=null;
        }
        int val = head.data;
        head = head.next;
//      new head previous should be null
        head.prev=null;
        size--;
        return val;
    }
//    print
    public void print(){
        Node temp = head;
        System.out.print("null<->");
        while (temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("null");
    }
    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr!=null){
            next= curr.next;
            curr.next = prev;
            curr.prev = next;

            prev=curr;
            curr=next;
        }
        head=prev;
    }

    public static void main(String[] args) {
        DoublyLL dll = new DoublyLL();
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.addFirst(4);
        dll.removeFirst();
        dll.print();
        System.out.println(dll.size);
        dll.reverse();
        dll.print();
        dll.addLast(6);
        dll.print();
    }
}
