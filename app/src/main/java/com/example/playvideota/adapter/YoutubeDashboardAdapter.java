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
import androidx.cardview.widget.CardView;
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
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        YoutubeDashboradModel youtubeDashboradModel = list.get(position);
        Picasso.with(context)
                .load(youtubeDashboradModel.getVideoImage())
                .placeholder(R.drawable.ic_profile_svgrepo_com)
                .into(holder.videoImage);

        Picasso.with(context)
                .load(youtubeDashboradModel.getChannelIcon())
                .placeholder(R.drawable.ic_profile_svgrepo_com)
                .into(holder.channelIcon);

        holder.videoDescription.setText(youtubeDashboradModel.getVideoTitle());

        holder.videoDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), VideoPlayer.class);
                intent.putExtra("userId", youtubeDashboradModel.getChannelId() );
                intent.putExtra("videoId",youtubeDashboradModel.getVideoId());
                intent.putExtra("videoTitle",youtubeDashboradModel.getVideoTitle());
                intent.putExtra("videoDescription",youtubeDashboradModel.getVideoDescription());
                intent.putExtra("videoLiveBroadcastContent",youtubeDashboradModel.getVideoLiveBroadcastContent());
                intent.putExtra("channelIcon",youtubeDashboradModel.getChannelIcon());
                intent.putExtra("channelName",youtubeDashboradModel.getChannelName());
                v.getContext().startActivity(intent);
            }
        });



        holder.cardViewContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
        ImageView videoImage;
        TextView videoDescription;
        CardView cardViewContainer;
        ImageView channelIcon;


        public viewHolder(@NonNull View itemView) {
            super(itemView);

            videoDescription = itemView.findViewById(R.id.videoDescription);
            videoImage = itemView.findViewById(R.id.videoImage);
            cardViewContainer  = itemView.findViewById(R.id.cardViewContainer);
            channelIcon = itemView.findViewById(R.id.profileUserImage);
        }
    }
}
