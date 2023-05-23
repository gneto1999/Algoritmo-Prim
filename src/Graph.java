import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int numVertices;
    private int [][] adjMtx;

    public Graph(int vertices) {
        this.numVertices = vertices;
        this.adjMtx = new int[vertices][vertices];
    }

    // Inicializa a matriz de adjacencia
    public void addEdge(int src, int dest, int weight) {
        adjMtx[src][dest] = weight;
        adjMtx[dest][src] = weight;
    }

    public int[][] getAdjMtx() {
        return adjMtx;
    }

    public int getNumVertices() {
        return numVertices;
    }

    // Função que pega todos os vértices adjacentes ao vertice u
    public List<Integer> getAdjVertices(int source) {
        List<Integer> adjVertices = new ArrayList<>();
        for(int i = 0; i < adjMtx.length; i++) {
            if(adjMtx[source][i] != 0){
                adjVertices.add(i);
            }
        }

        return adjVertices;
    }

}
