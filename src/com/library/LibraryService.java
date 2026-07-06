package com.library;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class LibraryService {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();
    private ArrayList<IssueRecord> issuedBooks = new ArrayList<>();

    // ---------------- BOOK ----------------

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book Added Successfully.");
    }

    public void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void searchBook(String keyword) {
        boolean found = false;

        for (Book b : books) {
            if (b.getBookName().toLowerCase().contains(keyword.toLowerCase())
                    || b.getAuthorName().toLowerCase().contains(keyword.toLowerCase())) {

                System.out.println(b);
                found = true;
            }
         }

        if (!found) {
            System.out.println("Book not found.");
        }
  
    } 
    // ---------------- MEMBER ----------------
    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member Added Successfully.");
    }

    public void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members found.");
            return;
        }
        for (Member m : members) {
            System.out.println(m);
        }
    }

    // ---------------- ISSUE BOOK ----------------

    public void issueBook(int bookId, int memberId) {

        Book book = null;

        for (Book b : books) {
            if (b.getBookId() == bookId) {
                book = b;
                break;
            }
        }

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.getQuantityAvailable() <= 0) {
            System.out.println("Book not available.");
            return;
        }

        book.setQuantityAvailable(book.getQuantityAvailable() - 1);

        issuedBooks.add(new IssueRecord(bookId, memberId, LocalDate.now()));

        System.out.println("Book Issued Successfully.");
    }

    // ---------------- RETURN BOOK ----------------

    public void returnBook(int bookId, int memberId) {

        IssueRecord record = null;

        for (IssueRecord r : issuedBooks) {
            if (r.getBookId() == bookId && r.getMemberId() == memberId) {
                record = r;
                break;
            }
        }

        if (record == null) {
            System.out.println("No issue record found.");
            return;
        }

        Book book = null;

        for (Book b : books) {
            if (b.getBookId() == bookId) {
                book = b;
                break;
            }
        }

        if (book != null) {
            book.setQuantityAvailable(book.getQuantityAvailable() + 1);
        }

        long days = ChronoUnit.DAYS.between(record.getIssueDate(), LocalDate.now());

        double fine = 0;

        if (days > 7 && days <= 15) {
            fine = (days - 7) * 10;
        } else if (days > 15) {
            fine = (8 * 10) + ((days - 15) * 20);
        }

        System.out.println("Book Returned Successfully");
        System.out.println("Days: " + days);
        System.out.println("Fine: ₹" + fine);

        issuedBooks.remove(record);
    }

    // ---------------- ISSUED BOOKS ----------------

    public void viewIssuedBooks() {
        if (issuedBooks.isEmpty()) {
            System.out.println("No issued books.");
            return;
        }
        for (IssueRecord r : issuedBooks) {
            System.out.println(r);
        }
    }
}