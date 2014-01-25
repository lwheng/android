package com.example.provider;

import android.app.ListActivity;
import android.content.ContentUris;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Uri allContacts = Uri.parse("content://contacts/people");
		allContacts = ContactsContract.Contacts.CONTENT_URI;
		// allContacts = ContentUris.withAppendedId(
		// ContactsContract.Contacts.CONTENT_URI, 1);

		String[] projections = { ContactsContract.Contacts._ID,
				ContactsContract.Contacts.DISPLAY_NAME,
				ContactsContract.Contacts.HAS_PHONE_NUMBER };

		// String filter = ContactsContract.Contacts.DISPLAY_NAME
		// + " LIKE '%Heng%'";
		String filter = ContactsContract.Contacts.DISPLAY_NAME + " LIKE ?";
		String[] args = { "%Amanda%" };
		String orderBy = ContactsContract.Contacts.DISPLAY_NAME + " ASC";

		Cursor c;
		CursorLoader cursorLoader = new CursorLoader(getBaseContext(),
				allContacts, null, filter, args, orderBy);
		c = cursorLoader.loadInBackground();

		String[] columns = new String[] {
				ContactsContract.Contacts.DISPLAY_NAME,
				ContactsContract.Contacts._ID };

		int[] views = new int[] { R.id.txtContact, R.id.txtID };

		SimpleCursorAdapter adapter;

		adapter = new SimpleCursorAdapter(getBaseContext(),
				R.layout.activity_main, c, columns, views);

		this.setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
