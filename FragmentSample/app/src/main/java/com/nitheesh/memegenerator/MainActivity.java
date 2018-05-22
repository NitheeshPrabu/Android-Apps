package com.nitheesh.memegenerator;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;



public class MainActivity extends AppCompatActivity implements TopSectionFragment.TopSectionListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	//This code called by the Top Fragment called when the user clicked the button
	@Override
	public void createClick(String top, String bottom) {
		BottomPictureFragment bottomFragment =
				(BottomPictureFragment)getSupportFragmentManager().findFragmentById(R.id.fragment2);
		bottomFragment.setClickedText(top, bottom);
	}


}
