package br.eb.ime.labprog3.tamapp;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Gravity;
import android.view.Menu;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Rotas extends Activity {
	private Context context;
	private String labelsTitulo[] = {"Origem","Destino","Preço","Duração","Vôo"};
	private List<Trecho> listaDeTrechosDestino;
	private List<Aeroporto> listaDeAeroportos;
	private TableLayout tableDeTrechos; 
	private TextView tv;
	private ProgressDialog pd;
	private int increment =0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rotas);
		context = this;
		this.gerarListaDeDestinos();
		tableDeTrechos = (TableLayout) this.findViewById(R.id.TableLayoutRotas);

        pd = new ProgressDialog(context);
        pd.setMessage("Calculando Rotas");
        pd.setTitle("Working....");
        pd.setIndeterminate(true);
        pd.setMax(labelsTitulo.length);
        pd.show();
		
		ThreadRender threadRender = new ThreadRender();
		threadRender.start();
	}
	
	private void gerarListaDeDestinos(){

		Integer origem = this.getIntent().getExtras().getInt("ORIGEM")+1;
		Integer destino = this.getIntent().getExtras().getInt("DESTINO")+1;
		
		XmlResourceParser aeroportoXML = this.getResources().getXml(R.xml.aeroportos);
		XmlResourceParser trechoXML = this.getResources().getXml(R.xml.rotas);
		
		AeroportoDAO daoAeroporto = new AeroportoDAO(aeroportoXML);
		TrechoDAO daoTrecho = new TrechoDAO(trechoXML);
		
		listaDeAeroportos = null;
		List<Trecho> listaDeTrechos = null;
		
		try{
			listaDeAeroportos = daoAeroporto.listarAeroportos();
			listaDeTrechos = daoTrecho.listarTrechos();
		}
		catch(Exception e){
			return;
		}
		
		if(listaDeAeroportos == null && listaDeTrechos == null)
			return;
		
        GeradorGrafoDijkstra geradorDeGrafo = new GeradorGrafoDijkstra(listaDeAeroportos,listaDeTrechos);
        
        List<Aeroporto> listaDeAeroportosDestino = geradorDeGrafo.geraMenorCaminho(origem, destino);
        
        
        listaDeTrechosDestino = new ArrayList<Trecho>();
        
        for(int i = 0;i<listaDeAeroportosDestino.size()-1;i++){
            Aeroporto aeroportoOrigem = listaDeAeroportosDestino.get(i);
            for(int j = 0;j<listaDeTrechos.size();j++){
               Trecho trecho = listaDeTrechos.get(j);

               if(trecho.getIdAeroportoOrigem()==aeroportoOrigem.getId()){
                   Aeroporto aeroportoDestino = listaDeAeroportosDestino.get(i+1);
                   trecho.setAeroportoOrigemNome(aeroportoOrigem.getNome());
                   if(trecho.getIdAeroportoDestino()==aeroportoDestino.getId()){
                       trecho.setAeroportoDestinoNome(aeroportoDestino.getNome());
                       listaDeTrechosDestino.add(trecho);
                   }
               }
            }
        }
	}
	
	private class ThreadRender extends Thread{
		public void run(){
			Looper.prepare();
			TextView label = null;
			TableRow row = null;
			
			for(int i = 0;i<(listaDeTrechosDestino.size()+1);i++){
				row = new TableRow(context);
				
				if(i==0){
				
					for (int j = 0; j < labelsTitulo.length; j++) {
		                label = new TextView(context);
		                label.setText(labelsTitulo[j]);
		                label.setLayoutParams(new TableRow.LayoutParams(
		                        LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		                label.setGravity(Gravity.CENTER_VERTICAL);
		                label.setPadding(5, 5, 5, 5);
		                row.addView(label);
					}
					
				}
				else{
					
					Trecho trecho = listaDeTrechosDestino.get(i-1);
					List<String> labelsTrechos = new ArrayList<String>();
					
					labelsTrechos.add(trecho.getAeroportoOrigemNome());
					labelsTrechos.add(trecho.getAeroportoDestinoNome());
					labelsTrechos.add(String.valueOf(trecho.getPreco()));
					labelsTrechos.add(trecho.getDuracao());
					labelsTrechos.add(trecho.getNumeroVoo());
					
					for (int j = 0; j < labelsTitulo.length; j++) {
		                label = new TextView(context);
		                label.setText(labelsTrechos.get(j));
		                label.setLayoutParams(new TableRow.LayoutParams(
		                        LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		                label.setGravity(Gravity.CENTER_VERTICAL);
		                label.setPadding(5, 5, 5, 5);
		                row.addView(label);
					}
					
				}
				
				tableDeTrechos.addView(row,LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
				increment++;
				handler.sendEmptyMessage(101);
		}
			handler.sendEmptyMessage(102);
		
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rotas, menu);
		return true;
	}
	
	private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
            case 102:
                pd.dismiss();
                break;
            case 101:
                pd.setProgress(increment);
                break;
            }
        }
    };


}
