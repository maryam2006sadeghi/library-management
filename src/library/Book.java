package library;

import datastructures.lists.CustomLinkedList;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    private CustomLinkedList<Member> customLinkedList;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
        customLinkedList = new CustomLinkedList<Member>();
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }

    public void addToWaitlist(Member member) {
        if (member == null) {
            throw new NullPointerException();
        }
        customLinkedList.add(member);
    }

    public Member getNextInWaitlist() {
        if (customLinkedList.isEmpty())
            return null;

        return customLinkedList.removeFirst();
    }

    public boolean hasWaitlist() {
        return !customLinkedList.isEmpty();
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", available=" + isAvailable +
                '}';
    }
}