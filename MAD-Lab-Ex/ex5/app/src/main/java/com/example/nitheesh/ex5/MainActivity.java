package com.example.nitheesh.ex5;

import android.database.Cursor;
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
		final Button b1=(Button) findViewById(R.id.insert);
		final Button b2=(Button) findViewById(R.id.selectall);
		final Button b3=(Button) findViewById(R.id.select);
		final Button b4=(Button) findViewById(R.id.update);
		final Button b5=(Button) findViewById(R.id.delete);
		final EditText et1=(EditText)findViewById(R.id.id);
		final EditText et2=(EditText)findViewById(R.id.name);
		final EditText et3=(EditText)findViewById(R.id.email);
		final DBAdapter db = new DBAdapter(MainActivity.this);

		//---Insert Contact---
		b1.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				db.open();
				db.insertContact(Integer.parseInt(et1.getText().toString()),et2.getText().toString(),
						et3.getText().toString());
				db.close();
				Toast.makeText(getBaseContext(), "Inserted",Toast.LENGTH_SHORT).show();
			}
		});

		//---Select All contacts---
		b2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				db.open();
				Cursor c = db.getAllContacts();
				if (c.moveToFirst()) {
					do {
						DisplayContact(c);
					} while (c.moveToNext());
				}
				db.close();
			}

			private void DisplayContact(Cursor c) {
				// TODO Auto-generated method stub
				if (c != null)
					Toast.makeText(getBaseContext(),"id: " + c.getString(0)  +"Name: " + c.getString(1) + "\n" + "Email: " + c.getString(2),Toast.LENGTH_LONG).show();
				else Toast.makeText(getBaseContext(),"No record found",Toast.LENGTH_LONG).show();
			}
		});

		//---Select a contact---
		b3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				db.open();
				Cursor c;
				if (!et1.getText().toString().isEmpty())
					c = db.getContact(Integer.parseInt (et1.getText().toString()));
				else {
					Toast.makeText(getBaseContext(),"Please enter ID",Toast.LENGTH_LONG).show();
					db.close();
					return;
				}
				if (c.moveToFirst())
					DisplayContact(c);
				else
					Toast.makeText(getBaseContext(), "No contact found",Toast.LENGTH_LONG).show();
				db.close();
			}

			private void DisplayContact(Cursor c) {
				// TODO Auto-generated method stub
				if (c != null)
					Toast.makeText(getBaseContext(),"id: " + c.getString(0) + "\n" +"Name: " + c.getString(1) +   "\n" +  "Email: " + c.getString(2),Toast.LENGTH_LONG).show();
				else Toast.makeText(getBaseContext(),"No record found",Toast.LENGTH_LONG).show();
			}
		});

		//---updates a contact---
		b4.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				db.open();
				if (!et1.getText().toString().isEmpty() && !et2.getText().toString().isEmpty() && !et3.getText().toString().isEmpty()) {
					if (db.updateContact(Integer.parseInt(et1.getText().toString()), et2.getText().toString(), et3.getText().toString()))
						Toast.makeText(getBaseContext(), "Update successful.", Toast.LENGTH_LONG).show();
					else
						Toast.makeText(getBaseContext(), "Update failed.", Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(getBaseContext(),"Please enter all fields",Toast.LENGTH_LONG).show();
				}
				db.close();
			}
		});

		//---delete a contact---
		b5.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				db.open();
				if (!et1.getText().toString().isEmpty()) {
					db.deleteContact(Integer.parseInt(et1.getText().toString()));
					Toast.makeText(getBaseContext(), "Deleted", Toast.LENGTH_SHORT).show();
				} else Toast.makeText(getBaseContext(),"Please enter ID",Toast.LENGTH_LONG).show();
				db.close();
			}
		});
	}

}