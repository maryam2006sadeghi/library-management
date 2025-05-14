package library;

import datastructures.lists.CustomLinkedList;
import datastructures.stacks.CustomStack;

public class Member {
    private String memberId;
    private String name;
    private CustomLinkedList<Transaction> customLinkedList;
    private Transaction lastTransaction;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        customLinkedList = new CustomLinkedList<>();
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }

    public void addTransaction(Transaction transaction) {
        customLinkedList.addLast(transaction);
        lastTransaction = transaction;
    }

    public Transaction getLastTransaction() {
        return lastTransaction;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId='" + memberId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
