import java.util.*;
public class RsaDS
{
    static Scanner in=new Scanner(System.in);
    static int p,q,n,pn,e,d,M;
    static int S,P;
    public static void main(String []args)
    {
        System.out.println("***** 21BCT0427---RAMYA S *****");
        System.out.print("Enter P = ");
        p=in.nextInt();
        System.out.print("Enter q = ");
        q=in.nextInt();
        System.out.print("Enter e = ");
        e=in.nextInt();
        System.out.print("Enter M = ");
        M=in.nextInt();
        System.out.println("\n----- KEY GENERATION -----\n");
        keyGeneration();
        System.out.println("\n----- SIGNATURE GENERATION -----\n");
        S = signatureGeneration(d,n,M);
        System.out.println("Signature = "+S);
        System.out.println("\n----- VERIFICATION -----\n");
        P = Verification(e,n,M,S);
        System.out.println("Plaintext (S^e mod n) = "+P);
        if(M==P)
        {
            System.out.println("M = "+M+"\nP = "+P+"\nSignature Verified!!");
        }
    }
    static int pow(int a,int b,int n)
    {
        int sum=a;
        while(b>1)
        {
            sum*=a;
            sum%=n;
            b--;
        }
        return sum;
    }
    static int signatureGeneration(int d,int n,int M)
    {
        System.out.println("Private Key = ["+d+","+n+"]");
        System.out.println("Ciphertext = "+M);
        int m=pow(M,d,n);
        return m;
    }
    static int Verification(int e,int n,int M,int S)
    {
        System.out.println("Public Key = ["+e+","+n+"]");
        System.out.println("Signature = "+S);
        int c=pow(S,e,n);
        return c;
    }
    static void keyGeneration()
    {
        n=p*q;
        System.out.println("n = "+n);
        pn=(p-1)*(q-1);
        System.out.println("pi(n) = "+pn);
        d=inverseModular(pn,e,0,1);
        if(d<0)
        {
            d+=pn;
        }
        System.out.println("d = "+d);
        System.out.println("Public Key = ["+e+","+n+"]");
        System.out.println("Private Key = ["+d+","+n+"]");
    }
    static int inverseModular(int a,int b,int s1,int s2)
    {
        if(b==0)
        {
            return s1;
        }
        int qu=a/b;
        int r=a%b;
        int s=s1-(qu*s2);
        s1 =inverseModular(b, r, s2, s);
        return s1;
    }
}
