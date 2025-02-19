package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса, осуществляющего переводы с одного счета на другой
 * @author BOGDANOVA ANNA
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей системы с привязанными к ним счетами
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и добавляет к нему пустой список
     * @param user пользователь, который добавляется
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод принимает на вход паспорт пользователя
     * @param passport паспорт, по которому ищем и удаляем пользователя
     */
    public void deleteUser(String passport) {
        users.remove(findByPassport(passport));
    }

    /**
     * Метод принимает на вход паспорт пользователя и счет.
     * Метод проверяет, что такого счета у пользователя еще нет
     * @param passport паспорт, по которому ищем пользователя
     * @param account счет, добавляемый к пользователю
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход паспорт пользователя и ищет по нему пользователя
     * @param passport паспорт, по которому находим пользователя
     * @return возвращает пользователя или null, если ничего не найдено
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод позволяет найти счет пользователя по реквизитам
     * Метод должен проверить, что найденный пользователь имеет значение отличное от null
     * Потом получает список счетов этого пользователя и в нем находит нужный счет
     * @param passport паспорт, по которому ищем пользователя
     * @param requisite реквизиты, по которым ищем счет
     * @return возвращает  счет пользователя
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = getAccounts(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт
     * @param sourcePassport паспорт пользователя-отправителя
     * @param sourceRequisite счет, с которого переводят
     * @param destinationPassport паспорт пользователя-получателя
     * @param destinationRequisite счет, на который переводят
     * @param amount сумму перевода
     * @return возвращает false, если счёт не найден или не хватает денег с которого переводят
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account source = findByRequisite(sourcePassport, sourceRequisite);
        Account dest = findByRequisite(destinationPassport, destinationRequisite);
        if (source != null
                && dest != null
                    && source.getBalance() >= amount) {
            source.setBalance(source.getBalance() - amount);
            dest.setBalance(dest.getBalance() + amount);
            return true;
        }
        return false;
    }

    /**
     * Метод принимает на вход пользователя и позволяет получить список его счетов
     * @param user пользователь, по которому ищем счета
     * @return возвращает список счетов пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
