package com.exercises.network;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Network {
    private final HashMap<Integer, Set<Integer>> adjacencyMap;

    public Network(int numberOfElements) {
        this.adjacencyMap = new HashMap<>();
        for (int i = 0; i < numberOfElements; i++) {
            this.addVertex(i+1);
        }
    }

    public void addVertex(Integer vertex) {
        if (this.adjacencyMap.containsKey(vertex)) {
            throw new IllegalArgumentException("Vertex already exist.");
        }

        this.adjacencyMap.put(vertex, new HashSet<Integer>());
    }

    public Iterable<Integer> getNeighbors(Integer v) {
        return this.adjacencyMap.get(v);
    }

    /**
     * Add new connection between vertex. Adding new connection from startVertex to destinationVertex will
     * automatically add new connection from destinationVertex to startVertex since the graph is undirected.
     *
     * @param startVertex Start vertex.
     * @param destinationVertex Destination vertex.
     */
    public void connect(Integer startVertex, Integer destinationVertex) {
        if (!this.adjacencyMap.containsKey(startVertex) || !this.adjacencyMap.containsKey(destinationVertex)) {
            throw new IllegalArgumentException();
        }

        this.adjacencyMap.get(startVertex).add(destinationVertex);
        this.adjacencyMap.get(destinationVertex).add(startVertex);
    }

    /**
     * check if startVertex and destinationVertex are connected directly or indirectly
     *
     * @param startVertex Start vertex.
     * @param destinationVertex Destination vertex.
     */
    public boolean query(Integer startVertex, Integer destinationVertex) {
        if (!this.adjacencyMap.containsKey(startVertex) || !this.adjacencyMap.containsKey(destinationVertex)) {
            throw new IllegalArgumentException();
        }

        boolean[] visited = new boolean[adjacencyMap.size()+1];
        visited[startVertex] = true;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            Integer currentVertex = queue.poll();
            for (Integer neighborVertex : this.getNeighbors(currentVertex)) {
                if (neighborVertex.equals(destinationVertex)) {
                    return true;
                }

                if (!visited[neighborVertex]) {
                    queue.offer(neighborVertex);
                    visited[neighborVertex] = true;
                }
            }
        }

        return false;
    }
}
