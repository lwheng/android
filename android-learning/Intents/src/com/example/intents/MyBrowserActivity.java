package com.example.intents;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyBrowserActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.browser);

		Uri uri = getIntent().getData();
		WebView webview = (WebView) findViewById(R.id.webView01);
		webview.setWebViewClient(new Callback());
		webview.loadUrl(uri.toString());
	}

	private class Callback extends WebViewClient {
		public boolean shouldOverrideUrlLoading(WebView view, String url) {
			return (false);
		}
	}

	// @Override
	// public boolean onCreateOptionsMenu(Menu menu) {
	// // Inflate the menu; this adds items to the action bar if it is present.
	// getMenuInflater().inflate(R.menu.main, menu);
	// return true;
	// }

}
