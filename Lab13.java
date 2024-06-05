public class Lab13 {
    public static void main(String[] args) throws Exception {
        GraphArray G = new GraphArray(4);
        G.addVertex("A");
        G.addVertex("B");
        G.addVertex("C");
        G.addVertex("D");

        G.addEdge("B", "A");
        G.addEdge("B", "D");
        G.addEdge("B", "C");
        G.addEdge("D", "C");

        G.displayVertices();
        G.displayGraph();

        System.out.println("\nNumber of vertices: " + G.getNumVertices());
        System.out.println("Number of edges: " + G.getNumEdges());

        System.out.println("indegree/outdegree of vertex A: " + G.indegree("A") + "/" + G.outdegree("A"));
        System.out.println("indegree/outdegree of vertex B: " + G.indegree("B") + "/" + G.outdegree("B"));

        System.out.println("\nTesting error cases: ");
        G.deleteEdge("A", "C");
        G.addVertex("E");
        G.deleteVertex("F");

        G.deleteEdge("B", "A");
        G.deleteVertex("D");
        System.out.println("\nDisplay the graph after deleting vertex D and edge (B,A): ");
        G.displayVertices();
        G.displayGraph();
        System.out.println("\nNumber of vertices after deleting: " + G.getNumVertices());
        System.out.println("Number of edges after deleting: " + G.getNumEdges());
    }
}

class GraphArray {// Directed Graph
    private String[] vertex;
    private boolean[][] edges;
    private int numVertices;
    private int numEdges;

    public GraphArray(int capacity) {
        vertex = new String[capacity];
        edges = new boolean[capacity][capacity];
    }

    public int getNumEdges() {
        return numEdges;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public boolean isEmpty() {
        return (numVertices == 0);
    }

    public boolean isFull() {
        return (numVertices == vertex.length);
    }

    public void clear() {
        numVertices = 0;
        numEdges = 0;
    }

    public int findVertex(String v) {
        for (int i = 0; i < numVertices; i++)
            if (vertex[i].equals(v))
                return i;
        return -1;
    }

    public boolean addVertex(String v) {
        if (findVertex(v) != -1) {
            System.out.println("addVertex failed- Error: Duplicate Vertex " + v);
            return false;
        }

        if (isFull()) {
            System.out.println("addvertex failed- Error: Full Graph!");
            return false;
        }

        vertex[numVertices++] = v;
        return true;
    }

    public boolean deleteVertex(String v) {
        int index = findVertex(v);

        if (isEmpty()) {
            System.out.println("deleteVertex failed- Error: Empty Graph!");
            return false;
        }

        if (index == -1) {
            System.out.println("deleteVertex failed- Error: Unknown Vertex " + v);
            return false;
        }

        // delete the vertex and array if needed
        vertex[index] = vertex[numVertices - 1];
        vertex[numVertices - 1] = null;

        // delete its rleated edges
        for (int j = 0; j < numVertices; j++) {// for rows (out edges)
            if (edges[index][j])
                numEdges--;
            edges[index][j] = edges[numVertices - 1][j];
        }

        for (int i = 0; i < numVertices; i++) {// for cols (in edges)
            if (edges[i][index])
                numEdges--;
            edges[i][index] = edges[i][numVertices - 1];
        }

        numVertices--;
        return true;
    }

    public boolean addEdge(String v1, String v2) {

        int i = findVertex(v1);
        if (i == -1) {// not found
            System.out.println("addEdge failed- Error: Unknown Vertex " + v1);
            return false;
        }

        int j = findVertex(v2);
        if (j == -1) {// not found
            System.out.println("addEdge failed- Error: Unknown Vertex " + v2);
            return false;
        }

        edges[i][j] = true;
        numEdges++;
        return true;
    }

    public boolean deleteEdge(String v1, String v2) {
        if (isEmpty()) {
            System.out.println("deteteEdge failed- Error: Empty Graph!");
            return false;
        }

        int i = findVertex(v1);
        if (i == -1) {// not found
            System.out.println("deteteEdge failed- Error: Unknown Vertex " + v1);
            return false;
        }

        int j = findVertex(v2);
        if (j == -1) {// not found
            System.out.println("deteteEdge failed- Error: Unknown Vertex " + v2);
            return false;
        }

        if (!edges[i][j]) {// already false
            System.out.println(
                    "deleteEdge failed- Error: There is no dege between (" + v1 + ") and (" + v2 + ") to be deleted.");
            return false;
        }

        edges[i][j] = false;
        numEdges--;
        return true;
    }

    public int outdegree(String v) {
        if (isEmpty()) {
            System.out.println("degree faied- Error: Empty Graph!");
            return -1;
        }

        int i = findVertex(v);
        if (i == -1) {// not found
            System.out.println("degree faied- Error: Unknown Vertex" + v);
            return -1;
        }

        int outdegree = 0;
        for (int j = 0; j < numVertices; j++)
            if (edges[i][j])
                outdegree++;
        return outdegree;
    }

    public int indegree(String v) {
        if (isEmpty()) {
            System.out.println("degree faied- Error: Empty Graph!");
            return -1;
        }

        int i = findVertex(v);
        if (i == -1) {// not found
            System.out.println("degree faied- Error: Unknown Vertex" + v);
            return -1;
        }

        int indegree = 0;
        for (int j = 0; j < numVertices; j++)
            if (edges[j][i])
                indegree++;

        return indegree;
    }

    public void displayGraph() {
        if (isEmpty()) {
            System.out.println("displayGraph failed- Error: Empty Graph!");
            return;
        }

        System.out.println("\n*** Graph Vertices and thier Edges ***");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("\n>> vertex " + (i + 1) + ": " + vertex[i]);
            System.out.print(" is connected to the vertices: ");

            boolean found = false;
            for (int j = 0; j < numVertices; j++)
                if (edges[i][j]) {
                    found = true;
                    System.out.print("(" + vertex[j] + ") ");
                }
            if (!found)
                System.out.println("Null");
            else
                System.out.println("");// new line
        }
    }

    public void displayVertices() {
        if (isEmpty()) {
            System.out.println("displayVertices failed- Error: Empty Graph!");
            return;
        }

        System.out.println("\n*** Graph Vertices ***");
        for (int i = 0; i < numVertices; i++)
            System.out.println("vertex " + (i + 1) + ": " + vertex[i]);
    }
}