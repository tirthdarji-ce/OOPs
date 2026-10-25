package util;

import model.Account;

@FunctionalInterface
public interface WithdrawRule {
    boolean allow(Account account, long amount);
}
