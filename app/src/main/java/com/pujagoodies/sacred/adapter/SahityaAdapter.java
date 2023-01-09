package com.pujagoodies.sacred.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.playvideota.R;
import com.pujagoodies.sacred.R;
import com.pujagoodies.sacred.model.SahityaImageModel;
import com.pujagoodies.sacred.model.SahityaModel;

import java.util.ArrayList;

public class SahityaAdapter extends RecyclerView.Adapter<SahityaAdapter.viewHolder> {

    Context context;
    ArrayList<SahityaModel> list;

    public SahityaAdapter(Context context, ArrayList<SahityaModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_sahitya_design,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        SahityaModel sahityaModel = list.get(position);

        holder.sahityaTopicTv.setText(sahityaModel.getSahityaTopicTv());
        SahityaImageAdapter sahityaImageAdapter;
        sahityaImageAdapter = new SahityaImageAdapter(context,sahityaModel.getList());

        holder.sahityaImageRv.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        holder.sahityaImageRv.setAdapter(sahityaImageAdapter);
        sahityaImageAdapter.notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {


        RecyclerView sahityaImageRv;
        TextView sahityaTopicTv;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            sahityaImageRv = itemView.findViewById(R.id.sahityaImageRv);
            sahityaTopicTv = itemView.findViewById(R.id.sahityaTopicTv);



        }
    }
}
