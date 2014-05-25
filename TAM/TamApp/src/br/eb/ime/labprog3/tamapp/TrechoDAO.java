/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.eb.ime.labprog3.tamapp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.res.XmlResourceParser;
import android.util.Log;

/**
 *
 * @author arthurfernandes
 */
public class TrechoDAO {
    
    private XmlResourceParser xmlFile;
    
    public TrechoDAO(XmlResourceParser xmlFile){
        this.xmlFile = xmlFile;
    }
    
    public List<Trecho> listarTrechos() throws XmlPullParserException, IOException{
		List<Trecho> listaDeTrechos = new ArrayList<Trecho>();
		Trecho trecho = null;
	    Integer id = 0;
	    Integer idOrigem = 0;
	    Integer idDestino = 0;
	    Float preco = Float.MAX_VALUE;
	    String duracao = "";
	    String numeroVoo = "";
	    xmlFile.next();
	    int eventType = xmlFile.getEventType();
	   
	    while (eventType != XmlPullParser.END_DOCUMENT)
	   {
		   
	    if(eventType == XmlPullParser.START_DOCUMENT)
	    {
	    	
	    }
	    else if(eventType == XmlPullParser.START_TAG)
	    {
	    	String name = xmlFile.getName();
	    	
	    	if(name!=null){
	    		
		    	if(name.equals("origem")){
		    		idOrigem = Integer.parseInt(xmlFile.getAttributeValue(0));
		    	}
		    	if(name.equals("destino")){
		    		idDestino = Integer.parseInt(xmlFile.getAttributeValue(0));
		    	}
		    	if(name.equals("preco")){
		    		String precoString = xmlFile.nextText();
		    		try{
	                   Integer precoComPonto = Integer.parseInt(precoString.substring(precoString.indexOf(".")+1));
	                   if(precoComPonto>0){
	                       precoString = precoString.replace(".", "");
	                   }
	                }
	                catch(Exception e){
	                    e.printStackTrace();
	                }
		    		preco = Float.parseFloat(precoString);
		    	}
		    	
		    	if(name.equals("duracao")){
		    		duracao = xmlFile.nextText();
		    	}
		    	if(name.equals("numeroVoo")){
		    		numeroVoo = xmlFile.nextText();
		    	}
	    	}
	    }
	    else if(eventType == XmlPullParser.END_TAG)
	    {
	    	String name = xmlFile.getName();
	    	if(name!=null){
	    		if(xmlFile.getName().equals("trecho")){
	    			
		    		trecho = new Trecho(0,idOrigem,idDestino,duracao,preco,numeroVoo);
		    		
		    		listaDeTrechos.add(trecho);
		    	}
	    	}
	    	
	    }
	    eventType = xmlFile.next();
	   }
		
        return listaDeTrechos;
        
    }
    
    public static void main(String args[]){
        
    }
}
