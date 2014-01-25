package com.example.dialog;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;

public class DialogActivity extends Activity {
	CharSequence[] items = { "Google", "Apple", "Microsoft" };
	boolean[] itemsChecked = new boolean[items.length];

	ProgressDialog progressDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialog);
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.dialog, menu);
	// return true;
	// }

	public void onClick(View v) {
		Toast.makeText(getBaseContext(), "Main button clicked!",
				Toast.LENGTH_SHORT).show();
		showDialog(0);
	}

	public void onClick2(View v) {
		final ProgressDialog dialog = ProgressDialog.show(this,
				"Doing something", "Please wait", true);
		new Thread(new Runnable() {
			public void run() {
				try {
					// Simulate doing something
					Thread.sleep(5000);
					// Dismiss the dialog
					dialog.dismiss();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	public void onClick3(View v) {
		showDialog(1);
		progressDialog.setProgress(0);

		new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < 15; i++) {
					try {
						// Do something
						Thread.sleep(1000);
						progressDialog.incrementProgressBy((int) (100 / 15));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				progressDialog.dismiss();
			}
		}).start();
	}

	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case 0:
			Builder builder = new AlertDialog.Builder(this);
			builder.setIcon(R.drawable.ic_launcher);
			builder.setTitle("This is a dialog with some simple text...");
			builder.setPositiveButton("OK",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							Toast.makeText(getBaseContext(), "OK clicked!",
									Toast.LENGTH_SHORT).show();
						}
					});
			builder.setNegativeButton("Cancel",
					new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,
								int whichButton) {
							Toast.makeText(getBaseContext(), "Cancel clicked!",
									Toast.LENGTH_SHORT).show();
						}
					});
			builder.setMultiChoiceItems(items, itemsChecked,
					new DialogInterface.OnMultiChoiceClickListener() {
						@Override
						public void onClick(DialogInterface dialog, int which,
								boolean isChecked) {
							Toast.makeText(
									getBaseContext(),
									items[which]
											+ (isChecked ? " checked!"
													: " unchecked!"),
									Toast.LENGTH_SHORT).show();
						}
					});
			return builder.create();
		case 1:
			progressDialog = new ProgressDialog(this);
			progressDialog.setIcon(R.drawable.ic_launcher);
			progressDialog.setTitle("Downloading files...");
			progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
			// progressDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK",
			// new DialogInterface.OnClickListener() {
			//
			// @Override
			// public void onClick(DialogInterface dialog, int which) {
			// // TODO Auto-generated method stub
			// Toast.makeText(getBaseContext(), "OK clicked!",
			// Toast.LENGTH_SHORT).show();
			// }
			// });
			progressDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							Toast.makeText(getBaseContext(), "Cancel clicked!",
									Toast.LENGTH_SHORT).show();
						}
					});
			return progressDialog;
		}
		return null;
	}
}
