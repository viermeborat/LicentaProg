package com.example.dida.licentaprog;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class PacientiActivity extends AppCompatActivity{

    private  String userID;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference().child("Pacient");

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("create","create");
        setContentView(R.layout.pacienti_layout);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("Paient");


        prepareListData();
        /*myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                showData(dataSnapshot);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/

    }

    private void prepareListData() {
        Log.d("prepare","prepare");
        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.d("prepare","prepare");
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    InfoPacienti pacient = snapshot.getValue(InfoPacienti.class);
                    Log.d("prepare","prepare");
                    Log.d("numepacient",pacient.getNume());
                }
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("cancel","cancel");
            }
        });
    }


    @Override
    public void onStart() {
        Log.d("start","start");
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
