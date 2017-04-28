package ru.alternation.Other.stepik_contest_java.functionals;


import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 Almost like a SQL: the total sum of transactions by each account

 You have two classes:
    Account: number: String, balance: Long
    Transaction: uuid: String, sum: Long, account: Account
 Both classes have getters for all fields with the corresponding names (getNumber(), getSum(), getAccount() and so on).

 TASK: Write a collector that calculates the total sum of transactions (long type, not integer) by each account
 (i.e. by account number). The collector will be applied to a stream of transactions.

 Classes Transaction and Account will be available during testing. You can create your own classes for local testing.

 You should write only the collector in any valid formats but without ; on the end.
 It will be passed as the argument to the collect() method of the stream.

 Examples of the valid solution formats: Collectors.reducing(...) or reducing(...)

 */
public class Main31 {
    public static void main(String[] args) {
        Account a1 = new Account("u_001");
        Account a2 = new Account("u_002");
        Account a3 = new Account("u_003");
        Transaction t1 = new Transaction("01T", a1, 100L);
        Transaction t2 = new Transaction("02T", a1, 900L);
        Transaction t3 = new Transaction("03T", a1, 444L);
        Transaction t4 = new Transaction("04T", a2, 3200L);
        Transaction t5 = new Transaction("05T", a2, 888L);
        Transaction t6 = new Transaction("06T", a3, 6666L);

        Map<String, Long> collect = Stream.of(t1, t2, t3, t4, t5, t6)
                .collect(
                        //Collectors.groupingBy((Transaction t) -> t.getAccount().getNumber(), Collectors.summingLong((Transaction t) -> t.getAccount().getBalance())) // not like this
                        Collectors.groupingBy((Transaction t) -> t.getAccount().getNumber(), Collectors.summingLong(Transaction::getSum))
                );

        System.out.println(collect); // {u_002=4088, u_003=6666, u_001=1444}


        // another answer
        Collectors.toMap((Transaction kTran) -> kTran.getAccount().getNumber(), Transaction::getSum, Long::sum);
    }

    static class Transaction {
        private String uuid;
        private Long sum;
        private Account account;

        public String getUuid() {
            return uuid;
        }

        public Long getSum() {
            return sum;
        }

        public Account getAccount() {
            return account;
        }

        public Transaction(String uuid, Account account, Long sum) {
            this.uuid = uuid;
            this.account = account;
            this.sum = sum;
        }
    }

    static class Account {
        private String number;
        private Long balance;

        public String getNumber() {
            return number;
        }

        public Long getBalance() {
            return balance;
        }

        public Account(String number) {
            this.number = number;
        }
    }
}
