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
        File file = new File(path, "books.txt");

        int length = (int) file.length();

        byte[] bytes = new byte[length];


        try {
            FileInputStream in = new FileInputStream(file);
            in.read(bytes);
            in.close();
        }
        catch(IOException io){

        }


        String contents = new String(bytes);

        System.out.println(contents);
    }
}
