import java.io.*;
import java.util.*;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int ar[]=new int[n];
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ar[i]=in.nextInt();
            ans[i]=1;
        }
        
        int max=0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(ar[j]<ar[i]&&ans[i]<ans[j]+1){
                    ans[i]=ans[j]+1;
                    if(max<ans[i]){
                        max=ans[i];
                    }
                }
            }
        }
        System.out.println(max);
    }
}