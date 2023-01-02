public class Strings {
    public static String toUpperCase(String str){
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for (int i = 1; i<str.length();i++){
            if (str.charAt(i) == ' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
//    By initializing string instead of stringBuilder
    public static String stringCompression(String str){
        String newstr = "";
        for (int i=0; i<str.length();i++){
//            below we compared the i with str.length -1 because when
//            str.charat(i) == str.charat(i+1) will exceed the string length
            Integer counter = 1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)) {
                counter++;
                i++;
            }
            newstr += str.charAt(i);
            if (counter>1){
                newstr += counter.toString();
            }
        }
        return newstr;
    }
//    By StringBuilder which has less timeComplexity than String function
    public static String stringsCompression(String str){
        StringBuilder sb = new StringBuilder("");
        for (int i=0; i<str.length();i++){
            Integer counter = 1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)) {
                counter++;
                i++;
            }
        sb.append(str.charAt(i));
            if (counter>1){
                sb.append(counter);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
//     String str = "hi, i am harsh";
//     System.out.println(toUpperCase(str));
     String str = "hhhhhhaaaarrrsshhh";
        System.out.println(stringCompression(str));
        System.out.println(stringsCompression(str));
    }
}
