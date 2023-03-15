package com.example.mahabandar;

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

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class PdfAdapter extends FirebaseRecyclerAdapter<PdfModel, PdfAdapter.MyViewHolder> {

    Context context;
    ProgressBar progressBar;

    public PdfAdapter(@NonNull FirebaseRecyclerOptions<PdfModel> options, ProgressBar progressBar, Context context) {
        super(options);
        this.context = context;
        this.progressBar = progressBar;
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull PdfModel model) {
        holder.textViewTitle.setText(model.getTitle());
        holder.textViewDescription.setText(model.getShortDescription());
        progressBar.setVisibility(View.GONE);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PdfViewer.class);
                intent.putExtra("pdfUrl", model.getPdfUrl());
                holder.cardView.getContext().startActivity(intent);
            }
        });
    }

    @NonNull
    @Override
    public PdfAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
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