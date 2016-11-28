package com.example.tommyspc.books;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;


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
     *
     * @param v
     */
    public void confirm(View v){
        Intent intent = new Intent(this, ConfirmationPage.class);
        startActivity(intent);
    }
}
