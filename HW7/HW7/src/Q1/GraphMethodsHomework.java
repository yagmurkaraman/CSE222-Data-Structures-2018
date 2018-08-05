package Q1;

import sun.security.provider.certpath.Vertex;

import java.util.*;

/**
 * Created by yagmur on 28.0g.getNumV().2018.
 */
public class GraphMethodsHomework {

    private Integer V;
    private List<List<Integer>> adjD;
    private LinkedList<Integer> adjU[]; // Adjacency List Represntation

    /**
     * This method print the graph
     * @param g graph
     */
    public void plot_graph(Graph g) {
        for (int i = 0; i < g.getNumV(); ++i) {
            for (int j = 0; j < g.getNumV(); ++j) {
                System.out.println(g.getEdge(i, j));
            }
        }
    }

    /**
     * This method return the graph is directed or undirected
     * @param g graph
     * @return boolean true if graph undirected, else false
     */
    public boolean is_undirected(Graph g) {

        return !(g.isDirected());
    }

    /**
     * This method check the vertex 1 and vertex 2 has a connection.
     * Search path between these vertices
     * @param g graph
     * @param v1 source vertex
     * @param v2 destination vertex
     * @return true if has a connection, else false
     */
    public boolean is_connected(Graph g, int v1, int v2) {

        Vector<Integer> vect=shortest_path(g, v1, v2);
        if(vect.size() != 0)
            return true;

        return false;
    }

    /**
     * This method find shortest path between vertices and return vector of path
     * @param i source vertex
     * @param j destination vertex
     * @param k start index
     * @param m size of vertex1 vector
     * @param n size of vertex2 size
     * @return vector of path
     */
    public Vector<Integer> ShortestPath(int i, int j, int k, int m,
                      int n) {
        Vector<Integer> path1 = new Vector<Integer>();
        Vector<Integer> path2 = new Vector<Integer>();
        Vector<Integer> returnVector = new Vector<Integer>();

        int x = m - 1;

        path1.add(i);
        while (x != k) {
            path1.add(i / 2);
            i = i / 2;
            x--;
        }
        int y = n - 1;
        path2.add(j);

        while (y != k) {
            path2.add(j / 2);
            j = j / 2;
            y--;
        }
        for (int l = 0; l < path1.size(); l++)
            returnVector.add(path1.get(l));

        for (int l = path2.size() - 2; l >= 0; l--)
            returnVector.add(path2.get(l));

        return returnVector;
    }

    /**
     * This method find shortest path between vertex i and j
     * @param g graph
     * @param i vertex1
     * @param j vertex2
     * @return vector of path
     */
    public Vector<Integer> shortest_path(Graph g, int i, int j) {
        Vector<Integer> v1 = new Vector<Integer>();
        Vector<Integer> v2 = new Vector<Integer>();
        int p1 = i;
        int p2 = j;
        while (i != 0) {
            v1.add(i % 2);
            i = i / 2;
        }
        while (j != 0) {
            v2.add(j % 2);
            j = j / 2;
        }
        Collections.reverse(v1);
        Collections.reverse(v2);
        int m = v1.size(), n = v2.size(), k = 0;
        if (m < n) {
            while (k < m && v1.get(k) == v2.get(k))
                k++;
        } else {
            while (k < n && v1.get(k) == v2.get(k))
                k++;
        }
        return ShortestPath(p1, p2, k - 1, m, n);
    }

    /**
     * This method fill the adjD list with number of vertices
     * @param V number of vertices of graph
     */
    public void fillListD(int V) {
        this.V = V;
        adjD = new ArrayList<>(V);

        for (int i = 0; i < V; i++)
            adjD.add(new LinkedList<>());
    }

    /**
     * This method check a directed graph is has a cyclic or nor
     * @param i vertex
     * @param visited array of visited vertex
     * @param recStack stack of remain vertex
     * @return true if graph has a cyclic, else false
     */
    public boolean isCyclicUtilD(int i, boolean[] visited,
                                 boolean[] recStack) {

        if (recStack[i])
            return true;

        if (visited[i])
            return false;

        visited[i] = true;

        recStack[i] = true;
        List<Integer> children = adjD.get(i);

        for (Integer c: children)
            if (isCyclicUtilD(c, visited, recStack))
                return true;

        recStack[i] = false;

        return false;
    }

    /**
     * This method check a graph is acyclic or not
     * @param g graph
     * @return true if graph is acyclic, else false
     */
    public boolean is_acyclic_graph(Graph g) {
        if(g.isDirected())
            return isCyclicDirected(g.getNumV());

        return isCyclicUndirected(g.getNumV());
    }

    /**
     * This method fill adjD list with destination of source vertices
     * @param source source vertex
     * @param dest destination vertex
     */
    public void addEdgeD(int source, int dest) {
        adjD.get(source).add(dest);
    }
    public boolean isCyclicDirected(Integer V) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];

        for (int i = 0; i < V; i++)
            if (isCyclicUtilD(i, visited, recStack))
                return true;

        return false;
    }

    /**
     * This method fill linkedlist with vertices
     * @param v number of vertices of graph
     */
    public void fillListU(int v) {
        V = v;
        adjU = new LinkedList[v];
        for(int i=0; i<v; ++i)
            adjU[i] = new LinkedList();
    }

    /**
     * This method add edges to adjU list of undirected graph
     * @param v vertex1
     * @param w vertex2
     */
    public void addEdgeU(int v, int w) {
        adjU[v].add(w);
        adjU[w].add(v);
    }

    /**
     * This method check a graph has a cyclic or not
     * @param v vertex
     * @param visited array of visited vertices
     * @param parent parent vertice of current vertice
     * @return true if graph has a cyclic, else false
     */
    public boolean isCyclicUtilU(int v, boolean visited[], int parent) {
        visited[v] = true;
        Integer i;

        Iterator<Integer> it = adjU[v].iterator();
        while (it.hasNext())
        {
            i = it.next();

            if (!visited[i]) {
                if (isCyclicUtilU(i, visited, v))
                    return true;
            }
            else if (i != parent)
                return true;
        }
        return false;
    }

    /**
     * This method check a undirected graph has any cyclics
     * @param V number of vertices of graph
     * @return true if graph has cyclic, else false
     */
    public boolean isCyclicUndirected(Integer V) {

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        for (int u = 0; u < V; u++)
            if (!visited[u])
                if (isCyclicUtilU(u, visited, -1))
                    return true;

        return false;
    }
}