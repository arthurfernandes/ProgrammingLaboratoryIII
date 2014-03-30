package br.eb.mil.ime.comp.lab3.smsreceiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;

public class MainActivity extends Activity {
	private BroadcastReceiver customSmsBroadcastReceiver;
	private IntentFilter smsIntentFilter;
	private EditText editSenderNum;
	private EditText editTextMessage;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editSenderNum = (EditText) this.findViewById(R.id.senderNum);
		editTextMessage = (EditText) this.findViewById(R.id.messageBody);
		
	}

	protected void onResume(){
		super.onResume();
		//Esse intente sera passado para que a activity atualize os valores nos EditTexts
		smsIntentFilter = new IntentFilter("SMSReceived.intent.MAIN");
		//smsIntentFilter.addCategory("SMSReceived.intent.MAIN");
		customSmsBroadcastReceiver = new BroadcastReceiver(){
			@Override
			public void onReceive(Context context, Intent intent) {
				String senderNum = intent.getExtras().getString("SENDERNUM");
				String messageText = intent.getExtras().getString("TEXTMESSAGE");
				
				editSenderNum.setText(senderNum);
				editTextMessage.setText(messageText);
				
			}
		};
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
