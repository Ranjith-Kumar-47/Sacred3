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

import java.util.ArrayList;

public class TvLiveVideoAdapter extends RecyclerView.Adapter<TvLiveVideoAdapter.viewHolder> {

    ArrayList<TvLiveVideoModel> list;
    Context context;

    public TvLiveVideoAdapter(ArrayList<TvLiveVideoModel> list, Context context) {
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

        TvLiveVideoModel tvLiveVideoModel = list.get(position);
        holder.liveVideoImage.setImageResource(tvLiveVideoModel.getImage());


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
