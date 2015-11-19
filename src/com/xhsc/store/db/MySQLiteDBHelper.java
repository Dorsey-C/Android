package com.xhsc.store.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteDBHelper extends SQLiteOpenHelper {

	private static final String DB_NAME = "mydatabase.db";
	private static final int DB_VERSION = 2;
	public MySQLiteDBHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	
	/**
	 * 初始化创建数据库表
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.v("tag","oncreate >>>>>>>>>>>");
		String sql = "create table "+DataColumns.UserTable.TABLE_NAME+"(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,username varchar(50),password varchar(10)";
	
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		Log.v("tag", "onUpgrade>>>>>>>>");
		String sql = "alter table"+DataColumns.UserTable.TABLE_NAME+"add column number varchar(5)";
		db.execSQL(sql);
	
	}

}
