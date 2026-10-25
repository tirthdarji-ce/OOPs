import java.io.Serializable;

import model.annotation.Id;
import model.annotation.Positive;
import modell.annotation.*;
public class Account implements Serializable {
    @Id private final String accountNumber;
    private String ownerName;
    @Positive private long balance;
    private static int counter=0;
    public Account(String owner,long balance){accountNumber=String.format("AC%04d",++counter);ownerName=owner;this.balance=balance;}
    public String toString(){return accountNumber+" | "+ownerName+" | "+balance;}
}
