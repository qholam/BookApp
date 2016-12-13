package com.example.tommyspc.books;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class BookPicture extends CommonButtons{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_picture);
    }

    /**
     * Called when the "Take Picture" button is clicked.
     * Takes a picture and associates it with the listing
     * @param v
     */
    public void takePicture(View v){
        //todo: take picture and so stuff
    }

    /**
     * Takes user to confirmation page after saving book to database
     * @param v
     */
    public void confirm(View v){
        /*Get book object*/
        Intent i = getIntent();
        Book book = (Book) i.getSerializableExtra("book");

        /*Save book to database*/
        book.save(this);

        Intent intent = new Intent(this, ConfirmationPage.class);
        startActivity(intent);
    }
}
