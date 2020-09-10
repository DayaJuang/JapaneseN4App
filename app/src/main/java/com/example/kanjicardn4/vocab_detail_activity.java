package com.example.kanjicardn4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class vocab_detail_activity extends AppCompatActivity {

    private final static String TAG = "Vocab Detail Activity";
    private TextView vocabTxt, longDesc;
    private ImageView vocabImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vocab_detail_activity);
        Log.d(TAG, "onCreate: Started.");

        init();
        getIncomingIntent();

    }

    public void init(){
        Log.d(TAG, "init: initiating variable...");

        vocabTxt = findViewById(R.id.vocabTxt2);
        longDesc = findViewById(R.id.longDescTxt);
        vocabImage = findViewById(R.id.vocabImg2);
    }

    public void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent: Getting the intent");

        if(getIntent().hasExtra("vocab_img")&&getIntent().hasExtra("vocab_txt")&&getIntent().hasExtra("vocab_desc")){
            Log.d(TAG, "getIncomingIntent: Found Intent");

            String vocabImg = getIntent().getStringExtra("vocab_img");
            String vocabName = getIntent().getStringExtra("vocab_txt");
            String vocabDesc = getIntent().getStringExtra("vocab_desc");

            setData(vocabImg,vocabName,vocabDesc);

        }
    }

    public void setData(String vocabImg, String vocabName, String vocabDesc){
        Log.d(TAG, "setData: Setting some data");

        vocabTxt.setText(vocabName);
        longDesc.setText(vocabDesc);
        Glide.with(this)
                .asBitmap()
                .load(vocabImg)
                .into(this.vocabImage);
    }
}