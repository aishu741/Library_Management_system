package com.library;

import java.time.LocalDate;

public class IssueRecord {

    private int bookId;
    private int memberId;
    private LocalDate issueDate;

    // ✅ FIX: Constructor MUST match your usage
    public IssueRecord(int bookId, int memberId, LocalDate issueDate) {
        this.bookId = bookId;
        this.memberId = memberId;
        this.issueDate = issueDate;
    }

    public int getBookId() {
        return bookId;
    }

    public int getMemberId() {
        return memberId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId +
                ", Member ID: " + memberId +
                ", Issue Date: " + issueDate;
    }
}