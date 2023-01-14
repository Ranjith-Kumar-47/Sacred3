package com.pujagoodies.sacred.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.playvideota.R;
import com.pujagoodies.sacred.R;
import com.pujagoodies.sacred.WebViewActivity;
import com.pujagoodies.sacred.model.YoutubeDashboradModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class YoutubeDashboardAdapter extends RecyclerView.Adapter<YoutubeDashboardAdapter.viewHolder> {
    Context context;
    ArrayList<YoutubeDashboradModel> list;
    YoutubeDashBoardAdapterInterface listener;
    FirebaseDatabase database;
    String tvserialName ;

    public YoutubeDashboardAdapter(Context context, ArrayList<YoutubeDashboradModel> list, YoutubeDashBoardAdapterInterface listener) {
        this.context = context;
        this.list = list;
        this.listener = (YoutubeDashBoardAdapterInterface) listener;
    }

    public YoutubeDashboardAdapter(Context context, ArrayList<YoutubeDashboradModel> list) {
        this.context = context;
        this.list = list;
    }

    public YoutubeDashboardAdapter(Context context, ArrayList<YoutubeDashboradModel> list, String tvserialName) {
        this.context = context;
        this.list = list;
        this.tvserialName = tvserialName;
    }



    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.story_design_youtube_video, parent, false);

        database = FirebaseDatabase.getInstance();



        viewHolder viewHolder = new viewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        YoutubeDashboradModel youtubeDashboradModel = list.get(position);
//        Picasso.with(context)
//                .load(youtubeDashboradModel.getVideoImage())
//                .placeholder(R.drawable.ic_profile_svgrepo_com.xml)
//                .into(holder.videoImage);
//
//        Picasso.with(context)
//                .load(youtubeDashboradModel.getChannelIcon())
//                .placeholder(R.drawable.ic_profile_svgrepo_com.xml)
//                .into(holder.channelIcon);



        database.getReference().child("tvSerial")
                .child(tvserialName)
                .child("image")
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if(snapshot.exists()){
                            Picasso.with(context)
                                    .load(snapshot.getValue().toString())
                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
                                    .into(holder.videoImage);

                            Picasso.with(context)
                                    .load(snapshot.getValue().toString())
                                    .placeholder(R.drawable.ic_profile_svgrepo_com)
                                    .into(holder.channelIcon);

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });



        holder.videoDescription.setText(youtubeDashboradModel.getVideoDescription());

        holder.videoDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WebViewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("id",youtubeDashboradModel.getVideoId());
                v.getContext().startActivity(intent);
            }
        });



        holder.cardViewContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), WebViewActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("id",youtubeDashboradModel.getVideoId());
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
        ImageView liveButton;




        public viewHolder(@NonNull View itemView) {
            super(itemView);

            videoDescription = itemView.findViewById(R.id.videoDescription);
            videoImage = itemView.findViewById(R.id.videoImage);
            cardViewContainer  = itemView.findViewById(R.id.cardViewContainer);
            channelIcon = itemView.findViewById(R.id.profileUserImage);
            liveButton = itemView.findViewById(R.id.liveButton);
        }
    }
}
