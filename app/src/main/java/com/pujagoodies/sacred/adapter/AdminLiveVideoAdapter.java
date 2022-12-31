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

import com.example.playvideota.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pujagoodies.sacred.WebViewActivity;
import com.pujagoodies.sacred.model.AdminLiveVideoModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdminLiveVideoAdapter extends RecyclerView.Adapter<AdminLiveVideoAdapter.viewHolder> {

    Context context;
    ArrayList<AdminLiveVideoModel> list;
    FirebaseDatabase database;

    public AdminLiveVideoAdapter(Context context, ArrayList<AdminLiveVideoModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_live_videos,parent,false);

        database = FirebaseDatabase.getInstance();

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
                v.getContext().startActivity(intent);
            }
        });

        holder.adminLiveVideoTitle.setText(adminLiveVideoModel.getTitle());
        holder.adminLiveVideoDescription.setText(adminLiveVideoModel.getDescription());

//        database.getReference().child("LiveVideo")
//                .child("videos")
//                .child(adminLiveVideoModel.getVideoId())
//                .child("title")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        holder.adminLiveVideoTitle.setText(snapshot.getValue().toString());
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });
//
//        database.getReference().child("LiveVideo")
//                .child("videos")
//                .child(adminLiveVideoModel.getVideoId())
//                .child("description")
//                .addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        holder.adminLiveVideoDescription.setText(snapshot.getValue().toString());
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView adminVideo;
        TextView adminLiveVideoTitle,adminLiveVideoDescription;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            adminVideo = itemView.findViewById(R.id.adminVideo);
            adminLiveVideoTitle = itemView.findViewById(R.id.adminLiveVideoTitle);
            adminLiveVideoDescription = itemView.findViewById(R.id.adminLiveVideoDescription);
        }
    }
}
