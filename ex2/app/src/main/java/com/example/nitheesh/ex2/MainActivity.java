package com.example.nitheesh.ex2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	@SuppressLint("ClickableViewAccessibility")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btn = (Button) findViewById(R.id.button);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				EditText txt = (EditText) findViewById(R.id.editText);
				Toast.makeText(getApplicationContext(), txt.getText().toString(), Toast.LENGTH_LONG).show();
			}
		});

		final GestureDetector gd = new GestureDetector(getApplicationContext(), new GestureDetector.SimpleOnGestureListener() {

			@Override
			public boolean onDoubleTap(MotionEvent e) {
				Toast.makeText(getApplicationContext(),"onDoubleTap",Toast.LENGTH_SHORT).show();
				return true;
			}

			@Override
			public void onLongPress(MotionEvent e) {
				Toast.makeText(getApplicationContext(),"onLongPress",Toast.LENGTH_SHORT).show();
				super.onLongPress(e);
			}

			@Override
			public boolean onSingleTapConfirmed(MotionEvent e) {
				Toast.makeText(getApplicationContext(),"onSingleTap",Toast.LENGTH_SHORT).show();
				return false;
			}

			@Override
			public boolean onDown(MotionEvent e) {
				return true;
			}
		});

		Button b = (Button) findViewById(R.id.b);
		b.setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return gd.onTouchEvent(event);
			}
		});
	}

}
