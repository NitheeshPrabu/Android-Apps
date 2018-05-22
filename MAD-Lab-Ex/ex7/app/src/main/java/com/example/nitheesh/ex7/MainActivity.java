package com.example.nitheesh.ex7;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	Handler hand = new Handler();
	Button clickme;
	TextView timer;
	TextView label;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		label = (TextView) findViewById(R.id.textView2);
		timer = (TextView) findViewById(R.id.timer);
		clickme = (Button) findViewById(R.id.clickme);
		clickme.setVisibility(View.INVISIBLE);
		hand.postDelayed(run, 1000);

		clickme.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(getApplicationContext(),"Button clicked!",Toast.LENGTH_SHORT).show();
			}
		});
	}

	Runnable run = new Runnable() {

		@Override
		public void run() {
			updateTime();
		}
	};

	public void updateTime() {
		timer.setText("" + (Integer.parseInt(timer.getText().toString()) - 1));
		if (Integer.parseInt(timer.getText().toString()) == 0) {
			label.setText("Click button now");
			clickme.setVisibility(View.VISIBLE);
			Intent browserIntent =
					new Intent(Intent.ACTION_VIEW, Uri.parse("http://google.com/"));
			startActivity(browserIntent);
		} else {
			hand.postDelayed(run, 1000);
		}
	}
}
