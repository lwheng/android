package com.example.activity101;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.util.Log;
import android.view.Window;

public class Activity101Activity extends Activity {
	String tag = "Lifecycle";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_activity101);
		Log.d(tag, "onCreate()");
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.activity101, menu);
	// return true;
	// }

	public void onStart() {
		super.onStart();
		Log.d(tag, "onStart()");
	}
	
	public void onRestart() {
		super.onRestart();
		Log.d(tag, "onRestart()");
	}
	
	public void onResume() {
		super.onResume();
		Log.d(tag, "onResume()");
	}
	
	public void onPause() {
		super.onPause();
		Log.d(tag, "onPause()");
	}
	
	public void onStop() {
		super.onStop();
		Log.d(tag, "onStop()");
	}
	
	public void onDestroy() {
		super.onDestroy();
		Log.d(tag, "onDestroy()");
	}
}
