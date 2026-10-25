public interface Switchable {
    void on();
    void off();

    default void toggle() {
        on();
    }
}
