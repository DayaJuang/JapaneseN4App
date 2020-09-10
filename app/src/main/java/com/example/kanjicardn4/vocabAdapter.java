package com.example.kanjicardn4;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class vocabAdapter extends RecyclerView.Adapter<vocabAdapter.ViewHolder>{

    private static final String TAG = "Vocab Adapter";
    private Context context;
    private List<Vocabulary> vocabList = new ArrayList<>();

    public vocabAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: Creating a view and returning ViewHolder");

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vocab_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: set the field");

        holder.vocabTxt.setText(vocabList.get(position).getName());
        Glide.with(context)
                .asBitmap()
                .load(vocabList.get(position).getUrl())
                .into(holder.vocabImage);
        holder.vocabParent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context,vocab_detail_activity.class);
                intent.putExtra("vocab_img",vocabList.get(position).getUrl());
                intent.putExtra("vocab_txt",vocabList.get(position).getName());
                intent.putExtra("vocab_desc",vocabList.get(position).getLongDesc());

                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return vocabList.size();
    }

    public void setVocabList(List<Vocabulary> vocabList) {
        this.vocabList = vocabList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView vocabTxt;
        private ImageView vocabImage;
        private CardView vocabParent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "ViewHolder: initiating the variable");

            vocabTxt = itemView.findViewById(R.id.vocabTxt);
            vocabImage = itemView.findViewById(R.id.vocabImg);
            vocabParent = itemView.findViewById(R.id.vocabParent);
        }
    }
}
