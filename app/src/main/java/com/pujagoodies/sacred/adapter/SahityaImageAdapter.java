package com.pujagoodies.sacred.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
//import com.example.playvideota.R;
import com.pujagoodies.sacred.R;
import com.pujagoodies.sacred.model.SahityaImageModel;
import java.util.ArrayList;

public class SahityaImageAdapter extends RecyclerView.Adapter<SahityaImageAdapter.viewHolder> {

    Context context;
    ArrayList<SahityaImageModel> list;

    public SahityaImageAdapter(Context context, ArrayList<SahityaImageModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_sahitya_design_image,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        SahityaImageModel sahityaImageModel = list.get(position);

        holder.sahityaImage.setImageResource(Integer.parseInt(sahityaImageModel.getSahityaImage()));

        holder.sahityaImageAboutTv.setText(sahityaImageModel.getSahityaImageAboutTv());
        holder.sahityaTitle.setText(sahityaImageModel.getSahityaTitle());
        holder.sahityaTitleCategories.setText(sahityaImageModel.getSahityaTitleCategories());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView sahityaImage;
        TextView sahityaImageAboutTv,sahityaTitle,sahityaTitleCategories;


        public viewHolder(@NonNull View itemView) {
            super(itemView);

            sahityaImage = itemView.findViewById(R.id.sahityaImage);
            sahityaImageAboutTv = itemView.findViewById(R.id.sahityaImageAboutTv);
            sahityaTitle = itemView.findViewById(R.id.sahityaTitle);
            sahityaTitleCategories = itemView.findViewById(R.id.sahityaTitleCategories);

        }
    }
}
