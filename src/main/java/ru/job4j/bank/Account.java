package ru.job4j.bank;

import java.util.Objects;

/**
 * Класс описывает модель банковского счета
 * @author BOGDANOVA ANNA
 * @version 1.0
 */
public class Account {
    /**
     * Реквизиты счета
     */
    private String requisite;
    /**
     * Баланс на счете
     */
    private Double balance;

    /**
     * Создание счета пользователя
     * @param requisite реквизиты счета
     * @param balance баланс на счете
     */
    public Account(String requisite, Double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    /**
     * Метод позволяет получить реквизиты счета
     * @return реквизиты счета
     */
    public String getRequisite() {
        return requisite;
    }

    /**
     * Метод присваивает реквизиты счета
     * @param requisite реквизиты счета
     */
    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    /**
     * Метод позволяет получить баланс счета
     * @return возвращает баланс счета
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Метод присваивает значение балансу на счете
     * @param balance возвращает баланс на счете
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /**
     * Метод принимает объект и позволяет сравнить его с текущим
     * @param o входящий объект
     * @return вернет true, если объекты равны. В противном случае - false
     * Возвращает результат сравнения по реквизиту счета
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return Objects.equals(requisite, account.requisite);
    }

    /**
     * Метод возвращает хеш-код реквизитов счета
     * @return возвращает хеш-код реквизитов счета
     */
    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
