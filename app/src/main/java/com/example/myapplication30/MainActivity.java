package com.example.myapplication30;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TextView mTvDaySum;
    private TextView mTvMonth;
    private SignView mCvCalendar;
    private List<SignEntity> data;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTvDaySum = findViewById(R.id.punch_tv_day_sum);
        mTvMonth = findViewById(R.id.punch_tv_month);
        mCvCalendar = findViewById(R.id.punch_cv_calendar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        onReady();
    }

    @SuppressLint("SetTextI18n")
    private void onReady() {
          calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        //int date =  calendar.get(Calendar.DATE);
        int dayOfMonthToday = calendar.get(Calendar.DAY_OF_MONTH);
        List<SignDate> signDates = new ArrayList<>();
        signDates.add(new SignDate(2021, 5, 1, true));
        signDates.add(new SignDate(2021, 5, 2, true));
        signDates.add(new SignDate(2021, 5, 3, true));
        signDates.add(new SignDate(2021, 5, 4, true));
        signDates.add(new SignDate(2021, 5, 5, true));

        mTvDaySum.setText("本期连续登录\t"+signDates.size()+"\t天");
        mTvMonth.setText(year+"年"+getResources().getStringArray(R.array.month_array)[month]+"\t"+dayOfMonthToday+"日");

        data = new ArrayList<>();
        for (int i = 1; i <= dayOfMonthToday; i++) {
            SignEntity signEntity = new SignEntity();
            if (i == dayOfMonthToday) {
                signEntity.setDayType(2);
            } else {
                signEntity.setDayType(1);
            }
            for (int j = 0; j < signDates.size(); j++) {
                if (signDates.get(j).getDay() == i) {
                    signEntity.setDayType(0);
                    break;
                } else if (dayOfMonthToday == i) {
                    signEntity.setDayType(2);
                } else {
                    signEntity.setDayType(1);
                }
            }
            data.add(signEntity);
        }

        SignAdapter signAdapter = new SignAdapter(data);
        mCvCalendar.setAdapter(signAdapter);
    }

}