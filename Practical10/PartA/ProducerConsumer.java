import java.util.*;
public class ProducerConsumer {
    static final Queue<Integer> q=new LinkedList<>(); static final int LIMIT=3;
    static class Buffer { synchronized void put(int x)throws InterruptedException{while(q.size()==LIMIT)wait();q.add(x);System.out.println("Produced "+x);notifyAll();} synchronized int get()throws InterruptedException{while(q.isEmpty())wait();int x=q.remove();System.out.println("Consumed "+x);notifyAll();return x;} }
    public static void main(String[] args)throws Exception{
        Scanner sc=new Scanner(System.in);System.out.print("Items: ");int n=sc.nextInt();Buffer b=new Buffer();
        Thread p=new Thread(()->{try{for(int i=1;i<=n;i++)b.put(i);}catch(Exception e){}});
        Thread c=new Thread(()->{try{for(int i=1;i<=n;i++)b.get();}catch(Exception e){}});
        p.start();c.start();p.join();c.join();System.out.println("Done.");
    }
}
