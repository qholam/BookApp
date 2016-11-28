package com.example.tommyspc.books;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SellCostInfo extends CommonButtons{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_cost_info);
    }

    /**
     * Goes to page to take picture of book
     * Saves the info that the user enters
     * @param v
     */
    public void postIt(View v){
        Intent intent = new Intent(this, BookPicture.class);
        startActivity(intent);

        //todo: save info user enters
    }
}
