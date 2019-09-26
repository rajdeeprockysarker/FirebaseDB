package com.raj.firebasedbrajone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    EditText fName,lName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fName =(EditText)findViewById(R.id.fName);
        lName =(EditText)findViewById(R.id.lName);

        FirebaseApp.initializeApp(this);

        Button btn=(Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                basicReadWrite();
            }
        });



    }





    public void basicReadWrite() {

        FirebaseApp.initializeApp(getApplicationContext());
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("user");

        myRef.setValue(new User(fName.getText().toString(),lName.getText().toString()));

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                String fName = (String) dataSnapshot.child("fName").getValue();
                String lName = (String) dataSnapshot.child("lNam").getValue();
                Log.d("sdfg", "Value is: " + fName+" "+lName);
            }

            @Override
            public void onCancelled(DatabaseError error) {

                Log.w("qwerfgh", "Failed to read value.", error.toException());
            }
        });

    }

}
