package com.nitheesh.gesturesample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;


public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
		GestureDetector.OnDoubleTapListener {
	private TextView buckysMessage;
	private GestureDetectorCompat gestureDetector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		buckysMessage = (TextView) findViewById(R.id.buckysMessage);
		this.gestureDetector = new GestureDetectorCompat(this, this);
		gestureDetector.setOnDoubleTapListener(this);
	}



	///////// GESTURE METHODS //////////
	@Override
	public boolean onSingleTapConfirmed(MotionEvent e) {
		buckysMessage.setText("onSingleTapConfirmed");
		return true;
	}

	@Override
	public boolean onDoubleTap(MotionEvent e) {
		buckysMessage.setText("onDoubleTap");
		return true;
	}

	@Override
	public boolean onDoubleTapEvent(MotionEvent e) {
		buckysMessage.setText("onDoubleTapEvent");
		return true;
	}

	@Override
	public boolean onDown(MotionEvent e) {
		buckysMessage.setText("onDown");
		return true;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		buckysMessage.setText("onShowPress");

	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		buckysMessage.setText("onSingleTapUp");
		return true;
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
		buckysMessage.setText("onScroll");
		return true;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		buckysMessage.setText("onLongPress");

	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
		buckysMessage.setText("onFling");
		return true;
	}

	///////// GESTURE METHODS //////////


	@Override
	public boolean onTouchEvent(MotionEvent event) {
		this.gestureDetector.onTouchEvent(event);
		return super.onTouchEvent(event);
	}


}
