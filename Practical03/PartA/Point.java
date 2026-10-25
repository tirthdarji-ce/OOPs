import java.util.Objects;
public class Point {
    private int x,y;
    public Point(int x,int y){this.x=x;this.y=y;}
    public String toString(){return "("+x+", "+y+")";}
    public boolean equals(Object o){
        if(this==o)return true;
        if(!(o instanceof Point))return false;
        Point p=(Point)o; return x==p.x && y==p.y;
    }
    public int hashCode(){return Objects.hash(x,y);}
}
