import java.util.*;
public class MaximumProfit{
    public static void main(String []ag)
    {
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the prize of stocks = ");
        String str=in.nextLine();
        String a[]=str.split(" ");
        int price[]=new int[a.length];
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int pos=0;
        for(int i=0;i<a.length;i++)
        {
            price[i]=Integer.valueOf(a[i]);
            if(min>price[i])
            {
                min=price[i];
                pos=i;
            }
        }
        for(int i=pos;i<a.length;i++)
        {
            if(max<price[i])
            {
                max=price[i];
            }
        }
        System.out.println(max-min);
    }
}