package com.example.mandir;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;

import adapter.MyAdapter;
import model.GodImages;
import model.MainGods;

public class DummyActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    Button button;
    String check;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);


        SharedPreferences sharedPreferences= getSharedPreferences("PREFERENCES",MODE_PRIVATE);
        String firstTime = sharedPreferences.getString("FirstTimeInstall","");
        if(firstTime.equals("es")) {
            startActivity(new Intent(DummyActivity.this, MainActivityMandir.class));

        }
        else {
            SharedPreferences.Editor editor = sharedPreferences.edit();
//            editor.putString("FirstTimeInstall","Yes");
            editor.putString("FirstTimeInstall","Yes");
            editor.apply();

            recyclerView = findViewById(R.id.checkk);
            button = findViewById(R.id.ok);
            LinearLayoutManager layoutManager2 = new LinearLayoutManager(this);
            layoutManager2.setOrientation(RecyclerView.VERTICAL);
            recyclerView.setLayoutManager(layoutManager2);


            final ArrayList<MainGods> gods = new ArrayList<>();
            myAdapter = new MyAdapter(gods, getApplicationContext());
            FirebaseDatabase.getInstance().getReference().child("god").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    System.out.println("Key one : "+snapshot.getKey());
                    ArrayList<GodImages> godImages = new ArrayList<>();
                    for (DataSnapshot childSnapshot:snapshot.getChildren()
                    ) {
                        System.out.println("Key two : " + childSnapshot.getKey());
                        System.out.println("value two : " + childSnapshot.getValue());

                        String images = String.valueOf(childSnapshot.getValue());
                        String name = String.valueOf(childSnapshot.getKey());
                        System.out.println("image taamit : " + images);
                        System.out.println("name taamit : " + name);

                        GodImages godImage = new GodImages(images);
                        godImages.add(godImage);
//                        MainGods mainGods = new MainGods(name, godImages, name);
                        MainGods mainGods = new MainGods(name,images);
                        gods.add(mainGods);

                        //###################################################
//                        System.out.println("Key two : " +childSnapshot.getKey());
//
//                        String names = childSnapshot.child(""+childSnapshot.getKey()).getKey().toString();
//                        System.out.println("name : "+names);
//                        ArrayList<GodImages> godImages = new ArrayList<>();
//
////
//                        for( DataSnapshot childSnapshot2 : childSnapshot.getChildren()){
////                                            System.out.println("Key three : " +childSnapshot2.getKey());
////                                            System.out.println("value three : " +childSnapshot2.getValue());
//
//                            String images = String.valueOf(childSnapshot2.getValue());
//                            String name = String.valueOf(childSnapshot2.getKey());
//                            System.out.println("image taamit : " +images);
//                            System.out.println("name taamit : " +name);
////
//                            GodImages godImage = new GodImages(images);
//                            godImages.add(godImage);
//
//                        }
//                        MainGods mainGods = new MainGods(names, godImages, names);
//                        gods.add(mainGods);
                        //##################################################
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
                        Toast.makeText(DummyActivity.this, "Choose atleast One god", Toast.LENGTH_LONG).show();
                    } else {
//                    Toast.makeText(DummyActivity.this, posistions.toString(), Toast.LENGTH_LONG).show();
                        PrefConfig.writeListInPref(getApplicationContext(), posistions);
                        Intent intent = new Intent(DummyActivity.this, MainActivityMandir.class);
                        intent.putExtra("pos", posistions);
                        startActivity(intent);
                    }
                }
            });
        }


    }

}