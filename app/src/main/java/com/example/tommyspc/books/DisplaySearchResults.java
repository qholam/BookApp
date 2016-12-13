package com.example.tommyspc.books;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DisplaySearchResults extends CommonButtons {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_search_results);

        displayResults(0);
    }

    public void goBack(View v){
        Intent intent = new Intent(this, SearchForBook.class);
        startActivity(intent);
    }

    /**
     * Displays results based on the search parameters provided by the intent
     */
    private void displayResults(int i){
        /*get intent*/
        Intent intent = this.getIntent();

        /*get search info from intent*/
        String title = intent.getStringExtra("title");
        String author = intent.getStringExtra("author");
        String edition = intent.getStringExtra("edition");
        String classId = intent.getStringExtra("class");

        /*search SQL database*/
        String status;
        if(i == 0)
            status = "sell";
        else
            status = "rent";

        BookDbHelper mDbHelper = new BookDbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection;
        if(i == 0){
            projection = new String[]{
                    BookContract.BookEntry.COLUMN_TITLE,
                    BookContract.BookEntry.COLUMN_AUTHOR,
                    BookContract.BookEntry.COLUMN_CLASS,
                    BookContract.BookEntry.COLUMN_PRICE
            };
        }
        else{
            projection = new String[]{
                    BookContract.BookEntry.COLUMN_TITLE,
                    BookContract.BookEntry.COLUMN_AUTHOR,
                    BookContract.BookEntry.COLUMN_CLASS,
                    BookContract.BookEntry.COLUMN_PRICE,
                    BookContract.BookEntry.COLUMN_RENT_DURATION
            };
        }

        // Filter results based on search criteria
        //todo come up with a better search algorithim
        String selection = BookContract.BookEntry.COLUMN_TITLE + " = ? AND " +
                BookContract.BookEntry.COLUMN_AUTHOR + " = ? AND " +
                BookContract.BookEntry.COLUMN_STATUS + " = ?";
        String[] selectionArgs;
        if(i == 0){
            selectionArgs = new String[]{
                    title,
                    author,
                    "sell"
            };
        }
        else{
            selectionArgs = new String[]{
                    title,
                    author,
                    "rent"
            };
        }

        Cursor c = db.query(
                BookContract.BookEntry.TABLE_NAME,        // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                      // The sort order
        );

        /*display search results*/
        StringBuilder builder = new StringBuilder();
        c.moveToFirst();
        while(!c.isAfterLast()){
            String s = "Title: " + c.getString(c.getColumnIndexOrThrow(BookContract.BookEntry.COLUMN_TITLE)) +
                    " || Author: " + c.getString(c.getColumnIndexOrThrow(BookContract.BookEntry.COLUMN_AUTHOR)) +
                    " || Price: " + c.getString(c.getColumnIndexOrThrow(BookContract.BookEntry.COLUMN_PRICE));
            if(i == 1)
                s += " || Rent Duration: " + c.getString(c.getColumnIndexOrThrow(BookContract.BookEntry.COLUMN_RENT_DURATION));

            builder.append(s).append("\n\n");

            c.moveToNext();
        }
        TextView books = (TextView) findViewById(R.id.bookList);
        books.setText(builder.toString());
    }

    public void displayRent(View v){
        displayResults(1);
    }

    public void displaySell(View v){
        displayResults(0);
    }
}
