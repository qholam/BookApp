package com.example.tommyspc.books;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SellerEnterBookInfo extends CommonButtons {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_enter_book_info);
    }

    /**
     * Take user to page to enter info on book they want to sell
     * @param v
     */
    public void sell(View v){
        Intent intent = new Intent(this, SellCostInfo.class);
        startActivity(intent);
    }

    /**
     * Take user to page to enter info on book they want to rent out
     * @param v
     */
    public void rent(View v){
        Intent intent = new Intent(this, RentCostInfo.class);
        startActivity(intent);
    }
}
