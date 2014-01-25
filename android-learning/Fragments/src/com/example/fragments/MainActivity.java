package com.example.fragments;

import android.os.Bundle;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Point;
import android.view.Display;
import android.view.Menu;
import android.view.WindowManager;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// FragmentManager fragmentManager = getFragmentManager();
		// FragmentTransaction fragmentTransaction = fragmentManager
		// .beginTransaction();
		//
		// WindowManager wm = getWindowManager();
		// Display d = wm.getDefaultDisplay();
		// Point size = new Point();
		// d.getSize(size);
		// if (size.x > size.y) {
		// Fragment1 fragment1 = new Fragment1();
		// fragmentTransaction.replace(android.R.id.content, fragment1);
		// } else {
		// Fragment2 fragment2 = new Fragment2();
		// fragmentTransaction.replace(android.R.id.content, fragment2);
		// }
		// fragmentTransaction.addToBackStack(null);
		// fragmentTransaction.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
