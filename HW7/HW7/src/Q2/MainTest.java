package Q2;

import Q1.AbstractGraph;
import Q1.GraphMethodsHomework;
import Q1.ListGraph;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by yagmur on 29.05.2018.
 */
public class MainTest {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("./src/files/test_part2.txt"));
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
            System.out.println("This graph is cyclic");
        }
        else
            System.out.println("This method is acyclic");

        /****************************************************************/
        /************ is_connected 1 ************************************/
        /****************************************************************/
        System.out.print("\nis_connected for (0, 13): ");
        if(hwGraph.is_connected(listGraph, 0, 13))
            System.out.println("This vertices are connected");

        else
            System.out.println("This vertices are not connected");

        /****************************************************************/
        /************ is_connected 2 ************************************/
        /****************************************************************/
        System.out.print("is_connected for (2, 9): ");
        if(hwGraph.is_connected(listGraph, 2, 9))
            System.out.println("This vertices are connected");

        else
            System.out.println("This vertices are not connected");

        /****************************************************************/
        /************ is_connected 3 ************************************/
        /****************************************************************/
        System.out.print("is_connected for (5, 7): ");
        if(hwGraph.is_connected(listGraph, 5, 7))
            System.out.println("This vertices are connected");

        else
            System.out.println("This vertices are not connected");


    }
}
