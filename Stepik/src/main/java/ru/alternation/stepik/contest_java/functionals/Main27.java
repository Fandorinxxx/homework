package ru.alternation.stepik.contest_java.functionals;

import java.util.Date;
import java.util.List;

/**
 2.27 The total sum of canceled transactions

 You have two classes:

    Transaction: uuid: String,  state: State (canceled, finished, processing), sum: Long, created: Date
    Account: number: String, balance: Long, transactions: List<Transaction>
 Both classes have getters for all fields with the corresponding names (getState(), getSum(), getTransactions() and so on).

 TASK: write a method using Stream API that calculates the total sum of canceled transactions for all non empty accounts
 (balance > 0). Perhaps, flatMap method can help you to implement it.


 Classes Transaction, Account and enum State will be available during testing. You can define your own classes
 for local testing.

 NOTE: Use the given template for your method. Pay attention to type of an argument and the returned value.
 Please, use only Stream API, no cycles.

 Example. There are 2 accounts (in JSON notation) below. The result is 10 000.

 [
 {
 "number": "1001",
 "balance": 0,
 "transactions": [
 {
 "uuid": "774cedda-9cde-4f53-8bc2-5b4d4859772a",
 "state": "canceled",
 "sum": 1000,
 "created": "2016.12.12 18:30:05"
 }
 ]
 },
 {
 "number": "1002",
 "balance": 8000,
 "transactions": [
 {
 "uuid": "337868a7-f469-43c0-9042-3422ce37ee26a",
 "state": "finished",
 "sum": 8000,
 "created": "2016.12.12 17:30:55"
 },
 {
 "uuid": "f8047f86-89e7-4226-8b75-74c55a4d7e31",
 "state": "canceled",
 "sum": 10000,
 "created": "2016.12.12 18:10:18"
 }
 ]
 }
 ]﻿﻿


 */
public class Main27 {
    /**
     * Calculates the general sum of canceled transactions for all non empty accounts in the list
     */
    public static long calcSumOfCanceledTransOnNonEmptyAccounts(List<Account> accounts) {

        return accounts.stream()
                .filter(account -> account.getBalance() > 0)
                .map(Account::getTransactions) //
                .flatMap(List::stream)         // .flatMap(a -> a.getTransactions().stream())
                .filter(transaction -> State.canceled.equals(transaction.getState())) // можно и через ==
                .mapToLong(Transaction::getSum)
                .sum();
    }


    static class Transaction {
        private String uuid;
        private State state;
        private Long sum;
        private Date created;

        public String getUuid() {
            return uuid;
        }

        public State getState() {
            return state;
        }

        public Long getSum() {
            return sum;
        }

        public Date getCreated() {
            return created;
        }
    }

    enum State {
        canceled,
        finished,
        processing
    }

    static class Account {
        private String number;
        private Long balance;
        private List<Transaction> transactions;

        public String getNumber() {
            return number;
        }

        public Long getBalance() {
            return balance;
        }

        public List<Transaction> getTransactions() {
            return transactions;
        }
    }
}
