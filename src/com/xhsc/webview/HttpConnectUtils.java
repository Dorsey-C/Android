package com.xhsc.webview;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import com.xhsc.webview.HttpConnectUtils.RequestMethod;

import android.os.AsyncTask;
import android.support.v4.os.AsyncTaskCompat;

public class HttpConnectUtils {
	public interface RequestMethod {
		public static final String GET = "GET";
		public static final String POST = "POST";

	}

	HTTPCallBack httpCallBack;
	public interface HTTPCallBack {
		public void returnMessage(String message);
	}

/**
 * GET请求网络服务器方法
 * @param url 服务器网络地址String型
 * @param params 需要传的参数HashMap<String, Object>型
 * @param httpCallBack实例化这个接口
 */
	public void requestHttpServer_GETMethod(String url,HashMap<String, Object> params,
			final HTTPCallBack httpCallBacks) {

		StringBuilder builder = new StringBuilder();
		builder.append("?");
		String urls = "";
		
			if (params.size() != 0 && params != null) {
				for (String key : params.keySet()) {

					String name = key;
					Object value = params.get(key);
					builder.append(name + "=" + value);
					builder.append("&");
				}
				String parameter = builder.substring(0, (builder.toString().length() - 1));
				urls = url + parameter;
			}

			asyncTaskGetMethod(httpCallBacks,urls);
		

	}

	private void asyncTaskGetMethod(final HTTPCallBack httpCallBacks,String urls){
		AsyncTask<String, Void, String> asyncTask = new AsyncTask<String, Void, String>() {

			@Override
			protected String doInBackground(String... params) {
				HttpClient client = new DefaultHttpClient();
				HttpGet request = new HttpGet(params[0]);
				try {
					HttpResponse response = client.execute(request);
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
				if (result != null) {
					httpCallBacks.returnMessage(result);
				}

			};
		};
		asyncTask.execute(urls);
	}
}
