import java.io.*;
import java.util.*;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in=new Scanner(System.in);
        String str=in.next();
        String restr="";
        for(int i=str.length()-1;i>=0;i--){
            restr+=str.charAt(i);
        }
        int dp[][]=new int[str.length()+1][restr.length()+1];
        for(int i=1;i<=str.length();i++){
            for(int j=1;j<=restr.length();j++){
                if(str.charAt(i-1)==restr.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[str.length()][restr.length()]);
    }
}