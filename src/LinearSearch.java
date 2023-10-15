//Program to implement Linear Search
//checking given character in string exist or not if exist so it return true otherwise false.

import java.util.Scanner;

public class LinearSearch
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Reading string
        System.out.print("Enter the string: ");
        String str = scan.next();

        //Reading character
        System.out.print("Enter the character to find: ");
        char ch = scan.next().charAt(0);

        // System.out.println(search(str, ch));
        System.out.println(search2(str, ch));
    }

    //first way to search
    public static boolean search(String str, char target)
    {
        if(str.length()==0)
            return false;
        for(int i=0 ; i<str.length() ; i++)
        {    
            if(target==str.charAt(i))
            return true;
        }
        return false;
    }

    //second way
    public static boolean search2(String str, char target)
    {
        char[] ch = str.toCharArray();
        
        if(ch.length==0)
        return false;

        for(char element : ch)
        {
            if(element==target)
            {
                return true;
            }
        }
        return false;
    }
}