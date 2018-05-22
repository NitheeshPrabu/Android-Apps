package com.example.nitheesh.ex9;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

	Button save,read;
	EditText t1,t2;

	private Context mContext;

	private static final int REQUEST = 112;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		t1=(EditText)findViewById(R.id.editText);
		t2=(EditText)findViewById(R.id.editText2);
		save=(Button)findViewById(R.id.button);
		read=(Button)findViewById(R.id.button2);
		mContext = this;

		if (Build.VERSION.SDK_INT >= 23) {
			String[] PERMISSIONS = {android.Manifest.permission.READ_EXTERNAL_STORAGE,android.Manifest.permission.WRITE_EXTERNAL_STORAGE};
			if (!hasPermissions(mContext, PERMISSIONS)) {
				ActivityCompat.requestPermissions((Activity) mContext, PERMISSIONS, REQUEST );
			}
		}

		save.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String fname=t1.getText().toString();
				String data=t2.getText().toString();
				FileOutputStream fos;
				try{
					File myfile=new File("/sdcard/"+fname);
					myfile.createNewFile();
					FileOutputStream fout=new FileOutputStream(myfile);
					OutputStreamWriter myoutwriter=new OutputStreamWriter(fout);
					myoutwriter.append(data);
					myoutwriter.close();
					fout.close();
					Toast.makeText(getApplicationContext(),fname+" saved",Toast.LENGTH_LONG).show();
				}
				catch(FileNotFoundException e)
				{
					e.printStackTrace();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}
		});

		read.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String filename = t1.getText().toString();
				StringBuffer sbuffer = new StringBuffer();
				String adatarow = "";
				String aBuffer = "";
				try {
					File myfile = new File("/sdcard/" + filename);
					FileInputStream in = new FileInputStream(myfile);
					BufferedReader myreader = new BufferedReader(new InputStreamReader(in));
					while ((adatarow = myreader.readLine()) != null) {
						aBuffer += adatarow + "\n";
					}
					myreader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				Toast.makeText(getApplicationContext(), aBuffer, Toast.LENGTH_LONG).show();
			}
		});
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		switch (requestCode) {
			case REQUEST: {
				if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
					//do here
				} else {
					Toast.makeText(mContext, "The app was not allowed to read your store.", Toast.LENGTH_LONG).show();
				}
			}
		}
	}

	private static boolean hasPermissions(Context context, String... permissions) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null && permissions != null) {
			for (String permission : permissions) {
				if (ActivityCompat.checkSelfPermission(context, permission) != PackageManager.PERMISSION_GRANTED) {
					return false;
				}
			}
		}
		return true;
	}
}
