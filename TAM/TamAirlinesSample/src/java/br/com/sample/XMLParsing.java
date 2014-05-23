/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sample;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



/**
 *
 * @author arthurfernandes
 */
public class XMLParsing {
    public static void main(String args[]) throws MalformedURLException, IOException{
        
        String path = "http://book.tam.com.br/TAM/dyn/air/booking/upslDispatcher";
        URL url = new URL(path);
        
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        
        con.setRequestMethod("POST");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        con.setRequestProperty("Accept-Language","en-US,en;q=0.8,pt;q=0.6");
        
        
        String urlParameters = "SITE=JJBKJJBK&LANGUAGE=BR&WDS_MARKET=BR&B_DATE_1=201405240000&B_LOCATION_1=SDU&E_LOCATION_1=BSB&TRIP_TYPE=O&adults=1&COMMERCIAL_FARE_FAMILY_1=NEWBUNDLE";
 
        // Send post request
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();
        
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
 /*
        File arquivo = new File("voo.xml");
        if(!arquivo.exists())
            arquivo.createNewFile();
        //construtor que recebe o objeto do tipo arquivo
        FileWriter fw = new FileWriter( arquivo );
        BufferedWriter bw = new BufferedWriter( fw );
        
        
        while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
                bw.write(inputLine);
        }
        bw.close();
        fw.close();
        in.close();
        
        */
        Document dom = Jsoup.parse(con.getInputStream(),null,"");
        Element tabelaDeVoos = dom.getElementById("outbound_list_flight_direct");
        Elements voos = tabelaDeVoos.getElementsByClass("flight");
        Elements aeroporto1 = voos.get(0).getElementsByClass("bLocation");
        Elements preco = voos.get(0).getElementsByClass("price");
        Elements numeroVoo = voos.get(0).getElementsByAttribute("data-flight-number");
        Elements duracao = voos.get(0).getElementsByClass("durationTh");
        System.out.println(preco.get(0).text());
        System.out.println(preco.get(1).text());

        System.out.println(preco.get(2).text());

        System.out.println(aeroporto1.get(0).text());
        System.out.println(numeroVoo.get(0).text());
        System.out.println(duracao.get(0).text());
        System.out.println("Tamanho:" + voos.size());
        
        
        //Document dom = Jsoup.parse("");
        //String str = dom.getElementsByClass("padding-s").get(0).toString();
        
        //System.out.println(dom.toString());
        
    }
}
