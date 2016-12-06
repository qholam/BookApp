package com.example.tommyspc.books;

import java.io.Serializable;

/**
 * Created by Tommy's PC on 12/3/2016.
 * This represents a book in our database.
 */

@SuppressWarnings("serial")
public class Book implements Serializable{
    /*properties of the book*/
    String bookTitle;
    String author;
    String edition;
    String classId;
    int ISBN;
    boolean forSell;
    boolean forRent;
    int price;
    int rentDuration; /*in days*/

    /**
     * Create a book given a title, author, and class its for
     * @param title title of book
     * @param author author of book
     * @param classId class this book is for
     */
    public Book(String title, String author, String classId, String edition){
        bookTitle = title;
        this.author = author;
        this.classId = classId;
        this.edition = edition;
    }

    /**
     * Prints out info on this book
     */
    public void printInfo(){
        System.out.println("Title: " + bookTitle +
                            " Author: " + author +
                            " Edition: " + edition +
                            " Class: " + classId +
                            " ISBN: " + ISBN +
                            " forSell: " + forSell +
                            " forRent: " + forRent +
                            " price: " + price +
                            " rentDuration: " + rentDuration);

    }

    /**
     * Return info on this book in the form of a string
     */
    public String getInfo(){
        String info = "Title: " + bookTitle +
                    " | Author: " + author +
                    " | Edition: " + edition +
                    " | Class: " + classId +
                    " | ISBN: " + ISBN +
                    " | forSell: " + forSell +
                    " | forRent: " + forRent +
                    " | price: " + price +
                    " | rentDuration: " + rentDuration;

        return info;
    }


    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public boolean isForSell() {
        return forSell;
    }

    public void setForSell(boolean forSell) {
        this.forSell = forSell;
        this.forRent = !forSell;
    }

    public boolean isForRent() {
        return forRent;
    }

    public void setForRent(boolean forRent) {
        this.forRent = forRent;
        this.forSell = !forRent;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRentDuration() {
        return rentDuration;
    }

    public void setRentDuration(int rentDuration) {
        this.rentDuration = rentDuration;
    }
}
