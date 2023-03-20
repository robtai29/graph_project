package com.algo.djikstra;

import com.algo.graph.Edge;
import com.algo.graph.Graph;

import java.util.*;
//This class creates an instance of an object capable of applying Djikstra algorithm
public class DjikstraSolver {
    private Graph graph;
    private char origin;
    private Set<Edge> relaxedEdges;
    private Set<Character> visited;
    PriorityQueue<Edge> pq;
    private HashMap<Character, List<Edge>> adjList;
    HashMap<Character,Integer> distances = new HashMap<>();

    //This initalizes the solver object which takes a graph and the origin
    public DjikstraSolver(Graph graph, char origin){
        this.graph = graph;
        this.origin = origin;
        pq = new PriorityQueue<>(Comparator.comparingInt(Edge::getDistance));
        pq.add(new Edge(origin, origin, 0));
        adjList = new HashMap<>(graph.getAdjList());
        relaxedEdges = graph.getEdges();
        visited = new HashSet<>();
        distances.put(origin, 0);
    }

    //this method computes shortest path starting from the origin
    public HashMap<Character, Integer> findShortestPath(){
        while (!pq.isEmpty()){
            Edge pop = pq.poll();
            char from = pop.getU();
            char to = pop.getV();
            visited.add(to);
            int distance = pop.getDistance() + distances.get(from);
            if (distances.containsKey(to)){
                if (distances.get(to) > distance){
                    distances.put(to, distance);
                    relaxedEdges.remove(pop);
                }
            }else{
                distances.put(to, distance);
                relaxedEdges.remove(pop);
            }
            for (Edge edge: adjList.get(to)){
                char vertex = edge.getV();
                if (!visited.contains(vertex)){
                    pq.add(edge);
                }
            }


        }

        return distances;


    }

    public Set<Edge> getRelaxedEdges() {
        return relaxedEdges;
    }
}
