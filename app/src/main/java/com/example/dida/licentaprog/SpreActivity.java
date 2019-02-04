package com.example.dida.licentaprog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SpreActivity extends AppCompatActivity {

    private Intrebari mQuestionLibrary = new Intrebari();

    private TextView mQuestionView;
    private TextView mDecisionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice1_1;
    private Button mButtonChoice1_2;
    private Button mButtonChoice1_3;


    private int mScore = 0;
    private int punctajQ[];
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sprefem);

        mQuestionView = (TextView) findViewById(R.id.intrebare);
        mDecisionView = (TextView) findViewById(R.id.Decizie);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice1_1 = (Button) findViewById(R.id.choice1_1);
        mButtonChoice1_2 = (Button) findViewById(R.id.choice1_2);
        mButtonChoice1_3 = (Button) findViewById(R.id.choice1_3);
        mButtonChoice1_1.setVisibility(View.INVISIBLE);
        mButtonChoice1_2.setVisibility(View.INVISIBLE);
        mButtonChoice1_3.setVisibility(View.INVISIBLE);
        mDecisionView.setVisibility(View.INVISIBLE);

        updateQuestion();

        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//DA

                mButtonChoice1.setVisibility(View.INVISIBLE);
                mButtonChoice2.setVisibility(View.INVISIBLE);
                mDecisionView.setVisibility(View.VISIBLE);
                mButtonChoice1_1.setVisibility(View.VISIBLE);
                mButtonChoice1_2.setVisibility(View.VISIBLE);
                mButtonChoice1_3.setVisibility(View.VISIBLE);

                mButtonChoice1_1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mScore = mScore + 0;
                        punctajQ[mQuestionNumber] = 0;
                        mQuestionNumber++;
                        updateQuestion();
                    }
                });

                mButtonChoice1_2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mScore = mScore + 0;
                        punctajQ[mQuestionNumber] = 0;
                        mQuestionNumber++;
                        updateQuestion();
                    }
                });

                mButtonChoice1_3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mScore = mScore + 1;
                        punctajQ[mQuestionNumber] = 1;
                        mQuestionNumber++;
                        updateQuestion();
                    }
                });
            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//NU

                    mScore = mScore + 0;
                    punctajQ[mQuestionNumber] = 0; //sccrii punctajul la intrebare in vector la pozitia intrebarii
                    mQuestionNumber++;
                    updateQuestion();

            }
        });


    }

    private void updateQuestion(){
        if(mQuestionNumber<=118) {
            mButtonChoice1.setVisibility(View.VISIBLE);
            mButtonChoice2.setVisibility(View.VISIBLE);
            mButtonChoice1_1.setVisibility(View.INVISIBLE);
            mButtonChoice1_2.setVisibility(View.INVISIBLE);
            mButtonChoice1_3.setVisibility(View.INVISIBLE);
            mDecisionView.setVisibility(View.INVISIBLE);
            mQuestionView.setText(mQuestionLibrary.getQuestion(mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice1());
            mButtonChoice2.setText(mQuestionLibrary.getChoice2());
            ////////////////////////////////////////////

        }else {
            mButtonChoice1.setVisibility(View.INVISIBLE);
            mButtonChoice2.setVisibility(View.INVISIBLE);


            Bundle bundle = getIntent().getExtras();
            String key = bundle.getString("id");
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("Pacient").child(key);
            myRef.child("Tulburare: ").setValue(mQuestionView);//mScore
           /* int score_temp = 0;
            for(int i = 0; i <= 6; i++){ //adunci in score_temp punctajul la primele 7 intrebari
                score_temp += punctajQ[i];
            }
            if( score_temp >= 4){ //verifici punctajul si afisezi
                mQuestionView.setText("Tulurare de personalitate evidenta");
                myRef.child("Tulburare: ").setValue(mQuestionView);//mScore
            }

            for(int i = 7; i <= 14; i++){
                score_temp += punctajQ[i];
            }
            if (score_temp >= 5) {
                mQuestionView.setText("Tulburare de personalitate dependenta");
                myRef.child("Tulburare: ").setValue(mQuestionView);//mScore
            }

            for (int i = 15; i <= 23; i++){
                score_temp += punctajQ[i];
            }
            if(score_temp >= 5){
                mQuestionView.setText("Tulburare de personalitate obsesivo-compulsiva");
                myRef.child("Tulburare: ").setValue(mQuestionView);//mScore
            }

            for(int i = 24; i <= 31; i++){
                score_temp += punctajQ[i];
            }
            if(score_temp >= 5){
                mQuestionView.setText("Tulburare de personalitate pasiv-agresiva");
                myRef.child("Tulburare: ").setValue(mQuestionView);//mScore
            }

            for(int i = 32; i <= 39; i++){
                score_temp += punctajQ[i];
            }
            if(score_temp >= 5){
                mQuestionView.setText("Tulburare de personalitate depresiva");
                myRef.child("Tulburare: ").setValue(mQuestionView);//mScore
            }

            for(int i = 40; i <= 47; i++){
                score_temp += punctajQ[i];
            }
            if(score_temp >= 4){
                mQuestionView.setText("Tulburare de personalitate paranoida");
                myRef.child("Tulburare: ").setValue(mQuestionView);//mScore
            }

            for(int i = 48; i <= 58; i++){
                score_temp += punctajQ[i];
            }
            if(score_temp >= 4){
                mQuestionView.setText("Tulburare de personalitate Schizotipala");
                myRef.child("Tulburare: ").setValue(mQuestionView);//mScore
            }

            for(int i = 59; i <= 64; i++){
                score_temp += punctajQ[i];
            }
            if(score_temp >= 4){
                mQuestionView.setText("Tulburare de personalitate Schizoida");
                myRef.child("Tulburare: ").setValue(mQuestionView);//mScore
            }

            for(int i = 65; i <= 71; i++){
                score_temp += punctajQ[i];
            }
            if(score_temp >= 5){
                mQuestionView.setText("Tulburare de personalitate Histrionica");
                myRef.child("Tulburare: ").setValue(mQuestionView);//mScore
            }

            for(int i = 72; i <= 88; i++){
                score_temp += punctajQ[i];
            }
            if(score_temp >= 5){
                mQuestionView.setText("Tulburare de personalitate Narcisista");
                myRef.child("Tulburare: ").setValue(mQuestionView);//mScore
            }

            for(int i = 89; i <= 103; i++){
                score_temp += punctajQ[i];
            }
            if(score_temp >= 5){
                mQuestionView.setText("Tulburare de personalitate Borderline");
                myRef.child("Tulburare: ").setValue(mQuestionView);//mScore
            }

            for(int i = 104; i <= 118; i++){
                score_temp += punctajQ[i];
            }
            if(score_temp >= 5){
                mQuestionView.setText("Tulburare de personalitate Antisociala");
                myRef.child("Tulburare: ").setValue(mQuestionView);//mScore
            }*/



             for ( int i = 0; i <= 6; i++) {
                    if (mScore >= 4) {
                        mQuestionView.setText("Tulurare de personalitate evidenta");
                    }
                }

                for (int i = 7; i <= 14; i++) {
                    if (mScore >= 5) {
                        mQuestionView.setText("Tulburare de personalitate dependenta");
                    }
                }

                for (int i = 15; i <= 23; i++) {
                    if (mScore >= 5) {
                        mQuestionView.setText("Tulburare de personalitate obsesivo-compulsiva");
                    }
                }

                for (int i = 24; i <= 31; i++) {
                    if (mScore >= 5) {
                        mQuestionView.setText("Tulburare de personalitate pasiv-agresiva");
                    }
                }

                for (int i = 32; i <= 39; i++) {
                    if (mScore >= 5) {
                        mQuestionView.setText("Tulburare de personalitate depresiva");
                    }
                }

                for (int i = 40; i <= 47; i++) {
                    if (mScore >= 4) {
                        mQuestionView.setText("Tulburare de personalitate paranoida");
                    }
                }

                for ( int i = 48; i <= 58; i++) {
                    if (mScore >= 5) {
                        mQuestionView.setText("Tulburare de personalitate Schizotipala");
                    }
                }

                for (int i = 59; i <= 64; i++) {
                    if (mScore >= 4) {
                        mQuestionView.setText("Tulburare de personalitate Schizoida");
                    }
                }

                for (int i = 65; i <= 71; i++) {
                    if (mScore >= 5) {
                        mQuestionView.setText("Tulburare de personalitate Histrionica");
                    }
                }

                for (int i = 72; i <= 88; i++) {
                    if (mScore >= 5) {
                        mQuestionView.setText("Tulburare de personalitate Narcisista");
                    }
                }

                for (int i = 89; i <= 103; i++) {
                    if (mScore >= 5) {
                        mQuestionView.setText("Tulburare de personalitate Borderline");
                    }
                }

                for (int i = 104; i <= 118; i++) {
                    if (mScore >= 2) {
                        mQuestionView.setText("Tulburare de personalitate Antisociala");
                    }
                }
        }
    }



}
