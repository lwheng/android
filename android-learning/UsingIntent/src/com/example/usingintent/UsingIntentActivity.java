package com.example.usingintent;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class UsingIntentActivity extends Activity {

	int request_code = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_using_intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.using_intent, menu);
		return true;
	}

	public void onClick(View v) {
		startActivityForResult(new Intent(
				"com.example.usingintent.SecondActivity"), request_code);
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == request_code) {
			Toast.makeText(getBaseContext(), data.getData().toString(),
					Toast.LENGTH_SHORT).show();
		}
	}

}
