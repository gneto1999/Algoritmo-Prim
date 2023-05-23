public class Edge implements Comparable<Edge>{
    private int source;
    private int dest;
    private int weight;

    public Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public int getDest() {
        return dest;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return source + "  <-->  " + dest + ", " + weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return Integer.compare(source, edge.source);
    }
}
