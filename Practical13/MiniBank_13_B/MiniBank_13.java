import java.util.*;
public class MiniBank_13 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);Repository_13<Account_13> repo=new Repository_13<>();
        System.out.print("Account 1 owner balance: ");String n1=sc.next();long b1=sc.nextLong();
        System.out.print("Account 2 owner balance: ");String n2=sc.next();long b2=sc.nextLong();
        System.out.print("Account 3 owner balance: ");String n3=sc.next();long b3=sc.nextLong();

        Account_13 a1=new Account_13(n1,b1),a2=new Account_13(n2,b2),a3=new Account_13(n3,b3);repo.saveAll(a1,a2,a3);
        System.out.print("Account number to find: ");String id=sc.next();System.out.println("Found: "+repo.findById(id));
        for(Account_13 a:repo.findAll())System.out.println(a);
        System.out.println("Total stored: "+repo.size());
        
        Repository_13<Customer_13> customers=new Repository_13<>();customers.save(new Customer_13("AC0001","Tirthu_20"));System.out.println("Customer repository: "+customers.findAll());
    }
}
