package com.pujagoodies.sacred;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.pujagoodies.sacred.PrefConfig;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

import com.pujagoodies.sacred.adapter.MyAdapter;
import com.pujagoodies.sacred.model.GodImages;
import com.pujagoodies.sacred.model.MainGods;

public class MandirDummyActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    Button button;
    String check;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy_mandir);


        SharedPreferences sharedPreferences= getSharedPreferences("PREFERENCES",MODE_PRIVATE);
        String firstTime = sharedPreferences.getString("FirstTimeInstall","");
        if(firstTime.equals("Yes")) {
            startActivity(new Intent(MandirDummyActivity.this, MandirMainActivity.class));

        }
        else {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("FirstTimeInstall","Yes");
            editor.apply();

            recyclerView = findViewById(R.id.checkk);
            button = findViewById(R.id.ok);
            LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
            layoutManager2.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(layoutManager2);


            final ArrayList<MainGods> gods = new ArrayList<>();
            myAdapter = new MyAdapter(gods, getApplicationContext());
            FirebaseDatabase.getInstance().getReference().child("/pics").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    System.out.println("key 1 -> "+snapshot.getKey());
                    System.out.println("value 1 -> "+snapshot.getValue());
                    for (DataSnapshot data : snapshot.getChildren()) {
                        System.out.println("key 2 -> "+data.getKey());
                        System.out.println("value 2 -> "+data.getValue());


                        String name = "";

                        if(data.child("godName").getValue() == null){
                            name = "";
                        }else{
                            name = data.child("godName").getValue().toString();
                        }

                        String mainName = "";

                        if(data.child("godMainName").getValue() == null){
                            mainName = "";
                        }else{
                            mainName = data.child("godMainName").getValue().toString();
                        }


                        String key = data.getKey();
                        DataSnapshot dataSnapshot = snapshot.child("/" + key + "/godImages");
                        ArrayList<GodImages> godImages = new ArrayList<>();
                        for (DataSnapshot data2 : dataSnapshot.getChildren()) {
                            System.out.println("key 3 -> "+data2.getKey());
                            System.out.println("value 3 -> "+data2.getValue());
                            String poster = data2.child("image").getValue().toString();
                            GodImages godImages1 = new GodImages(poster);
                            godImages.add(godImages1);
                        }
                        MainGods mainGods = new MainGods(name, godImages, mainName);
                        gods.add(mainGods);
                    }
                    myAdapter.notifyDataSetChanged();


                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
            recyclerView.setAdapter(myAdapter);
            recyclerView.setHasFixedSize(true);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ArrayList<Integer> posistions = new ArrayList<>(myAdapter.getSelected());
                    Collections.sort(posistions);
                    if (posistions.isEmpty()) {
                        Toast.makeText(MandirDummyActivity.this, "Choose atleast One god", Toast.LENGTH_LONG).show();
                    } else {
//                    Toast.makeText(DummyActivity.this, posistions.toString(), Toast.LENGTH_LONG).show();
                        PrefConfig.writeListInPref(getApplicationContext(), posistions);
                        Intent intent = new Intent(MandirDummyActivity.this, MandirMainActivity.class);
                        intent.putExtra("pos", posistions);
                        startActivity(intent);
                    }
                }
            });
        }


    }

}