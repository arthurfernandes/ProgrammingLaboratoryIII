package br.eb.ime.labprog3.tamapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParserException;

import android.app.Activity;
import android.content.Intent;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity {
	
	Button buscarRota;
	Spinner aeroportoOrigem;
	Spinner aeroportoDestino;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		buscarRota = (Button) this.findViewById(R.id.buscarRota);
		
		aeroportoOrigem = (Spinner) this.findViewById(R.id.aeroportosOrigem);
		aeroportoDestino = (Spinner) this.findViewById(R.id.aeroportosDestino);
		
		List<Aeroporto> aeroportos = new ArrayList<Aeroporto>();
		
		List<String> nomeAeroportos = new ArrayList<String>();
		
			
		XmlResourceParser xpp = this.getResources().getXml(R.xml.aeroportos);
		
		AeroportoDAO dao = new AeroportoDAO(xpp);
		try {
			//aeroportos = dao.listarAeroportos();
			aeroportos = dao.listarAeroportos();
			
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(aeroportos!=null){
			for(int i = 0;i<aeroportos.size();i++){
				nomeAeroportos.add(String.valueOf(aeroportos.get(i).getNome()));
			}
		}
		
		ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, nomeAeroportos);
		dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		aeroportoDestino.setAdapter(dataAdapter);
		aeroportoOrigem.setAdapter(dataAdapter);
		
		buscarRota.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent intent = new Intent(MainActivity.this,Rotas.class);
				intent.putExtra("ORIGEM", aeroportoOrigem.getSelectedItemPosition());
				intent.putExtra("DESTINO", aeroportoDestino.getSelectedItemPosition());
				
				startActivity(intent);
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
