package com.example.playvideota.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playvideota.MainActivity;
import com.example.playvideota.R;
import com.example.playvideota.YoutubeDashboard;
import com.example.playvideota.model.YoutuberModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class YoutuberAdapter extends RecyclerView.Adapter<YoutuberAdapter.viewHolder> {

    Context context;
    ArrayList<YoutuberModel> list;

    public YoutuberAdapter(Context context, ArrayList<YoutuberModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.story_design_youtuber,parent,false);
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

        if(youtuberModel.getLiveStatus().toLowerCase().equalsIgnoreCase("live")){
            holder.liveIconImageView.setVisibility(View.VISIBLE);
        }






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
