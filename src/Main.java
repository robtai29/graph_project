import com.algo.djikstra.*;
import com.algo.graph.Edge;
import com.algo.graph.Graph;
import com.algo.prims.PrimJarnikSolver;

import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Demonstrating Djistra's algo");
        Graph graph = new Graph(true, false);
        graph.addEdge(new Edge('A', 'B', 4));
        graph.addEdge(new Edge('A', 'C', 5));
        graph.addEdge(new Edge('B', 'C', 11));
        graph.addEdge(new Edge('B', 'E', 7));
        graph.addEdge(new Edge('B', 'D', 7));
        graph.addEdge(new Edge('C', 'E', 3));
        graph.addEdge(new Edge('D', 'E', 13));
        graph.addEdge(new Edge('D', 'F', 2));
        graph.addEdge(new Edge('E', 'F', 6));
        char origin = 'A';
        DjikstraSolver solver = new DjikstraSolver(graph, origin);
        System.out.println("output the relaxed edge prior to application of the algo, it should be the whole graph");
        for (Edge edge: solver.getRelaxedEdges()){
            System.out.println(edge);
        }


        HashMap<Character, Integer> results = solver.findShortestPath();
        System.out.println("\nAfter applying the algorithm: \n");
        for (char vertex : results.keySet()){
            System.out.println(origin + " ->  " + vertex + ": " + results.get(vertex));
        }

        System.out.println("Here are the relaxed edges");
        for (Edge edge: solver.getRelaxedEdges()){
            System.out.println(edge);
        }
        //output is same the readme;

        //Prim-Jarnik algo
        System.out.println("\n\nDemonstrating Prim-Jarnik algo, which will match the readme file");
        Graph graph2 = new Graph(true, false);
        graph2.addEdge(new Edge('A', 'B', 2));
        graph2.addEdge(new Edge('A', 'C', 8));

        graph2.addEdge(new Edge('B', 'D', 7));
        graph2.addEdge(new Edge('B', 'C', 5));
        graph2.addEdge(new Edge('C', 'D', 9));
        graph2.addEdge(new Edge('C', 'E', 8));
        graph2.addEdge(new Edge('D', 'F', 4));
        graph2.addEdge(new Edge('E', 'F', 3));
        graph2.addEdge(new Edge('A', 'E', 8));

        PrimJarnikSolver primSolver = new PrimJarnikSolver(graph2, 'A');
        List<Edge> mst = primSolver.findMST();

        for (Edge edge: mst){
            System.out.println(edge);
        }

        //this should match the readme file


    }




}