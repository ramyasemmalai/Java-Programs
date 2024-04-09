import java.util.*;
public class BinarySearch{
    public static void main(String []args){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter the sorted array elements = ");
        String ar=in.nextLine();
        System.out.print("Enter the number to search = ");
        int n=in.nextInt();
        String a[]=ar.split(" ");
        int mid=0;
        boolean flag=false;
        int x=0;
        int y=a.length-1;
        for(int i=0;i<a.length;i+=2)
        {
            mid=(int)(x+y)/2;
            if(n==Integer.parseInt(a[mid]))
            {
                flag=true;
                System.out.println("Number "+n+" Found!!!");
                break;
            }
            else if(n<Integer.parseInt(a[mid]))
            {
                y=mid-1;
            }
            else{
                x=mid+1;
            }
        }
        if(!flag)
        {
            System.out.println("Number "+n+" not found");
        }
    }
}