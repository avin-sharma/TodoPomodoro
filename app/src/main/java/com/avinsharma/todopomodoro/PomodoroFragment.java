package com.avinsharma.todopomodoro;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PomodoroFragment extends Fragment {

    private TextView mTimerTextView;
    private boolean mTimerOn = false;

    public PomodoroFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pomodoro, container, false);

        mTimerTextView = (TextView) view.findViewById(R.id.timer_text_view); // TextView displayed as timer
        //Count down timer
        final CountDownTimer countDownTimer = new CountDownTimer(1500000, 1000) {
            public void onTick(long millisUntilFinished) {
                String msg = "" + (int)((millisUntilFinished) / 1000 / 60) + ":" + (millisUntilFinished / 1000)%60;
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

        return view;
    }


}
