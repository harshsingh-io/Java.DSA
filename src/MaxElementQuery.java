public class MaxElementQuery {
    static int[] tree;

    public static void init(int n) {
        tree = new int[4 * n];
    }

    public static void buildST(int[] arr, int i, int start, int end) {
        if (start == end) {
            tree[i] = arr[start];
            return;
        }
        int mid = (start + end) / 2; // si+(sj-si)/2 -> for larger values
        buildST(arr, 2 * i + 1, start, mid);
        buildST(arr, 2 * i + 2, mid + 1, end);
        tree[i] = Math.max(tree[2 * i + 1],tree[2 * i + 2]);
    }
    public static int getMaxUtil(int i, int si, int sj, int qi, int qj) {
        if (qj < si || qi > sj) { //non overlapping
            return Integer.MIN_VALUE;
        } else if (si >= qi && sj <= qj) { //complete overlap
            return tree[i];
        } else { //partial overlap
            int mid = (si + sj) / 2;
            int left = getMaxUtil(2 * i + 1, si, mid, qi, qj);
            int right = getMaxUtil(2 * i + 2, mid + 1, sj, qi, qj);
            return Math.max(left,right);
        }
    }

    public static int getMax(int[] arr, int qi, int qj) {
        int n = arr.length;
        return getMaxUtil(0, 0, n - 1, qi, qj);
    }
    public static void updateUtil(int i, int si, int sj, int idx, int newVal) {
        if (idx > sj || idx < si) {
            return;
        }
        tree[i] = Math.max(tree[i],newVal);
        if (si != sj) { //non-leaf
            int mid = (si + sj) / 2;
            updateUtil(2 * i + 1, si, mid, idx, newVal);
            updateUtil(2 * i + 2, mid + 1, sj, idx, newVal);
        }
    }

    public static void update(int[] arr, int idx, int newVal) {
        arr[idx] = newVal;
        int n = arr.length;
        updateUtil(0, 0, n - 1, idx, newVal);
    }

    public static void main(String[] args) {
        int[] arr = {6,8,-1,2,17,1,3,2,4};
        init(arr.length);
        buildST(arr,0,0,arr.length-1);
//        for (int i=0;i<tree.length;i++){
//            System.out.print(tree[i]+" ");
//        }
        System.out.println(getMax(arr,2,5));
        update(arr,2,20);
        System.out.println(getMax(arr,2,5));
    }
}
