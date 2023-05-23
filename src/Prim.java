import java.util.*;

public class Prim {
    private final List<Edge> mst = new ArrayList<>();
    public List<Edge> primMst(Graph graph) {
        int numVertices = graph.getNumVertices();
        int [] key = new int[numVertices];
        Integer [] parent = new Integer[numVertices];
        boolean [] visited = new boolean[numVertices];

        // Inicializa a chava com infinito, os pais com null e vertices visitados com false
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, null);
        Arrays.fill(visited, false);

        // Considerando o vertice 0 como a raiz
        key[0] = 0;

        // Fila de prioridade dos vertices
        PriorityQueue<Vertice> priorityQueue = new PriorityQueue<>(numVertices, Comparator.comparingInt(v -> v.getKey()));
        priorityQueue.add(new Vertice(0, 0));

        // Add no min heap os vertices com suas respectivas chaves
        for(int i = 1; i < numVertices; i++) {
            priorityQueue.add(new Vertice(i, key[i]));
        }

        while(!priorityQueue.isEmpty()) {
            int u = priorityQueue.poll().getVertice();
            List<Integer> adjVertices = graph.getAdjVertices(u);
            visited[u] = true;

            for (Integer adjVertex : adjVertices) {
                if(!visited[adjVertex] && graph.getAdjMtx()[u][adjVertex] < key[adjVertex]){
                    priorityQueue.remove(new Vertice(adjVertex, key[adjVertex]));
                    parent[adjVertex] = u;
                    key[adjVertex] = graph.getAdjMtx()[u][adjVertex];
                    priorityQueue.add(new Vertice(adjVertex, key[adjVertex]));
                }
            }
        }

        // Add as arestas na lista MST
        for (int i = 1; i < numVertices; i++) {
            mst.add(new Edge(parent[i], i, key[i]));
        }

        // Ordena as arestas da MST
        Collections.sort(mst);

        return mst;
    }
}
