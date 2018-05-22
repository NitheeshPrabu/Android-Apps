package com.example.nitheesh.ex10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fn();

	}

	BroadcastReceiver onReceive;

	public void fn() {
		onReceive = new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
					final Bundle bundle = intent.getExtras();
					try {
						if (bundle != null) {
							final Object[] pdusObj = (Object[]) bundle.get("pdus");
							for (int i = 0; i < pdusObj.length; i++) {
								SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
								String phoneNumber = currentMessage.getDisplayOriginatingAddress();
								String senderNum = phoneNumber;
								String message = currentMessage.getDisplayMessageBody();
								Log.i("SmsReceiver", "senderNum: " + senderNum + "; message: " + message);
								int duration = Toast.LENGTH_LONG;
								Toast toast = Toast.makeText(context, "senderNum: " + senderNum + ", message: " + message, duration);
								toast.show();

							}
						}
					} catch (Exception e) {
						Toast.makeText(getApplicationContext(),e.toString(),Toast.LENGTH_SHORT).show();
					}
				}
			}


		};
		IntentFilter i = new IntentFilter();
		i.addAction("android.provider.Telephony.SMS_RECEIVED");
		registerReceiver(onReceive, i);
	}
}
