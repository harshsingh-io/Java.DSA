import java.util.LinkedList;

public class LinkedList_Last_Occurence_position
{
    public static void main(String[] args)
    {
        LinkedList<String> linkedList = new LinkedList<String>();
 
        linkedList.add("AAA");
 
        linkedList.add("BBB");
 
        linkedList.add("CCC");
 
        linkedList.add("BBB");
 
        linkedList.add("FFF");
 
        linkedList.add("BBB");
 
        System.out.println(linkedList);      
        System.out.println(linkedList.lastIndexOf("BBB"));    //Output : 5
    }
}