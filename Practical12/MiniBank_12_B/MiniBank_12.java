import java.util.*;
public class MiniBank_12 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);AccountStore_12 s=new AccountStore_12();
        
        System.out.print("Owner 1 and Balance: ");String n1=sc.next();long b1=sc.nextLong();
        System.out.print("Owner 2 and Balance: ");String n2=sc.next();long b2=sc.nextLong();
        System.out.print("Owner 3 and Balance: ");String n3=sc.next();long b3=sc.nextLong();
        s.add(new Account_12(n1,b1));s.add(new Account_12(n2,b2));s.add(new Account_12(n3,b3));
        for(Account_12 a:s.sortedByBalance())System.out.println(a);
        System.out.print("Account number to find: ");String id=sc.next();System.out.println("Found: "+s.get(id));
    }
}
