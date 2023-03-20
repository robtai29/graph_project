package com.algo.prims;

import com.algo.graph.Edge;
import com.algo.graph.Graph;

import java.util.*;

public class PrimJarnikSolver {
    private Graph graph;
    private char origin;
    private Set<Edge> edges;
    private Set<Character> visited;
    private PriorityQueue<Pair> pq;
    private HashMap<Character, List<Edge>> adjList;
    private HashMap<Character,Integer> distances = new HashMap<>();
    private List<Edge> finalList;
    private int size;

    /**
     * Report size of edge set
     * @param  graph input graph object
     * @param origin origin
     */
    public PrimJarnikSolver(Graph graph, char origin){
        this.graph = graph;
        this.origin = origin;
        pq = new PriorityQueue<>();

        adjList = new HashMap<>(graph.getAdjList());
        edges = graph.getEdges();
        visited = new HashSet<>();
        finalList = new LinkedList<>();
        pq.add(new Pair(origin, new Edge(origin, origin, 0)));
        size = adjList.size();
    }

    /**
     * Return the final list of edges in the MST
     * @return MST in a list of edges
     */
    public List<Edge> findMST(){
        while (visited.size() < size && !pq.isEmpty()){
            Pair pair = pq.poll();
            char destination = pair.getEdge().getV();
            char source = pair.getEdge().getU();
            int cost = pair.getDistance();

            visited.add(destination);

            finalList.add(new Edge(source, destination, cost));

            for (Edge edge: adjList.get(destination)){
                if (!visited.contains(edge.getV())){
                    pq.add(new Pair(edge.getV(), new Edge(edge.getU(), edge.getV(), edge.getDistance())));
                }
            }
        }
        return finalList;
    }


}
