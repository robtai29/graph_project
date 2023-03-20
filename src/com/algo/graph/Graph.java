package com.algo.graph;

import java.util.*;


public class Graph {
    private boolean isWeighted;
    private boolean isDirected;

    private HashMap<Character, List<Edge>> adjList;
    private HashSet<Edge> edges;

    public Graph(boolean isWeighted, boolean isDirected){
        this.isDirected = isDirected;
        this.isWeighted = isWeighted;
        adjList = new HashMap<>();
        edges = new HashSet<>();
    }

    public void addEdge(Edge edge){
        Objects.requireNonNull(edge);
        edges.add(edge);
        char from = edge.getU();
        char to = edge.getV();
        if (!adjList.containsKey(from)){
            adjList.put(from, new LinkedList<Edge>());
        }

        adjList.get(from).add(edge);
        if (!isDirected){
            if (!adjList.containsKey(to)){
                adjList.put(to, new LinkedList<Edge>());
            }
            adjList.get(to).add(new Edge(to, from, edge.getDistance()));
        }
    }

    public List<Edge> getEdges(char vertex){
        return adjList.get(vertex);
    }

    public HashMap<Character, List<Edge>>  getAdjList(){
        return adjList;
    }

    public HashSet<Edge> getEdges(){
        return edges;
    }

}
