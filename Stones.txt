/***************************************************************
 There are three piles of stones. The first pile contains a stones,
 the second pile contains b stones and the third pile contains c stones. 
 You must choose one of the piles and split the stones from it to the other 
 two piles; specifically, if the chosen pile initially contained s stones, 
 you should choose an integer k (0≤k≤s), move k stones from the chosen pile 
 onto one of the remaining two piles and s−k stones onto the other remaining 
 pile. Determine if it is possible for the two remaining piles (in any order) 
 to contain x stones and y stones respectively after performing this action.
INPUT FORMAT :
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first and only line of each test case contains five space-separated integers 
a,b,c, x and y.
OUTPUT FORMAT :
For each test case, print a single line containing the string “YES” if it is 
possible to obtain piles of the given sizes or “NO” if it is impossible.
SAMPLE INPUT :
4
1 2 3 2 4
3 2 5 6 5
2 4 2 6 2
6 5 2 12 1
SAMPLE OUTPUT :
YES
NO
YES
NO
 ***************************************************************/

import java.util.*;
public class Stones{
    public static void main(String []arg){
        Scanner in=new Scanner(System.in);
        System.out.print("Enter no.of test Cases = ");
        int t=in.nextInt();
        int a,b,c,x,y;
        for(int i=0;i<t;i++)
        {
            a=in.nextInt();
            b=in.nextInt();
            c=in.nextInt();
            x=in.nextInt();
            y=in.nextInt();
            System.out.println(find(a,b,c,x,y));
        }
    }
    static String find(int a, int b,int c,int x,int y)
    {
        if(findFunction(a,b,c,x,y,0).equals("NO"))
        {
            if(findFunction(a,c,b,x,y,0).equals("NO"))
            {
                if(findFunction(c,b,a,x,y,0).equals("NO"))
                {
                    return "NO";
                }
            }
        }
        return "YES";
    }
    static String findFunction(int a,int b,int c,int x,int y,int ind)
    {
        while(ind<=c){
            if(((a+ind)==x&&(b+(c-ind))==y)||((a+ind)==y&&(b+(c-ind))==x))
            {
               return "YES";
            }
            ind++;
        }
        return "NO";
    }
}