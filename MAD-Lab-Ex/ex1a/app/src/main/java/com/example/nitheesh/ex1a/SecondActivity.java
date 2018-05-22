package com.example.nitheesh.ex1a;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

	CheckBox android, dist, iot, ai, nlp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		android = (CheckBox) findViewById(R.id.androidCheckBox);
		dist = (CheckBox) findViewById(R.id.distCheckBox);
		ai = (CheckBox) findViewById(R.id.aiCheckBox);
		iot = (CheckBox) findViewById(R.id.iotCheckBox);
		nlp = (CheckBox) findViewById(R.id.nlpCheckBox);

		final Button submitButton = (Button) findViewById(R.id.submitButton);
		submitButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				StringBuilder str = new StringBuilder();
				TextView selectedText = (TextView) findViewById(R.id.selectedTextView);
				if (android.isChecked()) {
					if (str.length() != 0)
						str.append(", ");
					str.append(android.getText().toString());
				}
				if (dist.isChecked()) {
					if (str.length() != 0)
						str.append(", ");
					str.append(dist.getText().toString());
				}
				if (iot.isChecked()) {
					if (str.length() != 0)
						str.append(", ");
					str.append(iot.getText().toString());
				}
				if (ai.isChecked()) {
					if (str.length() != 0)
						str.append(", ");
					str.append(ai.getText().toString());
				}
				if (nlp.isChecked()) {
					if (str.length() != 0)
						str.append(", ");
					str.append(nlp.getText().toString());
				}
				if (str.length() == 0) {
					Toast.makeText(getApplicationContext(), "Please select an option!", Toast.LENGTH_SHORT).show();
					selectedText.setText("None");
				} else {
					str.append(" selected.");
					Toast.makeText(getApplicationContext(), "Preferences submitted!", Toast.LENGTH_SHORT).show();
					selectedText.setText(str);
				}
			}
		});
	}
}
