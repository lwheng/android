package com.example.sms;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	String SENT = "SMS_SENT";
	String DELIVERED = "SMS_DELIVERED";
	PendingIntent sentPI, deliveredPI;
	BroadcastReceiver smsSentReceiver, smsDeliveredReceiver;
	IntentFilter intentFilter;

	private BroadcastReceiver intentReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			// TODO Auto-generated method stub
			TextView txtMessage = (TextView) findViewById(R.id.txtMessage);
			txtMessage.setText(intent.getExtras().getString("sms"));
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		sentPI = PendingIntent.getBroadcast(this, 0, new Intent(SENT), 0);
		deliveredPI = PendingIntent.getBroadcast(this, 0,
				new Intent(DELIVERED), 0);
		intentFilter = new IntentFilter();
		intentFilter.addAction("SMS_RECEIVED_ACTION");

		registerReceiver(intentReceiver, intentFilter);
	}

	public void onResume() {
		super.onResume();

		// registerReceiver(intentReceiver, intentFilter);

		smsSentReceiver = new BroadcastReceiver() {
			@Override
			public void onReceive(Context context, Intent intent) {
				// TODO Auto-generated method stub
				switch (getResultCode()) {
				case Activity.RESULT_OK:
					displayToast("SMS sent");
					break;
				case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
					displayToast("Generic Failure");
					break;
				case SmsManager.RESULT_ERROR_NO_SERVICE:
					displayToast("No service");
					break;
				case SmsManager.RESULT_ERROR_NULL_PDU:
					displayToast("Null PDU");
					break;
				case SmsManager.RESULT_ERROR_RADIO_OFF:
					displayToast("Radio Off");
				}
			}
		};

		smsDeliveredReceiver = new BroadcastReceiver() {

			@Override
			public void onReceive(Context context, Intent intent) {
				// TODO Auto-generated method stub
				switch (getResultCode()) {
				case Activity.RESULT_OK:
					displayToast("SMS delivered");
					break;

				case Activity.RESULT_CANCELED:
					displayToast("SMS not delivered");
					break;
				}
			}

		};

		registerReceiver(smsSentReceiver, new IntentFilter(SENT));
		registerReceiver(smsDeliveredReceiver, new IntentFilter(DELIVERED));
	}

	public void onPause() {
		super.onPause();
		// unregisterReceiver(intentReceiver);
		unregisterReceiver(smsSentReceiver);
		unregisterReceiver(smsDeliveredReceiver);
	}

	public void onDestroy() {
		super.onDestroy();
		unregisterReceiver(intentReceiver);
	}

	public void displayToast(String msg) {
		Toast.makeText(getBaseContext(), msg, Toast.LENGTH_SHORT).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick(View view) {
		sendSMS("91479819", "Hello World from the app");
	}

	private void sendSMS(String phoneNumber, String msg) {
		SmsManager sms = SmsManager.getDefault();
		sms.sendTextMessage(phoneNumber, null, msg, sentPI, deliveredPI);
	}

	public void launchSMSApp(View view) {
		Intent i = new Intent(android.content.Intent.ACTION_VIEW);
		i.putExtra("address", "91479819; 91479819");
		i.putExtra("sms_body", "Hello my friends");
		i.setType("vnd.android-dir/mms-sms");
		startActivity(i);
	}

}
