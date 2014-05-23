/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.eb.ime.labprog3.tam;

import java.io.IOException;
import java.io.InputStream;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



/**
 *
 * @author arthurfernandes
 */
public class XMLParsingTamTrechos {

    private String aeroportoOrigem;
    private String aeroportoDestino;
    private Float preco;
    private String numeroVoo;
    private String duracao;
    
    public String getAeroportoOrigem() {
        return aeroportoOrigem;
    }

    public String getAeroportoDestino() {
        return aeroportoDestino;
    }

    public Float getPreco() {
        return preco;
    }

    public String getNumeroVoo() {
        return numeroVoo;
    }

    public String getDuracao() {
        return duracao;
    }
    
    
    private XMLParsingTamTrechos(){
    }
    
    public static XMLParsingTamTrechos createTrecho(InputStream streamPagina) {
        
        if(streamPagina == null)
            return null;
        
        Document dom = null;
        try{
            dom = Jsoup.parse(streamPagina,null,"");
        }
        catch(IOException e){
            return null;
        }
        
        Element tabelaDeVoos = dom.getElementById("outbound_list_flight_direct");
        
        if(tabelaDeVoos == null)
            return null;
        
        Elements voos = tabelaDeVoos.getElementsByClass("flight");
        
        if(voos.size() == 0)
            return null;
        
        Element vooMaisBarato = null;
        Float precoMaisBarato = Float.MAX_VALUE;

        for(Element voo: voos){
            try{
                String precoString = voo.getElementsByClass("price").get(0).text();
                if(precoString.indexOf(",")>0)
                    precoString = precoString.substring(0,precoString.indexOf(","));
                precoString = precoString.replace(".","");
                Float preco = Float.parseFloat(precoString);
                if(preco<precoMaisBarato){
                    vooMaisBarato = voo;
                    precoMaisBarato = preco;
                }
                        

            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
                
        if(vooMaisBarato == null)
            return null;
        
       

        
        XMLParsingTamTrechos trecho = new XMLParsingTamTrechos();
        
        try{
            trecho.aeroportoOrigem = vooMaisBarato.getElementsByClass("bLocation").get(0).text().trim();
            trecho.aeroportoDestino = vooMaisBarato.getElementsByClass("eLocation").get(0).text().trim();
            trecho.preco = precoMaisBarato;
            trecho.numeroVoo = vooMaisBarato.getElementsByAttribute("data-flight-number").text();
            trecho.duracao = vooMaisBarato.getElementsByClass("durationTh").get(0).text();
        }
        catch(Exception e){
            return null;
        }
        
        return trecho;
    }
    
    public static void main(String args[]){
        SendPostTamTrechos post1 = new SendPostTamTrechos("BSB","SDU","20140525");
        XMLParsingTamTrechos trecho = XMLParsingTamTrechos.createTrecho(post1.getStreamPagina());
        System.out.println(trecho.getPreco());
        
    }
}
