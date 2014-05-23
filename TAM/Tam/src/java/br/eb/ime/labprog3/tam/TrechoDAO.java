/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.eb.ime.labprog3.tam;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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
public class TrechoDAO {
    
    private File xmlFile;
    
    public TrechoDAO(File xmlFile){
        this.xmlFile = xmlFile;
    }
    
    public List<Trecho> listarTrechos(){
        
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        
        try{
            builder = builderFactory.newDocumentBuilder();
        }
        catch(ParserConfigurationException e){
            return null;
        }
        
        Document documentXML = null;
        
        try{
            documentXML = builder.parse(xmlFile);
        }
        catch(SAXException e){
            return null;
        }
        catch(IOException e){
            return null;
        }
        
        NodeList trechos = documentXML.getElementsByTagName("trecho");
        ArrayList<Trecho> listaDeTrechos = new ArrayList<>();
        
        for(int i = 0;i<trechos.getLength();i++){
            try{
                Element trechoElement = (Element) trechos.item(i);
                
                int idTrecho = Integer.parseInt(trechoElement.getElementsByTagName("id").item(0).getTextContent());
                
                Element origem = (Element) trechoElement.getElementsByTagName("origem").item(0);
                int idOrigem = Integer.parseInt(origem.getAttribute("id"));
                Element destino = (Element) trechoElement.getElementsByTagName("destino").item(0);
                int idDestino = Integer.parseInt(destino.getAttribute("id"));
                String duracao = trechoElement.getElementsByTagName("duracao").item(0).getTextContent();
                
                String precoString = trechoElement.getElementsByTagName("preco").item(0).getTextContent();
                
                try{
                   Integer precoComPonto = Integer.parseInt(precoString.substring(precoString.indexOf(".")+1));
                   if(precoComPonto>0){
                       precoString = precoString.replace(".", "");
                   }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                
                Float preco = Float.parseFloat(precoString);
                
                String numeroVoo = trechoElement.getElementsByTagName("numeroVoo").item(0).getTextContent();
                
                Trecho trecho = new Trecho(idTrecho,idOrigem,idDestino,duracao,preco,numeroVoo);
                listaDeTrechos.add(trecho);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        
        return listaDeTrechos;
    }
    
    public static void main(String args[]){
        TrechoDAO dao = new TrechoDAO(new File("rotas.xml"));
        List<Trecho> list = dao.listarTrechos();
        System.out.println(list.size());
        System.out.println(list.get(1).getIdAeroportoDestino() + " <- " + list.get(1).getIdAeroportoOrigem());
        
        
        
    }
}
