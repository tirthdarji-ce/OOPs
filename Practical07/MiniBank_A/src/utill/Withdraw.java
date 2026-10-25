package utill;
import modell.Accountt;
@FunctionalInterface
public interface Withdraw {
    boolean allow(Accountt account, long amount);
}
