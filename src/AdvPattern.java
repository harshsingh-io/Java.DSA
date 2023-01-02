public class AdvPattern {
public static void inverted_rotated_half_pyramid(int n){
    for(int i = 1; i<=n ; i++)
    {
        for(int j=1; j<=n-i; j++ )
        {
            System.out.print(" ");
        }
        for(int j = 1 ; j <= i ; j++ )
        {
            System.out.print("*");
        }
        System.out.println();
    }
}
public static void inverted_half_pyramid(int n)
{
    for(int i = 1; i <= n ; i++)
    {
        for(int j = 1 ; j <= n-i+1 ; j++)
        {
            System.out.print(j);
        }
        System.out.println();
    }
}
public static void floydsTriangle(int n) {
    int counter=1;
    for(int i = 1; i <= 5; i++)
    {
        for(int j = 1; j <= i; j++)
        {
            System.out.print(counter + " ");
            counter++;
        }
        System.out.println();
    }
    
}
public static void triangleOI(int n)
{
    for(int i = 1; i <= 5; i++)
    {
        for(int j = 1; j <= i; j++)
        {
            if((i+j)%2 == 0)
            {
                System.out.print("1");
            }
            else if((i+j)%2 != 0)
            {
                System.out.print("0");
            }
        }
        System.out.println();
    }
}
    public static void main(String[] args) {
        // inverted_rotated_half_pyramid(6);
        // inverted_half_pyramid(6);
        // floydsTriangle(5);
        triangleOI(5);
    }
    
}
