package com.xhsc.webview;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import com.xhsc.webview.HttpConnectUtils.RequestMethod;

import android.test.AndroidTestCase;
import android.util.Log;

public class test extends AndroidTestCase {

	public void testCase(){
		String url = "http://192.168.1.183:8080/app/login";
		String method = "GET";
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("user", "admin");
		map.put("psw", "123456");
		
		String urls =(String) requestHTTPServer(url,method,map);
		url = url+"?"+"user=admin&psw=123456";
		if(url.equals(urls)){
			Log.v("tag", "相等"+true);
		}
		Log.v("tag", ""+urls);
		
	}
	private Object requestHTTPServer(String url,String method,HashMap<String, Object> params){
		HttpClient client = new DefaultHttpClient();
		StringBuilder builder = new StringBuilder();
		builder.append("?");
		if(method.equals(RequestMethod.GET)){
			for(String key:params.keySet()){
				
				String name = key;
				Object value = params.get(key);
				builder.append(name+"="+value);
				builder.append("&");
			}
			String parameter= builder.substring(0, (builder.toString().length()-1));
			String urls = url+parameter;
			return urls;
		}
		return null;
	}
}
