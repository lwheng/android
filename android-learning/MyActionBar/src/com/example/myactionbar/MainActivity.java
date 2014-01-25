package com.example.myactionbar;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ActionBar actionBar = getActionBar();
		actionBar.setDisplayHomeAsUpEnabled(true);
		// // actionBar.hide();
		// actionBar.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.main, menu);

		super.onCreateOptionsMenu(menu);
		CreateMenu(menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		return MenuChoice(item);
	}

	public void CreateMenu(Menu menu) {
		MenuItem mnu1 = menu.add(0, 0, 0, "Item 1");
		mnu1.setIcon(R.drawable.ic_launcher);
		mnu1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM
				| MenuItem.SHOW_AS_ACTION_WITH_TEXT);

		MenuItem mnu2 = menu.add(0, 1, 1, "Item 2");
		mnu2.setIcon(R.drawable.ic_launcher);
		mnu2.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM
				| MenuItem.SHOW_AS_ACTION_WITH_TEXT);

		MenuItem mnu3 = menu.add(0, 2, 2, "Item 3");
		mnu3.setIcon(R.drawable.ic_launcher);
		mnu3.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM
				| MenuItem.SHOW_AS_ACTION_WITH_TEXT);

		MenuItem mnu4 = menu.add(0, 3, 3, "Item 4");
		mnu4.setIcon(R.drawable.ic_launcher);
		mnu4.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM
				| MenuItem.SHOW_AS_ACTION_WITH_TEXT);

		MenuItem mnu5 = menu.add(0, 4, 4, "Item 5");
		mnu5.setIcon(R.drawable.ic_launcher);
		mnu5.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM
				| MenuItem.SHOW_AS_ACTION_WITH_TEXT);
	}

	public boolean MenuChoice(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			displayToast("You clicked on the Application Icon");

			Intent i = new Intent(this, MainActivity.class);
			i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			// Clear Top ensures all activities are cleared when we return to Home of app
			startActivity(i);
			return true;
		case 0:
			displayToast("You clicked on Item "
					+ Integer.toString(item.getItemId() + 1));
		case 1:
			displayToast("You clicked on Item "
					+ Integer.toString(item.getItemId() + 1));
		case 2:
			displayToast("You clicked on Item "
					+ Integer.toString(item.getItemId() + 1));
		case 3:
			displayToast("You clicked on Item "
					+ Integer.toString(item.getItemId() + 1));
		case 4:
			displayToast("You clicked on Item "
					+ Integer.toString(item.getItemId() + 1));
		}
		return false;

	}

	private void displayToast(String msg) {
		Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
	}
}
