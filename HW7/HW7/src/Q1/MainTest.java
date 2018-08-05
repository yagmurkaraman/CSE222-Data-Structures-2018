package Q1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;
/**
 * Created by yagmur on 28.05.2018.
 */
public class MainTest {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new FileReader("./src/files/test_part1.txt"));
        Scanner scan = new Scanner(bf);
        ListGraph listGraph = (ListGraph) AbstractGraph.createGraph(scan,true,"List");
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
        hwGraph.fillListD(listGraph.getNumV());
        for(int i=0; i<listGraph.getNumV(); ++i) {
            for(int j=0; j<listGraph.getNumV(); ++j) {
                if(listGraph.isEdge(i,j))
                    hwGraph.addEdgeD(i,j);
            }
        }
        if(hwGraph.is_acyclic_graph(listGraph)) {
            System.out.println("This graph is cyclic");
        }
        else
            System.out.println("This method is acyclic");

        System.out.print("\nshortest_path for (0, 3): ");
        Vector<Integer> vect= hwGraph.shortest_path(listGraph, 0, 3);
        for(int i=0; i<vect.size(); ++i)
            System.out.print(vect.get(i) + " ");

        System.out.print("\nshortest_path for (1, 5): ");
        Vector<Integer> vect2= hwGraph.shortest_path(listGraph, 1, 5);
        for(int i=0; i<vect2.size(); ++i)
            System.out.print(vect2.get(i) + " ");

        System.out.print("\nshortest_path for (4, 8): ");
        Vector<Integer> vect3= hwGraph.shortest_path(listGraph, 4, 8);
        for(int i=0; i<vect3.size(); ++i)
            System.out.print(vect3.get(i) + " ");
    }
}
