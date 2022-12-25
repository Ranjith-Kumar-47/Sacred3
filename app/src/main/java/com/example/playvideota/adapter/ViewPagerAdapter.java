package com.example.playvideota.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.playvideota.fragment.GeetaSlokFragment;
import com.example.playvideota.fragment.MannTvFragment;
import com.example.playvideota.fragment.PanchangFragment;
import com.example.playvideota.fragment.RashiphalFragment;
import com.example.playvideota.fragment.TvFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private String[] titles = {"TV", "PANCHANG","RASHIPHAL","GEETA SLOK"};


    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position){
            case 0:
                return new MannTvFragment();
            case 1:
                return new PanchangFragment();
            case 2:
                return new RashiphalFragment();
            case 3:
                return new GeetaSlokFragment();

        }
        return new TvFragment();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }


}
