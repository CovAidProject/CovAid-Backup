package com.example.covaid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DetailsActivity extends AppCompatActivity {
    private EditText name;
    private EditText phonenumber;
    private EditText address;
    private Button submit;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    UserDetails userdetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        
        name=findViewById(R.id.name);
        phonenumber=findViewById(R.id.phonenumber);
        address=findViewById(R.id.address);

        Spinner bloodgroup = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this,R.array.spinner, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bloodgroup.setAdapter(adapter1);

        Spinner vaccinationstatus = findViewById(R.id.spinner1);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.spinner1, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vaccinationstatus.setAdapter(adapter2);

        Spinner illness = findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this,R.array.spinner2, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        illness.setAdapter(adapter3);

        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("UserDetails");

        userdetails = new UserDetails();

        submit = findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){


                String name_text = name.getText().toString();
                String phonenumber_text = phonenumber.getText().toString();
                String address_text = address.getText().toString();
                String bloodgroup_text = String.valueOf(bloodgroup.getSelectedItemId());
                String vaccinationstatus_text = String.valueOf(vaccinationstatus.getSelectedItemId());
                String illness_text = String.valueOf(illness.getSelectedItemId());



                if(TextUtils.isEmpty(name_text) || TextUtils.isEmpty(phonenumber_text) ||TextUtils.isEmpty(address_text)||TextUtils.isEmpty(bloodgroup_text)||TextUtils.isEmpty(vaccinationstatus_text)|| TextUtils.isEmpty(illness_text)) {
                    Toast.makeText(DetailsActivity.this, "Name,Phone Number ,Address,Blood Group,Vaccination Status and Medical history cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else{
                    addDatatoFirebase(name_text, phonenumber_text, address_text,bloodgroup_text,vaccinationstatus_text,illness_text);
                    startActivity(new Intent(DetailsActivity.this, PageActivity.class));
                        finish();
                    }

            }

            private void addDatatoFirebase(String name, String phonenumber, String address,String bloodgroup,String vaccination,String illness) {

                userdetails.setUserName(name);
                userdetails.setUserContactNumber(phonenumber);
                userdetails.setUserAddress(address);
                userdetails.setUserBloodGruop(bloodgroup);
                userdetails.setUserVaccinationStatus(vaccination);
                userdetails.setUserIllness(illness);

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.setValue(userdetails);
                        Toast.makeText(DetailsActivity.this, "Data Added Successfully!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(DetailsActivity.this, "Fail to add data" + error , Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}