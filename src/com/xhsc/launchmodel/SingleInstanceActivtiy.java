package com.xhsc.launchmodel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xhsc.layout.relativelayout.R;
/**
 * 
 * @author 单实例模式
 * 这种启动模式比较特殊，因为它会启用一个新的栈结构，将Acitvity放置于这个新的栈结构中，并保证不再有其他Activity实例进入。
 * 保证只有一个被压入栈里
 *
 */
public class SingleInstanceActivtiy extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.launchmodel_singleinstance);
		((TextView)findViewById(R.id.launmodel_singleinstance_txt)).setText("SingleInstanceActivtiy  current task id: "+">>>>>>>>"+this.getTaskId());
	}
	
	public void onStartStandardActivityClickLisenter(View v){
		startActivity(new Intent(this, StandardActivity.class));
	}
}
