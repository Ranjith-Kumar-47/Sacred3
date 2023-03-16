package com.pujagoodies.sacred.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.pujagoodies.sacred.R;
import com.pujagoodies.sacred.ViewData;
import com.pujagoodies.sacred.model.UploadImageModel;

public class ReadAdapter extends FirebaseRecyclerAdapter<UploadImageModel, ReadAdapter.MyViewHolder> {

    Context context;
    ProgressBar progressBar;

    public ReadAdapter(@NonNull FirebaseRecyclerOptions<UploadImageModel> options, ProgressBar progressBar, Context context) {
        super(options);
        this.context = context;
        this.progressBar = progressBar;
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull UploadImageModel model) {
        holder.textViewTitle.setText(model.getImageName());
        holder.textViewDescription.setText(model.getImageShortDescription());
        Glide.with(context).load(model.getImageUrl()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.cardViewImage);
        progressBar.setVisibility(View.GONE);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ViewData.class);
                intent.putExtra("title",model.getImageName());
                intent.putExtra("longDescription",model.getImageLongDescription());
                intent.putExtra("imageUrl",model.getImageUrl());
                holder.cardView.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_design, parent, false);
        return new MyViewHolder(view);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        CardView cardView;
        ImageView cardViewImage;
        TextView textViewDescription;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.cardViewTitle);
            textViewDescription = itemView.findViewById(R.id.cardViewShortDescription);
            cardViewImage = itemView.findViewById(R.id.cardViewImage);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }

}