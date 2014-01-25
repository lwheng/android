package com.example.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText txtText;
	static final int READ_BLOCK_SIZE = 100;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		txtText = (EditText) findViewById(R.id.txtText1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClickSave(View v) {
		String str = txtText.getText().toString();
		try {
			FileOutputStream fOut = openFileOutput("textfile.txt",
					MODE_WORLD_READABLE);
			OutputStreamWriter osw = new OutputStreamWriter(fOut);

			// write string to the file
			osw.write(str);
			osw.flush();
			osw.close();

			Toast.makeText(getBaseContext(), "File saved!", Toast.LENGTH_SHORT)
					.show();

			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + "/MyFiles");
			dir.mkdirs();

			File file = new File(dir, "textfile.txt");
			fOut = new FileOutputStream(file);
			osw = new OutputStreamWriter(fOut);

			osw.write(str);
			osw.flush();
			osw.close();

			Toast.makeText(getBaseContext(), "File saved to sdcard!",
					Toast.LENGTH_SHORT).show();

			txtText.setText("");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void onClickLoad(View v) {
		try {
			FileInputStream fIn = openFileInput("textfile.txt");
			InputStreamReader isr = new InputStreamReader(fIn);

			char[] inputBuffer = new char[READ_BLOCK_SIZE];

			String s = "";

			int charRead;
			while ((charRead = isr.read(inputBuffer)) > 0) {
				String readString = String
						.copyValueOf(inputBuffer, 0, charRead);
				s += readString;

				inputBuffer = new char[READ_BLOCK_SIZE];
			}

			txtText.setText(s);

			Toast.makeText(getBaseContext(), "File loaded", Toast.LENGTH_SHORT)
					.show();

			File sdCard = Environment.getExternalStorageDirectory();
			File dir = new File(sdCard.getAbsolutePath() + "/MyFiles");
			File file = new File(dir, "textfile.txt");
			fIn = new FileInputStream(file);
			isr = new InputStreamReader(fIn);

			inputBuffer = new char[READ_BLOCK_SIZE];
			s = "";
			while ((charRead = isr.read(inputBuffer)) > 0) {
				String readString = String
						.copyValueOf(inputBuffer, 0, charRead);
				s += readString;

				inputBuffer = new char[READ_BLOCK_SIZE];
			}

			txtText.setText(s);
			Toast.makeText(getBaseContext(), "File loaded from sdcard!",
					Toast.LENGTH_SHORT).show();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
