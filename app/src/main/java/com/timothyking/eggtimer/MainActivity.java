package com.timothyking.eggtimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar timerSeekBar = (SeekBar) findViewById(R.id.timerSeekBar);
        final TextView timerTextView =(TextView) findViewById(R.id.timerTextView);

        // 10 minutes max
        // timerSeekBar.setMax(600);
        // timerSeekBar.setProgress(30);

        // 60 minutes max
        timerSeekBar.setMax(3600);
        timerSeekBar.setProgress(500);

        timerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int minutes = progress / 60;
                int seconds = progress - minutes * 60;

                String secondString = Integer.toString(seconds);

                // Hack to always show leading zero
                secondString = ("00" + secondString).substring(secondString.length());

                // if (secondString == "0") {
                //    secondString = "00";
                // }

                timerTextView.setText(Integer.toString(minutes) + ":" + secondString);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
