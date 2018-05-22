package com.example.nitheesh.ex1b;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	Button bbt, rb, bb, gb, s18, s24, s30, s36;
	TextView txt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		bbt = (Button) findViewById(R.id.radioButton);
		rb = (Button) findViewById(R.id.radioButton2);
		bb = (Button) findViewById(R.id.radioButton3);
		gb = (Button) findViewById(R.id.radioButton4);
		s18 = (Button) findViewById(R.id.radioButton5);
		s24 = (Button) findViewById(R.id.radioButton6);
		s30 = (Button) findViewById(R.id.radioButton7);
		s36 = (Button) findViewById(R.id.radioButton8);

		txt = (TextView) findViewById(R.id.txt);

		bbt.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				txt.setTextColor(Color.BLACK);
				return false;
			}
		});

		rb.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				txt.setTextColor(Color.RED);
				return false;
			}
		});

		bb.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				txt.setTextColor(Color.BLUE);
				return false;
			}
		});

		gb.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				txt.setTextColor(Color.GREEN);
				return false;
			}
		});

		s18.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				txt.setTextSize(18);
				return false;
			}
		});

		s24.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				txt.setTextSize(24);
				return false;
			}
		});

		s30.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				txt.setTextSize(30);
				return false;
			}
		});

		s36.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				txt.setTextSize(36);
				return false;
			}
		});
	}

}
