package com.example.playvideota.fragment;

import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.playvideota.R;
import com.example.playvideota.adapter.GeetaAdapter;
import com.example.playvideota.adapter.TvLiveVideoAdapter;
import com.example.playvideota.databinding.FragmentGeetaSlokBinding;
import com.example.playvideota.databinding.FragmentRashiphalBinding;
import com.example.playvideota.model.GeetaModel;

import java.util.ArrayList;


public class GeetaSlokFragment extends Fragment {

    Button adhyay1,adhyay2,adhyay3,adhyay4,adhyay5,adhyay6,adhyay7,adhyay8,adhyay9,adhyay10,adhyay11,adhyay12,adhyay13,adhyay14,adhyay15,adhyay16,adhyay17,adhyay18;

    RecyclerView geetaRv;
    FragmentGeetaSlokBinding binding;
    ArrayList<GeetaModel> list1 = new ArrayList<>();
    ArrayList<GeetaModel> list2 = new ArrayList<>();
    ArrayList<GeetaModel> list3 = new ArrayList<>();
    ArrayList<GeetaModel> list4 = new ArrayList<>();
    ArrayList<GeetaModel> list5 = new ArrayList<>();
    ArrayList<GeetaModel> list6 = new ArrayList<>();
    ArrayList<GeetaModel> list7 = new ArrayList<>();
    ArrayList<GeetaModel> list8 = new ArrayList<>();
    ArrayList<GeetaModel> list9 = new ArrayList<>();
    ArrayList<GeetaModel> list10 = new ArrayList<>();
    ArrayList<GeetaModel> list11 = new ArrayList<>();
    ArrayList<GeetaModel> list12 = new ArrayList<>();
    ArrayList<GeetaModel> list13 = new ArrayList<>();
    ArrayList<GeetaModel> list14 = new ArrayList<>();
    ArrayList<GeetaModel> list15 = new ArrayList<>();
    ArrayList<GeetaModel> list16 = new ArrayList<>();
    ArrayList<GeetaModel> list17 = new ArrayList<>();
    ArrayList<GeetaModel> list18 = new ArrayList<>();

    public GeetaSlokFragment() {
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
//        return inflater.inflate(R.layout.fragment_geeta_slok, container, false);

        binding = FragmentGeetaSlokBinding.inflate(inflater,container,false);

        initButton();


        addDataToList1();
        addDataToList2();
        addDataToList3();
        addDataToList4();
        addDataToList5();
        addDataToList6();
        addDataToList7();
        addDataToList8();
        addDataToList9();
        addDataToList10();
        addDataToList11();
        addDataToList12();
        addDataToList13();
        addDataToList14();
        addDataToList15();
        addDataToList16();
        addDataToList17();
        addDataToList18();


        geetaRv = binding.geetaRV;
        onClickHandler();

        lookSelected(adhyay1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
        geetaRv.setLayoutManager(linearLayoutManager);
        GeetaAdapter geetaAdapter = new GeetaAdapter(getContext(),list1);
        geetaRv.setAdapter(geetaAdapter);

        return binding.getRoot();
    }

    private void onClickHandler() {
        adhyay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookSelected(adhyay1);
//                lookUnSelected(adhyay1);
                lookUnSelected(adhyay2);
                lookUnSelected(adhyay3);
                lookUnSelected(adhyay4);
                lookUnSelected(adhyay5);
                lookUnSelected(adhyay6);
                lookUnSelected(adhyay7);
                lookUnSelected(adhyay8);
                lookUnSelected(adhyay9);
                lookUnSelected(adhyay10);
                lookUnSelected(adhyay11);
                lookUnSelected(adhyay12);
                lookUnSelected(adhyay13);
                lookUnSelected(adhyay14);
                lookUnSelected(adhyay15);
                lookUnSelected(adhyay16);
                lookUnSelected(adhyay17);
                lookUnSelected(adhyay18);

                Toast.makeText(getContext(), "chapter 1", Toast.LENGTH_SHORT).show();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
                geetaRv.setLayoutManager(linearLayoutManager);
                GeetaAdapter geetaAdapter = new GeetaAdapter(getContext(),list1);
                geetaRv.setAdapter(geetaAdapter);
            }
        });

        adhyay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookSelected(adhyay2);
                lookUnSelected(adhyay1);
//                lookUnSelected(adhyay2);
                lookUnSelected(adhyay3);
                lookUnSelected(adhyay4);
                lookUnSelected(adhyay5);
                lookUnSelected(adhyay6);
                lookUnSelected(adhyay7);
                lookUnSelected(adhyay8);
                lookUnSelected(adhyay9);
                lookUnSelected(adhyay10);
                lookUnSelected(adhyay11);
                lookUnSelected(adhyay12);
                lookUnSelected(adhyay13);
                lookUnSelected(adhyay14);
                lookUnSelected(adhyay15);
                lookUnSelected(adhyay16);
                lookUnSelected(adhyay17);
                lookUnSelected(adhyay18);
                Toast.makeText(getContext(), "chapter 2", Toast.LENGTH_SHORT).show();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
                geetaRv.setLayoutManager(linearLayoutManager);
                GeetaAdapter geetaAdapter = new GeetaAdapter(getContext(),list2);
                geetaRv.setAdapter(geetaAdapter);
            }
        });

        adhyay3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookSelected(adhyay3);
                lookUnSelected(adhyay1);
                lookUnSelected(adhyay2);
//                lookUnSelected(adhyay3);
                lookUnSelected(adhyay4);
                lookUnSelected(adhyay5);
                lookUnSelected(adhyay6);
                lookUnSelected(adhyay7);
                lookUnSelected(adhyay8);
                lookUnSelected(adhyay9);
                lookUnSelected(adhyay10);
                lookUnSelected(adhyay11);
                lookUnSelected(adhyay12);
                lookUnSelected(adhyay13);
                lookUnSelected(adhyay14);
                lookUnSelected(adhyay15);
                lookUnSelected(adhyay16);
                lookUnSelected(adhyay17);
                lookUnSelected(adhyay18);
                Toast.makeText(getContext(), "chapter 3", Toast.LENGTH_SHORT).show();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
                geetaRv.setLayoutManager(linearLayoutManager);
                GeetaAdapter geetaAdapter = new GeetaAdapter(getContext(),list3);
                geetaRv.setAdapter(geetaAdapter);
            }
        });

        adhyay4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookSelected(adhyay4);
                lookUnSelected(adhyay1);
                lookUnSelected(adhyay2);
                lookUnSelected(adhyay3);
//                lookUnSelected(adhyay4);
                lookUnSelected(adhyay5);
                lookUnSelected(adhyay6);
                lookUnSelected(adhyay7);
                lookUnSelected(adhyay8);
                lookUnSelected(adhyay9);
                lookUnSelected(adhyay10);
                lookUnSelected(adhyay11);
                lookUnSelected(adhyay12);
                lookUnSelected(adhyay13);
                lookUnSelected(adhyay14);
                lookUnSelected(adhyay15);
                lookUnSelected(adhyay16);
                lookUnSelected(adhyay17);
                lookUnSelected(adhyay18);
                Toast.makeText(getContext(), "chapter 4", Toast.LENGTH_SHORT).show();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
                geetaRv.setLayoutManager(linearLayoutManager);
                GeetaAdapter geetaAdapter = new GeetaAdapter(getContext(),list4);
                geetaRv.setAdapter(geetaAdapter);
            }
        });

        adhyay5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookSelected(adhyay5);
                lookUnSelected(adhyay1);
                lookUnSelected(adhyay2);
                lookUnSelected(adhyay3);
                lookUnSelected(adhyay4);
//                lookUnSelected(adhyay5);
                lookUnSelected(adhyay6);
                lookUnSelected(adhyay7);
                lookUnSelected(adhyay8);
                lookUnSelected(adhyay9);
                lookUnSelected(adhyay10);
                lookUnSelected(adhyay11);
                lookUnSelected(adhyay12);
                lookUnSelected(adhyay13);
                lookUnSelected(adhyay14);
                lookUnSelected(adhyay15);
                lookUnSelected(adhyay16);
                lookUnSelected(adhyay17);
                lookUnSelected(adhyay18);
                Toast.makeText(getContext(), "chapter 5", Toast.LENGTH_SHORT).show();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
                geetaRv.setLayoutManager(linearLayoutManager);
                GeetaAdapter geetaAdapter = new GeetaAdapter(getContext(),list5);
                geetaRv.setAdapter(geetaAdapter);
            }
        });

        adhyay6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookSelected(adhyay6);
                lookUnSelected(adhyay1);
                lookUnSelected(adhyay2);
                lookUnSelected(adhyay3);
                lookUnSelected(adhyay4);
                lookUnSelected(adhyay5);
//                lookUnSelected(adhyay6);
                lookUnSelected(adhyay7);
                lookUnSelected(adhyay8);
                lookUnSelected(adhyay9);
                lookUnSelected(adhyay10);
                lookUnSelected(adhyay11);
                lookUnSelected(adhyay12);
                lookUnSelected(adhyay13);
                lookUnSelected(adhyay14);
                lookUnSelected(adhyay15);
                lookUnSelected(adhyay16);
                lookUnSelected(adhyay17);
                lookUnSelected(adhyay18);
                Toast.makeText(getContext(), "chapter 6", Toast.LENGTH_SHORT).show();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
                geetaRv.setLayoutManager(linearLayoutManager);
                GeetaAdapter geetaAdapter = new GeetaAdapter(getContext(),list6);
                geetaRv.setAdapter(geetaAdapter);
            }
        });

        adhyay7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookSelected(adhyay7);
                lookUnSelected(adhyay1);
                lookUnSelected(adhyay2);
                lookUnSelected(adhyay3);
                lookUnSelected(adhyay4);
                lookUnSelected(adhyay5);
                lookUnSelected(adhyay6);
//                lookUnSelected(adhyay7);
                lookUnSelected(adhyay8);
                lookUnSelected(adhyay9);
                lookUnSelected(adhyay10);
                lookUnSelected(adhyay11);
                lookUnSelected(adhyay12);
                lookUnSelected(adhyay13);
                lookUnSelected(adhyay14);
                lookUnSelected(adhyay15);
                lookUnSelected(adhyay16);
                lookUnSelected(adhyay17);
                lookUnSelected(adhyay18);
                Toast.makeText(getContext(), "chapter 7", Toast.LENGTH_SHORT).show();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
                geetaRv.setLayoutManager(linearLayoutManager);
                GeetaAdapter geetaAdapter = new GeetaAdapter(getContext(),list7);
                geetaRv.setAdapter(geetaAdapter);
            }
        });

        adhyay8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookSelected(adhyay8);
                lookUnSelected(adhyay1);
                lookUnSelected(adhyay2);
                lookUnSelected(adhyay3);
                lookUnSelected(adhyay4);
                lookUnSelected(adhyay5);
                lookUnSelected(adhyay6);
                lookUnSelected(adhyay7);
//                lookUnSelected(adhyay8);
                lookUnSelected(adhyay9);
                lookUnSelected(adhyay10);
                lookUnSelected(adhyay11);
                lookUnSelected(adhyay12);
                lookUnSelected(adhyay13);
                lookUnSelected(adhyay14);
                lookUnSelected(adhyay15);
                lookUnSelected(adhyay16);
                lookUnSelected(adhyay17);
                lookUnSelected(adhyay18);
                Toast.makeText(getContext(), "chapter 8", Toast.LENGTH_SHORT).show();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
                geetaRv.setLayoutManager(linearLayoutManager);
                GeetaAdapter geetaAdapter = new GeetaAdapter(getContext(),list8);
                geetaRv.setAdapter(geetaAdapter);
            }
        });

        adhyay9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookSelected(adhyay9);
                lookUnSelected(adhyay1);
                lookUnSelected(adhyay2);
                lookUnSelected(adhyay3);
                lookUnSelected(adhyay4);
                lookUnSelected(adhyay5);
                lookUnSelected(adhyay6);
                lookUnSelected(adhyay7);
                lookUnSelected(adhyay8);
//                lookUnSelected(adhyay9);
                lookUnSelected(adhyay10);
                lookUnSelected(adhyay11);
                lookUnSelected(adhyay12);
                lookUnSelected(adhyay13);
                lookUnSelected(adhyay14);
                lookUnSelected(adhyay15);
                lookUnSelected(adhyay16);
                lookUnSelected(adhyay17);
                lookUnSelected(adhyay18);
                Toast.makeText(getContext(), "chapter 9", Toast.LENGTH_SHORT).show();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
                geetaRv.setLayoutManager(linearLayoutManager);
                GeetaAdapter geetaAdapter = new GeetaAdapter(getContext(),list9);
                geetaRv.setAdapter(geetaAdapter);
            }
        });

        adhyay10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookSelected(adhyay10);
                lookUnSelected(adhyay1);
                lookUnSelected(adhyay2);
                lookUnSelected(adhyay3);
                lookUnSelected(adhyay4);
                lookUnSelected(adhyay5);
                lookUnSelected(adhyay6);
                lookUnSelected(adhyay7);
                lookUnSelected(adhyay8);
                lookUnSelected(adhyay9);
//                lookUnSelected(adhyay10);
                lookUnSelected(adhyay11);
                lookUnSelected(adhyay12);
                lookUnSelected(adhyay13);
                lookUnSelected(adhyay14);
                lookUnSelected(adhyay15);
                lookUnSelected(adhyay16);
                lookUnSelected(adhyay17);
                lookUnSelected(adhyay18);
                Toast.makeText(getContext(), "chapter 10", Toast.LENGTH_SHORT).show();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
                geetaRv.setLayoutManager(linearLayoutManager);
                GeetaAdapter geetaAdapter = new GeetaAdapter(getContext(),list10);
                geetaRv.setAdapter(geetaAdapter);
            }
        });

        adhyay11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookSelected(adhyay11);
                lookUnSelected(adhyay1);
                lookUnSelected(adhyay2);
                lookUnSelected(adhyay3);
                lookUnSelected(adhyay4);
                lookUnSelected(adhyay5);
                lookUnSelected(adhyay6);
                lookUnSelected(adhyay7);
                lookUnSelected(adhyay8);
                lookUnSelected(adhyay9);
                lookUnSelected(adhyay10);
//                lookUnSelected(adhyay11);
                lookUnSelected(adhyay12);
                lookUnSelected(adhyay13);
                lookUnSelected(adhyay14);
                lookUnSelected(adhyay15);
                lookUnSelected(adhyay16);
                lookUnSelected(adhyay17);
                lookUnSelected(adhyay18);
                Toast.makeText(getContext(), "chapter 11", Toast.LENGTH_SHORT).show();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
                geetaRv.setLayoutManager(linearLayoutManager);
                GeetaAdapter geetaAdapter = new GeetaAdapter(getContext(),list11);
                geetaRv.setAdapter(geetaAdapter);
            }
        });

        adhyay12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookSelected(adhyay12);
                lookUnSelected(adhyay1);
                lookUnSelected(adhyay2);
                lookUnSelected(adhyay3);
                lookUnSelected(adhyay4);
                lookUnSelected(adhyay5);
                lookUnSelected(adhyay6);
                lookUnSelected(adhyay7);
                lookUnSelected(adhyay8);
                lookUnSelected(adhyay9);
                lookUnSelected(adhyay10);
                lookUnSelected(adhyay11);
//                lookUnSelected(adhyay12);
                lookUnSelected(adhyay13);
                lookUnSelected(adhyay14);
                lookUnSelected(adhyay15);
                lookUnSelected(adhyay16);
                lookUnSelected(adhyay17);
                lookUnSelected(adhyay18);
                Toast.makeText(getContext(), "chapter 12", Toast.LENGTH_SHORT).show();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
                geetaRv.setLayoutManager(linearLayoutManager);
                GeetaAdapter geetaAdapter = new GeetaAdapter(getContext(),list12);
                geetaRv.setAdapter(geetaAdapter);
            }
        });

        adhyay13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookSelected(adhyay13);
                lookUnSelected(adhyay1);
                lookUnSelected(adhyay2);
                lookUnSelected(adhyay3);
                lookUnSelected(adhyay4);
                lookUnSelected(adhyay5);
                lookUnSelected(adhyay6);
                lookUnSelected(adhyay7);
                lookUnSelected(adhyay8);
                lookUnSelected(adhyay9);
                lookUnSelected(adhyay10);
                lookUnSelected(adhyay11);
                lookUnSelected(adhyay12);
//                lookUnSelected(adhyay13);
                lookUnSelected(adhyay14);
                lookUnSelected(adhyay15);
                lookUnSelected(adhyay16);
                lookUnSelected(adhyay17);
                lookUnSelected(adhyay18);
                Toast.makeText(getContext(), "chapter 13", Toast.LENGTH_SHORT).show();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
                geetaRv.setLayoutManager(linearLayoutManager);
                GeetaAdapter geetaAdapter = new GeetaAdapter(getContext(),list13);
                geetaRv.setAdapter(geetaAdapter);
            }
        });

        adhyay14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookSelected(adhyay14);
                lookUnSelected(adhyay1);
                lookUnSelected(adhyay2);
                lookUnSelected(adhyay3);
                lookUnSelected(adhyay4);
                lookUnSelected(adhyay5);
                lookUnSelected(adhyay6);
                lookUnSelected(adhyay7);
                lookUnSelected(adhyay8);
                lookUnSelected(adhyay9);
                lookUnSelected(adhyay10);
                lookUnSelected(adhyay11);
                lookUnSelected(adhyay12);
                lookUnSelected(adhyay13);
//                lookUnSelected(adhyay14);
                lookUnSelected(adhyay15);
                lookUnSelected(adhyay16);
                lookUnSelected(adhyay17);
                lookUnSelected(adhyay18);
                Toast.makeText(getContext(), "chapter 14", Toast.LENGTH_SHORT).show();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
                geetaRv.setLayoutManager(linearLayoutManager);
                GeetaAdapter geetaAdapter = new GeetaAdapter(getContext(),list14);
                geetaRv.setAdapter(geetaAdapter);
            }
        });

        adhyay15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookSelected(adhyay15);
                lookUnSelected(adhyay1);
                lookUnSelected(adhyay2);
                lookUnSelected(adhyay3);
                lookUnSelected(adhyay4);
                lookUnSelected(adhyay5);
                lookUnSelected(adhyay6);
                lookUnSelected(adhyay7);
                lookUnSelected(adhyay8);
                lookUnSelected(adhyay9);
                lookUnSelected(adhyay10);
                lookUnSelected(adhyay11);
                lookUnSelected(adhyay12);
                lookUnSelected(adhyay13);
                lookUnSelected(adhyay14);
//                lookUnSelected(adhyay15);
                lookUnSelected(adhyay16);
                lookUnSelected(adhyay17);
                lookUnSelected(adhyay18);
                Toast.makeText(getContext(), "chapter 15", Toast.LENGTH_SHORT).show();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
                geetaRv.setLayoutManager(linearLayoutManager);
                GeetaAdapter geetaAdapter = new GeetaAdapter(getContext(),list15);
                geetaRv.setAdapter(geetaAdapter);
            }
        });

        adhyay16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookSelected(adhyay16);
                lookUnSelected(adhyay1);
                lookUnSelected(adhyay2);
                lookUnSelected(adhyay3);
                lookUnSelected(adhyay4);
                lookUnSelected(adhyay5);
                lookUnSelected(adhyay6);
                lookUnSelected(adhyay7);
                lookUnSelected(adhyay8);
                lookUnSelected(adhyay9);
                lookUnSelected(adhyay10);
                lookUnSelected(adhyay11);
                lookUnSelected(adhyay12);
                lookUnSelected(adhyay13);
                lookUnSelected(adhyay14);
                lookUnSelected(adhyay15);
//                lookUnSelected(adhyay16);
                lookUnSelected(adhyay17);
                lookUnSelected(adhyay18);
                Toast.makeText(getContext(), "chapter 16", Toast.LENGTH_SHORT).show();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
                geetaRv.setLayoutManager(linearLayoutManager);
                GeetaAdapter geetaAdapter = new GeetaAdapter(getContext(),list16);
                geetaRv.setAdapter(geetaAdapter);
            }
        });

        adhyay17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookSelected(adhyay17);
                lookUnSelected(adhyay1);
                lookUnSelected(adhyay2);
                lookUnSelected(adhyay3);
                lookUnSelected(adhyay4);
                lookUnSelected(adhyay5);
                lookUnSelected(adhyay6);
                lookUnSelected(adhyay7);
                lookUnSelected(adhyay8);
                lookUnSelected(adhyay9);
                lookUnSelected(adhyay10);
                lookUnSelected(adhyay11);
                lookUnSelected(adhyay12);
                lookUnSelected(adhyay13);
                lookUnSelected(adhyay14);
                lookUnSelected(adhyay15);
                lookUnSelected(adhyay16);
//                lookUnSelected(adhyay17);
                lookUnSelected(adhyay18);
                Toast.makeText(getContext(), "chapter 17", Toast.LENGTH_SHORT).show();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
                geetaRv.setLayoutManager(linearLayoutManager);
                GeetaAdapter geetaAdapter = new GeetaAdapter(getContext(),list17);
                geetaRv.setAdapter(geetaAdapter);
            }
        });

        adhyay18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lookSelected(adhyay18);
                lookUnSelected(adhyay1);
                lookUnSelected(adhyay2);
                lookUnSelected(adhyay3);
                lookUnSelected(adhyay4);
                lookUnSelected(adhyay5);
                lookUnSelected(adhyay6);
                lookUnSelected(adhyay7);
                lookUnSelected(adhyay8);
                lookUnSelected(adhyay9);
                lookUnSelected(adhyay10);
                lookUnSelected(adhyay11);
                lookUnSelected(adhyay12);
                lookUnSelected(adhyay13);
                lookUnSelected(adhyay14);
                lookUnSelected(adhyay15);
                lookUnSelected(adhyay16);
                lookUnSelected(adhyay17);
//                lookUnSelected(adhyay18);
                Toast.makeText(getContext(), "chapter 18", Toast.LENGTH_SHORT).show();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL,false);
                geetaRv.setLayoutManager(linearLayoutManager);
                GeetaAdapter geetaAdapter = new GeetaAdapter(getContext(),list18);
                geetaRv.setAdapter(geetaAdapter);
            }
        });

    }

    private void addDataToList1() {

        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 1","धृतराष्ट्र उवाच |\n" +
                "धर्मक्षेत्रे कुरुक्षेत्रे समवेता युयुत्सवः |\n" +
                "मामकाः पाण्डवाश्चैव किमकुर्वत सञ्जय ||1||","धृतराष्ट्र ने कहा: हे संजय, कुरुक्षेत्र के पवित्र मैदान पर एकत्रित होकर, और युद्ध करने की इच्छा रखने के बाद, मेरे पुत्रों और पांडु के पुत्रों ने क्या किया?"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 2","सञ्जय उवाच ।\n" +
                "दृष्ट्वा तु पाण्डवानीकं व्यूढं दुर्योधनस्तदा ।\n" +
                "आचार्यमुपसङ्गम्य राजा वचनमब्रवीत् ।। 2।।","संजय ने कहा: पांडव सेना को सैन्य सेना में खड़ा देखकर, राजा दुर्योधन अपने शिक्षक द्रोणाचार्य के पास पहुंचे, और निम्नलिखित शब्द कहे।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 3","पश्यैतां पाण्डुपुत्राणामाचार्य महतीं चमूम् ।\n" +
                "व्यूढां द्रुपदपुत्रेण तव शिष्येण धीमता ।। 3।।","दुर्योधन ने कहा- आदरणीय गुरु! पांडु के पुत्रों की शक्तिशाली सेना को देखो, जो द्रुपद के पुत्र, अपने ही प्रतिभाशाली शिष्य द्वारा युद्ध के लिए इतनी कुशलता से तैयार है।"));
        list1.add(new GeetaModel("अध्याय 1"," गीता श्लोक 4-6","अत्र शूरा महेष्वासा भीमार्जुनसमा युधि\n" +
                "युयुधानो विराटश्च द्रुपदश्च महारथ: || 4||\n" +
                "\n" +
                "धृष्टकेतुश्चेकितान: काशिराजश्च वीर्यवान् |\n" +
                "पुरुजित्कुन्तिभोजश्च शैब्यश्च नरपुङ्गव: || 5||\n" +
                "\n" +
                "युधामन्युश्च विक्रान्त उत्तमौजाश्च वीर्यवान् |\n" +
                "सौभद्रो द्रौपदेयाश्च सर्व एव महारथा: || 6||","देखो उनके रैंकों में युयुधन, विराट और द्रुपद जैसे कई शक्तिशाली योद्धा हैं, जो शक्तिशाली धनुष का सामना कर रहे हैं और भीम और अर्जुन के बराबर सैन्य कौशल में हैं। धृष्टकेतु, चेकितान, काशी के वीर राजा पुरुजीत, कुंतीभोज और शैब्य जैसे निपुण नायक भी हैं। उनके रैंकों में, उनके पास साहसी युद्धमन्यु, सुभद्रा के पुत्र, बहादुर उत्तमौजा और द्रौपदी के पुत्र भी हैं, जो सभी महान योद्धा प्रमुख हैं।"));


        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 7","अस्माकं तु विशिष्टा ये तान्निबोध द्विजोत्तम |\n" +
                "नायका मम सैन्यस्य संज्ञार्थं तान्ब्रवीमि ते || 7||","हे श्रेष्ठ ब्राह्मणों, हमारी ओर के प्रमुख सेनापतियों के बारे में भी सुनो, जो विशेष रूप से नेतृत्व करने के योग्य हैं। अब मैं आपको बताता हूं"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 8","भवान्भीष्मश्च कर्णश्च कृपश्च समितिञ्जय: |\n" +
                "अश्वत्थामा विकर्णश्च सौमदत्तिस्तथैव च || 8||","आपके, भीष्म, कर्ण, कृपा, अश्वत्थामा, विकर्ण और भूरिश्रवा जैसे व्यक्तित्व हैं, जो युद्ध में हमेशा विजयी होते हैं।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 9","अन्ये च बहव: शूरा मदर्थे त्यक्तजीविता: |\n" +
                "\n" +
                "नानाशस्त्रप्रहरणा: सर्वे युद्धविशारदा: || 9||","इसके अलावा, कई अन्य वीर योद्धा हैं, जो मेरे लिए अपना जीवन देने के लिए तैयार हैं। वे सभी युद्ध की कला में कुशल हैं, और विभिन्न प्रकार के हथियारों से लैस हैं"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 10","अपर्याप्तं तदस्माकं बलं भीष्माभिरक्षितम् |\n" +
                "\n" +
                "पर्याप्तं त्विदमेतेषां बलं भीमाभिरक्षितम् || 10||","हमारी सेना की ताकत असीमित है और हमें ग्रैंडसियर भीष्म द्वारा सुरक्षित रूप से मार्शल किया जाता है, जबकि पांडव सेना की ताकत, जिसे भीम द्वारा सावधानीपूर्वक मार्शल किया गया था, सीमित है।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 11","अयनेषु च सर्वेषु यथाभागमवस्थिता: |\n" +
                "भीष्ममेवाभिरक्षन्तु भवन्त: सर्व एव हि || 11||","इसलिए, मैं कौरव सेना के सभी जनरलों का आह्वान करता हूं कि वे ग्रैंडसिर भीष्म को पूरा समर्थन दें, भले ही आप अपने संबंधित रणनीतिक बिंदुओं का बचाव करें।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 12","तस्य सञ्जनयन्हर्षं कुरुवृद्ध: पितामह: |\n" +
                "सिंहनादं विनद्योच्चै: शङ्खं दध्मौ प्रतापवान् || 12||","फिर, कुरु वंश के दादाजी, प्रतापी कुलपिता भीष्म, शेर की तरह दहाड़े, और दुर्योधन को खुशी देते हुए अपने शंख को बहुत जोर से उड़ाया।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 13","तत: शङ्खाश्च भेर्यश्च पणवानकगोमुखा: |\n" +
                "सहसैवाभ्यहन्यन्त स शब्दस्तुमुलोऽभवत् || 13||","इसके बाद, शंख, केटलड्रम, बिगुल, तुरही और सींग अचानक तेज हो गए, और उनकी संयुक्त ध्वनि भारी थी।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 14","तत: श्वेतैर्हयैर्युक्ते महति स्यन्दने स्थितौ |\n" +
                "माधव: पाण्डवश्चैव दिव्यौ शङ्खौ प्रदध्मतु: || 14||","फिर, पांडव सेना के बीच से, सफेद घोड़ों द्वारा खींचे गए एक शानदार रथ में बैठे, माधव और अर्जुन ने अपने दिव्य शंख बजाए।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 15","पाञ्चजन्यं हृषीकेशो देवदत्तं धनञ्जय: |\n" +
                "पौण्ड्रं दध्मौ महाशङ्खं भीमकर्मा वृकोदर: || 15||","हृषिकेश ने अपना शंख बजाया, जिसे पांचजन्य कहा जाता है, और अर्जुन ने देवदत्त उड़ाया। भीम, जो खाने वाला और कठिन कार्यों का प्रदर्शन करने वाला था, ने अपने शक्तिशाली शंख को उड़ाया, जिसे पौंड्रा कहा जाता है।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 16-18","अनन्तविजयं राजा कुन्तीपुत्रो युधिष्ठिर: |\n" +
                "नकुल: सहदेवश्च सुघोषमणिपुष्पकौ || 16||\n" +
                "काश्यश्च परमेष्वास: शिखण्डी च महारथ: |\n" +
                "धृष्टद्युम्नो विराटश्च सात्यकिश्चापराजित: || 17||\n" +
                "द्रुपदो द्रौपदेयाश्च सर्वश: पृथिवीपते |\n" +
                "सौभद्रश्च महाबाहु: शङ्खान्दध्मु: पृथक् पृथक् || 18||","राजा युधिष्ठिर ने अनंतविजय उड़ाया, जबकि नकुल और सहदेव ने सुघोष और मणिपुष्पक उड़ाया। उत्कृष्ट धनुर्धर और काशी के राजा, महान योद्धा शिखंडी, धृष्टद्युम्न, विराट और अजेय सात्यकि द्रौपदी के पांच पुत्र द्रुपद और सुभद्रा के पुत्र पराक्रमी-शस्त्र अभिमन्यु सभी ने अपने-अपने शंख उड़ाए, हे पृथ्वी के शासक।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 19","स घोषो धार्तराष्ट्राणां हृदयानि व्यदारयत् |\n" +
                "\n" +
                "नभश्च पृथिवीं चैव तुमुलोऽभ्यनुनादयन् || 19||","आकाश और पृथ्वी पर भयानक ध्वनि गरजी, और आपके बेटों के दिलों को चकनाचूर कर दिया, हे धृतराष्ट्र"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 20","अथ व्यवस्थितान्दृष्ट्वा धार्तराष्ट्रान् कपिध्वज: |\n" +
                "प्रवृत्ते शस्त्रसम्पाते धनुरुद्यम्य पाण्डव: ||20||\n" +
                "हृषीकेशं तदा वाक्यमिदमाह महीपते |","उस समय पांडु के पुत्र अर्जुन, जिनके रथ के ध्वज पर हनुमान का प्रतीक चिन्ह था, ने अपना धनुष उठाया। हे राजा, अर्जुन ने अपने पुत्रों को अपने विरुद्ध खड़ा देखकर श्री कृष्ण से निम्नलिखित शब्द कहे।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 21-22","अर्जुन उवाच |\n" +
                "सेनयोरुभयोर्मध्ये रथं स्थापय मेऽच्युत || 21||\n" +
                "यावदेतान्निरीक्षेऽहं योद्धुकामानवस्थितान् |\n" +
                "कैर्मया सह योद्धव्यमस्मिन् रणसमुद्यमे || 22||","अर्जुन ने कहा: हे अचूक, कृपया मेरे रथ को दोनों सेनाओं के बीच में ले जाएं, ताकि मैं युद्ध के लिए तैयार योद्धाओं को देख सकूं, जिनसे मुझे इस महान युद्ध में लड़ना है।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 23","योत्स्यमानानवेक्षेऽहं य एतेऽत्र समागता: |\n" +
                "धार्तराष्ट्रस्य दुर्बुद्धेर्युद्धे प्रियचिकीर्षव: || 23||","मैं उन लोगों को देखना चाहता हूं जो धृतराष्ट्र के दुष्ट स्वभाव वाले पुत्र के पक्ष में लड़ने के लिए यहां आए हैं, उसे खुश करने की इच्छा रखते हैं।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 24","एवमुक्तो हृषीकेशो गुडाकेशेन भारत |\n" +
                "सेनयोरुभयोर्मध्ये स्थापयित्वा रथोत्तमम् || 24||","संजय ने कहा: हे धृतराष्ट्र, जिसे इस प्रकार अर्जुन, नींद के विजेता द्वारा संबोधित किया गया था, श्री कृष्ण ने तब दोनों सेनाओं के बीच शानदार रथ खींचा।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 25","भीष्मद्रोणप्रमुखत: सर्वेषां च महीक्षिताम् |\n" +
                "उवाच पार्थ पश्यैतान्समवेतान्कुरूनिति || 25||","भीष्म, द्रोणाचार्य और अन्य सभी राजाओं की उपस्थिति में श्री कृष्ण ने कहा: हे पार्थ, इन कुरुओं को देखो।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 26","तत्रापश्यत्स्थितान् पार्थ: पितृ नथ पितामहान् |\n" +
                "आचार्यान्मातुलान्भ्रातृ न्पुत्रान्पौत्रान्सखींस्तथा || 26||\n" +
                "श्वशुरान्सुहृदश्चैव सेनयोरुभयोरपि |","वहां, अर्जुन दोनों सेनाओं में तैनात, अपने पिता, दादा, शिक्षक, मामा, भाई, चचेरे भाई, बेटे, भतीजे, पोते-भतीजे, दोस्त, ससुर और शुभचिंतकों को देख सकते थे।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 27","तान्समीक्ष्य स कौन्तेय: सर्वान्बन्धूनवस्थितान् || 27||\n" +
                "कृपया परयाविष्टो विषीदन्निदमब्रवीत् |","वहां उपस्थित अपने सभी रिश्तेदारों को देख कुंती के पुत्र अर्जुन करुणा से अभिभूत हो गए, और गहरे दुःख के साथ निम्नलिखित शब्द बोले।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 28","अर्जुन उवाच |\n" +
                "दृष्ट्वेमं स्वजनं कृष्ण युयुत्सुं समुपस्थितम् || 28||\n" +
                "सीदन्ति मम गात्राणि मुखं च परिशुष्यति |","अर्जुन ने कहा: हे कृष्ण, अपने ही रिश्तेदारों को यहां युद्ध के लिए खड़ा देखकर और एक-दूसरे को मारने का इरादा रखते हुए, मेरे अंग रास्ता दे रहे हैं और मेरा मुंह सूख रहा है।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 29-31","वेपथुश्च शरीरे मे रोमहर्षश्च जायते || 29||\n" +
                "गाण्डीवं स्रंसते हस्तात्त्वक्चै व परिदह्यते |\n" +
                "न च शक्नोम्यवस्थातुं भ्रमतीव च मे मन: || 30||\n" +
                "निमित्तानि च पश्यामि विपरीतानि केशव |\n" +
                "न च श्रेयोऽनुपश्यामि हत्वा स्वजनमाहवे || 31||","मेरा पूरा शरीर कांप जाता है; मेरे रोंगटे खड़े हैं। मेरा धनुष, ग़वी, मेरे हाथ से फिसल रहा है, और मेरी त्वचा चारों ओर जल रही है। मेरा मन उलझन में है और भ्रम में भंवर में है; मैं अब खुद को स्थिर रखने में असमर्थ हूं। हे कृष्ण, केशी राक्षस के हत्यारे, मुझे दुर्भाग्य के शगुन ही दिखाई देते हैं। मुझे नहीं लगता कि इस लड़ाई में अपने ही रिश्तेदारों को मारने से कोई फायदा कैसे हो सकता है।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 32-33","न काङ्क्षे विजयं कृष्ण न च राज्यं सुखानि च |\n" +
                "किं नो राज्येन गोविन्द किं भोगैर्जीवितेन वा || 32||\n" +
                "येषामर्थे काङ्क्षितं नो राज्यं भोगा: सुखानि च |\n" +
                "त इमेऽवस्थिता युद्धे प्राणांस्त्यक्त्वा धनानि च || 33||","हे कृष्ण, मैं विजय, राज्य या उससे प्राप्त होने वाली खुशी नहीं चाहता। एक राज्य, सुख, या यहां तक कि जीवन का क्या फायदा होगा, जब वे लोग जिनके लिए हम उनका लालच करते हैं, युद्ध के लिए हमारे सामने खड़े हैं?"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 34-35","आचार्या: पितर: पुत्रास्तथैव च पितामहा: |\n" +
                "मातुला: श्वशुरा: पौत्रा: श्याला: सम्बन्धिनस्तथा || 34||\n" +
                "एतान्न हन्तुमिच्छामि घ्नतोऽपि मधुसूदन |\n" +
                "अपि त्रैलोक्यराज्यस्य हेतो: किं नु महीकृते || 35||","शिक्षक, पिता, पुत्र, दादा, मामा, पोते, ससुर, पोते, पोते, ससुर, पोते, बहनोई और अन्य रिश्तेदार यहां मौजूद हैं, अपने जीवन और धन को दांव पर लगाते हैं। हे मधुसूदन, मैं उन्हें मारना नहीं चाहता, भले ही वे मुझ पर हमला करें। यदि हम धृतराष्ट्र के पुत्रों का वध कर दें तो तीनों लोकों पर प्रभुता करने से हमें क्या संतोष मिलेगा, इस पृथ्वी की क्या बात करें?"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 36-37","निहत्य धार्तराष्ट्रान्न: का प्रीति: स्याज्जनार्दन |\n" +
                "पापमेवाश्रयेदस्मान्हत्वैतानाततायिन: || 36 ||\n" +
                "तस्मान्नार्हा वयं हन्तुं धार्तराष्ट्रान्स्वबान्धवान् |\n" +
                "स्वजनं हि कथं हत्वा सुखिन: स्याम माधव || 37||","हे सब जीवों के रखवाले, धृतराष्ट्र के पुत्रों को मारने से हमें क्या आनंद मिलेगा? भले ही वे आक्रमणकारी हों, लेकिन अगर हम उन्हें मारते हैं तो पाप निश्चित रूप से हमारे ऊपर आएगा। इसलिए, हमें अपने चचेरे भाइयों, धृतराष्ट्र के पुत्रों और दोस्तों को मारना शोभा नहीं देता है। हे माधव (कृष्ण), हम अपने ही रिश्तेदारों को मारकर खुश होने की उम्मीद कैसे कर सकते हैं?"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 38-39","यद्यप्येते न पश्यन्ति लोभोपहतचेतस: |\n" +
                "कुलक्षयकृतं दोषं मित्रद्रोहे च पातकम् || 38||\n" +
                "कथं न ज्ञेयमस्माभि: पापादस्मान्निवर्तितुम् |\n" +
                "कुलक्षयकृतं दोषं प्रपश्यद्भिर्जनार्दन || 39||","उनके विचार लालच से हावी हो जाते हैं और वे अपने रिश्तेदारों को नष्ट करने या दोस्तों पर विश्वासघात करने में कोई गलती नहीं देखते हैं। फिर भी, हे जनार्दन (कृष्ण), हम, जो अपने लोगों को मारने में अपराध को स्पष्ट रूप से देख सकते हैं, इस पाप से मुंह क्यों नहीं मोड़ें?"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 40","कुलक्षये प्रणश्यन्ति कुलधर्मा: सनातना: |\n" +
                "धर्मे नष्टे कुलं कृत्स्नमधर्मोऽभिभवत्युत || 40||","जब एक राजवंश नष्ट हो जाता है, तो उसकी परंपराएं खत्म हो जाती हैं, और बाकी परिवार अधार्मिकता में शामिल हो जाता है।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 41","अधर्माभिभवात्कृष्ण प्रदुष्यन्ति कुलस्त्रिय: |\n" +
                "स्त्रीषु दुष्टासु वार्ष्णेय जायते वर्णसङ्कर: || 41||","हे कृष्ण, विकार की प्रधानता से, परिवार की महिलाएं अनैतिक हो जाती हैं; और स्त्रियों की अनैतिकता से, हे वृष्णि के वंशज, अवांछित संतान उत्पन्न होती है।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 42","सङ्करो नरकायैव कुलघ्नानां कुलस्य च |\n" +
                "पतन्ति पितरो ह्येषां लुप्तपिण्डोदकक्रिया: || 42||","अवांछित संतानों की वृद्धि से परिवार और परिवार को नष्ट करने वालों दोनों का जीवन नारकीय बन जाता है। यज्ञ से वंचित होकर ऐसे भ्रष्ट परिवारों के पूर्वजों का भी पतन होता है।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 43","दोषैरेतै: कुलघ्नानां वर्णसङ्करकारकै: |\n" +
                "उत्साद्यन्ते जातिधर्मा: कुलधर्माश्च शाश्वता: || 43||","जो कुल-परम्परा को नष्ट करके अवांछित संतान को जन्म देते हैं, उनके कुकृत्यों से अनेक प्रकार की सामाजिक और पारिवारिक कल्याणकारी गतिविधियाँ नष्ट हो जाती हैं।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 44","उत्सन्नकुलधर्माणां मनुष्याणां जनार्दन |\n" +
                "नरकेऽनियतं वासो भवतीत्यनुशुश्रुम || 44||","हे जनार्दन (कृष्ण), मैंने विद्वानों से सुना है कि कुल की परंपराओं को नष्ट करने वाले अनिश्चित काल तक नरक में रहते हैं।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 45-46","अहो बत महत्पापं कर्तुं व्यवसिता वयम् |\n" +
                "यद्राज्यसुखलोभेन हन्तुं स्वजनमुद्यता: || 45||\n" +
                "यदि मामप्रतीकारमशस्त्रं शस्त्रपाणय: |\n" +
                "धार्तराष्ट्रा रणे हन्युस्तन्मे क्षेमतरं भवेत् || 46||","काश! यह कितनी अजीब बात है कि हमने भयानक परिणामों के साथ इस महान पाप को करने के लिए अपना मन बना लिया है। राज-सुख की लालसा से प्रेरित होकर हम अपने स्वजनों का वध करने पर आमादा हैं। यदि धृतराष्ट्र के पुत्र हाथ में शस्त्र लेकर युद्ध के मैदान में निहत्थे और निरंकुश मुझे मार दें तो अच्छा होगा।"));
        list1.add(new GeetaModel("अध्याय 1","गीता श्लोक 47","एवमुक्त्वार्जुन: सङ्ख्ये रथोपस्थ उपाविशत् |\n" +
                "विसृज्य सशरं चापं शोकसंविग्नमानस: || 47||","संजय ने कहा: इस प्रकार कहकर, अर्जुन ने अपना धनुष और बाण एक तरफ रख दिया, और अपने रथ के आसन में बैठ गया, उसका मन व्याकुल और शोक से व्याकुल हो गया।"));

    }

    private void lookSelected(Button parsedButton) {
//        parsedButton.setTextColor(red);
        parsedButton.setBackgroundResource(R.drawable.no_button_bg);

    }

    private void lookUnSelected(Button parsedButton) {
//        parsedButton.setTextColor(white);
        parsedButton.setBackgroundResource(R.drawable.mobile_number_background);

    }

    private void initButton() {
        adhyay1 = binding.adhyay1;
        adhyay2 = binding.adhyay2;
        adhyay3 = binding.adhyay3;
        adhyay4 = binding.adhyay4;
        adhyay5 = binding.adhyay5;
        adhyay6 = binding.adhyay6;
        adhyay7 = binding.adhyay7;
        adhyay8 = binding.adhyay8;
        adhyay9 = binding.adhyay9;
        adhyay10 = binding.adhyay10;
        adhyay11 = binding.adhyay11;
        adhyay12 = binding.adhyay12;
        adhyay13 = binding.adhyay13;
        adhyay14 = binding.adhyay14;
        adhyay15 = binding.adhyay15;
        adhyay16 = binding.adhyay16;
        adhyay17 = binding.adhyay17;
        adhyay18 = binding.adhyay18;

    }

    private void addDataToList18() {
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 1","सन्यासस्य, महाबाहो, तत्त्वम्, इच्छामि, वेदितुम्,\n" +
                "त्यागस्य, च, हृषीकेश, पृथक्, केशिनिषूदन।।1।।","हे महाबाहु! हे सर्वज्ञ! केशी का नाश करने वाले! मैं सन्यास (त्याग) और त्याग (त्याग) के बारे में अलग-अलग सच्चाई जानना चाहता हूँ।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 2","काम्यानाम्, कर्मणाम्, न्यासम्, सóयासम्, कवयः, विदुः,\n" +
                "सर्वकर्मफलत्यागम्, प्राहुः, त्यागम्, विचक्षणाः।।2।।","गीता ज्ञान देने वाले ने अन्य से सुना हुआ ज्ञान इस प्रकार बताया कि (कवय) कवि जन मनोकामना पूर्ण करने की इच्छा से किए भक्ति कर्मों को त्याग कहते हैं। अन्य अपने आपको विचक्षण यानि विचार कुशल मानने वाले कर्मों के फल के त्याग को त्याग कहते हैं।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 3","त्याज्यम्, दोषवत्, इति, एके, कर्म, प्राहुः, मनीषिणः,\n" +
                "यज्ञदानतपःकर्म, न, त्याज्यम्, इति, च, अपरे।।3।।","(एके) एक-आधा यानि कोई-कोई (मनीषिणः) अपने को विद्वान मानने वाले कहते हैं कि सर्व कर्म दोषयुक्त हैं। इसलिए सब त्यागने योग्य हैं और दूसरे कहते हैं कि यज्ञ, दान, तप रूप कर्म त्यागने योग्य नहीं हैं।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 4","निश्चयम्, श्रृणु, मे, तत्रा, त्यागे, भरतसत्तम,\n" +
                "त्यागः, हि, पुरुषव्याघ्र, त्रिविधः, सम्प्रकीर्तितः।।4।।"," हे शेर पुरूष अर्जुन! त्याग और सन्यास इन दोनों में से पहले त्याग के विषय में मेरा विश्वास सुन। त्याग तीन प्रकार का कहा है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 5","यज्ञदानतपःकर्म, न, त्याज्यम्, कार्यम्, एव, तत्,\n" +
                "यज्ञः, दानम्, तपः, च, एव, पावनानि, मनीषिणाम्।।5।।","जो भक्त के कर्तव्य कर्म यज्ञ यानि धार्मिक अनुष्ठान जैसे दान, तप आदि स्वधर्म पालन करने में संघर्ष में होने वाले कष्ट को तप कहा जाता है। ये कर्म त्यागने योग्य नहीं हैं। वे तो अवश्य करने के हैं क्योंकि यज्ञ दान और तप कर्म ही विद्वान भक्तों की आत्मा को पवित्र करने वाले हैं।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 6","एतानि, अपि, तु, कर्माणि, संगम्, त्यक्त्वा, फलानि, च,\n" +
                "कर्तव्यानि, इति, मे, पार्थ निश्चितम्, मतम्, उत्तमम्।।6।।","इन उपरोक्त कर्मों के फल की इच्छा व संसार में आसक्ति त्याग करके करना चाहिए। यह मेरा निश्चय किया हुआ श्रेष्ठ मत यानि विचार है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 7","नियतस्य, तु, सóयासः, कर्मणः, न, उपपद्यते,\n" +
                "मोहात्, तस्य, परित्यागः, तामसः, परिकीर्तितः।।7।।","इसलिए नियत यानि शास्त्रा अनुकूल कर्म का त्याग उचित नहीं है। जैसे इसी अध्याय 18 के श्लोक 48 में कहा है कि अग्नि में धुंवे की तरह प्रत्येक काम में कुछ दोष भी होता है। जैसे धुँवा होने के के भय से भोजन बनाने के लिए जलाने वाली अग्नि को त्यागा नहीं जाता। इसी प्रकार अनिवार्य शुभ कर्म में भले ही कुछ पाप भी होता है, वे त्यागे नहीं जा सकते। जैसे किसान खेत जोतता है। उसमें करोड़ों जीवों की एक दिन में हिंसा होती है तो भी उसे त्यागा नहीं जा सकता। किसान का उद्देश्य जीव हिंसा करना नहीं है, अपना कर्तव्य कर्म करना है। (पापों से मुक्ति की विधि है कि पूर्ण संत से दीक्षा लेकर भक्ति करने से कर्म प्रतिदिन ही समाप्त होते रहते हैं। जैसे प्रतिदिन पहनने वाले वस्त्रा मैले होते हैं, परंतु प्रतिदिन साबुन-पानी से साफ करने से मैल साथ की साथ समाप्त हो जाता है। जो गुरू बनाकर शास्त्रा विधि अनुसार भक्ति नहीं करते, उनको वे पाप लगते रहते हैं। जिस कारण से उनको वे सर्व कर्म भोगने पड़ते हैं। सतगुरू के भक्त को भोगने नहीं पड़ते। इसलिए भक्ति अनिवार्य है।) मोह यानि अज्ञानतावश भावुक होकर कर्तव्य कर्मों को त्यागना यानि सन्यास लेकर जंगल में चला जाना तामस त्याग है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 8","दुःखम्, इति, एव, यत्, कर्म, कायक्लेशभयात्, त्यजेत्,\n" +
                "सः, कृत्वा, राजसम्, त्यागम्, न, एव, त्यागफलम्, लभेत्।।8।।","जो यह कहकर सब कर्मों के त्याग का विचार करता है कि सब कर्म कष्टदायक हैं, वह राजस त्याग कहा है। उसे उस त्याग का फल कभी नहीं मिलता।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 9","कार्यम्, इति, एव, यत्, कर्म, नियतम्, क्रियते, अर्जुन,\n" +
                "संगम्, त्यक्त्वा, फलम्, च, एव, सः, त्यागः, सात्त्विकः, मतः।।9।।"," हे अर्जुन! कर्तव्य कर्म यानि शास्त्राविहित कर्म करना कर्तव्य है। इस भाव से आसक्ति और फल का त्याग करके किया जाता है, वही सात्विक त्याग माना गया है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 10","न, द्वेष्टि, अकुशलम्, कर्म, कुशले, न, अनुषज्जते,\n" +
                "त्यागी, सत्त्वसमाविष्टः, मेधावी, छिन्नसंशयः।।10।।"," हे अर्जुन! जो मनुष्य अकुशल कर्मी से द्वेष नहीं करता तथा कुशल कर्मों से प्रभावित होकर उस पर आसक्त नहीं होता। केवल अपना कर्म यानि कार्य ही सिद्ध करता है। वह सत्वगुण प्रधान व्यक्ति संशयरहित बुद्धिमान त्यागी है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 11","न, हि, देहभृता, शक्यम्, त्यक्तुम्, कर्माणि, अशेषतः,\n" +
                "यः, तु, कर्मफलत्यागी, सः, त्यागी, इति, अभिधीयते।।11।।","क्योंकि किसी भी शरीरधारी मनुष्य द्वारा सम्पूर्णता से सब कर्मों का त्याग किया जाना संभव नहीं है। जो कर्म प्रतिफल की इच्छा न करके भक्ति कर्म करता है, वह वास्तव में सन्यासी है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 12","अनिष्टम्, इष्टम्, मिश्रम्, च, त्रिविधम्, कर्मणः, फलम्,\n" +
                "भवति, अत्यागिनाम्, प्रेत्य, न, तु, सóयासिनाम्, क्वचित्।।12।।","जो प्राणी शास्त्राविधिरहित कर्म बिना उपरोक्त त्याग भाव से करते हैं, उनको (प्रेत्य) मृत्यु के बाद अच्छे-बुरे सर्व फल भोगने पड़ेंगे। जैसे पुण्यों के प्रभाव से पालतु कुत्ता बनकर अच्छी सुविधा लेगा जो उसके पुण्यों का फल होगा। बुरे कर्म के फल रूप में नरक तथा सूअर आदि-आदि जीवों के शरीर प्राप्त करेगा। किंतु जो शास्त्राविधि अनुसार साधना करते हैं। उनको यह कष्ट नहीं होगा।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 13","पञ्च, एतानि, महाबाहो, कारणानि, निबोध, मे,\n" +
                "साङ्ख्ये, कृतान्ते, प्रोक्तानि, सिद्धये, सर्वकर्मणाम्।।13।।","काल ब्रह्म ने कहा कि अब मैं (सांख्ये) वेदांत में कहे विचार यानि मत बताता हूँ। मेरे से भली-भांति सुन।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 14","अधिष्ठानम्, तथा, कर्ता, करणम्, च, पृथग्विधम्,\n" +
                "विविधाः, च, पृथक्, चेष्टाः, दैवम्, च, एव, अत्रा, प×चमम्।। 14।।","वेदांत में पाँच कारण बताए हैं:- अधिष्ठान, कर्तापन, करण यानि कर्म इन्द्रियों व ज्ञान इन्द्रियों द्वारा किए गए कर्म तथा चेष्टाऐं, ये चार तथा पाँचवां कारण दैव यानि परमात्मा की अदृश्य शक्ति से पूर्व संस्कार से होना। जैसे कहते हैं कि दैव योग से एक तैराक नदी पर उपस्थित था जिसने जल में डूबते बच्चे को बचा लिया।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 15","शरीरवाङ्मनोभिः, यत्, कर्म, प्रारभते, नरः,\n" +
                "न्याय्यम्, वा, विपरीतम्, वा, पञ्च एते, तस्य, हेतवः।। 15।।","जो व्यक्ति मन, कर्म, वाणी से अथवा न्याय या अन्याय अर्थात् अच्छे-बुरे कर्म जो कुछ भी बताता है, उसके उपरोक्त ये पाँच कारण हैं (पूर्ण संत प्राप्ति के पश्चात् केवल शुभ कर्म प्राणी करता है जैसे नौका बिना खेवट के इधर-उधर भटकती है तो उसके कई कारण होते हैं, हवा का तेज चलना, जल की लहरें, दरिया के पानी का बहाव, जल की मछलियों की उछल-कूद से उत्पन्न पानी की हलचल। जब नौका को खेवट मिल जाता है तो वह उनके वश नहीं रहती, भले ही वे गतिरोध फिर भी रहते हैं। सतगुरू शरण में आने से पहले मानव (स्त्राी-पुरूष) की जीवन रूपी नौका संसार रूपी दरिया में बिना खेवट वाली नौका की तरह होती है जो प्रारब्ध कर्मों के कारण सुख-दुःख प्राप्त करके चलती है यानि मानव पूर्व जन्म के कर्मों के भोग प्राप्त करता है। सतगुरू शरण के पश्चात् खेवट वाली नौका की तरह चलती है यानि दुःख समाप्त\n" +
                "हो जाते हैं। सुख प्राप्त रहते हैं।इस श्लोक 15 का तात्पर्य यह है।)"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 16","तत्र, एवम्, सति, कर्तारम्, आत्मानम्, केवलम्, तु, यः,\n" +
                "पश्यति, अकृतबुद्धित्वात्, न, सः, पश्यति, दुर्मतिः।।16।।"," इस श्लोक में उस जड़मति व्यक्ति के विषय में कहा है जिसे सतगुरू नहीं मिला। वह स्वयं को सर्व अच्छे-बुरे कर्मों का कर्ता मानता है, उसकी मलीन बुद्धि है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 17","यस्य, न, अहङ्कृृतः, भावः, बुद्धिः, यस्य, न, लिप्यते,\n" +
                "हत्वा, अपि, सः, इमान्, लोकान्, न, हन्ति, न, निबध्यते।।17।।","इस श्लोक में उस तत्वदर्शी संत के शिष्य का वर्णन है जो सर्व कर्म सतगुरू का आदेश मानकर करता है। उसकी स्थिति उस सैनिक जैसी होती है जो अपने राजा की ओर से दूसरे शत्रु राजा की सेना से लड़ता है। वह जो शत्रु के सैनिक मारता है, उसमें वह दोषी नहीं है। यदि स्वयं मर जाता है तो स्वर्ग में जाता है। गीता अध्याय 2 श्लोक 37 में प्रमाण है। इसलिए इस श्लोक 17 में कहा कि वह सैनिक अपनी इच्छा से किसी को नहीं मारता। अपने राजा के आदेश से युद्ध करता है। इसलिए कहा है कि वह लोगों को मारकर भी नहीं मारता। तत्वज्ञान में बताया है कि:-\n" +
                "\n" +
                "जो इच्छा कर मारे नहीं, बिन इच्छा मर जाय, कह कबीर तास का, पाप नहीं लगाऐ।।\n" +
                "\n" +
                "जैसे कर्तव्य कर्मों में प्रतिदिन पोंचा लगाने में, खाना बनाने के लिए, लकड़ी व गैस आदि से अग्नि जलाने में, कृषि करने में, मजदूरी करने में आदि-आदि दैनिक कार्यों में जो जीव मरते हैं, उसका पाप पूर्ण संत के उपदेशी कबीर परमेश्वर के भक्त को नहीं लगते। अन्य जो भक्ति नहीं करते या गुरू बनाकर शास्त्रों के विपरित साधना करते हैं या अन्य देवी-देवताओं तथा ब्रह्म तक की साधना गुरू बनाकर भी करते हैं। उनको दैनिक व उपरोक्त कार्यों के सब पाप लगते हैं। उन व्यक्तियों के पुण्यों तथा पापों को भिन्न-भिन्न लिखा जाता है। उनको दोनों प्रकार के फल स्वर्ग-नरक व अन्य प्राणियों के शरीर में भोगने पड़ते हैं, परंतु पूर्ण संत के शिष्य कबीर परमेश्वर के भक्त को वे पाप नहीं लगते। जैसे कोई व्यक्ति चालक प्रमाण पत्र (driving license) के साथ कार-गाड़ी चलाता है। यदि उससे कोई दुर्घटना हो जाती है, तो चालक प्रमाण पत्र वाले को दोषी नहीं माना जाता यदि शराब आदि नशे का सेवन न कर रखा हो तो। इसी प्रकार सतगुरू के शिष्य को कर्तव्य कर्मों के पापों का फल नहीं भोगना पड़ता।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 18","ज्ञानम्, ज्ञेयम्, परिज्ञाता, त्रिविधा, कर्मचोदना,\n" +
                "करणम्, कर्म, कर्ता, इति, त्रिविधः, कर्मसंग्रहः।।18।।"," ज्ञाता यानि ज्ञान जानने वाला अर्थात् ज्ञानी, ‘‘ज्ञान’’ जैसे गीता ज्ञान, इसको जानने वाला ज्ञानी। ज्ञेय का अर्थ है जानने योग्य। जैसे भक्त के लिए ज्ञेय (अध्यात्म ज्ञान द्वारा) परमात्मा है, यह तीन प्रकार की कर्म प्रेरणा है। कर्ता जो कार्य करता है, करण जिस कारण से कर्म किया जा रहा है तथा कर्म जो करना है। वह क्रिया भी तीन प्रकार का\n" +
                "कर्म संग्रह है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 19","ज्ञानम्, कर्म, च, कर्ता, च, त्रिधा, एव, गुणभेदतः,\n" +
                "प्रोच्यते, गुणसङ्ख्याने, यथावत्, श्रृणु, तानि, अपि।।19।।","ज्ञान और कर्म तथा कर्ता गुणों के भेद से तीन-तीन प्रकार के ही कहे गए हैं। उनको भी तू मुझसे भली-भांति सुन।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 20","सर्वभूतेषु, येन, एकम्, भावम्, अव्ययम्, ईक्षते,\n" +
                "अविभक्तम्, विभक्तेषु, तत्, ज्ञानम्, विद्धि, सात्त्विकम्।।20।।"," जिस ज्ञान से ज्ञानी पृथक-पृथक सब प्राणियों में एक अविनाशी परमात्मा के भाव को विभाग रहित देखता है यानि सर्व प्राणियों में परमात्मा की सत्ता देखता है। उस ज्ञान को तू सात्विक यानि सच्चा ज्ञान समझ।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 21","पृथक्त्वेन, तु, यत्, ज्ञानम्, नानाभावान्, पृथग्विधान्,\n" +
                "वेत्ति, सर्वेषु, भूतेषु, तत्, ज्ञानम्, विद्धि, राजसम्।।21।।","जो सर्व प्राणियों में परमात्म भाव को भिन्न-भिन्न यानि जीव को कर्ता देखता है, वह राजस ज्ञान जान।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 22","यत्, तु, कृत्स्न्नवत्, एकस्मिन्, कार्ये, सक्तम्, अहैतुकम्,\n" +
                "अतत्त्वार्थवत्, अल्पम्, च, तत्, तामसम्, उदाहृतम्।।22।।","परन्तु वह ज्ञान जो केवल एक क्रियात्मक शरीर में ही समाया हुआ है जैसे कि वह सब कुछ है और जो बिना किसी समझ और कारण के तर्कहीन है और तुच्छ है - वह तामस कहा जाता है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 23","नियतम्, संगरहितम्, अरागद्वेषतः, कृतम्,\n" +
                "अफलप्रेप्सुना, कर्म, यत्, तत्, सात्त्विकम्, उच्यते।।23।।","जो कर्म शास्त्रानुकूल, कर्त्तापन के अभिमान से रहित तथा फल की इच्छा न रखने वाले के द्वारा बिना राग-द्वेष के किया जाता है, वह सात्विक कहलाता है।\n" +
                "jo karm shaastraanuk"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 24","\n" +
                "यत्, तु, कामेप्सुना, कर्म, साहंकारेण, वा, पुनः,\n" +
                "क्रियते, बहुलायासम्, तत्, राजसम्, उदाहृतम्।।24।।","परन्तु जिस कर्म में बहुत परिश्रम करना पड़ता है और फल की इच्छा रखने वाले या अभिमानी व्यक्ति द्वारा किया जाता है, वह कर्म राजस कहा जाता है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 25","अनुबन्धम्, क्षयम्, हिंसाम् अनवेक्ष्य, च, पौरुषम्,\n" +
                "मोहात्, आरभ्यते, कर्म, यत्, तत्, तामसम्, उच्यते।।25।।","\n" +
                "जो कर्म फल, हानि, हिंसा और सामर्थ्य का विचार किए बिना अज्ञानता से ही प्रारंभ किया जाता है, वह कर्म तामस कहलाता है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 26","मुक्तसंगः, अनहंवादी, धृत्युत्साहसमन्वितः,\n" +
                "सिद्धयसिद्धयोः, निर्विकारः, कर्ता, सात्त्विकः, उच्यते।।26।।","कर्म करने वाला, आसक्ति से रहित, अभिमान नहीं करने वाला, धैर्य और उत्साह से युक्त तथा कर्म की सफलता और असफलता में दोषों से रहित, सात्विक कहा जाता है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 27","रागी, कर्मफलप्रेप्सुः, लुब्धः, हिंसात्मकः, अशुचिः,\n" +
                "हर्षशोकान्वितः, कर्ता, राजसः, परिकीर्तितः।।27।।","कर्म करने वाला, आसक्ति से युक्त, कर्मों के फल की इच्छा रखने वाला, लोभी और दूसरों को नुकसान पहुँचाने का स्वभाव रखने वाला, भ्रष्ट और सुख-दुःख से युक्त, राजस कहा जाता है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 28","अयुक्तः, प्राकृृतः, स्तब्धः, शठः, नैष्कृतिकः, अलसः,\n" +
                "विषादी, दीर्घसूत्राी, च, कर्ता, तामसः, उच्यते।।28।।","कर्म करने वाला, अस्थिर, मनमौजी, अभिमानी, छली, दूसरों की आजीविका को नष्ट करने वाला, शोक करने वाला, आलसी और टालमटोल करने वाला तामस कहा जाता है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 29","बुद्धेः, भेदम्, धृतेः, च, एव, गुणतः, त्रिविधम्, श्रृणु,\n" +
                "प्रोच्यमानम्, अशेषेण, पृथक्त्वेन, धनञ्जय।। 29।।","हे धनंजय! अब तुम मेरे द्वारा पूर्णत: और अलग-अलग वर्णित गुणों के अनुसार बुद्धि और दृढता के तीन प्रकार के भेदों को सुनो"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 30","प्रवृत्तिम्, च, निवृत्तिम्, च, कार्याकार्ये, भयाभये,\n" +
                "बन्धम्, मोक्षम्, च, या, वेति, बुद्धिः, सा, पार्थ, सात्त्विकी।।30।।","ओह पार्थ! जो बुद्धि स्पष्ट रूप से जानती है कि क्या करना है और क्या नहीं करना है, क्या करना चाहिए और क्या नहीं करना चाहिए, भय और अभय, बंधन और मुक्ति, वह बुद्धि सात्विक है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 31","\n" +
                "यया, धर्मम्, अधर्मम्, च, कार्यम्, च, अकार्यम्, एव, च,\n" +
                "अयथावत्, प्रजानाति, बुद्धिः, सा, पार्थ, राजसी।।31।।","ओह पार्थ! जिस बुद्धि से धर्म और अधर्म का पूर्ण ज्ञान नहीं होता और क्या करना चाहिए और क्या नहीं करना चाहिए - वह बुद्धि राजसी है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 32","अधर्मम्, धर्मम्, इति, या, मन्यते, तमसा, आवृता,\n" +
                "सर्वार्थान्, विपरीतान्, च, बुद्धिः, सा, पार्थ, तामसी।।32।।","हे अर्जुन! जो बुद्धि तमोगुण में लिपटी हुई है, जो अधर्म को भी 'यही धर्म है' ही समझती है और इसी प्रकार अन्य सब बातों को भी विपरीत मानती है - वह बुद्धि तामसी है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 33","धृृत्या, यया, धारयते, मनःप्राणेन्द्रियक्रियाः,\n" +
                "योगेन, अव्यभिचारिण्या, धृतिः, सा, पार्थ, सात्त्विकी।।33।।","ओह पार्थ! एक ईश्वर में जिस अटल दृढ़ता से व्यक्ति मन, श्वास और इंद्रियों की गतिविधियों को भक्ति-योग के माध्यम से ग्रहण करता है - वह सात्विक दृढ़ता है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 34","यया, तु, धर्मकामार्थान्, धृत्या, धारयते, अर्जुन,\n" +
                "प्रसंगेन, फलाकाङ्क्षी, धृृतिः, सा, पार्थ, राजसी।।34।।","लेकिन पृथा अर्जुन के पुत्र! जिस दृढ़ता से फल की इच्छा रखने वाला मनुष्य प्रबल आसक्ति से धर्म, धन और सुखों को ग्रहण करता है - वह दृढ़ता ही राजसी है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 35","यया, स्वप्नम्, भयम्, शोकम्, विषादम्, मदम् एव, च,\n" +
                "न, विमुञ्चति, दुर्मेधाः, धृति:, सा, पार्थ, तामसी।।35।।","ओह पार्थ! नींद, भय, चिंता और दुख तथा नशा भी जिसे नीच प्रकृति का व्यक्ति नहीं छोड़ता - वह भक्ति की दृढ़ता तामसी है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 36-37","सुखम्, तु, इदानीम्, त्रिविधम्, श्रृणु, मे, भरतर्षभ,\n" +
                "अभ्यासात्, रमते, यत्रा, दुःखान्तम्, च, निगच्छति।।36।।\n" +
                "\n" +
                "यत्, तत्, अग्रे, विषम्, इव, परिणामे, अमृतोपमम्,\n" +
                "तत्, सुखम्, सात्त्विकम्, प्रोक्तम्, आत्मबुद्धिप्रसादजम्।।37।।","हे भरतश्रेष्ठ! अब तुम भी मेरे मुख से तीन प्रकार के सुखों को सुनो। जिस भजन की साधना में लीन रहते हैं और जिसके द्वारा दुखों का अंत हो जाता है, जो ऐसा सुख है जो शुरू में भले ही विष जैसा लगता हो, लेकिन अंत में अमृत समान होता है, वह सुख उसी से उत्पन्न होता है। ईश्वर के संबंध में मन की स्पष्टता सात्विक कही गई है।"));

        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 38","विषयेन्द्रियसंयोगात्, यत्, तत्, अगे्र, अमृतोपमम्,\n" +
                "परिणामे, विषम्, इव, तत्, सुखम्, राजसम्, स्मृतम्।।38।।","जो सुख इन्द्रियों और इन्द्रियविषयों के मिलन से उत्पन्न होता है, यद्यपि अनुभव के समय पहले तो अमृत जैसा लगता है, अंत में विष के समान है - वह सुख राजस कहा जाता है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 39","यत्, अग्रे, च, अनुबन्धे, च, सुखम् मोहनम्, आत्मनः,\n" +
                "निद्रालस्यप्रमादोत्थम्, तत्, तामसम्, उदाहृतम्।।39।।","अनुभव के समय जो पहले आत्मा को मोहित करता है और अंत में जो सुख नींद, आलस्य और अधर्म से उत्पन्न होता है, वह तामस कहा जाता है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 40","न, तत्, अस्ति, पृथिव्याम्, वा, दिवि, देवेषु, वा, पुनः,\n" +
                "सत्त्वम्, प्रकृतिजैः, मुक्तम्, यत्, एभिः, स्यात्, त्रिभिः, गुणैः।।40।।","पृथ्वी पर या आकाश में या देवताओं में, या कहीं भी ऐसा कोई जीव नहीं है, जो प्रकृति से उत्पन्न इन तीन गुणों से मुक्त हो।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 41","\n" +
                "ब्राह्मणक्षत्रियविशाम्, शूद्राणाम्, च, परन्तप,\n" +
                "कर्माणि, प्रविभक्तानि, स्वभावप्रभवैः, गुणैः।।41।।","हे परंतप! ब्राह्मणों, क्षत्रियों, वैश्यों और शूद्रों के कर्मों को उनके स्वभाव से उत्पन्न गुणों के अनुसार विभाजित किया गया है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 42","शमः, दमः, तपः, शौचम्, क्षान्तिः, आर्जवम्, एव, च,\n" +
                "ज्ञानम्, विज्ञानम्, आस्तिक्यम्, ब्रह्मकर्म, स्वभावजम्।।42।।","अस्पृश्यता से मुक्त और सुख-दुःख को ईश्वर की कृपा मानकर इन्द्रियों का दमन करना, धार्मिक नियमों के पालन के लिए कष्ट सहना, आन्तरिक और बाह्य रूप से शुद्ध रहना अर्थात् छल-कपट से मुक्त होना, दूसरों के अपराध को क्षमा करना, मन, इन्द्रियों को रखना और शरीर सरल, शास्त्रानुकूल भक्ति करके परमेश्वर और उनके सतलोक में समर्पित रहने के लिए, भगवान की भक्ति बहुत महत्वपूर्ण है, अन्यथा, मानव जीवन बेकार है - इस प्रकार का सरल ज्ञान और पूर्ण परमात्मा कौन है, वह कैसा है उसे प्राप्त करने की विधि क्या है, इस प्रकार का ज्ञान और परमात्मा के तत्वज्ञान को जानना और अन्य तीन वर्णों (जातियों) को शास्त्रानुकूल साधना समझाना ही ब्रह्म के संबंध में अपने कर्तव्य को जानकर ब्राह्मण के कर्म हैं, जो प्रकृति से पैदा होते हैं क्योंकि ये भगवान की प्राप्ति के संबंध में एक भक्त के स्वाभाविक कर्म हैं।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 43","शौर्यम्, तेजः, धृतिः, दाक्ष्यम्, युद्धे, च, अपि, अपलायनम्,\n" +
                "दानम्, ईश्वरभावः, च, क्षात्राम्, कर्म, स्वभावजम्।।43।।","पराक्रम, तेज, दृढ़ता, चतुराई और युद्ध से न भागना, दान देना और पूर्ण परमात्मा में प्रभु के रूप में रुचि, ये सब क्षत्रिय के स्वाभाविक कर्म हैं।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 44","कृृषिगौरक्ष्यवाणिज्यम्, वैश्यकर्म, स्वभावजम्,\n" +
                "परिचर्यात्मकम्, कर्म, शूद्रस्य, अपि, स्वभावजम्।।44।।","\n" +
                "खेती के लिए गायों की रक्षा और स्वयं को पालने के लिए ईश्वर प्राप्ति का व्यापार करना, ये वैश्य के स्वाभाविक कर्म हैं और सभी वर्णों (जातियों) की सेवा करना और परमेश्वर की भक्ति करना भी शूद्र के स्वाभाविक कर्म हैं।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 45","स्वे, स्वे, कर्मणि, अभिरतः, संसिद्धिम्, लभते, नरः,\n" +
                "स्वकर्मनिरतः, सिद्धिम्, यथा, विन्दति, तत्, श्रृृणु।।45।।","अपने स्वाभाविक व्यावहारिक कार्यों और सच्ची भक्ति के कार्यों में लगन से लगा हुआ मनुष्य सर्वोच्च आध्यात्मिक सफलता प्राप्त करता है। जिस प्रकार अपने स्वाभाविक कर्म में लगा हुआ मनुष्य परम आध्यात्मिक सिद्धि को प्राप्त करता है, वह विधि मुझसे सुनो।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 46","यतः, प्रवृत्तिः, भूतानाम्, येन्, सर्वम्, इदम्, ततम्,\n" +
                "स्वकर्मणा, तम्, अभ्यच्र्य, सिद्धिं, विन्दति, मानवः।।46।।","जिस ईश्वर से समस्त जीवों की उत्पत्ति हुई है और जिससे यह सारा संसार व्याप्त है, उस ईश्वर की अपने स्वाभाविक कर्मों के द्वारा अर्थात् हठयोग के अभ्यास के स्थान पर सांसारिक कार्यों को करते हुए उपासना करने से मनुष्य आध्यात्मिक सिद्धि प्राप्त करता है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 47","श्रेयान्, स्वधर्मः, विगुणः, परधर्मात्, स्वनुष्ठितात्,\n" +
                "स्वभावनियतम्, कर्म, कुर्वन्, न, आप्नोति, किल्बिषम्।।47।।","अपना धर्म अर्थात् शास्त्राविधि के अनुसार आचरण करना दूसरे के धर्म अर्थात् गुणों से रहित और मनमाने ढंग से किया जाने वाला धर्म अर्थात् शास्त्रविधि के विपरीत विधिपूर्वक किया जाने वाला धर्म है। जिस वर्ण/जाति अर्थात् क्षत्रिय, वैश्य, ब्राह्मण तथा शूद्र किसी भी वर्ण में उत्पन्न हुआ हो, उसके स्वाभाविक कर्म व भक्ति के कर्म करते हुए पाप नहीं लगता।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 48","सहजम्, कर्म, कौन्तेय, सदोषम्, अपि, न, त्यजेत्,\n" +
                "सर्वारम्भाः, हि, दोषेण, धूमेन, अग्निः, इव, आवृताः।।48।।","हे कुंतीपुत्र! दोषयुक्त होने के कारण भी सहज योग अर्थात् वर्णों के अनुसार कर्म करते हुए शास्त्रानुकूल भक्ति का त्याग नहीं करना चाहिए क्योंकि धुएँ से अग्नि की तरह सभी कर्मों में दोष होते हैं।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 49","असक्तबुद्धिः, सर्वत्र, जितात्मा, विगतस्पृहः,\n" +
                "नैष्कम्र्यसिद्धिम्, परमाम्, सन्न्यासेन, अधिगच्छति।।49।।","सब ओर से मुक्त बुद्धि वाला, कामनाओं से मुक्त, गलत कर्मों पर विजय प्राप्त करने वाला, तत्वज्ञान के अतिरिक्त सभी ज्ञानों का त्याग करने वाला भक्त आत्मा उस श्रेष्ठतम आध्यात्मिक सिद्धि अर्थात् परम पद को प्राप्त करता है जो सर्व के पूर्ण विनाश पर प्राप्त होने वाला पूर्ण मोक्ष है। पापों।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 50","सिद्धिम्, प्राप्तः, यथा, ब्रह्म, तथा, आप्नोति, निबोध, मे,\n" +
                "समासेन, एव, कौन्तेय, निष्ठा, ज्ञानस्य, या, परा।।50।।","वह जो ज्ञान की परम सिद्धि है, वह नैष्कर्म्यसिद्धि जिसे पाकर ईश्वर प्राप्त होता है, हे कुन्तीपुत्र! वह मुझ से संक्षेप में ही समझ लो।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 51","बुद्धया, विशुद्धया, युक्तः, धृृत्या, आत्मानम्, नियम्य, च,\n" +
                "शब्दादीन्, विषयान्, त्यक्त्वा, रागद्वेषौ, व्युदस्य, च।।51।।","बुद्धि की पवित्रता से संपन्न और सात्विक दृढ़ता से आत्मसंयम और ध्वनि आदि दोषों को त्याग कर, प्रेम-द्वेष को पूरी तरह से नष्ट कर देता है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 52","विविक्तसेवी, लघ्वाशी, यतवाक्कायमानसः,\n" +
                "ध्यानयोगपरः, नित्यम्, वैराग्यम्, समुपाश्रितः।।52।।","जो संयम से खाता-पीता है, व्यर्थ की बातों से दूर रहता है, जो एकांत प्रिय है, जो मन, वाणी और शरीर को संयमित करता है, जो निरन्तर सरल ध्यान के योग में लगा रहता है, जो त्याग का आश्रय लेता है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 53","अहंकारम्, बलम्, दर्पम्, कामम्, क्रोधम्, परिग्रहम्,\n" +
                "विमुच्य निर्ममः, शान्तः, ब्रह्मभूयाय, कल्पते।।53।।","अहंकार, बल, अहंकार, काम, क्रोध और आवश्यकता से अधिक संग्रह को त्याग कर ममतारहित साधक पूर्ण परमात्मा को प्राप्त करने का अधिकारी है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 54","ब्रह्मभूतः, प्रसन्नात्मा, न, शोचति, न, काङ्क्षति,\n" +
                "समः, सर्वेषु, भूतेषु, मद्भक्तिम्, लभते, पराम्।।54।।","जो भगवान को प्राप्त करने के योग्य हो गया है, एक प्रसन्न मन वाला योगी, न शोक करता है और न ही इच्छा करता है। समस्त प्राणियों के प्रति समचित्त होकर वह मेरी प्रकार की शास्त्रानुकूल परम भक्ति को प्राप्त करता है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 55","भक्त्या, माम्, अभिजानाति, यावान्, यः, च, अस्मि, तत्त्वतः,\n" +
                "ततः, माम्, तत्त्वतः, ज्ञात्वा, विशते, तदनन्तरम्।।55।।","वह भक्त मेरे बारे में जान लेता है कि मैं कौन हूँ और क्या हूँ, जैसा कि सार रूप में है और उस भक्ति द्वारा मुझे तत्व से जानकर शीघ्र ही पूर्ण परमात्मा की भक्ति में लीन हो जाता है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 56","सर्वकर्माणि, अपि, सदा, कुर्वाणः, मद्व्यपाश्रयः,\n" +
                "मत्प्रसादात्, अवाप्नोति, शाश्वतम्, पदम्, अव्ययम्।।56।।","मतावलंबी अर्थात् जो मेरे बताये हुए शास्त्रानुकूल मार्ग पर आश्रित रहकर भी सब कर्म करता हुआ मेरे उस मत (मत) की कृपा से अर्थात् शास्त्रानुकूल साधना के पूर्ण ज्ञान की कृपा से सनातन को प्राप्त होता है, अविनाशी अवस्था।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 57","चेतसा, सर्वकर्माणि, मयि, सन्न्यस्य, मत्परः,\n" +
                "बुद्धियोगम्, उपाश्रित्य, मच्चित्तः, सततम्, भव।।57।।","मन से सब कर्मों को त्यागकर ज्ञान योग का आश्रय लेकर मेरे मत के आधार पर निरन्तर मुझमें चित्त को एकाग्र करो।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 58","मच्चित्तः, सर्वदुर्गाणि, मत्प्रसादात्, तरिष्यसि,\n" +
                "अथ, चेत्, त्वम्, अहंकारात्, न, श्रोष्यसि, विनङ्क्ष्यसि।।58।।","मुझमें मन एकाग्र करके मेरे द्वारा बताये हुए शास्त्रानुकूल दृष्टिकोण की कृपा से तुम सब बाधाओं को सहज ही पार कर जाओगे और यदि अहंकारवश मेरे वचनों को नहीं सुनोगे तो नष्ट हो जाओगे अर्थात् बन जाओगे। योग (भक्ति) से भटक गया, तो नष्ट हो जाएगा। यह प्रमाण अध्याय 6 के श्लोक 40-46 में भी है।\n"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 59","यत्, अहंकारम्, आश्रित्य, न, योत्स्ये, इति, मन्यसे,\n" +
                "मिथ्या, एषः, व्यवसायः, ते, प्रकृतिः, त्वाम्, नियोक्ष्यति।।59।।","यदि अहंकारवश आप यह सोच रहे हैं कि 'मैं युद्ध नहीं करूँगा' तो आपका यह संकल्प असत्य है क्योंकि आपका क्षत्रिय स्वभाव ही आपको युद्ध करने के लिए विवश करेगा।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 60","स्वभावजेन, कौन्तेय, निबद्धः, स्वेन्, कर्मणा,\n" +
                "कर्तुम्, न, इच्छसि, यत्, मोहात्, करिष्यसि, अवशः, अपि, तत्।।60।।","हे कुंतीपुत्र! जो कर्म तुम मोहवश नहीं करना चाहते, वह भी तुम अपने पूर्वकृत स्वाभाविक क्षत्रिय कर्मों के वशीभूत होकर करोगे जिससे तुम बंधे हुए हो।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 61","ईश्वरः, सर्वभूतानाम्, हृद्देशे, अर्जुन, तिष्ठति,\n" +
                "भ्रामयन्, सर्वभूतानि, यन्त्रारूढानि, मायया।।61।।","हे अर्जुन! शरीर रूपी यन्त्र पर आरूढ़ होकर समस्त प्राणियों को अपनी माया से उनके कर्मों के अनुसार घुमाता हुआ सर्वज्ञ ईश्वर समस्त प्राणियों के हृदय में स्थित है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 62","तम्, एव, शरणम्, गच्छ, सर्वभावेन, भारत,\n" +
                "तत्प्रसादात्, पराम्, शान्तिम्, स्थानम्, प्राप्स्यसि, शाश्वतम्।।62।।","हे भरत! तुम सब प्रकार से उस परमेश्वर की ही शरण में जाओ। उस परमेश्वर की कृपा से ही तुम परमशान्ति तथा सदा रहने वाले स्थान (धाम/लोक) अर्थात् सतलोक को प्राप्त करोगे।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 63","इति, ते, ज्ञानम्, आख्यातम्, गुह्यात्, गुह्यतरम्, मया,\n" +
                "विमृश्य, एतत्, अशेषेण, यथा, इच्छसि, तथा, कुरु।।63।।","इस प्रकार, मैंने आपके लिए गोपनीय ज्ञान का अत्यंत गोपनीय खुलासा किया है। इस रहस्यमय ज्ञान पर पूरी तरह से विचार करते हुए, जैसा आप चाहते हैं वैसा ही करें।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 64","सर्वगुह्यतमम्, भूयः, श्रृणु, मे, परमम्, वचः,\n" +
                "इष्टः, असि, मे, दृढम्, इति, ततः, वक्ष्यामि, ते, हितम्।।64।।","मैं फिर से सब रहस्यो से परम गुह्यतम परम गुह्य उपकारी वचन कहूँगा, इन्हें सुनिये - यह पूर्ण ब्रह्म ही मेरा निश्चित पूज्य देव अर्थात् पूज्य देव है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 65","मन्मनाः, भव, मद्भक्तः, मद्याजी, माम्, नमस्कुरु,\n" +
                "माम्, एव, एष्यसि, सत्यम्, ते, प्रतिजाने, प्रियः, असि, मे।।65।।","मत के आधार पर एक मन होकर मेरे भक्त बनो। मतानुसार मेरी पूजा करके मुझे प्रणाम करो। तुम मुझे ही प्राप्त करोगे। मैं तुमसे सच में वादा करता हूँ; तुम मेरे लिए बहुत प्रिय हो।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 66","सर्वधर्मान्, परित्यज्य, माम्, एकम्, शरणम्, व्रज,\n" +
                "अहम्, त्वा, सर्वपापेभ्यः, मोक्षयिष्यामि, मा, शुचः।।66।।","\n" +
                "तुम मुझमें अपनी समस्त साधनाओं को त्याग कर उस एक अद्वितीय अर्थात् पूर्ण परमात्मा की ही शरण में जाओ। मैं तुझे सारे पापों से मुक्त कर दूंगा। तुम शोक मत करो।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 67","इदम्, ते, न, अतपस्काय, न, अभक्ताय, कदाचन,\n" +
                "न, च, अशुश्रुषवे, वाच्यम्, न, च, माम्, यः, अभ्यसूयति।।67।।","किसी भी समय, आपको गीता के इस रहस्यमय उपदेश को न तो तप से रहित, न भक्ति से रहित, न ही सुनने को तैयार रहने वाले और न ही मुझमें दोष देखने वाले से कहना चाहिए।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 68","यः, इमम्, परमम्, गुह्यम्, मद्भक्तेषु, अभिधास्यति,\n" +
                "भक्तिम्, मयि, पराम्, कृृत्वा, माम्, एव, एष्यति, असंशयः।।68।।","जो मनुष्य मेरी परम भक्ति से भक्तों को इस परम रहस्यमय गीता शास्त्र का उपदेश करेगा, वह मुझ ही को प्राप्त होगा। इसमें तो कोई शक ही नहीं है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 69","न, च, तस्मात्, मनुष्येषु, कश्चित्, मे, प्रियकृत्तमः,\n" +
                "भविता, न, च, मे, तस्मात्, अन्यः, प्रियतरः, भुवि।।69।।","There is no one among men, who does a dearer service to me than he and nor will there be anyone else on the entire Earth dearer to me than he."));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 70","अध्येष्यते, च, यः, इमम्, धम्र्यम्, संवादम्, आवयोः,\n" +
                "ज्ञानयज्ञेन, तेन, अहम्, इष्टः, स्याम्, इति, मे, मतिः।।70।।","जो मनुष्य हमारा गीता शास्त्र का यह धार्मिक संवाद पढ़ेगा, उसके लिए भी मैं ज्ञान यज्ञ द्वारा पूज्य देवता हो जाऊँगा। ये मेरा विचार हे।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 71","श्रद्धावान्, अनसूयः, च, श्रृणुयात्, अपि, यः, नरः,\n" +
                "सः, अपि, मुक्तः, शुभान्, लोकान्, प्राप्नुयात्, पुण्यकर्मणाम्।।71।।","जो मनुष्य इस गीता ग्रन्थ को भक्तिपूर्वक तथा दोष-निवारक होकर सुनेगा, वह भी मुक्त होकर पुण्य कर्म करने वालों के श्रेष्ठ लोकों को प्राप्त होगा।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 72","कच्चित्, एतत्, श्रुतम्, पार्थ, त्वया, एकाग्रेण, चेतसा,\n" +
                "कच्चित्, अज्ञानसम्मोहः, प्रनष्टः, ते, धनञ्जय।। 72।।","ओह पार्थ! क्या आपने इस गीता शास्त्र को ध्यानपूर्वक सुना, और हे धनंजय! क्या अज्ञान से उत्पन्न तुम्हारा मोह नष्ट हो गया है"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 73","नष्टः, मोहः, स्मृतिः, लब्धा, त्वत्प्रसादात्, मया, अच्युत,\n" +
                "स्थितः, अस्मि, गतसन्देहः, करिष्ये, वचनम्, तव।।73।।","अरे अच्युत! आपकी कृपा से मेरा मोह नष्ट हो गया है और मुझे ज्ञान प्राप्त हो गया है। मैं शंकारहित स्थित हूँ, अत: मैं आपकी आज्ञा का पालन करूँगा।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 74","इति, अहम्, वासुदेवस्य, पार्थस्य, च, महात्मनः,\n" +
                "संवादम्, इमम्, अश्रौषम्, अद्भुतम्, रोमहर्षणम्।।74।।","इस प्रकार मैंने श्री वासुदेव और महात्मा अर्जुन का यह अद्भुत गूढ़, रोमांचकारी संवाद सुना।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 75","व्यासप्रसादात्, श्रुतवान्, एतत्, गुह्यम्, अहम्, परम्\n" +
                "योगम्, योगेश्वरात्, कृष्णात्, साक्षात्, कथयतः, स्वयम्।।75।।","मैंने श्री व्यास जी की कृपा से दिव्य दृष्टि प्राप्त करके यह परम गुह्ययोग योगेश्वर भगवान श्री कृष्ण द्वारा स्वयं अर्जुन से कहा हुआ प्रत्यक्ष सुना है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 76","राजन्, संस्मृृत्य, संस्मृत्य, संवादम्, इमम्, अद्भुतम्,\n" +
                "केशवार्जुनयोः, पुण्यम्, हृष्यामि, च, मुहुर्मुहुः।।76।।","हे राजा! भगवान श्री कृष्ण और अर्जुन के इस रहस्यमय, शुभ और अद्भुत संवाद को बार-बार याद करके मैं बार-बार आनंदित हो रहा हूँ।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 77","तत्, च, संस्मृृत्य, संस्मृृत्य, रूपम्, अति, अद्भुतम्, हरेः,\n" +
                "विस्मयः, मे, महान्, राजन्, हृष्यामि, च, पुनः, पुनः।।77।।","हे राजा! साथ ही श्री हरि के उस अनुपम रूप का बार-बार स्मरण करके मेरा मन बड़ा विस्मय से भर जाता है और बार-बार आनंदित होता है।"));
        list18.add(new GeetaModel("अध्याय 18","गीता श्लोक 78","त्र, योगेश्वरः, कृष्णः, यत्र, पार्थः, धनुर्धरः,\n" +
                "तत्रा श्रीः, विजयः, भूतिः, ध्रुवा, नीतिः, मतिः, मम।।78।।","जहाँ योगेश्वर भगवान श्री कृष्ण हैं और जहाँ धनुष गाण्डीव अर्जुन है, वहाँ केवल ऐश्वर्य, विजय, कीर्ति और दृढ़ नीति है। ये मेरा विचार हे।"));

    }

    private void addDataToList17() {
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 1","ये, शास्त्राविधिम्, उत्सृृज्य, यजन्ते, श्रद्धया, अन्विताः,\n" +
                "तेषाम्, निष्ठा, तु, का, कृष्ण, सत्त्वम्, आहो, रजः, तमः।।1।।","हे कृष्ण! जो शास्त्रविधि को त्यागकर श्रद्धापूर्वक देवताओं आदि की पूजा करते हैं, उनकी स्थिति सात्विक, राजसी या तामसी क्या होती है?"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 2","त्रिविधा, भवति, श्रद्धा, देहिनाम्, सा, स्वभावजा,\n" +
                "सात्त्विकी, राजसी, च, एव, तामसी, च, इति, ताम्, श्रृृणु।।2।।","मनुष्यों की वह श्रद्धा उनके स्वभाव से उत्पन्न तीन प्रकार की ही होती है- सात्विकी और राजसी और तामसी। अज्ञान रूपी अंधकार के उस फंदे के बारे में सुनिए।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 3","सत्त्वानुरूपा, सर्वस्य, श्रद्धा, भवति, भारत्,\n" +
                "श्रद्धामयः, अयम्, पुरुषः, यः, यच्छ्रद्धः, सः, एव, सः।।3।।","हे भरत! सबकी श्रद्धा अपने अंतर्मन के अनुरूप होती है। यह व्यक्ति विश्वास से भरा हुआ है, इसलिए जिसकी जैसी आस्था होती है, वह स्वयं वास्तव में वही होता है।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 4","यजन्ते, सात्त्विकाः, देवान्, यक्षरक्षांसि, राजसाः,\n" +
                "प्रेतान्, भूतगणान्, च, अन्ये, यजन्ते, तामसाः, जनाः।।4।।","सात्विक पुरुष श्री ब्रह्मा जी, श्री विष्णु जी और श्री शिव जी आदि देवताओं की पूजा करते हैं। राजस पुरुष यक्षों और राक्षसों की पूजा करते हैं और अन्य जो तामस पुरुष हैं वे भूतों और भूतों की पूजा करते हैं और मुख्य रूप से श्री शिव जी को भी अपना देवता मानते हैं।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 5","अशास्त्रविहितम्, घोरम्, तप्यन्ते, ये, तपः, जनाः,\n" +
                "दम्भाहंकारसंयुक्ताः, कामरागबलान्विताः।।5।।","वे पुरुष जो केवल मनमाना कठोर तप करते हैं जो शास्त्रों द्वारा आदेशित नहीं है और पाखंड और अहंकार से सुसज्जित हैं और भक्ति की शक्ति के अभिमान और इच्छा के प्रति आसक्ति रखते हैं।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 6","कर्शयन्तः, शरीरस्थम्, भूतग्रामम्, अचेतसः, माम्,\n" +
                "च, एव, अन्तःशरीरस्थम्, तान्, विद्धि, आसुरनिश्चयान्।।6।।","शरीर में रहने वाले प्राणियों के प्रमुखों ब्रह्मा, विष्णु, शिव, गणेश, प्रकृति और मुझको और शरीर के हृदय कमल में जीव के साथ रहने वाले पूर्ण परमात्मा को कष्ट देने वाले अज्ञानी उन्हें राक्षसी जानते हैं। केवल प्रकृति"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 7","आहारः, तु, अपि, सर्वस्य, त्रिविधः, भवति, प्रियः,\n" +
                "यज्ञः, तपः, तथा, दानम्, तेषाम्, भेदम्, इमम्, श्रृणु।।7।।","भोजन भी तीन प्रकार का होता है, जो सभी को उनके स्वभाव के अनुसार प्रिय होता है। अतः इसी प्रकार यज्ञ, तप और दान भी तीन-तीन प्रकार के हैं। उनका यह भेद मुझसे सुनो।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 8","आयुः सत्त्वबलारोग्यसुखप्रीतिविवर्धनाः, रस्याः,\n" +
                "स्निग्धाः, स्थिराः, हृद्याः, आहाराः, सात्त्विकप्रियाः।।8।।","आयु, बुद्धि, बल, आरोग्य, सुख और प्रेम को बढ़ाने वाले, रसयुक्त, तैलीय और चिरस्थाई तथा स्वभाव से ही मन को प्रिय भोजन अर्थात् खाद्य पदार्थ सतोगुण प्रधान अर्थात् विष्णु के उपासकों को प्रिय होते हैं। पूजनीय देवता विष्णु हैं।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 9","कट्वम्ललवणात्युष्णतीक्ष्णरूक्षविदाहिनः,\n" +
                "आहाराः, राजसस्य, इष्टाः, दुःखशोकामयप्रदाः।।9।।","कटु, खट्टे, नमकीन, अधिक गर्म, चटपटे, रूखे, दाहकारक तथा दु:ख, चिन्ता तथा व्याधि को उत्पन्न करने वाले भोजन रजोगुण प्रधान अर्थात् जिनके पूज्य देवता ब्रह्मा हैं, रजस मनुष्यों को प्रिय होते हैं; क्योंकि हृणकशिपु ने ब्रह्मा की पूजा की थी।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 10","यातयामम्, गतरसम्, पूति, पर्युषितम्, च, यत्,\n" +
                "उच्छिष्टम्, अपि, च अमेध्यम्, भोजनम्, तामसप्रियम्।।10।।","अधपका, स्वादहीन, दुर्गंधयुक्त, बासी और बचा हुआ तथा अशुद्ध भोजन तामस पुरुष को प्रिय होता है। तमोगुण प्रधान लोगों के पूज्य देवता शिव हैं और वे निम्न स्तर के भूतों और आत्माओं की पूजा करते हैं। उन्हें उपर्युक्त भोजन पसंद है।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 11","अफलाकाङ्क्षिभिः, यज्ञः, विधिदृष्टः, यः, इज्यते,\n" +
                "यष्टव्यम्, एव, इति, मनः, समाधाय, सः, सात्त्विकः।।11।।","शास्त्राविधि से निर्देशित यज्ञ करना ही कर्तव्य है - ऐसे मन के संकल्प से जो यज्ञ फल की इच्छा न रखने वाले करते हैं, वह सात्विक होता है।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 12","अभिसन्धाय, तु, फलम्, दम्भार्थम्, अपि, च, एव, यत्,\n" +
                "इज्यते, भरतश्रेष्ठ, तम्, यज्ञम्, विद्धि, राजसम्।।12।।","\n" +
                "लेकिन हे अर्जुन! जो यज्ञ केवल दिखावे और फल की दृष्टि से किया जाता है, उस यज्ञ अर्थात् धार्मिक कर्म को राजस जानो।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 13","विधिहीनम्, असृृष्टान्नम्, मन्त्राहीनम्, अदक्षिणम्,\n" +
                "श्रद्धाविरहितम्, यज्ञम्, तामसम्, परिचक्षते।।13।।","ऐसा यज्ञ अर्थात् धार्मिक कर्मकांड जो शास्त्राविधि के विपरीत हो, जिसमें अन्न का वितरण न किया गया हो, जो बिना वास्तविक मन्त्रों के, बिना दान दिए, बिना दीक्षा प्राप्त किए और बिना श्रद्धा के किया गया हो, वह तामस यज्ञ कहा जाता है।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 14","देवद्विजगुरुप्राज्ञपूजनम्, शौचम्, आर्जवम्,\n" +
                "ब्रह्मचर्यम्, अहिंसा, च, शारीरम्, तपः, उच्यते।।14।।","दैवीय प्रकृति के व्यक्तियों अर्थात् संतों, ब्राह्मणों, गुरुओं और विद्वानों का सम्मान, पवित्रता, विनम्रता, ब्रह्मचर्य और अहिंसा, यह शरीर से संबंधित तप कहा जाता है। परन्तु यह सब शास्त्रोक्त आदेशों के विपरीत है और जिसके कारण व्यर्थ की साधना है। क्योंकि गीता अध्याय 16 के श्लोक 23-24 में शास्त्राविधि त्याग कर मनमाना आचरण करना व्यर्थ बताया है।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 15","अनुद्वेगकरम्, वाक्यम्, सत्यम्, प्रियहितम्, च, यत्,\n" +
                "स्वाध्यायाभ्यसनम्, च, एव, वाङ्मयम्, तपः, उच्यते।।15।।","जो उद्वेग न करे, प्रिय और हितकर हो, सत्य वाणी हो, धर्मग्रन्थों का अध्ययन हो और ईश्वर के मन्त्र जाप का अभ्यास ही वाणी सम्बन्धी तप कहा जाता है।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 16","मनः प्रसादः, सौम्यत्वम्, मौनम्, आत्मविनिग्रहः,\n" +
                "भावसंशुद्धिः, इति, एतत्, तपः, मानसम्, उच्यते।।16।।","मन की प्रसन्नता, शांति, भगवान की चर्चा के अलावा, सांसारिक बातों में मौन, हर विचार का संयम और भावनाओं में पवित्रता; इस प्रकार, यह मन से संबंधित तपस्या कहा जाता है।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 17","श्रद्धया, परया, तप्तम्, तपः, तत्, त्रिविधम्, नरैः,\n" +
                "अफलाकाङ्क्षिभिः, युक्तैः, सात्त्विकम्, परिचक्षते।।17।।","भक्ति में लीन पुरुषों द्वारा फल की इच्छा न रखने वाले पुरुषों द्वारा परम श्रद्धा से किया गया उपर्युक्त तीन प्रकार का वह तप सात्विक कहा गया है।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 18","सत्कारमानपूजार्थम्, तपः, दम्भेन, च, एव, यत्,\n" +
                "क्रियते, तत्, इह, प्रोक्तम्, राजसम्, चलम्, अध्रुवम्।।18।।","जिस तपस्या को मान-सम्मान रूपी पूजा के लिए ही किया जाता है और कपट से उस क्षणभंगुर नाशवान तप को यहाँ राजस कहा जाता है।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 19","मूढग्राहेण, आत्मनः, यत्, पीडया, क्रियते, तपः,\n" +
                "परस्य, उत्सादनार्थम्, वा, तत्, तामसम्, उदाहृतम्।।19।।","मन, वाणी और शरीर को कष्ट पहुँचाकर अथवा दूसरों को हानि पहुँचाने के लिए मूर्खतावश हठपूर्वक जो तप किया जाता है, वह तप तामस कहा गया है। {इसका प्रमाण गीता अध्याय 3 श्लोक 6 में भी है।}"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 20","दातव्यम्, इति, यत्, दानम्, दीयते, अनुपकारिणे,\n" +
                "देशे, काले, च, पात्रो, च, तत्, दानम्, सात्त्विकम्, स्मृतम्।।20।।","परोपकार करना कर्तव्य है। जो दान परिस्थिति और समय को पाकर इस विश्वास से दिया जाता है और उसके बदले में बिना किसी फल की इच्छा के दान देने योग्य व्यक्ति को दिया जाता है, वह दान सात्विक कहलाता है।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 21","यत्, तु, प्रत्युपकारार्थम्, फलम्, उद्दिश्य, वा, पुनः,\n" +
                "दीयते, च, परिक्लिष्टम्, तत्, दानम्, राजसम्, स्मृतम्।।21।।","परन्तु जो दान बदले में लाभ प्राप्त करने के लिए या पुरस्कार पाने के उद्देश्य से और मतभेद के साथ दिया जाता है अर्थात् दान देने पर अप्रसन्न मन से दिया जाता है, वह दान राजस कहा जाता है।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 22","अदेशकाले, यत्, दानम्, अपात्रोभ्यः, च, दीयते,\n" +
                "असत्कृतम्, अवज्ञातम्, तत्, तामसम्, उदाहृतम्।।22।।","जो दान गुरु की आज्ञा का उल्लंघन करके, उनका अनादर करके और अनुचित समय, स्थिति में, पूर्ण गुरु के स्थान पर किसी अयोग्य प्राप्तकर्ता को दिया जाता है [1] वह दान तामस कहलाता है।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 23","ॐ, तत्, सत्, इति, निर्देशः, ब्रह्मणः, त्रिविधः, स्मृृतः,\n" +
                "ब्राह्मणाः, तेन, वेदाः, च, यज्ञाः, च, विहिताः, पुरा।।23।।","ॐ/ॐ ब्रह्म का मंत्र, तत् - यह परब्रह्म का सांकेतिक मंत्र है, सत् - यह पूर्णब्रह्म का सांकेतिक मंत्र है। इस प्रकार पूर्ण परमात्मा के तीन प्रकार के मन्त्रों के स्मरण की दिशा है और प्रकृति के आदि में उसी तत्वज्ञान के आधार पर विद्वानों ने वेद और यज्ञ आदि की रचना की उसी के अनुसार उपासना करते थे।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 24","तस्मात्, ओम्, इति, उदाहृत्य, यज्ञदानतपःक्रियाः,\n" +
                "प्रवर्तन्ते, विधानोक्ताः, सततम्, ब्रह्मवादिनाम्।।24।।","इसलिए यज्ञ, दान, तप और सुमिरन के कार्य जो भगवान की पूजा करते हैं और जो शास्त्र विधि के अनुसार अनुष्ठान करने की सलाह देते हैं, वे हमेशा इस मंत्र ॐ के जप से शुरू होते हैं; अर्थात् तीन मन्त्रों के जाप में श्वास के द्वारा ॐ मन्त्र से प्रारंभ होता है"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 25","तत्, इति, अनभिसन्धाय, फलम्, यज्ञतपःक्रियाः,\n" +
                "दानक्रियाः, च, विविधाः, क्रियन्ते, मोक्षकाङ्क्षिभिः।।25।।","अक्षर पुरुष अर्थात् परब्रह्म के तत् मन्त्र के जाप पर श्वास इति अर्थात् समाप्त होती है और उन मनुष्यों द्वारा की जाती है जो फल की इच्छा न करके कल्याण की इच्छा से अर्थात् यज्ञ, तप और दान आदि नाना प्रकार के कर्म करते हैं। जो केवल जन्म-मरण के चक्र से पूरी तरह मुक्त होना चाहते हैं। यह तत् मन्त्र सोहं मन्त्र है, जो परब्रह्म का जाप मन्त्र है और सतनाम के जाप में श्वांसों द्वारा श्वास इति अर्थात् तत् मन्त्र पर समाप्त हो जाती है।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 26","सद्भावे, साधुभावे, च, सत्, इति, एतत्, प्रयुज्यते,\n" +
                "प्रशस्ते, कर्मणि, तथा, सत्, शब्दः, पार्थ, युज्यते।।26।।","\n" +
                "'सत्'- इसी पूर्ण परमात्मा के नाम से तत् मन्त्र के अन्त में यह सारनाम सच्चे अर्थ में और परम भाव में प्रयुक्त होता है और हे पार्थ, सत शब्द अर्थात् सारनाम श्रेष्ठ कर्म में ही प्रयुक्त होता है; अर्थात उपरोक्त दो मंत्रों ॐ और तत् के अंत में जोड़ा जाता है।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 27","यज्ञे, तपसि, दाने, च, स्थितिः, सत्, इति, च, उच्यते,\n" +
                "कर्म, च, एव, तदर्थीयम्, सत्, इति, एव, अभिधीयते।।27।।","तथा यज्ञ, तपस्या और दान में स्थिति भी 'सत्' कही गई है तथा उस परमेश्वर के लिए ही की गई शास्त्रानुकूल भक्ति में तत्वदर्शी संत द्वारा सत् शब्द के अंत में एक और शब्द कहा गया है। जैसे सत साहिब, सतगुरु, सतपुरुष, सतलोक, सतनाम आदि शब्द कहे जाते हैं।"));
        list17.add(new GeetaModel("अध्याय 17","गीता श्लोक 28","अश्रद्धया, हुतम्, दत्तम्, तपः, तप्तम्, कृृतम्, च, यत्,\n" +
                "असत्, इति, उच्यते, पार्थ, न, च, तत्, प्रेत्य, नो, इह।।28।।","हे अर्जुन! बिना श्रद्धा के हवन, दान, तप और जो कुछ शुभ कर्म किया जाता है, वह सब 'असत' अर्थात् व्यर्थ है - ऐसा कहा जाता है। इसलिए यह न तो इस लोक में हमारे लिए हितकर है और न मृत्यु के बाद।"));


    }

    private void addDataToList16() {
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 1","अभ्यं, सत्त्वसंशुद्धिः, ज्ञानयोगव्यवस्तिः,\n" +
                "दानं, दमः, च, यज्ञः, च, स्वाध्यायः, तपः, आर्जवम् ||1||","निर्भयता, अन्तःकरण की पूर्ण पवित्रता, ज्ञान और दान, आत्मसंयम, यज्ञों का निष्पादन, धार्मिक शास्त्रों का अध्ययन, भक्तिमार्ग में कष्टों को सहने के रूप में तपस्या और अधीनता"));
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 2","\n" +
                "अहिंसा, सत्यम्, अक्रोधः, त्यागः, शान्तिः, अपैशुनम्,\n" +
                "दया, भूतेषु, अलोलुप्त्वम्, मार्दवम्, ह्रीर अचापलम्।।2।।","किसी को मन, वाणी और शरीर से किसी भी प्रकार से दुःख न पहुँचाना, सत्यवादी, स्वयं को हानि पहुँचाने वाले के प्रति क्रोध भी न करना, भगवान को अपना सिर भी समर्पित कर देना, मन की चंचलता का अभाव, किसी की निन्दा न करना, सभी जीवों पर दया करना निर्गुण प्राणी, सज्जनता, गलत कर्म करने में लज्जा, चापलूसी का अभाव।"));
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 3","तेजः, क्षमा, धृतिः, शौचम्, अद्रोहः, नातिमानिता,\n" +
                "भवन्ति, सम्पदम्, दैवीम्, अभिजातस्य, भारत।।3।।","दीप्ति, क्षमा, धैर्य, पवित्रता, वैर का अभाव, स्वयं की प्रतिष्ठा नहीं करवाता, हे अर्जुन! भक्ति भाव से जन्म लेने वाले व्यक्ति के यही लक्षण होते हैं।"));
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 4","दम्भः, दर्पः, अभिमानः, च, क्रोधः, पारुष्यम्, एव, च,\n" +
                "अज्ञानम्, च, अभिजातस्य, पार्थ, सम्पदम्, आसुरीम्,।।4।।","ओह पार्थ! कपट, अहंकार और दंभ और क्रोध, कठोरता और अज्ञान भी - ये सभी आसुरी गुणों वाले व्यक्ति के लक्षण हैं।"));
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 5","दैवी, सम्पत्, विमोक्षाय, निबन्धाय, आसुरी, मता,\n" +
                "मा, शुचः, सम्पदम्, दैवीम्, अभिजातः, असि, पाण्डव।।5।।","संत गुण मुक्ति के लिए और आसुरी गुण बंधन के लिए माने गए हैं। इसलिए, हे अर्जुन, शोक मत करो क्योंकि तुम भक्ति स्वभाव के साथ पैदा हुए हो।"));
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 6","द्वौ, भूतसर्गौ, लोके, अस्मिन्, दैवः, आसुरः, एव, च,\n" +
                "दैवः, विस्तरशः, प्रोक्तः, आसुरम्, पार्थ, मे, श्रृणु।।6।।","हे अर्जुन! इस संसार में दो ही प्रकार के जीवों की सृष्टि होती है; एक साधु प्रकृति वाले और दूसरे राक्षसी स्वभाव वाले। इनमें से साधु स्वभाव वालों का पहले विस्तार से वर्णन किया जा चुका है। अभी तुम मेरे द्वारा आसुरी स्वभाव वालों के बारे में सुनो।"));
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 7","प्रवृत्तिम्, च, निवृत्तिम्, च, जनाः, न, विदुः, आसुराः,\n" +
                "न, शौचम्, न, अपि, च, आचारः, न, सत्यम्, तेषु, विद्यते।।7।।","आसुरी प्रकृति वाले भले ही संत कहलाते हों, चाहे उनके शिष्य हों या वे स्वयं, जो शास्त्राविधि के विपरीत साधना करते हैं, क्या करें और क्या न करें, यह भी नहीं जानते; इसलिए उनमें न तो आन्तरिक पवित्रता होती है, न सदाचार और सत्य का भी पता नहीं चलता।"));
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 8","असत्यम्, अप्रतिष्ठम्, ते, जगत्, आहुः, अनीश्वरम्,\n" +
                "अपरस्परसम्भूतम्, किम्, अन्यत्, कामहैतुकम्।।8।।","वे आसुरी प्रकृति वाले कहते हैं कि संसार निराधार है, सब प्रकार से मिथ्या है और ईश्वर रहित है। यह स्त्री और पुरुष के संयोग से ही स्वतः उत्पन्न होता है। केवल प्रजनन ही इसका कारण है। इसके सिवा और क्या है? ऐसी मान्यता रखने वाले आसुरी स्वभाव के होते हैं।"));
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 9","एताम्, दृष्टिम्, अवष्टभ्य, नष्टात्मानः, अल्पबुद्धयः,\n" +
                "प्रभवन्ति, उग्रकर्माणः, क्षयाय, जगतः, अहिताः।।9।।","इस दृष्टि से मिथ्या ज्ञान का पालन करने वाले मंदबुद्धि, सबका अहित करने वाले, क्रूर कर्म करने वाले निन्दित जीव संसार के विनाश के लिए उत्पन्न होते हैं।"));
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 10","कामम्, आश्रित्य, दुष्पूरम्, दम्भमानमदान्विताः,\n" +
                "मोहात्, गृहीत्वा, असद्ग्राहान्, प्रवर्तन्ते, अशुचिव्रताः।।10।।","पाखण्ड, मान और अहंकार से भरे हुए, अतृप्त कामनाओं से प्रेरित, अज्ञानवश शास्त्रविरूद्ध मिथ्या सिद्धान्तों को प्राप्त करके संसार में भटकते हैं।"));
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 11","चिन्ताम्, अपरिमेयाम्, च, प्रलयान्ताम्, उपाश्रिताः,\n" +
                "कामोपभोगपरमाः, एतावत्, इति, निश्चिताः।।11।।","मृत्यु के बाद भी जो असंख्य चिंताएँ रहती हैं, वे सांसारिक भोगों को भोगने के लिए लालायित रहते हैं और मानते हैं कि केवल यही सुख है।"));
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 12","आशापाशशतैः, बद्धाः, कामक्रोधपरायणाः,\n" +
                "ईहन्ते, कामभोगार्थम्, अन्यायेन, अर्थस×चयान्।। 12।।","सैकड़ों इच्छाओं की बेड़ियों से बँधा हुआ, काम और क्रोध के वशीभूत होकर, सांसारिक भोगों में लिप्त होने के लिए अन्यायपूर्ण तरीकों से धन आदि इकट्ठा करने का प्रयास करता है।"));
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 13","इदम्, अद्य, मया, लब्धम्, इमम्, प्राप्स्ये, मनोरथम्,\n" +
                "इदम्, अस्ति, इदम्, अपि, मे, भविष्यति, पुनः, धनम्।।13।।","आज मैंने इसे हासिल कर लिया है और अब मैं इस इच्छा को पूरा करूंगा। मेरे पास इतनी दौलत है और इतनी दौलत फिर भी रहेगी।"));
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 14","असौ, मया, हतः, शत्राुः, हनिष्ये, च, अपरान्, अपि,\n" +
                "ईश्वरः, अहम्, अहम्, भोगी, सिद्धः, अहम्, बलवान्, सुखी।।14।।","वह शत्रु मेरे द्वारा मारा गया है और मैं उन अन्य शत्रुओं को भी मारूंगा। मैं भगवान और विलासिता का भोक्ता हूँ। मैं सभी अलौकिक शक्तियों से संपन्न हूं और शक्तिशाली और खुश हूं।"));
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 15,16","आढ्यः, अभिजनवान्, अस्मि, कः, अन्यः, अस्ति, सदृशः, मया,\n" +
                "यक्ष्ये, दास्यामि, मोदिष्ये, इति, अज्ञानविमोहिताः।।15।।\n" +
                "\n" +
                "अनेकचितविभ्रान्ताः, मोहजालसमावृताः,\n" +
                "प्रसक्ताः, कामभोगेषु, पतन्ति, नरके, अशुचै।।16।।","मैं बहुत धनी हूं और मेरा एक बड़ा परिवार या कई शिष्य हैं। मेरे समान कौन है? मैं यज्ञ करूंगा, दान करूंगा और आनंद मनाऊंगा। इस प्रकार अज्ञान से मोहित और नाना प्रकार से उलझे हुए मन वाले, मोह के जाल में फँसे हुए और विषय-सुखों में अत्यधिक आसक्त होकर आसुरी लोग घोर अपवित्र नरक में गिरते हैं।"));
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 17","आत्सम्भाविताः, स्तब्धाः, धनमानमदान्विताः,\n" +
                "यजन्ते, नामयज्ञैः, ते, दम्भेन, अविधिपूर्वकम्।।17।।","जो अपने को श्रेष्ठ समझते हैं, दुराचार पर दृढ़ रहते हैं, धन-प्रतिष्ठा के नशे में चूर रहते हैं, केवल नाम के लिए यज्ञ करके अर्थात् मनमाना भक्ति करके, जो शास्त्राविधि विरुद्ध है, आडंबर से पूजा करते हैं।"));
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 18","अहंकारम्, बलम्, दर्पम्, कामम्, क्रोधम्, च, संश्रिताः,\n" +
                "माम्, आत्मपरदेहेषु, प्रद्विषन्तः, अभ्यसूयकाः।।18।।","दंभ, बल, अहंकार, काम और क्रोध आदि के वशीभूत होकर दूसरों की निन्दा करने वाले सब शरीरों में व्याप्त आत्मा सहित परमात्मा से और मुझ से द्वेष करते हैं।"));
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 19","तान् अहम्, द्विषतः, क्रूरान्, संसारेषु, नराधमान्,\n" +
                "क्षिपामि, अजस्त्राम्, अशुभान्, आसुरीषु, एव, योनिषु।।19।।","वास्तव में द्वेष करने वालों, पापी व्यक्तियों, क्रूर कर्म करने वाले, पतित मनुष्यों को मैं संसार में आसुरी जन्मों में बार-बार गिराता हूँ।"));
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 20","आसुरीम्, योनिम्, आपन्नाः, मूढाः, जन्मनि, जन्मनि,\n" +
                "माम् अप्राप्य, एव, कौन्तेय, ततः, यान्ति, अधमाम्, गतिम्।।20।।","हे अर्जुन! वे मूर्ख मुझको प्राप्त न होकर जन्म-जन्मान्तर आसुरी योनियों को प्राप्त करते हैं और फिर उससे भी नीची अवस्था को प्राप्त होते हैं अर्थात् घोर नरकों में गिरते हैं।"));
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 21","त्रिविधम्, नरकस्य, इदम्, द्वारम्, नाशनम्, आत्मनः,\n" +
                "कामः क्रोधः, तथा, लोभः, तस्मात्, एतत्, त्रायम्, त्यजेत्।।21।।","काम, क्रोध और लोभ ये तीन प्रकार के नरक के द्वार जीवात्मा के नाश करने वाले अर्थात् आत्मघाती हैं। अतः इन तीनों का त्याग कर देना चाहिए"));
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 22","एतैः, विमुक्तः, कौन्तेय, तमोद्वारैः, त्रिभिः, नरः,\n" +
                "आचरति, आत्मनः, श्रेयः, ततः, याति, पराम्, गतिम्।।22।।","हे अर्जुन! नरक के इन तीन द्वारों से मुक्त व्यक्ति आत्मा के कल्याण के लिए कार्य करता है। इस प्रकार वह परमपद को जाता है अर्थात् पूर्ण परमात्मा को प्राप्त करता है"));
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 23","यः, शास्त्राविधिम्, उत्सृज्य, वर्तते, कामकारतः,\n" +
                "न, सः, सिद्धिम्, अवाप्नोति, न, सुखम्, न, पराम्, गतिम्।।23।।","जो शास्त्राविधि को त्यागकर मनमर्जी की इच्छा के अनुसार कर्म करता है, वह न तो सिद्धि को प्राप्त होता है, न परमपद/मोक्ष को, न सुख को प्राप्त होता है।"));
        list16.add(new GeetaModel("अध्याय 16","गीता श्लोक 24","तस्मात्, शास्त्राम्, प्रमाणम्, ते, कार्याकार्यव्यवस्थितौ,\n" +
                "ज्ञात्वा, शास्त्राविधानोक्तम्, कर्म, कर्तुम्, इह, अर्हसि।।24।।","इसलिए क्या करना चाहिए और क्या नहीं करना चाहिए, इस स्थिति में आपके लिए शास्त्र ही एकमात्र प्रमाण है। यह जानकर ही वही कर्म करना चाहिए, जो शास्त्रविधि के अनुसार हो।"));

    }

    private void addDataToList15() {
        list15.add(new GeetaModel("अध्याय 15","गीता श्लोक 1","ऊध्र्वमूलम्, अधःशाखम्, अश्वत्थम्, प्राहुः, अव्ययम्,\n" +
                "छन्दांसि, यस्य, पर्णानि, यः, तम्, वेद, सः, वेदवित्।।1।।"," गीता अध्याय 4 श्लोक 34 में कहा है कि अर्जुन पूर्ण परमात्मा के तत्वज्ञान को जानने वाले तत्वदर्शी संतों के पास जा कर उनसे विनम्रता से पूर्ण परमात्मा का भक्ति मार्ग प्राप्त कर, मैं उस पूर्ण परमात्मा की प्राप्ति का मार्ग नहीं जानता। इसी अध्याय 15 श्लोक 3 में भी कहा है कि इस संसार रूपी वृृक्ष के विस्तार को अर्थात् सृृष्टि रचना को मैं यहाँ विचार काल में अर्थात् इस गीता ज्ञान में नहीं बता पाऊँगा क्योंकि मुझे इस के आदि (प्रारम्भ) तथा अन्त (जहाँ तक यह फैला है अर्थात् सर्व ब्रह्मण्डों का विवरण) का ज्ञान नहीं है। तत्वदर्शी सन्त के विषय में इस अध्याय 15 श्लोक 1 में बताया है कि वह तत्वदर्शी संत कैसा होगा जो संसार रूपी वृृक्ष का पूर्ण विवरण बता देगा कि मूल तो पूर्ण परमात्मा है, तना अक्षर पुरुष अर्थात् परब्रह्म है, डार ब्रह्म अर्थात् क्षर पुरुष है तथा शाखा तीनों गुण (रजगुण ब्रह्मा जी, सतगुण विष्णु जी, तमगुण शिव जी)है तथा पात रूप संसार अर्थात् सर्व ब्रह्मण्ड़ों का विवरण बताएगा वह तत्वदर्शी संत है।"));
        list15.add(new GeetaModel("अध्याय 15","गीता श्लोक 2","अधः, च, ऊध्र्वम्, प्रसृृताः, तस्य, शाखाः, गुणप्रवृृद्धाः,\n" +
                "विषयप्रवालाः, अधः, च, मूलानि, अनुसन्ततानि, कर्मानुबन्धीनि, मनुष्यलोके।।2।।","उस वृक्षकी नीचे और ऊपर तीनों गुणों ब्रह्मा-रजगुण, विष्णु-सतगुण, शिव-तमगुण रूपी फैली हुई विकार- काम क्रोध, मोह, लोभ अहंकार रूपी कोपल, डाली ब्रह्मा, विष्णु, शिव जीवको कर्मोंमें बाँधने की जड़ें मुख्य कारण हैं तथा मनुष्यलोक – स्वर्ग,-नरक लोक पृथ्वी लोक में नीचे - नरक, चैरासी लाख जूनियों में ऊपर स्वर्ग लोक आदि में व्यवस्थित किए हुए हैं।"));
        list15.add(new GeetaModel("अध्याय 15","गीता श्लोक 3","न, रूपम्, अस्य, इह, तथा, उपलभ्यते, न, अन्तः, न, च, आदिः, न, च,\n" +
                "सम्प्रतिष्ठा, अश्वत्थम्, एनम्, सुविरूढमूलम्, असङ्गशस्त्रोण, दृृढेन, छित्वा।।3।।","इस रचना का न शुरूवात तथा न अन्त है न वैसा स्वरूप पाया जाता है तथा यहाँ विचार काल में अर्थात् मेरे द्वारा दिया जा रहा गीता ज्ञान में पूर्ण जानकारी मुझे भी नहीं है क्योंकि सर्वब्रह्मण्डों की रचना की अच्छी तरह स्थिति का मुझे भी ज्ञान नहीं है इस अच्छी तरह स्थाई स्थिति वाला मजबूत स्वरूपवाले निर्लेप तत्वज्ञान रूपी दृढ़ शस्त्र से अर्थात् निर्मल तत्वज्ञान के द्वारा काटकर अर्थात् निरंजन की भक्ति को क्षणिक जानकर।"));
        list15.add(new GeetaModel("अध्याय 15","गीता श्लोक 4","ततः, पदम्, तत्, परिमार्गितव्यम्, यस्मिन्, गताः, न, निवर्तन्ति, भूयः,\n" +
                "तम्, एव्, च, आद्यम्, पुरुषम्, प्रपद्ये, यतः, प्रवृत्तिः, प्रसृता, पुराणी।।4।।","{जब गीता अध्याय 4 श्लोक 34 अध्याय 15 श्लोक 1 में वर्णित तत्वदर्शी संत मिल जाए} इसके पश्चात् उस परमेश्वर के परम पद अर्थात् सतलोक को भलीभाँति खोजना चाहिए जिसमें गये हुए साधक फिर लौटकर संसारमें नहीं आते और जिस परम अक्षर ब्रह्म से आदि रचना-सृष्टि उत्पन्न हुई है उस सनातन पूर्ण परमात्मा की ही मैं शरण में हूँ। पूर्ण निश्चय के साथ उसी परमात्मा का भजन करना चाहिए।"));
        list15.add(new GeetaModel("अध्याय 15","गीता श्लोक 5","निर्मानमोहाः, जितसंगदोषाः, अध्यात्मनित्याः, विनिवृत्तकामाः,\n" +
                "द्वन्द्वैः, विमुक्ताः, सुखदुःखसंज्ञैः, गच्छन्ति, अमूढाः, पदम्, अव्ययम्, तत्।। 5।।","जिनका मान और मोह नष्ट हो गया है आसक्तता नष्ट हो गई हर समय पूर्ण परमात्मा में व्यस्त रहते हैं कामनाओं से रहित सुख-दुःख रूपी अधंकारसे अच्छी तरह रहित विद्वान उस अविनाशी सतलोक स्थान को जाते हैं। "));
        list15.add(new GeetaModel("अध्याय 15","गीता श्लोक 6","न, तत्, भासयते, सूर्यः, न, शशांकः, न, पावकः,\n" +
                "यत्, गत्वा, न, निवर्तन्ते, तत्, धाम, परमम्, मम् ।।6।।","जहाँ जाकर लौटकर संसारमें नहीं आते उस स्थान को न सूर्य प्रकाशित कर सकता है न चन्द्रमा और न अग्नि ही वह सतलोक मेरे लोक से श्रेष्ठ है।\n" +
                "\n" +
                "गीता जी के अन्य अनुवाद कर्ताओं ने लिखा है कि ‘‘वह मेरा परम धाम है’’ यदि यह भी माने तो यह गीता बोलने वाला ब्रह्म सत्यलोक अर्थात् परम धाम से निष्कासित है, इसलिए कहा है कि मेरा परमधाम भी वही है तथा मेरे लोक से श्रेष्ठ है, जहाँ जाने के पश्चात् फिर जन्म-मृत्यु में नहीं आते। इसीलिए अध्याय 15 श्लोक 4 में कहा है कि उसी आदि पुरूष परमात्मा की मैं शरण हूँ।"));
        list15.add(new GeetaModel("अध्याय 15","गीता श्लोक 7","मम, एव, अंशः, जीवलोके, जीवभूतः, सनातनः,\n" +
                "मनःषष्ठानि, इन्द्रियाणि, प्रकृतिस्थानि, कर्षति।।7।।"," (जीवलोके) मृतलोक में (सनातनः) आदि परमात्मा (अंशः) अंश (जीवभूतः) जीवात्मा (एव) ही (प्रकृतिस्थानि) प्रकृतिमें स्थित (मम) मेरे (मनः) काल का दूसरा स्वरूप मन है इस मन व (इन्द्रियाणि) पाँच इन्द्रियों (षष्ठानि) सहित इन छःओं द्वारा (कर्षति) आकर्षित करके सताई जाती है अर्थात् कृषित की जाती है।"));
        list15.add(new GeetaModel("अध्याय 15","गीता श्लोक 8","शरीरम्, यत्, अवाप्नोति, यत्, च, अपि, उत्क्रामति, ईश्वरः,\n" +
                "गृृहीत्वा, एतानि, संयाति, वायुः, गन्धान्, इव, आशयात्।।8।।"," (वायुः) हवा (गन्धान्) गन्धको (आशयात्) ले जाती है क्योंकि गंध की वायु मालिक है (इव) इसी प्रकार (ईश्वरः) सर्व शक्तिमान प्रभु (अपि) भी इस जीवात्मा को (एतानि) इन पाँच इन्द्रियों व मन सहित सुक्ष्म शरीर (गृहीत्वा) ग्रहण करके जीवात्मा (यत्) जिस पुराने शरीरको (उत्क्रामति) त्याग कर (च) और (यत्) जिस नए (शरीरम्) शरीरको (अवाप्नोति) प्राप्त होता है उसमें संस्कारवश (संयाति) ले जाता है। गीता अध्याय 18 श्लोक 61 में भी प्रमाण है। "));
        list15.add(new GeetaModel("अध्याय 15","गीता श्लोक 9","श्रोत्रम्, चक्षुः, स्पर्शनम्, च, रसनम्, घ्राणम्, एव, च,\n" +
                "अधिष्ठाय, मनः, च, अयम्, विषयान्, उपसेवते।।9।।","(अयम्) यह परमात्मा - अंश जीव आत्मा (श्रोत्राम्) कान (चक्षुः) आँख (च) और (स्पर्शनम्) त्वचा (च) और (रसनम्) रसना (घ्राणम्) नाक (च) और (मनः) मनके (अधिष्ठाय) माध्यम से (एव) ही (विषयान्) विषयों अर्थात् शब्द, स्पर्श, रूप, रस, गंध आदि का (उपसेवते) सेवन करता है। फिर उस का कर्म भोग जीवात्मा को ही भोगना पड़ता है। "));
        list15.add(new GeetaModel("अध्याय 15","गीता श्लोक 10","उत्क्रामन्तम्, स्थितम्, वा, अपि, भु×जानम्, वा, गुणान्वितम्,\n" +
                "विमूढाः, न, अनुपश्यन्ति, पश्यन्ति, ज्ञानचक्षुषः।।10।।"," (विमूढाः) अज्ञानीजन (उत्क्रामन्तम्) अन्त समय में शरीर त्याग कर जाते हुए अर्थात् शरीर से निकल कर जाते हुए (वा) अथवा (स्थितम्) शरीरमें स्थित (वा) अथवा (भु×जानम्) भोगते हुए (गुणान्वितम्) इन गुणों वाले आत्मा से अभेद रूप में रहने वाले परमात्मा को (अपि) भी (न,अनुपश्यन्ति) नहीं देखते अर्थात् नहीं जानते (ज्ञानचक्षुषः) ज्ञानरूप नेत्रोंवाले अर्थात् पूर्ण ज्ञानी (पश्यन्ति) जानते हैं। इसी का प्रमाण गीता अध्याय 2 श्लोक 12 से 23 तक भी है। "));
        list15.add(new GeetaModel("अध्याय 15","गीता श्लोक 11","यतन्तः, योगिनः, च, एनम्, पश्यन्ति, आत्मनि, अवस्थितम्,\n" +
                "यतन्तः, अपि, अकृतात्मानः, न, एनम्, पश्यन्ति, अचेतसः।।11।।","प्रयत्नशील योगी (भक्त) इस परमात्मा को अपने हृदय में स्थित देखते हैं जो आत्मा के साथ अभिन्न रूप से रहता है जैसे सूर्य की गर्मी निरंतर अपने अदृश्य प्रभाव को बनाए रखती है, और अज्ञानी जिन्होंने अपने अंतर्मन को शुद्ध नहीं किया है अर्थात जो भक्ति के कार्य नहीं करते हैं शास्त्र विधि के अनुसार प्रयत्न करने पर भी इसे नहीं देखते।"));
        list15.add(new GeetaModel("अध्याय 15","गीता श्लोक 12","यत्, आदित्यगतम्, तेजः, जगत्, भासयते, अखिलम्,\n" +
                "यत्, चन्द्रमसि, यत्, च, अग्नौ, तत्, तेजः, विद्धि, मामकम्।।12।।","सूर्य में स्थित जो तेज सम्पूर्ण जगत को प्रकाशित करता है और जो तेज चन्द्रमा में है और जो अग्नि में है, उस तेज को मेरा ही जानो।"));
        list15.add(new GeetaModel("अध्याय 15","गीता श्लोक 13","गाम्, आविश्य, च, भूतानि, धारयामि, अहम्, ओजसा,\n" +
                "पुष्णामि, च, ओषधीः, सर्वाः, सोमः, भूत्वा, रसात्मकः।।13।।","और मैं ही पृथ्वी में प्रवेश करके अपने अधीन प्राणियों को शक्ति से धारण करता हूँ और रसयुक्त अर्थात् अमृतमय चन्द्रमा बनकर समस्त औषधियों अर्थात् वनस्पतियों का पोषण करता हूँ।"));
        list15.add(new GeetaModel("अध्याय 15","गीता श्लोक 14","अहम्, वैश्वानरः, भूत्वा, प्राणिनाम्, देहम्, आश्रितः,\n" +
                "प्राणापानसमायुक्तः, पचामि, अन्नम्, चतुर्विधम्।।14।।","मैं ही अपने अधीन प्राणियों के शरीरों में स्थित होकर आने-जाने वाले श्वासों से संयोग करके पाचन-अग्नि बन चार प्रकार से अन्न को पचाता हूँ।"));
        list15.add(new GeetaModel("अध्याय 15","गीता श्लोक 15","सर्वस्य, च, अहम्, हृदि, सन्निविष्टः, मत्तः, स्मृृतिः, ज्ञानम्, अपोहनम्,\n" +
                "च, वेदैः, च, सर्वैः, अहम्, एव, वेद्यः, वेदान्तकृत्, वेदवित्, एव, च, अहम्।।","मैं अपने इक्कीस ब्रह्मण्डों के समस्त प्राणियों के हृदय में शास्त्रानुकूल विचार उत्पन्न करता हूँ और मैं ही स्मृति, ज्ञान और विश्लेषण (संदेह दूर करने वाला) हूँ और मैं ही वेदान्त का रचयिता, वेदों का ज्ञाता हूँ। और मैं ही समस्त वेदों द्वारा जानने योग्य हूं।"));
        list15.add(new GeetaModel("अध्याय 15","गीता श्लोक 16","द्वौ, इमौ, पुरुषौ, लोके, क्षरः, च, अक्षरः, एव, च,\n" +
                "क्षरः, सर्वाणि, भूतानि, कूटस्थः, अक्षरः, उच्यते।।16।।","इस संसार में दो प्रकार के देवता हैं, नाशवान और अविनाशी। इसी प्रकार इन दोनों लोकों में सभी प्राणियों के शरीर नाशवान् और आत्मा अविनाशी बताए गए हैं।"));
        list15.add(new GeetaModel("अध्याय 15","गीता श्लोक 17","उत्तमः, पुरुषः, तु, अन्यः, परमात्मा, इति, उदाहृतः,\n" +
                "यः, लोकत्रायम् आविश्य, बिभर्ति, अव्ययः, ईश्वरः।।17।।","हालाँकि, सर्वोच्च भगवान, दो पूर्वोक्त भगवान, क्षर पुरुष और अक्षर पुरुष के अलावा कोई और है, जो तीन लोकों में प्रवेश करके सभी का पालन-पोषण करता है और शाश्वत परमेश्वर परमात्मा (अमर सर्वोच्च भगवान) कहा जाता है।"));
        list15.add(new GeetaModel("अध्याय 15","गीता श्लोक 18","यस्मात्, क्षरम्, अतीतः, अहम्, अक्षरात्, अपि, च, उत्तमः,\n" +
                "अतः, अस्मि, लोके, वेदे, च, प्रथितः, पुरुषोत्तमः।।18।।","क्योंकि मैं नाशवान भौतिक शरीर से सब प्रकार से बड़ा हूँ और अविनाशी आत्मा से भी श्रेष्ठ हूँ और इसलिए लोक वेद में अर्थात् वेदों में सुनी-सुनाई विद्या के आधार पर परमेश्वर के रूप में प्रसिद्ध हूँ।"));
        list15.add(new GeetaModel("अध्याय 15","गीता श्लोक 19","यः, माम्, एवम्, असम्मूढः, जानाति, पुरुषोत्तमम्,\n" +
                "सः, सर्ववित्, भजति, माम्, सर्वभावेन, भारत।।19।।","हे भरत! जो ज्ञानी पुरुष तत्वदर्शी संत न मिलने के कारण मुझे इस प्रकार पुरुषोत्तम/परमात्मा के रूप में जानता है, वही मुझे ही सब कुछ समझकर सब प्रकार से मेरी पूजा करता है।"));
        list15.add(new GeetaModel("अध्याय 15","गीता श्लोक 20","इति, गुह्यतमम्, शास्त्राम्, इदम्, उक्तम्, मया, अनघ,\n" +
                "एतत्, बुद्ध्वा, बुद्धिमान्, स्यात्, कृतकृत्यः, च, भारत।।20।।","हे निष्पाप अर्जुन! इस प्रकार यह परम गुह्य गूढ़ शास्त्र मेरे द्वारा कहा गया है और इसे सार रूप में जानकर ज्ञानी धन्य हो जाता है; अर्थात् पूर्ण सन्त जो तत्वदर्शी सन्त है उसे पाकर उपदेश प्राप्त करके काल के जाल से छूट जाता है।"));
    }

    private void addDataToList14() {
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 1","परम्, भूयः, प्रवक्ष्यामि, ज्ञानानाम्, ज्ञानम्, उत्तमम्,\n" +
                "यत्, ज्ञात्वा, मुनयः, सर्वे, पराम्, सिद्धिम्, इतः, गताः।।1।।","मैं फिर से उस परम ज्ञान को कहूँगा, जो सभी ज्ञानों में श्रेष्ठ है, जिसे जानकर सभी मुनियों ने इस संसार से मुक्त होकर परम सिद्धि/मोक्ष/आध्यात्मिक सिद्धि (सिद्धि) प्राप्त की है।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 2","इदम्, ज्ञानम्, उपाश्रित्य, मम, साधम्र्यम्, आगताः,\n" +
                "सर्गे, अपि, न, उपजायन्ते, प्रलये, न, व्यथन्ति, च।।2।।","शरणागति अर्थात् इस ज्ञान का पालन करने से मुझ जैसे गुणों को धारण करने वाले भक्त सृष्टि के आदि में उत्पन्न नहीं होते और प्रलयकाल में भी विचलित नहीं होते।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 3","मम, योनिः, महत्, ब्रह्म, तस्मिन्, गर्भम्, दधामि, अहम्,\n" +
                "सम्भवः, सर्वभूतानाम्, ततः, भवति, भारत।।3।।","हे अर्जुन! मेरी आदि प्रकृति अर्थात् दुर्गा समस्त प्राणियों की कोख है और मैं ब्रह्म-काल उस गर्भ में बीज रखता हूँ। उस मिलन से समस्त जीवों का जन्म होता है।\n"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 4","सर्वयोनिषु, कौन्तेय, मूर्तयः, सम्भवन्ति, याः,\n" +
                "तासाम्, ब्रह्म, महत्, योनिः, अहम्, बीजप्रदः, पिता।।4।।","हे अर्जुन! जो भी देहधारी प्राणी सब के गर्भ में जन्म लेते हैं, आदि प्रकृति उनकी गर्भ धारण करने वाली माता है और मैं ब्रह्म-काल बीज देने वाला पिता हूँ।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 5","सत्त्वम्, रजः, तमः, इति, गुणाः, प्रकृृतिसम्भवाः,\n" +
                "निबध्नन्ति, महाबाहो, देहे, देहिनम्, अव्ययम्।।5।।","हे अर्जुन! सत्वगुण, रजोगुण और तमोगुण, प्रकृति से उत्पन्न ये तीन गुण सनातन आत्मा को शरीर से बाँधते हैं।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 6","तत्र, सत्त्वम्, निर्मलत्वात्, प्रकाशकम्, अनामयम्,\n" +
                "सुखसंगेन, बध्नाति, ज्ञानसंगेन, च, अनघ।।6।।","हे निष्पाप! उन तीनों गुणों में सत्वगुण शुद्ध होने के कारण प्रकाश करने वाला और नकली अनामी है। यह सुख के साथ राग को और ज्ञान के साथ अर्थात् अपने अभिमान को मोह से बाँधता है।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 7","रजः, रागात्मकम्, विद्धि, तृष्णासंगसमुद्भवम्,\n" +
                "तत्, निबध्नाति, कौन्तेय, कर्मसंगेन, देहिनम्।।7।।","हे अर्जुन! राग रूपी रजोगुण को इच्छा और मोह से उत्पन्न होने वाला जानो। यह इस आत्मा को कर्मों और उनके फलों के प्रति आसक्ति से बांधता है।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 8","तमः, तु, अज्ञानजम्, विद्धि, मोहनम्, सर्वदेहिनाम्,\n" +
                "प्रमादालस्यनिद्राभिः, तत्, निबध्नाति, भारत।।8।।","हे अर्जुन! उस तमोगुण को जानो जो सभी देहधारी प्राणियों को अज्ञान से उत्पन्न होने का भ्रम देता है। यह आत्मा को अधर्म, आलस्य और निद्रा से बाँधता है।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 9","सत्त्वम्, सुखे, संजयति, रजः, कर्मणि, भारत,\n" +
                "ज्ञानम्, आवृत्य, तु, तमः, प्रमादे, संजयति, उत।। 9।।","हे अर्जुन! सत्त्वगुण सुख में और रजोगुण कर्म में और तमोगुण भी ज्ञान को आच्छादित करके गलत कार्यों में लगा रहता है"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 10","रजः, तमः, च, अभिभूय, सत्त्वम्, भवति, भारत,\n" +
                "रजः, सत्त्वम्, तमः, च, एव, तमः, सत्त्वम्, रजः, तथा।।10।।","हे अर्जुन! सत्वगुण प्रबल होता है अर्थात् रजोगुण और तमोगुण को दबा कर उदय होता है, रजोगुण सत्वगुण और तमोगुण को दबा कर प्रबल होता है, वैसे ही तमोगुण प्रबल होता है अर्थात् सत्वगुण और रजगुण को दबा कर उदय होता है।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 11","सर्वद्वारेषु, देहे, अस्मिन्, प्रकाशः, उपजायते,\n" +
                "ज्ञानम्, यदा, तदा, विद्यात्, विवृद्धम्, सत्त्वम्, इति, उत।।11।।","जब इस शरीर में और अन्तःकरण में और इन्द्रियों में चेतना और विवेक उत्पन्न हो, उस समय जानना चाहिए कि सत्त्वगुण प्रधान है।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 12","लोभः, प्रवृत्तिः, आरम्भः, कर्मणाम्, अशमः, स्पृृहा,\n" +
                "रजसि, एतानि, जायन्ते, विवृृद्धे, भरतर्षभ।।12।।","हे अर्जुन! रजोगुण प्रधान होने पर ये सब उत्पन्न होते हैं - स्वार्थी मन वाला लोभी स्वभाव, फल की इच्छा से कर्मों का प्रारंभ, बेचैनी और सांसारिक सुखों की लालसा।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 13","अप्रकाशः, अप्रवृृत्तिः, च, प्रमादः, मोहः, एव, च,\n" +
                "तमसि, एतानि, जायन्ते, विवृृद्धे, कुरुनन्दन।।13।।","\n" +
                "हे अर्जुन! जब तमोगुण की प्रधानता होती है तो ये सब ही उत्पन्न होते हैं - अन्तःकरण और इन्द्रियों में अन्धकार/विवेक का अभाव, कर्तव्य-पालन की प्रवृत्ति का अभाव, व्यर्थ चेष्टा-निद्रा आदि अन्तःकरण की मायावी वृत्तियाँ।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 14","यदा, सत्त्वे, प्रवृद्धे, तु, प्रलयम्, याति, देहभृत्,\n" +
                "तदा, उत्तमविदाम्, लोकान्, अमलान्, प्रतिपद्यते।।14।।","सत्त्वगुण प्रधान रहते हुए जब मृत्यु मिलती है, तब वह सत्कर्म करने वालों के पवित्र और दिव्य स्वर्ग-सदृश लोकों/लोकों को प्राप्त करता है।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 15","रजसि, प्रलयम्, गत्वा, कर्मसंगिषु, जायते,\n" +
                "तथा, प्रलीनः, तमसि, मूढयोनिषु जायते।।15।।","जब कोई व्यक्ति रजोगुण की प्रधानता से मरता है, तो वह कर्मों में आसक्त लोगों के बीच पैदा होता है, और जो व्यक्ति तमोगुण की प्रधानता से मरता है, वह कीट, पशु आदि के अज्ञान योनियों (गर्भों / जन्मों) में पैदा होता है।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 16","कर्मणः, सुकृतस्य, आहुः, सात्त्विकम्, निर्मलम्, फलम्,\n" +
                "रजसः, तु, फलम्, दुःखम्, अज्ञानम्, तमसः, फलम्।।16।।","श्रेष्ठ कर्म का फल सात्विक अर्थात् सुख, ज्ञान और वैराग्य आदि कहा गया है, किन्तु राजस कर्म का फल दु:ख और तामस कर्म का फल अज्ञान कहा गया है।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 17","सत्त्वात्, संजायते, ज्ञानम्, रजसः, लोभः, एव, च\n" +
                "प्रमादमोहौ, तमसः, भवतः, अज्ञानम्, एव, च।।17।।","सत्त्वगुण से ज्ञान और रजोगुण से निस्सन्देह लोभ और तमोगुण से अधर्म और मोह और अज्ञान भी उत्पन्न होता है।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 18","ऊध्र्वम्, गच्छन्ति, सत्त्वस्थाः, मध्ये, तिष्ठन्ति, राजसाः,\n" +
                "जघन्यगुणवृृत्तिस्थाः, अधः, गच्छन्ति, तामसाः।।18।।","सत्वगुण में स्थित पुरुष अर्थात् विष्णु के उपासक स्वर्ग रूपी उच्च लोकों में जाते हैं। रजोगुण में स्थित राजस पुरुष अर्थात् ब्रह्मा के उपासक बीच में अर्थात् पुरुषों के लोक में रहते हैं, और तामस पुरुष अर्थात् तमोगुण द्वारा किए गए निद्रावस्था, अधर्म और आलस्य आदि में स्थित शिव के उपासक कीड़ों के निम्न जन्मों में उतरते हैं, जानवर आदि और नरक में जाओ। उदाहरण-रावण, भस्मासुर आदि।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 19","न, अन्यम्, गुणेभ्यः, कर्तारम्, यदा, द्रष्टा, अनुपश्यति,\n" +
                "गुणेभ्यः, च, परम्, वेत्ति, मद्भावम्, सः, अधिगच्छति।।19।।","जब एक विवेकशील भक्त तीन गुणों - ब्रह्मा, विष्णु और शिव के अलावा अन्य किसी को भगवान के रूप में नहीं देखता है, और तीन गुणों - रजगुण-ब्रह्मा, सतगुण-विष्णु और तमगुण-शिव जी के अलावा पूर्ण परमात्मा को सार रूप में जानता है, वह उन दृष्टिकोणों को प्राप्त करता है जो मेरी राय (चटाई) के अनुसार हैं।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 20","\n" +
                "गुणान्, एतान्, अतीत्य, त्राीन्, देही, देहसमुद्भवान्,\n" +
                "जन्ममृत्युजरादुःखै, विमुक्तः, अमृृतम्, अश्नुते।।20।।","वह जीवात्मा इन तीनों गुणों अर्थात् रजोगुण-ब्रह्मा जी, सतगुण-विष्णु जी तथा तमगुण-शिव जी, जो शरीर की उत्पत्ति के कारण हैं, को पार कर जाता है और शास्त्रानुकूल परमेश्वर की साधना करके परमात्मा की साधना करके मुक्त हो जाता है। जन्म, मृत्यु, जरा और सब प्रकार के दुखों से मुक्त होकर परम सुख अर्थात् नित्यता को प्राप्त करता है।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 21","कैः, लिंगैः, त्राीन्, गुणान्, एतान्, अतीतः, भवति, प्रभो,\n" +
                "किमाचारः, कथम्, च, एतान्, त्राीन्, गुणान्, अतिवर्तते।।21।।","\n" +
                "इन तीनों गुणों से ऊपर उठ जाने वाले भक्त के क्या लक्षण होते हैं? और उसका आचरण क्या है? और हे प्रभु! वह कैसे इन तीनों गुणों से ऊपर उठता है अर्थात् ऊपर उठता है?"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 22","प्रकाशम्, च, प्रवृत्तिम्, च, मोहम्, एव, च, पाण्डव,\n" +
                "न, द्वेष्टि, सम्प्रवृत्तानि, न, निवृत्तानि, काङ्क्षति।।22।।","हे अर्जुन! एक भक्त जो रोशनी से नफरत नहीं करता है - सत्त्वगुण का वास्तविक रूप, और स्वभाव - रजोगुण का वास्तविक रूप, और भ्रम - तमोगुण का वास्तविक रूप, जब वे होते हैं, न ही उनके समाप्त होने पर उनकी लालसा करते हैं।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 23","उदासीनवत्, आसीनः, गुणैः, यः, न, विचाल्यते,\n" +
                "गुणाः, वर्तन्ते, इति, एव, यः, अवतिष्ठति, न, इंगते।।23।।","जो सब पदार्थों के भोग से हट गया है अर्थात् साक्षी की तरह स्थित है, उसे गुणों से विचलित नहीं किया जा सकता है, और यह जानकर कि गुण (रजगुण-ब्रह्मा, सतगुण-विष्णु और तमगुण-शिव) ही गुणों में कार्य करते हैं ( रजगुण, सतगुण और तमगुण), जो विशेष रूप से सच्चिदानंदघन [1] परमात्मा [2] में स्थित रहता है और उस स्थिति से कभी विचलित नहीं होता है।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 24","समदुःखसुखः, स्वस्थः, समलोष्टाश्मकांचनः,\n" +
                "तुल्यप्रियाप्रियः, धीरः, तुल्यनिन्दात्मसंस्तुतिः।।24।।","अपने तत्वज्ञान के आधार पर सुख-दुःख को एक समान मानने वाला, मिट्टी, पत्थर और सोने को समान रूप से देखने वाला, तत्वज्ञानी अर्थात् सुख-दुःख को समान मानने वाला ज्ञानी और आलोचना-प्रशंसा में संतुलित रहता है।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 25","मानापमानयोः, तुल्यः, तुल्यः, मित्रारिपक्षयोः,\n" +
                "सर्वारम्भपरित्यागी, गुणातीतः, सः, उच्यते।।25।।","जो मान और अपमान में संतुलित है, मित्र और शत्रु के समान है, और जो प्रेम के कारण किसी को लाभ पहुँचाने और द्वेष के कारण किसी को नुकसान पहुँचाने के सभी प्रयासों को त्याग देता है, वह भक्त गुणों से परे कहा जाता है अर्थात् वह है तीनों देवों (रजगुण-ब्रह्मा, सतगुण-विष्णु तथा तमगुण-शिव जी) की अदृश्य शक्ति से प्रभावित नहीं।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 26","माम्, च, यः, अव्यभिचारेण, भक्तियोगेन, सेवते,\n" +
                "सः, गुणान्, समतीत्य, एतान्, ब्रह्मभूयाय, कल्पते।।26।।","और जो भक्त अव्यभिचारी भक्ति योग के माध्यम से निरंतर मेरी पूजा करता है, वह भी इन तीनों गुणों को पार कर सच्चिदानंदघन ब्रह्म को प्राप्त करने के योग्य हो जाता है अर्थात् केवल उस एक पूर्ण परमात्मा की इच्छा करता है।"));
        list14.add(new GeetaModel("अध्याय 14","गीता श्लोक 27","ब्रह्मणः, हि, प्रतिष्ठा, अहम्, अमृतस्य, अव्ययस्य, च,\n" +
                "शाश्वतस्य, च, धर्मस्य, सुखस्य, ऐकान्तिकस्य, च।।27।।","क्योंकि उस अविनाशी परमेश्वर का और अमृत का, और सनातन उपासना का और परम आनंद का (प्रथम) चरण अर्थात् परिचय मैं ही हूँ अर्थात् वह परमेश्वर भी मेरे द्वारा ही प्राप्त होता है।"));

    }

    private void addDataToList13() {
        list13.add(new GeetaModel("अध्याय 13"," 1","इदम्, शरीरम्, कौन्तेय, क्षेत्राम्, इति, अभिधीयते,\n" +
                "एतत्, यः, वेत्ति, तम्, प्राहुः, क्षेत्राज्ञः, इति, तद्विदः।।1।।","हे अर्जुन! इस शरीर को क्षेत्र कहते हैं और तत्व को जानने वाले ज्ञानी पुरुष इस शरीर को क्षेत्रज्ञ कहते हैं।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 2","क्षेत्राज्ञम्, च, अपि, माम्, विद्धि, सर्वक्षेत्रोषु, भारत,\n" +
                "क्षेत्राक्षेत्राज्ञयोः, ज्ञानम्, यत्, तत्, ज्ञानम्, मतम्, मम।।2।।","हे अर्जुन! सब क्षेत्रों अर्थात् शरीरों में मुझ ही को ज्ञाता जान और क्षेत्र-क्षेत्रज्ञ को तत्व से जानना ही ज्ञान है; ये मेरा विचार हे।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 3","तत्, क्षेत्राम्, यत्, च, यादृक्, च, यद्विकारि, यतः, च, यत्,\n" +
                "सः, च, यः, यत्प्रभावः, च, तत्, समासेन, मे, श्रृणु।।3।।","\n" +
                "वह क्षेत्र, क्या है और कैसा है, उसमें क्या दोष है और किस कारण से है, क्या है, क्या है और उसका क्या प्रभाव है, वह सब मुझसे संक्षेप में सुनो।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 4","ऋषिभिः, बहुधा, गीतम्, छन्दोभिः, विविधैः, पृथक्,\n" +
                "ब्रह्मसूत्रापदैः, च, एव, हेतुमद्भिः, विनिश्चितैः।।4।।","इसे ऋषियों ने कई तरह से समझाया है, और इसे कई वैदिक मंत्रों द्वारा और ब्रह्मसूत्र के उचित रूप से निष्कर्षित, तर्कपूर्ण श्लोकों द्वारा भी विशिष्ट रूप से कहा गया है।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 5","महाभूतानि, अहंकारः, बुद्धिः, अव्यक्तम्, एव, च,\n" +
                "इन्द्रियाणि, दश, एकम्, च, पॅंच, च, इन्द्रियगोचराः।। 5।।","पांच महान तत्व, अहंकार, बुद्धि और अव्यक्त भी और दस इंद्रियां, एक मन और पांच इंद्रिय वस्तुएं यानी ध्वनि, स्पर्श, दृष्टि, स्वाद और गंध।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 6","इच्छा, द्वेषः, सुखम्, दुःखम्, सङ्घातः, चेतना, धृतिः,\n" +
                "एतत्, क्षेत्राम्, समासेन, सविकारम्, उदाहृतम्।।6।।","इच्छा, द्वेष, हर्ष, शोक, भौतिक शरीर/भौतिक शरीर, चेतना और दृढ़ता, इस प्रकार दोषों सहित इस क्षेत्र का वर्णन किया गया है।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 7","अमानित्वम्, अदम्भित्वम्, अहिंसा, क्षान्तिः, आर्जवम्,\n" +
                "आचार्योपासनम्, शौचम्, स्थैर्यम्, आत्मविनिग्रहः।।7।।","अहंकार का अभाव, दंभ का अभाव, अहिंसा - किसी भी जीव को किसी भी प्रकार से कष्ट न देना, क्षमा, सरलता, श्रद्धा और भक्ति से गुरु की सेवा, आन्तरिक और बाह्य शुद्धि, अंतर्मन की स्थिरता और आत्मसंयम।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 8","इन्द्रियार्थेषु, वैराग्यम्, अनहंकारः, एव, च,\n" +
                "जन्ममृत्युजराव्याधिदुःखदोषानुदर्शनम्।।8।।","इन्द्रियों के सुखों के प्रति आसक्ति का अभाव, और अहंकार का भी अभाव; जन्म, मृत्यु, बुढ़ापा और बीमारी आदि के कष्टों और दोषों पर बार-बार विचार करना।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 9","असक्तिः, अनभिष्वङ्गः, पुत्रादारगृहादिषु,\n" +
                "नित्यम्, च, समचित्तत्वम्, इष्टानिष्टोपपत्तिषु।।9।।","पुत्र, पत्नी, घर और धन आदि के प्रति आसक्ति का अभाव, मालकियत का अभाव और इष्टवादिता का विस्मरण अर्थात् पूज्य देव और अन्य अपादान्य देव की प्राप्ति और अप्राप्ति, मन की निरंतर समता।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 10","मयि, च, अनन्ययोगेन, भक्तिः, अव्यभिचारिणी,\n" +
                "विविक्तदेशसेवित्वम्, अरतिः, जनसंसदि।।10।।","मेरे प्रति अनन्य भक्ति, केवल एक ईश्वर पर आधारित भक्ति; और एकांत और पवित्र स्थान में रहने का स्वभाव और दुराचारियों की भीड़ के प्रति कोई स्नेह नहीं रखना।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 11","अध्यात्मज्ञाननित्यत्वम्, तत्त्वज्ञानार्थदर्शनम्,\n" +
                "एतत्, ज्ञानम्, इति, प्रोक्तम्, अज्ञानम्, यत्, अतः, अन्यथा।।11।।","अध्यात्म ज्ञान में निरन्तर स्थिति और तत्वज्ञान की दृष्टि से देखना - कहा है कि यह सब ज्ञान है और जो इसके विपरीत है वह अज्ञान है।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 12","ज्ञेयम्, यत्, तत्, प्रवक्ष्यामि, यत्, ज्ञात्वा, अमृतम्, अश्नुते।\n" +
                "अनादिमत्, परम्, ब्रह्म, न, सत्, तत्, न, असत्, उच्यते।।12।।","जो जानने योग्य है और जिसे जानकर परम सुख प्राप्त होता है, उसे मैं विधिपूर्वक घोषित करूँगा। उस अनादि परम ब्रह्म को न तो व्यक्त कहते हैं और न ही अव्यक्त।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 13","सर्वतः पाणिपादम्, तत्, सर्वतोऽक्षिशिरोमुखम्।\n" +
                "सर्वतःश्रुतिमत्, लोके, सर्वम्, आवृत्य, तिष्ठति।।13।।","उसके हाथ और पैर सभी दिशाओं में हैं, उसके चारों ओर आँखें, सिर और चेहरे हैं, और सभी दिशाओं में उसके कान हैं। क्योंकि वह संसार में सबको व्याप्त करके स्थित है।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 14","सर्वेन्द्रियगुणाभासम्, सर्वेन्द्रियविवर्जितम्।\n" +
                "असक्तम्, सर्वभृत्, च, एव, निर्गुणम्, गुणभोक्तृृ, च।।14।।","वह सब इन्द्रियों के विषयों को जानने वाला है, पर वास्तव में सब इन्द्रियों से रहित है, अनासक्त होकर भी सबका पालन करने वाला है और निर्गुण होते हुए भी गुणों का भोक्ता है।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 15","बहिः, अन्तः, च, भूतानाम्, अचरम्, चरम्, एव, च।\n" +
                "सूक्ष्मत्वात्, तत्, अविज्ञेयम्, दूरस्थम्, च, अन्तिके, च, तत्।।15।।","वह सभी चर और अचर प्राणियों के अंदर और बाहर रहता है और चर और अचर के रूप में भी है और सूक्ष्म होने के कारण अगम्य है अर्थात् जिसकी सही स्थिति को नहीं जाना जा सकता है और वह केवल बहुत ही स्थित है पास भी और दूर भी।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 16","अविभक्तम्, च, भूतेषु, विभक्तम्, इव, च, स्थितम्।\n" +
                "भूतभर्तृ, च, तत्, ज्ञेयम्, ग्रसिष्णु, प्रभविष्णु, च।।16।।","वह अविभाजित होते हुए भी जीवों के भीतर विभक्त होकर स्थित है और वह परमात्मा जानने योग्य, विष्णु-रूप में जीवों का पालन-पोषण करने वाला और सबका संहारक और उत्पत्ति करने वाला है।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 17","ज्योतिषाम्, अपि, तत्, ज्योतिः, तमसः, परम्, उच्यते।\n" +
                "ज्ञानम्, ज्ञेयम्, ज्ञानगम्यम्, हृदि, सर्वस्य, विष्ठितम्।।17।।","वह पूर्ण ब्रह्म ज्योतियों का भी प्रकाश और मायाधारी काल से भिन्न कहा जाता है। वह परमात्मा ज्ञान (रूप) है, तत्त्वज्ञान से जानने योग्य और प्राप्त करने योग्य है और सबके हृदय में विशेष प्रकार से स्थित है।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 18","इति, क्षेत्राम् तथा, ज्ञानम्, ज्ञेयम्, च, उक्तम्, समासतः।\n" +
                "मद्भक्तः, एतत्, विज्ञाय, मद्भावाय, उपपद्यते।।18।।","इस प्रकार मैंने शरीर और जानने योग्य परमात्मा के विषय में संक्षेप में ज्ञान कह दिया है। और मत् भक्त अर्थात् इस मत को जानने वाला जिज्ञासु अर्थात् मेरा भक्त जो मेरे मत को तत्वत: जानकर जानता है वही मत अर्थात् मतावलंबी प्राप्त करता है। काल अर्थात् ब्रह्म-साधना को त्याग कर पूर्ण ब्रह्म सतपुरुष की साधना करने से जन्म-मरण से सर्वथा मुक्त हो जाता है।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 19","प्रकृतिम्, पुरुषम्, च, एव, विद्धि, अनादी, उभौ, अपि।\n" +
                "विकारान्, च, गुणान्, च, एव, विद्धि, प्रकृतिसम्भवान्।।19।।","प्रकृति अर्थात् प्रथम माया जिसे पराशक्ति भी कहा जाता है और पूर्ण परमात्मा - इन दोनों को ही अनादि जानों और राग-द्वेष आदि दोषों को भी जानो और तीनों गुणों अर्थात् रजगुण-ब्रह्मा, सतगुण-विष्णु और तमगुण-शिव जी को भी जानो प्रकृति से ही जन्म लें। यही प्रमाण गीता अध्याय 14 के श्लोक 5 में भी है कि तीनों गुण अर्थात् रजगुण-ब्रह्मा, सतगुण-विष्णु तथा तमगुण-शिव जी की उत्पत्ति प्रकृति से हुई है।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 20","कार्यकरणकतृर्त्वे, हेतुः, प्रकृतिः, उच्यते।\n" +
                "पुरुषः सुखदुःखानाम्, भोक्तृृत्वे, हेतुः, उच्यते।।20।।","प्रकृति को क्रिया और प्रदर्शन के उत्पादन का कारण कहा जाता है, और सतपुरुष को देहधारी आत्मा को सुख और दुख का अनुभव कराने का कारण कहा जाता है। गीता अध्याय 18 के श्लोक 16 में कहा है कि परमेश्वर सर्व प्राणियों को कर्मों के अनुसार यन्त्र के समान घुमाता हुआ सब प्राणियों के हृदय में स्थित है। अध्याय 15 के श्लोक 17 में कहा है कि परमेश्वर गीता ज्ञान दाता के अतिरिक्त कोई और है। वही अमर परमात्मा तीनों लोकों में प्रवेश करके सबकी पालना करता है।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 21","पुरुषः, प्रकृृतिस्थः, हि, भुङ्क्ते, प्रकृृतिजान्, गुणान्।\n" +
                "कारणम्, गुणसंगः, अस्य, सदसद्योनिजन्मसु।।21।।","देहधारी आत्मा को प्रकृति से उत्पन्न त्रिगुणों से युक्त बनाकर उसके कर्मों का फल भोगने वाला पुरुष अर्थात् प्रकृति में स्थित परमात्मा ही अनुभव करता है और इन्हीं गुणों का संयोग ही इसे बनाने का कारण है। देहधारी आत्मा अच्छे और बुरे गर्भों में जन्म लेती है। यही प्रमाण गीता अध्याय 14 श्लोक 5 तथा अध्याय 18 श्लोक 16 में भी है।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 22","उपद्रष्टा, अनुमन्ता, च, भर्ता, भोक्ता, महेश्वरः।\n" +
                "परमात्मा, इति, च, अपि, उक्तः, देहे, अस्मिन्, पुरुषः, परः।।22।।","यह सतपुरुष अर्थात् पूर्णब्रह्म भी इस शरीर में स्थित है वास्तव में श्रेष्ठतम परमात्मा गीता ज्ञान दाता से अन्य है अर्थात् कोई और है। वही साक्षी होने के कारण दृष्टा, सत्य सहमति देने के कारण अनुमति देने वाला, सबका पालन-पोषण करने और रक्षा करने के कारण पालन करने वाला और आत्मा को उसके कर्मों का फल भोगने के कारण भोगने वाला कहा जाता है। यहाँ तक कि ब्रह्म और परब्रह्म, महेश्वर (सर्वोत्तम देव) और परमात्मा के भी स्वामी होने के नाते। यही प्रमाण गीता अध्याय 15 श्लोक 16-17 में भी है।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 23","यः, एवम्, वेत्ति, पुरुषम्, प्रकृृतिम्, च, गुणैः, सह,\n" +
                "सर्वथा, वर्तमानः, अपि, न, सः, भूयः, अभिजायते।।23।।","इस प्रकार जो सतपुरुष तथा माया अर्थात् दुर्गा को गुणों सहित अर्थात् रजगुण-ब्रह्मा, सतगुण-विष्णु तथा तमगुण-शिव जी को तत्व रूप में जानता है, वह वर्तमान में शास्त्रविरुद्ध भक्तिमार्ग से सर्वथा विमुख हो जाता है। समय अर्थात् वर्तमान काल में शास्त्रानुकूल भक्ति कर्म करते समय पुनर्जन्म नहीं होता।"));

        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 24","ध्यानेन, आत्मनि, पश्यन्ति, केचित्, आत्मानम्, आत्मना।\n" +
                "अन्ये, साङ्ख्येन, योगेन, कर्मयोगेन, च, अपरे।।24।।","बहुत से मनुष्य अपनी दिव्य दृष्टि से अपने शरीर में अंतर्मन में (ध्यान) ध्यान द्वारा ईश्वर को देखते हैं; ज्ञानयोग से अनेक और अनेक कर्मयोग द्वारा देखते अर्थात् अनुभव करते हैं। गीता अध्याय 5 श्लोक 4-5 में भी प्रमाण है।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 25","अन्ये, तु, एवम्, अजानन्तः, श्रुत्वा, अन्येभ्यः, उपासते।\n" +
                "ते, अपि, च, अतितरन्ति, एव, मृत्युम्, श्रुतिपरायणाः।।25।।","इसके विपरीत अन्य लोग इस प्रकार न जानते हुए दूसरों के द्वारा सुने हुए अर्थात् तत्त्व को जानने वाले पुरुषों के द्वारा पूजा करते हैं और जो सुनते हैं उसका पालन करने वाले भी निश्चित रूप से मृत्यु रूपी सागर को पार कर जाते हैं। दुनिया। इसका प्रमाण गीता अध्याय 5 श्लोक 4-5 में भी है।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 26","यावत्, संजायते , किंचित, सत्त्वम्, स्थावरजंगमम्।\n" +
                "क्षेत्राक्षेत्राज्ञसंयोगात्, तत्, विद्धि, भरतर्षभ।।26।।","हे अर्जुन! जो भी चर और अचर प्राणी उत्पन्न होते हैं, उन सबको क्षेत्र और क्षेत्रज्ञ के मिलन से उत्पन्न जान।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 27","समम्, सर्वेषु, भूतेषु, तिष्ठन्तम्, परमेश्वरम्।\n" +
                "विनश्यत्सु, अविनश्यन्तम्, यः, पश्यति, सः, पश्यति।।27।।","जो परमेश्वर को अविनाशी रूप में देखता है और नष्ट होने वाले सभी चर और अचर में समान रूप से स्थित है, वही सत्य को देखता है अर्थात् पूर्ण ज्ञानी है"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 28","समम्, पश्यन्, हि, सर्वत्रा, समवस्थितम्, ईश्वरम्।\n" +
                "न, हिनस्ति, आत्मना, आत्मानम्, ततः, याति, पराम्, गतिम्।।28।।","क्योंकि सर्वव्यापक परमेश्वर को सबमें समान रूप से देखकर वह अपने आप को नष्ट नहीं करता अर्थात् आत्मघात नहीं करता। इसके फलस्वरूप वह परमपद/मोक्ष को प्राप्त करता है।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 29","प्रकृत्या, एव, च, कर्माणि, क्रियमाणानि, सर्वशः।\n" +
                "यः, पश्यति, तथा, आत्मानम्, अकर्तारम्, सः, पश्यति।।29।।","और जो भक्त सब कर्मों को सब प्रकार से प्रकृति द्वारा ही होते हुए देखता है और परमात्मा को अकर्ता के रूप में देखता है, वही सत्य को देखता है।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 30","यदा, भूतपृथग्भावम्, एकस्थम्, अनुपश्यति।\n" +
                "ततः, एव, च, विस्तारम्, ब्रह्म, सम्पद्यते तदा।।30।।","जब भक्त जीवों के विविध स्वरूप और विस्तार को देखता है अर्थात् जान लेता है तो एक ईश्वर में स्थित भक्त उस परमेश्वर को ही प्राप्त करता है।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 31","अनादित्वात्, निर्गुणत्वात्, परमात्मा, अयम्, अव्ययः।\n" +
                "शरीरस्थः, अपि, कौन्तेय, न, करोति, न, लिप्यते।।31।।","हे अर्जुन! अनादि होने और उसकी शक्ति निर्गुण होने के कारण यह सनातन परमात्मा शरीर में रहते हुए भी वास्तव में न तो कुछ करता है और न प्रभावित होता है।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 32","यथा, सर्वगतम्, सौक्ष्म्यात्, आकाशम्, न, उपलिप्यते।\n" +
                "सर्वत्रा, अवस्थितः, देहे, तथा, आत्मा, न, उपलिप्यते।।32।।","जैसे सर्वव्यापी आकाश सूक्ष्म होने के कारण कलंकित नहीं होता; इसी प्रकार शरीर में सर्वत्र स्थित आत्मा सहित ईश्वर शरीर के गुणों से दूषित नहीं होते।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 33","यथा, प्रकाशयति, एकः, कृत्स्न्नम्, लोकम्, इमम्, रविः।\n" +
                "क्षेत्राम्, क्षेत्राी, तथा, कृत्स्न्नम्, प्रकाशयति, भारत।।33।।","हे अर्जुन! जैसे एक सूर्य इस सारे ब्रह्माण्ड को प्रकाशित करता है; इसी प्रकार पूर्ण ब्रह्म सारे शरीर अर्थात् ब्रह्मण्ड को प्रकाशित करता है।"));
        list13.add(new GeetaModel("अध्याय 13","गीता श्लोक 34","क्षेत्राक्षेत्राज्ञयोः, एवम्, अन्तरम्, ज्ञानचक्षुषा।\n" +
                "भूतप्रकृतिमोक्षम्, च, ये, विदुः, यान्ति, ते, परम्।।34।।","इस प्रकार जो ज्ञान नेत्रों से अर्थात् तत्वज्ञान से शरीर और ब्रह्म-काल के भेद से परिचित हो जाते हैं, वे जीव प्रकृति अर्थात् माया-अष्टंगी, काल द्वारा छोड़ी गई शक्ति से मुक्ति प्राप्त कर, काल के अतिरिक्त पूर्ण परमात्मा को प्राप्त करते हैं। गीता ज्ञान दाता। गीता अध्याय 13 श्लोक 1-2 में कहा है कि क्षेत्र अर्थात् शरीर को जानने वाला क्षेत्रज्ञ कहलाता है। इसलिए मुझे ही क्षेत्रज्ञ जानो। इससे सिद्ध होता है कि क्षेत्रज्ञ ज्ञान दाता काल अर्थात् ब्रह्म है।"));

    }

    private void addDataToList12() {
        list12.add(new GeetaModel("अध्याय 12","गीता श्लोक 1","एवम्, सततयुक्ताः, ये, भक्ताः, त्वाम्, पर्युपासते,\n" +
                "ये, च, अपि, अक्षरम्, अव्यक्तम्, तेषाम्, के, योगवित्तमाः।।1।।","जो भक्त आपके भजन-ध्यान में निरन्तर संलग्न होकर पूर्वोक्त प्रकार से आपकी पूजा करते हैं तथा जो केवल इन दोनों प्रकार के उपासकों में से नित्य, अदृश्य सच्चिदानन्दघन की ही परम श्रेष्ठ विधि से पूजा करते हैं, जो योग का सर्वोत्तम ज्ञाता अर्थात् योग का ज्ञाता है। भक्ति की विधि को कौन ठीक से जानता है?"));
        list12.add(new GeetaModel("अध्याय 12","गीता श्लोक 2","मयि, आवेश्य, मनः, ये, माम्, नित्ययुक्ताः, उपासते,\n" +
                "श्रद्धया, परया, उपेताः, ते, मे, युक्ततमाः, मताः।।2।।","जो भक्त मन को मुझमें एकाग्र करके निरंतर मेरे भजन-ध्यान में लीन रहते हैं, वे परम श्रद्धा से मेरी पूजा करते हैं, मैं उन्हें उपासकों में सर्वश्रेष्ठ मानता हूँ। ये मेरा विचार हे।"));
        list12.add(new GeetaModel("अध्याय 12","गीता श्लोक 3,4","ये, तु, अक्षरम्, अनिर्देश्यम्, अव्यक्तम्, पर्युपासते,\n" +
                "सर्वत्रागम्, अचिन्त्यम्, च, कूटस्थम्, अचलम्, ध्रुवम्।।3।।\n" +
                "\n" +
                "सन्नियम्य, इन्द्रियग्रामम्, सर्वत्रा, समबुद्धयः,\n" +
                "ते, प्राप्नुवन्ति, माम्, एव, सर्वभूतहिते, रताः।।4।।","परन्तु जो मन-बुद्धि से परे, सर्वव्यापक, नित्य एकरूप, नित्य, अपरिवर्तनशील, अदृश्य और अमर हैं, उन सब इन्द्रियों को ठीक प्रकार से संयमित करके एकनिष्ठ भक्ति से निरंतर उनकी पूजा करते हैं, वे समस्त प्राणियों के कल्याण में लगे रहते हैं, सबके प्रति समभाव रखते हुए, मेरे पास अकेले आओ।"));

        list12.add(new GeetaModel("अध्याय 12","गीता श्लोक 5","क्लेशः, अधिकतरः, तेषाम्, अव्यक्तासक्तचेतसाम्,\n" +
                "अव्यक्ता, हि, गतिः, दुःखम्, देहवद्भिः, अवाप्यते।।5।।","जो मनुष्य अदृश्य ब्रह्म में लीन हैं, उनकी साधना में मुख्य रूप से वाद-विवाद अर्थात् क्लेश होता है, क्योंकि अव्यक्त की स्थिति अभिमानी प्राणियों को बड़ी कठिनाई से प्राप्त होती है।"));
        list12.add(new GeetaModel("अध्याय 12","गीता श्लोक 6","ये, तु, सर्वाणि, कर्माणि, मयि, सóयस्य, मत्पराः,\n" +
                "अनन्येन, एव, योगेन, माम्, ध्यायन्तः, उपासते।।6।।","परन्तु वे मतावलम्बी भक्त जो मुझमें समर्पित हैं, जो अपने समस्त कर्मों को मुझमें समर्पित करके अनन्य भाव से मेरे विचारों में निरन्तर लीन रहकर केवल मुझ गुणों वाले प्रभु की ही पूजा करते हैं।"));
        list12.add(new GeetaModel("अध्याय 12","गीता श्लोक 7","तेषाम्, अहम्, समुद्धत्र्ता, मृत्युसंसारसागरात्,\n" +
                "भवामि, नचिरात्, पार्थ, मयि, आवेशितचेतसाम्।।7।","\n" +
                "हे अर्जुन! उन प्यारे भक्तों के लिए जो अपने मन को मुझमें समाहित करते हैं, मैं जल्द ही इस मृत्यु के सागर की दुनिया से तारणहार बन जाता हूं।"));
        list12.add(new GeetaModel("अध्याय 12","गीता श्लोक 8","मयि, एव, मनः, आधत्स्व, मयि, बुद्धिम् निवेशय,\n" +
                "निवसिष्यसि, मयि, एव, अतः, ऊध्र्वम्, न, संशयः।।8।।","अपने मन को मुझमें स्थिर करो और अपनी बुद्धि को केवल मुझमें लगाओ। इसके बाद तुम मुझमें ही निवास करोगे। इसमें कोई संदेह नहीं है।"));
        list12.add(new GeetaModel("अध्याय 12","गीता श्लोक 9","अथ, चित्तम्, समाधातुम्, न, शक्नोषि, मयि, स्थिरम्,\n" +
                "अभ्यासयोगेन, ततः, माम्, इच्छ, आप्तुम्, धन×जय।। 9।।\n" +
                "\n","यदि तुम अपने चित्त को मुझमें स्थिर करने में समर्थ नहीं हो, तो हे अर्जुन, अभ्यास योग द्वारा मुझे प्राप्त करने का प्रयत्न करो।"));
        list12.add(new GeetaModel("अध्याय 12","गीता श्लोक 10","अभ्यासे, अपि, असमर्थः, असि, मत्कर्मपरमः, भव,\n" +
                "मदर्थम्, अपि, कर्माणि, कुर्वन्, सिद्धिम्, अवाप्स्यसि।।10।।","यदि तुम साधना करने में भी समर्थ नहीं हो तो ही मेरे लिए शास्त्रों के अनुसार पुण्य कर्म करो। मेरे लिए कर्म करने से भी तुम लक्ष्य को प्राप्त करोगे।"));
        list12.add(new GeetaModel("अध्याय 12","गीता श्लोक 11","अथ, एतत्, अपि, अशक्तः, असि, कर्तुम्, मद्योगम्, आश्रितः,\n" +
                "सर्वकर्मफलत्यागम्, ततः, कुरु, यतात्मवान्।।11।।","यदि आप भी मेरे मतानुसार कर्मयोग का आश्रय लेकर उपरोक्त विधि का पालन करने में असमर्थ हैं तो सब कर्मों के फल का त्याग करके प्रयत्न करें।\n"));
        list12.add(new GeetaModel("अध्याय 12","गीता श्लोक 12","श्रेयः, हि, ज्ञानम्, अभ्यासात्, ज्ञानात्, ध्यानम्, विशिष्यते,\n" +
                "ध्यानात्, कर्मफलत्यागः, त्यागात्, शान्तिः, अनन्तरम्।।12।।\n" +
                "\n","तत्वज्ञान के अभाव में शास्त्रविधि को त्याग कर किये गये मनमाना अभ्यास (अभ्यास) से ज्ञान (ज्ञान) श्रेष्ठ है। जो शास्त्रों में वर्णित साधना न करके केवल ज्ञान प्राप्त करके ही विद्वान के रूप में प्रसिद्ध हो जाता है, उसके ज्ञान की तुलना में सहज ध्यान अर्थात् सहज समाधि श्रेष्ठ है। तथा ध्यान की तुलना में कर्मों के फल का त्याग कर नाम जप श्रेष्ठ है। क्योंकि कर्मों के फल का त्याग करके भक्ति करने से उस यज्ञ से तत्काल शान्ति प्राप्त होती है।"));
        list12.add(new GeetaModel("अध्याय 12","गीता श्लोक 13,14","अद्वेष्टा, सर्वभूतानाम्, मैत्राः, करुणः, एव, च,\n" +
                "निर्ममः, निरहंकारः, समदुःखसुखः, क्षमी।।13।।\n" +
                "\n" +
                "सन्तुष्टः, सततम्, योगी, यतात्मा, दृढनिश्चयः,\n" +
                "मयि, अर्पितमनोबुद्धिः, यः, मद्भक्तः, सः, मे, प्रियः।।14।।","जो समस्त प्राणियों के प्रति द्वेष रहित, मैत्रीपूर्ण और करुणामय है तथा ममता और अहंकार से रहित है, सुख-दुःख में सन्तुलित है और क्षमाशील है, वह योगी सदैव सन्तुष्ट रहता है। दोषों से रहित अर्थात् मन और इन्द्रियों सहित शरीर को वश में करने वाला, मन-बुद्धि से मुझे समर्पित मेरा वह भक्त, जो नियम के अनुसार भक्ति करता है, मुझे प्रिय है।\n"));

        list12.add(new GeetaModel("अध्याय 12","गीता श्लोक 15","यस्मात्, न, उद्विजते, लोकः, लोकात्, न, उद्विजते, च, यः,\n" +
                "हर्षामर्षभयोद्वेगैः, मुक्तः, यः, सः, च, मे, प्रियः।।15।।","जिससे कोई जीव व्याकुल नहीं होता और जो स्वयं किसी जीव से उद्वेलित नहीं होता तथा जो हर्ष, द्वेष, भय और चिन्ता आदि से रहित है, वह भक्त मुझे प्रिय है।"));
        list12.add(new GeetaModel("अध्याय 12","गीता श्लोक 16","अनपेक्षः, शुचिः, दक्षः, उदासीनः, गतव्यथः,\n" +
                "सर्वारम्भपरित्यागी, यः, मद्भक्तः, सः, मे, प्रियः।।16।।","जो कामनाओं से रहित है, भीतर और बाहर से पवित्र, चतुर, निष्पक्ष और दुखों से मुक्त है, जिसने सभी प्रारंभों को त्याग दिया है अर्थात् जिसने शास्त्रों के आदेशों के विरुद्ध सभी कार्यों को शुरू किया है, उन्हें त्याग दिया है जो शास्त्रों के आदेशों के अनुसार कार्य करता है वह मतानुसार मेरा भक्त मुझे प्रिय है।"));
        list12.add(new GeetaModel("अध्याय 12","गीता श्लोक 17","यः, न, हृष्यति, न, द्वेष्टि, न, शोचति, न, काङ्क्षति,\n" +
                "शुभाशुभपरित्यागी, भक्तिमान्, यः, सः, मे, प्रियः।।17।।","जो न हर्षित होता है, न द्वेष करता है, न शोक करता है, न लालसा करता है और जो समस्त शुभ-अशुभ कर्मों का परित्याग कर देता है, वह भक्तियुक्त पुरुष मुझे प्रिय है।"));
        list12.add(new GeetaModel("अध्याय 12","गीता श्लोक 18","\n" +
                "समः, शत्रौ, च, मित्रो, च, तथा, मानापमानयोः,\n" +
                "शीतोष्णसुखदुःखेषु, समः, संगविवर्जितः।।18।।","जो मित्र और शत्रु में, मान और अपमान में समान है, गर्मी-सर्दी और सुख-दुःख आदि में समान है और अनासक्त है।"));
        list12.add(new GeetaModel("अध्याय 12","गीता श्लोक 19","तुल्यनिन्दास्तुतिः, मौनी, सन्तुष्टः, येन, केनचित्,\n" +
                "अनिकेतः, स्थिरमतिः, भक्तिमान्, मे, प्रियः, नरः।।19।।","जो निन्दा और स्तुति को एक समान समझता है, मौन रहता है और जो कुछ भी उसके पास आता है उसी में सन्तुष्ट रहता है, राग-द्वेष से रहित वह स्थिर मन वाला भक्त मुझे प्रिय है।"));
        list12.add(new GeetaModel("अध्याय 12","गीता श्लोक 20","ये, तु, धम्र्यामृतम्, इदम्, यथा, उक्तम्, पर्युपासते,\n" +
                "श्रद्दधानाः, मत्परमाः, भक्ताः, ते, अतीव, मे, प्रियाः।।20।।","परन्तु जो श्रध्दालु पुरुष शास्त्रानुकूल साधना में रत होकर मुझ से श्रेष्ठ परमात्मा को पूर्ण श्रद्धा से भजते हैं, यह उपर्युक्त धर्म अमृत है, वे भक्त मुझे अत्यंत प्रिय हैं।"));
    }

    private void addDataToList11() {
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 1","मदनुग्रहाय, परमम्, गुह्यम्, अध्यात्मस×िज्ञतम्,\n" +
                "यत्, त्वया, उक्तम्, वचः, तेन, मोहः, अयम्, विगतः, मम।।1।।","शास्त्रानुकूल मत, परम गुह्य आध्यात्मिक वचन अर्थात् आपने कृपा बरसाने के लिए जो उपदेश दिया है, उससे मेरा यह मोह नष्ट हो गया है।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 2","भवाप्ययौ, हि, भूतानाम्, श्रुतौ, विस्तरशः, मया,\n" +
                "त्वत्तः, कमलपत्राक्ष, माहात्म्यम्, अपि, च, अव्ययम्।।2।।","क्योंकि हे कमल-नयन! मैंने आपसे जीवों की उत्पत्ति और विनाश को विस्तार से सुना है और आपकी अमर महिमा भी सुनी है।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 3","एवम्, एतत्, यथा, आत्थ, त्वम्, आत्मानम्, परमेश्वर,\n" +
                "द्रष्टुम्, इच्छामि, ते, रूपम्, ऐश्वरम्, पुरुषोत्तम।।3।।","हे परम प्रभु! यह ठीक वैसा ही है जैसा आप स्वयं का वर्णन करते हैं, लेकिन हे पुरुषोत्तम! मैं ज्ञान, ऐश्वर्य, शक्ति, बल, तेज और तेज से युक्त आपके दिव्य रूप को अपनी आँखों से देखना चाहता हूँ।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 4","मन्यसे, यदि, तत्, शक्यम्, मया, द्रष्टुम्, इति, प्रभो,\n" +
                "योगेश्वर, ततः, मे, त्वम्, दर्शय, आत्मानम्, अव्ययम्।।4।।\n" +
                "\n","हे प्रभो! यदि आप समझते हैं कि मैं आपके उस रूप को देख सकता हूं तो हे योगेश्वर, वह वास्तविक अविनाशी रूप मुझे दिखाइए।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 5","पश्य, मे, पार्थ, रूपाणि, शतशः, अथ, सहस्त्राशः,\n" +
                "नानाविधानि, दिव्यानि, नानावर्णाकृतीनि, च।।5।।","ओह पार्थ! अब आप मेरे विभिन्न प्रकार, रंगों और आकृतियों के सैकड़ों और हजारों दिव्य रूपों को देखें।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 6","पश्य, आदित्यान्, वसून्, रुद्रान्, अश्विनौ, मरुतः, तथा,\n" +
                "बहूनि, अदृष्टपूर्वाणि, पश्य, आश्चर्याणि, भारत।।6।।","हे भारतवंशी अर्जुन! मुझमें आदित्यों अर्थात् अदिति के बारह पुत्रों, आठ वसुओं, एकादश रुद्रों, दो अश्विनी कुमारों और उनतालीस मरुद्रणों को देखो तथा अन्य अनेक अद्भुत रूपों को भी देखो, जो पहले कभी नहीं देखे गए।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 7","इह, एकस्थम्, जगत्, कृृत्स्न्नम्, पश्य, अद्य, सचराचरम्,\n" +
                "मम, देहे, गुडाकेश, यत्, च, अन्यत्, द्रष्टुम्, इच्छसि।।7।।","हे अर्जुन! अब मेरे इस शरीर में एक स्थान पर स्थित चर और अचर सहित समस्त ब्रह्मांड को देखें और जो कुछ भी आप देखना चाहते हैं उसे देखें।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 8","न, तु, माम्, शक्यसे, द्रष्टुम्, अनेन, एव, स्वचक्षुषा,\n" +
                "दिव्यम्, ददामि, ते, चक्षुः, पश्य, मे, योगम्, ऐश्वरम्।।8।।","लेकिन आप निश्चित रूप से मुझे अपनी इन स्वाभाविक आँखों से देखने में असमर्थ हैं। इसलिए मैं तुम्हें दिव्य अर्थात् अलौकिक दृष्टि प्रदान करता हूँ; इसके साथ मेरी योग की दिव्य शक्ति को देखें।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 9","एवम्, उक्त्वा, ततः, राजन्, महायोगेश्वरः, हरिः,\n" +
                "दर्शयामास, पार्थाय, परमम्, रूपम्, ऐश्वरम्।।9।।","हे राजा! इतना कहकर महायोगेश्वर भगवान ने अर्जुन को परम दिव्य रूप दिखाया।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 10,11","अनेकवक्त्रानयनम्, अनेकाद्भुतदर्शनम्,\n" +
                "अनेकदिव्याभरणम्, दिव्यानेकोद्यतायुधम्।।10।।\n" +
                "\n" +
                "दिव्यमाल्याम्बरधरम्, दिव्यगन्धानुलेपनम्,\n" +
                "सर्वाश्चर्यमयम्, देवम्, अनन्तम्, विश्वतोमुखम्।।11।।","अर्जुन ने भगवान के विराट रूप को देखा, जिसमें कई मुंह और आंखें थीं, कई अद्भुत दृश्य प्रस्तुत कर रहे थे, कई दिव्य आभूषणों से विभूषित थे और हाथों में उठाए गए कई दिव्य हथियार, स्वर्ग की माला और वस्त्र पहने हुए थे और पूरे शरीर में दिव्य सुगंध बिखेर रहे थे। तरह-तरह के चमत्कार, असीमित और सभी दिशाओं में चेहरों के साथ।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 12","दिवि, सूर्यसहस्त्रास्य, भवेत्, युगपत्, उत्थिता,\n" +
                "यदि, भाः, सदृशी, सा, स्यात्, भासः, तस्य, महात्मनः।।12।।","आकाश में यदि हजारों सूर्य एक साथ उदय हों, तो उनका तेज भी उस ईश्वर के तेज के समान हो सकता है।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 13","तत्र, एकस्थम्, जगत्, कृृत्स्न्नम्, प्रविभक्तम्, अनेकधा,\n" +
                "अपश्यत्, देवदेवस्य, शरीरे, पाण्डवः, तदा।।13।।","उस समय पाण्डुपुत्र अर्जुन ने देवों के देव भगवान श्री कृष्ण के उस शरीर में समस्त सृष्टि को अनेक प्रकार से विभाजित होकर एक ही स्थान पर स्थित देखा।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 14","ततः, सः, विस्मयाविष्टः, हृष्टरोमा, धन×जयः,\n" +
                "प्रणम्य, शिरसा, देवम्, कृृता×जलिः, अभाषत।। 14।।","तत्पश्चात् वह अर्जुन विस्मय से चकित और पुलकित शरीर से काल भगवान को सिर नवाकर हाथ जोड़कर बोला।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 15","पश्यामि, देवान्, तव, देव, देहे, सर्वान्, तथा, भूतविशेषसंघान्, ब्रह्माणम्,\n" +
                "ईशम्, कमलासनस्थम्, ऋषीन्, च, सर्वान्, उरगान्, च, दिव्यान्।।15।।","हे प्रभो! मैं आपके शरीर में सभी देवताओं और विभिन्न जीवों को, कमल-पुष्प के आसन पर बैठे ब्रह्मा, महादेव (शिव) और सभी ऋषियों और दिव्य नागों को देखता हूं।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 16","अनेकबाहूदरवक्त्रानेत्राम्, पश्यामि, त्वाम्, सर्वतः, अनन्तरूपम्, न, अन्तम्,\n" +
                "न, मध्यम्, न, पुनः, तव, आदिम्, पश्यामि, विश्वेश्वर, विश्वरूप।।16।।","हे अखिल ब्रह्मांड के स्वामी! मैं आपको अनेक भुजाओं, पेटों, मुखों और नेत्रों से युक्त तथा सब ओर से असीमित रूपों में देखता हूँ। हे विश्वरूप (सार्वभौमिक रूप वाले)! न मैं तुम्हारा अंत देखता हूं, न मध्य और न ही आदि।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 17","किरीटिनम्, गदिनम्, चक्रिणम्, च, तेजोराशिम्, सर्वतः, दीप्तिमन्तम्,\n" +
                "पश्यामि, त्वाम्, दुर्निरीक्ष्यम्, समन्तात्, दीप्तानलार्कद्युतिम्, अप्रमेयम्।।17।।","मैं आपको मुकुट, गदा और चक्र के साथ और चारों ओर से दीप्तिमान एक पुंज के रूप में देखता हूं, जिसमें एक प्रज्वलित अग्नि और सूर्य के समान तेज है, देखने में कठिन और सभी दिशाओं में एक अतुलनीय रूप है।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 18","त्वम्, अक्षरम्, परमम्, वेदितव्यम्, त्वम्, अस्य, विश्वस्य, परम्, निधानम्, त्वम्,\n" +
                "अव्ययः, शाश्वतधर्मगोप्ता, सनातनः, त्वम्, पुरुषः, मतः, मे।।18।।","आप ही परम अक्षर अर्थात् परब्रह्म परमात्मा जानने योग्य हैं। आप ही इस ब्रह्मांड की परम शरण हैं। आप ही सनातन धर्म (धार्मिकता) के रक्षक हैं और आप ही अमर आदिदेव हैं। ये मेरा विचार हे।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 19","अनादिमध्यान्तम्, अनन्तवीर्यम्, अनन्तबाहुम्, शशिसूर्यनेत्राम्,\n" +
                "पश्यामि, त्वाम्, दीप्तहुताशवक्त्राम्, स्वतेजसा, विश्वम्, इदम्, तपन्तम्।।19।।","मैं आपको अनादि, अन्त और मध्य से रहित, असीम शक्ति से युक्त, असीमित भुजाओं वाले, सूर्य और चन्द्रमा के समान नेत्रों वाले, प्रज्वलित अग्नि के समान मुख वाले और अपने तेज से इस ब्रह्मांड को झुलसा देने वाले देखता हूं।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 20","द्यावापृृथिव्योः, इदम्, अन्तरम्, हि, व्याप्तम्, त्वया, एकेन, दिशः, च, सर्वाः,\n" +
                "दृष्टवा, अद्भुतम्, रूपम्, उग्रम्, तव, इदम्, लोकत्रायम्, प्रव्यथितम्, महात्मन्।। 20।।","हे महात्मन! स्वर्ग और पृथ्वी के बीच का यह सारा आकाश और सभी दिशाएँ एक आप ही से व्याप्त हैं और आपके इस अद्भुत और भयानक रूप को देखकर तीनों लोक बहुत व्याकुल हो रहे हैं।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 21","\n" +
                "अमी, हि, त्वाम्, सुरसंघा, विशन्ति, केचित्, भीताः।\n" +
                "प्राजलयः, ग ृृणन्ति, स्वस्ति, इति, उक्त्वा, महर्षिसिद्धसंघाः,\n" +
                "स्तुवन्ति, त्वाम्, स्तुतिभिः, पुष्कलाभिः।।21।।","देवताओं के वे समूह आपके भीतर प्रवेश करते हैं और कुछ डर के मारे हाथ जोड़कर जप करते हैं, और महर्षियों और सिद्धों के समूह यह कहकर - 'कल्याण हो! तब भी तुम उन्हें खा रहे हो।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 22","रुद्रादित्याः, वसवः, ये, च, साध्याः, विश्वे, अश्विनौ, मरुतः, च, ऊष्मपाः,\n" +
                "च, गन्धर्वयक्षासुरसिद्धसंघाः, वीक्षन्ते, त्वाम्, विस्मिताः, च, एव, सर्वे।।22।।","ग्यारह रुद्र और बारह आदित्य और आठ वसु, उपासक, विश्वेदेव, अश्विनी कुमार और मरुत और पितर और गन्धर्वों के यक्ष, यक्ष, दैत्य और सिद्धों के यजमान, वे सभी आपको विस्मय से देखते हैं।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 23","रूपम्, महत्, ते, बहुवक्त्रानेत्राम्, महाबाहो, बहुबाहूरुपादम्,\n" +
                "बहूदरम्, बहुदंष्ट्राकरालम्, दृृष्टवा, लोकाः, प्रव्यथिताः, तथा, अहम्।।23।।","हे महाबाहु! अनेक मुखों और नेत्रों वाले, अनेक हाथों, जंघाओं और पांवों वाले, अनेक पेटों वाले और अनेक दांतों वाले आपके अत्यंत भयानक विराट रूप को देखकर सभी लोग भयभीत हो रहे हैं और मैं भी।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 24","नभःस्पृृशम्, दीप्तम्, अनेकवर्णम्, व्यात्ताननम्, दीप्तविशालनेत्राम्,\n" +
                "दृष्टवा, हि, त्वाम्, प्रव्यथितान्तरात्मा, धृृतिम्, न, विन्दामि, शमम्, च, विष्णो।।24।।","क्योंकि हे विष्णु! आकाश को छूते हुए, प्रज्वलित, अनेक रंगों वाले, खुले मुंह वाले और बड़े-बड़े चमकदार नेत्रों वाले आपको देखकर मैं भयभीत अंतर्मन से शांत और स्थिर नहीं हो रहा हूं।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 25","दंष्ट्राकरालानि, च, ते, मुखानि, दृष्टवा, एव, कालानलसन्निभानि,\n" +
                "दिशः, न, जाने, न, लभे, च, शर्म, प्रसीद, देवेश, जगन्निवास।।25।।","तुम्हारे भयानक दाँतों से युक्त मुख और विश्व विनाश की अग्नि के समान दहकते हुए देखकर मैं दिशाहीन हो गया हूँ और मुझे कोई सुख भी नहीं हो रहा है। इसलिए हे देवेश (देवताओं के देव)! हे ब्रह्मांड के धाम! कृपया प्रसन्न हों।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 26,27","अमी, च, त्वाम्, धृतराष्ट्रस्य, पुत्राः, सर्वे, सह, एव, अवनिपालसंघैः,\n" +
                "भीष्मः, द्रोणः, सूतपुत्राः, तथा, असौ, सह, अस्मदीयैः, अपि, योधमुख्यैः।।26।।\n" +
                "\n" +
                "वक्त्राणि, ते, त्वरमाणाः, विशन्ति, दंष्ट्राकरालानि, भयानकानि, केचित्,\n" +
                "विलग्नाः, दशनान्तरेषु, संदृश्यन्ते, चूर्णितैः, उत्तमांगैः।।27।।","धृतराष्ट्र के वे सभी पुत्र राजाओं की सेना सहित आपके भीतर प्रवेश कर रहे हैं और भीष्म पितामह, द्रोणाचार्य और कर्ण सहित हमारे पक्ष के प्रमुख योद्धा, सभी भयानक दांतों के साथ आपके भयानक मुंह में तेजी से दौड़ रहे हैं। कुछ को आपके दांतों के बीच फंसा देखा जा सकता है और उनके सिर कुचले हुए हैं।"));

        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 28","यथा, नदीनाम्, बहवः, अम्बुवेगाः, समुद्रम्, एव, अभिमुखाः, द्रवन्ति, तथा,\n" +
                "तव, अमी, नरलोकवीराः, विशन्ति, वक्त्राणि, अभिविज्वलन्ति।।28।।","जिस प्रकार नदियों की नाना प्रकार की जलधाराएँ वेग से समुद्र की ओर दौड़ती हैं अर्थात् समुद्र में समा जाती हैं; इसी प्रकार मनुष्यलोक के वे वीर अर्थात् पृथ्वी भी आपके प्रज्वलित मुखों में प्रवेश कर रहे हैं।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 29","यथा, प्रदीप्तम्, ज्वलनम्, पतंगाः, विशन्ति, नाशाय, समृद्धवेगाः,\n" +
                "तथा, एव, नाशाय, विशन्ति, लोकाः, तव, अपि, वक्त्राणि, समृद्धवेगाः।।29।।","जिस प्रकार पतिंगे मोहवश अपने विनाश के लिए प्रज्वलित अग्नि में बड़े वेग से दौड़ते हैं; वैसे ही ये सब लोग भी बड़े वेग से तुम्हारे मुंह में अपना विनाश करने को दौड़ रहे हैं।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 30","लेलिह्यसे, ग्रसमानः, समन्तात्, लोकान्, समग्रान्, वदनैः, ज्वलद्भिः,\n" +
                "तेजोभिः, आपूर्य, जगत्, समग्रम्, भासः, तव, उग्राः, प्रतपन्ति, विष्णो।।30।।","तुम अपने प्रज्वलित मुखों से समस्त लोकों को भस्म कर रहे हो, तुम बार-बार सब ओर से उन्हें चाट रहे हो। हे विष्णु ! आपका भयानक प्रकाश पूरे ब्रह्मांड को अपने तेज से भरकर झुलसा रहा है।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 31","आख्याहि, मे, कः, भवान्, उग्ररूपः, नमः, अस्तु, ते, देववर, प्रसीद, विज्ञातुम्,\n" +
                "इच्छामि, भवन्तम्, आद्यम्, न, हि, प्रजानामि, तव, प्रवृत्तिम्।।31।।","बताओ तुम इस भयानक रूप में कौन हो? हे देवों में श्रेष्ठ ! मैंने आपको प्रणाम करता हूँ। कृपालु बनो! आदि यम अर्थात् आदिकाल मैं विशेष रूप से आपको जानना चाहता हूँ क्योंकि मैं आपके स्वभाव को नहीं जानता।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 32","कालः, अस्मि, लोकक्षयकृृत्, प्रवृृद्धः, लोकान्, समाहर्तुम्, इह, प्रवृृत्तः,\n" +
                "ऋते, अपि, त्वाम्, न, भविष्यन्ति, सर्वे, ये, अवस्थिताः, प्रत्यनीकेषु, योधाः।।32।।","मैं बढ़ा हुआ काल हूँ, लोकों का नाश करने वाला। इस बार मैं इन लोकों को नष्ट करने के लिए प्रकट हुआ हूँ; इसलिए विपरीत सेना में स्थित सभी योद्धा आपके बिना भी जीवित नहीं रहेंगे अर्थात यदि आप युद्ध नहीं करते हैं तो भी वे सब नष्ट हो जाएंगे।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 33","तस्मात्, त्वम्, उत्तिष्ठ, यशः, लभस्व, जित्वा, शत्राून्,\n" +
                "भुङ्क्ष्व, राज्यम्, समृद्धम्, मया, एव, एते, निहताः,\n" +
                "पूर्वम्, एव, निमित्तमात्राम्, भव, सव्यसाचिन्।33।।","इसलिए तुम खड़े हो जाओ! कीर्ति प्राप्त करो और शत्रुओं को जीतकर धन और अन्न से सम्पन्न राज्य का उपभोग करो। ये सब योद्धा मेरे द्वारा पहले ही मारे जा चुके हैं। ओह सव्यसाचिन! तुम निमित्त मात्र बनो"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 34","द्रोणम्, च, भीष्मम्, च, जयद्रथम्, च, कर्णम्, तथा, अन्यान्, अपि, योधवीरान्,\n" +
                "मया, हतान्, त्वम्, जहि, मा, व्यथिष्ठाः, युध्यस्व, जेतासि, रणे, सपत्नान्।।34।।","तुम द्रोणाचार्य और भीष्म पितामह और जयद्रथ और कर्ण को मार डालो और मेरे द्वारा पहले से ही मारे गए कई अन्य वीर योद्धाओं को भी। डरो मत। आप युद्ध में शत्रुओं पर विजय प्राप्त करेंगे; इसलिए लड़ो।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 35","एतत्, श्रुत्वा, वचनम्, केशवस्य, कृृता×जलिः, वेपमानः, किरीटी, नमस्क ृत्वा,\n" +
                "भूयः, एव, आह, कृृष्णम्, सग०दम्, भीतभीतः, प्रणम्य।।35।।","केशव भगवान् के इन वचनों को सुनकर मुकुटधारी अर्जुन ने काँपते हुए, हाथ जोड़कर प्रणाम किया, फिर भी अत्यन्त भयभीत होकर, सिर झुकाकर, लड़खड़ाती वाणी में श्रीकृष्ण से कहा।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 36","स्थाने, हृषीकेश, तव, प्रकीत्र्या, जगत्, प्रहृष्यति, अनुरज्यते, च,\n" +
                "रक्षांसि, भीतानि, दिशः, द्रवन्ति, सर्वे, नमस्यन्ति, च, सिद्धसंघाः।।36।।","हे सर्वज्ञ! यह सत्य ही है कि आपके नाम, गुण और शक्ति की महिमा से जगत् हर्षित हो रहा है और प्रेम से भी भर रहा है और भयभीत राक्षस चारों दिशाओं में दौड़ रहे हैं और यजमान सब सिद्धों को नमस्कार कर रहे हैं।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 37","कस्मात्, च, ते, न, नमेरन्, महात्मन्, गरीयसे, ब्रह्मणः,\n" +
                "अपि, आदिकत्र्रो, अनन्त, देवेश, जगन्निवास,\n" +
                "त्वम्, अक्षरम्, सत्, असत्, तत्परम्, यत्।।37।।","हे महात्मन! आप सर्वशक्तिमान ईश्वर हैं, मूल निर्माता और महानतम भी हैं। वे आपको क्यों न नमन करें क्योंकि हे (अनंत) अनंत होने के नाते! हे (देवेश) देवों के देव! हे (जगन्निवस) जगत के शरण, जो व्यक्त और अव्यक्त है और उनसे भी परे अक्षर अर्थात् सच्चिदानंदघन ब्रह्म है, वही तू ही है।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 38","त्वम्, आदिदेवः, पुरुषः, पुराणः, त्वम्, अस्य, विश्वस्य,\n" +
                "परम्, निधानम्, वेत्ता, असि, वेद्यम्, च, परम्, च,\n" +
                "धाम, त्वया, ततम्, विश्वम्, अनन्तरूप।।38।।","आप ही आदि देव हैं, सनातन देव हैं। आप इस ब्रह्मांड की परम शरण हैं, ज्ञाता और जानने योग्य हैं, और परम धाम हैं। हे अनंत रूपों वाले! यह सारा जगत आपसे व्याप्त है।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 39","वायुः, यमः, अग्निः, वरुणः, शशांक, प्रजापतिः, त्वम्, प्रपितामहः, च,\n" +
                "नमः, नमः, ते, अस्तु, सहस्त्राकृत्वः, पुनः, च, भूयः, अपि, नमः, नमः, ते।। ृ 39।।","आप वायु, यमराज, अग्नि, वरुण, चन्द्रमा, जीवों के स्वामी, ब्रह्मा और ब्रह्मा के पिता भी हैं। आपको कोटि कोटि नमन ! सलाम! पुनः आपको बारंबार प्रणाम ! सलाम!"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 40","नमः, पुरस्तात्, अथ, पृष्ठतः, ते, नमः, अस्तु, ते, सर्वतः, एव, सर्व,\n" +
                "अनन्तवीर्य, अमितविक्रमः, त्वम्, सर्वम्, समाप्नोषि, ततः, असि, सर्वः।।40।।","हे असीमित शक्ति वाले! आपको आगे से भी प्रणाम और पीछे से भी। हे विश्वात्मा! आपको सभी ओर से नमस्कार है क्योंकि हे असीमित पराक्रम वाले, आप संपूर्ण ब्रह्मांड को व्याप्त कर रहे हैं। इसलिए आप सब हैं।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 41,42","सखा, इति, मत्वा, प्रसभम्, यत्, उक्तम्, हे कृष्ण, हे यादव, हे सखे,\n" +
                "इति, अजानता, महिमानम्, तव, इदम्, मया, प्रमादात्, प्रणयेन, वा, अपि।।41।।\n" +
                "\n" +
                "यत्, च, अवहासार्थम्, असत्कृतः, असि, विहारशय्यासनभोजनेषु,\n" +
                "एकः, अथवा, अपि, अच्युत, तत्समक्षम्, तत्, क्षामये, त्वाम्, अहम्, अप्रमेयम्।।42।।","तेरी इस शक्ति/गौरव से अनभिज्ञ, तुझे अपना मित्र समझकर, दीवानगी में या प्रेम में भी, हे कृष्ण, हे यादव, हे मित्र, इस प्रकार मैंने बिना सोचे-समझे जो कुछ भी कहा है, और हे अच्युत, आपने मेरा अपमान किया है खेलते समय मनोरंजन में, बिस्तर पर लेटे हुए और भोजन के समय या तो अकेले या उन दोस्तों के सामने भी; हे अचिन्त्य शक्ति/महिमा वाले, मैं आपसे उन सभी अपराधों के लिए क्षमा माँगता हूँ।"));

        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 43","पिता, असि, लोकस्य, चराचरस्य, त्वम्, अस्य, पूज्यः, च, गुरुः, गरीयान्,\n" +
                "न, त्वत्समः, अस्ति, अभ्यधिकः, कुतः, अन्यः, लोकत्राये, अपि, अप्रतिमप्रभाव।।43।।","आप इस चर और अचल संसार के पिता और सबसे बड़े गुरु और सबसे पूजनीय हैं। हे अतुलनीय शक्ति वाले! तीनों लोकों में आपके समान कोई नहीं है तो आपसे बड़ा कोई कैसे हो सकता है?"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 44","तस्मात्, प्रणम्य, प्रणिधाय, कायम्, प्रसादये, त्वाम्, अहम्, ईशम्, ईड्यम्,\n" +
                "पिता, इव, पुत्रास्य, सखा, इव, सख्युः, प्रियः, प्रियायाः, अर्हसि, देव, सोढुम्।।44।।","इसलिए हे भगवान! मैं अपने शरीर को पूर्ण रूप से आपके चरणों में अर्पित कर (आपके सामने प्रणाम करते हुए) श्रद्धापूर्वक प्रणाम करके आप पूज्य भगवान से विनती करता हूँ कि आप कृपा करें। हाय भगवान्! जिस प्रकार एक पिता पुत्र के, मित्र के मित्र के और प्रिय पत्नी के पति के अपराध को सहन करता है; वैसे ही तुम भी मेरे अपराध सहने के योग्य हो।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 45","अदृष्टपूर्वम्, हृषितः, अस्मि, दृष्टवा, भयेन, च, प्रव्यथितम्, मनः,\n" +
                "मे, तत्, एव, मे, दर्शय, देवरूपम्, प्रसीद, देवेश, जगन्निवास।।45।।","आपके इस अनुपम रूप को, जो पहले कभी नहीं देखा गया था, देखकर मुझे हर्ष हो रहा है और मेरा मन भी भय से व्याकुल हो रहा है; इसलिए आप ही मुझे अपना वह चतुर्भुज विष्णु-रूप दिखाइए। हे देवों के देव! हे ब्रह्माण्ड के आश्रय ! कृपा होगी।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 46","किरीटिनम्, गदिनम्, चक्रहस्तम्, इच्छामि, त्वाम्, द्रष्टुम्, अहम्,\n" +
                "तथा, एव, तेन, एव, रूपेण, चतुर्भुजेन, सहस्रबाहो, भव, विश्वमूर्ते।।46।।","मैं आपको पहले की तरह मुकुट से विभूषित और हाथ में गदा और चक्र लिए हुए देखना चाहता हूं। हे विश्व रूप! हे हजार भुजाओं वाले! आप उसी चतुर्भुज (चतुर्भुज) रूप में प्रकट होते हैं।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 47","मया, प्रसन्नेन, तव, अर्जुन, इदम्, रूपम्, परम्, दर्शितम्, आत्मयोगात्,\n" +
                "तेजोमयम्, विश्वम्, अनन्तम्, आद्यम्, यत्, मे, त्वदन्येन, न, दृष्टपूर्वम्।।47।।","हे अर्जुन! मैंने तुम पर प्रसन्न होकर अपने योगबल से अपना यह परम तेजोमय, आदि और असीम विराट रूप तुम्हें दिखाया है, जिसे तुम्हारे अतिरिक्त और किसी ने नहीं देखा था।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 48","न, वेदयज्ञाध्ययनैः, न, दानैः, न, च, क्रियाभिः, न, तपोभिः,\n" +
                "उग्रैः, एवंरूपः, शक्यः, अहम्, नृलोके, द्रष्टुम्, त्वदन्येन, कुरुप्रवीर।।48।।","हे अर्जुन! मनुष्यलोक में मैं इस विराट रूप में न तो वेदों के अध्ययन से, न यज्ञों से, न दान से, न कर्मकांडों से और न केवल तुम्हारे सिवा किसी के घोर तपस्या से ही देखा जा सकता हूँ।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 49","मा, ते, व्यथा, मा, च, विमूढभावः, दृष्टवा, रूपम्, घोरम्, ईदृक्, मम, इदम्,\n" +
                "व्यपेतभीः, प्रीतमनाः, पुनः, त्वम्, तत्, एव, मे, रूपम्, इदम्, प्रपश्य।।49।।","मेरे इस प्रकार के विकराल रूप को देखकर तुम्हें व्यथित नहीं होना चाहिए और मूर्छित भी नहीं होना चाहिए। तुम भय से रहित और स्नेहमय मन से फिर उसी मेरे इस रूप को देखो।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 50","इति, अर्जुनम्, वासुदेवः, तथा, उक्त्वा, स्वकम्, रूपम्, दर्शयामास, भूयः,\n" +
                "आश्वासयामास, च, भीतम्, एनम्, भूत्वा, पुनः, सौम्यवपुः, महात्मा।।50।।","अर्जुन से ऐसा कहकर वसुदेव भगवान ने फिर अपना वही चतुर्भुज रूप दिखाया और फिर महात्मा कृष्ण का सौम्य रूप धारण कर इस भयभीत अर्जुन को सांत्वना दी।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 51","दृष्टवा, इदम्, मानुषम्, रूपम्, तव, सौम्यम्, जनार्दन,\n" +
                "इदानीम्, अस्मि, संवृत्तः, सचेताः, प्रकृतिम्, गतः।।51।।","हे जनार्दन! आपके इस अत्यंत शान्त मानव रूप को देखकर अब मैं संयत हो गया हूँ और अपनी सहज अवस्था में आ गया हूँ।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 52","सुदुर्दर्शम्, इदम्, रूपम्, दृष्टवान्, असि, यत्, मम।\n" +
                "देवाः, अपि, अस्य, रूपस्य, नित्यम्, दर्शनकाङ्क्षिणः।।52।।","मेरा चतुर्भुज (चतुर्भुज) रूप जो आपने देखा है वह बहुत ही कम देखने को मिलता है अर्थात् देखना बड़ा कठिन है। देवता भी इस रूप को देखने के लिए सदैव लालायित रहते हैं।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 53","न, अहम्, वेदैः, न, तपसा, न, दानेन, न, च, इज्यया।\n" +
                "शक्यः, एवंविधः, द्रष्टुम्, दृष्टवान्, असि, माम्, यथा।।53।।","जिस प्रकार आपने मुझे चतुर्भुज (चतुर्भुज) रूप में देखा है, इस प्रकार मैं न तो वेदों से देखा जा सकता हूँ, न तप से, न दान से और न केवल यज्ञ से।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 54","भक्त्या, तु, अनन्यया, शक्यः, अहम्, एवंविधः, अर्जुन।\n" +
                "ज्ञातुम्, द्रष्टुम्, च, तत्त्वेन्, प्रवेष्टुम्, च, परन्तप।।54।।","परन्तु हे परन्तप अर्जुन! अविभक्त भक्ति से मैं इस चतुर्भुज (चतुर्भुज) रूप में स्पष्ट रूप से देखा जा सकता हूँ और सार रूप में जाना जा सकता है और मेरे काल के जाल में ठीक से प्रवेश करना संभव है।"));
        list11.add(new GeetaModel("अध्याय 11","गीता श्लोक 55","मत्कर्मकृत्, मत्परमः, मद्भक्तः, संगवर्जितः,\n" +
                "निर्वैरः, सर्वभूतेषु, यः, सः, माम्, एति, पाण्डव।।55।।","हे अर्जुन! जो मेरे प्रति सब कर्म शास्त्रों के अनुसार करता है, जो मेरे मत के अनुसार श्रेष्ठ है, मेरा मतावलम्बी भक्त है, जो सभी जीवों के प्रति वैराग्य रहित और वैराग्य रहित है, वह अकेला ही मेरे पास आता है; अर्थात् वह मेरे ब्रह्म लोक में बने महान स्वर्ग में आता है, जहाँ कभी-कभी यह काल विष्णु रूप में दर्शन देता है। ब्रह्म काल को वास्तविक रूप में प्राप्त नहीं किया जा सकता है।"));


    }

    private void addDataToList10() {
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 1","भूयः, एव, महाबाहो, श्रृृणु, मे, परमम्, वचः,\n" +
                "यत्, ते, अहम्, प्रीयमाणाय, वक्ष्यामि, हितकाम्यया।।1।।","हे महाबाहु! साथ ही फिर मेरे परम गोपनीय और प्रभावशाली वचनों को भी सुनो जो मैं कल्याण की इच्छा से अत्यधिक प्रेम रखने वाले तुमसे कहूँगा।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 2","न, मे, विदुः, सुरगणाः, प्रभवम्, न, महर्षयः,\n" +
                "अहम्, आदिः, हि, देवानाम्, महर्षीणाम्, च, सर्वश्ः।।2।।","मेरी उत्पत्ति को न तो देवता और न ही महर्षि जानते हैं क्योंकि मैं ही सब प्रकार से देवताओं और महर्षियों का आदि कारण हूँ।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 3","यः, माम्, अजम्, अनादिम्, च, वेत्ति, लोकमहेश्वरम्,\n" +
                "असम्मूढः, सः, मत्र्येषु, सर्वपापैः,प्रमुच्यते।।3।।","एक विद्वान व्यक्ति जो मुझे और नित्य अर्थात् आदि, अजन्मा, सभी लोकों के महान भगवान अर्थात् महानतम भगवान को जानता है, वह जो शास्त्रों को ठीक से जानता है अर्थात् जिसे शास्त्रों का ज्ञान है, पुरुषों के बीच ज्ञानी अर्थात् तत्वदर्शी विद्वान तत्वज्ञान के आधार पर साधना करने से समस्त पापों से मुक्त हो जाता है। वह केवल पापों के बारे में विस्तार से बताता है अर्थात् वह केवल रचना और कर्मों के ज्ञान का सही विवरण देता है अर्थात अज्ञान से पूरी तरह मुक्त करता है।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 4,5","बुद्धिः, ज्ञानम्, असम्मोहः, क्षमा, सत्यम्, दमः, शमः,\n" +
                "सुखम्, दुःखम्, भवः, अभावः, भयम्, च, अभयम्, एव, च।।\n" +
                "\n" +
                "अहिंसा, समता, तुष्टिः, तपः, दानम्, यशः, अयशः,\n" +
                "भवन्ति, भावाः, भूतानाम्, मत्तः, एव, पृथग्विधाः।।4, 5।।","निर्णय शक्ति, पूर्ण ज्ञान, अज्ञान से मुक्ति, क्षमा, सत्य, इंद्रियों पर नियंत्रण, मन पर नियंत्रण और सुख-दुःख, उत्पत्ति-विनाश और भय-निर्भयता और अहिंसा, समता, संतोष, तपस्या, दान, यश और अपयश - प्राणियों के नाना प्रकार के लक्षण नियमानुसार विद्यमान रहते हैं।"));

        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 6","महर्षयः, सप्त, पूर्वे, चत्वारः, मनवः, तथा,\n" +
                "मद्भावाः, मानसाः, जाताः, येषाम्, लोके,इमाः,प्रजाः।।6।।","सात महर्षि और उनसे पूर्व की चार सनकादि तथा स्वायंभुव जैसे चौदह मनु, ये सब जो मुझमें श्रद्धा रखते हैं, मेरी इच्छा से उत्पन्न हुए हैं, जिनकी संसार में इतनी सारी जनसंख्या है।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 7","एताम्, विभूतिम्, योगम्, च, मम, यः, वेत्ति, तत्त्वतः,\n" +
                "सः, अविकम्पेन, योगेन, युज्यते, न, अत्रा, संशयः।।7।।","\n" +
                "जो मनुष्य मेरी महिमा और योगबल को इस प्रकार जान लेता है, वह अविचल भक्ति योग से युक्त हो जाता है। इसमें तो कोई शक ही नहीं है।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 8","अहम्, सर्वस्य, प्रभवः, मत्तः, सर्वम्, प्रवर्तते,\n" +
                "इति, मत्वा, भजन्ते, माम्, बुधाः, भावसमन्विताः।।8।।","मैं ही सबकी उत्पत्ति का कारण हूँ। पूरी दुनिया मेरी जानकारी के अनुसार प्रयास करती है। इस प्रकार समझकर जिन ज्ञानी भक्तों को तत्वदर्शी सन्त नहीं मिला, वे श्रद्धा और भक्ति से युक्त निरन्तर मुझ ही को भजते हैं।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 9","मच्चित्ताः, म०तप्राणाः, बोधयन्तः, परस्परम्,\n" +
                "कथयन्तः, च, माम्, नित्यम्, तुष्यन्ति, च, रमन्ति, च।।9।।","मुझ पर आश्रित प्राणी, जो केवल इतना ही जानते हैं और मुझमें ही मन लगाते हैं, वे सदा आपस में विचार-विमर्श करके संतुष्ट रहते हैं और मुझमें ही लीन रहते हैं।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 10","तेषाम्, सततयुक्तानाम्, भजताम्, प्रीतिपूर्वकम्,\n" +
                "ददामि, बुद्धियोगम्, तम्, येन, माम्, उपयान्ति, ते।।10।।","जो सदा ज्ञान की चर्चा में लगे रहते हैं और प्रेमपूर्वक भजन करते हैं, उन्हें मैं उसी स्तर का ज्ञान योग देता हूँ, जिससे वे मुझे प्राप्त होते हैं।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 11","तेषाम्, एव, अनुकम्पार्थम्, अहम्, अज्ञानजम्, तमः,\n" +
                "नाशयामि, आत्मभावस्थः, ज्ञानदीपेन, भास्वता।।11।।","मैं केवल उन पर अपनी कृपा बरसाने के लिए, अज्ञान से उत्पन्न अंधकार को नष्ट करने के लिए ही हूँ। मैं प्रेत के समान प्रवेश करके और आत्मा के समान शरीर में स्थापित होकर ज्ञान के दीपक को प्रकाशित करता हूँ; जैसे आत्मा बोलती है, वैसे आत्मा में आत्मभाव स्थापित करके।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 12,13","परम्, ब्रह्म परम्, धाम, पवित्राम्, परमम्, भवान्,\n" +
                "पुरुषम्, शाश्वतम्, दिव्यम्, आदिदेवम्, अजम्, विभुम्,\n" +
                "\n" +
                "आहुः, त्वाम्, ऋषयः, सर्वे, देवर्षिः, नारदः, तथा,\n" +
                "असितः, देवलः, व्यासः, स्वयम्, च, एव, ब्रवीषि, मे।।12 - 13।।","आप परमब्रह्म, परम धाम और परम पवित्र हैं क्योंकि सभी ऋषि आपको सनातन ईश्वर और देवताओं के आदि देव, अजन्मा और सर्वव्यापी कहते हैं। इसी प्रकार देवऋषि नारद और असित तथा देवल ऋषि और महर्षि व्यास भी यही कहते हैं और आप स्वयं ही मेरे लिए कहते हैं।"));

        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 14","सर्वम्, एतत्, ऋतम्, मन्ये, यत्, माम्, वदसि, केशव,\n" +
                "न, हि, ते, भगवन्, व्यक्तिम्, विदुः, देवाः, न, दानवाः।।14।।","हे केशव ! तुम जो कुछ भी मुझसे कहते हो, मैं इन सब बातों को सत्य मानता हूँ। हे प्रभो! आपके मनुष्य सदृश रूप को न तो दैत्य जानते हैं और न केवल देवता।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 15","स्वयम्, एव, आत्मना, आत्मानम्, वेत्थ, त्वम्,\n" +
                "पुरुषोत्तम, भूतभावन, भूतेश, देवदेव, जगत्पते।।15।।","हे जीवों के निर्माता! हे जीवों के स्वामी, हे देवों के देव! हे ब्रह्मांड के स्वामी! हे पुरुषोत्तम! आप ही अपने आप को अपने आप से जानते हैं।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 16","वक्तुम्, अर्हसि, अशेषेण, दिव्याः, हि, आत्मविभूतयः,\n" +
                "याभिः, विभूतिभिः, लोकान्, इमान्,त्वम्, व्याप्य, तिष्ठसि।।16।।","आप ही अपनी उन दैवीय शक्तियों का समग्रता से वर्णन करने में समर्थ हैं। जिन शक्तियों के द्वारा आप इन सभी लोकों को घेर कर स्थित हैं"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 17","कथम्, विद्याम्, अहम्, योगिन्, त्वाम्, सदा, परिचिन्तयन्,\n" +
                "केषु, केषु, च, भावेषु, चिन्त्यः, असि, भगवन्, मया।।17।।\n" +
                "\n","हे योगेश्वर! आपके विचारों में निरन्तर लीन रहते हुए मैं आपको कैसे जानूँ और हे प्रभु, मुझे किन-किन रूपों में आपका ध्यान करना है?"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 18","विस्तरेण, आत्मनः, योगम्, विभूतिम्, च, जनार्दन,\n" +
                "भूयः, कथय, तृप्तिः, हि, श्रृण्वतः, न, अस्ति, मे, अमृृतम्।।18।।","हे जनार्दन! फिर भी/फिर भी अपनी योगशक्ति और महिमा विस्तारपूर्वक बताइये क्योंकि आपके अमृतमय वचनों को सुनकर मुझे तृप्ति नहीं होती अर्थात् सुनने की इच्छा बनी रहती है।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 19","हन्त, ते, कथयिष्यामि, दिव्याः, हि, आत्मविभूतयः,\n" +
                "प्राधान्यतः, कुरुश्रेष्ठ, न, अस्ति, अन्तः, विस्तरस्य, मे।।19।।","हे कौरवों में श्रेष्ठ! अब मैं अपनी मुख्य दिव्य अभिव्यक्तियाँ/शक्तियाँ आपको बताऊँगा क्योंकि मेरे विस्तार की कोई सीमा नहीं है।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 20","अहम्, आत्मा, गुडाकेश, सर्वभूताशयस्थितः,\n" +
                "अहम्, आदिः, च, मध्यम्, च, भूतानाम्, अन्तः, एव, च।।20।।","\n" +
                "हे अर्जुन! मैं समस्त प्राणियों में स्थित आत्मा हूँ अर्थात् आत्मा काल के इशारे पर नाचती है इसलिए ऐसा कहा है। और मैं ही सब प्राणियों का आदि, मध्य और अन्त हूँ।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 21","आदित्यानाम्, अहम्, विष्णुः, ज्योतिषाम्, रविः, अंशुमान्,\n" +
                "मरीचिः, मरुताम्, अस्मि, नक्षत्राणाम्, अहम्, शशी।।21।।","मैं अदिति के बारह पुत्रों में विष्णु हूँ और ज्योतियों में दीप्तिमान सूर्य हूँ और मैं उनतालीस पवन-देवताओं का तेज / तेज हूँ और सितारों का स्वामी चंद्रमा हूँ"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 22","वेदानाम्, सामवेदः, अस्मि, देवानाम्, अस्मि, वासवः,\n" +
                "इन्द्रियाणाम्, मनः, च, अस्मि, भूतानाम्, अस्मि, चेतना।।22।।","वेदों में मैं सामवेद हूँ; देवताओं में मैं इन्द्र हूँ; मैं इन्द्रियों में मन हूँ, और चेतना अर्थात् जीवों की जीवन-शक्ति हूँ।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 23","रुद्राणाम्, शंकरः, च, अस्मि, वित्तेशः, यक्षरक्षसाम्,\n" +
                "वसूनाम्, पावकः, च, अस्मि, मेरुः, शिखरिणाम्, अहम्।।23।।","ग्यारह रुद्रों में मैं शंकर हूँ, और यक्षों और राक्षसों में मैं धन का स्वामी कुबेर हूँ; आठ वसुओं में अग्नि और शिखरों में सुमेरु पर्वत मैं हूँ।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 24","पुरोधसाम्, च, मुख्यम्, माम्, विद्धि, पार्थ, बृहस्पतिम्,\n" +
                "सेनानीनाम्, अहम्, स्कन्दः, सरसाम्, अस्मि, सागरः।।24।।","पुजारियों में मुझे प्रमुख ब्रहस्पति के रूप में जानते हैं। ओह पार्थ! सेनापतियों में स्कंद हूँ और जलाशयों में समुद्र हूँ।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 25","महर्षीणाम्, भृृगुः, अहम्, गिराम्, अस्मि, एकम्, अक्षरम्,\n" +
                "यज्ञानाम्, जपयज्ञः, अस्मि, स्थावराणाम्, हिमालयः।।25।।","मैं महर्षियों में भृगु हूँ और शब्दों में एक अक्षर अर्थात् ओंकार हूँ। सभी यज्ञों में मैं जपयज्ञ (ईश्वर के नाम का मौन जप) और अचलों में पर्वत हिमालय हूँ।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 26","अश्वत्थः, सर्ववृृक्षाणाम्, देवर्षीणाम्, च, नारदः,\n" +
                "गन्धर्वाणाम्, चित्रारथः, सिद्धानाम्,कपिलः,मुनिः।।26।।","सभी वृक्षों में मैं पीपल का वृक्ष हूँ; देवऋषि/दिव्य संतों में नारद मुनि; गन्धर्वों में चित्ररथ और सिद्धों में मैं कपिल मुनि हूँ।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 27","उच्चैः, श्रवसम्, अश्वानाम्, विद्धि, माम्, अमृतोद्भवम्,\n" +
                "ऐरावतम्, गजेन्द्राणाम्, नराणाम्, च, नराधिपम्।।27।।","घोड़ों में मुझे अमृत से उत्पन्न उच्चैःश्रवा घोड़ा जानो; श्रेष्ठ हाथियों में ऐरावत नाम का हाथी और मनुष्यों में राजा।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 28","आयुधानाम्, अहम्, वज्रम्, धेनूनाम्, अस्मि, कामधुक्,\n" +
                "प्रजनः, च, अस्मि, कन्दर्पः, सर्पाणाम्, अस्मि, वासुकिः।।28।।","मैं शस्त्रों में वज्र और गौओं में कामधेनु हूँ। मैं कामदेव हूँ, शास्त्रों के अनुसार संतान की उत्पत्ति का कारण और नागों में नागों का राजा वासुकि हूँ।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 29","अनन्तः, च, अस्मि, नागानाम्, वरुणः, यादसाम्, अहम्,\n" +
                "पित¤णाम्, अर्यमा, च, अस्मि, यमः, संयमताम्, अहम्।।29।।","मैं सर्पों में शेषनाग हूँ और मैं जलचरों का स्वामी वरुण हूँ और पितरों में अर्यमा नाम का पितृ हूँ और शासकों में मैं यमराज हूँ।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 30","हलादः, च, अस्मि, दैत्यानाम्, कालः, कलयताम्, अहम्,\n" +
                "मृगाणाम्, च, मृगेन्द्रः, अहम्, वैनतेयः, च, पक्षिणाम्।।30।।","मैं दैत्यों में प्रह्लाद और गिनती करने वालों का काल हूं, और पशुओं में मैं पशुओं का राजा सिंह हूं; और पक्षियों में मैं गरुड़ हूँ।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 31","पवनः, पवताम्, अस्मि, रामः, शस्त्राभृताम्, अहम्,\n" +
                "झषाणाम्, मकरः, च, अस्मि, स्त्रोतसाम्, अस्मि, जाह्नवी।।31।।","मैं पवित्र करने वालों में वायु और शस्त्रधारियों में श्री राम हूं। मैं मछलियों में मगरमच्छ हूँ, और नदियों में गंगा हूँ।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 32","सर्गाणाम्, आदिः, अन्तः, च, मध्यम्, च, एव, अहम्, अर्जुन,\n" +
                "अध्यात्मविद्या, विद्यानाम्, वादः, प्रवदताम्, अहम्।।32।।","हे अर्जुन! मैं ही आदि और अंत हूँ और यहाँ तक कि प्रकृति/सृष्टि का मध्य भी हूँ। मैं समस्त विद्याओं में अध्यात्मविद्या अर्थात् ब्रह्मविद्या (ब्रह्म का अध्ययन) हूँ तथा सत्य निष्कर्ष निकालने के लिए आपस में वाद-विवाद करने वालों का संवाद हूँ।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 33","अक्षराणाम्, अकारः, अस्मि, द्वन्द्वः, सामासिकस्य, च,\n" +
                "अहम्, एव, अक्षयः, कालः, धाता, अहम्, विश्वतोमुखः।।33।।","मैं अक्षरों में ओंकार हूँ और स्मासों में द्वन्द्व नाम का समास (यौगिक) हूँ; कभी न खत्म होने वाला काल, और मैं ही विराट रूप को सभी दिशाओं में मुखों के साथ प्राप्त करता हूं।\n"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 34","मृृत्युः, सर्वहरः, च, अहम्, उद्भवः, च, भविष्यताम्,\n" +
                "कीर्तिः, श्रीः, वाक्, च, नारीणाम्, स्मृृतिः, मेधा, धृृतिः, क्षमा।।34।।","मैं सबका नाश करने वाली मृत्यु हूँ और जन्म लेने वालों की उत्पत्ति का कारण हूँ और स्त्रियों में यश, भाग्य, वाक्, स्मृति, बुद्धि, दृढ़ता और क्षमा हूँ।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 35","बृहत्साम, तथा, साम्नाम्, गायत्राी, छन्दसाम्, अहम्,\n" +
                "मासानाम्, मार्गशीर्षः, अहम्, ऋतूनाम्, कुसुमाकरः।।35।।","और जो स्तोत्र गाए जा सकते हैं उनमें मैं बृहत्साम हूँ और छंदों में मैं गायत्री छंद हूँ और मैं महीनों में मार्गशीर्ष और ऋतुओं में वसंत हूँ।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 36","द्यूतम्, छलयताम्, अस्मि, तेजः, तेजस्विनाम्, अहम्,\n" +
                "जयः, अस्मि, व्यवसायः, अस्मि, सत्वम्, सत्ववताम्, अहम्।।36।।","मैं धोखेबाजों और प्रतापी पुरुषों के बीच जुआ खेलता हूं। मैं सात्विक पुरुषों की जीत, दृढ़ संकल्प और सात्विक गुण / या अच्छे / ईमानदार पुरुषों की अच्छाई हूं।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 37","वृष्णीनाम्, वासुदेवः, अस्मि, पाण्डवानाम्, धनजयः,\n" +
                "मुनीनाम्, अपि, अहम्, व्यासः, कवीनाम्, उशना, कविः।।37।।","वृष्णि के वंशजों में मैं वासुदेव हूँ अर्थात् मैं स्वयं आपका मित्र हूँ; पांडवों में धनंजय अर्थात् आप; ऋषियों/मुनियों में वेदव्यास और कवियों में मैं ही कवि शुक्राचार्य हूँ।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 38","दण्डः, दमयताम्, अस्मि, नीतिः, अस्मि, जिगीषताम्,\n" +
                "मौनम्, च, एव, अस्मि, गुह्यानाम्, ज्ञानम्, ज्ञानवताम्, अहम्।।38।।","दमन करने वालों का दण्ड मैं हूँ अर्थात् उनके दमन की शक्ति हूँ; मैं उन लोगों की राजनेता हूँ जो जीत चाहते हैं; मैं मौन हूँ, गुप्त रखने वाली बातों का रक्षक हूँ और ज्ञानियों का ज्ञान मैं ही हूँ।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 39","यत्, च, अपि, सर्वभूतानाम्, बीजम्, तत्, अहम्, अर्जुन,\n" +
                "न, तत्, अस्ति, विना, यत्, स्यात्, मया भूतम्, चराचरम्।।39।।","और हे अर्जुन! जो समस्त प्राणियों की उत्पत्ति का कारण है, वह भी मैं ही हूँ क्योंकि ऐसा कोई भी चेतन या जड़ प्राणी नहीं है जो मुझसे रहित हो।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 40","न, अन्तः, अस्ति, मम, दिव्यानाम्, विभूतीनाम्, परन्तप,\n" +
                "एषः, तु, उद्देशतः, प्रोक्तः, विभूतेः, विस्तरः, मया।।40।।","हे परंतप! मेरी दिव्य शक्तियों / महिमाओं / गुणों का कोई अंत नहीं है। मैंने अपनी शक्तियों/गुणों/गौरवों की इस सीमा का संक्षेप में वर्णन किया है।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 41","यत्, यत्, विभूतिमत्, सत्वम्, श्रीमत्, ऊर्जितम्, एव, वा,\n" +
                "तत्, तत्, एव अवगच्छ, त्वम्, मम्, तेजोंऽशसम्भवम्।। 41।।","जो कुछ भी राजसी, श्रेष्ठ और शक्तिशाली वस्तु है; जानते हैं कि मेरी प्रतिभा के एक हिस्से की अभिव्यक्ति के रूप में।"));
        list10.add(new GeetaModel("अध्याय 10","गीता श्लोक 42","अथवा, बहुना, एतेन, किम्, ज्ञातेन्, तव, अर्जुन,\n" +
                "विष्टभ्य, अहम्, इदम्, कृृत्स्न्नम्, एकांशेन, स्थितः, जगत्।।42।।","या हे अर्जुन! आपको यह सब विस्तार से जानने की क्या आवश्यकता है? मैं अपनी योगशक्ति के अंश मात्र से इस समस्त ब्रह्माण्ड को धारण करके स्थित हूँ।"));


    }

    private void addDataToList9() {
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 1","इदम्, तु, ते, गुह्यतमम्, प्रवक्ष्यामि, अनसूयवे,\n" +
                "ज्ञानम्, विज्ञानसहितम्, यत्, ज्ञात्वा, मोक्ष्यसे, अशुभात्।।1।।","आप को, एक भक्त जो शिकायत नहीं करता है, मैं फिर से इस परम गुप्त ज्ञान को अनुभवात्मक/विशेष ज्ञान के साथ उचित रूप से प्रदान करूंगा, जिसे जानकर आप शास्त्र विरुद्ध कर्मों से मुक्त हो जाएंगे।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 2","राजविद्या, राजगुह्यम्, पवित्राम्, इदम्, उत्तमम्,\n" +
                "प्रत्यक्षावगमम्, धम्र्यम्, सुसुखम्, कर्तुम्,अव्ययम्।।2।।","यह ज्ञान समस्त विद्याओं का राजा, समस्त रहस्यों का राजा, अत्यंत पवित्र, उत्कृष्ट और दृश्य फल देने वाला, शास्त्रानुकूल धर्म/धर्म से युक्त, कार्य करने पर सुख प्रदान करने वाला और सनातन है।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 3","\n" +
                "अश्रद्दधानाः, पुरुषाः, धर्मस्य, अस्य, परन्तप,\n" +
                "अप्राप्य, माम्, निवर्तन्ते, मृृत्युसंसारवत्र्मनि।।3।।","हे अर्जुन! श्रद्धाहीन व्यक्ति इस उपर्युक्त धर्म/धर्म के भक्ति-मार्ग को प्राप्त करने के स्थान पर मेरे, ब्रह्म के, मृत्यु लोक के चक्र में चक्कर लगाते रहते हैं।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 4","मया, ततम्, इदम्, सर्वम्, जगत्, अव्यक्तमूर्तिना,\n" +
                "मत्स्थानि, सर्वभूतानि, न, च, अहम्, तेषु, अवस्थितः।।4।।","मेरे और आकार वाले अदृश्य परमेश्वर के द्वारा यह सारा संसार फैला हुआ है, घिरा हुआ है अर्थात् परमेश्वर ने ही रचा है और वास्तव में वही नियंता है। और जितने भी जीव मेरे अधीन हैं, उनमें मैं स्थित नहीं हूँ। क्योंकि काल अर्थात् ज्योति निरंजन अपने इक्कीसवें ब्रह्मण्ड में अलग रहता है और प्रत्येक ब्रह्मण्ड में भी गुप्त रूप से और अलग-अलग महाब्रह्मा, महाविष्णु और महाशिव रूप में रहता है। इसका प्रमाण गीता अध्याय 7 श्लोक 12 में भी है। गीता अध्याय 13 श्लोक 17 तथा अध्याय 18 श्लोक 61 में भी यही प्रमाण है। कहा जाता है कि पूर्ण परमात्मा विशेष रूप से सबके हृदय में स्थित है। वह सभी प्राणियों को यंत्र की तरह घुमाता है।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 5","न, च, मत्स्थानि, भूतानि, पश्य, मे, योगम्, ऐश्वरम्,\n" +
                "भूतभृत्, न, च, भूतस्थः, मम, आत्मा, भूतभावनः।।5।।","तथा समस्त जीव मुझमें स्थित नहीं हैं तथा मेरी आत्मा को भी समस्त प्राणियों का जनक नहीं मानते। वह सर्वशक्तिमान परमेश्वर, जो सभी जीवों का पालन-पोषण करने वाला है, अविच्छेद्य संबंध की शक्ति से जीवों में स्थित है। इसका प्रमाण गीता अध्याय 15 श्लोक 16-17 में भी है कि परमेश्वर कोई और है; वह पूरे ब्रह्मांड को धारण करता है। यही प्रमाण गीता अध्याय 13 श्लोक 17 तथा अध्याय 18 श्लोक 61 में भी है। कहा है कि पूर्ण परमात्मा सबके हृदय में विशेष रूप से स्थित है। वह सभी प्राणियों को यंत्र की तरह घुमाता है।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 6","यथा, आकाशस्थितः, नित्यम्, वायुः, सर्वत्रागः, महान्,\n" +
                "तथा, सर्वाणि, भूतानि, मत्स्थानि, इति, उपधारय।।6।।","जिस प्रकार सर्वत्र विचरती हुई प्रचण्ड वायु सदैव आकाश में स्थित रहती है; इसी तरह, सभी जीवित प्राणी ठीक से स्थित हैं। इसे ऐसे समझें।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 7","सर्वभूतानि, कौन्तेय, प्रकृतिम्, यान्ति, मामिकाम्।\n" +
                "कल्पक्षये, पुनः, तानि, कल्पादौ, विसृृजामि, अहम्।।7।।","ह अर्जुन! कल्पों (युगों/युगों) के अंत में सभी प्राणी मेरी प्रकृति में चले जाते हैं अर्थात् प्रकृति में विलीन हो जाते हैं और कल्पों के आरंभ में मैं उन्हें फिर से उत्पन्न करता हूँ।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 8","प्रकृृतिम्, स्वाम्, अवष्टभ्य, विसृृजामि, पुनः, पुनः।\n" +
                "भूतग्रामम्, इमम्, कृत्थ्म्, अवशम्,प्रकृतेः,वशात्।।8।।","\n" +
                "मैं अपनी प्रकृति को स्वीकार करके अर्थात् उसे पत्नी रूप में रखकर बार-बार उनके कर्मों के अनुसार जीवों के इस सम्पूर्ण समुदाय की रचना करता हूँ जो उनके स्वभाव के वशीभूत हैं।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 9","न, च, माम्, तानि, कर्माणि, निबध्नन्ति, धन×जय,\n" +
                "उदासीनवत्, आसीनम्, असक्तम्, तेषु, कर्मसु।।9।।","हे अर्जुन! जो अनासक्त और उदासीन के समान उन कर्मों में स्थित है, वे कर्म मुझे नहीं बांधते।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 10","मया, अध्यक्षेण, प्रकृतिः, सूयते, सचराचरम्,\n" +
                "हेतुना, अनेन, कौन्तेय, जगत्, विपरिवर्तते।।10।।","\n" +
                "हे अर्जुन! प्रकृति मुझको स्वामी मानकर चेतन और जड़ सहित सारे जगत् को उत्पन्न करती है। इसी कारण से ही यह संसार रूपी चक्र घूम रहा है।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 11","अवजानन्ति, माम्, मूढाः, मानुषीम्, तनुम्, आश्रितम्,\n" +
                "परम्, भावम्, अजानन्तः, मम, भूतमहेश्वरम्।।11।।","मेरे प्रधान चरित्र को तथा समस्त प्राणियों के महान स्वामी परमेश्वर को न जानकर मूर्ख लोग मुझे मनुष्य शरीर धारण करने वाला तुच्छ समझते हैं अर्थात् कृष्ण रूप में मानते हैं।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 12","मोघाशाः, मोघकर्माणः, मोघज्ञानाः, विचेतसः,\n" +
                "राक्षसीम्, आसुरीम्, च, एव, प्रकृतिम्, मोहिनीम् श्रिताः।।12।।","व्यर्थ आशा, व्यर्थ कर्म और व्यर्थ ज्ञान से विमूढ़ मन वाले अज्ञानी लोग आसुरी, राक्षसी और मायावी प्रकृति को ही अपनाते हैं।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 13","महात्मानः, तु, माम्, पार्थ, दैवीम्, प्रकृतिम्, आश्रिताः,\n" +
                "भजन्ति, अनन्यमनसः, ज्ञात्वा, भूतादिम्, अव्ययम्।।13।।","दूसरी ओर, हे कुन्तीपुत्र! महात्मा लोग दैवीय स्वभाव अर्थात् मुनि का स्वभाव धारण करके, समस्त प्राणियों के नित्य कारण, अमर परमात्मा को तत्व रूप में जानकर अविचल मन से मेरा भजन करते हैं।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 14","सततम्, कीर्तयन्तः, माम्, यतन्तः, च, दृढव्रताः,\n" +
                "नमस्यन्तः, च माम्, भक्त्या, नित्ययुक्ताः, उपासते।।14।।","भक्तगण दृढ संकल्प वाले मेरे नाम (मन्त्र) और गुणों का निरन्तर गुणगान करते हुए और मुझे प्राप्त करने का प्रयत्न करते हुए और बारंबार मुझे श्रद्धापूर्वक नमस्कार करके सदा श्रद्धा से मेरा भजन करते हैं।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 15","ज्ञानयज्ञेन, च, अपि, अन्ये, यजन्तः, माम्, उपासते,\n" +
                "एकत्वेन, पृथक्त्वेन, बहुधा, विश्वतोमुखम्।।15।।","अन्य लोग ज्ञान के यज्ञ द्वारा मुझ ब्रह्म को एक/अविभाजित रूप में पूजते हैं और अन्य पुरुष अलग-अलग रूपों में मौजूद मुझ विराट रूप वाले भगवान को अलग-अलग पूजते हैं।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 16","अहम्, क्रतुः, अहम्, यज्ञः, स्वधा, अहम्, अहम्, औषधम्,\n" +
                "मन्त्राः, अहम्, अहम्, एव, आज्यम्, अहम्, अग्निः, अहम्, हुतम्।।16।।","मैं यज्ञकर्ता हूँ, मैं यज्ञ हूँ, मैं ही प्रसाद हूँ, मैं ही औषधि हूँ, मैं मंत्र हूँ, मैं ही घी हूँ, मैं ही अग्नि हूँ और मैं ही हवन की क्रिया हूँ।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 17","पिता, अहम्, अस्य, जगतः, माता, धाता, पितामहः,\n" +
                "वेद्यम्, पवित्राम्, ओंकारः, ऋक्, साम, यजुः, एव, च।।17।।","मैं ही इक्कीस ब्रह्मण्डों के इस संसार का पालनहार, पिता, माता, पितामह, पवित्र ओंकार और ऋग्वेद, सामवेद और यजुर्वेद आदि तीन वेदों को जानने के योग्य हूँ।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 18","गतिः, भर्ता, प्रभुः, साक्षी, निवासः, शरणम्, सुहृत्, प्रभवः,\n" +
                "प्रलयः, स्थानम्, निधानम्, बीजम्,अव्ययम्।।18।।","मैं राज्य का पालनकर्ता, स्वामी, अच्छे और बुरे का साक्षी, निवास, शरण लेने योग्य, हितैषी जो उपकार की वापसी की कामना नहीं करता, सबकी उत्पत्ति और विनाश का कारण, सबके राज्य का आधार , जलाशय और शाश्वत कारण।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 19","तपामि, अहम्, अहम्, वर्षम्, निगृह्णामि, उत्सृजामि, च,\n" +
                "अमृतम्, च, एव, मृत्युः, च, सत्, असत्, च, अहम्, अर्जुन।।19।।","मैं केवल सूर्य के रूप में जलता हूँ, वर्षा को रोकता और भेजता हूँ। हे अर्जुन! मैं ही अमरत्व और मृत्यु हूँ और मैं ही सत्य और असत्य का कारण हूँ।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 20","त्रौविद्याः, माम्, सोमपाः, पूतपापाः, यज्ञैः, इष्ट्वा, स्वर्गतिम्, प्रार्थयन्ते,\n" +
                "ते, पुण्यम्, आसाद्य, सुरेन्द्रलोकम्, अश्नन्ति, दिव्यान्, दिवि, देवभोगान्।।20।।","जो पुण्यात्मा तीनों वेदों में वर्णित विधियों के अनुसार भक्ति के अमृत का पान करते हैं, यज्ञों के माध्यम से मुझे देवता के रूप में पूजते हैं, वे स्वर्ग को प्राप्त करना चाहते हैं। पुण्य कर्मों के फलस्वरूप इन्द्रलोक को प्राप्त करके वे स्वर्ग में देवताओं के दिव्य सुखों का भोग करते हैं।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 21","ते, तम्, भुक्त्वा, स्वर्गलोकम्, विशालम्, क्षीणे, पुण्ये, मत्र्यलोकम्,\n" +
                "विशन्ति, एवम्, त्रायीधर्मम्, अनुप्रपन्नाः, गतागतम्, कामकामाः, लभन्ते।।21।।","उस विस्तृत स्वर्गलोक को भोगकर पुण्य कर्मों के क्षीण होने पर वे पुनः नश्वर लोक में प्रवेश करते हैं। इस प्रकार जो लोग सांसारिक भोगों की इच्छा से तीनों वेदों में वर्णित भक्ति के कार्य का पालन करते हैं, वे बार-बार जन्म और मृत्यु प्राप्त करते हैं।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 22","अनन्याः, चिन्तयन्तः, माम्, ये, जनाः, पर्युपासते,\n" +
                "तेषाम्, नित्याभियुक्तानाम्, योगक्षेमम्, वहामि, अहम्।।22।।","जो अनन्य प्रेमी भक्त मेरे चिन्तन में लीन रहते हैं, उस परमपिता परमेश्वर की निष्काम भक्ति करते हैं, मैं उन्हीं पुरुषों की साधना की रक्षा करता हूँ जो सदा साधना में लगे रहते हैं।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 23","ये, अपि, अन्यदेवताः, भक्ताः, यजन्ते, श्रद्धया, अन्विताः,\n" +
                "ते, अपि, माम्, एव, कौन्तेय, यजन्ति, अविधिपूर्वकम्।।23।।","हे अर्जुन! जो भक्त अन्य देवताओं को भी श्रद्धा से पूजते हैं, वे भी मेरी ही पूजा करते हैं, पर उनकी वह पूजा नियम के विपरीत अर्थात् शास्त्र विरुद्ध है।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 24","अहम्, हि, सर्वयज्ञानाम्, भोक्ता, च, प्रभुः,एव, च,\n" +
                "न, तु, माम्,अभिजानन्ति,तत्त्वेन,अतः,च्यवन्ति,ते।।24।।","क्योंकि मैं ही समस्त यज्ञों का भोक्ता और स्वामी हूँ, परन्तु वे मुझे तत्व से नहीं जानते हैं और इसलिए चौरासी लाख योनियों के शरीरों में पतित होते हैं अर्थात् भोगते हैं।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 25","यान्ति, देवव्रताः, देवान्, पितृ़न्यान्ति, पितृव्रताः।\n" +
                "भूतानि,यान्ति,भूतेज्याः,यान्ति, मद्याजिनः,अपि,माम्।।25।।","देवताओं के उपासक देवताओं के पास जाते हैं, पितरों के उपासक पितरों के पास जाते हैं, भूतों के उपासक भूतों के पास जाते हैं; इसी प्रकार मेरे भक्त जो शास्त्रानुकूल उपासना करते हैं (मातानुसार) भी मुझे प्राप्त होते हैं।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 26","पत्राम्, पुष्पम्, फलम्, तोयम्, यः, मे, भक्त्या, प्रयच्छति,\n" +
                "तत्, अहम्, भक्त्युपहृतम्, अश्नामि, प्रयतात्मनः।।26।।","जो भक्त भक्तिपूर्वक मुझे पत्र, पुष्प, फल और जल आदि अर्पित करता है, उस प्रेमी भक्त द्वारा भक्तिपूर्वक अर्पित की गई वस्तु को मैं ग्रहण करता हूँ।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 27","यत्, करोषि, यत्, अश्नासि, यत्, जुहोषि, ददासि, यत्,\n" +
                "यत्, तपस्यसि, कौन्तेय, तत्, कुरुष्व, मदर्पणम्।।27।।","हे अर्जुन! तुम जो कुछ कर्म करते हो, जो कुछ खाते हो, जो हवन करते हो, जो कुछ दान करते हो, जो कुछ तप करते हो, वह सब शास्त्रानुसार (मातानुसार) मुझे अर्पण कर दो।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 28","शुभाशुभफलैः, एवम्, मोक्ष्यसे, कर्मबन्धनैः,\n" +
                "सóयासयोगयुक्तात्मा, विमुक्तः, माम्, उपैष्यसि।।28।।","इस प्रकार मतानुसार साधना करने से (शास्त्राविधि अनुसार) साधना करने वाला साधक घर त्याग कर साधना करता है या हठयोग का अभ्यास करके अपने कल्याण और दुर्भाग्य का फल जानकर शास्त्रविरुद्ध साधना से बच जाता है जो हठयोग है जिसमें कोई एक जगह बंध कर बैठता है। ऐसी साधना के बंधन से मुक्त होकर जो शास्त्रविरूद्ध है अर्थात् शास्त्रानुकूल साधना करके मुझ से ही लाभ प्राप्त करेगा अर्थात् मुझ तक ही आयेगा।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 29","समः, अहम्, सर्वभूतेषु, न, मे, द्वेष्यः, अस्ति, न, प्रियः,\n" +
                "ये, भजन्ति, तु, माम्, भक्त्या, मयि, ते, तेषु, च, अपि, अहम्।।29।।","मैं समस्त प्राणियों में समान रूप से विद्यमान हूँ, न कोई मेरा शत्रु है, न प्रिय है, परन्तु जो भक्त शास्त्रानुकूल मेरी उपासना करते हैं, वे मुझमें हैं और मैं उनमें भी हूँ।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 30","अपि, चेत्, सुदुराचारः, भजते, माम्, अनन्यभाक्,\n" +
                "साधुः, एव, सः, मन्तव्यः, सम्यक्, व्यवसितः, हि, सः।।30।।","कोई दुराचारी भी यदि अनन्य भक्ति से मेरी पूजा करता है, तो भी वह संत माने जाने के योग्य है, क्योंकि उसने सही निर्णय लिया है।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 31","क्षिप्रम्, भवति, धर्मात्मा, शश्वत्, शान्तिम्, निगच्छति,\n" +
                "कौन्तेय, प्रति, जानीहि, न, मे, भक्तः, प्रणश्यति।।31।।","उक्त भक्त का अगले श्लोक में ही कहा है कि वह दुष्ट व्यक्ति मेरी पूजा करता है अर्थात् भक्तिमार्ग मत अर्थात् मेरे द्वारा दिए गए सिद्धांत के आधार पर शास्त्रों का अध्ययन करने से शीघ्र ही संत के गुण प्राप्त कर लेता है, परन्तु ऐसा करने से मेरी उपासना से वह साधक कर्मों के आधार पर जन्म-मरण के चक्र के आधार पर दीर्घ काल तक शान्ति को प्राप्त होता है अर्थात् एक कल्प/आयु तक ब्रह्मलोक में रहता है। तत्पश्चात् कर्मों के आधार पर अन्य प्राणियों का शरीर प्राप्त करता है। गीता अध्याय 9 श्लोक 7 में भी यही प्रमाण है कि कल्प के अन्त में सभी प्राणी प्रकृति में लीन हो जाते हैं। कल्प के आदि में फिर रचता हूँ। हे कुंतीपुत्र! यह न जानने वाला मेरा भक्त भी फिर अदृश्य हो जाता है अर्थात् मानव शरीर प्राप्त करने के स्थान पर अन्य प्राणियों के शरीर प्राप्त करता है।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 32","माम्, हि, पार्थ, व्यपाश्रित्य, ये, अपि, स्युः, पापयोनयः,\n" +
                "स्त्रिायः, वैश्याः, तथा, शूद्राः, ते, अपि, यान्ति, पराम्, गतिम्।।32।।","क्योंकि हे पार्थ! जो कोई पापी जन्म अर्थात् पापी वेश्या स्त्री और शूद्र (निम्न जाति का व्यक्ति) में मेरे आश्रित हो जाते हैं, वे सब भी परम गति को प्राप्त होते हैं।"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 33","किम्, पुनः, ब्राह्मणाः, पुण्याः, भक्ताः, राजर्षयः, तथा,\n" +
                "अनित्यम्, असुखम्, लोकम्, इमम्, प्राप्य, भजस्व, माम्।।33।।","पवित्र गीता के कथावाचक भगवान कह रहे हैं कि यदि उपरोक्त श्लोक 32 में वर्णित पाप आत्माएं भी परम गति प्राप्त कर सकती हैं तो पुण्य भक्तों, ब्राह्मणों और राजमुनियों के लिए यह कितना मुश्किल है। मेरे, ब्रह्म के, इस नाशवान, संकटमय संसार में जन्म लेकर उस पूर्ण परमेश्वर की पूजा करते हैं क्योंकि गीता अध्याय 8 श्लोक 8-10, 1 और 3 तथा 20-23 में पूर्ण परमात्मा की प्राप्ति के लिए विस्तृत विवरण दिया गया है, तथा अध्याय 8 के श्लोक 5-7 व 13 में अपने बारे में बताया है। यहाँ भी उस पूर्ण परमात्मा के विषय में सांकेतिक संदेश है तथा निम्न श्लोक 34 में स्वयं के विषय में कहा है कि यदि तुम्हें मेरी शरण में रहना पड़े और जन्म-मरण के कष्ट सहते रहना पड़े तो"));
        list9.add(new GeetaModel("Adhya 9","गीता श्लोक 34","मन्मनाः, भव, मद्भक्तः, मद्याजी, माम्, नमस्कुरु,\n" +
                "माम्, एव, एष्यसि, युक्त्वा, एवम्, आत्मानम्, मत्परायणः।।34।।","\n" +
                "मुझमें स्थिर मन से मेरे शास्त्रानुकूल उपासक, मतानुसार अर्थात् मेरे मतानुसार उपासना करने वाले उपासक बनो। झुको मेरे सामने। इस प्रकार आत्मा से मेरा आश्रय लेकर शास्त्रानुकूल साधना करने से ही तुम मुझ से लाभ प्राप्त करोगे।"));

    }

    private void addDataToList8() {
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 1","किम्, तत्, ब्रह्म, किम्, अध्यात्मम्, किम्, कर्म, पुरुषोत्तम्,\n" +
                "अधिभूतम्, च, किम्, प्रोक्तम्, अधिदैवम्, किम्, उच्यते।।1।।","हे पुरुषोत्तम! वह ब्रह्म क्या है ? अध्यात्म क्या है? कर्म क्या है? अधिभूत नाम से किसे कहते हैं और अधिदैव किसे कहते हैं?"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 2","अधियज्ञः, कथम्, कः, अत्रा, देहे, अस्मिन्, मधुसूदन,\n" +
                "प्रयाणकाले, च, कथम्, ज्ञेयः, असि, नियतात्मभिः।।2।।","हे मधुसूदन! यहाँ अधियज्ञ कौन है, और वह इस शरीर में कैसे है? और वह मृत्यु के समय उन पुरुषों द्वारा कैसे जाना जाता है जिन्होंने मन को वश में कर लिया है।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 3","अक्षरम्, ब्रह्म, परमम्, स्वभावः, अध्यात्मम्, उच्यते,\n" +
                "भूतभावोद्भवकरः, विसर्गः, कर्मस×िज्ञतः।। 3।।","गीता ज्ञान दाता भगवान ब्रह्म ने उत्तर दिया है - वह परम अक्षर 'ब्रह्म' है, जो सदैव आत्मा के साथ रहता है; उसका अपना स्वरूप अर्थात् परमात्मा के गुणों वाली आत्मा को 'अध्यात्म' नाम से पुकारा जाता है और जीव/जीव/जीव के स्वभाव को उत्पन्न करने वाले यज्ञ को 'कर्म' नाम से पुकारा जाता है।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 4","अधिभूतम्, क्षरः, भावः, पुरुषः, च, अधिदैवतम्,\n" +
                "अधियज्ञः, अहम्, एव, अत्रा, देहे, देहभृताम्, वर।।4।।","देहधारियों में श्रेष्ठ अर्थात इस मानव शरीर में अधिभूत - नाशवान प्रकृति वाले जीव के स्वामी और अधिदैव - दैवीय शक्ति के स्वामी और अधियज्ञ - यज्ञ के स्वामी अर्थात् यज्ञों में स्थित पूर्ण परमात्मा हैं। इसी तरह, मैं इस मानव शरीर में हूँ ।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 5","अन्तकाले, च, माम्, एव, स्मरन्, मुक्त्वा, कलेवरम्,\n" +
                "यः, प्रयाति, सः, मद्भावम्, याति, न, अस्ति, अत्रा, संशयः।।5।।","जो मनुष्य मृत्यु के समय भी केवल मुझे ही याद करते हुए शरीर त्याग करता है, वह शास्त्रानुकूल भक्ति के स्वरूप ब्रह्म तक की साधना को प्राप्त करता है। इसमें कोई शक नहीं है।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 6","यम्, यम्, वा, अपि, स्मरन्, भावम्, त्यजति, अन्ते, कलेवरम्,\n" +
                "तम्, तम्, एव, एति, कौन्तेय, सदा, तद्भावभावितः।।6।।","हे कुंतीपुत्र अर्जुन! यह मनुष्य जिस-जिस रूप अर्थात् जिस-जिस देवता का स्मरण करते-करते मृत्यु के समय शरीर त्याग देता है, उसी में चला जाता है, क्योंकि वह सदा उसी भक्ति अर्थात् प्रकृति को प्राप्त करता है।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 7","तस्मात्, सर्वेषु, कालेषु, माम्, अनुस्मर, युध्य, च,\n" +
                "मयि, अर्पितमनोबुद्धिः, माम्, एव, एष्यसि, असंशयम्।।7।।","इसलिए हे अर्जुन! आपको हर समय मुझे याद करना चाहिए और साथ ही लड़ना चाहिए। इस प्रकार मन-बुद्धि को मुझमें समर्पित करके नि:सन्देह तुम मेरे पास आओगे अर्थात् जब-जब तुम्हारा मनुष्य जन्म होगा, तब-तब तुम मेरी पूजा में लीन रहोगे और मेरे ही पास रहोगे।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 8","अभ्यासयोगयुक्तेन, चेतसा, नान्यगामिना।\n" +
                "परमम्, पुरुषम्, दिव्यम्, याति, पार्थ, अनुचिन्तयन्।।8।।","ओह पार्थ! पूर्ण परमात्मा के मन्त्र जप (नाम जाप) की साधना रूपी भक्तियुक्त अर्थात पूर्ण परमात्मा की भक्ति में निरन्तर एकाग्र भाव से लीन रहने वाला भक्त निरन्तर ईश्वर का चिन्तन करने वाला भक्त परब्रह्म परमात्मा अर्थात् परमात्मा के पास जाता है। सर्वोच्च ईश्वर ही।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 9","कविम्, पुराणम् अनुशासितारम्, अणोः, अणीयांसम्, अनुस्मरेत्,\n" +
                "यः, सर्वस्य, धातारम्, अचिन्त्यरूपम्, आदित्यवर्णम्, तमसः, परस्तात्।।9।।","कविर्देव अर्थात् परमेश्वर कबीर जो कवि के रूप में प्रसिद्ध हो जाते हैं, वे अनादि हैं, सभी के नियंत्रक हैं, सूक्ष्म से भी सूक्ष्म हैं, अचिन्त्य हैं, सूर्य के समान सदा दीप्तिमान हैं। जो (सुमिरन करता है) उस सच्चिदानंदघन परमेश्वर (सच्चे सुख देने वाले परमेश्वर) को अज्ञान के अंधकार से परे याद करता है।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 10","प्रयाणकाले, मनसा, अचलेन, भक्त्या, युक्तः, योगबलेन, च, एव, भ्रुवोः,\n" +
                "मध्ये, प्राणम्, आवेश्य, सम्यक्, सः, तम्, परम् पुरुषम्, उपैति, दिव्यम्।।10।।","वह भक्तियुक्त साधक मृत्यु के समय भक्ति के प्रभाव से मन्त्र जप (नाम का जाप) करके भौहों के मध्य में प्राणवायु को ठीक से स्थिर करके स्थिर मन से जाता है। अज्ञात, दिव्य सर्वोच्च ईश्वर ही।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 11","यत्, अक्षरम्, वेदविदः, वदन्ति, विशन्ति, यत्, यतयः, वीतरागाः,\n" +
                "यत्, इच्छन्तः, ब्रह्मचर्यम्, चरन्ति, तत्, ते, पदम्, सङ्ग्रहेण, प्रवक्ष्ये।।11।।","उपरोक्त श्लोक 8 से 10 में उल्लेख किया है, सच्चे सुख देने वाले परमेश्वर [सच्चिदानंद घन परमेश्वर], जिन्हें वेदों के ज्ञाता अर्थात् तत्वदर्शी संत वास्तव में अमर कहते हैं। जिनमें आसक्ति से रहित प्रयत्नशील उपासक प्रवेश करते हैं अर्थात् उन्हें प्राप्त करते हैं। जिनके चाहने वाले ब्रह्मचर्य का पालन करते हैं अर्थात् ब्रह्मचर्य का पालन करके उस परमात्मा को प्राप्त करने का प्रयत्न भी करते हैं। मैं संक्षेप में अर्थात् सांकेतिक रूप में उस स्थिति को अर्थात् उस पूर्ण परमात्मा को प्राप्त करने की वह विधि, भक्ति की विधि, उपासना विधि कहूँगा।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 12","सर्वद्वाराणि, संयम्य, मनः, हृदि, निरुध्य, च,\n" +
                "मू£ध्न्, आधाय, आत्मनः, प्राणम्, आस्थितः, योगधारणाम्।।12।।","भक्ति की जो विधि मैं बताने जा रहा हूँ, उसमें साधक इन्द्रियों के सब द्वारों को संयमित कर, मन को हृदय में और प्राणों को ललाट में स्थिर करके, ईश्वर के चिंतन में स्थित होकर योग धारणा अर्थात् में स्थित हो जाता है। पूजा में।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 13","ओम्, इति, एकाक्षरम्, ब्रह्म, व्याहरन्, माम्, अनुस्मरन्,\n" +
                "यः, प्रयाति, त्यजन्, देहम्, सः, याति, परमाम्, गतिम्।।13।।","गीता ज्ञान दाता ब्रह्म कह रहा है कि उपरोक्त श्लोक 11-12 में गीता अध्याय 17 श्लोक 23 में जिस मंत्र के बारे में परमेश्वर की प्राप्ति के लिए बताया है, उस मंत्र में पूर्ण मोक्ष का मार्ग जिसमें तीन मंत्र ओम-तत्-सत् का जाप होता है; उसमें मुझ ब्रह्म का जप करते हुए सुमिरन अर्थात् साधना करने के लिए एक ही शब्द 'ॐ/ॐ' है। जो शरीर त्यागते समय सुमिरन करता है/स्मरण करता है अर्थात् अन्तकाल में सुमिरन करते-करते मर जाता है, वह परम पद - पूर्ण मोक्ष को प्राप्त करता है। {ब्रह्म ने गीता अध्याय 7 श्लोक 18 में अपनी स्थिति/मोक्ष को निकृष्ट/अशुभ बताया है। अतः यहाँ पर पूर्ण परमात्मा अर्थात् पूर्ण मोक्ष की परम स्थिति की प्राप्ति का वर्णन है।}"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 14","अनन्यचेताः, सततम्, यः, माम्, स्मरति, नित्यशः,\n" +
                "तस्य, अहम्, सुलभः, पार्थ, नित्ययुक्तस्य, योगिनः।।14।।","हे अर्जुन! जो निरन्तर अखण्ड चित्त से मेरा स्मरण करता है, उस योगी के लिए जो निरन्तर तल्लीन रहता है, मैं सहज ही प्राप्त हो जाता हूँ।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 15","माम्, उपेत्य, पुनर्जन्म, दुःखालयम्, अशाश्वतम्,\n" +
                "न, आप्नुवन्ति, महात्मानः, संसिद्धिम्, परमाम्, गताः।।15।।","\n" +
                "मुझको प्राप्त साधक अल्पकाल के लिए दु:खधाम, बार-बार जन्म-मरण में रहता है। जिन महात्माओं ने परम आध्यात्मिक सिद्धि प्राप्त कर ली है अर्थात् जो पूर्ण परमात्मा की साधना से प्राप्त होती है, उनका जन्म-मरण नहीं होता।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 16","आब्रह्मभुवनात्, लोकाः, पुनरावर्तिनः, अर्जुन,\n" +
                "माम्, उपेत्य, तु, कौन्तेय, पुनर्जन्म, न, विद्यते।।16।।","हे अर्जुन! ब्रह्मलोक तक के सभी लोक बार-बार निर्माण और विनाश के अधीन हैं। परन्तु हे कुन्तीपुत्र, जो यह नहीं जानते वे मुझको प्राप्त होकर भी पुनः जन्म लेते हैं।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 17","सहस्त्रायुगपर्यन्तम्, अहः,यत्,ब्रह्मणः, विदुः,रात्रिम्,\n" +
                "युगसहस्त्रान्ताम्, ते, अहोरात्राविदः, जनाः।।17।।","\n" +
                "जो सार रूप में जानते हैं कि परब्रह्म का एक दिन एक हजार युग की अवधि का होता है और रात भी एक हजार युग की अवधि की होती है, वे तत्वदर्शी संत दिन-रात के बारे में सच्चाई जानते हैं।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 18","अव्यक्तात्, व्यक्तयः, सर्वाः, प्रभवन्ति, अहरागमे,\n" +
                "रात्रयागमे, प्रलीयन्ते, तत्रा, एव, अव्यक्तसज्ञके।। 18।।","\n" +
                "सारा प्रकट जगत अव्यक्त अर्थात् अदृश्य परब्रह्म से दिन के प्रारम्भ में उत्पन्न होता है और रात्रि के आगमन पर उसी अदृश्य अर्थात् गुप्त परब्रह्म में विलीन हो जाता है।\n"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 19","भूतग्रामः, सः, एव, अयम्, भूत्वा, भूत्वा, प्रलीयते,\n" +
                "रात्रयागमे, अवशः, पार्थ, प्रभवति, अहरागमे।।19।।","ओह पार्थ! वही जीव जन्तु कर्मों के प्रभाव से जन्म लेकर रात्रि के आने पर विलीन हो जाता है और दिन के प्रारम्भ में पुनः जन्म लेता है।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 20","परः, तस्मात्, तु, भावः, अन्यः, अव्यक्तः,, अव्यक्तात्, सनातनः।\n" +
                "यः सः, सर्वेषु, भूतेषु, नश्यत्सु, न, विनश्यति।।20।।","परन्तु दूसरा सनातन अव्यक्त अर्थात् अदृश्य रूप जो उस अव्यक्त अर्थात् अदृश्य परब्रह्म से परे विद्यमान है, वह परम परमात्मा परमात्मा समस्त प्राणियों के नष्ट होने पर भी नष्ट नहीं होता।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 21","अव्यक्तः, अक्षरः, इति, उक्तः, तम्, आहुः, परमाम्, गतिम्।\n" +
                "यम्, प्राप्य, न, निवर्तन्ते, तत् धाम, परमम्, मम्।।21।।","जिसे अदृश्य और सनातन नाम से पुकारा जाता है, अज्ञान के अन्धकार में छिपा हुआ स्थान परमपद कहलाता है, जिसे पाकर मनुष्य वापस नहीं लौटता। वह लोक मुझसे और मेरे लोक से श्रेष्ठ है।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 22","पुरुषः, सः, परः, पार्थ, भक्त्या, लभ्यः, तु, अनन्यया।\n" +
                "यस्य, अन्तःस्थानि, भूतानि, येन, सर्वम्, इदम्, ततम्।।22।।","ओह पार्थ! जिस परमेश्वर के अधीन समस्त प्राणी हैं तथा सच्चिदानंदघन परमेश्वर (सच्चा सुख देने वाला परमेश्वर) जिससे यह सारा जगत व्याप्त है अर्थात् पूर्ण है, जिसके बारे में उपरोक्त श्लोक 20, 21 तथा गीता अध्याय 15 के श्लोक में उल्लेख है। 1-4 और 17 तथा अध्याय 18 के श्लोक 46, 61, 62, 65 तथा 66 में वह पूर्ण परमात्मा अनन्य भक्ति से ही प्राप्त होता है।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 23","यत्रा, काले, तु, अनावृत्तिम्, आवृत्तिम्, च, एव, योगिनः,\n" +
                "प्रयाताः यान्ति, तम्, कालम्, वक्ष्यामि, भरतर्षभ।।23।।","हे अर्जुन! जिस समय में शरीर त्याग कर जाने वाले योगी उस स्थिति को प्राप्त करते हैं जिसमें वे वापस नहीं आते हैं, और जिस समय में जाने वाले केवल उसी स्थिति को प्राप्त करते हैं जिसमें वे वापस लौटते हैं, उस गुप्त समय को मैं बताउंगा रास्ते।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 24","अग्निः, ज्योतिः, अहः, शुक्लः, षण्मासाः, उत्तरायणम्,\n" +
                "तत्रा, प्रयाताः, गच्छन्ति, ब्रह्म, ब्रह्मविदः, जनाः।।24।।","प्रकाश अग्नि / अग्नि दिन का कर्ता है, शुक्ल पक्ष कहलाता है, और उत्तरायण के छह महीनों का देवता है। जो योगी ईश्वर को सार रूप में जानते हैं, जो मृत्यु के बाद उस मार्ग पर चले गए हैं, वे ईश्वर को प्राप्त करते हैं।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 25","धूमः, रात्रिः, तथा, कृष्णः, षण्मासाः, दक्षिणायनम्,\n" +
                "तत्रा, चान्द्रमसम्, ज्योतिः, योगी, प्राप्य, निवर्तते।।25।।","अन्धकार रात्रि का कर्ता है, और कृष्ण पक्ष है; और छह महीने के दक्षिणायन का होता है। एक योगी, जो मृत्यु के बाद उस रास्ते पर चला गया है, चंद्रमा के प्रकाश को प्राप्त करता है, स्वर्ग में अपने पुण्य कर्मों का फल भोगता है।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 26","शुक्लकष्णे, गती, हि, एते, जगतः, शाश्वते, मते, \n" +
                "एकया,याति,अनावृत्तिम्,अन्यया,आवर्तते,पुनः।।26।।","क्योंकि शुक्ल और कृष्ण इन दो प्रकार के मोक्ष के मार्ग को शाश्वत माना जाता है, इनमें से वह, जो एक ऐसे रास्ते से गुजरा है जहाँ से कोई वापसी नहीं है, परम पद को प्राप्त करता है; और जो दूसरे से होकर गुजरा है, वह फिर लौट आता है अर्थात् जन्म-मरण को प्राप्त होता है।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 27","न,एते,सृती, पार्थ, जानन्,योगी, मुह्यति,कश्चन,\n" +
                "तस्मात्,सर्वेषु, कालेषु, योगयुक्तः, भव, अर्जुन।।27।।","ओह पार्थ! इस प्रकार इन दोनों मार्गों के भेद को सार रूप में जानकर कोई भी योगी मोहित नहीं होता। इसलिए हे अर्जुन! आप हर समय एकाग्रचित्त/संतुलित मन से योग में जुड़े रहें अर्थात् परमात्म प्राप्ति के लिए निरंतर साधना करें।"));
        list8.add(new GeetaModel("Adhya 8","गीता श्लोक 28","वेदेषु, यज्ञेषु, तपःसु, च, एव, दानेषु, यत्, पुण्यफलम्, प्रदिष्टम्, अत्येति,\n" +
                "तत्, सर्वम्, इदम्, विदित्वा, योगी, परम्, स्थानम्, उपैति, च, आद्यम्।।28।।","उपरोक्त रहस्य को सार रूप में जानने पर, वेदों के अध्ययन में और यज्ञों (यज्ञों, यज्ञों, दानों आदि) के प्रदर्शन में - जिसे मेधावी कर्मों का फल कहा जाता है, निःसंदेह मुझमें वह सब कुछ त्याग कर, एक उपासक वेदों से परे ज्ञान को जानकर शास्त्रानुकूल साधना करता है और अन्तकाल में परम लोक - परमेश्वर के सतलोक को प्राप्त करता है।"));

    }

    private void addDataToList7() {
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 1","मयि, आसक्तमनाः, पार्थ, योगम्, यु×जन्, मदाश्रयः,\n" +
                "असंशयम्, समग्रम्, माम्, यथा, ज्ञास्यसि, तत्, श्रृणु।।1।।","ओह पार्थ! मुझमें मन लगाकर, मत में लगा हुआ, योग/भक्ति में लीन, जिस प्रकार तुम सब संशयों से मुक्त होकर मुझे समग्रता से जानोगे, उसे सुनो।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 2","ज्ञानम्, ते, अहम्, सविज्ञानम्, इदम्, वक्ष्यामि, अशेषतः,\n" +
                "यत्, ज्ञात्वा, न, इह, भूयः, अन्यत्, ज्ञातव्यम्, अवशिष्यते।।2।।","मैं इस विशेष ज्ञान सहित तत्वज्ञान को आपके लिए पूर्ण रूप से कहूँगा; जिसे जानकर इस संसार में और कुछ जानने को शेष नहीं रहता।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 3","मनुष्याणाम्, सहस्त्रोषु, कश्चित्, यतति, सिद्धये,\n" +
                "यतताम्, अपि, सिद्धानाम्, कश्चित्, माम्, वेत्ति, तत्त्वतः।।3।।","हजारों मनुष्यों में से कोई एक परमात्मा की प्राप्ति के लिए प्रयत्न करता है और उन योगियों में भी जो प्रयत्न करते हैं, उनमें कोई विरला ही होता है जो मुझे तत्त्व से अर्थात् यथार्थ रूप से जानता है।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 4,5","भूमिः, आपः, अनलः, वायुः, खम्, मनः, बुद्धिः, एव, च,\n" +
                "अहंकारः, इति, इयम्, मे, भिन्ना, प्रकृतिः, अष्टधा।।4।।\n" +
                "\n" +
                "अपरा, इयम्, इतः, तु, अन्याम्, प्रकृतिम्, विद्धि, मे, पराम्,\n" +
                "जीवभूताम्, महाबाहो, यया, इदम्, धार्यते, जगत्।।5।।","एक भौतिक शरीर पृथ्वी, जल, अग्नि, वायु, आकाश आदि से बना होता है; इसी प्रकार मन, बुद्धि और अहंकार से सूक्ष्म शरीर बनता है। इस प्रकार आठ प्रकार से विभाजित अर्थात् यह अष्टंगी ही मेरी प्रकृति अर्थात् दुर्गा है। वह अद्वितीय है अर्थात् उसके समान कोई अन्य देवी नहीं है और उपर्युक्त दोनों शरीरों में उसका ही मुख्य योगदान है, और हे महाबाहु! इसके अतिरिक्त अन्य को जानो, जिनके द्वारा यह सारा संसार मेरी दूसरी प्रकृति अर्थात् दुर्गा के रूप में पोषित है, जो जीव रूप में चेतन है अर्थात् साकार है। क्योंकि दुर्गा ही अन्य रूप बनाकर समुद्र में छिपी थी, और लक्ष्मी, सावित्री और उमा के तीन रूपों को प्राप्त करके, तीनों देवताओं (ब्रह्मा, विष्णु और शिव) से विवाह किया और जीवों को उत्पन्न किया।"));

        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 6","एतद्योनीनि, भूतानि, सर्वाणि, इति, उपधारय,\n" +
                "अहम्, कृत्स्न्नस्य, जगतः, प्रभवः, प्रलयः, तथा।।6।।","इस प्रकार भूल भुलैया बनाकर इन्हीं दोनों प्रकृतियों से ही समस्त जीवों की उत्पत्ति होती है और मैं ही समस्त जगत का आदि और संहार हूँ।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 7","मत्तः, परतरम्, न, अन्यत्, कि×िचत्, अस्ति, धनजय,\n" +
                "मयि, सर्वम्, इदम्, प्रोतम्, सूत्रो, मणिगणाः, इव।।7।।","हे धनंजय! उपर्युक्त सिद्धान्त के अतिरिक्त और कोई प्रधान कारण नहीं है। यह सारा ब्रह्मांड मुझमें धागे में मणि के समान पिरोया हुआ है।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 8","रसः, अहम्, अप्सु, कौन्तेय, प्रभा, अस्मि, शशिसूर्ययोः,\n" +
                "प्रणवः, सर्ववेदेषु, शब्दः, खे, पौरुषम्, नृषु।।8।।","हे अर्जुन! मैं जल में रस, चन्द्रमा और सूर्य में प्रकाश, समस्त वेदों में अक्षर 'ॐ', आकाश में ध्वनि और मनुष्यों में पौरूष हूँ।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 9","पुण्यः, गन्धः, पृथिव्याम्, च, तेजः, च, अस्मि, विभावसौ,\n" +
                "जीवनम्, सर्वभूतेषु, तपः, च, अस्मि, तपस्विषु।।9।।","\n" +
                "मैं पृथ्वी में शुद्ध गंध और अग्नि में तेज हूँ, और सभी प्राणियों में जीवन और तपस्वियों में तप हूँ।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 10","बीजम्, माम्, सर्वभूतानाम्, विद्धि पार्थ, सनातनम्,\n" +
                "बुद्धिः, बुद्धिमताम्, अस्मि, तेजः, तेजस्विनाम्, अहम्।।10।।","हे अर्जुन! समस्त प्राणियों के मूल कारण मुझ ही को जानो। मैं बुद्धिमानों की बुद्धि और तेजस्वियों का तेज हूं।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 11","बलम्, बलवताम्, च, अहम्, कामरागविवर्जितम्,\n" +
                "धर्माविरुद्धः, भूतेषु, कामः अस्मि, भरतर्षभ।।11।।","हे भरतश्रेष्ठ! मैं ही आसक्ति और कामनाओं से रहित, बलवानों का बल हूँ और मैं ही अपने अधीन समस्त प्राणियों में धर्मानुकूल अर्थात् शास्त्रानुकूल कर्म हूँ।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 12","ये, च, एव, सात्त्विकाः, भावाः, राजसाः, तामसाः, च, ये,\n" +
                "मत्तः, एव, इति, तान्, विद्धि, न, तु, अहम्, तेषु, ते, मयि।।12।।","साथ ही सत्वगुण विष्णु जी से रक्षा और रजोगुण ब्रह्मा जी से सृष्टि और तमोगुण शिव जी से संहार के लक्षण भी मुझ ही से सुनियोजित ढंग से और नियमानुसार हो रहे हैं, ऐसा समझो। वास्तव में न मैं उनमें हूँ, न वे मुझमें हैं।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 13","त्रिभिः, गुणमयैः, भावैः, एभिः, सर्वम्, इदम्, जगत्,\n" +
                "मोहितम्, न अभिजानाति, माम्, एभ्यः, परम्, अव्ययम्।।13।।","इन्हीं गुणों के प्रभाव से सात्विक श्री विष्णु जी के प्रभाव से, रजस श्री ब्रह्मा जी के प्रभाव से तथा तामस श्री शिव जी के प्रभाव से - तीनों प्रकार के गुणों से यह सारा संसार (सारे जीव ) आसक्त हो रहा है अर्थात् मेरे ही काल के जाल में फँसा हुआ है; इसलिए, सर्वोच्च शाश्वत भगवान को नहीं जानता।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 14","दैवी, हि, एषा, गुणमयी, मम, माया, दुरत्यया, माम्,\n" +
                "एव, ये, प्रपद्यन्ते, मायाम्, एताम्,तरन्ति,ते।।14।।","क्योंकि मेरी यह अलौकिक अर्थात् अति विलक्षण त्रिगुणमयी माया बड़ी भयंकर/कठिन है, परन्तु जो सदैव मेरी ही भक्ति करते हैं, वे इस माया अर्थात् तीनों गुणों से ऊपर उठकर - रजगुण-ब्रह्मा जी, सतगुण-विष्णु जी, का उल्लंघन/पार कर जाते हैं। और तमगुण-शिव जी काल-ब्रह्म की साधना में लग जाओ।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 15","न, माम्, दुष्कतिनः, मूढाः, प्रपद्यन्ते, नराधमाः, \n" +
                "मायया, अपहृतज्ञानाः, आसुरम्, भावम्, आश्रिताः।।15।।","जिनका ज्ञान इस त्रिगुणमयी माया द्वारा अर्थात् रजगुण-ब्रह्मा, सतगुण-विष्णु, तमगुण-शिव जी की साधना से प्राप्त अल्पायु लाभ के आश्रित होकर हर लिया है, जो मेरी अर्थात् ब्रह्म-पूजा भी नहीं करते, जो केवल इन तीन देवताओं तक ही सीमित हैं, ऐसे व्यक्ति जो आसुरी स्वभाव वाले हैं, जो पुरुषों में सबसे नीचे हैं, दुष्ट कर्म करने वाले, मूर्ख हैं, वे मेरी पूजा नहीं करते हैं अर्थात् वे तीन गुणों (रजगुण-ब्रह्मा, सतगुण-विष्णु) की पूजा करते रहते हैं , तमगुण-शिव)।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 16","चतुर्विधाः, भजन्ते, माम्, जनाः, सुकृतिनः, अर्जुन,\n" +
                "आर्तः, जिज्ञासुः, अर्थार्थी, ज्ञानी,च,भरतर्षभ।।16।।","हे भरतश्रेष्ठ अर्जुन! पुण्य कर्म करने वाले - अर्थर्थी (धन चाहने वाले) - धन प्राप्ति के लिए वेद मन्त्रों से कर्म करने वाले, आरत (पीड़ित) - संकट दूर करने के लिए वेद मन्त्रों से कर्म करने वाले, जिज्ञासु (जिज्ञासु) - जिनके पास ज्ञान प्राप्त करके ईश्वर के बारे में जानकारी प्राप्त करने की इच्छा, वेदों के आधार पर ज्ञानी होकर वक्ता बन जाता है, और ज्ञानी (ज्ञानी) - जिसने जान लिया है कि मानव जीवन केवल ईश्वर प्राप्ति के लिए है; एक ही सर्वशक्तिमान ईश्वर की अविचल मन से साधना करने से ईश्वर भी प्राप्त हो सकता है; ऐसे चार प्रकार के भक्त पुरुष मुझे भजते हैं।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 17","तेषाम्, ज्ञानी, नित्ययुक्तः, एकभक्तिः, विशिष्यते,\n" +
                "प्रियः, हि, ज्ञानिनः, अत्यर्थम्, अहम्, सः, च, मम, प्रियः।।17।।","उनमें सदा एक ही ईश्वर की भक्ति में लीन रहने वाला ज्ञानी श्रेष्ठ है क्योंकि मुझे ज्ञानी अत्यंत प्रिय हैं और वह ज्ञानी मुझे अति प्रिय है।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 18","उदाराः, सर्वे, एव, एते, ज्ञानी, तु, आत्मा, एव, मे, मतम्,\n" +
                "आस्थितः, सः, हि, युक्तात्मा, माम्, एव, अनुत्तमाम्, गतिम्।।18।।","क्योंकि मेरे विचार से ये सब विद्वान् आत्माएँ श्रेष्ठ हैं, परन्तु वह आत्मा जो मुझमें ही लीन है, वह मेरे अति निकम्मे मोक्ष पर ही आश्रित है।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 19","बहूनाम्, जन्मनाम्, अन्ते, ज्ञानवान्, माम्, प्रपद्यते,\n" +
                "वासुदेवः, सर्वम्, इति, सः, महात्मा,सुदुर्लभः।।19।।","बहुत जन्मों के बाद पिछले जन्म में, जिसने तत्वज्ञान (सच्चा आध्यात्मिक ज्ञान) प्राप्त किया है, वह मेरी पूजा करता है। वासुदेव अर्थात् सर्वव्यापक पूर्ण ब्रह्म ही सब कुछ है, जो इस बात को जानता है, वह महात्मा अत्यंत दुर्लभ है।\n" +
                "\n" +
                "श्रीमद्भागवत स्कंद दशम अध्याय 51 में स्वयं श्री कृष्ण ने कहा है कि वासुदेव पुत्र होने के कारण मुझे वासुदेव कहा जाता है और न ही सबका स्वामी या सर्वव्यापी होने के कारण अर्थात् पूर्ण परमात्मा वासुदेव है।\n"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 20","कामैः, तैः, तैः, हृतज्ञानाः, प्रपद्यन्ते, अन्यदेवताः,\n" +
                "तम्, तम् नियमम्, आस्थाय, प्रकृत्या, नियताः, स्वया।।20।।","उन-उन सुखों की कामनाओं द्वारा जिनका ज्ञान हर लिया गया है, वे अपने निहित स्वभाव से प्रेरित होकर उस-उस अज्ञानरूपी अंधकार से युक्त नीति पर आश्रित होकर अन्य देवताओं की पूजा करते हैं।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 21","यः, यः, याम्, याम्, तनुम्, भक्तः, श्रद्धया, अर्चितुम्, इच्छति,\n" +
                "तस्य, तस्य अचलाम्, श्रद्धाम्, ताम्, एव, विदधामि, अहम्।।21।।","जो भक्त जिस जिस देवता के स्वरूप की श्रद्धा से पूजा करना चाहता है, उस-उस भक्त की श्रद्धा को मैं उसी भगवान में दृढ़ कर देता हूँ।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 22","\n" +
                "सः, तया, श्रद्धया, युक्तः, तस्य, आराधनम्, ईहते,\n" +
                "लभते, च, ततः, कामान्, मया, एव, विहितान्, हि, तान्।।22।।","उस श्रद्धा से युक्त वह भक्त उस देवता की पूजा करता है और उस देवता से मेरे ही द्वारा प्रदत्त वांछित सुखों को प्राप्त करता है।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 23","अन्तवत्, तु, फलम्, तेषाम्, तत्, भवति, अल्पमेधसाम्,\n" +
                "देवान्, देवयजः, यान्ति, मद्भक्ताः, यान्ति, माम्, अपि।।23।।","परन्तु उन मंदबुद्धि लोगों का वह फल नाशवान होता है। जो देवताओं को पूजते हैं वे देवताओं के पास जाते हैं और मातावलम्बी अर्थात् मेरे बताए हुए भक्ति मार्ग से मेरे पास भी आते हैं।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 24","अव्यक्तम्, व्यक्तिम्, आपन्नम्, मन्यन्ते, माम्, अबुद्धयः।\n" +
                "परम्, भावम्, अजानन्तः, मम, अव्ययम्, अनुत्तमम्।।24।।","\n" +
                "मूढ़ लोग मेरे निकृष्ट, स्थायी और प्रधान चरित्र से अनभिज्ञ होने के कारण गुप्त अर्थात् अदृश्य मुझ काल को मनुष्य की भाँति प्राप्त कर लिया है, कृष्ण के रूप में अवतरित हुए अर्थात् मैं कृष्ण नहीं हूँ।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 25","न, अहम्, प्रकाशः, सर्वस्य, योगमायासमावृतः।\n" +
                "मूढः, अयम्, न, अभिजानाति, लोकः, माम्, अजम्, अव्ययम्।।25।।","मैं योगमाया से छिपा हुआ किसी के सामने प्रकट नहीं होता अर्थात् अदृश्य रहता हूँ; इसलिए यह अज्ञानी जगत् (जीव) मुझे और मेरे जन्म न लेने के सनातन, अपरिवर्तनशील स्वरूप को नहीं जानता अर्थात् मुझे अवतार रूप में आया हुआ मानता है। क्योंकि ब्रह्म अपनी शब्द शक्ति से अपने अनेक रूप बनाता है; वह दुर्गा के पति हैं, इसलिए इस श्लोक में कह रहे हैं कि मैं श्री कृष्ण आदि की तरह दुर्गा से जन्म नहीं लेता।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 26","वेद्, अहम्, समतीतानि, वर्तमानानि, च, अर्जुन,\n" +
                "भविष्याणि, च, भूतानि, माम्, तु, वेद,न,कश्चन।।26।।","हे अर्जुन! मैं उन सभी प्राणियों को जानता हूँ जो अतीत में निवास कर चुके हैं और जो वर्तमान में विद्यमान हैं और भविष्य में आएंगे। लेकिन मुझे कोई नहीं जानता।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 27","इच्छाद्वेषसमुत्थेन, द्वन्द्वमोहेन, भारत,\n" +
                "सर्वभूतानि, सम्मोहम्, सर्गे, यान्ति, परन्तप।।27।।","हे भारतवंशी, अर्जुन! इस संसार में काम और द्वेष से उत्पन्न सुख-दु:ख आदि परस्पर विरोधी मोह से सभी जीव अत्यंत अज्ञानी होते जा रहे हैं।\n"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 28","येषाम्, तु, अन्तगतम्, पापम्, जनानाम्, पुण्यकर्मणाम्,\n" +
                "ते, द्वन्द्वमोहनिर्मुक्ताः, भजन्ते, माम्, दृढव्रताः।।28।।","परन्तु वे पुरुष, जो बिना इच्छा के पुण्य कर्म करते हैं, जिनके पाप नष्ट हो गए हैं, वे दृढ निश्चयी भक्त, राग-द्वेष से उत्पन्न परस्पर विरोधी मोह से मुक्त होकर सब प्रकार से मेरी पूजा करते हैं।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 29","जरामरणमोक्षाय, माम्, आश्रित्य, यतन्ति, ये,।\n" +
                "ते, ब्रह्म, तत् विदुः, कृत्थ्म्, अध्यात्मम्, कर्म, च, अखिलम्।।29।।","जो मेरे सम्पूर्ण (अध्यात्म) अध्यात्म ज्ञान तथा समस्त कर्मों को जानते हैं, वे पुरुष उस ब्रह्म का आश्रय लेकर वृद्धावस्था और मृत्यु से छुटकारा पाने का प्रयत्न करते हैं।"));
        list7.add(new GeetaModel("Adhya 7","गीता श्लोक 30","साधिभूताधिदैवम्, माम्, साधियज्ञम्, च, ये, विदुः।\n" +
                "प्रयाणकाले,अपि,च,माम्,ते,विदुः,युक्तचेतसः।।30।।","जो भक्त मुझे अधिभूत, अधिदैव और अधियज्ञ के साथ ठीक से जानते हैं, वे मुझे जानते हैं और मृत्यु के समय भी उनका मन लीन रहता है अर्थात् मेरे द्वारा दिए गए कष्टों को जानकर, अपने मन को एक परमेश्वर में स्थिर रखते हैं।"));


    }

    private void addDataToList6() {
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 1","अनाश्रितः, कर्मफलम्, कार्यम्, कर्म, करोति, यः,\n" +
                "सः, सन्यासी, च, योगी, च, न, निरग्निः, न, च, अक्रियः।।1।।","जो साधक कर्मों के फल की परवाह किये बिना शास्त्राविधि अनुसार भक्ति करने योग्य कर्म करता है, वह सन्यासी अर्थात् शास्त्रविरुद्ध साधना का परित्याग करने वाला और योगी है। भक्त। और जो इच्छा से रहित नहीं है और जो एक स्थान पर विशेष आसन में बैठकर दिखावा करता है और सभी गतिविधियों को त्याग देता है, वह योगी नहीं है।"));
        list6.add(new GeetaModel("Adhya 6","Geeta गीता श्लोक 2","यम्, सन्यासम्, इति, प्राहुः, योगम्, तम्, विद्धि पाण्डव,\n" +
                "न, हि, असन्यस्तसङ्कल्पः, योगी, भवति, कश्चन।।2।।","हे अर्जुन! भक्ति और ज्ञान के उस योग को जानो जिसे सन्यास कहा जाता है क्योंकि जो इच्छाओं का त्याग नहीं करता वह योगी नहीं है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 3","आरुरुक्षोः, मुनेः, योगम्, कर्म, कारणम्, उच्यते,\n" +
                "योगारूढस्य, तस्य, एव, शमः, कारणम्, उच्यते।।3।।","एक चिंतनशील उपासक जो योग अर्थात् भक्ति में दृढ़ होने की इच्छा रखता है, उसके लिए केवल शास्त्रों द्वारा निर्धारित भक्ति के कार्यों का प्रदर्शन ही भक्ति का कारण अर्थात लक्ष्य कहा जाता है। वास्तव में भक्ति में लीन भक्त के लिए समस्त कामनाओं का न होना ही भक्ति करने का कारण अर्थात् हेतु कहा जाता है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 4","यदा, हि, न, इन्द्रियार्थेषु, न, कर्मसु, अनुषज्जते,\n" +
                "सर्वसङ्कल्पसन्यासी, योगारूढः, तदा, उच्यते।।4।।","जब कोई इन्द्रिय-सुखों में या कर्मों में आसक्त नहीं होता, उस अवस्था में जो मनुष्य सब कामनाओं का त्याग कर चुका होता है, वह वास्तव में पूर्ण निश्चय के साथ भक्ति में लीन कहा जाता है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 5","उद्धरेत्, आत्मना, आत्मानम्, न, आत्मानम्, अवसादयेत्,\n" +
                "आत्मा, एव, हि, आत्मनः, बन्धुः, आत्मा, एव, रिपुः, आत्मनः।।5।।","आत्मा के साथ अविच्छेद्य रूप में रहने वाले पूर्ण परमात्मा के तत्वज्ञान को ध्यान में रखते हुए शास्त्रानुकूल साधना करके अपनी आत्मा को ऊपर उठाना चाहिए न कि स्वयं को नीचा दिखाना चाहिए क्योंकि परमेश्वर जिस साधक की साधना में लगा रहता है उस पर अपनी उत्तम कृपा प्रदान करता है। शास्त्रों के अनुसार। वह परमात्मा आत्मा के साथ अविच्छेद्य रूप में रहता है। इसलिए वह आत्मा रूपी परमात्मा वास्तव में आत्मा का मित्र है। और जीव शास्त्रों के विधान को त्यागकर मनमाना आचरण करने वाला वास्तव में अपना शत्रु होता है।"));
        list6.add(new GeetaModel("Adhya 6","Geeta Slok 6","बन्धुः, आत्मा, आत्मनः, तस्य, येन, आत्मा, एव, आत्मना, जितः,\n" +
                "अनात्मनः, तु, शत्रुत्वे, वर्तेत, आत्मा, एव, शत्राुवत्।।6।।","शास्त्रों के अनुसार साधना करने वाली आत्मा का मित्र परमात्मा ही होता है; जिसके फलस्वरूप परमेश्वर की शक्ति शास्त्रानुकूल भक्त की आत्मा के साथ विशेष प्रकार से कार्य करती है। जैसे मानव शक्ति से असंभव कार्यों को बिजली का कनेक्शन मिलने के बाद आसानी से पूरा किया जा सकता है। इसी प्रकार जीवात्मा परमेश्वर के कारण विजयी होता है अर्थात् सभी कार्य संपन्न होते हैं और वह हर सुख को प्राप्त कर परम गति को प्राप्त करता है और वह केवल मन और इन्द्रियों को भी जीत लेता है। परन्तु इसके विपरीत जो शास्त्रानुकूल साधना नहीं करता उसकी आत्मा को परमेश्वर का विशेष आश्रय प्राप्त नहीं होता; वह केवल वही प्राप्त करता है जो उसके लिए नियत होता है। अतः परमेश्वर के सहयोग से वंचित जीवात्मा अपने ही शत्रु के समान व्यवहार करता है। वास्तव में वह भक्त अपना ही शत्रु है अर्थात् जो शास्त्रानुकूल साधना को त्याग कर मनमाना व्यवहार करता है अर्थात् मनमाना धर्म आचरण करता है, न सुख प्राप्त करता है, न उसका कोई कार्य सिद्ध होता है और न ही परमगति को प्राप्त होता है। प्रमाण- पवित्र गीता अध्याय 16 मंत्र 23-24।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 7","जितात्मनः, प्रशान्तस्य, परमात्मा, समाहितः,\n" +
                "शीतोष्णसुखदुःखेषु, तथा, मानापमानयोः।।7।।","ऊपर के श्लोक 6 में वर्णित विजयी आत्मा के संबंध में कहा है कि जिस विजयी आत्मा को भगवान का आशीर्वाद प्राप्त है, जो शास्त्रानुकूल साधना करके भगवान से हर सुख और कार्यों की सिद्धि प्राप्त कर रही है, वह पूर्ण संतुष्ट साधक पूर्ण रूप से आश्रित है सर्वोच्च ईश्वर, जिसका अर्थ है कि उन्हें किसी और से कोई अपेक्षा नहीं है। सर्दी-गर्मी में भी अर्थात् सुख-दुःख में, मान-अपमान में भी वह ईश्वर की इच्छा समझकर शांत रहता है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 8","ज्ञानविज्ञानतृप्तात्मा, कूटस्थः, विजितेन्द्रियः,\n" +
                "युक्तः, इति, उच्यते, योगी, समलोष्टाश्मकाञ्चन:।। 8।।","वह, जिसका अंतःकरण ज्ञान और विज्ञान से अर्थात् तत्वज्ञान (सच्चा आध्यात्मिक ज्ञान) से संतुष्ट है, जिसकी आत्मा दोषों से मुक्त है, जिसकी इंद्रियाँ ईश्वर की सहायता से पर्याप्त रूप से जीत ली गई हैं और जिनके लिए रेत, पत्थर, पत्थर, और सोना एक समान है, वह शास्त्रानुकूल साधक परमात्मा को प्राप्त हो गया। यह आखिरी वाला सही भक्ति करने वाला कहा जाता है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 9","सुहृद् मित्र अरि उदासीन मध्यस्थ द्वेष्य बन्धुषु, \n" +
                "साधुषु, अपि, च, पापेषु, समबुद्धिः, विशिष्यते।।9।।","वह, जिसका अंतःकरण ज्ञान और विज्ञान से अर्थात् तत्वज्ञान (सच्चा आध्यात्मिक ज्ञान) से संतुष्ट है, जिसकी आत्मा दोषों से मुक्त है, जिसकी इंद्रियाँ ईश्वर की सहायता से पर्याप्त रूप से जीत ली गई हैं और जिनके लिए रेत, पत्थर, पत्थर, और सोना एक समान है, वह शास्त्रानुकूल साधक परमात्मा को प्राप्त हो गया। यह आखिरी वाला सही भक्ति करने वाला कहा जाता है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 10","योगी, युजीत, सततम्, आत्मानम्, रहसि, स्थितः,\n" +
                "एकाकी, यतचित्तात्मा, निराशीः, अपरिग्रहः।।10।।","एक भक्त, अपेक्षा और कब्जे से मुक्त, जिसने मन और इंद्रियों सहित अपने शरीर को वश में कर लिया है, एकांत स्थान में अकेला रहता है, और खुद को स्थापित करके, अपनी आत्मा को निरंतर भगवान में लगाना चाहिए।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 11","शुचै, देशे, प्रतिष्ठाप्य, स्थिरम्, आसनम्, आत्मनः,\n" +
                "न, अत्युच्छ्रितम्, न, अतिनीचम्, चैलाजिनकुशोत्तरम्।।11।।","एक पवित्र स्थान में जो क्रमशः कुश घास, मृगचर्म और वस्त्र से ढका हुआ है, जो न तो बहुत ऊँचा है और न ही बहुत नीचा है, अपने लिए ऐसा दृढ़ आसन स्थापित किया है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 12","तत्रा, एकाग्रम्, मनः, कृत्वा, यतचितेन्द्रियक्रियः,\n" +
                "उपविश्य, आसने, युज्यात्, योगम्, आत्मविशुद्धये।। 12।।","उस आसन पर बैठकर मन और इन्द्रियों की क्रियाओं को वश में रखते हुए अन्तःकरण की शुद्धि के लिए एक चित्त होकर साधना करनी चाहिए।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 13","समम्, कायशिरोग्रीवम्, धारयन्, अचलम्, स्थिरः,\n" +
                "सम्प्रेक्ष्य, नासिकाग्रम्, स्वम्, दिशः, च, अनवलोकयन्।।13।।","अपने शरीर, सिर और गर्दन को सीधा और स्थिर रखते हुए, बिना किसी अन्य दिशा को देखे, नाक की नोक पर अपनी दृष्टि टिकाए रखना।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 14","प्रशान्तात्मा, विगतभीः, ब्रह्मचारिव्रते, स्थितः,\n" +
                "मनः, संयम्य, मच्चितः, युक्तः, आसीत, मत्परः।।14।।\n" +
                "\n","ब्रह्मचर्य व्रत में दृढ़, निर्भय और पर्याप्त शान्त अन्तरात्मा से मन को वश में करके और चित्त को लीन करके मातावलम्बी मत पर आधारित साधना में स्थित होना चाहिए अर्थात् काल जो विचार व्यक्त कर रहा है, उसका पालन करते हुए।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 15","युंजन्, एवम्, सदा, आत्मानम्, योगी, नियतमानसः,\n" +
                "शान्तिम्, निर्वाणपरमाम्, मत्संस्थाम्, अधिगच्छति।।15।।","इस प्रकार भक्त मेरे द्वारा बताए गए हठयोग के अनुसार मन को वश में करके निरन्तर ईश्वर की भक्ति में लगा रहता है, केवल मुझ पर आश्रित होकर पूर्व निर्धारित सिद्धांत के आधार पर करता है कि जैसा करता है वैसा ही फल प्राप्त होता है अर्थात् परम शांति अर्थात् लगभग प्राप्त होता है। अनात्म/नाममात्र शान्ति अर्थात् मुझसे नाममात्र की मुक्ति प्राप्त करता है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 16","न, अति, अश्नतः, तु, योगः, अस्ति, न, च, एकान्तम्, अनश्नतः,\n" +
                "न, च, अति, स्वप्नशीलस्य, जाग्रतः, न, एव, च, अर्जुन।।16।।","उपरोक्त श्लोक 10 से 15 में वर्णित विशेष आसन पर एकान्त स्थान में बैठकर साधना करने की विधि मेरे ही लाभ की प्राप्ति का साधन है; वास्तव में, यह अच्छा/श्रेष्ठ नहीं है। गीता अध्याय 7 श्लोक 18 में उन्होंने अपने द्वारा दिए जाने वाले लाभ (गति/मोक्ष) को निकृष्ट/हीन बताया है। इसलिए हे अर्जुन, इसके विपरीत उस पूर्ण परमात्मा की प्राप्ति की भक्ति न तो एकांत स्थान में किसी विशेष आसन या आसन पर बैठने से सफल होती है, न अधिक खाने वाले की और न ही भोजन न करने वाले की। सब यानी रोज़े रखना, न ज़्यादा सोने वाले का और न ज़ोर से जागने वाले का। अर्थात् उपरोक्त श्लोक 10 से 15 में बताई गई विधि व्यर्थ है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 17","क्ताहारविहारस्य, युक्तचेष्टस्य, कर्मसु,\n" +
                "युक्तस्वप्नावबोधस्य, योगः, भवति, दुःखहा।।17।।","समस्त दुखों का नाश करने वाली भक्ति उसी की सफल होती है जो आवश्यकता के अनुसार भोजन करता है; जो शास्त्रों के अनुसार कर्मों में उपयुक्त प्रयास करता है और जो आवश्यकता के अनुसार सोता और जागता है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 18","यदा, विनियतम्, चित्तम्, आत्मनि, एव, अवतिष्ठते,\n" +
                "निःस्पृहः, सर्वकामेभ्यः, युक्तः, इति, उच्यते, तदा।।18।।","जब एक परमेश्वर की शास्त्रानुकूल भक्ति में पूर्ण अनुशासित मन वास्तव में केवल भगवान में ही दृढ़ हो जाता है, उस समय कहा जाता है कि यह सभी इच्छाओं से मुक्त है अर्थात् भक्ति में लीन है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 19","यथा, दीपः, निवातस्थः, न, इंगते, सा, उपमा, स्मृता,\n" +
                "योगिनः, यतचित्तस्य, युज्तः, योगम्, आत्मनः।।19।।","जिस प्रकार निर्वात स्थान में रखा हुआ दीपक नहीं टिमटिमाता, उसी प्रकार एक प्रयत्नशील शास्त्रानुकूल भक्त के मन में पूर्णब्रह्म अर्थात् परमात्मा की साधना में लगे हुए अविच्छेद्य रूप में रहने वाले के मन का सुमिरन होता है। आत्मा।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 20","यत्रा, उपरमते, चित्तम्, निरुद्धम्, योगसेवया,\n" +
                "यत्रा, च, एव, आत्मना, आत्मानम्, पश्यन्, आत्मनि, तुष्यति।।20।।","जब मन संयम योग के अभ्यास से उपर्युक्त मतों पर आधारित हो जाता है और जब शास्त्रानुकूल भक्त आत्मा के साथ रहने वाले परमेश्वर को आत्मा के द्वारा सब जगह देखकर वास्तव में उस परमेश्वर में ही तृप्त रहता है। आत्मा से अविभाज्य अर्थात् वह डोलता नहीं है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 21","सुखम् आत्यन्तिकम्, यत्, तत्, बुद्धिग्राह्यम्, अतीन्द्रियम्,\n" +
                "वेत्ति, यत्रा, न, च, एव, अयम्, स्थितः, चलति, तत्त्वतः।।21।।","इंद्रियों के दायरे से परे, शुद्ध सूक्ष्म बुद्धि द्वारा ही प्राप्त करने योग्य शाश्वत आनंद, जिस अवस्था में व्यक्ति पूर्ण मोक्ष यानी कभी न खत्म होने वाले सुख के लिए परमेश्वर को प्राप्त करने का प्रयास करता है, उसका अनुभव करता है। और वास्तव में इस प्रकार स्थापित यह तत्वज्ञानी योगी विचलित नहीं होता।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 22","यम्, लब्ध्वा, च, अपरम्, लाभम्, मन्यते, न, अधिकम्, ततः,\n" +
                "यस्मिन्, स्थितः, न, दुःखेन, गुरुणा, अपि, विचाल्यते।।22।।","शास्त्रानुकूल साधना द्वारा एक ही परमात्मा में मन लगाने वाला साधक जिस लाभ को प्राप्त करके उससे बड़ा कोई लाभ नहीं समझता और जिसके फलस्वरूप साधक सन्मार्ग पर स्थिर हो जाता है। सच्ची भक्ति गहनतम दुःख से भी विचलित नहीं होती।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 23","तम्, विद्यात्, दुःखसंयोगवियोगम्, योगसज्ञितम्,\n" +
                "सः, निश्चयेन, योक्तव्यः, योगः, अनिर्विण्णचेतसा।।23।।","अज्ञान रूपी अंधकार से अज्ञात परमेश्वर की भक्ति के वास्तविक ज्ञान को जानना चाहिए, जो बुरे कर्मों के कारण उत्पन्न होने वाले दुखों को समाप्त करता है अर्थात् दूर करता है। वह भक्ति ऊबे नहीं अर्थात् मुरझाए मन को दृढ़ निश्चय के साथ करनी चाहिए।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 24","संकल्पप्रभवान्, कामान्, त्यक्त्वा, सर्वान्, अशेषतः,\n" +
                "मनसा, एव, इन्द्रियग्रामम्, विनियम्य, समन्ततः।।24।।","वास्तव में व्रतों से उत्पन्न समस्त कामनाओं का सर्वथा त्याग कर मन के द्वारा इन्द्रियों को सब दिशाओं से वश में करना।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 25","शनैः, शनैः, उपरमेत्, बुद्धया, धृतिगृृहीतया,\n" +
                "आत्मसंस्थम्, मनः, कृत्वा, न, किंचित्, अपि, चिन्तयेत्।।25।।","उपर्युक्त मत अर्थात् ज्ञानमय विचार द्वारा धीर-बुद्धि से मन को धीरे-धीरे अभ्यास और स्थिर करके परमात्मा में स्थिर कर देना चाहिए, किसी भी बात की चिन्ता नहीं करनी चाहिए।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 26","यतः, यतः, निश्चरति, मनः, चंचलम्, अस्थिरम्,\n" +
                "ततः, ततः, नियम्य, एतत्, आत्मनि, एव, वशम्, नयेत्।।26।।","यह चंचल और अशांत मन जहाँ-जहाँ भटके, वहाँ से हटाकर शास्त्रानुकूल भक्त, पूर्ण परमात्मा से धन्य आत्मा को ही अपने परमेश्वर के आश्रय से मन को वश में करना चाहिए।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 27","प्रशान्तमनसम्, हि, एनम्, योगिनम्, सुखम्, उत्तमम्,\n" +
                "उपैति, शान्तरजसम्, ब्रह्मभूतम्, अकल्मषम्।।27।।","शास्त्रों के नुस्खे को त्याग कर साधना करना पाप है। अतः निश्चय ही इस पाप को त्याग कर, शास्त्रानुकूल भक्त, जिसका मन एक परमेश्वर में पर्याप्त रूप से शांत है, जो पाप से मुक्त है, जो भौतिक सुख की इच्छा नहीं रखता, वह विधिपूर्वक भक्त, भगवान के हंस/आत्मा, परम सुख को प्राप्त करता है अर्थात् पूर्ण मोक्ष प्राप्त करता है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 28","युज्न्, एवम्, सदा, आत्मानम्, योगी, विगतकल्मषः,\n" +
                "सुखेन, ब्रह्मसंस्पर्शम्, अत्यन्तम्, सुखम्, अश्नुते।।28।।","पापमुक्त भक्त इस प्रकार निरन्तर समर्पण भाव से साधना करता हुआ परमात्मा के सहज मिलन रूपी परमात्मा के कभी न समाप्त होने वाले सुख का अनुभव करता है अर्थात् पूर्ण मुक्त हो जाता है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 29","सर्वभूतस्थम्, आत्मानम्, सर्वभूतानि, च, आत्मनि,\n" +
                "ईक्षते, योगयुक्तात्मा, सर्वत्रा, समदर्शनः।।29।।","जिसकी आत्मा भक्ति से युक्त है, जो सभी को समान भाव से देखता है, वह आत्मा से अविच्छेद्य परमात्मा को सभी प्राणियों में और अपने जैसे सभी प्राणियों में स्थित देखता है अर्थात् जैसे वह सुख-दुःख को अनुभव करता है, वैसे ही देखता है वे इस दृष्टिकोण से."));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 30","यः, माम्, पश्यति, सर्वत्रा, सर्वम्, च, मयि, पश्यति,\n" +
                "तस्य, अहम्, न, प्रणश्यामि, सः, च, मे, न, प्रणश्यति।।30।।","जो मुझे सर्वत्र देखता है और सबको मुझमें देखता है, उसके लिए मैं अदृश्य नहीं हूँ और वह मुझसे अदृश्य नहीं है अर्थात् वह केवल मेरी दृष्टि में ही मेरे जाल में है। उसे पूरा ज्ञान नहीं है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 31","सर्वभूतस्थितम्, यः, माम्, भजति, एकत्वम्, आस्थितः,\n" +
                "सर्वथा, वर्तमानः, अपि, सः, योगी, मयि, वर्तते।।31।।","जो एकत्व में स्थित होकर सब प्राणियों में स्थित मुझको भजता है, वह योगी इस समय भी सब प्रकार से मुझमें ही अभ्यास/निवास कर रहा है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 32","आत्मौपम्येन, सर्वत्रा, समम्, पश्यति, यः, अर्जुन,\n" +
                "सुखम्, वा, यदि, वा, दुःखम्, सः, योगी, परमः, मतः।।32।।","हे अर्जुन! जो योगी शास्त्रानुकूल साधना करके परमात्म कृपा का पात्र बनता है, उस पर ईश्वर की असाधारण कृपा होने से उसकी आत्मा परमात्मा के समान हो जाती है। इसलिए वह परमात्मा को देखता है, जो आत्मा के साथ अविच्छेद्य रूप में, हर जगह और सभी जीवों में समान रूप से रहता है, और सभी में समान रूप से सुख और दुःख देखता है। शास्त्रानुकूल आचरण वाला वह योगी श्रेष्ठ है"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 33","यः, अयम्, योगः, त्वया, प्रोक्तः, साम्येन, मधुसूदन,\n" +
                "एतस्य, अहम्, न, पश्यामि, चंचलत्वात्, स्थितिम्, स्थिराम्।।33।।","हे मधुसूदन! यह योग जो आपने समभाव से कहा है, मन के चंचल होने के कारण इसकी सनातन स्थिति मुझे दिखाई नहीं पड़ती।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 34","चंचलम्, हि, मनः, कृष्ण, प्रमाथि, बलवत्, दृढम्,\n" +
                "तस्य, अहम्, निग्रहम्, मन्ये, वायोः, इव, सुदुष्करम्।।34।।","क्योंकि हे श्रीकृष्ण! यह मन बड़ा चंचल, स्वभाव से अशांत, बड़ा हठी और शक्तिशाली है; इसलिए, इसे नियंत्रित करना, मेरा मानना है, हवा को नियंत्रित करने जितना ही कठिन है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 35","असंशयम्, महाबाहो, मनः, दुर्निग्रहम्, चलम्,\n" +
                "अभ्यासेन, तु, कौन्तेय, वैराग्येण, च, गृह्यते।।35।।","हे महाबाहु! निश्चय ही मन चंचल है और वश में करना अत्यन्त कठिन है, किन्तु हे कुन्तीपुत्र अर्जुन! इसे अभ्यास और वैराग्य द्वारा नियंत्रित किया जाता है"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 36","असंयतात्मना, योगः, दुष्प्रापः, इति, मे, मतिः,\n" +
                "वश्यात्मना, तु, यतता, शक्यः, अवाप्तुम्, उपायतः।।36।।","जिसका मन वश में नहीं है अर्थात् जो संयमी नहीं है, उसे भक्ति प्राप्त करना कठिन है, परन्तु शास्त्रानुकूल साधना करने वाला अर्थात् मनमाना साधना न करने वाला प्रयत्नशील व्यक्ति उचित साधन द्वारा प्राप्त करना संभव है, जिसका मन वश में नहीं है। नियंत्रण में। यह मेरा मत अर्थात् दृष्टि है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 37","अयतिः, श्रद्धया, उपेतः, योगात्, चलितमानसः,\n" +
                "अप्राप्य, योगसंसिद्धिम्, काम्, गतिम्, कृष्ण, गच्छति।।37।।","हे श्रीकृष्ण! जो योग में आस्था रखता है पर संयमी नहीं है, जिसका मन योग से विचलित हो गया है, योग में सिद्धि प्राप्त करने में असफल हो गया है, ऐसा उपासक योगी किस अवस्था को प्राप्त करता है?"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 38","कच्चित्, न, उभयविभ्रष्टः, छिन्नाभ्रम्, इव, नश्यति,\n" +
                "अप्रतिष्ठः, महाबाहो, विमूढः, ब्रह्मणः, पथि।।38।।","हे महाबाहु! क्या वह मूर्ख परमेश्वर की प्राप्ति के मार्ग से भटक गया है; जो शास्त्र विधि को त्याग कर साधना करता है उसे ईश्वर का सहयोग नहीं मिलता; ऐसा व्यक्ति, बिना सहारे के, दोनों ओर से गिरा हुआ, फटे हुए बादल की तरह नष्ट नहीं हो जाता?"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 39","एतत्, मे, संशयम्, कृष्ण, छेत्तुम्, अर्हसि, अशेषतः,\n" +
                "त्वदन्यः, संशयस्य, अस्य, छेत्ता, न, हि, उपपद्यते।।39।।","हे श्रीकृष्ण! मेरे इस संशय को पूर्णतया दूर करने के योग्य तो आप ही हैं क्योंकि इस संशय को दूर करने वाला आपके अतिरिक्त और कोई मिल ही नहीं सकता।\n"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 40","पार्थ, न, एव, इह, न, अमुत्रा, विनाशः, तस्य, विद्यते,\n" +
                "न, हि, कल्याणकृत्, कश्चित्, दुर्गतिम्, तात, गच्छति।।40।।","ओह पार्थ! वास्तव में मार्ग से भटका हुआ साधक न तो इस लोक का रहता है और न उस लोक का। उसका विनाश ही ज्ञात है। निस्सन्देह जो मनुष्य अन्तिम श्वास तक आत्मकल्याण के लिए कर्म नहीं करता अर्थात् योग से विमुख हो जाता है, हे प्रिय, उसका भाग्य विपत्ति में पड़ जाता है। इसका प्रमाण गीता अध्याय 4 श्लोक 40 में भी दिया है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 41","प्राप्य, पुण्यकृताम्, लोकान्, उषित्वा, शाश्वतीः, समाः,\n" +
                "शुचीनाम्, श्रीमताम्, गेहे, योगभ्रष्टः, अभिजायते।।41।।","चौरासी लाख जन्मों के कष्टों को भोग कर भक्ति से भटका हुआ मनुष्य पुण्य कर्मों के आधार पर पुण्य लोकों अर्थात् स्वर्ग आदि लोकों में जाता है और वहाँ वेदों की वाणी के आधार पर निश्चित काल तक निवास करने के बाद ग्रहण करता है। धर्मी और प्रतिष्ठित लोगों के घर में जन्म। निम्न श्लोक 42 में कहा है कि ऐसा जन्म दुर्लभ है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 42","अथवा, योगिनाम्, एव, कुले, भवति, धीमताम्,\n" +
                "एतत्, हि, दुर्लभतरम्, लोके, जन्म, यत्, ईदृृशम्।।42।।","या विद्वान योगियों के परिवार में जन्म लेता है। वास्तव में इस प्रकार का जन्म, जो यह है, निस्संदेह संसार में बहुत दुर्लभ है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 43","तत्र, तम्, बुद्धिसंयोगम्, लभते, पौर्वदेहिकम्,\n" +
                "यतते, च, ततः, भूयः, संसिद्धौ, कुरुनन्दन।।43।।","यदि वहाँ वह अनायास पूर्व जन्म/जन्म में संचित प्रारब्ध बुद्धि को पुनः प्राप्त कर लेता है, और हे कुरुनन्दन! उसके बाद पुनः ईश्वर प्राप्ति की आध्यात्मिक सिद्धि प्राप्त करने का प्रयत्न करता है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 44","पूर्वाभ्यासेन, तेन, एव, ह्रियते, हि, अवशः, अपि, सः,\n" +
                "जिज्ञासुः, अपि, योगस्य, शब्दब्रह्म, अतिवर्तते।।44।।","वह साधक मार्ग से भटका हुआ, स्वभाव से लाचार, वास्तव में उस पूर्व साधना से ही आकर्षित होता है, क्योंकि ईश्वर की भक्ति का जिज्ञासु व्यक्ति भी शास्त्रों में वर्णित भगवान की भक्ति विधि के अनुसार पूजा न करने के कारण विचलित हो जाता है। पूर्व स्वभाव से उस वास्तविक नाम का जाप न करके ईश्वर की वाणी रूपी आज्ञा का उल्लंघन करता है। क्योंकि पूर्व स्वभाव से वह फिर विचलित हो जाता है। इसलिए गीता अध्याय 7 श्लोक 16-17 में जिज्ञासु को अच्छा नहीं कहा है। एक ईश्वर की भक्ति करने वाला ज्ञानी भक्त ही श्रेष्ठ कहा जाता है। गीता अध्याय 18 श्लोक 58 में भी प्रमाण है।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 45","प्रयत्नात्, यतमानः, तु, योगी, संशुद्धकिल्बिषः,\n" +
                "अनेकजन्मसंसिद्धः, ततः, याति, पराम्, गतिम्।।45।।","इसके विपरीत शास्त्रानुकूल भक्त जिसे परमेश्वर का आश्रय प्राप्त है, वह संयमी अर्थात् प्रयत्नशील व्यक्ति जिसने अपने मन पर विजय प्राप्त कर ली है, सत्य भक्ति के पुरुषार्थ से तथा अनेक जन्मों की भक्ति की कमाई से निष्पाप होकर तुरन्त परमगति को प्राप्त हो जाता है। उसी जन्म में।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 46","तपस्विभ्यः, अधिकः, योगी, ज्ञानिभ्यः, अपि, मतः, अधिकः,\n" +
                "कर्मिभ्यः, च, अधिकः, योगी, तस्मात्, योगी, भव, अर्जुन।।46।।","भगवान कह रहे हैं कि तत्वदर्शी संत से ज्ञान प्राप्त करने के बाद नाम की साधना करने वाला भक्त उन तपस्वियों से श्रेष्ठ है जो भक्ति के बल से साधना करते हैं अर्थात श्लोक 10 से 15 में वर्णित हठयोग द्वारा पूजा की विधि के ज्ञान के अनुसार अर्थात् मेरे द्वारा दी गई साधना पर अनुमानित मत तथा गीता अध्याय 7 श्लोक 16-17 में वर्णित विद्वानों तथा कर्म करने वालों अर्थात् शास्त्रविरुद्ध साधना करने वालों को। इसलिए हे अर्जुन गीता अध्याय 4 श्लोक 34 में वर्णित तत्वदर्शी संत को पाकर उनसे आध्यात्मिक उपदेश लेकर शास्त्रानुकूल भक्त बनो।"));
        list6.add(new GeetaModel("Adhya 6","गीता श्लोक 47","\n" +
                "योगिनाम्, अपि, सर्वेषाम्, मद्गतेन, अन्तरात्मना,\n" +
                "श्रद्धावान्, भजते, यः, माम्, सः, मे, युक्ततमः, मतः।।47।।","समस्त योगियों में भी जो मेरे द्वारा दिये गये मत के अनुसार अन्तरात्मा से मेरा भजन करता है, वह योगी मेरे मत के अनुसार यथार्थ रूप से भक्ति में लीन रहता है।\n"));

    }

    private void addDataToList5() {
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 1","सóयासम्, कर्मणाम्, कृष्ण, पुनः, योगम्, च, शंससि,\n" +
                "यत्, श्रेयः, एतयोः, एकम्, तत्, मे, ब्रूहि, सुनिश्चितम्।।1।।","हे कृष्ण! आप कर्मों के सन्यास (कर्म) अर्थात् कर्मों को त्याग कर साधना करने, आसन में बैठने, कान बन्द करने आदि की स्तुति करते हैं और फिर कर्मयोग अर्थात् कर्म करते हुए साधना करने की स्तुति करते हैं। अत: इन दोनों में से वह मार्ग बताओ जो निश्चय ही मेरे लिए शुभ हो।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 2","सóयासः, कर्मयोगः, च, निःश्रेयसकरौ, उभौ,\n" +
                "तयोः, तु, कर्मसóयासात्, कर्मयोगः, विशिष्यते।।2।।","तत्वदर्शी संत न मिलने के कारण तथा सच्ची भक्ति का ज्ञान न होने के कारण शास्त्रविरुद्ध साधना प्राप्त साधक ईश्वर प्राप्ति की उत्कंठा से प्रेरित होकर घर त्याग कर वन में चला जाता है या बैठे बैठे कर्मों का त्याग कर देता है। एक स्थान पर नाक कान आदि बन्द करना या साधना करना तथा कर्म करते हुए शास्त्राविधि रहित साधना भी करना, दोनों ही व्यर्थ अर्थात् शुभ नहीं हैं और करने योग्य नहीं हैं। जो शास्त्र विधि के अनुसार साधना करते हैं और सन्यास लेते हैं वे मठ में रहते हैं और कर्म सन्यास नहीं लेते हैं और जो विवाह करके घर में रहते हैं, दोनों की पूजा का विधान है। वे अशुभ नहीं हैं, परंतु उपर्युक्त दोनों में भी यदि किसी मठ में रहकर भी कोई काम-चोर है तो उस कर्म सन्यास की तुलना में कर्मयोग अर्थात् सांसारिक कर्म करते हुए शास्त्रानुकूल साधना करना श्रेष्ठ है।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 3","ज्ञेयः, सः, नित्यसóयासी, यः, न, द्वेष्टि, न, काङ्क्षति,\n" +
                "निद्र्वन्द्वः, हि, महाबाहो, सुखम्, बन्धात्, प्रमुच्यते।।3।।","हे अर्जुन! जो भक्त न तो किसी से द्वेष करता है और न ही किसी से कामना करता है, वह तत्वदर्शी क्योंकि जिस व्यक्ति में राग-द्वेष होता है, उसका मन भटकता रहता है और इनसे रहित भक्त का मन कर्म करते हुए भी भगवान की भक्ति और स्तुति में लगा रहता है, इसलिए, वह हमेशा एक सन्यासी होता है। क्योंकि कर्मों के बन्धन से पूर्ण मुक्ति के सुख को जानने योग्य ज्ञान का सही-सही वर्णन वही करता है।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 4","साङ्ख्ययोगौ, पृथक्, बालाः, प्रवदन्ति, न, पण्डिताः,\n" +
                "एकम्, अपि, आस्थितः, सम्यक्, उभयोः, विन्दते, फलम्।।4।।","अज्ञानी कहते हैं कि तत्वज्ञान के आधार पर जो एक प्रकार की साधना गृहस्थ या कुंवारे होकर करते हैं, दोनों को भिन्न-भिन्न फल प्राप्त होते हैं। वे पंडित भी नहीं हैं। जो व्यक्ति वास्तव में एक सर्वशक्तिमान ईश्वर में स्थित हैं, वे दोनों तत्वज्ञान के आधार पर समान परिणाम प्राप्त करते हैं। गीता अध्याय 13 श्लोक 24-25 में सजीव वर्णन है।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 5","यत्, साङ्ख्यैः, प्राप्यते, स्थानम्, तत्, योगैः, अपि, गम्यते,\n" +
                "एकम्, साङ्ख्यम्, च, योगम्, च, यः, पश्यति, सः, पश्यति।।5।।","शास्त्राविधि अनुसार साधना करने से जो स्थान तत्वज्ञानियों को प्राप्त होता है वही स्थान सामान्य व्यक्तियों अर्थात् कर्मयोगियों को भी तत्वदर्शी से उपदेश लेकर प्राप्त होता है। इसलिए जो ज्ञानयोग और कर्मयोग को फल रूप में एक ही देखता है, वही यथार्थ को देखता है; जिसका अर्थ है कि वह वास्तव में भक्ति मार्ग को जानता है।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 6","सóयासः, तु, महाबाहो, दुःखम्, आप्तुम्, अयोगतः,\n" +
                "योगयुक्तः, मुनिः, ब्रह्म, नचिरेण, अधिगच्छति।।6।।","हे अर्जुन! इसके विपरीत कर्म सन्यास/कर्म सन्यास शास्त्राविधि विरुद्ध साधना होने के कारण केवल दु:ख ही देता है और शास्त्रानुकूल साधना करने वाला भक्त शीघ्र ही भगवान को प्राप्त कर लेता है।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 7","योगयुक्तः, विशुद्धात्मा, विजितात्मा, जितेन्द्रियः,\n" +
                "सर्वभूतात्मभूतात्मा, कुर्वन्, अपि, न, लिप्यते।।7।।","वह, जिसका मन तत्वज्ञान और सच्ची भक्ति के कारण संदेह से मुक्त है, एक पवित्र आत्मा जिसने अपनी इंद्रियों को जीत लिया है, वह जीव, जिसने तत्वज्ञान प्राप्त कर लिया है, सभी जीवों के स्वामी की सच्ची भक्ति द्वारा सभी जीवों को समझकर आत्मा रूप में सत्य भक्ति में लीन संसार में रहते हुए तथा सांसारिक कर्मों को करते हुए भटकता नहीं अर्थात् संतान और धन के प्रति आसक्त नहीं होता। क्योंकि उसे तत्वज्ञान से ज्ञान हो जाता है कि यह वंश और धन मेरा नहीं है। उदाहरण के लिए, यदि कोई व्यक्ति किसी होटल में ठहरा हुआ है, तो वह वहाँ नौकरों और अन्य सामग्री (टी.वी., सोफा सेट, टेलीफोन, बिस्तर और जिस कमरे में वह रहता है) को अपना नहीं मानता है। वह व्यक्ति जानता है कि ये मेरे नहीं हैं। इसलिए न तो वह उनसे द्वेष करता है और न ही किसी प्रकार की आसक्ति रखता है और अपने मुख्य लक्ष्य को नहीं भूलता। इसलिए जिस घर में हम रह रहे हैं, यह सब धन-संपत्ति को अपना न मानकर प्रेमपूर्वक रहते हुए परमात्मा को पाने की इच्छा को बनाए रखना चाहिए।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 8,9","न, एव, कि×िचत्, करोमि, इति, युक्तः, मन्येत, तत्त्ववित्,\n" +
                "पश्यन्, श्रृण्वन्, स्पृशन्, जिघ्रन्, अश्नन्, गच्छन्, स्वपन्,।।8।।\n" +
                "\n" +
                "श्वसन्, प्रलपन्, विसृजन्, गृह्णन्, उन्मिषन्, निमिषन्, अपि,\n" +
                "इन्द्रियाणि, इन्द्रियार्थेषु, वर्तन्ते, इति, धारयन्।। 9।।","तत्वदर्शी – योगी/भक्त देखते, सुनते, छूते, सूंघते, खाते, चलते, सोते, सांस लेते, बोलते, देते, लेते, आंखें खोलते और बंद करते हुए भी ईश्वर में लीन रहते हैं, यह समझकर कि सभी इंद्रियां अपने आप में कार्य कर रही हैं वस्तुएँ अर्थात् मैं कोई भी अशुभ कार्य नहीं करता हूँ। वह निश्चय ही यह मानता है कि मैं कुछ भी नहीं करता अर्थात् ऐसा कार्य नहीं करता जिससे पाप लगता हो।"));

        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 10","ब्रह्मणि, आधाय, कर्माणि, संगम्, त्यक्त्वा, करोति, यः,\n" +
                "लिप्यते, न, सः, पापेन, पद्मपत्राम्, इव, अम्भसा।।1।।","जो मनुष्य समस्त कर्मों को पूर्ण परमात्मा को अर्पण करके आसक्ति को त्यागकर शास्त्रविधि के अनुसार कर्म करता है, वह भक्त पाप से उसी प्रकार कलंकित नहीं होता जैसे कमल का पत्ता जल अर्थात् परमेश्वर की भक्ति से दूषित नहीं होता। एक भक्त उन सभी बंधनों से मुक्त हो जाता है जो पाप कर्मों के परिणामस्वरूप बनते हैं।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 11","कायेन, मनसा, बुद्धया, केवलैः, इन्द्रियैः, अपि,\n" +
                "योगिनः, कर्म, कुर्वन्ति, संगम्, त्यक्त्वा, आत्मशुद्धये।।11।।","इस संसार में रहने वाले भक्त इन्द्रियों, मन, बुद्धि और शरीर की आसक्ति को त्याग कर भी होटल में रहने की तरह अंतःकरण की शुद्धि के लिए सतनाम का स्मरण, दान, सतगुरु की सेवा और संसार में सदाचार जैसे कर्म करते हैं। यानी आत्म-कल्याण के लिए।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 12","युक्तः, कर्मफलम्, त्यक्त्वा, शान्तिम्, आप्नोति, नैष्ठिकीम्,\n" +
                "अयुक्तः, कामकारेण, फले, सक्तः, निबध्यते।।12।।","शास्त्रानुकूल सत साधना में लगा हुआ भक्त कर्मफल को त्याग कर नित्य अर्थात् परमशान्ति को प्राप्त होता है और आषाढ़ अर्थात् शास्त्र विधि से रहित साधना करने वाला कर्म फल में आसक्त होकर सिद्धि के लिए होता है इच्छाओं का, पाप कर्मों के परिणामस्वरूप बंध जाता है।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 13","सर्वकर्माणि, मनसा, सóयस्य, आस्ते, सुखम्, वशी,\n" +
                "नवद्वारे, पुरे, देही, न, एव, कुर्वन्, न, कारयन्।।13।।","तत्वज्ञान के आधार पर काल लोक के लाभों से मन को भटकाना और संचित कर्मों के आधार पर अर्थात् सभी शास्त्रानुकूल धार्मिक कृत्यों से सच्ची भक्ति की संचित कमाई अर्थात् सच्ची साधना से पूर्ण निश्चय के साथ वास्तविक में निवास करता है। सुख अर्थात् सतलोक में जो पूर्ण मोक्ष की परम शांति से युक्त है। इस प्रकार जीवात्मा अर्थात् परमात्मा से अविभाज्य आत्मा नौ द्वारों वाले पाँच तत्वों के दुर्ग रूपी शरीर में न तो क्रिया करता है और न करवाता है, पूर्ण मोक्ष प्राप्त करके ही सुखपूर्वक सतलोक में निवास करता है।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 14","न, कर्तृत्वम्, न, कर्माणि, लोकस्य, सृजति, प्रभुः,\n" +
                "न, कर्मफलसंयोगम्, स्वभावः, तु, प्रवर्तते।।14।।","कुल के स्वामी परमेश्वर सर्वप्रथम संसार की रचना करते हैं। उस समय न तो कर्त्तापन का आधार था, न कर्मों का और न कर्म-फल के योग का। इसके विपरीत प्रकृति द्वारा समस्त प्राणियों द्वारा किये गये कर्म का फल ही कार्य कर रहा है"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 15","न, आदत्ते, कस्यचित्, पापम्, न, च, एव, सुकृतम्, विभुः,\n" +
                "अज्ञानेन, आवृतम्, ज्ञानम्, तेन, मुह्यन्ति, जन्तवः।।15।।","परमेश्वर न तो किसी के पाप का फल देता है, न किसी के शुभ कर्मों का फल देता है अर्थात् निर्धारित नियमों के अनुसार फल देता है लेकिन ज्ञान अज्ञान से ढका रहता है। तत्वज्ञान के अभाव में समस्त पशुरूपी अज्ञानी पुरुष उसी से मोहित हो रहे हैं अर्थात् अपने स्वभाव से हटकर भक्ति के कर्म कर रहे हैं और शास्त्रविधि के विपरीत सांसारिक कर्म अल्पकाल के सुख की ओर आकृष्ट हो रहे हैं। जो भक्त शास्त्रों के अनुसार भक्ति करते हैं, उनके पाप भगवान क्षमा कर देते हैं अन्यथा जो प्रारब्ध होता है वह दे देते हैं। इसका विस्तृत विवरण पवित्र गीता अध्याय 16 व 17 में देखें।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 16","ज्ञानेन, तु, तत्, अज्ञानम्, येषाम्, नाशितम्, आत्मनः,\n" +
                "तेषाम्, आदित्यवत्, ज्ञानम्, प्रकाशयति, तत्परम्।।16।।","दूसरी ओर जिनका अज्ञान उस परमेश्वर के तत्वज्ञान से नष्ट हो गया है, जो आत्मा का अभिन्न साथी है और इसलिए आत्मा कहा जाता है, उनका वह तत्वज्ञान उस पूर्ण परमात्मा को सूर्य के समान प्रकाशित करता है अर्थात् अज्ञान के अंधकार को दूर करता है।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 17","तद्बुद्धयः, तदात्मानः, तन्निष्ठाः, तत्परायणाः,\n" +
                "गच्छन्ति, अपुनरावृत्तिम्, ज्ञाननिर्धूतकल्मषाः।।17।।","तत्वज्ञान (सच्चा आध्यात्मिक ज्ञान) से सुसज्जित वह सन्निहित आत्मा, जिसका मन उस परमेश्वर के सच्चे ज्ञान में पूरी तरह से लगा हुआ है, वह हमेशा सर्वव्यापी भगवान में एकचित्त रूप से स्थित है। उस परमात्मा पर आधारित तत्वज्ञान के आधार पर शास्त्राविधि विरुद्ध साधना करना भी पाप है और उसके फलस्वरूप पुण्य के स्थान पर पाप ही लगता है; इसलिए सत्य भक्ति करके पापमुक्त होकर जन्म-मरण से मुक्त होकर संसार में न लौटने की स्थिति को प्राप्त करते हैं अर्थात् पूर्ण मुक्ति/मोक्ष को प्राप्त करते हैं।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 18","विद्याविनयसम्पन्ने, ब्राह्मणे, गवि, हस्तिनि,\n" +
                "शुनि, च, एव, श्वपाके, च, पण्डिताः, समदर्शिनः।।18।।","पूर्ण रूप से गुप्त तत्वज्ञान से युक्त अर्थात् पूर्ण तत्वज्ञानी भक्त ब्राह्मण, गाय, हाथी, कुत्ते तथा जाति से बाहर को समभाव से देखता है। वास्तव में जिसमें ऐसे गुण होते हैं वही विद्वान अर्थात् तत्वज्ञानी होता है।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 19","इह, एव, तैः, जितः, सर्गः, येषाम्, साम्ये, स्थितम्, मनः,\n" +
                "निर्दोषम्, हि, समम्, ब्रह्म, तस्मात्, ब्रह्मणि, ते, स्थिताः।।19।।","वास्तव में जिनका चित्त समचित्त में स्थित है, उन्होंने इसी जीवित अवस्था में सारे संसार को जीत लिया है अर्थात् वे मनजीत हो गए हैं। निस्सन्देह वे पापमुक्त भक्त भगवान के तुल्य हैं अर्थात् निष्पाप आत्मा बन गये हैं और इसलिए पूर्ण परमात्मा में ही स्थित हैं। पाप रहित आत्मा और ईश्वर के अनेक गुण एक जैसे हैं, जैसे शाश्वत, प्रेम-द्वेष से मुक्त, जन्म-मृत्यु से मुक्त, आत्म-प्रकाशित; हालांकि शक्ति में बहुत अंतर है।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 20","न, प्रहृष्येत्, प्रियम्, प्राप्य, न, उद्विजेत्, प्राप्य, च, अप्रियम्,\n" +
                "स्थिरबुद्धिः, असम्मूढः, ब्रह्मवित्, ब्रह्मणि, स्थितः।।20।।","जो न तो प्रिय को पाकर हर्षित होता है, न अप्रिय को पाकर निराश होता है, वह स्थिरबुद्धि, संशय से रहित और ईश्वर के सार का पूर्ण ज्ञान रखने वाला व्यक्ति सदा परमात्मा में ही स्थित रहता है।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 21","बाह्यस्पर्शेषु, असक्तात्मा, विन्दति, आत्मनि, यत्, सुखम्,\n" +
                "सः, ब्रह्मयोगयुक्तात्मा, सुखम्, अक्षयम्, अश्नुते।।21।।","जो भक्त बाह्य विषयों में आसक्त नहीं होता, सुमिरन का जो सुख अपने भीतर पाता है, वह भक्त आत्मा परमात्मा की भक्ति साधना में एकाग्रचित्त होकर नित्य आनंद अर्थात् पूर्ण मोक्ष को प्राप्त करता है।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 22","ये, हि, संस्पर्शजाः, भोगाः, दुःखयोनयः, एव, ते,\n" +
                "आद्यन्तवन्तः, कौन्तेय, न, तेषु, रमते, बुधः।।22।।","वास्तव में इन्द्रियों और इन्द्रियविषयों के योग से उत्पन्न होने वाले ये सभी सुख निश्चय ही दुखमय जन्मों के कारण हैं, जिनका आदि और अंत है अर्थात् शाश्वत नहीं हैं। हे अर्जुन! एक बुद्धिमान, समझदार व्यक्ति उनके प्रति आकर्षित नहीं होता है।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 23","शक्नोति, इह, एव, यः, सोढुम्, प्राक्, शरीरविमोक्षणात्,\n" +
                "कामक्रोधोद्भ्वम्, वेगम्, सः, युक्तः, सः, सुखी, नरः।।23।।","शरीर के नाश से पहले जो भक्त इस मानव शरीर में काम और क्रोध से उत्पन्न आवेगों को सहन करने में सक्षम हो जाता है, वही व्यक्ति भगवान में लीन भक्त है और वही सुखी है।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 24","यः, अन्तःसुखः, अन्तरारामः, तथा, अन्तज्र्योतिः, एव, यः,\n" +
                "सः, योगी, ब्रह्मनिर्वाणम्, ब्रह्मभूतः, अधिगच्छति।।24।।","अपने अन्तर्मन में प्रसन्न रहने वाला दृढ़निश्चयी पुरुष, जो उस सर्वज्ञ परमात्मा में ही लीन है, जो सर्वज्ञ रूप में आत्मा के साथ रहता है और जो भीतर से प्रकाशित होता है अर्थात् पवित्र ज्ञान के आधार पर सच्ची भक्ति करते हुए भटकता नहीं है। शास्त्रों के अनुसार ईश्वर तुल्य गुणों से युक्त भक्त शान्त ब्रह्म अर्थात् पूर्ण परमात्मा को प्राप्त करता है।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 25","लभन्ते, ब्रह्मनिर्वाणम्, ऋषयः, क्षीणकल्मषाः,\n" +
                "छिन्नद्वैधाः, यतात्मानः, सर्वभूतहिते, रताः।।25।।","शास्त्रानुकूल साधना करने से जिनके सर्व पाप नष्ट हो गए हैं, जिनके सब संशय दूर हो गए हैं अर्थात् जो पथ से विचलित नहीं हुए हैं, जो समस्त प्राणियों के कल्याण में लगे हुए हैं और जो पुरुषार्थ अर्थात् साधना में लगे हुए हैं भगवान, वे साधु पुरुष शान्त ब्रह्म अर्थात् पूर्ण परमात्मा को प्राप्त होते हैं।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 26","कामक्रोधवियुक्तानाम्, यतीनाम्, यतचेतसाम्,\n" +
                "अभितः, ब्रह्मनिर्वाणम्, वर्तते, विदितात्मनाम्।।26।।","जो पुरुष काम और क्रोध से मुक्त हैं, ईश्वर की भक्ति में मेहनती हैं, जिन्होंने भगवान को देखा और मिला है, जो भगवान के आश्रित हैं, वे केवल शांतिपूर्ण ब्रह्म अर्थात् पूर्ण ब्रह्म परमात्मा (पूर्ण / सर्वोच्च भगवान) से निपटते हैं। सम्मान अर्थात् केवल एक पूर्ण/परम ईश्वर की पूजा करें।"));
        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 27,28","स्पर्शान्, कृत्वा, बहिः, बाह्यान्, चक्षुः, च, एव, अन्तरे, भ्रुवोः,\n" +
                "प्राणापानौ, समौ, कृत्वा, नासाभ्यन्तरचारिणौ।।27।।\n" +
                "\n" +
                "यतेन्द्रियमनोबुद्धिः, मुनिः, मोक्षपरायणः,\n" +
                "विगतेच्छाभयक्रोधः, यः, सदा, मुक्तः, एव, सः।।28।।","वास्तव में बाह्य विषयों के सुखों को बाहर निकालकर दृष्टि को भृकुटि (भौंहों) के मध्य में स्थिर करके नथुनों में चलने वाले आने-जाने वाले श्वासों को सम करके सत्यनाम का सुमिरन करने वाला, इन्द्रियों, मन और इंद्रियों को जीत लेने वाला बुद्धि अर्थात् जो नाम के सुमिरन में ध्यान लगाता है और अपने मन को भटकने नहीं देता, ऐसा चिंतनशील उपासक जो मोक्ष प्राप्ति के लिए समर्पित है और इच्छा, भय और क्रोध से मुक्त हो गया है, वास्तव में वह सदा मुक्त है।"));

        list5.add(new GeetaModel("Adhya 5","गीता श्लोक 29","भोक्तारम्, यज्ञतपसाम्, सर्वलोकमहेश्वरम्,\n" +
                "सुहृदम्, सर्वभूतानाम्, ज्ञात्वा, माम्, शान्तिम्, ऋच्छति।।29।।","जो लोग मुझे समस्त यज्ञों और तपस्याओं का भोक्ता, समस्त लोकों के देवों का देव, निःस्वार्थ करुणामय तथा समस्त प्राणियों का प्रेमी मानते हैं, मुझ पर आश्रित रहते हैं, उनकी शांति पूर्णतया समाप्त हो जाती है अर्थात् उनकी क्षमता समाप्त हो जाती है। शांति में रहना समाप्त होता है। इसलिए मेरा भक्त भी बड़ा संकट में रहता है॥ इसका प्रमाण गीता अध्याय 2 श्लोक 66 में भी है कि शांति विहीन व्यक्ति को क्या सुख होता है और अध्याय 7 श्लोक 18 तथा गीता अध्याय 6 श्लोक 15 में भी स्पष्ट है। इसलिए गीता अध्याय 15 श्लोक 16-17 में कहते हैं कि वास्तव में पूर्ण परमात्मा अर्थात् पूर्ण मोक्ष दाता कोई और ही परमात्मा है; इसलिए गीता अध्याय 18 के श्लोक 62-64-66 में कहा है कि अर्जुन सब प्रकार से उस परमात्मा की शरण में जा, जिसकी कृपा से ही तू परमशान्ति तथा परम सनातन धाम अर्थात् सत्यलोक को प्राप्त होगा।"));


    }

    private void addDataToList4() {
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 1","इमम्, विवस्वते, योगम्, प्रोक्तवान्, अहम्, अव्ययम्,\n" +
                "विवस्वान्, मनवे, प्राह, मनुः, इक्ष्वाकवे, अब्रवीत्।।1।।","यह सनातन भक्ति मैंने सूर्य से कही थी, सूर्य ने अपने पुत्र वैवस्वत मनु से और मनु ने अपने पुत्र राजा इक्ष्वाकु से यह कहा था।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 2","एवम्, परम्पराप्राप्तम्, इमम्, राजर्षयः, विदुः,\n" +
                "सः, कालेन, इह, महता, योगः, नष्टः, परन्तप।।2।।","हे परंतप अर्जुन! इस तरह शाही संतों ने भक्ति के इस तरीके के बारे में सीखा जो नियमित उत्तराधिकार में दिया गया था। परन्तु उसके बाद वह योग अर्थात् भक्ति मार्ग दीर्घ काल व्यतीत होने के कारण इस लोक में लुप्त हो गया।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 3","सः, एव, अयम्, मया, ते, अद्य, योगः, प्रोक्तः, पुरातनः,\n" +
                "भक्तः, असि, मे, सखा, च, इति, रहस्यम्, हि, एतत्, उत्तमम्।।3।।","आप मेरे भक्त भी हैं और मित्र भी। इसलिए मैंने यही कहा है कि यह प्राचीन, पुराना और वास्तविक भक्ति मार्ग आपके लिए है क्योंकि यह एक परम रहस्य है अर्थात यह मामला गुप्त रखने योग्य है।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 4","अपरम्, भवतः, जन्म, परम्, जन्म, विवस्वतः,\n" +
                "कथम्, एतत्, विजानीयाम्, त्वम्, आदौ, प्रोक्तवान् इति।।4।।","आपका जन्म दीर्घकाल का नहीं है अर्थात् हाल ही का है और सूर्य का जन्म अति प्राचीन काल का है। मैं इसे कैसे समझूँ कि आपने ही युग के आदि में सूर्य से यह योग कहा था?"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 5","बहूनि, मे, व्यतीतानि, जन्मानि, तव, च, अर्जुन,\n" +
                "तानि, अहम्, वेद, सर्वाणि, न, त्वम्, वेत्थ, परन्तप।।5।।","हे परंतप अर्जुन! आपके और मेरे कई जन्म हुए हैं। आप उन सभी को नहीं जानते लेकिन मैं जानता हूं।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 6","अजः, अपि, सन्, अव्ययात्मा, भूतानाम्, ईश्वरः, अपि, सन्,\n" +
                "प्रकृतिम्, स्वाम्, अधिष्ठाय, सम्भवामि, आत्ममायया।।6।।","मैं, मनुष्य के रूप में जन्म नहीं लेने वाला और अमर आत्मा होने के साथ-साथ अपने 21 ब्रह्मण्डों के जीवों का स्वामी होने के नाते, अपनी प्रकृति, दुर्गा को अपनी पत्नी के रूप में वश में करके, अपने अंगों को अर्थात् उत्पन्न करता हूँ। पुत्र, श्री ब्रह्मा जी, श्री विष्णु जी और श्री शिव जी; फिर उन्हें श्री कृष्ण, श्री राम, श्री परशुराम आदि अवतारों के रूप में प्रकट करें।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 7","यदा, यदा, हि, धर्मस्य, ग्लानिः, भवति, भारत,\n" +
                "अभ्युत्थानम्, अधर्मस्य, तदा, आत्मानम्, सृजामि, अहम्।।7।।","हे भरत! जब-जब धर्म का ह्रास होता है और अधर्म का उदय होता है, तभी मैं अपना आंशिक अवतार उत्पन्न करता हूँ।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 8","परित्राणाय, साधूनाम्, विनाशाय, च, दुष्कृृताम्,\n" +
                "धर्मसंस्थापनार्थाय, सम्भवामि, युगे, युगे।।8।।","साधु पुरुषों की रक्षा के लिए, दुष्टों का विनाश करने के लिए और भक्तिमार्ग को शास्त्रानुकूल दिशा देने के लिए मैं युग-युग में अपने अंगों को प्रकट करता हूँ और उनमें गुप्त रूप से प्रवेश करके अपनी दिव्य लीला करता हूँ।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 9","जन्म, कर्म, च, मे, दिव्यम्, एवम्, यः, वेत्ति, तत्त्वतः,\n" +
                "त्यक्त्वा, देहम्, पुनः, जन्म, न, एति, माम्, एति, सः, अर्जुन।।9।।","हे अर्जुन! मेरे जन्म और कर्म दैवी अर्थात् दिव्य हैं। इस प्रकार जो इस बात को तत्व से समझता है, वह शरीर त्यागने पर फिर जन्म नहीं लेता, परन्तु जो मुझ काल को नहीं जानता, वह तत्व रूप में मेरे पास ही आता है।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 10","वीतरागभयक्रोधाः, मन्मयाः, माम्, उपाश्रिताः,\n" +
                "बहवः, ज्ञानतपसा, पूताः, मद्भावम्, आगताः।।10।।","जिनका प्रेम, भय और क्रोध सर्वथा नष्ट हो गया है और जो अनन्य प्रेम से मुझमें एकाग्र रहते हैं, ऐसे अनेक भक्त, जो मुझ पर आश्रित हैं, उपर्युक्त ज्ञान की तपस्या से शुद्ध होकर मतावलंबी अर्थात् प्रकृति के हो गए हैं। शास्त्रों के अनुसार पूजा करना।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 11","ये, यथा, माम्, प्रपद्यन्ते, तान्, तथा, एव, भजामि, अहम्,\n" +
                "मम्, वत्र्म, अनुवर्तन्ते, मनुष्याः, पार्थ, सर्वशः।।11।।","हे अर्जुन! जो भक्त जिस प्रकार से मेरी पूजा करते हैं, मैं भी उसी प्रकार उनकी पूजा करता हूँ अर्थात् उनका पूरा ध्यान रखता हूँ। वास्तव में सभी मनुष्य सब प्रकार से मेरे ही आचरण का अनुसरण करते हैं।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 12","काङ्क्षन्तः, कर्मणाम्, सिद्धिम्, यजन्ते, इह, देवताः,\n" +
                "क्षिप्रम्, हि, मानुषे, लोके, सिद्धिः, भवति, कर्मजा।।12।।","इस मनुष्य लोक में जो कर्मों के फल की इच्छा रखते हैं, वे देवताओं अर्थात् ब्रह्मा, विष्णु, शिव की पूजा करते हैं क्योंकि वे अपने कर्मों से अर्थात् कर्मों के आधार पर होने वाली आध्यात्मिक सिद्धि को शीघ्र प्राप्त कर लेते हैं।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 13","चातुर्वण्र्यम्, मया, सृष्टम्, गुणकर्मविभागशः,\n" +
                "तस्य, कर्तारम्, अपि, माम्, विद्धि, अकर्तारम्, अव्ययम्।।13।।","ब्राह्मण, क्षत्रिय, वैश्य और शूद्र चार वर्णों/जातियों का समूह मेरे द्वारा गुणों और कर्मों के विभाजन के आधार पर बनाया गया है। इस प्रकार मुझ काल को ही उस कर्म का कर्ता समझो। वह सनातन परमात्मा अकर्ता है।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 14","न, माम्, कर्माणि, लिम्पन्ति, न, मे, कर्मफले, स्पृृहा,\n" +
                "इति, माम्, यः, अभिजानाति, कर्मभिः, न, सः, बध्यते।।14।।","मुझे कर्मों के फल की कोई इच्छा नहीं है इसलिए कर्म मुझे कलंकित नहीं करते हैं। इस प्रकार जो मुझे काल-ब्रह्म को संक्षेप में समझता है, वह भी कर्मों के लिए बाध्य नहीं होता अर्थात् गीता अध्याय 4 श्लोक 34 में वर्णित तत्वदर्शी संत को पाकर गीता अध्याय 18 श्लोक 62 में वर्णित उस परमात्मा की शरण में जाकर परमपुरुष/पूर्ण परमात्मा की भक्ति करने से कर्मों के बंधन से मुक्त हो जाता है।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 15","एवम्, ज्ञात्वा, कृृतम्, कर्म, पूर्वैः, अपि, मुमुक्षुभिः,\n" +
                "कुरु, कर्म, एव, तस्मात्, त्वम्, पूर्वैः, पूर्वतरम्, कृृतम्।।15।।","प्राचीनकाल के मोक्ष के साधकों ने भी इसी प्रकार जानकर शास्त्रानुकूल साधना के कार्यों को बड़े चाव से किया है। अतः आप भी शास्त्रानुकूल पितरों द्वारा किये जाने वाले शास्त्रानुकूल भक्ति कर्म करें।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 16","किम्, कर्म, किम्, अकर्म, इति, कवयः, अपि, अत्रा, मोहिताः,\n" +
                "तत्, ते, कर्म, प्रवक्ष्यामि, यत्, ज्ञात्वा, मोक्ष्यसे, अशुभात्।।16।।","कर्म क्या है और अकर्म क्या है ? इस प्रकार बुद्धिमान भक्त भी यहाँ निर्णय लेने में भ्रमित हो जाते हैं। इसलिए मैं तुम्हें उस कर्म का सार अच्छी तरह समझाऊंगा, जिसे जानकर तुम शास्त्रविरुद्ध कर्मों से मुक्त हो जाओगे।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 17","कर्मणः, हि, अपि, बोद्धव्यम्, बोद्धव्यम्, च, विकर्मणः,\n" +
                "अकर्मणः, च, बोद्धव्यम्, गहना, कर्मणः, गतिः।।17।।","कर्म के स्वरूप को जो शास्त्राविधि अनुसार है समझ लेना चाहिए और अकर्म (निष्क्रियता) का स्वभाव जो शास्त्र विधान के विपरीत है उसे भी समझ लेना चाहिए और विकर्म का स्वभाव जैसे मांस, शराब, तम्बाकू, चोरी-दुर्व्यवहार आदि के सेवन को भी समझना चाहिए क्योंकि कर्म की अवस्था गम्भीर होती है।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 18","कर्मणि, अकर्म, यः, पश्येत्, अकर्मणि, च, कर्म, यः,\n" +
                "सः, बुद्धिमान्, मनुष्येषु, सः, युक्तः, कृृत्स्न्नकर्मकृृत्।।18।।","जो कर्म/कर्म अर्थात् शास्त्रानुकूल पूजा योग्य कर्मों को देखता है अर्थात् समझता है तथा अकर्म/निष्क्रियता अर्थात् शास्त्राविधि को त्यागकर मनमाना कर्म करने योग्य नहीं है और जो अकर्म अर्थात् कर्म नहीं करता है। जो शास्त्रविरुद्ध पूजा के कार्य और करने योग्य नहीं हैं, और कर्म अर्थात् करने योग्य कर्म करता है, वह मनुष्यों में बुद्धिमान है, और वह योगी (भक्त) सभी कार्यों को धर्म के नियमों के अनुसार करता है शास्त्र।\n"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 19","यस्य, सर्वे, समारम्भाः, कामसंकल्पवर्जिताः,\n" +
                "ज्ञानाग्निदग्धकर्माणम्, तम्, आहुः, पण्डितम्, बुधाः।।19।।","जिसके समस्त शास्त्रानुकूल कर्म कामनाओं और संकल्पों से रहित हैं तथा अशुभ कर्मों अर्थात् शास्त्रविधि विरुद्ध कर्मों को तत्वज्ञान की अग्नि द्वारा भस्म कर दिया गया है अर्थात् पूर्ण ज्ञान प्राप्त करने पर साधक पूर्ण संत को पाकर सिद्धि को प्राप्त कर लेता है। वास्तविक मंत्र जिसके द्वारा सभी पाप नष्ट हो जाते हैं, बुद्धिमान पुरुष, जो शास्त्रों के अनुसार पूजा करते हैं, उन्हें पंडित कहते हैं।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 20","त्यक्त्वा, कर्मफलासंगम्, नित्यतृप्तः, निराश्रयः,\n" +
                "कर्मणि, अभिप्रवृत्तः, अपि, न, एव, किंचित्, करोति, सः।।20।।","तत्वज्ञान के आधार पर शास्त्रविरुद्ध कर्मों और उनके फलों में आसक्ति को पूर्णतः त्यागकर शास्त्रविरूद्ध भक्ति कर्मों से मुक्त हो गया है और शास्त्रानुकूल भक्ति कर्मों से सदा सन्तुष्ट रहता है। वह भक्ति के सांसारिक और शास्त्रानुकूल कार्यों में उचित रूप से संलग्न होने पर भी वास्तव में शास्त्रों के नियमों को छोड़कर किसी भी मनमानी पूजा के तरीके का पालन नहीं करता है।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 21","निराशीः, यतचित्तात्मा, त्यक्तसर्वपरिग्रहः,\n" +
                "शारीरम्, केवलम्, कर्म, कुर्वन्, न, आप्नोति, किल्बिषम्।।21।।","शास्त्रानुकूल भक्ति युक्त आत्मा जिसने शास्त्रविरुद्ध समस्त संचित साधनाओं का त्याग कर दिया है, ऐसा भक्त जिसने निराधार साधना का त्याग कर दिया है अर्थात् शास्त्राविधि विरुद्ध साधना का त्याग कर दिया है, वह केवल हठयोग करने के स्थान पर, जबकि शरीर के द्वारा सहज में की जाने वाली साधना को करने से सांसारिक कर्म और शरीर सम्बन्धी शास्त्रानुकूल भक्ति कर्म करने से पाप नहीं लगता। क्योंकि गीता अध्याय 7 श्लोक 12 से 15 में जो मनुष्य शास्त्रविधि को त्यागकर मनमाना साधना करते हैं, उन्हें आसुरी प्रकृति का, पुरुषों में नीच और पाप करने वाला अर्थात् शास्त्राविधि को त्यागने वाला कहा गया है। मनमाना व्यवहार करने वाले, मूर्ख जो मेरी पूजा नहीं करते, वे केवल त्रिगुण अर्थात् रजगुण ब्रह्मा जी, सतगुण विष्णु जी, तमगुण शिव जी की पूजा करके उनसे प्राप्त अल्पकाल के निवारण के आश्रित रहते हैं। इन तीनों गुणों अर्थात् श्री ब्रह्मा जी, श्री विष्णु जी, श्री शिव जी की ही साधना शास्त्रविरुद्ध कही गई है। इस शास्त्रविरूद्ध साधना को त्याग कर शास्त्रानुकूल भक्ति करता है। यही प्रमाण गीता अध्याय 18 श्लोक 47-48 में भी है।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 22","यदृच्छालाभसन्तुष्टः, द्वन्द्वातीतः, विमत्सरः,\n" +
                "समः, सिद्धौ, असिद्धौ, च, कृत्वा, अपि, न, निबध्यते।।22।।","जो स्वाभाविक रूप से प्राप्त हुई वस्तु से दूर रहता है, जिसकी इच्छा नहीं है, जिसमें ईर्ष्या का पूर्ण अभाव है, और जो सुख-दुख आदि के द्वंद्वों से पूरी तरह मुक्त हो गया है, जो सफलता में अपरिवर्तित रहता है तथा किसी कार्य के विफल होने पर वह शास्त्रानुकूल भक्ति करते हुए भी कर्म करने के साथ-साथ उनसे बंधता नहीं है। क्योंकि पूर्ण संत से पूर्ण मन्त्र का जाप प्राप्त कर बिना इच्छा के की गई शास्त्रानुकूल साधना के शुभ कर्म भक्ति में सहायक होते हैं और पाप नष्ट हो जाते हैं। जिसके फलस्वरूप मनुष्य कर्मों के बंधन से मुक्त हो जाता है"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 23","गतसंगस्य, मुक्तस्य, ज्ञानावस्थितचेतसः,\n" +
                "यज्ञाय, आचरतः, कर्म, समग्रम्, प्रविलीयते।।23।।","शास्त्रविरुद्ध साधना में विश्वास खोने के कारण उस मुक्त भक्त का मन सदैव ईश्वर के सच्चे आध्यात्मिक ज्ञान में स्थित रहता है। शास्त्रानुकूल भक्ति के लिए कर्म करने वाले ऐसे मनुष्य के सभी कर्म भगवान की भक्ति में लीन हो जाते हैं।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 24","ब्रह्म, अर्पणम्, ब्रह्म, हविः, ब्रह्माग्नौ, ब्रह्मणा, हुतम्,\n" +
                "ब्रह्म, एव, तेन, गन्तव्यम्, ब्रह्मकर्मसमाधिना।।24।।","ऐसे भक्त का शास्त्रानुकूल समर्पण भी ब्रह्म अर्थात् ईश्वर के प्रति होता है तथा यज्ञ का पदार्थ भी ईश्वर ही होता है तथा ब्रह्म रूपी अग्नि में पूर्ण परमात्मा को समर्पित अर्थात् ईश्वर की प्रार्थना करने से पाप का त्याग होता है अर्थात् पाप नष्ट हो जाते हैं। नष्ट किया हुआ। वास्तव में सांसारिक कार्य करते हुए भी जिसका मन भगवान में ही लगा रहता है और जो शरीर से सहज ही होने वाले कर्मों को करता है अर्थात् जो सहज समाधि में रहकर साधना करता है, उसके लिए ईश्वर प्राप्ति के योग्य है अर्थात् वही सहज समाधि में रहने वाले ईश्वर को प्राप्त कर सकते हैं।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 25","दैवम्, एव, अपरे, यज्ञम्, योगिनः, पर्युपासते,\n" +
                "ब्रह्माग्नौ, अपरे, यज्ञम्, यज्ञेन, एव, उपजुह्नति।।25।।","इसके विपरीत अन्य योगी/भक्त विधिपूर्वक केवल देवताओं की पूजा के रूप में यज्ञ करते हैं और अन्य योगी भगवान को प्राप्त करने के लिए वियोग की अग्नि से मनमानी धार्मिक प्रथाओं के माध्यम से ही धार्मिक कार्यों का पालन करते हैं।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 26","श्रोत्रादीनि, इन्द्रियाणि, अन्ये, संयमाग्निषु, जुह्नति,\n" +
                "शब्दादीन्, विषयान्, अन्ये, इन्द्रियाग्निषु, जुह्नति।।26।।","अन्य योगी कान नाक बन्द करके अर्थात् हठयोग द्वारा समस्त इन्द्रियों को संयम रूपी अग्नि में अर्पित कर पापों को भस्म करने का प्रयास करते हैं तथा अन्य उपासक शब्द-स्पर्श आदि समस्त इन्द्रिय-वस्तुओं/सांसारिक भोगों को इन्द्रिय-अग्नियों में आहुति देकर पापों को भस्म करने का प्रयास करते हैं। अर्थात् हठ/बल से साधना करने को ही मोक्ष का मार्ग समझो।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 27","सर्वाणि, इन्द्रियकर्माणि, प्राणकर्माणि, च, अपरे,\n" +
                "आत्मसंयमयोगाग्नौ, जुह्नति, ज्ञानदीपिते।।27।।","अन्य योगी इन्द्रियों की समस्त क्रियाओं और श्वासों की समस्त क्रियाओं को ज्ञान द्वारा आलोकित भक्तिरूपी संयम अर्थात् ज्ञान द्वारा संयम करके उपासना की अग्नि में आहुति देते हैं; वे इसे ही मोक्ष का मार्ग मानते हैं।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 28","द्रव्ययज्ञाः, तपोयज्ञाः, योगयज्ञाः, तथा, अपरे,\n" +
                "स्वाध्यायज्ञानयज्ञाः, च, यतयः, संशितव्रताः।।28।।","बहुत से भक्त केवल धन से संबंधित धार्मिक कार्य करते हैं अर्थात केवल दान करते हैं; बहुत से लोग तपस्या को धार्मिक कृत्य मानते हैं और कई अन्य योग मुद्राओं के रूप में धार्मिक कृत्यों को करते हैं और कई कठोर व्रत/व्रतों का पालन करके प्रयास कर रहे हैं, और कुछ ज्ञान का यज्ञ करते हैं अर्थात केवल नियमित रूप से सच्चे शास्त्रों का अध्ययन करते हैं। दूसरे शब्दों में वे इसे ही मोक्ष का मार्ग मानते हैं।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 29","अपाने, जुह्नति, प्राणम्, प्राणे, अपानम्, तथा, अपरे,\n" +
                "प्राणापानगती, रुद्ध्वा, प्राणायामपरायणाः।।29।।\n" +
                "\n" +
                "अपरे, नियताहाराः, प्राणान्, प्राणेषु, जुह्नति,\n" +
                "सर्वे, अपि, एते, यज्ञविदः, यज्ञक्षपितकल्मषाः।।30।।","दूसरे लोग पापों को जलाने के लिए आने वाली सांस को बाहर जाने वाली सांस में बलिदान करने की कोशिश करते हैं। इसी तरह बाहर जाने वाली सांस को अंदर आने वाली सांस में बलिदान करें, और कई अन्य, जो संयम में खाते हैं, सांस को नियंत्रित करने के लिए समर्पित हैं, आने और जाने वाली सांस की गति को रोककर, और अपनी जीवन-सांसों को मिनट बनाकर उन्हें जलाने की कोशिश करते हैं। प्राणों को ही त्याग के रूप में अर्थात् प्राणायाम करके परमात्मा को प्राप्त करने का प्रयत्न करो। ये सभी भक्त उपर्युक्त धार्मिक कृत्यों अर्थात् साधनाओं को पाप नाश करने वाली भक्ति का साधन मानते हैं। दूसरे शब्दों में इसी साधना को मोक्ष का मार्ग समझो।"));

        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 31","यज्ञशिष्टामृृतभुजः, यान्ति, ब्रह्म, सनातनम्,\n" +
                "न, अयम्, लोकः, अस्ति, अयज्ञस्य, कुतः, अन्यः, कुरुसत्तम।।31।।","हे कौरवों में श्रेष्ठ, अर्जुन! शास्त्रानुकूल साधना से बचे हुए लाभ को भोगकर उपर्युक्त शास्त्रविरुद्ध साधनाओं से बचे हुए ज्ञानी उपासक आदि पुरुष परमेश्वर अर्थात् पूर्ण ब्रह्म को प्राप्त होते हैं तथा जो मनुष्य परमेश्वर की भक्ति नियमानुसार नहीं करता है, उसे प्राप्त होता है। शास्त्रों का विधान है कि यह मनुष्य लोक भी सुखदायी नहीं है तो परलोक सुखदायी कैसे हो सकता है?"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 32","एवम्, बहुविधाः, यज्ञाः, वितताः, ब्रह्मणः, मुखे,\n" +
                "कर्मजान्, विद्धि, तान्, सर्वान्, एवम्, ज्ञात्वा, विमोक्ष्यसे।।32।।","इस प्रकार नाना प्रकार की शास्त्रानुकूल धार्मिक क्रियाएं होती हैं। आप उन सभी को कर्मों के माध्यम से किए जा रहे यज्ञों के रूप में जान सकते हैं। इस प्रकार उन्हें पूर्ण परमात्मा ने अपने मुखकमल से पंचम वेद अर्थात् स्वसम वेद में विस्तार से बताया है। यह जानकर तुम पूरी तरह मुक्त हो जाओगे।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 33","श्रेयान्, द्रव्यमयात्, यज्ञात्, ज्ञानयज्ञः, परन्तप,\n" +
                "सर्वम्, कर्म, अखिलम्, पार्थ, ज्ञाने, परिसमाप्यते।।33।।","हे परंतप अर्जुन! पैसों से किये जाने वाले यज्ञों अर्थात् दान, भोजन आदि की व्यवस्था करने वाले धार्मिक कर्मों की तुलना में ज्ञान यज्ञ बहुत श्रेष्ठ है और सभी शास्त्रानुकूल कर्मों की परिणति तत्वज्ञान में होती है।\n" +
                "he parantap ar"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 34","तत्, विद्धि, प्रणिपातेन, परिप्रश्नेन, सेवया,\n" +
                "उपदेक्ष्यन्ति, ते, ज्ञानम्, ज्ञानिनः, तत्त्वदर्शिनः।।34।।","पवित्र गीता के बोलने वाले भगवान कह रहे हैं कि उपरोक्त नाना प्रकार की साधना मनमाना आचरण है। यह मेरे स्तर तक साधना का काल्पनिक ज्ञान है लेकिन पूर्ण परमात्मा की पूर्ण मुक्ति का मार्ग मुझे भी नहीं पता। उसके संबंध में इस मंत्र 34 में कहा है कि उस तत्वज्ञान को समझो। जो साधक परमेश्वर के सत्य ज्ञान और समाधान को जानते हैं, उनकी सेवा करके, छल छोड़कर, सरलता से प्रश्न पूछकर, परमेश्वर को सार रूप में जानने वाले अर्थात् तत्वदर्शी, ज्ञानी महात्माओं को ठीक से प्रणाम करके उपदेश देंगे। आप तत्वज्ञान/सच्चे आध्यात्मिक ज्ञान में।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 35","\n" +
                "यत्, ज्ञात्वा, न, पुनः, मोहम्, एवम्, यास्यसि, पाण्डव,\n" +
                "येन, भूतानि, अशेषेण, द्रक्ष्यसि, आत्मनि, अथो, मयि।।35।।","सच्चा अध्यात्म ज्ञान जिसे जानकर फिर तुम इस प्रकार मोह में नहीं पड़ोगे और हे अर्जुन! जिस ज्ञान से तुम सर्व प्राणियों को आत्मा के साथ अभिन्न रूप से रहने वाले परमेश्वर में और बाद में मुझको देखोगे कि मैं काल हूँ; आपको यह पता चल जाएगा।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 36","अपि, चेत्, असि, पापेभ्यः, सर्वेभ्यः, पापकृत्तमः,\n" +
                "सर्वम्, ज्ञानप्लवेन, एव, वृजिनम्, सन्तरिष्यसि।।36।।","यदि आप अन्य सभी पापियों में सबसे अधिक पापी हैं, तो भी तत्वज्ञान के आधार पर अज्ञानता को पार करते हुए वास्तविक नाम की नाव से आप नि:संदेह पूरी तरह से पार हो जायेंगे अर्थात् पापमुक्त होने के बाद आप पूर्ण मुक्त हो जायेंगे।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 37","यथा, एधांसि, समिद्धः, अग्निः, भस्मसात्, कुरुते, अर्जुन,\n" +
                "ज्ञानाग्निः, सर्वकर्माणि, भस्मसात्, कुरुते, तथा।।37।।","हे अर्जुन! जैसे प्रज्वलित अग्नि लकड़ी को जलाकर राख कर देती है; इसी प्रकार तत्वज्ञान/सच्चे अध्यात्म ज्ञान की अग्नि सभी निराधार कर्मों को भस्म कर देती है।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 38","न, हि, ज्ञानेन, सदृृशम्, पवित्राम्, इह, विद्यते,\n" +
                "तत् स्वयम्, योगसंसिद्धः, कालेन, आत्मनि, विन्दति।।38।।","निस्संदेह इस संसार में तत्वज्ञान के समान पवित्र करने वाली कोई वस्तु नहीं लगती। उस तत्वदर्शी संत द्वारा बताए गए सच्चे भक्ति मार्ग से जिसकी भक्ति कमाई पूर्ण हो गई है, वह समय के अनुसार गीता अध्याय 8 श्लोक में वर्णित विवरण के आधार पर उस परमेश्वर को स्वत: ही प्राप्त कर लेता है जो आत्मा के साथ अभिन्न रूप से रहता है। 8 से 10।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 39","श्रद्धावान्, लभते, ज्ञानम्, तत्परः, संयतेन्द्रियः,\n" +
                "ज्ञानम्, लब्ध्वा, पराम्, शान्तिम्, अचिरेण, अधिगच्छति।।39।।","उस तत्वदर्शी संत से प्राप्त साधना के प्रति समर्पित होकर अपनी इन्द्रियों को जीत लेने वाला श्रद्धेय व्यक्ति भक्ति प्राप्त कर पूर्ण परमात्मा का तत्वज्ञान प्राप्त करता है तथा तत्वज्ञान प्राप्त कर अविलंब परमशान्ति स्वरूप को प्राप्त करता है। ईश्वर की प्राप्ति का।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 40","अज्ञः, च, अश्रद्दधानः, च, संशयात्मा, विनश्यति,\n" +
                "न, अयम् लोकः, अस्ति, न, परः, न, सुखम्, संशयात्मनः।।40।।","जो साधक उस तत्वदर्शी सन्त के ज्ञान और साधना पर अविश्वास करता है, वह अविवेकी, श्रद्धाहीन और शंकालु व्यक्ति निश्चित रूप से भक्ति मार्ग से विचलित हो जाता है। ऐसे शंकालु व्यक्ति के लिए न तो इस लोक में सुख है और न ही परलोक में। इसका प्रमाण गीता अध्याय 6 श्लोक 40 में भी है।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 41","योगसन्नयस्तकर्माणम्, ज्ञानसछिन्नसंशयम्,\n" +
                "आत्मवन्तम्, न, कर्माणि, निबध्नन्ति, धनंजय।। 41।।","हे धनंजय! जिसने तत्वज्ञान के आधार पर शास्त्रविरुद्ध सभी भक्ति कर्मों का परित्याग कर दिया है और जिसने तत्वज्ञान द्वारा सभी संदेहों को नष्ट कर दिया है, (शास्त्रों के नियमों को त्यागने और मनमाना आचरण करने पर, व्यक्ति को पाप लगता है। ये) जो शास्त्र विधि के अनुसार साधना करता है, उसके द्वारा नहीं होता है, इसलिए) परमेश्वर के शास्त्रानुकूल ज्ञान पर दृढ़ रहने वाले ऐसे भक्त को पाप कर्म नहीं बाँधते; अर्थात उसे पूर्ण मोक्ष की प्राप्ति होती है।"));
        list4.add(new GeetaModel("Adhya 4","गीता श्लोक 42","तस्मात्, अज्ञानसम्भूतम्, हृत्स्थम्, ज्ञानासिना, आत्मनः,\n" +
                "छित्त्वा, एनम्, संशयम्, योगम्, आतिष्ठ, उत्तिष्ठ, भारत।।42।।","\n" +
                "इसलिए हे भारतवंशी अर्जुन! अज्ञान से उत्पन्न निराधार संशय रूपी पाप को अपने हृदय में तत्वज्ञान अर्थात् दूध और पानी की तलवार से काटकर उठो अर्थात् जाग्रत हो जाओ और अन्तरात्मा से परमात्मा की शास्त्रानुकूल भक्ति में स्थिर हो जाओ। ."));


    }

    private void addDataToList3() {
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 1","ज्यायसी, चेत्, कर्मणः, ते, मता, बुद्धिः, जनार्दन,\n" +
                "तत्, किम्, कर्मणि, घोरे, माम्, नियोजयसि, केशव।।1।।","हे जनार्दन! यदि तत्वदर्शी द्वारा दिये गये ज्ञान को कर्म की दृष्टि से श्रेष्ठ मानते हो तो हे केशव! गीता अध्याय 6 के श्लोक 10 से 15 में वर्णित गर्दन और सिर को सीधा रखकर एक स्थान पर बैठकर इन्द्रियों को वश में करने के इस घोर और निकृष्ट कार्य में आप मुझे क्यों लगाते हैं?"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 2","व्यामिश्रेण, इव, वाक्येन, बुद्धिम्, मोहयसि, इव, मे,\n" +
                "तत्, एकम्, वद, निश्चित्य, येन, श्रेयः, अहम्, आप्नुयाम्।।2।।","इस तरह के विरोधाभासी बयान मेरे दिमाग को भ्रमित कर रहे हैं। अतएव तुम मुझे निश्चयपूर्वक वह एक बात बताओ, जिससे मेरा कल्याण हो जाय।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 3","लोके, अस्मिन्, द्विविधा, निष्ठा, पुरा, प्रोक्ता, मया, अनघ,\n" +
                "ज्ञानयोगेन, साङ्ख्यानाम्, कर्मयोगेन, योगिनाम्।।3।।","अरे मासूम ! इस दुनिया में मेरे द्वारा पहले दो प्रकार के विश्वासों की व्याख्या की गई है। उनमें से (ज्ञानियों) ज्ञानियों की श्रद्धा ज्ञानयोग में अर्थात् अपनी बुद्धि से खींची हुई साधना के निष्कर्ष में होती है और योगियों की आस्था कर्मयोग अर्थात् सांसारिक कार्यों के अतिरिक्त साधना करने में होती है।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 4","न, कर्मणाम्, अनारम्भात्, नैष्कम्र्यम्, पुरुषः, अश्नुते,\n" +
                "न, च, सóयसनात्, एव, सिद्धिम्, समधिगच्छति।।4।।","शास्त्रों में वर्णित शास्त्रानुकूल साधना के साथ-साथ सांसारिक कार्यों को करने से जो परमात्मा अर्थात् पूर्ण मोक्ष प्राप्त होता है, वह बिना कर्म प्रारंभ किए प्राप्त नहीं होता। उदाहरण के लिए, अगर किसी को एक एकड़ में गेहूं की फसल काटनी है, तो वह कटाई की प्रक्रिया शुरू करने के बाद ही कटेगी। तब फसल काटने की क्रिया नहीं रहती और इसलिए केवल कर्मों का त्याग कर हठयोग द्वारा एक स्थान पर विशेष आसन पर बैठने से सिद्धि/अलौकिक शक्ति प्राप्त नहीं होती।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 5","न, हि, कश्चित्, क्षणम्, अपि, जातु, तिष्ठति, अकर्मकृत्,\n" +
                "कार्यते, हि, अवशः, कर्म, सर्वः, प्रकृतिजैः, गुणैः।।5।।","निस्सन्देह कोई भी व्यक्ति किसी भी समय क्षणमात्र भी कर्म किये बिना नहीं रहता। क्योंकि प्रकृति अर्थात् दुर्गा से उत्पन्न गुणों रजगुण ब्रह्मा, सतगुण विष्णु तथा तमगुण शिव जी से वशीभूत समस्त मानव जाति कर्म करने के लिए बाध्य है। (इसका प्रमाण अध्याय 14 के श्लोक 3-5 में भी है)"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 6","कर्मेन्द्रियाणि, संयम्य, यः, आस्ते, मनसा, स्मरन्,\n" +
                "इन्द्रियार्थान्, विमूढात्मा, मिथ्याचारः, सः, उच्यते।।6।।","जो अत्यंत मूढ़ मनुष्य सब कर्मेन्द्रियों को ऊपर से बलपूर्वक रोककर, भीतर से उन ज्ञानेन्द्रियों के विषयों का चिन्तन करता रहता है, वह कपटी अर्थात् पाखण्डी कहा जाता है। (इसका विस्तृत विवरण गीता अध्याय 17 श्लोक 19 में दिया गया है)"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 7","यः, तु, इन्द्रियाणि, मनसा, नियम्य, आरभते, अर्जुन,\n" +
                "कर्मेन्द्रियैः, कर्मयोगम्, असक्तः, सः, विशिष्यते।।7।।","लेकिन हे अर्जुन! जो मनुष्य इन्द्रियों को आन्तरिक रूप से वश में करके अनासक्त होकर कर्मयोग अर्थात् सांसारिक कार्यों के सम्पादन के साथ-साथ शास्त्रों के विधान के अनुसार भक्ति का आचरण करता है, वही श्रेष्ठ है।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 8","नियतम्, कुरु, कर्म, त्वम्, कर्म, ज्यायः, हि, अकर्मणः,\n" +
                "शरीरयात्रा, अपि, च, ते, न, प्रसिद्धयेत्, अकर्मणः।।8।।","शास्त्राविधि अनुसार कर्म करना चाहिए क्योंकि अकर्म की तुलना में अर्थात् कुश के बने विशेष आसन पर एकान्त स्थान में बैठकर बलपूर्वक भक्ति करने की तुलना में सांसारिक कार्यों को करते हुए भक्ति करना श्रेष्ठ है और कर्म न करने अर्थात् हठयोग करके यदि एकान्त में बैठे रहेंगे तो अपने शरीर और परिवार का भरण-पोषण भी नहीं हो पायेगा।\n"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 9","यज्ञार्थात्, कर्मणः, अन्यत्रा, लोकः, अयम्, कर्मबन्धनः,\n" +
                "तदर्थम्, कर्म, कौन्तेय, मुक्तसंगः, समाचर।।9।।","इस लोक में वही कर्मों में बंधता है अर्थात् चौरासी लाख जन्मों में अत्याचार सहता है, जो शास्त्राविधि त्यागकर यज्ञ अर्थात् धार्मिक कर्मों के निमित्त शास्त्रानुकूल कर्मों के स्थान पर अन्य कर्मों में लगा रहता है। . इसलिए हे अर्जुन! आसक्ति से मुक्त होकर उस शास्त्रानुकूल यज्ञ[2] के निमित्त सांसारिक कर्म करते हुए शास्त्रानुकूल भक्ति कर्म अर्थात् कर्तव्य कर्म [1] करना चाहिए; अर्थात् साधना शास्त्रों के अनुसार अर्थात् नियम के अनुसार ही करें।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 10","सहयज्ञाः, प्रजाः, सृष्टा , पुरा, उवाच, प्रजापतिः,\n" +
                "अनेन, प्रसविष्यध्वम्, एषः, वः, अस्तु, इष्टकामधुक्।।10।।","सभी प्राणियों के स्वामी प्रजापति ने सृष्टि के प्रारंभ में यज्ञ सहित सभी प्राणियों की रचना करके उनसे कहा कि अन्न से किए जाने वाले उस यज्ञ से तुम्हारा कल्याण हो सकता है जिसे धर्मयज्ञ कहा जाता है, जिसमें आम भोजन किया जाता है। आदि प्रदान किया जाता है, और यह यज्ञ में स्थित परमेश्वर ही आपको वांछित सुखों का दाता हो सकता है।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 11","देवान्, भावयत, अनेन, ते, देवाः, भावयन्तु, वः,\n" +
                "परस्परम् भावयन्तः, श्रेयः, परम्, अवाप्स्यथ।।11।।","\n" +
                "इस यज्ञ के द्वारा देवताओं अर्थात् शाखाओं को उन्नत करें और वे देवता अर्थात् शाखाएँ आप लोगों को समृद्ध करें अर्थात् संस्कारों के आधार पर फल प्रदान करें। इस प्रकार निःस्वार्थ रूप से एक दूसरे को समृद्ध करते हुए, तुम परम मंगल को प्राप्त करोगे।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 12","इष्टान् भोगान्, हि, वः, देवाः, दास्यन्ते, यज्ञभाविताः,\n" +
                "तैः दत्तान्, अप्रदाय, एभ्यः, यः, भुङ्क्ते, स्तेनः, एव, सः।।12।।","उन यज्ञों में स्थित देवता को अर्थात् पूर्ण परमात्मा को भोग लगाने के कारण यज्ञ से प्रसन्न होकर देवता उसका प्रतिफल भोग रूप में देते रहेंगे। जो उनके द्वारा दिए गए भौतिक सुखों को अर्पित किए बिना अर्थात् यज्ञ, दान आदि किए बिना स्वयं उसका सेवन करता है, वह वास्तव में चोर है।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 13","यज्ञशिष्टाशिनः, सन्तः, मुच्यन्ते, सर्वकिल्बिषैः,\n" +
                "भुजते, ते, तु, अघम्, पापाः, ये, पचन्ति, आत्मकारणात्।। 13।।","यज्ञ में स्थित देवता अर्थात् पूर्ण परमात्मा को प्रसाद चढ़ाकर जो साधु लोग खाते हैं, वे यज्ञ आदि न करने से होने वाले समस्त पापों से छूट जाते हैं और जो पापी मनुष्य केवल अपने शरीर को पुष्ट करने के लिए भोजन पकाते हैं, वे निश्चय ही पाप ही खाता है।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 14,15","अन्नात्, भवन्ति, भूतानि, पर्जन्यात्, अन्नसम्भवः,\n" +
                "यज्ञात्, भवति, पर्जन्यः, यज्ञः, कर्मसमुद्भवः।।14।।\n" +
                "\n" +
                "कर्म, ब्रह्मोद्भवम्, विद्धि, ब्रह्म, अक्षरसमुद्भवम्,\n" +
                "तस्मात्, सर्वगतम्, ब्रह्म, नित्यम्, यज्ञे, प्रतिष्ठितम्।।15।।","अन्न से प्राणी उत्पन्न होते हैं, वर्षा से अन्न उत्पन्न होता है, यज्ञ से वर्षा होती है, और नियत कर्मों से यज्ञ उत्पन्न होता है। ब्रह्म से उत्पन्न होने वाले कर्मों को और सनातन परमात्मा से उत्पन्न ब्रह्म अर्थात् क्षर पुरुष पर विचार करो। इससे सिद्ध हुआ कि सर्वव्यापक परमात्मा सदैव यज्ञों में स्थित रहता है अर्थात् यज्ञ का भाग ग्रहण कर फल देने वाला भी वही पूर्णब्रह्म है। (इसका प्रमाण पवित्र गीता अध्याय 4 के श्लोक 13 में भी है कि गुणों के आधार पर कर्मों को जोड़कर चार वर्ण (जातियां) बनाई हैं और कर्मों को जोड़ने वाला मैं ब्रह्म ही हूं।"));

        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 16","एवम्, प्रवर्तितम्, चक्रम्, न, अनुवर्तयति, इह, यः,\n" +
                "अघायुः, इन्द्रियारामः, मोघम्, पार्थ, सः, जीवति।।16।।","ओह पार्थ! इस संसार में जो इस प्रकार परम्परागत प्रकृति के चक्र के अनुसार कर्म नहीं करता अर्थात् जो अपने कर्तव्यों का पालन नहीं करता, वह पापी मनुष्य जो इन्द्रियों के द्वारा संसार के सुखों को भोगता है, वह व्यर्थ ही जीवित है।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 17","यः, तु, आत्मरतिः, एव, स्यात्, आत्मतृप्तः, च, मानवः,\n" +
                "आत्मनि, एव, च, सन्तुष्टः, तस्य, कार्यम्, न, विद्यते।।17।।","परन्तु जो मनुष्य वास्तव में आत्मा के साथ अविच्छिन्न रूप में रहने वाले परमात्मा में ही रमण करता है और एक परमात्मा में ही सन्तुष्ट है और केवल परमात्मा में ही सन्तुष्ट है, उसके लिए कोई कर्तव्य नहीं मालूम पड़ता।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 18","न, एव, तस्य, कृृतेन, अर्थः, न, अकृृतेन, इह, कश्चन,\n" +
                "न, च, अस्य, सर्वभूतेषु, कश्चित्, अर्थव्यपाश्रयः।।18।।","इस लोक में उस महापुरुष को न तो कर्म करने में रुचि है, न केवल कर्म न करने में ही रुचि है, और सर्व प्राणियों में रत्ती भर भी रस नहीं है। क्योंकि वह स्वार्थ से रहित होकर किसी से शास्त्रानुकूल पूजा नहीं कराता और न स्वयं करता है। न वह धन कमाने के उद्देश्य से साधना करता है और न दूसरों से करवाता है।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 19","तस्मात्, असक्तः, सततम्, कार्यम्, कर्म, समाचर,\n" +
                "असक्तः, हि, आचरन्, कर्म, परम्, आप्नोति, पूरुषः।।19।।","\n" +
                "इसलिए आसक्ति से मुक्त होकर सदा शास्त्रों के अनुसार अपने निर्धारित कर्तव्यों का पर्याप्त रूप से पालन करते रहो क्योंकि इच्छाओं से मुक्त होकर भक्ति के कार्य करने से तुम परमेश्वर को प्राप्त करोगे।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 20","कर्मणा, एव, हि, संसिद्धिम्, आस्थिताः, जनकादयः,\n" +
                "लोकसंग्रहम्, एव, अपि, सम्पश्यन्, कर्तुम्, अर्हसि।।20।।","जनक आदि ने भी आसक्तिरहित कर्मों से ही परम आध्यात्मिक सिद्धि प्राप्त की। इस कारण और संसार के कल्याण को ध्यान में रखते हुए आपको सांसारिक कार्यों के अलावा शास्त्रों के अनुसार कर्म करना चाहिए अर्थात कर्म करना आपके लिए बेहतर है"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 21","यत्, यत् आचरति, श्रेष्ठः, तत्, तत्, एव, इतरः, जनः,\n" +
                "सः, यत्, प्रमाणम्, कुरुते, लोकः, तत्, अनुवर्तते।।21।।","महापुरुष अर्थात् शास्त्र विधि से साधना करने वाला भक्त जो कुछ करता है, दूसरे पुरुष भी वैसा ही करते हैं। वह जो भी मानक निर्धारित करता है, सभी लोग उसका पालन करने लगते हैं।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 22","न, मे, पार्थ, अस्ति, कर्तव्यम्, त्रिषु, लोकेषु, किंचन\n" +
                "न, अनवाप्तम्, अवाप्तव्यम्, वर्ते, एव, च, कर्मणि।।22।।","हे अर्जुन! इन तीनों लोकों में न तो मेरा कोई कर्तव्य है और न ही मुझे कोई प्राप्त होने वाली वस्तु प्राप्त हुई है; फिर भी मैं कर्म में ही लगा रहता हूँ।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 23","यदि, हि, अहम्, न, वर्तेयम्, जातु, कर्मणि, अतन्द्रितः,\n" +
                "मम, वत्र्म, अनुवर्तन्ते, मनुष्याः, पार्थ, सर्वशः।।23।।","क्योंकि हे पार्थ! यदि कभी मैं सावधानी से कर्मों में नहीं लगा तो बहुत हानि हो सकती है क्योंकि मनुष्य सब प्रकार से मेरे ही मार्ग पर चलते हैं।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 24","उत्सीदेयुः, इमे, लोकाः, न, कुर्याम्, कर्म, चेत्, अहम्,\n" +
                "संकरस्य, च, कर्ता, स्याम्, उपहन्याम्, इमाः, प्रजाः।।24।।","यदि मैं कर्म न करूँ तो ये सब मनुष्य पूरी तरह से नष्ट हो जाएँगे और मैं मिश्रित जातियों (विभिन्न जातियों के पुरुष और स्त्री के योग से उत्पन्न) का कारण बनूँगा और इन सभी लोगों का नाश करने वाला बनूँगा।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 25","सक्ताः, कर्मणि, अविद्वांसः, यथा, कुर्वन्ति, भारत,\n" +
                "कुर्यात्, विद्वान्, तथा, असक्तः, चिकीर्षुः, लोकसङ्ग्रहम्।।25।।","हे भरत! जिस प्रकार कर्मों में आसक्त अज्ञानी मनुष्य शास्त्रानुकूल कर्म करते हैं, उसी प्रकार आसक्ति रहित ज्ञानी पुरुष को भी चाहिए कि लोगों को एकत्र करने की इच्छा से शिष्य बनाने की इच्छा से शास्त्रविधि के अनुसार उपर्युक्त कर्म करें।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 26","न, बुद्धिभेदम्, जनयेत्, अज्ञानाम्, कर्मसंगिनाम्,\n" +
                "जोषयेत्, सर्वकर्माणि, विद्वान्, युक्तः, समाचरन्।।26।।","शास्त्रविरुद्ध साधना से हानि और शास्त्रानुकूल साधना से लाभ स्पष्ट देखकर (ज्ञानी को) परिवर्तन नहीं करना चाहिए अर्थात् अशिक्षितों को भ्रमित नहीं करना चाहिए अर्थात् अज्ञानियों को शास्त्रानुकूल ज्ञान आधारित भक्ति कर्मों पर दृढ़ नहीं होना चाहिए। शास्त्रानुकूल उपासकों ने यह कहकर दिया कि तुम अशिक्षित हो, तुम सच्ची उपासना के बारे में क्या जानते हो। शास्त्रविरुद्ध अन्य साधनाओं में लीन ज्ञानी को अपने अहंकार के कारण उन्हें भ्रमित नहीं करना चाहिए और स्वयं भक्ति के कार्यों को ठीक से करते हुए उन्हें भी कराना चाहिए अर्थात उन्हें गुमराह करने के बजाय उन्हें प्रोत्साहित करना चाहिए।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 27","प्रकृतेः, क्रियमाणानि, गुणैः, कर्माणि, सर्वशः,\n" +
                "अहंकारविमूढात्मा, कर्ता, अहम्, इति, मन्यते।।27।।","प्रकृति-दुर्गा से उत्पन्न तीनों गुणों अर्थात् रजगुण ब्रह्मा, सतगुण विष्णु, तमगुण शिव जी द्वारा संस्कारों के आधार पर सभी कर्म सब प्रकार से सम्पन्न होते हैं; शिक्षित होते हुए भी तत्वज्ञान से रहित अहंकारी अज्ञानी व्यक्ति ऐसा सोचता है - \"मैं कर्ता हूँ\"।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 28","तत्त्ववित्, तु, महाबाहो, गुणकर्मविभागयोः,\n" +
                "गुणाः, गुणेषु, वर्तन्ते, इति, मत्वा, न, सज्जते।।28।।","लेकिन ओह ग्रेट-आर्म्ड! एक ज्ञानी व्यक्ति जो गुणों और कर्मों के संबंधित क्षेत्रों के बारे में सच्चाई जानता है यानी एक तत्वदर्शी, यह समझने के बाद कि सभी गुण (तीन गुण, रजगुण, सतगुण, तमगुण) ही गुणों (तीनों भगवान) में अभिनय कर रहे हैं उनकी ओर आकर्षित न हों। अर्थात् तीनों गुणों - रजगुण ब्रह्मा जी, सतगुण विष्णु जी, तमगुण शिव जी में जितनी शक्तियाँ होती हैं, उससे पूर्ण परिचित व्यक्ति का इन पर इतना ही विश्वास रह जाता है। (इसका प्रमाण गीता अध्याय 2 के श्लोक 45-46 में भी है।) अहंकार को त्यागकर वह तुरंत शास्त्रानुकूल साधना करने लगता है।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 29","प्रकृृतेः, गुणसम्मूढाः, सज्जन्ते, गुणकर्मसु,\n" +
                "तान्, अकृत्स्न्नविदः, मन्दान्, कृत्स्न्नवित्, न, विचालयेत्।।29।।","मूर्ख व्यक्ति, तीन गुणों से अत्यंत मोहित, प्रकृति से उत्पन्न प्रकृति के पुत्र, अर्थात् रजगुण ब्रह्मा जी, सतगुण विष्णु जी, तमगुण शिव जी, गुण अर्थात् तीनों देवताओं की साधना के कार्यों में मग्न रहते हैं। सत्य भक्ति को जानने वाला अर्थात् शास्त्रानुकूल साधना करने वाला ज्ञानी मंदबुद्धि अशिक्षितों अर्थात् अज्ञानियों को विचलित नहीं कर सकता, जो पूर्ण रूप से नहीं समझते अर्थात् शास्त्रानुकूल साधना को स्वभावतः त्याग कर धर्म पर दृढ़ रहते हैं। तीनों गुणों अर्थात श्री ब्रह्मा जी, श्री विष्णु जी, श्री शिव जी की गलत साधना से साधना; वे निश्चय ही नाश हो गए हैं। इसका प्रमाण गीता अध्याय 7 श्लोक 12-15 में भी दिया है।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 30","मयि, सर्वाणि, कर्माणि, सóयस्य, अध्यात्मचेतसा,\n" +
                "निराशीः, निर्ममः, भूत्वा, युध्यस्व, विगतज्वरः।।30।।","पूर्ण परमात्मा में मन लगाकर सब कर्मों को मुझमें अर्पण करके कामना, मालकियत और शोक से रहित होकर युद्ध करो। इसका प्रमाण गीता अध्याय 18 श्लोक 66 में भी दिया है कि सर्व धर्म कर्मों को मुझमें छोड़कर परमात्मा की शरण में जाओ।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 31","ये, मे, मतम्, इदम्, नित्यम्, अनुतिष्ठन्ति, मानवाः,\n" +
                "श्रद्धावन्तः, अनसूयन्तः, मुच्यन्ते, ते, अपि, कर्मभिः।।31।।","जो मनुष्य दोषों से रहित और श्रद्धापूर्वक सदा इस मत अर्थात् मेरे इस सिद्धांत का पालन करते हैं, वे शास्त्रविधि के त्यागने अर्थात् नियमों के त्याग करने पर किये हुए दोषपूर्ण कर्मों से बच जाते हैं।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 32","ये, तु, एतत्, अभ्यसूयन्तः, न, अनुतिष्ठन्ति, मे, मतम्,\n" +
                "सर्वज्ञानविमूढान्, तान्, विद्धि, नष्टान्, अचेतसः।।32।।","परन्तु जो लोग दोष लगाते हैं और इस मत अर्थात् मेरे सिद्धांत का पालन नहीं करते हैं, उन मूर्खों को समस्त विद्याओं में आसक्त और नष्ट होने वाला ही समझते हैं।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 33","सदृशम्, चेष्टते, स्वस्याः, प्रकृतेः, ज्ञानवान्, अपि,\n" +
                "प्रकृतिम्, यान्ति, भूतानि, निग्रहः, किम्, करिष्यति।।33।।","सभी जीव अपने स्वभाव का पालन करते हैं। ज्ञानी व्यक्ति भी अपने स्वभाव के अनुसार अपने द्वारा सिद्ध किये गये भक्ति मार्ग के आधार पर प्रयत्न करते हैं। क्या (हाथ) पूरा करने पर रोक लगाएगा?"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 34","इन्द्रियस्य, इन्द्रियस्य, अर्थे, रागद्वेषौ, व्यवस्थितौ,\n" +
                "तयोः, न, वशम्, आगच्छेत्, तौ, हि, अस्य, परिपन्थिनौ।।34।।","प्रेम और घृणा प्रत्येक इंद्रिय की वस्तु में छिपे हुए हैं। इनके वश में नहीं आना चाहिए क्योंकि ये दोनों ही इनके बाधक महाशत्रु हैं।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 35","श्रेयान्, स्वधर्मः, विगुणः, परधर्मात्, स्वनुष्ठितात्,\n" +
                "स्वधर्मे, निधनम्, श्रेयः, परधर्मः, भयावहः।।35।।","दूसरों की मनमानी पूजा से अपनी शास्त्रानुकूल साधना बहुत अच्छी होती है, जो आचरण में तो बहुत अच्छी होती है, पर गुणहीन होती है अर्थात् शास्त्राविधि त्याग कर की जाती है। अपनी इबादत में मरना भी फायदेमंद है और दूसरे की इबादत डराने वाली।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 36","अथ, केन, प्रयुक्तः, अयम्, पापम्, चरति, पूरुषः,\n" +
                "अनिच्छन्, अपि, वाष्र्णेय, बलात्, इव, नियोजितः।।36।।","हे कृष्ण! फिर किससे प्रेरित होकर यह मनुष्य स्वयं भी अनिच्छा से यह पाप करता है, मानो बल से प्रेरित हो।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 37","कामः, एषः, क्रोधः, एषः, रजोगुणसमुद्भवः,\n" +
                "महाशनः, महापाप्मा, विद्धि, एनम्, इह, वैरिणम्।।37।।","रजोगुण से उत्पन्न यह काम अर्थात् काम और यह क्रोध अति खाने वाला अर्थात् जीव का नाश करने वाला महापापी है। इस मामले में आप उपरोक्त पाप को ही शत्रु मान सकते हैं।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 38","धूमेन, आव्रियते, वह्निः, यथा, आदर्शः, मलेन, च,\n" +
                "यथा, उल्बेन, आवृतः, गर्भः, तथा, तेन, इदम्, आवृृतम्।।38।।","जैसे धुएँ से अग्नि और धूल से शीशा ढका रहता है, वैसे ही भ्रूण गर्भावरण से ढका रहता है; इसी प्रकार यह ज्ञान भी उपरोक्त दोषों से आच्छादित है।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 39","आवृतम्, ज्ञानम्, एतेन, ज्ञानिनः, नित्यवैरिणा,\n" +
                "कामरूपेण, कौन्तेय, दुष्पूरेण, अनलेन, च।।39।।","और हे कुन्तीपुत्र अर्जुन! मनुष्य का ज्ञान ज्ञानियों के काम रूपी शाश्वत शत्रु द्वारा आच्छादित है जो इस अग्नि की तरह कभी भी तृप्त नहीं हो सकता।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 40","इन्द्रियाणि, मनः, बुद्धिः, अस्य, अधिष्ठानम्, उच्यते,\n" +
                "एतैः, विमोहयति, एषः, ज्ञानम्, आवृत्य, देहिनम्।।40।।","इन्द्रियाँ, मन और बुद्धि- ये सब इसी कामदेव अर्थात् कामवासना के निवास स्थान कहे गए हैं। मन, बुद्धि और इन्द्रियों के माध्यम से ही ज्ञान को आच्छादित करके यह यौन सुख की इच्छा आत्मा को आकर्षित करती है।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 41","तस्मात्, त्वम्, इन्द्रियाणि, आदौ, नियम्य, भरतर्षभ,\n" +
                "पाप्मानम्, प्रजहि, हि, एनम्, ज्ञानविज्ञाननाशनम्।।41।।","इसलिए, हे भरत के वंशज, अर्जुन! तुम सर्वप्रथम इन्द्रियों को वश में करके ज्ञान और विज्ञान के इस विनाशक महा पापी लिंग का अवश्य ही संहार करो।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 42","इन्द्रियाणि, पराणि, आहुः, इन्द्रियेभ्यः, परम्, मनः,\n" +
                "मनसः, तु, परा, बुद्धिः, यः, बुद्धेः, परतः, तु, सः।।42।।","भौतिक शरीर की तुलना में इंद्रियों को श्रेष्ठ, शक्तिशाली और सूक्ष्म कहा गया है; मन इन इन्द्रियों से श्रेष्ठ है; हालाँकि, बुद्धि मन से श्रेष्ठ है और जो बुद्धि से भी अधिक शक्तिशाली है वह आत्मा है जिसके साथ भगवान हैं।"));
        list3.add(new GeetaModel("Adhya 3","गीता श्लोक 43","एवम्, बुद्धेः, परम्, बुद्ध्वा, संस्तभ्य, आत्मानम्, आत्मना,\n" +
                "जहि, शत्रुम्, महाबाहो, कामरूपम्, दुरासदम्।।43।।","इस प्रकार भगवान् को बुद्धि से परम श्रेष्ठ और स्वयं को साधना से संयमी समझकर हे महाबाहु अर्जुन! आप इस कामरूपी (कामुक) अजेय शत्रु को मार सकते हैं।"));
    }

    private void addDataToList2() {
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 1","तम्, तथा, कृपया, आविष्टम्, अश्रुपूर्णाकुलेक्षणम्,\n" +
                "विषीदन्तम्, इदम्, वाक्यम्, उवाच, मधुसूदनः।।1।।","और इस प्रकार मधुसूदन भगवान् ने करुणा से विभूषित, व्याकुल नेत्रों वाले, व्याकुल और ममता के अन्धकार में डूबे हुए अर्जुन से यह कथन कहा।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 2","कुतः, त्वा, कश्मलम्, इदम्, विषमे, समुपस्थितम्,\n" +
                "अनार्यजुष्टम्, अस्वग्र्यम्, अकीर्तिकरम्, अर्जुन।।2।।","हे अर्जुन! इस दु:खद अनुपयुक्त समय में यह स्नेह किस उद्देश्य से आपके पास आया? क्योंकि यह हीन पुरुषों का चरित्र है; यह स्वर्ग की ओर नहीं ले जाएगा और केवल अपमान लाने वाला है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 3","क्लैब्यम्, मा, स्म, गमः, पार्थ, न, एतत्, त्वयि, उपपद्यते,\n" +
                "क्षुद्रम् हृदयदौर्बल्यम्, त्यक्त्वा, उत्तिष्ठ, परन्तप।।3।।","हे अर्जुन! नपुंसकता के आगे न झुकें। यह तुम्हें शोभा नहीं देता। हे परंतप! हृदय की इस क्षुद्र दुर्बलता को त्याग कर युद्ध के लिए खड़े हो जाओ।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 4","कथम्, भीष्मम्, अहम्, सङ्ख्ये, द्रोणम्, च, मधुसूदन,\n" +
                "इषुभिः, प्रति, योत्स्यामि, पूजार्हौ, अरिसूदन।।4।।","हे मधुसूदन! मैं युद्ध के मैदान में भीष्म पितामह और द्रोणाचार्य के खिलाफ बाणों से कैसे लड़ूंगा? क्योंकि हे अरिसूदन! वे दोनों पूज्य हैं।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 5","गुरून्, अहत्वा, हि, महानुभावान्, श्रेयः, भोक्तुम्,\n" +
                "भैक्ष्यम्, अपि, इह, लोके, हत्वा, अर्थकामान्, तु,\n" +
                "गुरून्, इह, एव, भुजीय, भोगान्, रुधिरप्रदिग्धान्,।। 5।।","मैं तो बड़े-बड़े गुरुओं को मारने के स्थान पर इस संसार में भिक्षा का भोजन करना भी शुभ मानता हूँ। क्योंकि गुरुजनों को मारकर भी मैं इस संसार में केवल रक्तरंजित धन और वासनारूपी सुख भोगूंगा।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 6","न, च, एतत्, विध्मः, कतरत्, नः, गरीयः, यत्, वा,\n" +
                "जयेम, यदि, वा, नः, जयेयुः, यान् एव, हत्वा, न,\n" +
                "जिजीविषामः, ते, अवस्थिताः, प्रमुखे, धार्तराष्ट्राः।।6।।","और हम यह भी नहीं जानते कि इन दोनों में से हमारे लिए क्या अच्छा है कि हम युद्ध करें या न करें और यह भी नहीं जानते कि हम उन्हें जीत लेंगे या वे हम पर विजय प्राप्त कर लेंगे। और जिसे मारकर हम जीने की इच्छा भी नहीं रखते, वे ही धृतराष्ट्र के पुत्र ही युद्ध में खड़े हैं।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 7","कार्पण्यदोषोपहतस्वभावः, पृच्छामि, त्वाम्,\n" +
                "धर्मसम्मूढचेताः, यत्, श्रेयः, स्यात्, निश्चितम्, ब्रूहि,\n" +
                "तत्, मे, शिष्यः, ते, अहम्, शाधि, माम्, त्वाम्, प्रपन्नम्।।7।।","मैं कायरता के दोष से अभिभूत और धर्म के विषय में मोहित होने के स्वभाव से आपसे पूछता हूँ कि जो कुछ मेरे लिए निश्चित रूप से शुभ है वह मुझे बताएं क्योंकि मैं आपका शिष्य हूँ। अतः जो आपकी शरण में है, मुझे शिक्षा दीजिए।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 8","न, हि, प्रपश्यामि, मम, अपनुद्यात्, यत्, शोकम्, उच्छोषणम्, इन्द्रियाणाम्,\n" +
                "अवाप्य, भूमौ, असपत्नम्, ऋद्धम्, राज्यम्, सुराणाम्, अपि,च,आधिपत्यम्।।8।।","अर्जुन कह रहा है कि भगवन, यदि मैं सारी पृथ्वी का राज्य अथवा देवताओं के स्वामी इन्द्र का पद प्राप्त कर लूं तो मुझे नहीं लगता कि कोई मुझे युद्ध के लिए तैयार कर सकता है अर्थात् मैं युद्ध नहीं करूँगा। यह कहकर वह चुप हो गया।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 9","एवम्, उक्त्वा, हृषीकेशम्, गुडाकेशः, परन्तप,\n" +
                "न, योत्स्ये, इति, गोविन्दम्, उक्त्वा, तूष्णीम्, बभूव, ह।।9।।","हे राजा! इस प्रकार अंतर्यामी (सर्वज्ञ) श्रीकृष्ण महाराज से कहकर निद्राजीत अर्जुन ने भगवान श्री गोविन्द से स्पष्ट कह दिया कि मैं युद्ध नहीं करूँगा और मौन हो गया।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 10","तम्, उवाच, हृषीकेशः, प्रहसन्, इव, भारत,\n" +
                "सेनयोः, उभयोः, मध्ये, विषीदन्तम्, इदम्, वचः।।10।।","हे भरत के वंशज, धृतराष्ट्र! अन्तर्यामी/सर्वज्ञ श्रीकृष्ण ने दोनों सेनाओं के मध्य में शोक करते हुए उस अर्जुन से हँसते हुए ये वचन कहे।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 11","अशोच्यान्, अन्वशोचः, त्वम्, प्रज्ञावादान्, च, भाषसे,\n" +
                "गतासून्, अगतासून्, च, न, अनुशोचन्ति, पण्डिताः।।11।।","आप उन पुरुषों के लिए शोक कर रहे हैं जो शोक करने के योग्य नहीं हैं, और पंडितों की तरह बयान कर रहे हैं, लेकिन पंडित उनके लिए शोक नहीं करते हैं जो मर चुके हैं और जो जीवित हैं उनके लिए भी।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 12","न, तु, एव, अहम्, जातु, न, आसम्, न, त्वम्, न, इमे, जनाधिपाः,\n" +
                "न, च, एव, न, भविष्यामः, सर्वे, वयम्, अतः, परम्।।12।।","न ऐसा है कि मैं कभी न था, न तुम थे, न ये राजा थे, और न ऐसा है कि इसके आगे हम न होंगे।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 13","देहिनः, अस्मिन्, यथा, देहे, कौमारम्, यौवनम्, जरा,\n" +
                "तथा, देहान्तरप्राप्तिः, धीरः, तत्रा, न, मुह्यति।।13।।","जैसे इस शरीर में आत्मा का बचपन, जवानी और बुढ़ापा होता है; उसी प्रकार यह दूसरा शरीर प्राप्त करता है। धीर पुरुष उस विषय पर मोहित नहीं होता।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 14","मात्रास्पर्शाः, तु, कौन्तेय, शीतोष्णसुखदुःखदाः,\n" +
                "आगमापायिनः, अनित्याः, तान्, तितिक्षस्व, भारत।।14।।","हे कुंतीपुत्र! शीत, उष्ण, सुख-दु:ख देने वाले इन्द्रियों और उनके विषयों के सम्पर्क आते-जाते हैं अर्थात् अस्थायी होते हैं; इसलिए, हे भरत! तू इनको सहन कर।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 15","यम्, हि, न, व्यथयन्ति, एते, पुरुषम्, पुरुषर्षभ,\n" +
                "समदुःखसुखम्, धीरम्, सः, अमृतत्वाय, कल्पते।।15।।","क्योंकि हे पुरुषों में श्रेष्ठ ! जो सुख-दुःख को समान मानता है, स्थिर अर्थात् तत्वदर्शी मनुष्य, जिसे ये विचलित नहीं करते, वह पूर्ण परमात्मा के सुख का अधिकारी है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 16","न, असतः, विद्यते, भावः, न, अभावः, विद्यते, सतः,\n" +
                "उभयोः, अपि, दृष्टः, अन्तः, तु, अनयोः, तत्त्वदर्शिभिः।।16।।","नाशवान वस्तु का अस्तित्व ज्ञात नहीं होता और अविनाशी के अभाव/विनाश का पता नहीं चलता, अत: इन दोनों की सत्यता/वास्तविकता को भी तत्वज्ञानी अर्थात् तत्वदर्शी संतों ने माना है। (इसका प्रमाण गीता अध्याय 4 श्लोक 34 में है)।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 17","अविनाशि, तु, तत्, विद्धि, येन्, सर्वम्, इदम्, ततम्,\n" +
                "विनाशम्, अव्ययस्य, अस्य, न, कश्चित्, कर्तुम्, अर्हति।।17।।","जिससे यह सारा दृश्य जगत व्याप्त है, उसे अविनाशी/अमर जानना चाहिए। इस अमर को नष्ट करने में कोई भी सक्षम नहीं है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 18","अन्तवन्तः, इमे, देहाः, नित्यस्य, उक्ताः, शरीरिणः,\n" +
                "अनाशिनः, अप्रमेयस्य, तस्मात्, युध्यस्व, भारत।।18।।","पंचतत्वों से बना यह शरीर नाशवान है। अमर परमात्मा हमेशा शरीर में आत्मा के साथ रहता है। एक साधारण उपासक पूर्ण परमात्मा और आत्मा के अविभाज्य संबंध से अपरिचित है। इसलिए असिद्ध को अविनाशी कहा गया है, जो सदैव आत्मा के साथ रहता है। इसलिए, हे भरत के वंशज, अर्जुन! लड़ाई"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 19","यः, एनम्, वेत्ति, हन्तारम्, यः, च, एनम्, मन्यते, हतम्,\n" +
                "उभौ तौ, न, विजानीतः, न, अयम्, हन्ति, न, हन्यते।।19।।","जो इसे मारने वाला मानता है और जो इसे मारने वाला मानता है, वे दोनों नहीं जानते क्योंकि वास्तव में वह न तो किसी को मारता है और न ही किसी के द्वारा मारा जाता है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 20","न, जायते, म्रियते, वा, कदाचित्, न, अयम्, भूत्वा, भविता, वा, न,\n" +
                "भूयः, अजः, नित्यः, शाश्वतः, अयम्, पुराणः, न, हन्यते, हन्यमाने, शरीरे।।20।।","यह न तो किसी काल में जन्म लेती है, न कभी मरती है और न ही जन्म लेने के बाद फिर से अस्तित्व में आने वाली है, क्योंकि यह अजन्मा, नित्य, नित्य और आदि है। शरीर के मारे जाने पर यह मारा भी नहीं जाता।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 21","वेद, अविनाशिनम्, नित्यम्, यः, एनम्, अजम्, अव्ययम्,\n" +
                "कथम्, सः, पुरुषः, पार्थ, कम्, घातयति, हन्ति, कम्।।21।।","हे अर्जुन! जो इस परमात्मा को आत्मा सहित अविनाशी, सनातन, अजन्मा और अमर जानता है, वह किसकी हत्या करता है और कैसे किसी को मारता है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 22","वासांसि, जीर्णानि, यथा, विहाय, नवानि, गृह्णतिः, नरः, अपराणि,\n" +
                "तथा, शरीराणि, विहाय, जीर्णानि, अन्यानि, संयाति, नवानि, देही।।22।।","जैसे मनुष्य पुराने वस्त्रों को त्याग कर दूसरे नये वस्त्रों को धारण करता है; इसी प्रकार जीवात्मा पुराने शरीरों को त्याग कर अन्य नए शरीरों को प्राप्त करता है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 23","न, एनम्, छिन्दन्ति, शस्त्राणि, न, एनम्, दहति, पावकः,\n" +
                "न, च, एनम्, क्लेदयन्ति, आपः, न, शोषयति, मारुतः।।23।।","शस्त्र उसे काट नहीं सकते; अग्नि उसे जला नहीं सकती, जल उसे घोल नहीं सकता और वायु उसे सुखा नहीं सकती।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 24","अच्छेद्यः, अयम्, अदाह्यः, अयम्, अक्लेद्यः, अशोष्यः, एव, च,\n" +
                "नित्यः, सर्वगतः, स्थाणुः, अचलः, अयम्, सनातनः।।24।।","यह अविभाज्य है। यह ईश्वर अज्वलनशील, अघुलनशील और निस्संदेह सुखाया नहीं जा सकता है, और यह ईश्वर अनादि, सर्वव्यापी, अचल, स्थायी और सदा विद्यमान है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 25","अव्यक्तः, अयम्, अचिन्त्यः, अयम्, अविकार्यः, अयम्, उच्यते,\n" +
                "तस्मात्, एवम्, विदित्वा, एनम्, न, अनुशोचितुम्, अर्हसि।।25।।","यह परमात्मा इस आत्मा के साथ गुप्त रूप से रहता है। यह ईश्वर अकल्पनीय है और इसे दोष रहित कहा गया है। इसलिए हे अर्जुन! इस प्रकार इस परमात्मा को जानने के बाद तुम शोक करने के योग्य नहीं हो अर्थात् तुम्हारे लिए शोक करना उचित नहीं है। तात्पर्य यह है कि जब परमात्मा जीव के साथ है तो जीव को कोई हानि नहीं हो सकती।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 26","अथ, च, एनम्, नित्यजातम्, नित्यम्, वा, मन्यसे, मृतम्,\n" +
                "तथापि त्वम्, महाबाहो, न, एवम्, शोचितुम्, अर्हसि।।26।।","और यदि इसके बाद भी तुम उन्हें निरन्तर जन्मते और सदा मरते हुए समझते हो, तो भी हे महाबाहु! तुम इस तरह शोक करने के योग्य नहीं हो।\n"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 27","जातस्य, हि, ध्रुवः, मृत्युः, ध्रुवम्, जन्म, मृतस्य, च,\n" +
                "तस्मात्, अपरिहार्ये, अर्थे, न, त्वम्, शोचितुम्, अर्हसि।।27।।","क्योंकि जिसका जन्म हुआ है उसकी मृत्यु निश्चित है और जो मर गया है उसका पुनर्जन्म निश्चित है। इससे भी तुम इस अपरिहार्य विषय में शोक करने के योग्य नहीं हो।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 28","अव्यक्तादीनि, भूतानि, व्यक्तमध्यानि, भारत,\n" +
                "अव्यक्तनिधनानि, एव, तत्रा, का, परिदेवना।।28।।","हे अर्जुन! सभी जीव जन्म से पहले अव्यक्त थे और मृत्यु के बाद अव्यक्त हो जाएंगे। वे मध्य में ही प्रकट होते हैं। फिर ऐसी स्थिति में शोक करने की क्या बात है?"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 29","आश्चर्यवत्, पश्यति, कश्चित्, एनम्, आश्चर्यवत्,\n" +
                "वदति, तथा, एव, च, अन्यः, आश्चर्यवत्, च, एनम्, अन्यः,\n" +
                "श्रृणोति, श्रुत्वा, अपि, एनम्, वेद, न, च, एव, कश्चित्।।29।।","कोई विरला ही इस परमात्मा को आत्मा सहित विस्मय में देखता है और इसी प्रकार कोई महापुरुष विस्मय में वर्णन ही करता है और कोई विस्मय से सुनता भी है और कोई यह सुनकर भी नहीं जानता।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 30","देही, नित्यम्, अवध्यः, अयम्, देहे, सर्वस्य, भारत,\n" +
                "तस्मात्, सर्वाणि, भूतानि, न, त्वम्, शोचितुम्, अर्हसि।।30।।","हे अर्जुन! यह आत्मा परमात्मा सहित सबके शरीर में सदा अमर है। अतः आप समस्त प्राणियों के लिए शोक करने योग्य नहीं हैं"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 31","स्वधर्मम्, अपि, च, अवेक्ष्य, न, विकम्पितुम्, अर्हसि,\n" +
                "धम्र्यात्, हि, युद्धात्, श्रेयः, अन्यत्, क्षत्रियस्य, न, विद्यते।।31।।","साथ ही अपने शास्त्रानुकूल धर्म का विचार करके भी तुम्हें डरना नहीं चाहिए क्योंकि क्षत्रिय के लिए धर्मयुद्ध से बढ़कर और कोई कर्तव्य नहीं माना जाता।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 32","यदृच्छया, च, उपपन्नम्, स्वर्गद्वारम्, अपावृतम्,\n" +
                "सुखिनः, क्षत्रियाः, पार्थ, लभन्ते, युद्धम्, ईदृशम्।।32।।","ओह पार्थ! सौभाग्यशाली क्षत्रियों को ही ऐसी लड़ाई लड़ने का अवसर मिलता है जो अपने आप आती \u200B\u200Bहै और स्वर्ग के खुले द्वार के समान है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 33","अथ, चेत्, त्वम्, इमम्, धम्र्यम्, सङ्ग्रामम्, न, करिष्यसि,\n" +
                "ततः, स्वधर्मम्, कीर्तिम्, च, हित्वा, पापम्, अवाप्स्यसि।।33।।","परन्तु यदि तुम इस धर्म ज्ञान के आधार पर युद्ध नहीं करोगे तो अपने समान धर्म और कीर्ति को खोकर पाप को प्राप्त होगे।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 34","अकीर्तिम्, च, अपि, भूतानि, कथयिष्यन्ति, ते, अव्ययाम्,\n" +
                "सम्भावितस्य, च, अकीर्तिः, मरणात्, अतिरिच्यते।।34।।","और सब लोग तेरी दीर्घकालीन अपकीर्ति की चर्चा करेंगे और एक प्रतिष्ठित व्यक्ति के लिए अपकीर्ति मृत्यु से भी बढ़कर है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 35","भयात्, रणात्, उपरतम्, मंस्यन्ते, त्वाम्, महारथाः,\n" +
                "येषाम्, च, त्वम्, बहुमतः, भूत्वा, यास्यसि, लाघवम्।।35।।","और जिनकी दृष्टि में तुम पहले बड़े आदरणीय थे और अब तुच्छ हो जाओगे, वे महारथी योद्धा तुम्हें भय के मारे युद्ध से पीछे हटे हुए समझेंगे।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 36","अवाच्यवादान्, च, बहून्, वदिष्यन्ति, तव, अहिताः,\n" +
                "निन्दन्तः, तव, सामथ्र्यम्, ततः, दुःखतरम्, नु, किम्।।36।।","आपके विरोधी आपकी काबिलियत की आलोचना करते हुए आपको कई अपशब्द भी बोलेंगे। इससे ज्यादा शर्मनाक और क्या होगा?"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 37","हतः, वा, प्राप्स्यसि, स्वर्गम्, जित्वा, वा, भोक्ष्यसे, महीम्,\n" +
                "तस्मात्, उत्तिष्ठ, कौन्तेय, युद्धाय, कृतनिश्चयः।।37।।","या तो तुम युद्ध में मरोगे और स्वर्ग को प्राप्त करोगे या युद्ध को जीतकर पृथ्वी के राज्य का भोग करोगे। इसलिए हे अर्जुन! दृढ़ निश्चय के साथ युद्ध के लिए खड़े हों।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 38","सुखदुःखे, समे, कृत्वा, लाभालाभौ, जयाजयौ,\n" +
                "ततः, युद्धाय, युज्यस्व, न, एवम्, पापम्, अवाप्स्यसि।।38।।","जय-पराजय, लाभ-हानि और सुख-दुख को समान समझकर युद्ध के लिए तैयार हो जाओ। इस प्रकार, आपको पाप नहीं लगेगा।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 39","एषा, ते, अभिहिता, साङ्ख्ये, बुद्धिः, योगे, तु, इमाम्, श्रृणु,\n" +
                "बुद्धया, युक्तः, यया, पार्थ, कर्मबन्धम्, प्रहास्यसि।।39।।","ओह पार्थ! यह ज्ञानयोग के सम्बन्ध में तुम्हें यह ज्ञानवाणी दी गई थी और अब तुम इसे योग के सम्बन्ध में सुनते हो; जिस ज्ञान से संपन्न होकर आप कर्मों के बंधन को पूरी तरह से त्याग देंगे अर्थात् उसे पूरी तरह से नष्ट कर देंगे। गीता अध्याय 6 श्लोक 46 में कहा है कि ज्ञानयोगियों तथा कर्मयोगियों की तुलना में तत्वदर्शी सन्त अर्थात् योगी श्रेष्ठ है। इसी गीता के अध्याय 5 के श्लोक 2 में शास्त्रविरुद्ध ज्ञानयोगी अर्थात् तपस्वी और कर्मयोगी दोनों को हीन कहा है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 40","न, इह, अभिक्रमनाशः, अस्ति, प्रत्यवायः, न, विद्यते,\n" +
                "स्वल्पम्, अपि, अस्य, धर्मस्य, त्रायते, महतः, भयात्।।40।।","इस योग में आदि अर्थात् बीज का नाश नहीं होता और फल रूपी दोष/पाप को भी नहीं जानते; बल्कि इस योग धर्म के भक्ति धन का एक अंश भी महाभय से रक्षा करता है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 41","व्यवसायात्मिका, बुद्धिः, एका, इह, कुरुनन्दन,\n" +
                "बहुशाखाः, हि, अनन्ताः, च, बुद्धयः, अव्यवसायिनाम्।।41।।","हे अर्जुन! इस योग में दृढ़बुद्धि और ज्ञानवाणी एक ही होती है, परन्तु जो मनुष्य अनिर्वचनीय, विचारहीन और इच्छुक होते हैं, उनकी बुद्धि अर्थात् ज्ञान के दृष्टिकोण निश्चय ही अनेक भेदों से युक्त और असीमित होते हैं।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 42,43,44","याम्, इमाम्, पुष्पिताम्, वाचम्, प्रवदन्ति, अविपश्चितः,\n" +
                "वेदवादरताः, पार्थ, न, अन्यत्, अस्ति, इति, वादिनः।।42।।\n" +
                "\n" +
                "कामात्मानः, स्वर्गपराः, जन्मकर्मफलप्रदाम्,\n" +
                "क्रियाविशेषबहुलाम्, भोगैश्वर्यगतिम्, प्रति।।43।।\n" +
                "\n" +
                "भोगैश्वर्यप्रसक्तानाम्, तया, अपहृतचेतसाम्,\n" +
                "व्यवसायात्मिका, बुद्धिः, समाधौ, न, विधीयते।।44।।","हे अर्जुन! जो सांसारिक सुखों में मग्न हो रहे हैं, (जिन्हें) केवल वेदों के मन्त्रों में आसक्ति है, जिनके मन में स्वर्ग ही एकमात्र परम सिद्धि है और कुछ नहीं-ऐसा वे कहते हैं। इस प्रकार की अलंकारिक अर्थात् दिखावटी अलंकारिक वाणी जो वे अविवेकी लोग देते हैं, जो कर्मों के फल के रूप में जन्म लेते हैं और जो सांसारिक सुखों और विलासिता की प्राप्ति के लिए विभिन्न प्रकार के कर्मकांडों / गतिविधियों का वर्णन करते हैं; जिनका हृदय उस वाणी द्वारा हर लिया गया है, जो सांसारिक सुखों और विलासिता में दृढ़ता से तल्लीन हैं, उन पुरुषों का परमेश्वर की एकाग्रता में दृढ़ मन नहीं लगता है।"));

        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 45","त्रौगुण्यविषयाः, वेदाः, निस्त्रौगुण्यः, भव, अर्जुन,\n" +
                "निद्र्वन्द्वः, नित्यसत्त्वस्थः, निर्योगक्षेमः, आत्मवान्।।45।।","हे अर्जुन! रजगुण-ब्रह्मा, सतगुण-विष्णु और तमगुण-शिव तीनों गुणों से प्राप्त सांसारिक सुखों के ज्ञान से, तीनों गुणों से ऊपर उठकर, सुख-दुःख की उलझनों से मुक्त, सनातन वस्तु में स्थित सत्यपुरुष अर्थात् पूर्ण परमात्मा योग क्षेम अर्थात् भक्ति के बदले सांसारिक सुखों की इच्छा न रखते हुए स्वयं में आस्तिक बनो।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 46","यावान्, अर्थः, उदपाने, सर्वतः, सम्प्लुतोदके,\n" +
                "तावान्, सर्वेषु, वेदेषु, ब्राह्मणस्य, विजानतः।।46।।","पूरी तरह लबालब भरे जलाशय को प्राप्त करने के बाद एक छोटे से जलाशय में जो रुचि बची है, एक विद्वान व्यक्ति, जो परमेश्वर को तत्व से जानता है, के पास सभी ज्ञानों में उतनी ही रुचि बची है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 47","कर्मणि, एव, अधिकारः, ते, मा, फलेषु, कदाचन,\n" +
                "मा, कर्मफलहेतुः, भूः, मा, ते, संगः, अस्तु, अकर्मणि।।47।।","अध्याय 2 श्लोक 47\n" +
                "कर्माणि, एव, अधिकारः, ते, मा, फलेषु, कदाचन,\n" +
                "मा, कर्मफलहेतुः, भूः, मा, ते, संगः, अस्तु, अकर्मणि ||47||\n" +
                "\n" +
                "अनुवाद: (ते) तुम्हारा (कर्मिणी) कर्म करनेमें (एव) ही (अधिकारः) अधिकार है (फलेषु) फलोंमें (कदाचन) बिल्कुल भी नहीं (मा) नहीं; इसलिए आप (कर्मफलहेतुः) कर्मों के फलों के उद्देश्य से (मा, भोः) नहीं होते; और (ते) तुम्हारा (अकर्मणि) कर्म न करना भी (संगः) आसक्ति (मा) न (अस्तु) हो। (47)\n" +
                "\n" +
                "अनुवाद\n" +
                "आपको केवल कर्म करने का अधिकार है उसके फल का कभी नहीं। अतः आप कर्मफल के कारण नहीं हो और कर्म न करने में भी आसक्ति नहीं रखनी चाहिए।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 48","योगस्थः, कुरु, कर्माणि, संगम्, त्यक्त्वा, धन×जय,\n" +
                "सिद्धयसिद्धयोः, समः, भूत्वा, समत्वम्, योगः, उच्यते।।48।।","हे धनंजय! आसक्ति को त्याग कर सफलता और असफलता में संतुलित होकर, शास्त्रों के अनुसार भक्ति-योग में स्थापित होकर, शास्त्रों के आदेश के अनुसार भक्ति के अनिवार्य कार्यों को करो; समचित्तता ही योग अर्थात् सच्ची भक्ति कहलाती है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 49","दूरेण, हि, अवरम्, कर्म, बुद्धियोगात्, धनजय,\n" +
                "बुद्धौ, शरणम्, अन्विच्छ, कृपणाः, फलहेतवः।।49।।","भक्ति मार्ग का आत्मनिर्णित निष्कर्ष अर्थात् मनमाना व्यवहार अर्थात अपने मन से भक्ति का कार्य बहुत निम्न स्तर का है। इसलिए हे धनंजय! एक पूर्ण परमात्मा का ज्ञान कराने वाले संत की शरण लेनी चाहिए अर्थात् तत्वदर्शी संतों द्वारा बताए गए एक ही पूर्ण परमात्मा के भक्ति मार्ग का आश्रय लेना चाहिए क्योंकि सबसे दयनीय वे हैं जो फल/परिणाम के कारण बनते हैं।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 50","बुद्धियुक्तः, जहाति, इह, उभे, सुकृतदुष्कृते,\n" +
                "तस्मात् योगाय, युज्यस्व, योगः, कर्मसु, कौशलम्।।50।।","मन की समता से युक्त अर्थात् तत्वदर्शी संत द्वारा निर्देशित सच्चे शास्त्रानुकूल भक्ति मार्ग में लीन भक्त इन दोनों अच्छे कर्मों को त्याग देता है, जैसे मनमाना धार्मिक अभ्यास जो वह शुभ या अनुसार कर रहा था मेरे द्वारा बताया गया मार्ग - 'ओम' का जाप और यज्ञ आदि, वह जो पुण्य कर्म करता था, और पाप कर्म - मांस-शराब-तंबाकू आदि नशीले पदार्थों का सेवन करना, इसी लोक अर्थात् काल लोक में अर्थात् वह पूर्ण संत के निर्देशानुसार कार्य करता है। इसलिए आप शास्त्रानुकूल साधना अर्थात् सच्ची भक्ति में लग जाओ। भक्ति के कार्यों में से केवल तत्वदर्शी संत द्वारा निर्देशित भक्ति मार्ग ही कल्याणकारी है अर्थात् एक बुद्धिमान कार्य है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 51","कर्मजम्, बुद्धियुक्ताः, हि, फलम्, त्यक्त्वा, मनीषिणः,\n" +
                "जन्मबन्धविनिर्मुक्ताः, पदम्, गच्छन्ति, अनामयम्।।51।।","क्योंकि तत्वज्ञान के आधार पर समचित्त, लीन मनुष्य कर्मों के फल को त्यागकर जन्म-बन्धन से पूर्णत: मुक्त होकर अनामी अर्थात् जन्म-मरण के रोग से मुक्त परमपद अर्थात् सतलोक में जाते हैं। अर्थात उन्हें पूर्ण मोक्ष की प्राप्ति होती है अर्थात जन्म-मरण का रोग पूर्णतया समाप्त हो जाता है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 52","यदा, ते, मोहकलिलम्, बुद्धिः, व्यतितरिष्यति,\n" +
                "तदा, गन्तासि, निर्वेदम्, श्रोतव्यस्य, श्रुतस्य, च।।52।।","जिस समय आपकी बुद्धि मोह अर्थात् अज्ञान के कीचड़ से पूरी तरह पार हो जायेगी, अर्थात् जब आप तत्वज्ञान (सच्चे आध्यात्मिक ज्ञान) से अवगत हो जायेंगे, तब आपको सभी भोगों से संबंधित सुनी-सुनाई लोककथाएँ मिलेंगी इस लोक को और (परलोक) दूसरे लोक अर्थात् स्वर्ग और महास्वर्ग को वेदविरुद्ध ज्ञान अर्थात् अज्ञेय वाद-विवाद के रूप में व्यर्थ होना।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 53","श्रुतिविप्रतिपन्ना, ते, यदा, स्थास्यति, निश्चला,\n" +
                "समाधौ, अचला, बुद्धिः, तदा, योगम्, अवाप्स्यसि।।53।।","तरह-तरह की बातें सुनकर भ्रमित होकर जब आपकी बुद्धि तत्वज्ञान के आधार पर स्थिर होकर एक ईश्वर के चिन्तन में दृढ़ हो जायेगी तब आपको योग अर्थात् भक्ति की प्राप्ति होगी। तब तुम्हारी भक्ति प्रारम्भ होगी अर्थात् तब तुम योगी बनोगे। गीता अध्याय 6 श्लोक 46 में कहा है कि हे अर्जुन तू योगी बन।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 54","स्थितप्रज्ञस्य, का, भाषा, समाधिस्थस्य, केशव,\n" +
                "स्थितधीः, किम्, प्रभाषेत, किम्, आसीत, व्रजेत, किम्।।54।।","हे केशव ! स्थिर बुद्धि वाले, सहज समाधि में स्थित, परमात्मा को प्राप्त करने वाले की परिभाषा अर्थात् लक्षण क्या है? वह स्थिर मन वाला कैसे बोलता है? वह कैसे बैठता है और कैसे चलता है?"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 55","प्रजहाति, यदा, कामान्, सर्वान्, पार्थ, मनोगतान्\n" +
                "आत्मनि, एव, आत्मना, तुष्टः, स्थितप्रज्ञः, तदा, उच्यते।।55।।","हे अर्जुन! जब यह व्यक्ति मन में मौजूद सभी इच्छाओं को पूरी तरह से त्याग देता है और आत्मा से अर्थात् समर्पण के साथ आत्मा के साथ रहने वाले भगवान में ही संतुष्ट रहता है, तो उसे स्थिर मन वाला कहा जाता है यानी वह नहीं बनता है भ्रमित और केवल तत्वदर्शी संत के सच्चे आध्यात्मिक ज्ञान पर पूरी तरह से आधारित रहता है। वह एक योगी हैं।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 56","दुःखेषु, अनुद्विग्नमनाः, सुखेषु, विगतस्पृहः,\n" +
                "वीतरागभयक्रोधः, स्थितधीः, मुनिः, उच्यते।।56।।","जिसका मन दु:खों की प्राप्ति से उद्विग्न रहता है, जो सुखों की प्राप्ति पर सदा कामनाओं से मुक्त रहता है और जिसका राग, भय और क्रोध नष्ट हो गया है, वह मुनि अर्थात् उपासक स्थिर मन वाला कहा जाता है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 57","\n" +
                "यः, सर्वत्रा, अनभिस्नेहः, तत्, तत्, प्राप्य, शुभाशुभम्,\n" +
                "न, अभिनन्दति, न, द्वेष्टि, तस्य, प्रज्ञा, प्रतिष्ठिता।।57।।","जो सब ओर से ममता रहित होकर उस अच्छी-बुरी वस्तु को प्राप्त करके न हर्षित होता है और न द्वेष करता है, उसका मन स्थिर है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 58","यदा, संहरते, च, अयम्, कूर्मः, अंगानि, इव, सर्वशः,\n" +
                "इन्द्रियाणि, इन्द्रियार्थेभ्यः, तस्य, प्रज्ञा, प्रतिष्ठिता।।58।।","और जिस प्रकार कछुआ अपने अंगों को चारों ओर से समेट लेता है; इसी प्रकार जब यह व्यक्ति सब प्रकार से इन्द्रियविषयों से इन्द्रियों को हटा लेता है, तब मनुष्य को समझना चाहिए कि उसका मन स्थिर है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 59","विषयाः, विनिवर्तन्ते, निराहारस्य, देहिनः,\n" +
                "रसवर्जम्, रसः, अपि, अस्य, परम्, दृष्टवा, निवर्तते।।59।।","जो मनुष्य इन्द्रियों से विषयों का भोग नहीं करता, उसके दोष ही समाप्त हो जाते हैं, पर आसक्ति नहीं छूटती। इस स्थिर मन वाले, श्रेष्ठ देखने वाले अर्थात् इन दोषों से होने वाले नुकसान को जानने वाले व्यक्ति की आसक्ति भी समाप्त हो जाती है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 60","यततः, हि, अपि, कौन्तेय, पुरुषस्य, विपिश्चितः,\n" +
                "इन्द्रियाणि, प्रमाथीनि, हरन्ति, प्रसभम्, मनः।।60।।","हे अर्जुन! क्योंकि ये अशांत इन्द्रियाँ प्रयत्नशील ज्ञानी पुरुष के मन को भी बलपूर्वक मोहित कर लेती हैं।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 61","तानि, सर्वाणि, संयम्य, युक्तः, आसीत, मत्परः,\n" +
                "वशे, हि, यस्य, इन्द्रियाणि, तस्य, प्रज्ञा, प्रतिष्ठिता।।61।।","उन सब इन्द्रियों को वश में करके मन को वश में करके निश्चयपूर्वक शास्त्रानुकूल साधना में लग जाओ क्योंकि जिसकी इन्द्रियाँ वश में हैं उसकी बुद्धि स्थिर हो जाती है अर्थात् मन और इन्द्रियों पर बुद्धि का आधिपत्य हो जाता है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 62","ध्यायतः, विषयान्, पुंसः, संग, तेषु, उपजायते, संगात्,\n" +
                "सजायते, कामः, कामात्, क्रोधः, अभिजायते।। 62।।","जो सांसारिक भोगों पर विचार करता है, वह उन सांसारिक भोगों के प्रति आसक्त हो जाता है। आसक्ति से उन सांसारिक भोगों की इच्छा उत्पन्न होती है और इच्छाओं की पूर्ति में बाधा से क्रोध उत्पन्न होता है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 63","क्रोधात्, भवति, सम्मोहः, सम्मोहात्, स्मृतिविभ्रमः,\n" +
                "स्मृतिभ्रंशात्, बुद्धिनाशः, बुद्धिनाशात्, प्रणश्यति।।63।।","क्रोध से निरी मूर्खता उत्पन्न होती है; मूर्खता स्मृति में भ्रम की ओर ले जाती है; स्मृति में भ्रम होने से बुद्धि अर्थात् ज्ञान की शक्ति का नाश होता है और बुद्धि के नाश होने पर यह मनुष्य अपनी अवस्था से गिर जाता है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 64","रागद्वेषवियुक्तैः, तु, विषयान्, इन्द्रियैः, चरन्,\n" +
                "आत्मवश्यैः, विधेयात्मा, प्रसादम्, अधिगच्छति।।64।।","परन्तु भक्त जिसका अंतःकरण तत्वज्ञान द्वारा वश में कर लिया गया है, अपनी इन्द्रियों को वश में करके, राग-द्वेष से रहित होकर भी इन्द्रियों के विषयों (सांसारिक भोगों) में भटकता हुआ भी उनमें लिप्त नहीं होता और सुख प्राप्त करता है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 65","प्रसादे, सर्वदुःखानाम्, हानिः, अस्य, उपजायते,\n" +
                "प्रसन्नचेतसः, हि, आशु, बुद्धिः, पर्यवतिष्ठते।।65।।","आन्तरिक सुख की प्राप्ति पर उसके सारे दु:ख समाप्त हो जाते हैं और उस कर्मयोगी का मन प्रसन्नचित्त होकर शीघ्र ही सब ओर से हटकर एक ही परमात्मा में दृढ़ हो जाता है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 66","न, अस्ति, बुद्धिः, अयुक्तस्य, न, च, अयुक्तस्य, भावना,\n" +
                "न, च, अभावयतः, शान्तिः, अशान्तस्य, कुतः, सुखम्।।66।।","जिस मनुष्य ने अपने मन और इन्द्रियों को वश में नहीं किया है, उसकी बुद्धि दृढ़ नहीं होती है और अनियंत्रित मन वाले व्यक्ति के अंतःकरण में कोई भावना नहीं होती है। और भावहीन व्यक्ति को शांति प्राप्त नहीं होती। शांति से रहित व्यक्ति सुख कैसे प्राप्त कर सकता है?"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 67","इन्द्रियाणाम्, हि, चरताम्, यत्, मनः, अनु, विधीयते,\n" +
                "तत्, अस्य, हरति, प्रज्ञाम्, वायुः, नावम्, इव, अम्भसि।।67।।","क्योंकि जैसे जल में चलती हुई नाव को वायु उड़ा ले जाती है; इसी प्रकार जब मन इन्द्रिय-विषयों में विचरती हुई इन्द्रियों के बीच किसी इन्द्रिय के अधूरे ज्ञान पर आधारित हो जाता है, तो निरंकुश मन वाले मनुष्य की बुद्धि बह जाती है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 68","तस्मात् यस्य, महाबाहो, निगृहीतानि, सर्वशः,\n" +
                "इन्द्रियाणि, इन्द्रियार्थेभ्यः, तस्य, प्रज्ञा, प्रतिष्ठिता।।68।।","इसलिए हे महाबाहो! जिसकी इन्द्रियाँ तत्वज्ञान के आधार पर सब प्रकार से इन्द्रियविषयों से निरुद्ध हो गई हैं, केवल उसी का मन स्थिर है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 69","या, निशा, सर्वभूतानाम्, तस्याम्, जागर्ति, संयमी,\n" +
                "यस्याम्, जाग्रति, भूतानि, सा, निशा, पश्यतः, मुनेः।।69।।","समस्त प्राणियों के लिए जो रात्रि के समान है, उस सनातन ज्ञान रूपी परम सुख दाता परमात्मा की प्राप्ति में स्थिर मन वाला योगी जाग्रत रहता है। सभी जीव अल्पकाल के सांसारिक सुखों की प्राप्ति के लिए जागते रहते हैं और उस मुनि के लिए जो परमात्मा के सत्य को जानता है वह रात्रि के समान है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 70","आपूर्यमाणम्, अचलप्रतिष्ठम्, समुद्रम्, आपः, प्रविशन्ति, यद्वत्,\n" +
                "तद्वत्, कामाः, यम्, प्रविशन्ति, सर्वे, सः, शान्तिम्, आप्नोति, न, कामकामी।।70।।","जिस प्रकार विभिन्न नदियों का जल समुद्र में प्रवेश करता है, जो चारों ओर से भरा हुआ है और बिना विचलित हुए स्थिर स्थिति में है; इसी तरह स्थिर मन वाले व्यक्ति में बिना किसी दोष के सभी इच्छाएं विलीन हो जाती हैं। केवल वही मनुष्य परमशान्ति को प्राप्त होता है, न कि इच्छाओं की पूर्ति के लिए प्रयत्न करने वाला।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 71","विहाय, कामान्, यः, सर्वान्, पुमान्, चरति, निःस्पृहः,\n" +
                "निर्ममः, निरहंकारः, सः, शान्तिम्, अधिगच्छति।।71।।","जो मनुष्य समस्त कामनाओं को त्याग कर मालकियत, अहंकार और उत्कंठा से मुक्त होकर विचरता है, वही शान्ति को प्राप्त होता है।"));
        list2.add(new GeetaModel("Adhya 2","गीता श्लोक 72","एषा, ब्राह्मी, स्थितिः, पार्थ, न, एनाम्, प्राप्य, विमुह्यति,\n" +
                "स्थित्वा, अस्याम्, अन्तकाले, अपि, ब्रह्मनिर्वाणम्, ऋच्छति।।72।।","हे अर्जुन! इच्छाओं के त्याग की यह उपर्युक्त स्थिति, अहंकार से मुक्त, एक भक्त की स्थिति है जिसने भगवान को प्राप्त कर लिया है। इसे प्राप्त न करने से साधक विषयों/सांसारिक भोगों के प्रति आकर्षित हो जाता है और मृत्यु के समय जिसके दोष समाप्त नहीं हुए हैं, वह इस स्थिति में स्थित होने पर भी परमेश्वर को प्राप्त करने की क्षमता खो देता है अर्थात लाभ से वंचित रह जाता है परमपिता परमेश्वर को प्राप्त करने के लिए।"));
//        list2.add(new GeetaModel("Adhya 2","Geeta Slok 63","",""));

    }
}