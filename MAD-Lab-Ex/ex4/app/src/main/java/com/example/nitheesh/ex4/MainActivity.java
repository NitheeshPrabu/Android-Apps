package com.example.nitheesh.ex4;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

	DemoView demoview;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		demoview = new DemoView(this);
		setContentView(demoview);
	}
	private class DemoView extends View {
		public DemoView(Context context){
			super(context);
		}
		@Override protected void onDraw(Canvas canvas) {
			super.onDraw(canvas);
			// custom drawing code here
			Paint ob = new Paint();
			ob.setStyle(Paint.Style.FILL);
			// make the entire canvas white
			ob.setColor(Color.WHITE);
			canvas.drawPaint(ob);
			// draw blue circle with anti aliasing turned off
			ob.setAntiAlias(false);
			ob.setColor(Color.GREEN);
			canvas.drawCircle(200, 200, 150, ob);
			// draw green circle with anti aliasing turned on
			ob.setAntiAlias(true);
			ob.setColor(Color.CYAN);
			canvas.drawCircle(720, 500, 300, ob);
			ob.setColor(Color.BLUE);
			RectF oval3 = new RectF(250, 850, 350, 400);
			canvas.drawOval(oval3, ob);
			// draw red rectangle with anti aliasing turned off
			ob.setAntiAlias(false);
			ob.setColor(Color.MAGENTA);
			canvas.drawRect(100, 1200, 1000, 1500, ob);
			ob.setAntiAlias(false);
			ob.setColor(Color.RED);
			canvas.drawLine(250, 50, 350, 400,ob);
			// draw the rotated text
			canvas.rotate(-45);
			ob.setStyle(Paint.Style.FILL);
			canvas.drawText("FDP Training MAD", 50, 180, ob);
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
