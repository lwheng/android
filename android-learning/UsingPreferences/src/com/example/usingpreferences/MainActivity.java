package com.example.usingpreferences;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

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

	public void onClickLoad(View view) {
		Intent i = new Intent(
				"com.example.usingpreferences.AppPreferencesActivity");
		startActivity(i);
	}

	public void onClickDisplay(View view) {
		// SharedPreferences appPrefs = getSharedPreferences(
		// "com.example.usingpreferences_preferences", MODE_PRIVATE);
		SharedPreferences appPrefs = getSharedPreferences("appPreferences", MODE_PRIVATE);
		DisplayText(appPrefs.getString("editTextPref", ""));
	}

	public void onClickModify(View view) {
		// SharedPreferences appPrefs = getSharedPreferences(
		// "com.example.usingpreferences_preferences", MODE_PRIVATE);
		SharedPreferences appPrefs = getSharedPreferences("appPreferences", MODE_PRIVATE);
		SharedPreferences.Editor prefsEditor = appPrefs.edit();
		prefsEditor.putString("editTextPref",
				((EditText) findViewById(R.id.txtString)).getText().toString());
		prefsEditor.commit();
	}

	private void DisplayText(String str) {
		Toast.makeText(getBaseContext(), str, Toast.LENGTH_SHORT).show();
	}
}
