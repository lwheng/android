package com.example.basicviews1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button btnSave = (Button) findViewById(R.id.btnSave);
		btnSave.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				displayToast("You clicked Save");
			}
		});

		Button btnOpen = (Button) findViewById(R.id.btnOpen);
		btnOpen.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				displayToast("You clicked Open");
			}
		});

		ImageButton imgBtn = (ImageButton) findViewById(R.id.btnImg);
		imgBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				displayToast("You clicked the Image Button");
			}
		});

		CheckBox chkAutosave = (CheckBox) findViewById(R.id.chkAutoSave);
		chkAutosave.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (((CheckBox) v).isChecked()) {
					displayToast("Autosave is on");
				} else {
					displayToast("Autosave is off");
				}
			}
		});

		CheckBox chkStar = (CheckBox) findViewById(R.id.star);
		chkStar.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (((CheckBox) v).isChecked()) {
					displayToast("Star On");
				} else {
					displayToast("Star Off");
				}
			}
		});

		RadioGroup radGroup = (RadioGroup) findViewById(R.id.radioGroup1);
		radGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				RadioButton radBtn = (RadioButton) findViewById(R.id.radioBtn1);
				if (radBtn.isChecked()) {
					displayToast("Option 1 Checked");
				} else {
					displayToast("Option 2 Checked");
				}

			}
		});

		ToggleButton toggleBtn = (ToggleButton) findViewById(R.id.toggle1);
		toggleBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (((ToggleButton) v).isChecked()) {
					displayToast("Toggled to ON");
				} else {
					displayToast("Toggled to OFF");
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

	private void displayToast(String msg) {
		Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
	}

}
