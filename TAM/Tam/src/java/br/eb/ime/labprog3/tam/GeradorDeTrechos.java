/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.eb.ime.labprog3.tam;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author arthurfernandes
 */
public class GeradorDeTrechos {
    //Formato da data Ano/Mes/Dia
    public boolean geraTrechos(String data) throws IOException{
        
        File aeroportosFile = new File("aeroportos.xml");
        File trechosFile = new File("trechos.xml");
        
        FileWriter fw = null;
        
        try{
            fw = new FileWriter(trechosFile);
        }
        catch(Exception e){
            return false;
        }
        BufferedWriter bw = new BufferedWriter(fw);
        
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        
        try{
            builder = builderFactory.newDocumentBuilder();
        }
        catch(ParserConfigurationException e){
            return false;
        }
        
        Document documentXML = null;
        
        try{
            documentXML = builder.parse(aeroportosFile);
        }
        catch(SAXException e){
            return false;
        }
        catch(IOException e){
            return false;
        }
        
        
        
        NodeList aeroportos = documentXML.getElementsByTagName("aeroporto");
        
        int idTrecho = 1;
        bw.write("<?xml version=\"1.0\"?>\n");
        bw.write("<trechos data=\""+data+"\">\n");
        
        for(int i = 11;i<12;i++){
            System.out.println("Indice i:"+i);
            for(int j = 0;j<aeroportos.getLength();j++){
                System.out.println("Indice j:"+j);
                if(i!=j){
                    
                    Element aeroportoOrigem = (Element) aeroportos.item(i);
                    Element aeroportoDestino = (Element) aeroportos.item(j);
                    String siglaOrigem = aeroportoOrigem.getElementsByTagName("sigla").item(0).getTextContent();
                    String siglaDestino = aeroportoDestino.getElementsByTagName("sigla").item(0).getTextContent();
                    String idOrigem = aeroportoOrigem.getElementsByTagName("id").item(0).getTextContent();
                    String idDestino = aeroportoDestino.getElementsByTagName("id").item(0).getTextContent();
                    SendPostTamTrechos postRequest = new SendPostTamTrechos(siglaOrigem,siglaDestino,data);
                    XMLParsingTamTrechos trecho = XMLParsingTamTrechos.createTrecho(postRequest.getStreamPagina());
                    
                    if(trecho!=null){
                        try{
                            bw.write("\t<trecho>\n");
                            bw.write("\t\t<id>"+idTrecho+"</id>\n");
                            bw.write("\t\t<origem id=\""+idOrigem+"\">"+siglaOrigem+"</origem>\n");
                            bw.write("\t\t<destino id=\""+idDestino+"\">"+siglaDestino+"</destino>\n");
                            bw.write("\t\t<preco>"+trecho.getPreco().toString()+"</preco>\n");
                            bw.write("\t\t<duracao>"+trecho.getDuracao()+"</duracao>\n");
                            bw.write("\t\t<numeroVoo>"+trecho.getNumeroVoo()+"</numeroVoo>\n");
                            bw.write("\t</trecho>\n");
                            System.out.println(idTrecho);
                        }
                        catch(Exception e){
                            System.out.println("ErroNaRota: "+siglaOrigem+" - "+siglaDestino);
                        }
                        finally{
                            idTrecho++;
                        }
                    }
                        
                }
            }
            
            }
            bw.write("</trechos>\n");
        
        
        
        try {
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(GeradorDeTrechos.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            fw.close();
        } catch (IOException ex) {
            Logger.getLogger(GeradorDeTrechos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
        
        
    }
    
    public GeradorDeTrechos(){
        
    }
    
    public static void main(String args[]) throws IOException{
        GeradorDeTrechos geraTrechos = new GeradorDeTrechos();
        System.out.println(geraTrechos.geraTrechos("20140530"));
    }
}
