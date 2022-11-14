package com.example.playvideota.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.playvideota.R;
import com.example.playvideota.databinding.FragmentPanchangBinding;

public class PanchangFragment extends Fragment {


    FragmentPanchangBinding binding;

    public PanchangFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_panchang, container, false);
        binding = FragmentPanchangBinding.inflate(inflater,container,false);

        TextView todayDateTextview = binding.todayDateTextview;
        long millis = System.currentTimeMillis();

        // creating a new object of the class Date
        java.util.Date date = new java.util.Date(millis);
        System.out.println(date);
        String cDate = ""+date;
        String startDate = cDate.substring(0,10);
        String endDate = cDate.substring(29);

        todayDateTextview.setText(" "+startDate+" "+endDate+" " );




        return  binding.getRoot();
    }
}