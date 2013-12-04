package lwheng.forceoverflowmenu;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.PopupMenu.OnMenuItemClickListener;
import android.widget.Toast;

/*
 * This implementation is what I learnt from http://developer.android.com/guide/topics/ui/menus.html#PopupMenu
 * If you searched enough about forcing overflow of the items on the Action Bar, the general answer is:
 *     DON'T FORCE IT.
 *     
 * It disrupts the overall Android feel.
 * 
 * However if it is absolutely necessary you need to force it to appear (maybe your client WANTS it), then this is
 * how you might implement it.
 */

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// We have added exactly ONE item to action bar. This will be the "overflow" item
		// Of course the icon looks different, but I'm sure you can get one yourself.

		// And sure, you can add more items onto the action bar (to the left of the "overflow" item that is)
		// Just modify the "main.xml" file accordingly.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// When we tap on the "overflow" item, we want it to show the popup.
		if (item.getItemId() == R.id.action_overflow) {
			showPopup(findViewById(item.getItemId()));
		}
		return super.onOptionsItemSelected(item);
	}

	public void showPopup(View v) {
		// Once we tapped on the "overflow" item, we want to load more items by inflating another xml, "main_child.xml"
		// main_child.xml would define the list of items you want to see when you tap on the "overflow" item.
		PopupMenu popup = new PopupMenu(this, v);
		MenuInflater inflater = popup.getMenuInflater();
		inflater.inflate(R.menu.main_child, popup.getMenu());

		// We'll need to add click listener to this popup we created.
		popup.setOnMenuItemClickListener(new OnMenuItemClickListener() {

			@Override
			public boolean onMenuItemClick(MenuItem item) {
				// You can do whatever you want here
				// E.g. start another activity
				Toast.makeText(getBaseContext(), item.getTitle() + " clicked", Toast.LENGTH_SHORT).show();
				return false;
			}
		});
		popup.show();
	}

	// To intercept the Hard Menu key button
	public boolean onKeyUp(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_MENU) {
			showPopup(findViewById(R.id.action_overflow));
			return true;
		}
		return super.onKeyUp(keyCode, event);
	}

}
