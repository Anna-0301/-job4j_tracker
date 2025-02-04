package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, users.get(user));
    }

    public void deleteUser(String passport) {
        User user = findByPassport(passport);
        if (user == null) {
            return;
        }
        if (user.getPassport().equals(passport)) {
            users.remove(user);
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user == null) {
            return;
        }
        List<Account> accounts = getAccounts(user);
        if (accounts.isEmpty() || !accounts.contains(account)) {
            accounts.add(account);
            users.put(user, accounts);
        }
    }

    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user == null) {
            return null;
        }
        List<Account> accounts = getAccounts(user);
        for (Account account : accounts) {
            if (account.getRequisite().equals(requisite)) {
                return account;
            }
        }
        return null;
    }

    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        if (!sourcePassport.equals(destinationPassport)) {
            return false;
        }
        User user = findByPassport(sourcePassport);
        List<Account> accounts = getAccounts(user);
        Account accountSource = null;
        Account accountDest = null;
        for (Account account : accounts) {
            if (account.getRequisite().equals(sourceRequisite)) {
                accountSource = account;
            } else if (account.getRequisite().equals(destinationRequisite)) {
                accountDest = account;
            }
        }
        if (accountSource == null || accountDest == null) {
            return false;
        }
        if (accountSource.getBalance() >= amount) {
            accountSource.setBalance(accountSource.getBalance() - amount);
            accountDest.setBalance(accountDest.getBalance() + amount);
            return true;
        }
        return false;
    }

    public List<Account> getAccounts(User user) {
        List<Account> accounts = new ArrayList<>();
        if (users.get(user) != null) {
            accounts.addAll(users.get(user));
        }
        return accounts;
    }
}
