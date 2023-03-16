package com.pujagoodies.sacred.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.pujagoodies.sacred.fragment.GeetaSlokFragment;
import com.pujagoodies.sacred.fragment.MannTvFragment;
import com.pujagoodies.sacred.fragment.PanchangFragment;
import com.pujagoodies.sacred.fragment.PoojaVidhiFragment;
import com.pujagoodies.sacred.fragment.RashiphalFragment;
import com.pujagoodies.sacred.fragment.SahityaFragment;
import com.pujagoodies.sacred.fragment.TvFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {

//    private String[] titles = {"TV", "PANCHANG","RASHIPHAL","GEETA SLOK","SAHITYA"};
    private String[] titles = {"TV", "PANCHANG","POOJA VIDHI","RASHIPHAL","GEETA SLOK"};


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
                return new PoojaVidhiFragment();
            case 3:
                return new RashiphalFragment();
            case 4:
                return new GeetaSlokFragment();
//            case 4:
//                return new SahityaFragment();

        }
        return new TvFragment();
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }


}
