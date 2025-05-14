package management;

import datastructures.lists.CustomArrayList;
import library.Book;
import library.Member;
import library.Transaction;

import java.util.ArrayList;
import java.util.Date;

public class TransactionManager {
    private CustomArrayList<Transaction> customArrayList;
    public TransactionManager() {
        customArrayList = new CustomArrayList<>();
    }

    public Transaction addTransaction(String bookTitle, String memberName, String type) {

        Transaction transaction = new Transaction(
                "TXN-" + new Date().getTime(),
                bookTitle,
                memberName,
                type
        );

        customArrayList.add(transaction);
        return transaction;
    }

    public Transaction getTransactionByIndex(int index) {
        return customArrayList.get(index);
    }
}
