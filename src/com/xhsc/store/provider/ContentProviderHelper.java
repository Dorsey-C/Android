package com.xhsc.store.provider;

import com.xhsc.store.db.DataColumns;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;

/**
 * ContentProvider 内容提供者 四大组件之一 ContentReserver Uri :
 * content://xxxxxxxxxxxxx/path \scheme /\ Authority /\ path/
 */
public class ContentProviderHelper extends ContentProvider {
	/**
	 * Uri 作为唯一标识，在加载应用时会在manifest文件注册的provider中去查找对应标识下的provider类完成初始化，所以需要注册，才能找到对应的provider
	 */
	private static final String AUTHORITY = "com.xhsc.store.provider";
	public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);
	private SQLiteDatabase db;

	

	/**
	 * 初始化创建数据库对象
	 */
	@Override
	public boolean onCreate() {
		DBSQLiteOperHelper helper = new DBSQLiteOperHelper(getContext());
		db = helper.getReadableDatabase();
		return false;
	}

	/**
	 * 查询数据内容
	 */
	@Override
	public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {

		return db.query(DataColumns.UserTable.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	/**
	 * 插入数据库
	 */
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		long id = db.insert(DataColumns.UserTable.TABLE_NAME, null, values);
		return Uri.withAppendedPath(CONTENT_URI,String.valueOf(id));
	}

	/**
	 * 删除数据库
	 */
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		int id = db.delete(DataColumns.UserTable.TABLE_NAME, selection, selectionArgs);
		return 0;
	}

	/**
	 * 更新数据库
	 */
	@Override
	public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
		int id = db.update(DataColumns.UserTable.TABLE_NAME, values, selection, selectionArgs);
		return 0;
	}
	
	
	
	//*********************************************
	public class DBSQLiteOperHelper extends SQLiteOpenHelper {
		private final static String DB_NAME = "scxh_user.db";
		private final static int DB_VERSION = 1;
		private static final String PRIMARY_KEY = "INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT";

		public DBSQLiteOperHelper(Context context) {
			super(context, DB_NAME, null, DB_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {

			String sql = "create table " + DataColumns.UserTable.TABLE_NAME + " (" 
					+ DataColumns.UserTable._ID + " int," 
					+ DataColumns.UserTable.COLUMN_NAME_NAME + " varchar(50) ,"
					+ DataColumns.UserTable.COLUMN_NAME_PASSWORD + " varchar(10))";
			db.execSQL(sql);
			Log.v("tag", ""+sql);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		}
	}

}
