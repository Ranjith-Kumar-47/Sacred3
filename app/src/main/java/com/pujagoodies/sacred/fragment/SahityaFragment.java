package com.pujagoodies.sacred.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import com.example.playvideota.R;
import com.pujagoodies.sacred.R;
import com.pujagoodies.sacred.databinding.FragmentSahityaBinding;
import com.pujagoodies.sacred.adapter.SahityaAdapter;
import com.pujagoodies.sacred.model.SahityaImageModel;
import com.pujagoodies.sacred.model.SahityaModel;

import java.util.ArrayList;


public class SahityaFragment extends Fragment {
    RecyclerView sahityaRv;
    FragmentSahityaBinding binding;

    ArrayList<SahityaImageModel> sahityaImageModelArrayList;
    ArrayList<SahityaImageModel> sahityaImageModelArrayList2;

    ArrayList<SahityaModel> sahityaModelArrayList;
    ArrayList<SahityaModel> sahityaModelArrayList2;

    public SahityaFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSahityaBinding.inflate(inflater,container,false);




        initData();
        addDataToSahityaImageModel();


        return binding.getRoot();

        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_sahitya, container, false);
    }

    private void addDataToSahityaImageModel() {

        sahityaImageModelArrayList = new ArrayList<>();
        sahityaImageModelArrayList2 = new ArrayList<>();

        sahityaImageModelArrayList.add(new SahityaImageModel(""+R.drawable.ic_profile_svgrepo_com,"aarti kejiya hanuman ki","shree Hanuman Ji Aarti","Aarti Sangrah"));
        sahityaImageModelArrayList.add(new SahityaImageModel(""+R.drawable.ic_profile_svgrepo_com,"aarti kejiya hanuman ki","shree Hanuman Ji Aarti","Aarti Sangrah"));
        sahityaImageModelArrayList.add(new SahityaImageModel(""+R.drawable.ic_profile_svgrepo_com,"aarti kejiya hanuman ki","shree Hanuman Ji Aarti","Aarti Sangrah"));
        sahityaImageModelArrayList.add(new SahityaImageModel(""+R.drawable.ic_profile_svgrepo_com,"aarti kejiya hanuman ki","shree Hanuman Ji Aarti","Aarti Sangrah"));

        sahityaImageModelArrayList2.add(new SahityaImageModel(""+R.drawable.ic_profile_svgrepo_com,"aarti kejiya hanuman ki","shree Hanuman Ji Aarti","Aarti Sangrah"));
        sahityaImageModelArrayList2.add(new SahityaImageModel(""+R.drawable.ic_profile_svgrepo_com,"aarti kejiya hanuman ki","shree Hanuman Ji Aarti","Aarti Sangrah"));
        sahityaImageModelArrayList2.add(new SahityaImageModel(""+R.drawable.ic_profile_svgrepo_com,"aarti kejiya hanuman ki","shree Hanuman Ji Aarti","Aarti Sangrah"));
        sahityaImageModelArrayList2.add(new SahityaImageModel(""+R.drawable.ic_profile_svgrepo_com,"aarti kejiya hanuman ki","shree Hanuman Ji Aarti","Aarti Sangrah"));


        sahityaModelArrayList = new ArrayList<>();
//        sahityaModelArrayList2 = new ArrayList<>();

        sahityaModelArrayList.add(new SahityaModel("Aarti Sangrah",sahityaImageModelArrayList));
        sahityaModelArrayList.add(new SahityaModel("Hanuman Sangrah",sahityaImageModelArrayList2));

        SahityaAdapter sahityaAdapter = new SahityaAdapter(getContext(), sahityaModelArrayList);
        sahityaRv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
        sahityaRv.setAdapter(sahityaAdapter);
        sahityaRv.setNestedScrollingEnabled(false);
        sahityaAdapter.notifyDataSetChanged();

    }

    private void initData() {
        sahityaRv = binding.sahityaRv;
    }
}