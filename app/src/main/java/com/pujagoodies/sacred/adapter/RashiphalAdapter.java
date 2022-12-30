package com.pujagoodies.sacred.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playvideota.R;
import com.pujagoodies.sacred.model.RashiPhalModel;

import java.util.ArrayList;

public class RashiphalAdapter extends RecyclerView.Adapter<RashiphalAdapter.viewHolder> {
    Context context;
    ArrayList<RashiPhalModel> list;

    public RashiphalAdapter(Context context, ArrayList<RashiPhalModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.sample_rashiphal_fragment,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        RashiPhalModel rashiPhalModel = list.get(position);

        holder.rashiphalImage.setImageResource(rashiPhalModel.getRashiphalImage());
        holder.rashiphalName.setText(rashiPhalModel.getRashiphalName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView rashiphalImage;
        TextView rashiphalName;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            rashiphalImage = itemView.findViewById(R.id.rashiphalImage);
            rashiphalName = itemView.findViewById(R.id.virgoTv);

        }

    }
}
