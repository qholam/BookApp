package com.example.tommyspc.books;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SearchForBook extends CommonButtons {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_for_book);
    }

    /**
     * Takes user to page that displays the search results based on what they input.
     * @param v
     */
    public void search(View v){
        /*get info that user entered*/
        EditText titleView = (EditText) findViewById(R.id.title);
        EditText authorView = (EditText) findViewById(R.id.author);
        EditText classView = (EditText) findViewById(R.id.classId);
        EditText editionView = (EditText) findViewById(R.id.edition);

        String title = titleView.getText().toString();
        String author = authorView.getText().toString();
        String classId = classView.getText().toString();
        String edition = editionView.getText().toString();

        /*send intent and pass search parameters to page that will display results*/
        Intent intent = new Intent(this, DisplaySearchResults.class);
        intent.putExtra("title", title);
        intent.putExtra("author", author);
        intent.putExtra("class", classId);
        intent.putExtra("edition", edition);
        startActivity(intent);
    }
}
