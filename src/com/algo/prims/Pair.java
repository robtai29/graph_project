package com.algo.prims;

import com.algo.graph.Edge;

public class Pair implements Comparable<Pair> {
    private char Vertex;
    private Edge edge;

    public Pair(char vertex, Edge edge) {
        Vertex = vertex;
        this.edge = edge;
    }

    public char getVertex() {
        return Vertex;
    }

    public Edge getEdge() {
        return edge;
    }

    public int getDistance(){
        return edge.getDistance();
    }


    @Override
    public int compareTo(Pair o) {
        if (this.getDistance() == o.getDistance()){
            return o.Vertex - this.Vertex;
        }

        return this.getDistance() - o.getDistance();
    }
}
