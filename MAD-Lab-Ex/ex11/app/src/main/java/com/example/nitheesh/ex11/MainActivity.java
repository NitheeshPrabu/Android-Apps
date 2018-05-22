package com.example.nitheesh.ex11;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

	Handler hand = new Handler();
	TextView txt;
	Runnable run;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		run = new Runnable() {

			@Override
			public void run() {
				updateTime();
			}
		};

		hand.postDelayed(run,1000);
		txt = (TextView) findViewById(R.id.text);

		//Create an offset from the current time in which the alarm will go off.
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.SECOND, 5);

		//Create a new PendingIntent and add it to the AlarmManager
		Intent intent = new Intent(this, AlarmReceiverActivity.class);
		PendingIntent pendingIntent = PendingIntent.getActivity(this,
				12345, intent, PendingIntent.FLAG_CANCEL_CURRENT);
		AlarmManager am =
				(AlarmManager)getSystemService(Activity.ALARM_SERVICE);
		am.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
				pendingIntent);
	}
	public void updateTime() {
		txt.setText("" + (Integer.parseInt(txt.getText().toString()) - 1));
		if (Integer.parseInt(txt.getText().toString()) == 0) {
		} else {
			hand.postDelayed(run, 1000);
		}
	}

}
