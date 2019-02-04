package com.example.dida.licentaprog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class ChestionarActivity extends AppCompatActivity {

    private Button spre;
    private EditText Nnume;
    private EditText Nprenume;
    private EditText Nvarsta;
    private EditText Nsex;
    private EditText Ninaltime;
    private EditText Ngreutate;
    private EditText Ntelefon;
    private EditText Nmail;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("Pacient").push();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chestionar_layout);


        Nnume = (EditText) findViewById(R.id.nume);
        Nprenume = (EditText) findViewById(R.id.prenume);
        Nvarsta = (EditText) findViewById(R.id.varsta);
        Nsex = (EditText) findViewById(R.id.sex);
        Ninaltime = (EditText) findViewById(R.id.inaltime);
        Ngreutate = (EditText) findViewById(R.id.greutate);
        Ntelefon = (EditText) findViewById(R.id.telefon);
        Nmail = (EditText) findViewById(R.id.mail);
        spre = (Button) findViewById(R.id.spre);




        spre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myRef.child("Nume").setValue(Nnume.getText().toString());
                myRef.child("Prenume").setValue(Nprenume.getText().toString());
                myRef.child("Varsta").setValue(Nvarsta.getText().toString());
                myRef.child("Sex").setValue(Nsex.getText().toString());
                myRef.child("Inaltime").setValue(Ninaltime.getText().toString());
                myRef.child("Greutate").setValue(Ngreutate.getText().toString());
                myRef.child("Telefon").setValue(Ntelefon.getText().toString());
                myRef.child("Mail").setValue(Nmail.getText().toString());
                myRef.child("IMC").setValue(Integer.parseInt(Ngreutate.getText().toString())/((Integer.parseInt(Ninaltime.getText().toString())/100)^2));
                Intent intent = new Intent(ChestionarActivity.this,SpreActivity.class);
                String id=myRef.getKey();
                Bundle bundle = new Bundle();
                bundle.putString("id",id);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
