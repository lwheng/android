package com.example.webview;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		WebView wv = (WebView) findViewById(R.id.webview1);
		WebSettings webSettings = wv.getSettings();
		webSettings.setBuiltInZoomControls(true);
		wv.loadUrl("file:///android_asset/Index.html");

		final String mimeType = "text/html";
		final String encoding = "UTF-8";
		String html = "<H1>A simple HTML page</H1><body>"
				+ "<p>The quick brown fox jumps over the lazy dog</p>";
		// wv.loadDataWithBaseURL("", html, mimeType, encoding, "");

		// wv.setWebViewClient(new Callback());
		// wv.loadUrl("http://ecx.images-amazon.com/images/I/41HGB-W2Z8L._SL500_AA300_.jpg");

		// wv.loadUrl("http://www.wrox.com");
	}

	private class Callback extends WebViewClient {
		@Override
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
