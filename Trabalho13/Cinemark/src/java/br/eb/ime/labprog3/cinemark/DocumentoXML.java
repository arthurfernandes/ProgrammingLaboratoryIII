/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.eb.ime.labprog3.cinemark;

import org.w3c.dom.Document;

/**
 *
 * @author arthurfernandes
 */
public class DocumentoXML {
    
    private Document documentXML = null;
    
    public DocumentoXML(Document documentoXML){
        this.documentXML = documentoXML;
    }
    
    public Document getDocumentXML(){
        return this.documentXML;
    }
}
