package com.pujagoodies.sacred.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.playvideota.R;
import com.pujagoodies.sacred.R;
import com.pujagoodies.sacred.VideoPlayer;
import com.pujagoodies.sacred.model.YoutubeDashboradModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TvLiveVideoAdapter extends RecyclerView.Adapter<TvLiveVideoAdapter.viewHolder> {

    ArrayList<YoutubeDashboradModel> list;
    Context context;
    YoutubeDashBoardAdapterInterface listener;

    public TvLiveVideoAdapter(ArrayList<YoutubeDashboradModel> list, Context context, YoutubeDashBoardAdapterInterface listener) {
        this.list = list;
        this.context = context;
        this.listener = listener;
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


        holder.liveVideoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("momo : "+youtubeDashboradModel.getVideoId());

                Intent intent = new Intent(v.getContext(), VideoPlayer.class);
                intent.putExtra("userId", youtubeDashboradModel.getChannelId() );
                intent.putExtra("videoId",youtubeDashboradModel.getVideoId());
                intent.putExtra("videoTitle",youtubeDashboradModel.getVideoTitle());
                intent.putExtra("videoDescription",youtubeDashboradModel.getVideoDescription());
                intent.putExtra("videoLiveBroadcastContent",youtubeDashboradModel.getVideoLiveBroadcastContent());
                intent.putExtra("channelIcon",youtubeDashboradModel.getChannelIcon());
                intent.putExtra("channelName",youtubeDashboradModel.getChannelName());
                System.out.println("CHANNEL NAME YDA : "+youtubeDashboradModel.getChannelName());
                v.getContext().startActivity(intent);

            }
        });

        holder.playButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("momo : "+youtubeDashboradModel.getVideoId());

                Intent intent = new Intent(v.getContext(), VideoPlayer.class);
                intent.putExtra("userId", youtubeDashboradModel.getChannelId() );
                intent.putExtra("videoId",youtubeDashboradModel.getVideoId());
                intent.putExtra("videoTitle",youtubeDashboradModel.getVideoTitle());
                intent.putExtra("videoDescription",youtubeDashboradModel.getVideoDescription());
                intent.putExtra("videoLiveBroadcastContent",youtubeDashboradModel.getVideoLiveBroadcastContent());
                intent.putExtra("channelIcon",youtubeDashboradModel.getChannelIcon());
                intent.putExtra("channelName",youtubeDashboradModel.getChannelName());
                System.out.println("CHANNEL NAME YDA : "+youtubeDashboradModel.getChannelName());
                v.getContext().startActivity(intent);

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView liveVideoImage,playButtonImageView;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            liveVideoImage = itemView.findViewById(R.id.liveVideoImageView);
            playButtonImageView = itemView.findViewById(R.id.playButtonImageView);
        }
    }
}
