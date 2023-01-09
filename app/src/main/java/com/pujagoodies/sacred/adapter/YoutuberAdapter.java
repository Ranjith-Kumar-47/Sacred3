package com.pujagoodies.sacred.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.playvideota.R;
import com.pujagoodies.sacred.R;
import com.pujagoodies.sacred.YoutubeDashboard;
import com.pujagoodies.sacred.model.YoutuberModel;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class YoutuberAdapter extends RecyclerView.Adapter<YoutuberAdapter.viewHolder> {

    Context context;
    ArrayList<YoutuberModel> list;
    FirebaseDatabase database;
    ArrayList<String> channelIdList = new ArrayList<>();
    public YoutuberAdapter(Context context, ArrayList<YoutuberModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        database = FirebaseDatabase.getInstance();
        View view = LayoutInflater.from(context).inflate(R.layout.story_design_youtuber,parent,false);


        channelIdList.add("UC04m8d9t8UeWZ5DuvQVnqiw");
        channelIdList.add("UC6vQRTCxutg6fJLUGkDKynQ");
        channelIdList.add("UC7ZivIYRB0fMSGh-THcTYbw");

        channelIdList.add("UC8Igqo3g1U40n66BLb-xHuQ");
        channelIdList.add("UCHq7ZxlzRRXimaBmk5QAxSQ");
        channelIdList.add("UCOizxR3GwY7dmehMCAdvv9g");
        channelIdList.add("UCRUAdVm9ZOF4JheOd8qIQHA");

        channelIdList.add("UCSzOZ97LOpU-_AVlGfmD4rQ");
        channelIdList.add("UCUUIz69kK3Ib5bD4hWLKAwA");
        channelIdList.add("UCDe0DwkMVFfSIoiYdQUPQmQ");
        channelIdList.add("UCfwa_zKl8-zC9rQDWIEixgg");
        channelIdList.add("UCyIkg79GpPVF77qYKoAINtw");

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        YoutuberModel youtuberModel = list.get(position);


        holder.youtuberName.setText(youtuberModel.getYoutuberName());
        Picasso.with(context)
                .load(youtuberModel.getYoutuberImage())
                .placeholder(R.drawable.ic_profile_svgrepo_com)
                .into(holder.youtuberImage);




        holder.youtuberImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), YoutubeDashboard.class);
                intent.putExtra("youtuberId",youtuberModel.getYoutuberId());
                intent.putExtra("youtuberName",youtuberModel.getYoutuberName());
                intent.putExtra("youtuberImage",youtuberModel.getYoutuberImage());
                intent.putExtra("youtuberBannerImage",youtuberModel.getYoutuberBannerImage());
                v.getContext().startActivity(intent);
            }
        });

//        if(youtuberModel.getLiveStatus().toLowerCase().equalsIgnoreCase("live")){
//            holder.liveIconImageView.setVisibility(View.VISIBLE);
//        }






    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder{
        ImageView youtuberImage, liveIconImageView;
        TextView youtuberName;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            youtuberImage = itemView.findViewById(R.id.videoImage);
            youtuberName = itemView.findViewById(R.id.videoDescription);
            liveIconImageView = itemView.findViewById(R.id.liveIconImageView);
        }
    }
}
