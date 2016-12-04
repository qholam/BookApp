package com.example.tommyspc.books;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SellCostInfo extends CommonButtons{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO: 12/3/2016 set widget on top of page to reflect book info
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_cost_info);
    }

    /**
     * Goes to page to take picture of book
     * Saves the info that the user enters
     * @param v
     */
    public void postIt(View v){
        /*Get book object passed to us*/
        Intent i = getIntent();
        Book book = (Book) i.getSerializableExtra("book");

        /*Save info entered from this page*/
        //todo: error checking if user doesn't enter an int
        EditText priceView = (EditText) findViewById(R.id.loanTime);
        int price = Integer.parseInt(priceView.getText().toString());
        book.setPrice(price);

        /*pass book object to page that will handle taking a picture of the book*/
        Intent intent = new Intent(this, BookPicture.class);
        intent.putExtra("book", book);
        startActivity(intent);
    }
}
