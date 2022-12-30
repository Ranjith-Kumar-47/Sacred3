package com.pujagoodies.sacred.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.playvideota.R;
import com.pujagoodies.sacred.model.GeetaModel;

import java.util.ArrayList;

public class GeetaAdapter extends RecyclerView.Adapter<GeetaAdapter.viewHolder> {
    Context context;
    ArrayList<GeetaModel> geetaModelArrayList;
    String a1 = "अध्याय 1";
    String a2 = "अध्याय 2";
    String a3 = "अध्याय 3";
    String a4 = "अध्याय 4";
    String a5 = "अध्याय 5";
    String a6 = "अध्याय 6";
    String a7 = "अध्याय 7";
    String a8 = "अध्याय 8";
    String a9 = "अध्याय 9";
    String a10 = "अध्याय 10";
    String a11 = "अध्याय 11";
    String a12 = "अध्याय 12";
    String a13 = "अध्याय 13";
    String a14 = "अध्याय 14";
    String a15 = "अध्याय 15";
    String a16 = "अध्याय 16";
    String a17 = "अध्याय 17";
    String a18 = "अध्याय 18";

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

        if(geetaModel.getAdhya().toLowerCase().equalsIgnoreCase("Adhya 1")){
            holder.adhyaNumber.setText(a1);
        }else if (geetaModel.getAdhya().toLowerCase().equalsIgnoreCase("Adhya 2")){
            holder.adhyaNumber.setText(a2);
        }else if (geetaModel.getAdhya().toLowerCase().equalsIgnoreCase("Adhya 3")){
            holder.adhyaNumber.setText(a3);
        }else if (geetaModel.getAdhya().toLowerCase().equalsIgnoreCase("Adhya 4")){
            holder.adhyaNumber.setText(a4);
        }else if (geetaModel.getAdhya().toLowerCase().equalsIgnoreCase("Adhya 5")){
            holder.adhyaNumber.setText(a5);
        }else if (geetaModel.getAdhya().toLowerCase().equalsIgnoreCase("Adhya 6")){
            holder.adhyaNumber.setText(a6);
        }else if (geetaModel.getAdhya().toLowerCase().equalsIgnoreCase("Adhya 7")){
            holder.adhyaNumber.setText(a7);
        }else if (geetaModel.getAdhya().toLowerCase().equalsIgnoreCase("Adhya 8")){
            holder.adhyaNumber.setText(a8);
        }else if (geetaModel.getAdhya().toLowerCase().equalsIgnoreCase("Adhya 9")){
            holder.adhyaNumber.setText(a9);
        }else if (geetaModel.getAdhya().toLowerCase().equalsIgnoreCase("अध्याय 10")){
            holder.adhyaNumber.setText(a10);
        }else if (geetaModel.getAdhya().toLowerCase().equalsIgnoreCase("अध्याय 11")){
            holder.adhyaNumber.setText(a11);
        }else if (geetaModel.getAdhya().toLowerCase().equalsIgnoreCase("अध्याय 12")){
            holder.adhyaNumber.setText(a12);
        }else if (geetaModel.getAdhya().toLowerCase().equalsIgnoreCase("अध्याय 13")){
            holder.adhyaNumber.setText(a13);
        }else if (geetaModel.getAdhya().toLowerCase().equalsIgnoreCase("अध्याय 14")){
            holder.adhyaNumber.setText(a14);
        }else if (geetaModel.getAdhya().toLowerCase().equalsIgnoreCase("अध्याय 15")){
            holder.adhyaNumber.setText(a15);
        }else if (geetaModel.getAdhya().toLowerCase().equalsIgnoreCase("अध्याय 16")){
            holder.adhyaNumber.setText(a16);
        }else if (geetaModel.getAdhya().toLowerCase().equalsIgnoreCase("अध्याय 17")){
            holder.adhyaNumber.setText(a17);
        }else if (geetaModel.getAdhya().toLowerCase().equalsIgnoreCase("अध्याय 18")){
            holder.adhyaNumber.setText(a18);
        }


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
