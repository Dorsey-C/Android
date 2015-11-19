package com.xhsc.store.sharedpreference;

import android.test.AndroidTestCase;
import android.util.Log;
/**
 * 
 * @author 单元测试步凑
 * 1、继承AndroidTestCase类
 * 2、setUp中初始化参数
 * 3、要测试的方法前面加test
 * 4、在Manifest文件中添加<instrumentation android:targetPackage="com.xhsc.layout.relativelayout" android:name="android.test.InstrumentationTestRunner"></instrumentation>

 *5、在Manifest文件application下面添加<uses-library android:name="android.test.runner"/>
 */
public class SharePreferenceAndroidCase extends AndroidTestCase {

	private SharedPreferencesOpenHelper mSharePrefrenceOpenHelper;
	
	/**
	 * setUp()初始化参数
	 */
	@Override
	protected void setUp() throws Exception {
	
		super.setUp();
		mSharePrefrenceOpenHelper = SharedPreferencesOpenHelper.getInstance(getContext());
	}
	
	@Override
	protected void tearDown() throws Exception {
		
		super.tearDown();
	}
	
	public void testAddStudent(){
		Student student = new Student();
		student.setAge(18);
		student.setId(10);
		student.setName("张三");
		student.setScore("61");
		Log.v("tag", "student--->"+student+"____"+"mSharePrefrenceOpenHelper----->"+mSharePrefrenceOpenHelper);
		mSharePrefrenceOpenHelper.addStudent(student);
	}
	
	public void testFindStudent(){
		Student student = mSharePrefrenceOpenHelper.findStudentByName("张三");
		if(student != null){
			Log.v("tag","<<<<<<<<<<  学生信息 >>>>>>>>> ");
			Log.d("tag","ID  姓名     年龄     成绩   ");
			Log.d("tag",student.getId() + "   " + student.getName() + "     "
					+ student.getAge() + "     " + student.getScore());
		}else{
			Log.v("tag","查找学生不存在!");
		}
	}
}
