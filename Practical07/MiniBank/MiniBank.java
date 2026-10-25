import java.util.*;
public class MiniBank {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Balance to validate (use -100 for error): ");long b=sc.nextLong();
        Account a=new Account("Riya",b);
        String[] errors=AnnotationValidator.validate(a);
        if(errors.length==0)System.out.println("No errors.");
        else for(String e:errors)System.out.println(e);
    }
}
