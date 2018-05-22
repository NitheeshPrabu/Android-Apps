package com.example.nitheesh.ex6;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by nitheesh on 26/2/18.
 */

public class Second extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		WebView myWebView=(WebView)findViewById(R.id.webView);
		myWebView.loadUrl("http://tutorialspoint.com/android/sampleXML.xml");
		myWebView.setWebViewClient(new WebViewClient() {

			@Override
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});
	}
}
