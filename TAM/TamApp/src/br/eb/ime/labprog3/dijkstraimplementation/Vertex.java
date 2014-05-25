

package br.eb.ime.labprog3.dijkstraimplementation;

import java.util.ArrayList;
import java.util.List;


public class Vertex {
    
    
    private int id;
    //The name of the city or airport
    private String location;
    private List<Vertex> neighbors = new ArrayList<Vertex>();
    private List<Edge> edges = new ArrayList<Edge>();
    private int traveledDistance;
    private boolean isVisited = false;
    private Vertex fatherVertex;
    
    public Vertex(){
        
    }
    
    public Vertex(int Id){
        this.id = Id;
    }
    
    public void setId(int Id){
        this.id = Id;
    }
    
    public int getId(){
        return id;
    }
    
    public void setNeighbors(List<Vertex> Neighbors){
        this.neighbors = Neighbors;
    }
    
    public List<Vertex> getNeighbors(){
        return this.neighbors;
    }
    
    public void setEdges(List<Edge> Edges){
        this.edges = Edges;
    }
    
    public List<Edge> getEdges(){
        return this.edges;
    }
    
    public String getLocation(){
        return this.location;
    }
    
    public void setLocation(String Location){
        this.location = Location;
    }
    
    
    public void setTraveledDistance(int distance){
        this.traveledDistance = distance;
    }
    
    public int getTraveledDistance(){
        return this.traveledDistance;
    }
    
     public void visit(){
        this.isVisited = true;
    }
    
    public void unvisit(){
        this.isVisited = false;
    }
    
    public boolean checkVisit(){
        return this.isVisited;
    }
    
    public void setFatherVertex(Vertex father){
        this.fatherVertex = father;
    }
    
    public Vertex getFatherVertex(){
        return this.fatherVertex;
    }
    
    public void addEdge(Edge edge){
        this.edges.add(edge);
    }
    
    public Edge getEdgeByDestination(Vertex destination){
        for(Edge v:edges){
            if(v.getDestination().id == destination.id){
                return v;
            }
        }
        return null;
    }
}
