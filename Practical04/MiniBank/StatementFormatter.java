public class StatementFormatter {

    public static String buildStatement(Account account) {

        StringBuilder sb = new StringBuilder();

        sb.append("----- ACCOUNT STATEMENT -----\n");
        sb.append("Account Number: ")
          .append(account.getAccountNumber())
          .append("\n");

        sb.append("Balance: ")
          .append(account.getBalance())
          .append("\n");

        sb.append("-----------------------------");

        return sb.toString();
    }
}