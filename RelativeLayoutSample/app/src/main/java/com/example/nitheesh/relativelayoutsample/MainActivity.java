package com.example.nitheesh.relativelayoutsample;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//Layout
		RelativeLayout nitheeshsLayout = new RelativeLayout(this);
		nitheeshsLayout.setBackgroundColor(Color.GREEN);

		//Button
		Button redButton = new Button(this);
		redButton.setText("Log In");
		redButton.setBackgroundColor(Color.RED);

		//Username input
		EditText username = new EditText(this);

		redButton.setId(1);
		username.setId(2);

		RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT
		);
		RelativeLayout.LayoutParams usernameDetails = new RelativeLayout.LayoutParams(
				RelativeLayout.LayoutParams.WRAP_CONTENT,
				RelativeLayout.LayoutParams.WRAP_CONTENT
		);

		//Give rules to position widgets
		usernameDetails.addRule(RelativeLayout.ABOVE, redButton.getId());
		usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
		usernameDetails.setMargins(0,0,0,50);

		buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
		buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);

		Resources r = getResources();
		int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,200,
				r.getDisplayMetrics()
		);

		username.setWidth(px);

		//Add widget to layout(button is now a child of layout)
		nitheeshsLayout.addView(redButton, buttonDetails);
		nitheeshsLayout.addView(username, usernameDetails);

		//Set this activities content/display to this view
		setContentView(nitheeshsLayout);
	}
}
