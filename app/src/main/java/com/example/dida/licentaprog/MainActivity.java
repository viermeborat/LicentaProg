package com.example.dida.licentaprog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private Button btCal;
    private Button btChes;
    private Button btPac;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView zLabel = (TextView) findViewById(R.id.zLabel);
        TextView lLabel = (TextView) findViewById(R.id.lLabel);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM");
        String strData = sdf.format(cal.getTime());
        String[] val = strData.split("/", 0);

        zLabel.setText(val[0]);
        lLabel.setText(val[1]);

        btCal = (Button) findViewById(R.id.btCal);
        btPac = (Button) findViewById(R.id.btPac);
        btChes = (Button) findViewById(R.id.btChes);

        btCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(intent);
            }
        });

        btChes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChestionarActivity.class);
                startActivity(intent);
            }
        });

        btPac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PacientiActivity.class);
                startActivity(intent);
            }
        });

    }
}

