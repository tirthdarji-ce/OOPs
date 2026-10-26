import java.util.*;
import java.util.concurrent.*;
public class AccountStore_12 {
    private HashMap<String,Account_12> accounts=new HashMap<>(); private ArrayList<String> history=new ArrayList<>(); private ConcurrentHashMap<String,Account_12> shared=new ConcurrentHashMap<>();
    public void add(Account_12 a){accounts.put(a.getAccountNumber(),a);shared.put(a.getAccountNumber(),a);history.add("Added "+a.getAccountNumber());}
    public Account_12 get(String id){return accounts.get(id);} public ArrayList<Account_12> getAll(){return new ArrayList<>(accounts.values());}
    public ArrayList<Account_12> sortedByBalance(){ArrayList<Account_12> x=getAll();x.sort(Comparator.comparingLong(Account_12::getBalance).reversed());return x;}
}
