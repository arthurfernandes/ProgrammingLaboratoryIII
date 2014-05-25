
package br.eb.ime.labprog3.dijkstraimplementation;

import java.util.ArrayList;
import java.util.List;


public class Dijkstra {
    
    private Graph dijkstra = new Graph();
    private Graph nonVisitedVertices = new Graph();
    
    
    public void setInfiniteDistance(List<Vertex> vertices){
        for(Vertex v: vertices){
            v.setTraveledDistance(9999999);
        }
    }
    
    
    public Graph doDijkstra(Vertex origin, Vertex destination, Graph graph){
        
        List<Vertex> auxiliar = new ArrayList<Vertex>();
        Vertex actualVertex = new Vertex(); 
        Vertex nextVertex = new Vertex();
        
        //Add origin to final graph
        dijkstra.addVertex(origin);
        //Set distances
        auxiliar = graph.getGraph();
        this.setInfiniteDistance(auxiliar);

        //Add vertices to nonVisitedVertices
        this.nonVisitedVertices.setGraph(auxiliar);
        origin.setTraveledDistance(0);

        this.nonVisitedVertices.orderByTraveledDistance();
        
        
        while(!this.nonVisitedVertices.isEmpty()){
            
            auxiliar = this.nonVisitedVertices.getGraph();
            actualVertex = auxiliar.get(0);
            for(int i = 0; i < actualVertex.getEdges().size(); i++){
                nextVertex = actualVertex.getEdges().get(i).getDestination();
                
                if(!nextVertex.checkVisit()){
                        if (nextVertex.getTraveledDistance() > (actualVertex.getTraveledDistance() + actualVertex.getEdges().get(i).getWeight())){

                            nextVertex.setTraveledDistance(actualVertex.getTraveledDistance()+ actualVertex.getEdges().get(i).getWeight());
                            nextVertex.setFatherVertex(actualVertex);
                    
                            if (nextVertex == destination) {
				dijkstra.setGraph(new ArrayList<Vertex>());
				dijkstra.addVertex(nextVertex);
				while (nextVertex.getFatherVertex() != null) {
                                    dijkstra.addVertex(nextVertex.getFatherVertex());
                                    nextVertex = nextVertex.getFatherVertex();
							}
                                        
                        }
                        
                        dijkstra.orderByTraveledDistance();
                    }
                }
            }
            actualVertex.visit();
            this.nonVisitedVertices.removeVertex(actualVertex);
            this.nonVisitedVertices.orderByTraveledDistance();
        }
        return this.dijkstra;
    }
    
    public List<Edge> getDijkstraEdges(){
        int i;
        List<Edge> edges = new ArrayList<Edge>();
        for(i = 0;i <this.dijkstra.getGraph().size()-1;i++){
            edges.add(this.dijkstra.getGraph().get(i).getEdgeByDestination(this.dijkstra.getGraph().get(i+1)));
            
        }
        return edges;
    }
    
    
    
}
