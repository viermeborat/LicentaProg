package com.example.dida.licentaprog;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class CalendarActivity extends AppCompatActivity {

    private CalendarView calendarV;
    private Button btAdd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar_layout);
        calendarV = (CalendarView) findViewById(R.id.calendarView);

        btAdd = (Button) findViewById(R.id.btAdd);

        btAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalendarActivity.this, ProgramareActivity.class);
                startActivity(intent);

            }
        });

    }
}
