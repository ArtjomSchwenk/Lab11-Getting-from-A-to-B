package src;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.Collections;

public class WeightedGraph<V> {
    private final Map<V, List<Edge<V>>> adjacencyList;

    public WeightedGraph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addVertex(V vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    public void addEdge(V source, V destination, int weight) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(new Edge<>(destination, weight));
        adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>()).add(new Edge<>(source, weight));
    }

    public Set<V> getVertices() {
        return adjacencyList.keySet();
    }

    public List<Edge<V>> getEdges(V vertex) {
        return adjacencyList.getOrDefault(vertex, Collections.emptyList());
    }

    public static class Edge<V> {
        V destination;
        int weight;

        public Edge(V destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "destination=" + destination +
                    ", weight=" + weight +
                    '}';
        }
    }
}
