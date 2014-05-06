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
public class CinemaDAO {
    private DocumentoXML documentoXML;
    
    public CinemaDAO(){
        
    }
    
    public void setDocumentoXML(DocumentoXML documentoXML){
        this.documentoXML = documentoXML;
    }
    
    public List<Cinema> getTodosOsCinemas(){
        Document documentXML = documentoXML.getDocumentXML();
        XPath xPath = XPathFactory.newInstance().newXPath();
        String expression = "//theater";
        
        NodeList nodeList = null;
        
        try{
            nodeList = (NodeList) xPath.compile(expression).evaluate(documentXML,XPathConstants.NODESET);
        }
        catch(XPathExpressionException e){
            return new ArrayList<>();
        }
        
        return geradorDeListaDeCinemas(nodeList); 
    }
    
    public List<Cinema> getCinemasPorCidade(Integer cidadeId){
        Document documentXML = documentoXML.getDocumentXML();
        XPath xPath = XPathFactory.newInstance().newXPath();
        String expression = "//theather/city[@id="+cidadeId.toString()+"]";
        
        NodeList nodeList = null;
        
        try{
            nodeList = (NodeList) xPath.compile(expression).evaluate(documentXML,XPathConstants.NODESET);
        }
        catch(XPathExpressionException e){
            return new ArrayList<>();
        }
        
        return geradorDeListaDeCinemas(nodeList); 
    }
    
    private List<Cinema> geradorDeListaDeCinemas(NodeList nodeList){
        ArrayList<Cinema> todosOsCinemas = new ArrayList<>();
        
        for(int i = 0;i<nodeList.getLength();i++){
            CinemaBuilder cinemaBuilder = new CinemaBuilder();
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element elemento = (Element) node;
                cinemaBuilder.comCinemaId(elemento.getAttribute("id"));
                cinemaBuilder.comNome(elemento.getElementsByTagName("name").item(0).getTextContent());
                
                Node enderecoNode = elemento.getElementsByTagName("address").item(0);
                if(enderecoNode.getNodeType() == Node.ELEMENT_NODE){
                    Element enderecoElemento = (Element) enderecoNode;
                    cinemaBuilder.comLatitude(enderecoElemento.getAttribute("latitude"));
                    cinemaBuilder.comLongitude(enderecoElemento.getAttribute("longitude"));
                }
                
                Node salasNode = elemento.getElementsByTagName("auditoriums").item(0);
                if(salasNode.getNodeType() == Node.ELEMENT_NODE){
                    Element salasElemento = (Element) salasNode;
                    cinemaBuilder.comNumeroSalas(String.valueOf(salasElemento.getElementsByTagName("auditorium").getLength()));
                }
                
                Node cidadeNode = elemento.getElementsByTagName("city").item(0);
                if(cidadeNode.getNodeType() == Node.ELEMENT_NODE){
                    Element cidadeElemento = (Element) cidadeNode;
                    Integer cidadeId = 0;
                    try{
                        cidadeId = Integer.parseInt(cidadeElemento.getAttribute("id"));
                    }
                    catch(NumberFormatException e){
                        cidadeId = 0;
                        
                    }
                    
                    String cidadeNome = cidadeElemento.getTextContent();
                    if(cidadeId!=0)
                        cinemaBuilder.comCidade(new Cidade(cidadeId,cidadeNome));
                }
                
                Cinema cinema = cinemaBuilder.geraCinema();
                todosOsCinemas.add(cinema);
            }
        }
        return todosOsCinemas;
    }
}
