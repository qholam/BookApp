package com.example.tommyspc.books;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DisplaySearchResults extends CommonButtons {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_search_results);

        displayResults(0);
    }

    public void goBack(View v){
        Intent intent = new Intent(this, SearchForBook.class);
        startActivity(intent);
    }

    /**
     * Displays results based on the search parameters provided by the intent
     */
    private void displayResults(int i){
        /*get intent*/
        Intent intent = this.getIntent();

        /*get search info from intent*/
        String title = intent.getStringExtra("title");
        String author = intent.getStringExtra("author");
        String edition = intent.getStringExtra("edition");
        String classId = intent.getStringExtra("class");

        //todo: come up with a better way to search. currently we only consider title and author
        /*Open file and search for all listings that match these parameters*/
        String filename;
        if(i == 0){
            filename = "booksforsell.txt";
        }
        else{
            filename = "booksforrent.txt";
        }
        File path = this.getApplication().getFilesDir();
        File file = new File(path, filename);
        List<String> results = new ArrayList<String>();/*holds all the listings that match the search parameters*/

        try {
            FileInputStream is = new FileInputStream(file);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String line = reader.readLine();
            while (line != null) {/*read through line by line*/
                line = reader.readLine();

                /*check if this listing matches the search parameters, if it does then add it to our arraylist*/
                if(line != null && meetsCriteria(line, author, title)){
                    results.add(line);
                }
            }
        }
        catch(IOException io){
            //todo: do something here if theres an error
        }

        /*display search results*/
        StringBuilder builder = new StringBuilder();
        TextView books = (TextView) findViewById(R.id.bookList);
        for (String s : results) {
            builder.append(s).append("\n\n");
        }
        books.setText(builder.toString());
    }

    private boolean meetsCriteria(String str, String author, String title){
        boolean b = false;

        String[] parts = str.split("\\|");
        if(parts.length > 1 && parts[0].toLowerCase().contains(title.toLowerCase()) && parts[1].toLowerCase().contains(author.toLowerCase())) {
            b = true;
        }

        return b;
    }

    public void displayRent(View v){
        displayResults(1);
    }

    public void displaySell(View v){
        displayResults(0);
    }
}
