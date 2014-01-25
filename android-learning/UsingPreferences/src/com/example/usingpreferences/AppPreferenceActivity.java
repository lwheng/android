package com.example.usingpreferences;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;

public class AppPreferenceActivity extends PreferenceActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		PreferenceManager prefManager = getPreferenceManager();
		prefManager.setSharedPreferencesName("appPreferences");
		// ---load the preferences from an XML file---
		addPreferencesFromResource(R.xml.myapppreferences);
	}
}