/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.eb.ime.labprog3.tamapp;

import br.eb.ime.labprog3.dijkstraimplementation.Dijkstra;
import br.eb.ime.labprog3.dijkstraimplementation.Edge;
import br.eb.ime.labprog3.dijkstraimplementation.Graph;
import br.eb.ime.labprog3.dijkstraimplementation.Vertex;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arthurfernandes
 */
public class GeradorGrafoDijkstra {
    
    private final List<Aeroporto> aeroportos;
    private final List<Trecho> trechos;
    
    public GeradorGrafoDijkstra(List<Aeroporto> aeroportos,List<Trecho> trechos){
        this.aeroportos = aeroportos;
        this.trechos = trechos;
    }
    //Os indexes come��am em 1
    List<Aeroporto> geraMenorCaminho(int indexAeroportoOrigem,int indexAeroportoDestino){
        Vertex[] vertexAeroportos = new Vertex[aeroportos.size()];
        Edge[] edgeTrechos = new Edge[trechos.size()];
        
        for(int i = 0;i<vertexAeroportos.length;i++){
            //Index come��ando em 1
            vertexAeroportos[i] = new Vertex(i+1);
        }
        
        for(int i = 0;i<edgeTrechos.length;i++){
            Trecho trecho = trechos.get(i);
            
            int indexDestino = trecho.getIdAeroportoDestino();
            int indexOrigem = trecho.getIdAeroportoOrigem();
            
            int preco = (int) trecho.getPreco();
            
            if(indexDestino>0 && trecho.getIdAeroportoOrigem()>0){
                edgeTrechos[i] = new Edge(vertexAeroportos[indexOrigem-1],vertexAeroportos[indexDestino-1],preco);
                
                vertexAeroportos[indexOrigem-1].addEdge(edgeTrechos[i]);
            }
        }
                
        Graph graph = new Graph();
        for(int i = 0;i<vertexAeroportos.length;i++)
            graph.addVertex(vertexAeroportos[i]);
        
        Dijkstra dijkstra = new Dijkstra();
        Graph result = new Graph();
        result = dijkstra.doDijkstra(vertexAeroportos[indexAeroportoOrigem-1], vertexAeroportos[indexAeroportoDestino-1], graph);
        
        List<Vertex> vertices = new ArrayList<Vertex>();
        vertices = result.getGraph();
        
        //List<Edge> edgeTrechosResultado = dijkstra.getDijkstraEdges();
        
        List<Aeroporto> aeroportosCaminho = new ArrayList<Aeroporto>();
        for(int i = 0;i<vertices.size();i++){
            int id = vertices.get(i).getId();
            String sigla = aeroportos.get(id-1).getSigla();
            String nome = aeroportos.get(id-1).getNome();
            Aeroporto aeroporto = new Aeroporto(id,sigla,nome);
            aeroportosCaminho.add(aeroporto);
        }
        
        /*
        List<Trecho> trechosResultado = new ArrayList<>();
        for(int i =0;i<edgeTrechosResultado.size();i++){
            int idTrecho = edgeTrechosResultado.get(i).getWeight();
            Trecho trecho = new Trecho(0, indexAeroportoOrigem, indexAeroportoDestino, "", preco, "");
        }*/
        return aeroportosCaminho;
    }
    
    public static void main(String args[]){
    }
}
