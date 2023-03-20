import java.util.HashMap;
import java.util.Set;

public class HashMapB {
    public static void main(String[] args) {
        //Create
        HashMap<String, Integer> hashMap = new HashMap<>();

        //Insert - O(1)
        hashMap.put("India", 100);
        hashMap.put("China", 150);
        hashMap.put("US", 50);
//        System.out.println(hashMap);

//        //Get - O(1)
//        int population = hashMap.get("India");
//        System.out.println(population); // 100 returned
//        System.out.println(hashMap.get("Indonesia")); //null return

//        //ContainKeus - O(1)
//        System.out.println(hashMap.containsKey("India")); //true
//        System.out.println(hashMap.containsKey("Indonesia")); //false

        //Remove - O(1)
//        System.out.println(hashMap.remove("China"));
//        System.out.println(hashMap);
//        System.out.println(hashMap.remove("Indonesia"));

//        //Size O(1)
//        System.out.println(hashMap.size());

//        // Is Empty
//        System.out.println(hashMap.isEmpty());

        // Clear
//        hashMap.clear();
//        System.out.println(hashMap);

        //Iterate - O(1)
        // hashMap.entrySet() - for pair set
        //hashMap.keySet() - for key set
        Set<String> keys = hashMap.keySet();
        System.out.println(keys);

        for (String k : keys) {
            System.out.println("Key = "+k+ ", Value = "+hashMap.get(k));
        }
    }
}
