package com.example.tommyspc.books;

import android.content.Intent;
import android.content.res.AssetManager;
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

        //todo: display book a user owns based on a database, currently we are using a text file
        /*read from text file books are saved in and print*/
        File path = this.getApplication().getFilesDir();
        File filesell = new File(path, "booksforsell.txt");
        File filerent = new File(path, "booksforrent.txt");

        int length = (int) filesell.length();
        int length2 = (int) filerent.length();

        byte[] bytes = new byte[length];
        byte[] bytes2 = new byte[length2];

        try {
            FileInputStream in = new FileInputStream(filesell);
            in.read(bytes);
            in.close();
            FileInputStream in2 = new FileInputStream(filerent);
            in2.read(bytes2);
            in2.close();
        }
        catch(IOException io){

        }


        String contents = new String(bytes) + new String(bytes2);

        TextView booksView = (TextView) findViewById(R.id.books);
        booksView.setText(contents);
    }
}
