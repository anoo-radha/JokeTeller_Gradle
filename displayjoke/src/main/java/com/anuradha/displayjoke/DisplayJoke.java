package com.anuradha.displayjoke;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class DisplayJoke extends AppCompatActivity{
    public static final String JOKE_KEY = "joke_display";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_joke);
        Intent intent = this.getIntent();
        String jokeReceived = intent.getStringExtra(JOKE_KEY);
        TextView jokeTextView = (TextView) findViewById(R.id.jokeandroidlibrary_txt);
        if (jokeReceived != null && jokeReceived.length() != 0) {
            jokeTextView.setText(jokeReceived);
        }
    }
}
