/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.eb.ime.labprog3.tamapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.content.res.XmlResourceParser;
import android.util.Log;

/**
 *
 * @author arthurfernandes
 */
public class AeroportoDAO {
    
    private XmlResourceParser xmlFile;
    
    public AeroportoDAO(XmlResourceParser xmlFile){
        this.xmlFile = xmlFile;
    }
    
    
	public List<Aeroporto> listarAeroportos() throws XmlPullParserException, IOException{
        List<Aeroporto> listaDeAeroportos = new ArrayList<Aeroporto>();
		Aeroporto aeroporto = null;
        Integer id = 0;
        String nome = "";
        String sigla = "";
        
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
	    		
		    	if(name.equals("id")){
		    		id = Integer.parseInt(xmlFile.nextText());
		    	}
		    	
		    	if(name.equals("nome")){
		    		nome = xmlFile.nextText();
		    	}
		    	
		    	if(name.equals("sigla")){
		    		sigla = xmlFile.nextText();
		    	}
	    	}
	    }
	    else if(eventType == XmlPullParser.END_TAG)
	    {
	    	String name = xmlFile.getName();
	    	if(name!=null){
	    		if(xmlFile.getName().equals("aeroporto")){
		    		aeroporto = new Aeroporto(3,sigla,nome);
		    		
		    		listaDeAeroportos.add(aeroporto);
		    	}
	    	}
	    	
	    }
	    eventType = xmlFile.next();
	   }
		
        return listaDeAeroportos;
    }
    
    public static void main(String args[]) throws IOException{
    	
    }
}
