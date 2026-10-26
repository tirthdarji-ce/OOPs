public class BankAccountSession_8 implements AutoCloseable {
    public void use() {
        System.out.println("AutoCloseable resource is in use.");
    }

    @Override
    public void close() {
        System.out.println("Bank account session closed automatically.");
    }
}
