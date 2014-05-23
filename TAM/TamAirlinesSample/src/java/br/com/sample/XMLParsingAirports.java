/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.sample;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 *
 * @author arthurfernandes
 */
public class XMLParsingAirports {
    public static void main(String args[]) throws MalformedURLException, IOException{
        File arquivo = new File("tamroutes.html");
        FileReader fr = new FileReader( arquivo );
        BufferedReader br = new BufferedReader( fr );
        String inputLine;
        StringBuilder response = new StringBuilder();
        
        while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
                
        }
        br.close();
        fr.close();
        
        
        
        Document dom = Jsoup.parse(response.toString());
        Elements aeroportos = dom.getElementsByClass("BrasilList");
        System.out.println(aeroportos.get(0).attr("data-code"));
        System.out.println(aeroportos.get(0).text());
        System.out.println(aeroportos.size());
        File arquivoOutput = new File("aeroportos.xml");
        FileWriter fw = new FileWriter(arquivoOutput);
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write("<?xml version=1.0 ?>"+"\n");
        bw.write("<trechos>"+"\n");
        int k = 1;
        for(int i = 0;i<aeroportos.size();i++){
            if(aeroportos.get(i).attr("data-code").equals("RIO"))
                continue;
            if(aeroportos.get(i).attr("data-code").equals("SAO"))
                continue;
            if(aeroportos.get(i).attr("data-code").equals("BHZ"))
                continue;
            
            
            
            bw.write("\t<aeroporto>"+"\n");
            bw.write(("\t\t<id>"+(k)+"</id>\n"));
            bw.write("\t\t<nome>"+(aeroportos.get(i).text())+"</nome>\n");
            bw.write("\t\t<sigla>"+(aeroportos.get(i).attr("data-code"))+"</sigla>\n");
            bw.write("\t</aeroporto>\n");
            k++;
        }
        bw.write("</trechos>\n");
        bw.close();
        fw.close();
    }
}
