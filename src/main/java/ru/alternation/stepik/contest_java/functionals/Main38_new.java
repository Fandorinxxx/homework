package ru.alternation.stepik.contest_java.functionals;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 2.38 Optional in action

 There are two related tasks with a common domain model:
    Account (guid: UUID, balance: long)
    User (login: String, account: Account)
 Both classes have getters for all corresponding fields: getGuid(), getBalance(), getLogin(), getAccount().

 You need to write two method for processing domain objects.

========================================================================================================================

 You need to write a method findUserByLogin(String login) that returns an optional value of type Optional<User>.
 If the user exists in the "users" set you need to return non-empty optional wrapping the user inside,
 otherwise returned optional should be empty.

 Important. Use the provided template for your solution. Do not change it!


========================================================================================================================

 Using the method you wrote for finding an user by their login, write a new method printBalanceIfNotEmpty(String userLogin)
 that prints an account balance for an existing user if `balance > 0`. In this case, the result format should print the string:

 login: balance

 If the user is not found, account is null or the balance = 0, then the method should not print anything.

 Do not forget to use optional for avoiding NPE.

 */


public class Main38_new {

    static class Account {
        Integer guid;
        long balance;

        public Account(Integer guid, long balance) {
            this.guid = guid;
            this.balance = balance;
        }

        public Integer getGuid() {
            return guid;
        }

        public long getBalance() {
            return balance;
        }
    }

    static class User {
        String login;
        Account account;

        public User(String login, Account account) {
            this.login = login;
            this.account = account;
        }

        public String getLogin() {
            return login;
        }

        public Account getAccount() {
            return account;
        }
    }

    private static final Set<User> users = new HashSet<>();

    public static Optional<User> findUserByLogin(String login) {

        return users.stream()
                .filter((user) -> user.getLogin().equals(login))
                .findAny();
    }
    public static void printBalanceIfNotEmpty(String userLogin) {
        findUserByLogin(userLogin)
                .map(User::getAccount)
                .map(Account::getBalance)
                .filter(balance -> balance > 0)
                .ifPresent(balance -> System.out.println(userLogin + ": " + balance));
    }

//    public static void printBalanceIfNotEmpty(String userLogin) {
//        findUserByLogin(userLogin).ifPresent(user -> {
//            if (user.getAccount() != null) {
//                if (user.getAccount().getBalance() > 0){
//                    System.out.println(userLogin + ": " + user.getAccount().getBalance());
//                }
//            }
//        });
//    }


    public static void main(String[] args) {




    }
}
