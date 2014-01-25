package com.example.passingdata;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
	int request_code = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick(View v) {
		Intent i = new Intent("com.example.passingdata.SecondActivity");
		Bundle extras = new Bundle();

		extras.putString("str1", "From Main");
		extras.putInt("age1", 20);

		i.putExtras(extras);

		startActivityForResult(i, request_code);
	}

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case 1:
			if (resultCode == RESULT_OK) {
				Toast.makeText(this, data.getExtras().getString("str2"),
						Toast.LENGTH_SHORT).show();
				Toast.makeText(this,
						Integer.toString(data.getExtras().getInt("age2")),
						Toast.LENGTH_SHORT).show();
			}
			break;

		default:
			break;
		}
	}

}
