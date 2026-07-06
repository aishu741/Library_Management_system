package com.library;

public class Book {

    private int bookId;
    private String bookName;
    private String authorName;
    private String category;
    private int quantityAvailable;

    public Book(int bookId,
                String bookName,
                String authorName,
                String category,
                int quantityAvailable) {

        this.bookId = bookId;
        this.bookName = bookName;
        this.authorName = authorName;
        this.category = category;
        this.quantityAvailable = quantityAvailable;
    }

    // ✅ GETTERS (VERY IMPORTANT)

    public int getBookId() {
        return bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantityAvailable() {
        return quantityAvailable;
    }

    public void setQuantityAvailable(int quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId +
                ", Name: " + bookName +
                ", Author: " + authorName +
                ", Category: " + category +
                ", Quantity: " + quantityAvailable;
    }
}