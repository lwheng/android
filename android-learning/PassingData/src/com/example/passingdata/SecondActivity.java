package com.example.passingdata;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondactivity);

		Intent passedIntent = getIntent();

		Toast.makeText(this, passedIntent.getStringExtra("str1").toString(),
				Toast.LENGTH_SHORT).show();
		Toast.makeText(this,
				Integer.toString(passedIntent.getIntExtra("age1", 0)),
				Toast.LENGTH_SHORT).show();

		Bundle bundle = passedIntent.getExtras();

		Toast.makeText(this, bundle.getString("str1"), Toast.LENGTH_SHORT)
				.show();
		Toast.makeText(this, Integer.toString(bundle.getInt("age1")),
				Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick(View v) {
		Intent intent = new Intent();
		Bundle bundle = new Bundle();
		bundle.putString("str2", "From 2nd activity");
		bundle.putInt("age2", 2);
		intent.putExtras(bundle);

		setResult(RESULT_OK, intent);
		finish();
	}

}
