package com.example.appparimpar;

import java.util.Random;

import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity implements OnClickListener{

	private EditText editInput;
	private Button playButton;
	private Button consultButton;
	private EditText editMessages;
	private EditText editPlayerName;
	private String typeOfConsult = "play";
	private String ServletResponse = "";
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editInput = (EditText) this.findViewById(R.id.editInput);
		playButton = (Button) this.findViewById(R.id.buttonPlay);
		consultButton = (Button) this.findViewById(R.id.buttonConsult);
		editMessages = (EditText) this.findViewById(R.id.editMessages);
		editPlayerName = (EditText) this.findViewById(R.id.editPlayerName);
		
		Random randomInteger = new Random();
		String randomPlayer = "CustomPlayer"+randomInteger.nextInt(100);
		
		editPlayerName.setText(randomPlayer);
		
		playButton.setOnClickListener(this);
		
		consultButton.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		switch(arg0.getId()){
		case R.id.buttonConsult:
			typeOfConsult = "consult";
		case R.id.buttonPlay:
			
			// TODO Auto-generated method stub
			new Thread(new Runnable(){
				public void run(){
					// TODO Auto-generated method stub
					Integer value = 0;
					try{
						value = Integer.parseInt(editInput.getText().toString());
						
					}
					catch(Exception e){
						Log.d("Exception",e.getMessage());
						return;
					}
					
					String URL = "http://10.0.2.2:8084/WebApp/ServletParImpar?jogador="+editPlayerName.getText().toString();
					URL = URL+"&value="+value;
					URL = URL+ "&type="+typeOfConsult;
					HttpClient client = new DefaultHttpClient();
					HttpGet httpget = new HttpGet(URL);
					ResponseHandler<String> responseHandler = new BasicResponseHandler();
					ServletResponse = "";
					try {
						ServletResponse = client.execute(httpget,responseHandler);
					}
					catch(Exception e){
						Log.d("Exception",e.getMessage());
						return;
					}
					
					runOnUiThread(new Runnable() {
                        public void run() {

                        	editMessages.setText(ServletResponse);

                       }
                   });
					
					
				}
			}).start();
					
			break;
			}
		}
		
	}
