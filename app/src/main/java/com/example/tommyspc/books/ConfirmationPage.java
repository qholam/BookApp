package com.example.tommyspc.books;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ConfirmationPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_page);
    }


    public void goToMyBooks(View v) {
        Intent intent = new Intent(this, MyBooksList.class);
        startActivity(intent);

        //todo: remove this code below, it is currently just used to see if books save
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

        System.out.println(contents);
    }
}
