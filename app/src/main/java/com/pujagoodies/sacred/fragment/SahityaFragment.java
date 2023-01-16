package com.pujagoodies.sacred.fragment;

import static java.lang.Thread.sleep;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

//import com.example.playvideota.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pujagoodies.sacred.AuthActivity;
import com.pujagoodies.sacred.R;
import com.pujagoodies.sacred.SplashScreen;
import com.pujagoodies.sacred.databinding.FragmentSahityaBinding;
import com.pujagoodies.sacred.adapter.SahityaAdapter;
import com.pujagoodies.sacred.model.SahityaImageModel;
import com.pujagoodies.sacred.model.SahityaModel;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class SahityaFragment extends Fragment {
    RecyclerView sahityaRv;
    FragmentSahityaBinding binding;

    FirebaseDatabase database;


    ArrayList<SahityaImageModel> sahityaImageModelArrayList;
    ArrayList<SahityaImageModel> sahityaImageModelArrayList2;
    ArrayList<SahityaImageModel> sahityaImageModelArrayList3;

    ArrayList<SahityaModel> sahityaModelArrayList;


    public SahityaFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        database = FirebaseDatabase.getInstance();

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
        sahityaImageModelArrayList3 = new ArrayList<>();

        sahityaModelArrayList = new ArrayList<>();


        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                try {

                    database.getReference().child("sahitya")
                            .addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    if(snapshot.exists()){
                                        System.out.println("key Main "+snapshot.getKey());
//                                    System.out.println("value Main "+snapshot.getValue());

                                        for (DataSnapshot datasnapshot: snapshot.getChildren()
                                        ) {
                                            System.out.println("key second "+datasnapshot.getKey());
                                            String name =  datasnapshot.getKey();
                                            ArrayList<SahityaImageModel> namekey = new ArrayList<>();
//                                        System.out.println("value second "+datasnapshot.getValue());

                                            for (DataSnapshot datasnapshots: datasnapshot.getChildren()
                                            ) {
                                                System.out.println("key third "+datasnapshots.getKey());
//                                            System.out.println("value third "+datasnapshots.getValue());

//                                            System.out.println("#######################################");
                                                System.out.println("image "+datasnapshots.child("image").getValue());
                                                System.out.println("title "+datasnapshots.child("title").getValue());
                                                System.out.println("description "+datasnapshots.child("description").getValue());
                                                System.out.println("#######################################");

                                                String image = (String) datasnapshots.child("image").getValue();
                                                String title = (String) datasnapshots.child("title").getValue();
                                                String description = (String) datasnapshots.child("description").getValue();


                                                SahityaImageModel sahityaImageModel = new SahityaImageModel(
                                                        image,title,title,description
                                                );

                                                namekey.add(sahityaImageModel);

                                            }


                                            sahityaModelArrayList.add(new SahityaModel(name,namekey));

                                        }

                                    }

                                    SahityaAdapter sahityaAdapter = new SahityaAdapter(getContext(), sahityaModelArrayList);
                                    sahityaRv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
                                    sahityaRv.setAdapter(sahityaAdapter);
                                    sahityaRv.setNestedScrollingEnabled(false);
                                    sahityaAdapter.notifyDataSetChanged();


                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });

                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    SahityaAdapter sahityaAdapter = new SahityaAdapter(getContext(), sahityaModelArrayList);
                    sahityaRv.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false));
                    sahityaRv.setAdapter(sahityaAdapter);
                    sahityaRv.setNestedScrollingEnabled(false);
                    sahityaAdapter.notifyDataSetChanged();

                }
            }
        });





//        sahityaImageModelArrayList.add(new SahityaImageModel(""+R.drawable.ic_profile_svgrepo_com,"aarti kejiya hanuman ki","shree Hanuman Ji Aarti","Aarti Sangrah"));
//        sahityaImageModelArrayList.add(new SahityaImageModel(""+R.drawable.ic_profile_svgrepo_com,"aarti kejiya hanuman ki","shree Hanuman Ji Aarti","Aarti Sangrah"));
//        sahityaImageModelArrayList.add(new SahityaImageModel(""+R.drawable.ic_profile_svgrepo_com,"aarti kejiya hanuman ki","shree Hanuman Ji Aarti","Aarti Sangrah"));
//        sahityaImageModelArrayList.add(new SahityaImageModel(""+R.drawable.ic_profile_svgrepo_com,"aarti kejiya hanuman ki","shree Hanuman Ji Aarti","Aarti Sangrah"));
//
//        sahityaImageModelArrayList2.add(new SahityaImageModel(""+R.drawable.ic_profile_svgrepo_com,"aarti kejiya hanuman ki","shree Hanuman Ji Aarti","Aarti Sangrah"));
//        sahityaImageModelArrayList2.add(new SahityaImageModel(""+R.drawable.ic_profile_svgrepo_com,"aarti kejiya hanuman ki","shree Hanuman Ji Aarti","Aarti Sangrah"));
//        sahityaImageModelArrayList2.add(new SahityaImageModel(""+R.drawable.ic_profile_svgrepo_com,"aarti kejiya hanuman ki","shree Hanuman Ji Aarti","Aarti Sangrah"));
//        sahityaImageModelArrayList2.add(new SahityaImageModel(""+R.drawable.ic_profile_svgrepo_com,"aarti kejiya hanuman ki","shree Hanuman Ji Aarti","Aarti Sangrah"));
//
//
//        sahityaImageModelArrayList3.add(new SahityaImageModel(""+R.drawable.ic_profile_svgrepo_com,"aarti kejiya hanuman ki","shree Hanuman Ji Aarti","Aarti Sangrah"));
//        sahityaImageModelArrayList3.add(new SahityaImageModel(""+R.drawable.ic_profile_svgrepo_com,"aarti kejiya hanuman ki","shree Hanuman Ji Aarti","Aarti Sangrah"));
//        sahityaImageModelArrayList3.add(new SahityaImageModel(""+R.drawable.ic_profile_svgrepo_com,"aarti kejiya hanuman ki","shree Hanuman Ji Aarti","Aarti Sangrah"));
//        sahityaImageModelArrayList3.add(new SahityaImageModel(""+R.drawable.ic_profile_svgrepo_com,"aarti kejiya hanuman ki","shree Hanuman Ji Aarti","Aarti Sangrah"));
//


//
//        sahityaModelArrayList.add(new SahityaModel("Aarti Sangrah",sahityaImageModelArrayList));
//        sahityaModelArrayList.add(new SahityaModel("Hanuman Sangrah",sahityaImageModelArrayList2));
//        sahityaModelArrayList.add(new SahityaModel("Ram Sangrah",sahityaImageModelArrayList3));



    }

    private void initData() {
        sahityaRv = binding.sahityaRv;
    }
}