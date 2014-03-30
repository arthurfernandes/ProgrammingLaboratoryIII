package br.eb.mil.ime.comp.lab3.smsreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReceiver extends BroadcastReceiver{
	//Objeto SmsManager
    final SmsManager sms = SmsManager.getDefault();
     
    public void onReceive(Context context, Intent intent) {
    	
        Bundle bundle = intent.getExtras();
 
        Intent smsIntent = new Intent("SMSReceived.intent.MAIN");
        
        if (bundle != null) {
                 
                final Object[] pdusObjects = (Object[]) bundle.get("pdus");
                 
                for (int i = 0; i < pdusObjects.length; i++) {
                     
                    SmsMessage incomingMessage = SmsMessage.createFromPdu((byte[]) pdusObjects[i]);
                    String phoneNumber = incomingMessage.getDisplayOriginatingAddress();
                   
                    String senderNum = phoneNumber;
                    String messageText = incomingMessage.getDisplayMessageBody();
                   
                    Toast toast = Toast.makeText(context, 
                            "Mensagem de:: "+ senderNum + "\nMenssagem: " + messageText, Toast.LENGTH_LONG);
                    toast.show();
       
                    smsIntent.putExtra("SENDERNUM", senderNum);
                    smsIntent.putExtra("TEXTMESSAGE", messageText);
                }
        }
    }    

}
