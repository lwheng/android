package com.example.gridview;

import android.app.Activity;
import android.os.Bundle;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
	// ---the images to display---
	Integer[] imageIDs = { R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
			R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7 };

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		GridView gridView = (GridView) findViewById(R.id.gridview);
		gridView.setAdapter(new ImageAdapter(this));

		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				Toast.makeText(getBaseContext(),
						"pic" + (position + 1) + " selected",
						Toast.LENGTH_SHORT).show();
			}
		});
	}

	public class ImageAdapter extends BaseAdapter {
		private Context context;

		public ImageAdapter(Context c) {
			context = c;
		}

		// ---returns the number of images---
		public int getCount() {
			return imageIDs.length;
		}

		// ---returns the ID of an item---
		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		// ---returns an ImageView view---
		public View getView(int position, View convertView, ViewGroup parent) {
			ImageView imageView;
			if (convertView == null) {
				imageView = new ImageView(context);
				imageView.setLayoutParams(new GridView.LayoutParams(185, 185));
				imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
				imageView.setPadding(1, 1, 1, 1);
			} else {
				imageView = (ImageView) convertView;
			}
			imageView.setImageResource(imageIDs[position]);
			return imageView;
		}
	}
}