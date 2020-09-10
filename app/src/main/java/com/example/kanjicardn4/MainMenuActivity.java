package com.example.kanjicardn4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainMenuActivity extends AppCompatActivity {

    private final static String TAG = "Main Menu Activity";
    private Button kanjiBtn , vocabBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Log.d(TAG, "onCreate: Started");

        kanjiBtn = findViewById(R.id.kanjiBtn);
        vocabBtn = findViewById(R.id.vocabBtn);

        kanjiBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        vocabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this,Vocab_Activity.class);
                startActivity(intent);
            }
        });

    }
}