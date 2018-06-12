package jp.techacademy.hiromu.kikuchi.aisatsuapp;

import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.net.wifi.p2p.WifiP2pManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.TimePicker;

public class AisatsuApp extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aisatsu_app);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);


        mTextView = (TextView) findViewById(R.id.TextView);
    }
        @Override
            public void onClick(View v) {
              if (v.getId() == R.id.button1) {
                  showTimePickerDialog();
              }
        }
        private void showTimePickerDialog() {
            TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                    new TimePickerDialog.OnTimeSetListener() {
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                            Log.d("UI-PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));

                            TextView textView = (TextView) findViewById(R.id.TextView);

                            if (hourOfDay >= 2 && hourOfDay <= 9 && minute <= 59) {
                                Log.d("Aisatsu", "おはよう");
                                textView.setText("おはよう");

                            } else if (hourOfDay >= 10 && hourOfDay <=17 ) {
                                Log.d("Aisatsu1", "こんにちは");
                                textView.setText("こんにちは");

                            } else if (hourOfDay >= 18 || hourOfDay <=1  ) {
                                Log.d("Aisatsu2", "こんばんは");
                                textView.setText("こんばんは");
                            }

                        }
                    },
                    21,
                    58,
                    true);
            timePickerDialog.show();





        }

    }

