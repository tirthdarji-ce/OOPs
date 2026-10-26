import java.util.*;
public class MiniBank_10 {
    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.print("Starting balance: ");long opening=sc.nextLong();
        System.out.print("Number of deposit tasks: ");int n=sc.nextInt();
        Account_10 a=new Account_10("Tirth",opening);TransactionProcessor_10 p=new TransactionProcessor_10();
        for(int i=0;i<n;i++){System.out.print("Deposit "+(i+1)+": ");long x=sc.nextLong();p.submit(()->a.deposit(x));}
        p.stop();System.out.println("Final balance: "+a.getBalance());
        System.out.println("For transfers, always lock the lower account number first to avoid deadlock.");
    }
}
