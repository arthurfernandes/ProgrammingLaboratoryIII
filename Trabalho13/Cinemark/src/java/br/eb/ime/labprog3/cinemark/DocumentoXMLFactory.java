/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.eb.ime.labprog3.cinemark;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;


/**
 *
 * @author arthurfernandes
 */
public class DocumentoXMLFactory {
    
    private InputStream arquivoXML = null;
    
    private DocumentoXMLFactory(URL url) throws IOException{
        
        this.arquivoXML = url.openStream();
        
    }
    
    public static DocumentoXMLFactory newInstance(URL url){
        DocumentoXMLFactory documentoXMLFactory = null;
        try{
            documentoXMLFactory = new DocumentoXMLFactory(url);
        }
        catch(IOException e){
        }
        finally{
            return documentoXMLFactory;
        }    
    }
    
    public DocumentoXML geraDocumentoXML(){
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        DocumentoXML documentoXML = null;
        
        try{
            builder = builderFactory.newDocumentBuilder();
        }
        catch(ParserConfigurationException e){
            return documentoXML;
        }
        
        Document documentXML = null;
        
        try{
            documentXML = builder.parse(arquivoXML);
        }
        catch(SAXException e){
            return null;
        }
        catch(IOException e){
            return null;
        }
        
        documentoXML = new DocumentoXML(documentXML);
        
        return documentoXML;
    }
    
   
}
