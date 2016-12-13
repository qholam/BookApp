package com.example.tommyspc.books;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

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
        //todo add something for
        ISBN = 0;
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

    /**
     * Adds this book to SQLite Database
     */
    //todo everything is saved locally currently, need to save to cloud
    public void save(Context c){
        BookDbHelper mDbHelper = new BookDbHelper(c);
        //get data repo in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        //create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(BookContract.BookEntry.COLUMN_TITLE, this.getBookTitle());
        values.put(BookContract.BookEntry.COLUMN_AUTHOR, this.getAuthor());
        values.put(BookContract.BookEntry.COLUMN_EDITION, this.getEdition());
        values.put(BookContract.BookEntry.COLUMN_CLASS, this.getClassId());
        values.put(BookContract.BookEntry.COLUMN_ISBN, this.getISBN());
        if(this.isForRent())
            values.put(BookContract.BookEntry.COLUMN_STATUS, "rent");
        else
            values.put(BookContract.BookEntry.COLUMN_STATUS, "sell");
        values.put(BookContract.BookEntry.COLUMN_PRICE, this.getPrice());
        values.put(BookContract.BookEntry.COLUMN_RENT_DURATION, this.getRentDuration());

        //insert the new row
        db.insert(BookContract.BookEntry.TABLE_NAME, null, values);
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
