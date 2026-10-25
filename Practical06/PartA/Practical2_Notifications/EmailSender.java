public class EmailSender implements Urgent {
    private String email;

    public EmailSender(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
