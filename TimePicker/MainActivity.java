package com.example.myapplication_time;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textview);
        TimePicker timePicker = findViewById(R.id.timepicker);

        // Set a listener for when the time changes
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                int hour = hourOfDay;
                String amPm;

                // Determine AM or PM and convert to 12-hour format
                if (hour == 0) {
                    hour = 12;
                    amPm = "AM";
                } else if (hour == 12) {
                    amPm = "PM";
                } else if (hour > 12) {
                    hour -= 12;
                    amPm = "PM";
                } else {
                    amPm = "AM";
                }

                // Format hour and minute for display
                String formattedHour = (hour < 10) ? "0" + hour : String.valueOf(hour);
                String formattedMinute = (minute < 10) ? "0" + minute : String.valueOf(minute);

                // Display the selected time
                String msg = "Time is: " + formattedHour + " : " + formattedMinute + " " + amPm;
                textView.setText(msg);
            }
        });
    }
}
