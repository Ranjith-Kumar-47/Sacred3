package com.example.playvideota.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playvideota.MainActivity;
import com.example.playvideota.R;
import com.example.playvideota.YoutubeDashboard;
import com.example.playvideota.model.YoutubeDashboradModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class YoutubeDashboardAdapter extends RecyclerView.Adapter<YoutubeDashboardAdapter.viewHolder> {
    Context context;
    ArrayList<YoutubeDashboradModel> list;

    public YoutubeDashboardAdapter(Context context, ArrayList<YoutubeDashboradModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.story_design_youtube_video, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        YoutubeDashboradModel youtubeDashboradModel = list.get(position);
        Picasso.with(context)
                .load(youtubeDashboradModel.getVideoImage())
                .placeholder(R.drawable.ic_profile_svgrepo_com)
                .into(holder.videoImage);

        holder.videoDescription.setText(youtubeDashboradModel.getVideoDescription());



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView videoImage;
        TextView videoDescription;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            videoDescription = itemView.findViewById(R.id.videoDescription);
            videoImage = itemView.findViewById(R.id.videoImage);
        }
    }
}
