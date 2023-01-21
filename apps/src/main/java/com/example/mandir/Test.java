package com.example.mandir;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Test extends AppCompatActivity {

    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Intent intent = new Intent();
//                intent.setClassName("com.pujagoodies.sacred","com.pujagoodies.sacred.MainActivity");
//                startActivity(intent);
//
//                startActivity(intent);

                Intent intent = new Intent(Test.this, DummyActivity.class);
                startActivity(intent);
            }
        });
    }
}