package com.example.tommyspc.books;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Tommy's PC on 11/28/2016.
 * Compiles all common buttons between multiple into this one file so all guis can use them.
 * This avoids having to rewrite code
 */

public class CommonButtons extends AppCompatActivity {

    /**
     * Return to main menu
     * @param v
     */
    public void returnToMainMenu(View v){
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }

    /**
     * Return to page to enter book info
     * @param v
     */
    public void back(View v){
        Intent intent = new Intent(this, SellerEnterBookInfo.class);
        startActivity(intent);
    }
}
