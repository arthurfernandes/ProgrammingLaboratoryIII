package com.example.alarmeapp;

import java.util.Calendar;
import java.util.Date;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AlarmService extends IntentService{

	public AlarmService() {
		super("");
		
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onHandleIntent(Intent arg0) {
		// TODO Auto-generated method stub
	 Log.i("****************************", "inside background service ");
	    AlarmManager service = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
	    Calendar cal = Calendar.getInstance();
	    Intent i = new Intent(this, AlarmReceiver.class);
	    PendingIntent pending = PendingIntent.getBroadcast(this, 0, i,
	    PendingIntent.FLAG_CANCEL_CURRENT);
	    Date data = cal.getTime();
	    data.setSeconds(data.getSeconds()+10);
	    //service.set(AlarmManager.RTC_WAKEUP, data.getTime(), pending);
	    //service.setInexactRepeating(AlarmManager.RTC_WAKEUP,data.getTime(), 1000*5, pending);
	    
	}
	

}
