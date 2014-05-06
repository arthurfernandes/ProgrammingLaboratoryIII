/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.eb.ime.labprog3.cinemark;

import java.util.ArrayList;
import java.util.List;
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
public class FilmeDAO {
    
    private DocumentoXML documentoXML;
    
    public FilmeDAO(){
        
    }
    
    public void setDocumentoXML(DocumentoXML documentoXML){
        this.documentoXML = documentoXML;
    }
    
    public List<Filme> getTodosOsFilmes(){
        
        Document documentXML = this.documentoXML.getDocumentXML();

        XPath xPath =  XPathFactory.newInstance().newXPath();
        String expression = "//film";
        NodeList nodeList = null;
        try{
        nodeList = (NodeList) xPath.compile(expression).evaluate(documentXML,XPathConstants.NODESET);
        }
        catch(XPathExpressionException e){
            return new ArrayList<Filme>();
        }
        
        return this.geradorDeListaDeFilmes(nodeList);
    }
    
    public List<Filme> getDezPrimeirosFilmes(){
        Document documentXML = this.documentoXML.getDocumentXML();

        XPath xPath =  XPathFactory.newInstance().newXPath();
        String expression = "//film[@n<=10]";
        NodeList nodeList = null;
        try{
        nodeList = (NodeList) xPath.compile(expression).evaluate(documentXML,XPathConstants.NODESET);
        }
        catch(XPathExpressionException e){
            return new ArrayList<Filme>();
        }
        
        return geradorDeListaDeFilmes(nodeList);
    }
    
    private List<Filme> geradorDeListaDeFilmes(NodeList nodeList){
        ArrayList<Filme> todosFilmes = new ArrayList<>();
        
        for(int i = 0;i<nodeList.getLength();i++){
            FilmeBuilder filmeBuilder = new FilmeBuilder();
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element elemento = (Element) node;
                filmeBuilder.comFilmeId(elemento.getAttribute("id"));
                filmeBuilder.comNome(elemento.getTextContent());
                filmeBuilder.comGenero(elemento.getAttribute("genre"));
                filmeBuilder.comClassificacaoIndicativa(elemento.getAttribute("parent-guide-rating"));
                filmeBuilder.comDistribuidora(elemento.getAttribute("distributor"));
                filmeBuilder.comDuracao(elemento.getAttribute("runtime"));

                Filme filme = filmeBuilder.geraFilme();
                todosFilmes.add(filme);
            }
        }
        
        return todosFilmes;
    }
}
