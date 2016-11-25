package com.nantian.websocketserver;

import java.net.InetSocketAddress;

import com.nantian.impl.SocketCenter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.webkit.WebView;


public class MainActivity extends Activity {

	private WebView mWebView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ChatServer s = new ChatServer(new InetSocketAddress(1337));
		s.start();
		//SocketCenter.getInstance();
		mWebView = (WebView) findViewById(R.id.web_view);
		mWebView.loadUrl("file:///android_asset/index.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


}
