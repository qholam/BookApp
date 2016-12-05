package com.example.tommyspc.books;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.text.TextUtils.isEmpty;

public class SellCostInfo extends CommonButtons{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_cost_info);

        updateViews();
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
        //todo: error checking if user enters nothing
        EditText priceView = (EditText) findViewById(R.id.price);
        if (isEmpty(priceView.getText().toString())) {
            Toast.makeText(this, "Please enter a loan duration and price", Toast.LENGTH_SHORT).show();
        }
        else {/*ensures text field is not empty*/
            int price = Integer.parseInt(priceView.getText().toString());
            book.setPrice(price);

            /*pass book object to page that will handle taking a picture of the book*/
            Intent intent = new Intent(this, BookPicture.class);
            intent.putExtra("book", book);
            startActivity(intent);
        }
    }

    public void updateViews(){
        /*Get book object passed to us*/
        Intent i = getIntent();
        Book book = (Book) i.getSerializableExtra("book");

        /*Get info we are interested in to be displayed on screen*/
        String title = book.getBookTitle();
        String author = book.getAuthor();

        /*Update the views to display this info*/
        TextView titleView = (TextView) findViewById(R.id.title);
        TextView authorView = (TextView) findViewById(R.id.author);
        titleView.setText(title);
        authorView.setText("by " + author);
    }
}
