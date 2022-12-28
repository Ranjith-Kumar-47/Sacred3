package com.example.playvideota.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playvideota.R;
import com.example.playvideota.WebViewActivity;
import com.example.playvideota.model.AdminLiveVideoModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdminLiveVideoAdapter extends RecyclerView.Adapter<AdminLiveVideoAdapter.viewHolder> {

    Context context;
    ArrayList<AdminLiveVideoModel> list;

    public AdminLiveVideoAdapter(Context context, ArrayList<AdminLiveVideoModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_live_videos,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        AdminLiveVideoModel adminLiveVideoModel = list.get(position);

        Picasso.with(context).load(adminLiveVideoModel.getImage())
                .placeholder(R.drawable.ic_video_loading)
                .into(holder.adminVideo);



        holder.adminVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WebViewActivity.class);
                intent.putExtra("id",adminLiveVideoModel.getVideoId());
                Toast.makeText(context, adminLiveVideoModel.getVideoId(), Toast.LENGTH_SHORT).show();
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView adminVideo;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            adminVideo = itemView.findViewById(R.id.adminVideo);
        }
    }
}
