package com.example.tommyspc.books;

import android.provider.BaseColumns;

/**
 * Created by Tommy's PC on 12/13/2016.
 */

public class BookContract {
    //make private to prevent someone from accidently instantiating the contract class
    private BookContract(){}

    /*inner class which defines the table contents*/
    public static class BookEntry implements BaseColumns{
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_AUTHOR = "author";
        public static final String COLUMN_EDITION = "edition";
        public static final String COLUMN_CLASS = "class";
        public static final String COLUMN_ISBN = "ISBN";
        public static final String COLUMN_STATUS = "status";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_RENT_DURATION = "duration";

    }
}
