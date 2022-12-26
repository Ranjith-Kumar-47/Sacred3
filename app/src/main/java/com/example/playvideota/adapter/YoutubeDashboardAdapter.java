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
import com.example.playvideota.TvSerialActivity;
import com.example.playvideota.VideoPlayer;
import com.example.playvideota.WebViewActivity;
import com.example.playvideota.YoutubeDashboard;
import com.example.playvideota.model.YoutubeDashboradModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.ArrayList;

public class YoutubeDashboardAdapter extends RecyclerView.Adapter<YoutubeDashboardAdapter.viewHolder> {
    Context context;
    ArrayList<YoutubeDashboradModel> list;
    YoutubeDashBoardAdapterInterface listener;
    FirebaseDatabase database;

    public YoutubeDashboardAdapter(Context context, ArrayList<YoutubeDashboradModel> list, YoutubeDashBoardAdapterInterface listener) {
        this.context = context;
        this.list = list;
        this.listener = (YoutubeDashBoardAdapterInterface) listener;
    }

    public YoutubeDashboardAdapter(Context context, ArrayList<YoutubeDashboradModel> list) {
        this.context = context;
        this.list = list;
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
//                .placeholder(R.drawable.ic_profile_svgrepo_com)
//                .into(holder.videoImage);
//
//        Picasso.with(context)
//                .load(youtubeDashboradModel.getChannelIcon())
//                .placeholder(R.drawable.ic_profile_svgrepo_com)
//                .into(holder.channelIcon);

        database.getReference().child("tvSerial")
                .child("mahabharat")
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
