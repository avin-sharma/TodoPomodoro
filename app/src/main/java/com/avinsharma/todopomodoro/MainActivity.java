package com.avinsharma.todopomodoro;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private TextView mTimerTextView;
    private boolean mTimerOn = false;
    private static final int RC_SIGN_IN = 123;
    private FirebaseUser user;

    //TODO: complete bottom bar
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_pomodoro:
                    return true;
                case R.id.navigation_todo:
                    return true;
                case R.id.navigation_stats:
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseAuth auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            // already signed in
            user = auth.getCurrentUser();
        } else {
            // not signed in
            startActivityForResult(
                    AuthUI.getInstance()
                            .createSignInIntentBuilder()
                            .setProviders(Arrays.asList(new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                                    new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build(),
                                    new AuthUI.IdpConfig.Builder(AuthUI.FACEBOOK_PROVIDER).build()))
                            .setIsSmartLockEnabled(false)
                            .build(),
                    RC_SIGN_IN);
        }

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mTimerTextView = (TextView) findViewById(R.id.timer_text_view); // TextView displayed as timer
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

    }

}
