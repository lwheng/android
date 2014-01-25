package com.example.contentproviders;

import android.app.Activity;
import android.content.ContentValues;
import android.content.CursorLoader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ContentValues editedValues = new ContentValues();
		editedValues.put(BooksProvider.TITLE, "Android Tips and Tricks");
		getContentResolver().update(
				Uri.parse("content://com.example.provider.Books/books/2"),
				editedValues, null, null);

		getContentResolver().delete(
				Uri.parse("content://com.example.provider.Books/books/2"),
				null, null);

		getContentResolver().delete(
				Uri.parse("content://com.example.provider.Books/books"), null,
				null);

		Button btnAdd = (Button) findViewById(R.id.btnAdd);
		btnAdd.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				/*
				 * //---add a book--- ContentValues values = new
				 * ContentValues(); values.put(BooksProvider.TITLE, ((EditText)
				 * findViewById(R.id.txtTitle)).getText().toString());
				 * values.put(BooksProvider.ISBN, ((EditText)
				 * findViewById(R.id.txtISBN)).getText().toString()); Uri uri =
				 * getContentResolver().insert(BooksProvider.CONTENT_URI,
				 * values); Toast.makeText(getBaseContext(),uri.toString(),
				 * Toast.LENGTH_LONG).show();
				 */

				ContentValues values = new ContentValues();
				values.put("title", ((EditText) findViewById(R.id.txtTitle))
						.getText().toString());
				values.put("isbn", ((EditText) findViewById(R.id.txtISBN))
						.getText().toString());
				Uri uri = getContentResolver()
						.insert(Uri
								.parse("content://com.example.provider.Books/books"),
								values);
				Toast.makeText(getBaseContext(), uri.toString(),
						Toast.LENGTH_LONG).show();
			}
		});

		Button btnRetrieve = (Button) findViewById(R.id.btnRetrieve);
		btnRetrieve.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// ---retrieve the titles---
				Uri allTitles = Uri
						.parse("content://com.example.provider.Books/books");
				CursorLoader cursorLoader = new CursorLoader(getBaseContext(),
						allTitles, null, null, null, "title desc");
				Cursor c = cursorLoader.loadInBackground();
				if (c.moveToFirst()) {
					do {
						Log.v("ContentProviders",
								c.getString(c.getColumnIndex(BooksProvider._ID))
										+ ", "
										+ c.getString(c
												.getColumnIndex(BooksProvider.TITLE))
										+ ", "
										+ c.getString(c
												.getColumnIndex(BooksProvider.ISBN)));
					} while (c.moveToNext());
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
