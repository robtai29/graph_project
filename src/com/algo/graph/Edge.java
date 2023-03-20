package com.algo.graph;

public class Edge {

    private final char u;
    private final char v;

    private final int distance;

    public Edge(char u, char v, int distance){
        this.u = u;
        this.v = v;
        this.distance = distance;
    }

    public Edge(char u, char v){
        this(u, v, 0);
    }

    public char getU() {
        return u;
    }

    public char getV() {
        return v;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null){
            return false;
        }

        if (other.getClass() != this.getClass()){
            return false;
        }

        Edge otherEdge = (Edge) other;
        if (this.distance != otherEdge.distance){
            return false;
        }

        return (distance == otherEdge.distance && u == otherEdge.u && v == otherEdge.v) || (distance == otherEdge.distance && v == otherEdge.u && u == otherEdge.v);
    }

    public String toString(){
        String res = u + "--" + v + "  Distance: " + distance;
        return res;
    }
}
