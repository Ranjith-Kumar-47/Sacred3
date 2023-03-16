package com.pujagoodies.sacred.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pujagoodies.sacred.R;
import com.pujagoodies.sacred.adapter.MyAdapter;
import com.pujagoodies.sacred.adapter.PdfAdapter;
import com.pujagoodies.sacred.adapter.ReadAdapter;
import com.pujagoodies.sacred.adapter.videoAdapter;
import com.pujagoodies.sacred.model.PdfModel;
import com.pujagoodies.sacred.model.UploadImageModel;
import com.pujagoodies.sacred.model.VideoModel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PoojaVidhiFragment extends Fragment {
        private ReadAdapter readAdapter;
    private com.pujagoodies.sacred.adapter.videoAdapter videoAdapter;
    private PdfAdapter pdfAdapter;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    ProgressBar progressBar, progressBarSpecial, progressBarPdf;
    ChipGroup chipGroup, chipGroup1;
    RecyclerView recyclerView, recyclerViewSpecial, recyclerViewPdf;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PoojaVidhiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment PoojaVidhiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static PoojaVidhiFragment newInstance(String param1, String param2) {
        PoojaVidhiFragment fragment = new PoojaVidhiFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pooja_vidhi, container, false);

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String today = simpleDateFormat.format(date);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Pooja Vidhi/Todays Special On Shree Mandir").child(today);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                chipGroup.removeAllViews();
                chipGroup1.removeAllViews();

                if (!(value == null)) {
                    String[] tags = value.split(",");
                    if (tags.length >= 10) {
                        for (int i = 0; i < tags.length / 2; i++) {
                            String tag = tags[i].trim();
                            Chip chip = (Chip) getLayoutInflater().inflate(R.layout.chip_design, null, false);
                            chip.setText(tag);
                            chipGroup.addView(chip);
                        }
                        for (int i = tags.length / 2; i < tags.length; i++) {
                            String tag = tags[i].trim();
                            Chip chip = (Chip) getLayoutInflater().inflate(R.layout.chip_design, null, false);
                            chip.setText(tag);
                            chipGroup1.addView(chip);
                        }
                    } else {
                        for (int i = 0; i < tags.length; i++) {
                            String tag = tags[i].trim();
                            Chip chip = (Chip) getLayoutInflater().inflate(R.layout.chip_design, null, false);
                            chip.setText(tag);
                            chipGroup.addView(chip);
                        }
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error + "", Toast.LENGTH_SHORT).show();

            }
        });

        RecyclerView.LayoutManager recyclerViewLayoutManager = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager recyclerViewLayoutManager1 = new LinearLayoutManager(getContext());
        RecyclerView.LayoutManager recyclerViewLayoutManager2 = new LinearLayoutManager(getContext());

        LinearLayoutManager HorizontalLayout = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager HorizontalLayout1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager HorizontalLayout2 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerViewSpecial = view.findViewById(R.id.recyclerViewSpecial);
        recyclerViewPdf = view.findViewById(R.id.recyclerViewPdf);

        progressBar = view.findViewById(R.id.progressBar);
        progressBarSpecial = view.findViewById(R.id.progressBarSpecial);
        progressBarPdf = view.findViewById(R.id.progressBarPdf);

        chipGroup = view.findViewById(R.id.chipGroup);
        chipGroup1 = view.findViewById(R.id.chipGroup1);


        recyclerView.setLayoutManager(recyclerViewLayoutManager);
        recyclerViewSpecial.setLayoutManager(recyclerViewLayoutManager1);
        recyclerViewPdf.setLayoutManager(recyclerViewLayoutManager2);

        progressBar.setVisibility(View.VISIBLE);
        progressBarSpecial.setVisibility(View.VISIBLE);
        recyclerViewPdf.setVisibility(View.VISIBLE);


        recyclerView.setLayoutManager(HorizontalLayout);
        recyclerViewSpecial.setLayoutManager(HorizontalLayout1);
        recyclerViewPdf.setLayoutManager(HorizontalLayout2);

        FirebaseRecyclerOptions<UploadImageModel> recyclerOptions = new FirebaseRecyclerOptions.Builder<UploadImageModel>().setQuery(FirebaseDatabase.getInstance().getReference("Pooja Vidhi/Trending On Shri Mandir"), UploadImageModel.class).build();
        readAdapter = new ReadAdapter(recyclerOptions, progressBar, getContext());
        recyclerView.setAdapter(readAdapter);

        FirebaseRecyclerOptions<VideoModel> recyclerOptions1 = new FirebaseRecyclerOptions.Builder<VideoModel>().setQuery(FirebaseDatabase.getInstance().getReference("Pooja Vidhi/Special To You"), VideoModel.class).build();
        videoAdapter = new videoAdapter(recyclerOptions1, progressBarSpecial, getContext());
        recyclerViewSpecial.setAdapter(videoAdapter);

        FirebaseRecyclerOptions<PdfModel> recyclerOptions2 = new FirebaseRecyclerOptions.Builder<PdfModel>().setQuery(FirebaseDatabase.getInstance().getReference("Pooja Vidhi/Pdf Uploader"), PdfModel.class).build();
        pdfAdapter = new PdfAdapter(recyclerOptions2, progressBarPdf, getContext());
        recyclerViewPdf.setAdapter(pdfAdapter);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        readAdapter.startListening();
        videoAdapter.startListening();
        pdfAdapter.startListening();
    }
}