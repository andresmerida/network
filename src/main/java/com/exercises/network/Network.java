package com.exercises.network;

import java.util.HashMap;
import java.util.HashSet;
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

    public void connect(Integer startVertex, Integer destinationVertex) {
        if (!this.adjacencyMap.containsKey(startVertex) || !this.adjacencyMap.containsKey(destinationVertex)) {
            throw new IllegalArgumentException();
        }

        this.adjacencyMap.get(startVertex).add(destinationVertex);
        this.adjacencyMap.get(destinationVertex).add(startVertex);
    }

    public boolean query(Integer startVertex, Integer destinationVertex) {
        if (!this.adjacencyMap.containsKey(startVertex) || !this.adjacencyMap.containsKey(destinationVertex)) {
            throw new IllegalArgumentException();
        }

        return false;
    }
}
