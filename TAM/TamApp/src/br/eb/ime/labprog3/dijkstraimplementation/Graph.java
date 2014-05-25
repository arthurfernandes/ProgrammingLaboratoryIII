

package br.eb.ime.labprog3.dijkstraimplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Graph implements Comparator<Vertex>{
    
    private List<Vertex> graph = new ArrayList<Vertex>();
    
    
    public Vertex getVertexById(int id){
        Vertex aux = new Vertex();
        for(int i = 0; i< graph.size(); i++){
            aux = graph.get(i);
            if((aux.getId()) == id){
                return graph.get(i);
            }
        }
        return null;
    
    }
    
    
    public List<Vertex> getGraph(){
        return this.graph;
    }
    
    public void setGraph(List<Vertex> _graph){
        this.graph = _graph;
    }
    
    public void addVertex(Vertex newVertex){
        if(this.getVertexById(newVertex.getId()) == null){
            graph.add(newVertex);
        }
        
    }
    
    public void removeVertex(Vertex vertex){
        Vertex aux = new Vertex();
        int id = vertex.getId();
        aux = this.getVertexById(id);
        if(aux != null){
            graph.remove(vertex);
        }
    }
    
    public void orderByTraveledDistance(){
        Collections.sort(graph, this);
    }

    public int compare(Vertex v1, Vertex v2) {
        if(v1.getTraveledDistance() > v2.getTraveledDistance()){
            return 1;
        }
        else if(v1.getTraveledDistance() == v2.getTraveledDistance()){
            return 0;
        }
        else{
            return -1;
        }
    }
    
    public boolean isEmpty(){
        return graph.isEmpty();
    }
    
}
