import java.util.*;
public class MinMaxList{
    public static void main(String []arg){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter value = ");
        List<Integer>list=new LinkedList<>();
        String input=in.nextLine();
        String ar[]=input.split(" ");
        for(int i=0;i<ar.length;i++)
        {
            list.add(Integer.parseInt(ar[i]));
        }
        System.out.println("Min = "+Collections.min(list));
        System.out.println("Max = "+Collections.max(list));
    }
}