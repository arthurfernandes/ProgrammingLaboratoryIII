package com.example.alarmeapp;

import java.util.Calendar;
import java.util.Date;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver{

	@Override
	public void onReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		 
		 Calendar cal = Calendar.getInstance();
		 Date data = cal.getTime();
		 
		 Log.i("****************************", "inside timer triggered :hour:"+data.getHours()+"min:"+data.getMinutes()+"sec"+data.getSeconds());
	}

}
