package com.example.kanjicardn4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Kanji Main Activity";
    private RecyclerView recyclerView;
    private List<Kanji> kanjiList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Started.");

        init();
        inputData();

        Adapter adapter = new Adapter(this);
        adapter.setKanjiList(kanjiList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


    }
    
    public void init(){

        Log.d(TAG, "init: initiating recycleView");
        recyclerView = findViewById(R.id.recycleView);
    }
    
    public void inputData(){

        Log.d(TAG, "inputData: Inputting data to a list");

        kanjiList.add(new Kanji(getString(R.string.kanji1),getString(R.string.url1),getString(R.string.des1),
                getString(R.string.on1),getString(R.string.kun1),getResources().getStringArray(R.array.wordList1)));
        kanjiList.add(new Kanji(getString(R.string.kanji2),getString(R.string.url2),getString(R.string.des2),
                getString(R.string.on2),getString(R.string.kun2),getResources().getStringArray(R.array.wordList2)));
        kanjiList.add(new Kanji(getString(R.string.kanji3),getString(R.string.url3),getString(R.string.des3),
                getString(R.string.on3),getString(R.string.kun3),getResources().getStringArray(R.array.wordList3)));
        kanjiList.add(new Kanji(getString(R.string.kanji4),getString(R.string.url4),getString(R.string.des4),
                getString(R.string.on4),getString(R.string.kun4),getResources().getStringArray(R.array.wordList4)));
        kanjiList.add(new Kanji(getString(R.string.kanji5),getString(R.string.url5),getString(R.string.des5),
                getString(R.string.on5),getString(R.string.kun5),getResources().getStringArray(R.array.wordList5)));
        kanjiList.add(new Kanji(getString(R.string.kanji6),getString(R.string.url6),getString(R.string.des6),
                getString(R.string.on6),getString(R.string.kun6),getResources().getStringArray(R.array.wordList6)));
        kanjiList.add(new Kanji(getString(R.string.kanji7),getString(R.string.url7),getString(R.string.des7),
                getString(R.string.on7),getString(R.string.kun7),getResources().getStringArray(R.array.wordList7)));
        kanjiList.add(new Kanji(getString(R.string.kanji8),getString(R.string.url8),getString(R.string.des8),
                getString(R.string.on8),getString(R.string.kun8),getResources().getStringArray(R.array.wordList8)));
        kanjiList.add(new Kanji(getString(R.string.kanji9),getString(R.string.url9),getString(R.string.des9),
                getString(R.string.on9),getString(R.string.kun9),getResources().getStringArray(R.array.wordList9)));
        kanjiList.add(new Kanji(getString(R.string.kanji10),getString(R.string.url10),getString(R.string.des10),
                getString(R.string.on10),getString(R.string.kun10),getResources().getStringArray(R.array.wordList10)));
        
    }
}