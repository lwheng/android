package com.example.preferencefragmentexample;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.Menu;

public class PreferenceFragmentExampleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preference_fragment_example);

		FragmentManager fragmentManager = getFragmentManager();
		FragmentTransaction fragmentTranscation = fragmentManager
				.beginTransaction();
		Fragment1 fragment1 = new Fragment1();
		fragmentTranscation.replace(android.R.id.content, fragment1);
		fragmentTranscation.addToBackStack(null);
		fragmentTranscation.commit();
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.preference_fragment_example, menu);
	// return true;
	// }

}
