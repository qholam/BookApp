package com.example.tommyspc.books;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;


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
        //TODO: save book to an actual database, currently we are saving it locally on  a text file
        try
        {
            String info = book.getInfo();
            FileOutputStream fos = openFileOutput("books.txt", Context.MODE_APPEND);
            fos.write(info.getBytes());
            fos.close();
        }
        catch(IOException ioe)
        {
            //TODO: do something if this fails
            System.err.println("#$^@$^@#^#$^#$^IOException: " + ioe.getMessage());
        }
        catch(Exception e){
            System.err.println("@$@4$#$Error: " + e.getMessage());
        }

        Intent intent = new Intent(this, ConfirmationPage.class);
        startActivity(intent);
    }
}
