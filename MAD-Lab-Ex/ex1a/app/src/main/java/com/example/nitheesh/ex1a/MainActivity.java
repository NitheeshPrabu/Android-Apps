package com.example.nitheesh.ex1a;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		final Button loginButton = (Button) findViewById(R.id.lButton);
		loginButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				EditText uname = (EditText) findViewById(R.id.uname);
				final String username = uname.getText().toString();
				EditText pwd = (EditText) findViewById(R.id.pwd);
				final String password = pwd.getText().toString();
				if (username.equals("nitheesh") && password.equals("password")) {
					Intent intent = new Intent(view.getContext(), SecondActivity.class);
					startActivity(intent);
				} else {
					Toast.makeText(getApplicationContext(), "Wrong username/password", Toast.LENGTH_LONG).show();
				}
			}
		});
	}
}
