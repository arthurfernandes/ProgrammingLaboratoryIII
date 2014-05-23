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
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author arthurfernandes
 */
public class AeroportoDAO {
    
    private File xmlFile;
    
    public AeroportoDAO(File xmlFile){
        this.xmlFile = xmlFile;
    }
    
    public List<Aeroporto> listarAeroportos(){
        
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
        
        NodeList aeroportos = documentXML.getElementsByTagName("aeroporto");
        
        ArrayList<Aeroporto> listaDeAeroportos = new ArrayList<>();
        
        for(int i = 0;i<aeroportos.getLength();i++){
            try{
                Element aeroportoElement = (Element) aeroportos.item(i);
                Integer id = Integer.parseInt(aeroportoElement.getElementsByTagName("id").item(0).getTextContent());
                String nome = aeroportoElement.getElementsByTagName("nome").item(0).getTextContent();
                String sigla = aeroportoElement.getElementsByTagName("sigla").item(0).getTextContent();
                Aeroporto aeroporto = new Aeroporto(id,sigla,nome);
                listaDeAeroportos.add(aeroporto);
            }
            catch(DOMException | NumberFormatException e){
                e.printStackTrace();
            }
        }
        
        return listaDeAeroportos;
    }
    
    public static void main(String args[]){
        AeroportoDAO dao = new AeroportoDAO(new File("aeroportos.xml"));
        List<Aeroporto> lista = dao.listarAeroportos();
        System.out.println(lista.get(1).getNome());
        System.out.println(lista.size());
    }
}
