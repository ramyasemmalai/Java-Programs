import java.util.*;
public class ElgamalDS
{
    static Scanner in=new Scanner(System.in);
    public static void main(String []args)
    {
        System.out.println("***** 21BCT0427---RAMYA S *****\n");
        System.out.print("Enter q = ");
        int q=in.nextInt();
        System.out.print("Enter a ( alpha ) = ");
        int a=in.nextInt();
        System.out.print("Enter k ( k < q ) = ");
        int k=in.nextInt();
        System.out.print("Enter Xa ( Xa < q ) = ");
        int Xa=in.nextInt();
        System.out.print("Enter H(M) ( M < q ) = ");
        int M=in.nextInt();
        System.out.println("\n----- KEY GENERATION -----\n");
        int key = keyGeneration(a,Xa,q);
        System.out.println("Public Key = [ "+q+" , "+a+" , "+key+" ]\nPrivate Key = "+Xa);
        System.out.println("\n----- SIGNATURE GENERATION -----\n");
        int ct[] = signatureGeneration(q,a,Xa,M,k);
        System.out.println("Ciphertext = [ "+ct[0]+" , "+ct[1]+" ]");
        System.out.println("\n----- VERIFICATION -----\n");
        Verification(ct,key,q,a,M);
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
    static void Verification(int ct[],int Ya,int q,int a,int M)
    {
        System.out.println("Public Key = [ "+q+" , "+a+" , "+Ya+" ]");
        System.out.println("Signature = [ "+ct[0]+" , "+ct[1]+" ]");
        int v1=pow(a,M,q);
        int v2=(pow(Ya,ct[0],q)*pow(ct[0],ct[1],q))%q;
        System.out.println("V1 = "+v1+"\nV2 = "+v2);
        if(v1==v2)
        {
            System.out.println("Signature Verified!!");
        }
    }
    static int[] signatureGeneration(int q,int a,int Xa,int M,int k)
    {
        System.out.println("Private Key = [ "+Xa+" ]");
        System.out.println("Plaintext = "+M);
        int ciphertext[]=new int[2];
        ciphertext[0]=pow(a,k,q);
        int neg=inverseModular(q-1,k,0,1);
        int neg1=(neg*(M-(Xa*ciphertext[0])))%(q-1);
        while(neg1<0)
        {
            neg1+=q-1;
        }
        ciphertext[1]=neg1;
        return ciphertext;
    }
    static int keyGeneration(int a,int Xa,int q)
    {
        return pow(a,Xa,q);
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
