/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.eb.ime.labprog3.tam;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author arthurfernandes
 */
public class SendPostTamTrechos {
    
    private InputStream streamPagina = null; 
    //Formato da Data Ano/Mes/Dia
    
    public InputStream getStreamPagina(){
        return streamPagina;
    }
    
    public SendPostTamTrechos(String aeroportoOrigem,String aeroportoDestino,String data){
        try{
            String path = "http://book.tam.com.br/TAM/dyn/air/booking/upslDispatcher";
            URL url = new URL(path);

            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            con.setRequestProperty("Accept-Language","en-US,en;q=0.8,pt;q=0.6");

            String urlParameters = "SITE=JJBKJJBK&LANGUAGE=BR&WDS_MARKET=BR&B_DATE_1="+data+"0000&B_LOCATION_1="+aeroportoOrigem+"&E_LOCATION_1="+aeroportoDestino+"&TRIP_TYPE=O&adults=1&COMMERCIAL_FARE_FAMILY_1=NEWBUNDLE";

            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();
            streamPagina = con.getInputStream();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
}
