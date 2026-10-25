@FunctionalInterface
public interface SwitchRule {
    boolean maySwitchOn(Switchable device, int hour);
}
