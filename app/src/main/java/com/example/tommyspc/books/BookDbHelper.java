package com.example.tommyspc.books;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Tommy's PC on 12/13/2016.
 */

public class BookDbHelper extends SQLiteOpenHelper{
    private static final String TEXT_TYPE = " TEXT";
    private static final String NUMBER_TYPE = " INTEGER";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + BookContract.BookEntry.TABLE_NAME + " (" +
                    "_ID" + " INTEGER PRIMARY KEY," +
                    BookContract.BookEntry.COLUMN_TITLE + TEXT_TYPE + COMMA_SEP +
                    BookContract.BookEntry.COLUMN_AUTHOR + TEXT_TYPE + COMMA_SEP +
                    BookContract.BookEntry.COLUMN_EDITION + TEXT_TYPE + COMMA_SEP +
                    BookContract.BookEntry.COLUMN_CLASS + TEXT_TYPE + COMMA_SEP +
                    BookContract.BookEntry.COLUMN_ISBN + TEXT_TYPE + COMMA_SEP +
                    BookContract.BookEntry.COLUMN_STATUS + TEXT_TYPE + COMMA_SEP +
                    BookContract.BookEntry.COLUMN_PRICE + NUMBER_TYPE + COMMA_SEP +
                    BookContract.BookEntry.COLUMN_RENT_DURATION + NUMBER_TYPE + " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + BookContract.BookEntry.TABLE_NAME;

    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Book.db";

    public BookDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
