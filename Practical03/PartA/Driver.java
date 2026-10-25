import java.util.*;
public class Driver {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("How many points? "); int n=sc.nextInt();
        Point[] a=new Point[n];
        int distinct=0;
        for(int i=0;i<n;i++){
            System.out.print("X Y: "); a[i]=new Point(sc.nextInt(),sc.nextInt());

            boolean seen=false;
            for(int j=0;j<i;j++) if(a[i].equals(a[j])) {seen=true;break;}
            if(!seen) distinct++;
        }
        System.out.println("Points: "+Arrays.toString(a));
        System.out.println("Distinct: "+distinct);
    }
}
