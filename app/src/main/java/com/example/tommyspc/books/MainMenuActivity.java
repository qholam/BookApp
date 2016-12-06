package com.example.tommyspc.books;

import android.app.Activity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
/**
 * Created by Calvin on 11/17/16.
 */

public class MainMenuActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("MainMenu started");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);
    }

    public void seller(View view){
        Intent intent = new Intent(this, SellerEnterBookInfo.class);
        startActivity(intent);
    }

    public void buyer(View view){
        Intent intent = new Intent(this, SearchForBook.class);
        startActivity(intent);
    }
}
