package com.xhsc.store.provider;

import com.xhsc.store.db.DataColumns;
import com.xhsc.store.db.UserDBHelper;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * ContentProvider 内容提供者 四大组件之一
 * ContentReserver Uri :
 * content://xxxxxxxxxxxxx/path 
 * \scheme /\ Authority /\ path/
 */
public class UserContentProvider extends ContentProvider {

	private static final String AUTHORITY = "com.scxh.android1503.tearchprovider";

	private static final String USER_PATH = "user";//user表标识
	private static final String TEARCH_PATH = "tearch";//teacher表标识

	private static final int USER_CODE = 0;
	private static final int TEARCH_CODE = 1;
	
	public static final Uri CONTENT_URI_USER = Uri.parse("content://"+ AUTHORITY + "/"+USER_PATH);
	public static final Uri CONTENT_URI_TEARCH = Uri.parse("content://"+ AUTHORITY + "/"+TEARCH_PATH);

	private SQLiteDatabase db;
	//多表操作code码匹配类
	public static UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	static{
		uriMatcher.addURI(AUTHORITY, USER_PATH, USER_CODE);
		uriMatcher.addURI(AUTHORITY, TEARCH_PATH, TEARCH_CODE);
	}
	@Override
	public boolean onCreate() {
		UserDBHelper helper = new UserDBHelper(getContext());
		db = helper.getReadableDatabase();
		return false;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
		int code = uriMatcher.match(uri);
		switch (code) {
		case USER_CODE:
			return db.query(DataColumns.UserTable.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
		case TEARCH_CODE:
			return db.query(DataColumns.TearchTable.TABLE_NAME, projection,selection, selectionArgs, null, null, sortOrder);
		default:
			return null;
		}
		
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		return null;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		return 0;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		return 0;
	}

}
