import java.util.*;
public class LinearSearch{
    public static void main(String[] arg)
    {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter array elements = ");
        String ar=in.nextLine();
        System.out.print("Enter the number to search = ");
        int n=in.nextInt();
        String a[]=ar.split(" ");
        boolean flag=false;
        for(int i=0;i<a.length;i++)
        {
            if(n==Integer.parseInt(a[i]))
            {
                flag=true;
                System.out.println("Number "+n+" Found!!!");
                break;
            }
        }
        if(!flag)
        {
            System.out.println("Number "+n+" is not Found!!!");
        }
    }
}