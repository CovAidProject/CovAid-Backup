package com.example.covaid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class PageActivity extends AppCompatActivity {
    private Button logout;
    private Button beds;
    private Button plasma;
    private Button vaccine;
    private Button medicine;
    private Button oxygen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        logout = findViewById(R.id.logout);
        beds = findViewById(R.id.beds);
        plasma = findViewById(R.id.plasma);
        vaccine = findViewById(R.id.vaccine);
        medicine = findViewById(R.id.medicine);
        oxygen = findViewById(R.id.oxygen);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(PageActivity.this, "Logged Out Succesfully!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(PageActivity.this,StartActivity.class));

            }
        });
        beds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PageActivity.this,userlist.class));
            }
        });
        plasma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PageActivity.this,PlasmaActivity.class));
            }
        });
        vaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PageActivity.this,VaccineActivity.class));
            }
        });
        medicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PageActivity.this,MedicineActivity.class));
            }
        });
        oxygen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PageActivity.this,OxygenActivity.class));
            }
        });
//        FirebaseDatabase.getInstance().getReference().child("Programming Knowledge").child("Android").setValue("abcd");

        HashMap<String,Object>map = new HashMap<>();
        map.put("Name","Sabbi");
        map.put("Email","sabbi@gmail.com");
        FirebaseDatabase.getInstance().getReference().child("Programming Knowledge").child("MultiplevValues").updateChildren(map);
    }
}