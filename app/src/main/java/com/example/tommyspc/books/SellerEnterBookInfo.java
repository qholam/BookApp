package com.example.tommyspc.books;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.text.TextUtils.isEmpty;

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
        if(notEmpty()) {
            /*create the book*/
            Book book = createBook();

            /*set as for sell*/
            book.setForSell(true);

            Intent intent = new Intent(this, SellCostInfo.class);
            intent.putExtra("book", book);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Take user to page to enter info on book they want to rent out
     * @param v
     */
    public void rent(View v){
        if(notEmpty()) {
            /*create the book*/
            Book book = createBook();

            /*set as for sell*/
            book.setForRent(true);

            Intent intent = new Intent(this, RentCostInfo.class);
            intent.putExtra("book", book);
            startActivity(intent);
        }
        else{
            Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Creates a book object based on what was enetered by the user
     */
    private Book createBook(){
        /*get info that user entered*/
        EditText titleView = (EditText) findViewById(R.id.bookTitle);
        EditText authorView = (EditText) findViewById(R.id.author);
        EditText classView = (EditText) findViewById(R.id.classId);
        EditText editionView = (EditText) findViewById(R.id.edition);

        String title = titleView.getText().toString();
        String author = authorView.getText().toString();
        String classId = classView.getText().toString();
        String edition = editionView.getText().toString();

        /*Create the book*/
        Book book = new Book(title, author, classId, edition);

        return book;
    }

    private boolean notEmpty(){
        /*get info that user entered*/
        EditText titleView = (EditText) findViewById(R.id.bookTitle);
        EditText authorView = (EditText) findViewById(R.id.author);
        EditText classView = (EditText) findViewById(R.id.classId);
        EditText editionView = (EditText) findViewById(R.id.edition);

        if(isEmpty(titleView.getText().toString()) || isEmpty(editionView.getText().toString()) || isEmpty(classView.getText().toString()) || isEmpty(authorView.getText().toString())){
            return false;
        }

        return true;
    }

}
