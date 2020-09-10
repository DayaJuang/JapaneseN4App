package com.example.kanjicardn4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class KanjiActivity extends AppCompatActivity {

    public static final String TAG = "Kanji Activity";
    TextView OnTxt,KunTxt,kanjiTxt,meaningTxt;
    ListView wordList;
    ImageView detail_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kanji);

        Log.d(TAG, "onCreate: started.");

        init();
        getIncomingIntent();
        String[] words = getWordList();

        final ArrayAdapter<String> wordAdapter = new ArrayAdapter<String>(KanjiActivity.this,
                android.R.layout.simple_list_item_1,
                words){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = super.getView(position,convertView,parent);
                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                // Set the text size 25 dip for ListView each item
                tv.setTextSize(TypedValue.COMPLEX_UNIT_DIP,10);

                return view;
            }
        };


        wordList.setAdapter(wordAdapter);

    }

    public void init(){
        Log.d(TAG, "init: initiating variable");

        OnTxt = findViewById(R.id.OnTxt);
        KunTxt = findViewById(R.id.kunTxt);
        wordList = findViewById(R.id.wordList);
        detail_img = findViewById(R.id.kanjiImg);
        kanjiTxt = findViewById(R.id.kanjiTxt);
        meaningTxt = findViewById(R.id.meaningTxt);
    }
    
    public void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: check incoming intents.");

        if(getIntent().hasExtra("image_url")&&getIntent().hasExtra("kanji_name")&&getIntent().hasExtra("kanji_on")&&
                getIntent().hasExtra("kanji_kun")&&getIntent().hasExtra("kanji_desc")){
            Log.d(TAG, "getIncomingIntent: Found Intent.");

            String imageUrl = getIntent().getStringExtra("image_url");
            String kanjiName = getIntent().getStringExtra("kanji_name");
            String onYomi = getIntent().getStringExtra("kanji_on");
            String kunYomi = getIntent().getStringExtra("kanji_kun");
            String kanjiMeaning= getIntent().getStringExtra("kanji_desc");

            setData(imageUrl,kanjiName,onYomi,kunYomi,kanjiMeaning);

        }
    }

    public String[] getWordList(){
        Log.d(TAG, "getWordList: getting an Array");

        String[] words;

        if (getIntent().hasExtra("kanji_WordList")) {
            words = getIntent().getStringArrayExtra("kanji_WordList");
            return words;
        }
        return null;
    }

    public void setData(String imageUrl, String kanjiName, String onYomi, String kunYomi, String kanjiMeaning){
        Log.d(TAG, "setData: Set data to the field");

        init();

        kanjiTxt.setText(kanjiName);
        OnTxt.setText(onYomi);
        KunTxt.setText(kunYomi);
        meaningTxt.setText(kanjiMeaning);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(detail_img);

    }
}