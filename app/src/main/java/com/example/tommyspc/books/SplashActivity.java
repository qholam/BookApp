package com.example.tommyspc.books;

/**
 * Created by Calvin on 11/15/16.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashActivity extends Activity {

    /**
     * Duration of wait
     **/
    private final int SPLASH_DISPLAY_LENGTH = 500;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread newThread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(3000);
                 /* Create an Intent that will start the Menu-Activity. */
                    if(SaveLogin.getUserName(getBaseContext()).length() == 0) {
                        // call Login Activity
                        Intent mainIntent = new Intent(getApplicationContext(), LoginActivity.class);
                        SplashActivity.this.startActivity(mainIntent);
                    } else {
                        // Stay at the current activity.
                        Intent mainIntent = new Intent(getApplicationContext(), MainMenuActivity.class);
                        SplashActivity.this.startActivity(mainIntent);
                    }
                    SplashActivity.this.finish();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        newThread.start();
    }
}


