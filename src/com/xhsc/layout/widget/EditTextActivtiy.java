package com.xhsc.layout.widget;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

import com.xhsc.layout.relativelayout.R;
public class EditTextActivtiy extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edittext_widget);
		EditText eText = (EditText)findViewById(R.id.edittext_count);
	}
}
