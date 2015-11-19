package com.xhsc.webview;

import java.net.URL;

import com.xhsc.layout.relativelayout.R;
import com.xhsc.layout.ui.gridview.GridViewActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;

public class WebViewActivity extends Activity {

	String url = "http://192.168.1.183:8080/html/androidapp.html";
	WebView mWebView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.webview_activity_layout);
		mWebView = (WebView) findViewById(R.id.webview);
		mWebView.loadUrl(url);
		
		WebSettings settings = mWebView.getSettings();
		settings.setJavaScriptEnabled(true);
		
		mWebView.addJavascriptInterface(new WebViewJavaScript(), "musicServiceInterfaceName");
		
	}
	
	class WebViewJavaScript{
		
		public void playMusic(){
			Toast.makeText(WebViewActivity.this, "Html资源加载",Toast.LENGTH_SHORT).show();
		}
		
		public void startGridView(){
			Intent intent = new Intent(WebViewActivity.this, GridViewActivity.class);
			startActivity(intent);
		}
	}
}
