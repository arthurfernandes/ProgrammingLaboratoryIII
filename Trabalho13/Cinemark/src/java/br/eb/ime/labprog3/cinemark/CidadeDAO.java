/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.eb.ime.labprog3.cinemark;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author arthurfernandes
 */
public class CidadeDAO {
    private DocumentoXML documentoXML;
    
    public CidadeDAO(){
    }
    
    public void setDocumentoXML(DocumentoXML documentoXML){
        this.documentoXML = documentoXML;
    }
    
    public Collection<Cidade> getTodasAsCidades(){
        Document documentXML = this.documentoXML.getDocumentXML();

        XPath xPath =  XPathFactory.newInstance().newXPath();
        String expression = "//city";
        NodeList nodeList = null;
        try{
        nodeList = (NodeList) xPath.compile(expression).evaluate(documentXML,XPathConstants.NODESET);
        }
        catch(XPathExpressionException e){
            return new TreeSet<Cidade>();
        }
        
        return geradorDeListaDeCidades(nodeList);
    }
    
    private Collection<Cidade> geradorDeListaDeCidades(NodeList nodeList){
        TreeSet<Cidade> todasAsCidades = new TreeSet(
                new Comparator<Cidade>(){

                    @Override
                    public int compare(Cidade o1, Cidade o2) {
                        return o1.getNome().compareToIgnoreCase(o2.getNome());
                    }
                }
        );
        
        for(int i = 0;i<nodeList.getLength();i++){
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element elemento = (Element) node;
                Integer cidadeId = 0;
                try{
                    cidadeId = Integer.parseInt(elemento.getAttribute("id"));
                }
                catch(NumberFormatException e){
                    break;
                }
                
                String cidadeNome = elemento.getTextContent();
                
                Cidade cidade = new Cidade(cidadeId,cidadeNome);
                todasAsCidades.add(cidade);
            }
        }
        
        return todasAsCidades;
        
    }

}
