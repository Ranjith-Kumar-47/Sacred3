package com.example.playvideota.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playvideota.R;
import com.example.playvideota.model.GeetaModel;

import java.util.ArrayList;

public class GeetaAdapter extends RecyclerView.Adapter<GeetaAdapter.viewHolder> {
    Context context;
    ArrayList<GeetaModel> geetaModelArrayList;

    public GeetaAdapter(Context context, ArrayList<GeetaModel> geetaModelArrayList) {
        this.context = context;
        this.geetaModelArrayList = geetaModelArrayList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.geeta_story_design,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        GeetaModel geetaModel = geetaModelArrayList.get(position);

        holder.adhyaNumber.setText(geetaModel.getAdhya());
        holder.geetaSlokNumber.setText(geetaModel.getSlok());
        holder.slokSanskrit.setText(geetaModel.getSlokSanskrit());
        holder.slokSar.setText(geetaModel.getSlokSar());
    }

    @Override
    public int getItemCount() {
        return geetaModelArrayList.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView adhyaNumber,geetaSlokNumber,slokSanskrit,slokSar;
        public viewHolder(@NonNull View itemView) {
            super(itemView);

            adhyaNumber = itemView.findViewById(R.id.adhyaNumber);
            geetaSlokNumber = itemView.findViewById(R.id.geetaSlokNumber);
            slokSanskrit = itemView.findViewById(R.id.slokSanskrit);
            slokSar = itemView.findViewById(R.id.slokSar);
        }
    }
}
