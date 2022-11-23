package com.example.playvideota.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playvideota.R;
import com.example.playvideota.VideoPlayer;
import com.example.playvideota.model.TvSerialModel;
import com.example.playvideota.model.YoutubeDashboradModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TvSerialAdapter extends RecyclerView.Adapter<TvSerialAdapter.viewHolder>{

    Context context;
    ArrayList<TvSerialModel> list;

    public TvSerialAdapter(Context context, ArrayList<TvSerialModel> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.story_design_youtube_video,parent,false);
        return  new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        TvSerialModel tvSerialModel = list.get(position);

//        holder.videoImage.setImageURI(Uri.parse(tvSerialModel.getVideoImage().toString()));

        holder.profileUserImage.setVisibility(View.GONE);

        holder.videoDescription.setText(tvSerialModel.getDescription());
        Picasso.with(context).load(tvSerialModel.getVideoImage()).placeholder(R.drawable.ic_profile_svgrepo_com).into(holder.videoImage);

        holder.videoImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), VideoPlayer.class);
                intent.putExtra("userId", tvSerialModel.getChannelId() );
                intent.putExtra("videoId",tvSerialModel.getVideoId());
                intent.putExtra("videoTitle",tvSerialModel.getTitle());
                intent.putExtra("videoDescription",tvSerialModel.getDescription());
                intent.putExtra("videoLiveBroadcastContent",tvSerialModel.getVideoLiveBroadcastContent());
                intent.putExtra("channelIcon",tvSerialModel.getVideoImage());
                intent.putExtra("channelName",tvSerialModel.getTitle());
//                System.out.println("CHANNEL NAME YDA : "+youtubeDashboradModel.getChannelName());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView videoImage,profileUserImage;
        TextView videoDescription;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            videoImage = itemView.findViewById(R.id.videoImage);
            videoDescription = itemView.findViewById(R.id.videoDescription);
            profileUserImage = itemView.findViewById(R.id.profileUserImage);
        }
    }
}
