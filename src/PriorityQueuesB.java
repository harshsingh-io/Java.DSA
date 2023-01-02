import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueuesB {
    static class Student implements Comparable<Student>{
        String name;
        int rank;

        public Student(String name, int rank){
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s2){
            //if we want to compare on the basis of rank
            return this.rank-s2.rank;
        }
    }
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        /* for reverse order
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Comparators are interface which defines logic of comparators
        whenever sorting happen then it will be compared the comparator actually do
        how to compare either ascending or descending
         */
        pq.add(3); //O(log n)
        pq.add(4);
        pq.add(1);
        pq.add(7);

        while (!pq.isEmpty()){
            System.out.println(pq.peek()); //O(1)
            pq.remove(); //O(log n)
        }

        PriorityQueue<Student> st = new PriorityQueue<>();
//        PriorityQueue<Student> st = new PriorityQueue<>(Comparator.reverseOrder());
        st.add(new Student("A", 4));
        st.add(new Student("B", 2));
        st.add(new Student("C", 4));
        st.add(new Student("D", 3));
        st.add(new Student("E", 1));

        while (!st.isEmpty()){
            System.out.println(st.peek().name+"->"+st.peek().rank); //O(1)
            st.remove(); //O(log n)
        }
    }
}
