package com.example.tommyspc.books;

import android.content.Intent;
import android.content.res.AssetManager;
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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static android.R.attr.path;

public class MyBooksList extends CommonButtons {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_books_list);

        //todo: this page currently displays all books in the database, filter this by users
        BookDbHelper mDbHelper = new BookDbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        String[] projection = new String[]{
                BookContract.BookEntry.COLUMN_TITLE,
                BookContract.BookEntry.COLUMN_AUTHOR,
                BookContract.BookEntry.COLUMN_CLASS,
                BookContract.BookEntry.COLUMN_PRICE,
                BookContract.BookEntry.COLUMN_STATUS
        };

        Cursor c = db.query(
                BookContract.BookEntry.TABLE_NAME,        // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
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
                    " || Class: " + c.getString(c.getColumnIndexOrThrow(BookContract.BookEntry.COLUMN_CLASS)) +
                    " || Price: " + c.getString(c.getColumnIndexOrThrow(BookContract.BookEntry.COLUMN_PRICE)) +
                    " || For: " + c.getString(c.getColumnIndexOrThrow(BookContract.BookEntry.COLUMN_STATUS));

            builder.append(s).append("\n\n");

            c.moveToNext();
        }

        TextView booksView = (TextView) findViewById(R.id.books);
        booksView.setText(builder.toString());
    }
}
