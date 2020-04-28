 
import java.io.*; 
import java.util.*; 

public class Graph {
	
	public static int V; 
	public static LinkedList<Integer> adj[]; // Adjacency List Representation 
	public static boolean visited[];
	
	Graph(int v) { 
		V = v; 
	    adj = new LinkedList[v]; 
	    for(int i = 0; i < v; i++) {
	    	adj[i] = new LinkedList();
	    }
	    visited = new boolean[v];
	 } 
	
     void addEdge(int v,int w) { 
        adj[v].add(w); 
        adj[w].add(v); 
     } 
     
     public static boolean isCyclic() {
    	return isCyclic(1, -1);
     }
    
     public static boolean isCyclic(int node, int parent) {
    	visited[node] = true;
    	for(int child : adj[node]) {
    		if(!visited[child]) {
    			return isCyclic(child, node);
    		} else if(child != parent) {
        		return true;
        	}
    	} 
    	return false;
     }
	
     public static void main(String args[]) {
		Graph g1 = new Graph(6); 
        g1.addEdge(1, 2); 
        g1.addEdge(2, 3);  
        g1.addEdge(3, 4); 
        g1.addEdge(4, 5); 
        g1.addEdge(3, 5); 
        
        if (g1.isCyclic()) 
            System.out.println("Graph G1 contains a cycle"); 
        else
            System.out.println("Graph G1 doesn't contains a cycle"); 
  
 		Graph g2 = new Graph(7); 
        g1.addEdge(1, 4); 
        g1.addEdge(6, 4);  
        g1.addEdge(5, 4); 
        g1.addEdge(3, 4); 
        g1.addEdge(2, 3); 
        if (g2.isCyclic()) 
            System.out.println("Graph G2 contains a cycle"); 
        else
            System.out.println("Graph G2 doesn't contains a cycle"); 
  	}
 }