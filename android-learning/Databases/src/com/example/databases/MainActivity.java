package com.example.databases;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		DBAdapter db = new DBAdapter(this);

		// db.open();
		// long id = db.insertContact("Heng Low Wee", "alpha116@gmail.com");
		// id = db.insertContact("John Smith", "email@example.com");
		// db.close();

		DisplayText("getAllContacts()");
		db.open();
		Cursor c = db.getAllContacts();
		if (c.moveToFirst()) {
			do {
				DisplayContact(c);
			} while (c.moveToNext());
		}
		db.close();

		DisplayText("getContact()");
		db.open();
		c = db.getContact(2);
		db.close();
		DisplayContact(c);

		DisplayText("updateContact()");
		db.open();
		if (db.updateContact(1, "Wang Luo Hui", "hnglww@gmail.com"))
			DisplayText("Update Successful!");
		else
			DisplayText("Update Failed!");
		db.close();

		DisplayText("deleteContact()");
		db.open();
		if (db.deleteContact(1)) {
			DisplayText("Deleted");
		} else {
			DisplayText("Delete failed");
		}
		db.close();

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private void DisplayContact(Cursor c) {
		String s = "";
		for (int i = 0; i < c.getColumnCount(); i++) {
			s += c.getColumnName(i) + ": " + c.getString(i) + "\n";
		}
		Toast.makeText(getBaseContext(), s, Toast.LENGTH_SHORT).show();
	}

	private void DisplayText(String s) {
		Toast.makeText(getBaseContext(), s, Toast.LENGTH_SHORT).show();
	}

}
