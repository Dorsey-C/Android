package com.xhsc.store.provider;

import org.apache.http.impl.conn.LoggingSessionInputBuffer;

import com.xhsc.store.db.DataColumns;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.test.AndroidTestCase;
import android.util.Log;

public class ContactProviderAndroidCase extends AndroidTestCase {

	ContentResolver contentResolver;
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		contentResolver = getContext().getContentResolver();
	}
	
	public void testFindContact(){
//		String uriString = "content://com.android.contacts/contacts";
//		Uri uri = Uri.parse(uriString)最好封装在工具类中
		
		Uri uri = ContactsContract.Contacts.CONTENT_URI;
		
		Cursor c = contentResolver.query(uri, null, null, null, null);
		if(c != null && c.getCount()>0){
			Log.v("tag", "显示名");
			while(c.moveToNext()){
				String displayName = c.getString(c.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
			
				
				Log.v("tag", displayName);
			}
		}
	}
	
	public void testInsertUser(){
		addUser("李四","abcd");
		findUser();
	}
	
	public void addUser(String name,String password){
		ContentValues values = new ContentValues();
		values.put(DataColumns.UserTable.COLUMN_NAME_NAME, name);
		values.put(DataColumns.UserTable.COLUMN_NAME_PASSWORD, password);
		
		Uri uri = contentResolver.insert(ContentProviderHelper.CONTENT_URI, values);
		Log.v("tag", "uri:"+uri.toString());
	}
	
	public void findUser(){
		Cursor c = contentResolver.query(ContentProviderHelper.CONTENT_URI, null, null, null, null);
		if(c != null&&c.getCount()>0){
			Log.v("tag", "姓名        密码");
			while (c.moveToNext()) {
				String displayName = c.getString(c.getColumnIndex(DataColumns.UserTable.COLUMN_NAME_NAME));
				String passWord = c.getString(c.getColumnIndex(DataColumns.UserTable.COLUMN_NAME_PASSWORD));
				Log.v("tag", displayName+"       "+passWord);
				
			}
		}
	}
}
