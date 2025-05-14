package management;

import datastructures.maps.CustomHashMap;
import library.Book;
import library.Member;

public class BookManager {
    private CustomHashMap<String, Book> customHashMap;
    private MemberManager memberManager;

    public BookManager(MemberManager memberManager) {
        customHashMap = new CustomHashMap<>();
        this.memberManager = memberManager;
    }

    public void addBook(Book book) {
        customHashMap.put(book.getIsbn(), book);
    }

    public Book getBookByIsbn(String isbn) {
        return customHashMap.get(isbn);
    }

    public boolean isBookAvailable(String isbn) {
        Book book = customHashMap.get(isbn);
        return  book != null && book.isAvailable();
    }

    public void setBookAvailability(String isbn, boolean available) {
        Book book = getBookByIsbn(isbn);
        if (book != null) {
            book.setAvailable(available);
        }
    }

    public void addToWaitlist(String isbn, String memberId) {
       Book book = getBookByIsbn(isbn);
        book.addToWaitlist(memberManager.getMember(memberId));
    }

    public Member getNextFromWaitlist(String isbn) {
        Book book = getBookByIsbn(isbn);
        return book.getNextInWaitlist();
    }

    public boolean hasWaitlist(String isbn) {
        Book book = getBookByIsbn(isbn);
        return book.hasWaitlist();
    }
}