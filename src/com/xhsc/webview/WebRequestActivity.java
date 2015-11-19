package com.xhsc.webview;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import com.xhsc.layout.relativelayout.R;


import android.app.Activity;
import android.graphics.Path;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class WebRequestActivity extends Activity implements OnClickListener {
	TextView mTextView;
	Button mButton, mHttpClient_GET_Btn, mHttpClient_PSOT_Btn,mHttpClient_Utils_request;
	String httpPath = "http://192.168.1.183:8080/app/login";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.request_web_server_layout);
		mTextView = (TextView) findViewById(R.id.request_textView);
		mButton = (Button) findViewById(R.id.request_button);
		mHttpClient_GET_Btn = (Button) findViewById(R.id.httpclient_apache_get_button);
		mHttpClient_PSOT_Btn = (Button) findViewById(R.id.httpclient_apache_post_button);
		mHttpClient_Utils_request = (Button) findViewById(R.id.httpclient_utils_apache_post_button);
		mButton.setOnClickListener(this);
		mHttpClient_GET_Btn.setOnClickListener(this);
		mHttpClient_PSOT_Btn.setOnClickListener(this);
		mHttpClient_Utils_request.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.request_button:
			new AsyncTask<String, Void, String>() {

				@Override
				protected String doInBackground(String... params) {
					String path = params[0];
					String result = requestServer(path);
					return result;
				}

				@Override
				protected void onPostExecute(String result) {
					mTextView.setText(result);
				};
			}.execute(httpPath);
			break;
		case R.id.httpclient_apache_get_button:
			new AsyncTask<String, Void, String>() {

				@Override
				protected String doInBackground(String... params) {
					String url = params[0];
					String param = "?user=admin&psw=123456";
					url=url+param;
					HttpClient client = new DefaultHttpClient();
					HttpGet getRequest = new HttpGet(url);
					HttpResponse response;
					try {
						response = client.execute(getRequest);
						// 可以写流
						/*InputStream is = response.getEntity().getContent();
						String str = readInputStream(is);
						return str;*/
						// 也可以用Apache封装好的工具类
						String apchaeStr = EntityUtils.toString(response.getEntity());
						return apchaeStr;
					} catch (ClientProtocolException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					return null;

				}

				@Override
				protected void onPostExecute(String result) {
					if (result != null) {
						mTextView.setText(result);
					}
				};
			}.execute(httpPath);
			break;
		case R.id.httpclient_apache_post_button:
			new AsyncTask<String, Void, String>(){

				@Override
				protected String doInBackground(String... params) {
					String url = params[0];
					HttpClient client = new DefaultHttpClient();
					HttpPost postRequest = new HttpPost(url);
					try {
						BasicNameValuePair pairUserName = new BasicNameValuePair("user", "张三");
						BasicNameValuePair pairUserPsw = new BasicNameValuePair("psw", "123456");
						ArrayList<BasicNameValuePair> pairs = new ArrayList<BasicNameValuePair>();
						pairs.add(pairUserName);
						pairs.add(pairUserPsw);
						HttpEntity entity = new UrlEncodedFormEntity(pairs, HTTP.UTF_8);
						postRequest.setEntity(entity);
						/**防中文乱码*/
						postRequest.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
						
						HttpResponse response = client.execute(postRequest);
						String str = EntityUtils.toString(response.getEntity());
						return str;
					} catch (ClientProtocolException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
					return null;
				}
				@Override
				protected void onPostExecute(String result) {
					if(result != null){
						mTextView.setText(result);
					}
				};
				}.execute(httpPath);
			
			break;
		case R.id.httpclient_utils_apache_post_button:
			String url = "http://192.168.1.183:8080/app/login";
			String method = "GET";
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("user", "admin");
			map.put("psw", "123456");
			new HttpConnectUtils().requestHttpServer_GETMethod(url, map, new HTTPCallBack());
			break;
		default:
			break;
		}
	}

	public String requestServer(String urlPath) {
		try {
			// URL url = new URL(urlPath+"?admin&12222");
			URL url = new URL(urlPath);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// conn.setRequestMethod("GET");

			conn.setRequestMethod("POST");
			conn.connect();

			// 写入数据都行
			/*
			 * OutputStream os = conn.getOutputStream(); PrintWriter pw = new
			 * PrintWriter(os); pw.print("user=admin&psw=123456"); pw.flush();
			 */
			OutputStream os = conn.getOutputStream();
			BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
			String users = URLEncoder.encode("小敏", "UTF-8");
			bf.write("user=" + users + "&psw=123456");
			bf.flush();

			InputStream is = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));

			String line;
			StringBuilder builder = new StringBuilder();
			while ((line = br.readLine()) != null) {
				builder.append(line);
			}
			return builder.toString();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String readInputStream(InputStream is) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String line;
		StringBuilder builder = new StringBuilder();
		try {
			while ((line = br.readLine()) != null) {
				builder.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return builder.toString();
	}
}
