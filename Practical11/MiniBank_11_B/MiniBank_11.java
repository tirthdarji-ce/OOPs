import java.nio.file.*; import java.util.*;
public class MiniBank_11 {
    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);
        System.out.print("Owner 1: ");String n1=sc.nextLine();System.out.print("Balance 1: ");long b1=sc.nextLong();
        System.out.print("Owner 2: ");String n2=sc.next();System.out.print("Balance 2: ");long b2=sc.nextLong();
        Account_11[] a={new Account_11(n1,b1),new Account_11(n2,b2)};

        Path data=Path.of("data");Path accounts=data.resolve("accounts.dat");Path logs=data.resolve("logs/transactions.log");
        StatePersister_11.save(a,accounts);TransactionLog_11.append(logs,"DEPOSIT "+a[0].getAccountNumber()+" 500");TransactionLog_11.append(logs,"WITHDRAW "+a[1].getAccountNumber()+" 200");
        Account_11[] loaded=StatePersister_11.load(accounts);for(Account_11 x:loaded)System.out.println("Loaded: "+x);
        ReportGenerator_11.generate(data.resolve("logs"),data.resolve("report.txt"));
        System.out.println(Files.readString(data.resolve("report.txt")));
    }
}
