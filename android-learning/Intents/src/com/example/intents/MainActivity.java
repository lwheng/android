package com.example.intents;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

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

	public void onClickWebBrowser(View v) {
		Intent i = new Intent(android.content.Intent.ACTION_VIEW,
				Uri.parse("http://www.amazon.com"));
		startActivity(Intent.createChooser(i, "Use..."));
	}

	public void onClickMakeCalls(View v) {
		Intent i = new Intent(android.content.Intent.ACTION_DIAL,
				Uri.parse("tel:+6591479819"));
		startActivity(i);
	}

	public void onClickShowMap(View v) {
		Intent i = new Intent(android.content.Intent.ACTION_VIEW,
				Uri.parse("geo:37.827500,-122.481670"));
		startActivity(i);
	}

	public void onClickLaunchMyBrowser(View v) {
		Intent i = new Intent("com.example.intents.MyBrowser");
		i.setData(Uri.parse("http://www.amazon.com"));
		startActivity(i);
	}

}
