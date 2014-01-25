package com.example.usingintent;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondactivity);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.using_intent, menu);
		return true;
	}

	public void onClick(View v) {
		Intent data = new Intent();

		EditText txt_username = (EditText) findViewById(R.id.txt_username);
		data.setData(Uri.parse(txt_username.getText().toString()));
		setResult(RESULT_OK, data);
		finish();
	}

}
