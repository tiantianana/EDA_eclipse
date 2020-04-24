package ListofAdjacents;

import Grafos.GraphMA;
import java.util.Queue;
import java.util.List;

public class GraphLAFull implements IGraph{

	int numVertices;
	int maxVertices;

	DListVertex[] vertices;
	boolean directed;

	public <DLisVertex> GraphLAFull(int n, int max, boolean d) {
		if (max <= 0)
			throw new IllegalArgumentException("Negative max num of vertices!");
		if (n <= 0)
			throw new IllegalArgumentException("Negative number of vertices!");
		if (n > max)
			throw new IllegalArgumentException("n cant be greater than max");

		numVertices = max;
		vertices = new DListVertex[maxVertices];
		numVertices = n;

		for (int i = 0; i < numVertices; i++) {
			vertices[i] = new DListVertex();
		}
		directed = d;

	}

	private boolean checkVertex(int i) {
		if (i >= 0 && i < numVertices)
			return true;
		else
			return false;
	}

	@Override
	public int sizeVertices() {
		return numVertices;
	}

	@Override
	public int getDegree(int i) {
		int degree = 0;
		if (directed) {
			degree = getOutDegree(i) + getInDegree(i);
		} else
			degree = vertices[i].getSize();
		return degree;
	}

	@Override
	public int getInDegree(int i) {
		if (!checkVertex(i))
			throw new IllegalArgumentException("No existe este vertice" + i);
		int indegree = 0;
		for (int j = 0; j < numVertices; j++) {
			if (vertices[j].contains(i))
				indegree++;
		}
		return indegree;
	}

	@Override
	public int getOutDegree(int i) {
		if (!checkVertex(i))
			throw new IllegalArgumentException("No existe este vertice" + i);
		int outdegree = 0;
		outdegree = vertices[i].getSize();
		return outdegree;
	}

	@Override
	public void addEdge(int i, int j, float w) {
		if (!checkVertex(i))
			throw new IllegalArgumentException("No existe este vertice" + i);
		if (!checkVertex(j))
			throw new IllegalArgumentException("No existe este vertice" + j);

		vertices[i].addLast(j, w);

		if (!directed)
			vertices[j].addLast(i, w);
	}

	@Override
	public void removeEdge(int i, int j) {
		if (!checkVertex(i))
			throw new IllegalArgumentException("No existe este vertice" + i);
		if (!checkVertex(j))
			throw new IllegalArgumentException("No existe este vertice" + j);

		int index = vertices[i].getIndexOg(j);
		vertices[i].removeAt(index);

		if (!directed) {
			index = remove[j].getIndexOf(i);
			vertices[j].removeAt(index);
		}
	}

	@Override
	public boolean isEdge(int i, int j) {
		if (!checkVertex(i))
			throw new IllegalArgumentException("No existe este vertice" + i);
		if (!checkVertex(j))
			throw new IllegalArgumentException("No existe este vertice" + j);
		boolean result = vertices[i].contains(j);
		return result;
	}

	@Override
	public int[] getAdjacents(int i) {
		if (!checkVertex(i))
			throw new IllegalArgumentException("No existe este vertice" + i);
		int numAdjacents = vertices[i].getSize();

		int[] adjVertices = new int[numAdjacents];

		for (int j = 0; j < numAdjacents; j++) {
			adjVertices[j] = vertices[i].getVertexAt(j);
		}
		return adjVertices;
	}
	
	public void breadth() {
		System.out.println("breadth");
		boolean visited[] = new boolean[numVertices];
		
		for(int i=0; i<numVertices; i++) {
			if(!visited[i]) {
				breadth(i, visited);
				System.out.println();
			}
		}
	}
	
	protected void breadth(int i, boolean[] visited) {
		boolean stored[] = new boolean[numVertices];
		System.out.println("bread traverse for" +i);
		SQueue q = new SQueue();
		q.enqueue(i);
		
		while(!q.isEmpty()) {
			int vertex = q.dequeue();
			System.out.println(vertex);
			visited[vertex] = true;
			
			int[] adjacents = getAdjacents(vertex);
			for(int adjVertex: adjacents) {
				if(!visited[adjVertex] && !stored[adjVertex]) {
					q.enqueue(adjVertex);
					stored[adjVertex] = true;
				}
			}
		}
		
	}
	
	public void depth() {
		System.out.println("depth");
		boolean visited[] new boolean[numVertices];
		for(int i=0; i<numVertices; i++) {
			if(!visited[i]) depth(i, visited);
		}
	}

	protected void depth(int i, boolean[] visited) {
		System.out.println(i);
		visited[i] = true;
		int[] adjacents = getAdjacents(i);
		for(int adjV: adjacents) {
			if(!visited[adjV]) {
				depth(adjV, visited);
			}
		}
	}
}
