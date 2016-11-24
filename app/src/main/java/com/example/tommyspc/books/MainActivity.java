package com.example.tommyspc.books;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void seller(View view){
        Intent intent = new Intent(this, SellerEnterBookInfo.class);
        startActivity(intent);
    }

    public void sell(View view){
        Intent intent = new Intent(this, SellCostInfo.class);
        startActivity(intent);
    }

    public void rent(View view){
        Intent intent = new Intent(this, RentCostInfo.class);
        startActivity(intent);
    }

    public void picture(View view){
        Intent intent = new Intent(this, BookPicture.class);
        startActivity(intent);
    }

    public void main(View view){
        Intent intent = new Intent(this, ConfirmationPage.class);
        startActivity(intent);
    }

    public void main2(View view){
        Intent intent = new Intent(this, MyBooksList.class);
        startActivity(intent);
    }
}
