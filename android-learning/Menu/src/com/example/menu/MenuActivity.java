package com.example.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);

		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnCreateContextMenuListener(this);
	}

	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		CreateMenu(menu);
	}

	private void CreateMenu(Menu menu) {
		menu.setQwertyMode(true);
		MenuItem mnu1 = menu.add(0, 0, 0, "Item 1");
		{
			mnu1.setAlphabeticShortcut('a');
			mnu1.setIcon(R.drawable.ic_launcher);
		}
		MenuItem mnu2 = menu.add(0, 1, 1, "Item 2");
		{
			mnu2.setAlphabeticShortcut('b');
			mnu2.setIcon(R.drawable.ic_launcher);
		}
		MenuItem mnu3 = menu.add(0, 2, 2, "Item 3");
		{
			mnu3.setAlphabeticShortcut('c');
			mnu3.setIcon(R.drawable.ic_launcher);
		}
		MenuItem mnu4 = menu.add(0, 3, 3, "Item 4");
		{
			mnu4.setAlphabeticShortcut('d');
		}
		menu.add(0, 3, 3, "Item 5");
		menu.add(0, 3, 3, "Item 6");
		menu.add(0, 3, 3, "Item 7");
	}

	private boolean MenuChoice(MenuItem item) {
		switch (item.getItemId()) {
		case 0:
			Toast.makeText(getBaseContext(), "You clicked on Item 1", Toast.LENGTH_LONG)
					.show();
			return true;
		case 1:
			Toast.makeText(this, "You clicked on Item 2", Toast.LENGTH_LONG)
					.show();
			return true;
		case 2:
			Toast.makeText(this, "You clicked on Item 3", Toast.LENGTH_LONG)
					.show();
			return true;
		case 3:
			Toast.makeText(this, "You clicked on Item 4", Toast.LENGTH_LONG)
					.show();
			return true;
		case 4:
			Toast.makeText(this, "You clicked on Item 5", Toast.LENGTH_LONG)
					.show();
			return true;
		case 5:
			Toast.makeText(this, "You clicked on Item 6", Toast.LENGTH_LONG)
					.show();
			return true;
		case 6:
			Toast.makeText(this, "You clicked on Item 7", Toast.LENGTH_LONG)
					.show();
			return true;
		}
		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.menu, menu);
		super.onCreateOptionsMenu(menu);
		CreateMenu(menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		return MenuChoice(item);
	}

}
