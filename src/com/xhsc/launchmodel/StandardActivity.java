package com.xhsc.launchmodel;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xhsc.layout.relativelayout.R;
/**
 * 
 * @author scxh
 *standard模式是默认的启动模式，不用为<activity>配置android:launchMode属性即可，当然也可以指定值为standard。
 */
public class StandardActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.launchmodel_standard);
		((TextView)findViewById(R.id.launmodel_standard_txt)).setText("StandardActivity  current task id: "+">>>>>>>>"+this.getTaskId());
		
	}
	
	public void onStartSingleInstanceActivityClickLisenter(View v){
		startActivity(new Intent(this, SingleInstanceActivtiy.class));
	}
}
