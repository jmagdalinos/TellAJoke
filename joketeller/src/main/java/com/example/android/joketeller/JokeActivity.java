package com.example.android.joketeller;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

/** Displays the text of a joke in quotes */
public class JokeActivity extends AppCompatActivity {

    /** Key used to pass the joke string as an intent extra */
    public static final String KEY_JOKE ="key_extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        // Set up back button navigation
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        // Get the TextView and display the joke
        TextView textView = (TextView) findViewById(R.id.tv_joke);
        textView.setText(getIntent().getExtras().getString(KEY_JOKE));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
