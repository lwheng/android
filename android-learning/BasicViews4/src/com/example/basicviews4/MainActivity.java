package com.example.basicviews4;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.view.Menu;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {

	TimePicker timePicker;
	DatePicker datePicker;

	int hour, minute;
	int day, month, yr;
	static final int TIME_DIALOG_ID = 0;
	static final int DATE_DIALOG_ID = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		timePicker = (TimePicker) findViewById(R.id.timePicker);
		timePicker.setIs24HourView(true);

		// showDialog(TIME_DIALOG_ID);

		datePicker = (DatePicker) findViewById(R.id.datePicker);

		Calendar today = Calendar.getInstance();
		yr = today.get(Calendar.YEAR);
		month = today.get(Calendar.MONTH);
		day = today.get(Calendar.DAY_OF_MONTH);

		showDialog(DATE_DIALOG_ID);
	}

	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case TIME_DIALOG_ID:
			return new TimePickerDialog(this, mTimeSetListener, hour, minute,
					false);

		case DATE_DIALOG_ID:
			return new DatePickerDialog(this, mDateSetListener, yr, month,
					day);
		}
		return null;
	}

	private DatePickerDialog.OnDateSetListener mDateSetListener = new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
			yr = year;
			month = monthOfYear;
			day = dayOfMonth;
			Toast.makeText(
					getBaseContext(),
					"You have selected : " + (month + 1) + "/" + day + "/"
							+ year, Toast.LENGTH_SHORT).show();
		}
	};

	private TimePickerDialog.OnTimeSetListener mTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
		public void onTimeSet(TimePicker view, int hourOfDay, int minuteOfHour) {
			hour = hourOfDay;
			minute = minuteOfHour;

			SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm aa");
			Calendar cal = Calendar.getInstance();
			cal.set(2013, 6, 2);
			cal.set(Calendar.HOUR, hour);
			cal.set(Calendar.MINUTE, minute);
			// Date date = new Date(0, 0, 0,
			// hour, minute);
			Date date = cal.getTime();
			String strDate = timeFormat.format(date);
			Toast.makeText(getBaseContext(), "You have selected " + strDate,
					Toast.LENGTH_SHORT).show();
		}
	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick(View v) {
		Toast.makeText(
				getBaseContext(),
				"Date selected:" + (datePicker.getMonth() + 1) + "/"
						+ datePicker.getDayOfMonth() + "/"
						+ datePicker.getYear() + "\n" + "Time selected:"
						+ timePicker.getCurrentHour() + ":"
						+ timePicker.getCurrentMinute(), Toast.LENGTH_SHORT)
				.show();
	}
}
