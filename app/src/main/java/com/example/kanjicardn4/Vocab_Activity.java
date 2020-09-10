package com.example.kanjicardn4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Vocab_Activity extends AppCompatActivity {

    private final static String TAG = "Vocab Activity";
    private RecyclerView recyclerView;
    private List<Vocabulary> vocabularies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab_);

        Log.d(TAG, "onCreate: Started.");

        init();
        inputData();

        vocabAdapter vocabAdapter = new vocabAdapter(this);
        vocabAdapter.setVocabList(vocabularies);

        recyclerView.setAdapter(vocabAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }

    public void init(){
        Log.d(TAG, "init: initiating variable");

        recyclerView = findViewById(R.id.recycleViewVocab);
    }

    public void inputData(){
        Log.d(TAG, "inputData: inputting data to Card View");

        vocabularies.add(new Vocabulary(getString(R.string.vocab1),getString(R.string.vocabUrl),
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum"));
    }

}