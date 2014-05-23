

package br.eb.ime.labprog3.dijkstraimplementation;


public class Edge {
    
    private Vertex origin;
    private Vertex destination;
    private int weight;
    
   
    public Edge(Vertex Origin, Vertex Destination, int Weight){
        this.origin = Origin;
        this.destination = Destination;
        this.weight = Weight;
    }
    
    public Edge(Vertex Origin, Vertex Destination){
        this.destination = Destination;
        this.origin = Origin;
    }
    
    public Vertex getOrigin(){
        return this.origin;
    }
    
    public void setOrigin(Vertex Origin){
        this.origin = Origin;
    }
    
    public void setDestination(Vertex Destination){
        this.destination = Destination;
    }
    
    public Vertex getDestination(){
        return this.destination;
    }
    
    public int getWeight(){
        return this.weight;
    }
    
    public void setWeight(int Weight){
        this.weight = Weight;
    }
    
    
    
    
    
}
