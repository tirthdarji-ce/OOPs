import java.util.*;
public class Driver {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter password: ");
        PasswordChecker.check(sc.nextLine());
    }
}
