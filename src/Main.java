import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Graph graph = null;
        String path = "src\\graph2.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            int vertice = 0, source = 0, dest = 0, weight = 0;

            System.out.println("Arestas do arquivo txt");
            while(line != null) {
                if(!line.startsWith("//")) {

                    String[] parts = line.split(" ");

                    if(parts.length < 2) {
                        vertice = Integer.parseInt(line);
                        graph = new Graph(vertice);
                    } else {
                        source = Integer.parseInt(parts[0]);
                        dest = Integer.parseInt(parts[1]);
                        weight = Integer.parseInt(parts[2]);
                        graph.addEdge(source, dest, weight);
                        System.out.printf("%d <-> %d, %d %n", source, dest, weight);
                    }
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        Prim p = new Prim();

        System.out.println();
        System.out.println("------ Arvore MST ------ \n");
        System.out.println("  Aresta    Peso");
        for (Edge edge : p.primMst(graph)) {
            System.out.println(edge);
        }
    }
}