package com.example.kanjicardn4;

import android.content.Context;
import android.content.Intent;
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

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Kanji> kanjiList = new ArrayList<>();
    private Context context;

    public Adapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kanji_layout,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txtKanji.setText(kanjiList.get(position).getName());
        holder.txtDesc.setText(kanjiList.get(position).getDesc());
        Glide.with(context)
                .asBitmap()
                .load(kanjiList.get(position).getUrl())
                .into(holder.image);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,KanjiActivity.class);
                intent.putExtra("image_url",kanjiList.get(position).getUrl());
                intent.putExtra("kanji_name",kanjiList.get(position).getName());
                intent.putExtra("kanji_on",kanjiList.get(position).getOnYomi());
                intent.putExtra("kanji_kun",kanjiList.get(position).getKunYomi());
                intent.putExtra("kanji_desc",kanjiList.get(position).getDesc());
                intent.putExtra("kanji_WordList",kanjiList.get(position).getWordList());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return kanjiList.size();
    }

    public void setKanjiList(List<Kanji> kanjiList) {
        this.kanjiList = kanjiList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView txtKanji,txtDesc;
        private CardView cardView;
        private ImageView image;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtKanji = itemView.findViewById(R.id.txtKanji);
            txtDesc = itemView.findViewById(R.id.txtDesc);
            cardView = itemView.findViewById(R.id.parent);
            image = itemView.findViewById(R.id.image);
        }
    }

}
