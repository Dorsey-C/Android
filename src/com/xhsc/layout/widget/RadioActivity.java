package com.xhsc.layout.widget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

import com.xhsc.layout.relativelayout.R;

public class RadioActivity extends Activity {
	private RadioGroup mSexRadioGroup;
	private RadioGroup mMySexRadioGroup;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.widget_radiobutton_layout);
		// 通过findViewById()获取控件实例
		mSexRadioGroup = (RadioGroup) findViewById(R.id.sex_radio_group);
		mMySexRadioGroup = (RadioGroup) findViewById(R.id.my_sex_radio_group);

		// toggle默认选中
		((RadioButton) mSexRadioGroup.getChildAt(0)).toggle();
		((RadioButton) mMySexRadioGroup.getChildAt(0)).toggle();

		// 状态改变监听
		mSexRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch (checkedId) {
				case R.id.man_radio:
					RadioButton manRadioBtn = (RadioButton) group.getChildAt(0);
					System.out.println("onCheckedChanged >>>>>>>>>> " + manRadioBtn.getText());
					Toast.makeText(RadioActivity.this, manRadioBtn.getText(), Toast.LENGTH_SHORT).show();
					break;
				case R.id.woman_radio:
					RadioButton womanRadioBtn = (RadioButton) findViewById(checkedId);
					System.out.println("onCheckedChanged >>>>>>>>>> " + womanRadioBtn.getText());
					Toast.makeText(RadioActivity.this, womanRadioBtn.getText(), Toast.LENGTH_SHORT).show();
				default:
					break;
				}
			}
		});

		mMySexRadioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch (checkedId) {
				case R.id.my_man_radio:
					RadioButton manRadioBtn = (RadioButton) group.getChildAt(0);
					System.out.println("onCheckedChanged >>>>>>>>>> " + manRadioBtn.getText());
					Toast.makeText(RadioActivity.this, manRadioBtn.getText(), Toast.LENGTH_SHORT).show();
					break;
				case R.id.my_woman_radio:
					RadioButton womanRadioBtn = (RadioButton) findViewById(checkedId);
					System.out.println("onCheckedChanged >>>>>>>>>> " + womanRadioBtn.getText());
					Toast.makeText(RadioActivity.this, womanRadioBtn.getText(), Toast.LENGTH_SHORT).show();
				default:
					break;
				}
			}
		});
	}
}
