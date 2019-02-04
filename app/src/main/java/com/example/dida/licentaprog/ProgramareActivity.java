package com.example.dida.licentaprog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import java.text.DateFormat;
import java.util.Calendar;


public class ProgramareActivity extends AppCompatActivity{

    DateFormat formatDateTime = DateFormat.getDateInstance();
    Calendar dateTime=Calendar.getInstance();
    private TextView textView2;
    private TextView textView3;
    private Button button2;
    private Button button3;
    private Button button4;
    public static String KEY_NUME = "NumePers";
    public static String KEY_OBS = "Observatii";
    public static String KEY_DATA = "data";
    public static String KEY_ORA = "ora";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.programare_layout);

        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        updateTextLable();

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDate();
            }
        });

        button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateTime();
            }
        });

        button4 = (Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProgramareActivity.this, CalendarActivity.class);

                EditText NumePacient = (EditText) findViewById(R.id.editText);
                EditText Observatii = (EditText) findViewById(R.id.editText1);
                TextView data = (TextView) findViewById(R.id.textView2);
                TextView ora = (TextView) findViewById(R.id.textView3);

                intent.putExtra(KEY_NUME,NumePacient.getText());
                intent.putExtra(KEY_OBS,Observatii.getText());
                intent.putExtra(KEY_DATA,data.getText());
                intent.putExtra(KEY_ORA,ora.getText());

                startActivity(intent);
                finish();
            }
        });
    }

    private void updateDate(){
        new DatePickerDialog(this, d, dateTime.get(Calendar.YEAR),dateTime.get(Calendar.MONTH),dateTime.get(Calendar.DAY_OF_MONTH)).show();
        }
            DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
             @Override
             public void onDateSet(DatePicker view, int an, int luna, int zi) {
                    dateTime.set(Calendar.YEAR, an);
                    dateTime.set(Calendar.MONTH, luna);
                    dateTime.set(Calendar.DAY_OF_MONTH, zi);
                    updateTextLable();
             }
        };

       private void updateTime(){
            new TimePickerDialog(this, t, dateTime.get(Calendar.HOUR_OF_DAY), dateTime.get(Calendar.MINUTE), true).show();
       }
         TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
             @Override
             public void onTimeSet(TimePicker view, int ora, int minut) {
                 view.setIs24HourView(true);
                 dateTime.set(Calendar.HOUR_OF_DAY, ora);
                 dateTime.set(Calendar.MINUTE, minut);
                 Toast.makeText(getApplicationContext(), ora + "  " + minut, Toast.LENGTH_SHORT).show();
                 textView3.setText("Ora: " + ora + " : " + minut );
             }
        };
    private void updateTextLable(){
        textView2.setText(formatDateTime.format(dateTime.getTime()));
    }


}
