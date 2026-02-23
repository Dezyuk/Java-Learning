package OOP.PaymentsAndTransacationsProcessing;


import java.util.Arrays;

public class Account {
    private static final int DEFAULT_TRANSACTIONS_AMOUNT = 10;
    //    <write your code here>
    private int id;
    private Transaction[] transactions;
    private int lastTransactionIndex;

    {
        transactions = new Transaction[DEFAULT_TRANSACTIONS_AMOUNT];
    }

    public Account(int id) {
        this.id = id;
    }

    public void sendMoneyToAccount(Account accountTo, double moneyAmount) {
//	    <write your co
        if (accountTo == null || moneyAmount <= 0) {
            return;
        }
        Transaction transaction = new Transaction(this, accountTo, moneyAmount, StandardAccountOperations.MONEY_TRANSFER_SEND);
        addTransaction(transaction);
        accountTo.receiveMoney(this, moneyAmount);

    }

    private void receiveMoney(Account accountFrom, double moneyAmount) {
        if (accountFrom == null || moneyAmount <= 0) {
            return;
        }
        Transaction transaction = new Transaction(accountFrom, this, moneyAmount, StandardAccountOperations.MONEY_TRANSFER_RECEIVE);
        addTransaction(transaction);
    }

    private void addTransaction(Transaction transaction) {
        if (transaction == null) {
            return;
        }
        if (transactions.length <= lastTransactionIndex) {
            transactions = Arrays.copyOf(transactions, transactions.length << 1);
        }
        transactions[lastTransactionIndex++] = transaction;

    }

    public void withdrawMoney(double moneyAmount) {
//		<write your code here>
        Transaction transaction = new Transaction(this, null, moneyAmount, StandardAccountOperations.WITHDRAW);
        addTransaction(transaction);
    }

    public Transaction[] getTransactions() {
//		<write your code here>

        int nonNullTransactionsAmount = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                nonNullTransactionsAmount++;
            }
        }

        Transaction[] filteredTransactions = new Transaction[nonNullTransactionsAmount];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                filteredTransactions[index++] = transaction;
            }
        }
        return filteredTransactions;
    }
    @Override
    public String toString() {
        return "Account ID: " + this.id;
    }

    public static class Transaction {

        private Account accountFrom;
        private Account accountTo;
        private double moneyAmount;
        private StandardAccountOperations operation;

        private Transaction(Account accountFrom, Account accountTo, double moneyAmount,
                            StandardAccountOperations moneyTransferOperation) {
            this.accountFrom = accountFrom;
            this.accountTo = accountTo;
            this.moneyAmount = moneyAmount;
            this.operation = moneyTransferOperation;
        }

        public Account getAccountFrom() {
            return accountFrom;
        }

        public void setAccountFrom(Account accountFrom) {
            this.accountFrom = accountFrom;
        }

        public Account getAccountTo() {
            return accountTo;
        }

        public void setAccountTo(Account accountTo) {
            this.accountTo = accountTo;
        }

        public double getMoneyAmount() {
            return moneyAmount;
        }

        public void setMoneyAmount(double moneyAmount) {
            this.moneyAmount = moneyAmount;
        }

        public StandardAccountOperations getOperation() {
            return operation;
        }

        public void setOperation(StandardAccountOperations operation) {
            this.operation = operation;
        }

        @Override
        public String toString() {
            return "Transaction [accountFrom=" + accountFrom + ", accountTo=" + accountTo
                    + ", moneyAmount=" + moneyAmount + ", operation=" + operation + "]";
        }

    }
}

