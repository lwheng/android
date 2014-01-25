package com.example.orientations;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d("StateInfo", "onCreate");
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.main, menu);
	// return true;
	// }

	public void onStart() {
		Log.d("StateInfo", "onStart");
		super.onStart();
	}

	public void onResume() {
		Log.d("StateInfo", "onResume");
		super.onResume();
	}

	public void onPause() {
		Log.d("StateInfo", "onPause");
		super.onPause();
	}

	public void onStop() {
		Log.d("StateInfo", "onStop");
		super.onStop();
	}

	public void onDestroy() {
		Log.d("StateInfo", "onDestroy");
		super.onDestroy();
	}

	public void onRestart() {
		Log.d("StateInfo", "onRestart");
		super.onRestart();
	}

}
