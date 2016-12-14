package com.example.tommyspc.books;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ImageView;
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
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, 1);
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        ImageView imgView = (ImageView) findViewById(R.id.imageView3);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imgView.setImageBitmap(imageBitmap);
        }

        //todo save image to a gaallery database on cloud, so it can be displayed
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
