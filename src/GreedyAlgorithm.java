import java.util.*;
public class GreedyAlgorithm {
    public static void maxActivity(int[] start, int[] end){
//        end time basis is not sorted
//        sorting
        int[][] activities = new int[start.length][3];
        for (int i = 0 ; i < start.length ; i++){
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }
//        lambda function -> short form
        Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

//        end time basis sorted
        int maxAct = 0; // counter for no. of activity
        ArrayList<Integer> ans = new ArrayList<>(); //for activity no.

        //1st activities
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = end[0];
        for (int i = 1 ; i< end.length; i++){
            if (activities[i][1]>=lastEnd){
//                activity selected
                maxAct++;
                ans.add(i);
                lastEnd=activities[i][2];
            }
        }
//        1st activity
//        maxAct = 1;
//        ans.add(0);
//        int lastEnd = end[0];
//        for (int i = 1 ; i< end.length; i++){
//            if (start[i]>=lastEnd){
////                activity selected
//                maxAct++;
//                ans.add(i);
//                lastEnd=end[i];
//            }
//        }
        System.out.println("Max activities :  " + maxAct);
        for (int i = 0 ; i<ans.size(); i++){
            System.out.print( "A"+ans.get(i)+" ");
        }
        System.out.println();
    }
    public static int fractionalKnapsack(int[] value, int[] weight,int capacity){
        int profit = 0;
        double[][] ratio = new double[value.length][2]; // 0th col -> index; 1st col -> ratio
        for (int i = 0 ; i<ratio.length; i++){
            ratio[i][0] = i;
            ratio[i][1] = value[i]/(double)weight[i];
        }
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        for (int i = ratio.length-1; i>=0;i--){
            int idx = (int)ratio[i][0];
            if (capacity>=weight[idx]){
                capacity=capacity-weight[idx];
                profit+=value[idx];
            }else {
                profit+= ratio[i][1]*capacity; //adding value according to remaining capacity
                capacity=0;
                break;
            }
        }
        return profit;
    }
    public static int minAbsoluteDiff(int[] A, int[] B){
        Arrays.sort(A);
        Arrays.sort(B);
        int mAbDif = 0;
        for (int i = 0; i < A.length; i++){
            mAbDif += Math.abs(A[i]-B[i]);
        }
        return mAbDif;
    }
    public static int longestChain(int[][] pair){ //O(nlogn)
        Arrays.sort(pair,Comparator.comparingDouble(o->o[1]));
        int chainLength = 0;
        int lastSelected = pair[0][1]; // Last Selected Pair End // chain end
        chainLength = 1;
        for (int i = 1 ; i < pair.length;i++){
            if (pair[i][0] > lastSelected){
                chainLength++;
                lastSelected = pair[i][1];
            }
        }
        return chainLength;
    }
    public static void indianCoin(Integer[] coin,int money){
        Arrays.sort(coin, Collections.reverseOrder());

        ArrayList<Integer> coinUsed = new ArrayList<>();
        int totalCoins = 0;
        for (int i = 0 ; i < coin.length; i++) {
            if (money == 0){
                break;
            }
            if (money >= coin[i]) {
                money-= coin[i];
                totalCoins++;
                coinUsed.add(coin[i]);
                i-=1;
            }
        }
        System.out.println(totalCoins);
        System.out.println(coinUsed);
    }

    static class Job{
        int id;
        int deadline;
        int profit;
        public Job(int i, int d, int p){
            this.id =i;
            this.deadline=d;
            this.profit=p;
        }
    }
    public static void jobSequence(int[][] jobInfo){
        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < jobInfo.length; i++){
            jobs.add(new Job(i, jobInfo[i][0], jobInfo[i][1]));
        }
        Collections.sort(jobs, (obj1 , obj2) -> obj2.profit-obj1.profit);

        ArrayList<Integer> seq = new ArrayList<>();
        int time =0;
        for (int i = 0; i<jobs.size();i++){
            Job curr = jobs.get(i);
            if (curr.deadline>time){
                seq.add(curr.id);
                time++;

            }

        }
        System.out.println(seq.size());
        for (int i = 0; i<seq.size(); i++){
            System.out.print(seq.get(i)+" ");
        }
        System.out.println();
    }
    public static int chacolaProblem(int n,int m,Integer[] costVer, Integer[] costHor){
        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());
        int horPieces = 1;
        int verPieces = 1;
        int totalCost=0;
        int h=0,v=0;
        while (h < costHor.length && v < costVer.length){
            if (costVer[v]<=costHor[h]){ // horizontal cut
                totalCost+= (verPieces*costHor[h]);
                horPieces++;
                h++;
            }else { //vertical cuts
                totalCost+=(horPieces*costVer[v]);
                verPieces++;
                v++;
            }
        }
        while (h<costHor.length){
            totalCost+= (verPieces*costHor[h]);
            horPieces++;
            h++;
        }
        while(v<costVer.length){
            totalCost+=(horPieces*costVer[v]);
            verPieces++;
            v++;
        }
        return totalCost;
    }
    public static void main(String[] args) {

//        int start[] = {1,3,0,5,8,5};
//        int end[] = {2,4,6,7,9,9};
//        maxActivity(start,end);
//        int[] value = {60,100,120};
//        int[] weight = {10,20,30};
//        int capacity = 50;
//        System.out.println(fractionalKnapsack(value,weight,capacity));

//        int[] A = {4,1,8,7};
//        int[] B = {2,3,6,5};
//        System.out.println(minAbsoluteDiff(A,B));

//        int[][] pairs = {{5,24}, {39,60}, {5,28}, {27,40}, {50,90}};
//        System.out.println(longestChain(pairs));

//        Integer[] coins = {1,2,5,10,20,50,100,500,2000};
//        int money = 4688;
//        indianCoin(coins, money);

//        int[][] jobInfo = {{4,20}, {1,10}, {1,40}, {1,30}};
//        jobSequence(jobInfo);

        int n = 4,m=5;
        Integer[] costVertical = {2,1,3,1,4};
        Integer[] costHorizontal = {4,1,2};
        System.out.println("Minimum cost of cuts = "+ chacolaProblem(n,m,costVertical,costHorizontal));
    }
}