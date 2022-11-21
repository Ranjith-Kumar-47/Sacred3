package com.example.playvideota.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playvideota.R;
import com.example.playvideota.model.TvLiveVideoModel;
import com.example.playvideota.model.YoutubeDashboradModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TvLiveVideoAdapter extends RecyclerView.Adapter<TvLiveVideoAdapter.viewHolder> {

    ArrayList<YoutubeDashboradModel> list;
    Context context;

    public TvLiveVideoAdapter(ArrayList<YoutubeDashboradModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.live_video_sample,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

//        TvLiveVideoModel tvLiveVideoModel = list.get(position);
//        holder.liveVideoImage.setImageResource(tvLiveVideoModel.getImage());

        YoutubeDashboradModel youtubeDashboradModel = list.get(position);

        Picasso.with(context)
                .load(youtubeDashboradModel.getVideoImage())
                .placeholder(R.drawable.ic_profile_svgrepo_com)
                .into(holder.liveVideoImage);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView liveVideoImage;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            liveVideoImage = itemView.findViewById(R.id.liveVideoImageView);
        }
    }
}
