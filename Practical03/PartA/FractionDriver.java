import java.util.*;
public class FractionDriver {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter numerator denominator for first fraction: "); Fraction a=new Fraction(sc.nextInt(),sc.nextInt());
        System.out.print("Enter numerator denominator for second fraction: "); Fraction b=new Fraction(sc.nextInt(),sc.nextInt());
        System.out.println(a+" = "+b+" ? "+a.equals(b));
    }
}
