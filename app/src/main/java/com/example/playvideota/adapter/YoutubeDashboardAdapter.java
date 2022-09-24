package com.example.playvideota.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.example.playvideota.R;
import com.example.playvideota.VideoPlayer;
import com.example.playvideota.YoutubeDashboard;
import com.example.playvideota.model.YoutubeDashboradModel;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.ArrayList;

public class YoutubeDashboardAdapter extends RecyclerView.Adapter<YoutubeDashboardAdapter.viewHolder> {
    Context context;
    ArrayList<YoutubeDashboradModel> list;
    YoutubeDashBoardAdapterInterface listener;

    public YoutubeDashboardAdapter(Context context, ArrayList<YoutubeDashboradModel> list, YoutubeDashBoardAdapterInterface listener) {
        this.context = context;
        this.list = list;
        this.listener = (YoutubeDashBoardAdapterInterface) listener;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.story_design_youtube_video, parent, false);

        viewHolder viewHolder = new viewHolder(view);
        viewHolder.videoImage.setOnClickListener(v -> {
//            listener.itemClicked(list.get(viewHolder.getAdapterPosition()));
            listener.itemClicked(list.get(viewHolder.getAdapterPosition()).getVideoId(),list.get(viewHolder.getAdapterPosition()).getVideoId());
            System.out.println("ITEM");
            Toast.makeText(context, "INTERFACE TOAST", Toast.LENGTH_SHORT).show();
        });




        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        YoutubeDashboradModel youtubeDashboradModel = list.get(position);
        Picasso.with(context)
                .load(youtubeDashboradModel.getVideoImage())
                .placeholder(R.drawable.ic_profile_svgrepo_com)
                .into(holder.videoImage);

        holder.videoDescription.setText(youtubeDashboradModel.getVideoTitle());


        holder.videoImage.setOnClickListener(v -> {
            listener.itemClicked(youtubeDashboradModel.getVideoId(), youtubeDashboradModel.getVideoId());
        });




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
