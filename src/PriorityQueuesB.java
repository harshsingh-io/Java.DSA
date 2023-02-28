import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueuesB {
//    static class Student implements Comparable<Student>{
//        String name;
//        int rank;
//
//        public Student(String name, int rank){
//            this.name = name;
//            this.rank = rank;
//        }
//
//        @Override
//        public int compareTo(Student s2){
//            //if we want to compare on the basis of rank
//            return this.rank-s2.rank;
//        }
//    }

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distanceSquare;
        int idx;
        public Point(int x,int y,int distanceSquare, int idx){
            this.distanceSquare = distanceSquare;
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
        @Override
        public int compareTo(Point p2){
            return this.distanceSquare-p2.distanceSquare;
        }
    }
    static class Row implements Comparable<Row> {
        int soldiers;
        int idx;

        public Row(int soliders, int idx){
            this.soldiers = soliders;
            this.idx = idx;
        }

        @Override
        public int compareTo(Row r2){
            if (this.soldiers == r2.soldiers){
                return this.idx - r2.idx;
            }
            else {
                return this.soldiers - r2.soldiers;
            }
        }
    }
    public static void main(String[] args) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        /* for reverse order
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
//        Comparators are interface which defines logic of comparators
//        whenever sorting happen then it will be compared the comparator actually do
//        how to compare either ascending or descending
//         */
//        pq.add(3); //O(log n)
//        pq.add(4);
//        pq.add(1);
//        pq.add(7);
//
//        while (!pq.isEmpty()){
//            System.out.println(pq.peek()); //O(1)
//            pq.remove(); //O(log n)
//        }
//
//        PriorityQueue<Student> st = new PriorityQueue<>();
////        PriorityQueue<Student> st = new PriorityQueue<>(Comparator.reverseOrder());
//        st.add(new Student("A", 4));
//        st.add(new Student("B", 2));
//        st.add(new Student("C", 4));
//        st.add(new Student("D", 3));
//        st.add(new Student("E", 1));
//
//        while (!st.isEmpty()){
//            System.out.println(st.peek().name+"->"+st.peek().rank); //O(1)
//            st.remove(); //O(log n)
//        }

//        int pts[][] = {{3,3}, {5,-1}, {-2,4}};
//        int k = 2;
//
//        PriorityQueue<Point> pq = new PriorityQueue<>();
//        for (int i = 0; i < pts.length; i++){
//            int distanceSquare = pts[i][0]*pts[i][0]+pts[i][1]*pts[i][1];
//            pq.add(new Point(pts[i][0], pts[i][1], distanceSquare,i));
//        }
//
//        //nearest K cars
//        for (int i=0; i<k; i++){
//            System.out.println("C" + pq.remove().idx);
//        }
//
//        int[] ropes = {2,3,3,4,6};
//
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int i=0 ; i<ropes.length ; i++){
//            pq.add(ropes[i]);
//        }
//        int cost = 0;
//        while (pq.size()>1){
//            int min = pq.remove();
//            int min2 = pq.remove();
//            cost += min + min2;
//            pq.add(min+min2);
//        }
//        System.out.println("Cost of connecting n ropes = " + cost);
        int army[][] = {{1, 0, 0, 0},
                        {1, 1, 1, 1},
                        {1, 0, 0, 0},
                        {1, 0, 0, 0}};
        int k = 2;
        PriorityQueue<Row> pq = new PriorityQueue<>();
        for (int i=0; i<army.length; i++) {
            int count = 0;
            for (int j = 0; j < army[0].length; j++) {
                count += army[i][j] == 1 ? 1 : 0;
            }
            pq.add(new Row(count, i));
        }
        for (int i = 0 ; i < k ; i++) {
            System.out.println("R"+pq.remove().idx);
        }
    }
}
