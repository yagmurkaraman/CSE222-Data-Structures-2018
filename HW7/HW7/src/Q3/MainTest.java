package Q3;

import Q1.AbstractGraph;
import Q1.GraphMethodsHomework;
import Q1.ListGraph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by yagmur on 29.05.2018.
 */
public class MainTest {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("./src/files/test_part3.txt"));
        Scanner scan = new Scanner(bf);
        ListGraph listGraph = (ListGraph) AbstractGraph.createGraph(scan,false,"List");
        GraphMethodsHomework hwGraph = new GraphMethodsHomework();
        System.out.println("plot_graph method:");
        System.out.println("--------------");
        hwGraph.plot_graph(listGraph);

        System.out.print("\nis_undirected method: ");
        if(hwGraph.is_undirected(listGraph)) {
            System.out.println("This graph is undirected");
        }
        else
            System.out.println("This graph is directed");

        System.out.print("\nis_acyclic_graph method: ");
        hwGraph.fillListU(listGraph.getNumV());
        for(int i=0; i<listGraph.getNumV(); ++i) {
            for(int j=0; j<listGraph.getNumV(); ++j) {
                if(listGraph.isEdge(i,j))
                    hwGraph.addEdgeU(i,j);
            }
        }
        if(!hwGraph.is_acyclic_graph(listGraph)) {
            System.out.println("This graph is acyclic");
        }
        else
            System.out.println("This method is cyclic");

        System.out.println("\n***********************************************");
        System.out.println("********         BFS                ***********");
        System.out.println("***********************************************");
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        bfs.breadthFirstSearch(listGraph, 1);

        System.out.println("\n\n***********************************************");
        System.out.println("********         DFS                ***********");
        System.out.println("***********************************************");
        DepthFirstSearch dfs = new DepthFirstSearch(listGraph);
        int i;
        for(i=0; i<dfs.discoveryOrder.length; ++i) {
            System.out.print(dfs.discoveryOrder[i]);
            System.out.print(" -> ");
        }
    }
}
