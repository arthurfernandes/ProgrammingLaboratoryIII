package com.example.calculator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button buttonInit = (Button) this.findViewById(R.id.buttonGo);
		buttonInit.setOnClickListener( new OnClickListener(){
	        
            public void onClick(View arg0){
                
                Intent iniciador = new Intent(MainActivity.this,CalculatorActivity.class);
                
                startActivity(iniciador);
                //fraseTexto.setText("NovoTexto");
            }
        });
        
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
