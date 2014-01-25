package com.example.dialogfragmentexample;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Fragment1 dialogFragment = Fragment1
				.newInstance("Are you sure you want to do this?");
		dialogFragment.show(getFragmentManager(), "dialog");
	}
	
	public void doPositiveClick() {
		Log.d("DialogFragmentExample", "User clicks on OK");
	}
	
	public void doNegativeClick() {
		Log.d("DialogFragmentExample", "User clicks on Cancel");
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

}
