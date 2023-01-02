import java.util.Arrays;

public class StringExercise {
//    Question 1 : Count how many times lowercase vowels occurred in a String entered by the
//user.
    public static int countVowelLC(String str){
        int counter =0;
        for (int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch =='o' || ch == 'u'){
                counter++;
            }
        }
        return counter;
    }
    /*
    Question 4 : Determine if 2 Strings are anagrams of each other.
What are anagrams?
If two strings contain the same characters but in a different order, they can be said to be
anagrams. Consider race and care. In this case, race's characters can be formed into a study,
or care's characters can be formed into race. Below is a java program to check if two strings
are anagrams or not.
     */
    public static boolean checkAnagrams(String str1, String str2){
        boolean result = false;
        // check if length is same
        if (str1.length()==str2.length()){
            // convert strings to char array
            char[] charArray1 = str1.toCharArray();
            char[] charArray2 = str2.toCharArray();
            // sort the char array
            Arrays.sort(charArray1);
            Arrays.sort(charArray2);
            // if sorted char arrays are same
            // then the string is anagram
            result = Arrays.equals(charArray1,charArray2);
        }
        return result;
    }
    public static void main(String[] args) {
        String str = "Here we go master Harsh";
        System.out.println(countVowelLC(str));
        String str1 = "race";
        String str2 = "care";
        System.out.println(checkAnagrams(str1,str2));
        StringBuffer sbf = new StringBuffer("Here we go master Harsh");
        System.out.println(sbf.length());
        System.out.println(sbf.capacity());
        System.out.println(sbf.charAt(2));
        System.out.println(sbf.delete(2,3));
        System.out.println(sbf.deleteCharAt(1));
        System.out.println(sbf.insert(2, 'h'));
        //System.out.println(sbf.reverse());
        System.out.println(sbf.replace(1,5, "babu"));
    }
}
