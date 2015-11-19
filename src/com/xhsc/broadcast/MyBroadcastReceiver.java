package com.xhsc.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

	public static final String ACTION_SMS_RECEIVER = "com.xhsc.broadcast.ACTION_SMS_RECEIVER";
	public static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";

	@Override
	public void onReceive(Context context, Intent intent) {

		String action = intent.getAction();
		if (action.equals(ACTION_SMS_RECEIVER)) {
			Toast.makeText(context, "接收到广播消息", Toast.LENGTH_SHORT).show();
		} else if (action.equals(SMS_RECEIVED)) {
			Toast.makeText(context, "接收短消息静态广播", Toast.LENGTH_SHORT).show();

			Log.v("tag", "接收短消息静态广播 >>>>>>>>>>>>>>>> ");

		}
	}

}
