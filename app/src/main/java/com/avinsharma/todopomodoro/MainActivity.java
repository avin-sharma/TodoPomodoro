package com.avinsharma.todopomodoro;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTimerTextView;
    private boolean mTimerOn = false;

    //TODO: complete bottom bar
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    return true;
                case R.id.navigation_dashboard:
                    return true;
                case R.id.navigation_notifications:
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mTimerTextView = (TextView) findViewById(R.id.timer_text_view); // TextView displayed as timer
        //Count down timer
        final CountDownTimer countDownTimer = new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                String msg = "" + (int)((millisUntilFinished) / 1000 / 60) + ":" + (millisUntilFinished) / 1000;
                mTimerTextView.setText(msg);
            }

            public void onFinish() {
                mTimerTextView.setText("done!");
            }
        };

        // Setting Stop/Start of timer
        mTimerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mTimerOn){
                    countDownTimer.start();
                    mTimerOn = true;
                } else {
                    countDownTimer.cancel();
                    mTimerOn = false;
                }

            }
        });

    }

}
