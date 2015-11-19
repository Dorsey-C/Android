package com.xhsc.store.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.AvoidXfermode.Mode;

public class SharedPreferencesOpenHelper {

	private SharedPreferences mSharePreferences;
	private static SharedPreferencesOpenHelper sHelper;
	private static final String NAME_PREFERENCE = "com.xhsc.store.SHARE_MESSAGE";
	private static final String ID = "id";
	private static final String NAME = "name";
	private static final String AGE = "age";
	private static final String SCORE = "score";

	//单实例模式，却应用中有且只有一个实例
	private SharedPreferencesOpenHelper(Context context) {
		mSharePreferences = context.getSharedPreferences(NAME_PREFERENCE, context.MODE_PRIVATE);
	}

	public static SharedPreferencesOpenHelper getInstance(Context context) {
		if (sHelper == null) {
			sHelper = new SharedPreferencesOpenHelper(context);
		}
		return sHelper;
	}
	
	/**
	 * 添加学生对象
	 * 
	 * @param student
	 */
	
	public void addStudent(Student student){
		Editor editor = mSharePreferences.edit();
		editor.putInt(ID,student.getId());
		editor.putString(NAME, student.getName());
		editor.putInt(AGE, student.getAge());
		editor.putString(SCORE, student.getScore());
		editor.commit();
	}
	
	/**
	 * if 返回 null表示 查找的学生不存在.
	 * 
	 * @param name
	 * @return
	 */
	public Student findStudentByName(String name){
		String studentName = mSharePreferences.getString(NAME, "");
		if(studentName.equals(name)){
			int id = mSharePreferences.getInt(ID, 0);
			int age = mSharePreferences.getInt(AGE, 0);
			String score = mSharePreferences.getString(SCORE, "0");
			Student student = new Student();
			student.setAge(age);
			student.setId(id);
			student.setScore(score);
			student.setName(studentName);
			
			return student;
		} else {
			return null;
		}
		
		
		}
	/**
	 * 清空所有信息
	 */
	public void clearAll() {
		mSharePreferences.edit().clear().commit();
	}
}
