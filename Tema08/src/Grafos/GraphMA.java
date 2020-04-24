package Grafos;

public class GraphMA implements IGraph {

	int numVertices;
	int maxVertices;
	boolean[][] matrix;
	boolean directed;

	public GraphMA(int n, int max, boolean d) {
		if (max <= 0)
			throw new IllegalArgumentException("Negative max number of vertices!!");
		if (n <= 0)
			throw new IllegalArgumentException("Negative number of vertices!!");
		if (n > max)
			throw new IllegalArgumentException("Number of vertices can never be greater than n");

		maxVertices = max;
		numVertices = n;
		matrix = new boolean[maxVertices][maxVertices];
		directed = d;
	}

	@Override
	public void addVertex() {
		if (numVertices == maxVertices) {
			System.out.println("Cannot add new vertices");
			return;
		}
		numVertices++;
	}

	private boolean checkVertex(int i) {
		if (i >= 0 && i < numVertices)
			return true;
		else
			return false;
	}

	@Override
	public void addEdge(int i, int j) {
		if (!checkVertex(i))
			throw new IllegalArgumentException("No existe este vertice" + i);
		if (!checkVertex(j))
			throw new IllegalArgumentException("No existe este vertice" + j);

		matrix[i][j] = true;
		if (!directed)
			matrix[j][i] = true;
	}

	@Override
	public boolean isEdge(int i, int j) {
		if (!checkVertex(i))
			throw new IllegalArgumentException("No existe este vertice" + i);
		if (!checkVertex(j))
			throw new IllegalArgumentException("No existe este vertice" + j);

		return matrix[i][j];
	}

	@Override
	public void removeEdge(int i, int j) {
		if (!checkVertex(i))
			throw new IllegalArgumentException("No existe este vertice" + i);
		if (!checkVertex(j))
			throw new IllegalArgumentException("No existe este vertice" + j);
		matrix[i][j] = false;
		if (!directed)
			matrix[j][i] = false;

	}

	@Override
	public int sizeVertices() {
		return numVertices;
	}

	@Override
	public int sizeEdges() {
		int numEdges = 0;
		if (directed) {
			for (int i = 0; i < numVertices; i++) {
				for (int j = 0; i < numVertices; j++) {
					if (matrix[i][j] != false)
						numEdges++;
				}
			}
		} else {
			for (int i = 0; i < numVertices; i++) {
				for (int j = 0; j < numVertices; j++) {
					if (matrix[i][j] != false)
						numEdges++;
				}

			}
		}
		return numEdges;
	}

	@Override
	public int getOutDegrees(int i) {
		if (!directed) {
			System.out.println("Graph non directed");
			return 0;
		}
		if (!checkVertex(i))
			throw new IllegalArgumentException("No existe este vertice" + i);
		int outdeg = 0;

		for (int col = 0; col < numVertices; col++) {
			if (matrix[i][col] != false)
				outdeg++;
		}
		return outdeg;
	}

	@Override
	public int getInDegrees(int i) {
		if (!directed) {
			System.out.println("Graph non directed");
			return 0;
		}
		if (!checkVertex(i))
			throw new IllegalArgumentException("No existe este vertice" + i);
		int indeg = 0;
		for (int row = 0; row < numVertices; row++) {
			if (matrix[row][i] != false)
				indeg++;
		}
		return indeg;
	}

	@Override
	public int getDegrees(int i) {
		if (!checkVertex(i))
			throw new IllegalArgumentException("No existe este vertice" + i);
		int degree = 0;
		if (directed)
			degree = getInDegrees(i) + getOutDegrees(i);
		else {
			for (int row = 0; row < numVertices; row++) {
				if (matrix[row][i] != false)
					degree++;
			}
		}
		return degree;
	}

	@Override
	public int[] getAdjacents(int i) {
		if (!checkVertex(i))
			throw new IllegalArgumentException("No existe este vertice" + i);
		int numAdjacents = 0;
		if (directed)
			numAdjacents = getOutDegrees(i);
		else
			numAdjacents = getDegrees(i);

		int[] adjacents = new int[numAdjacents];

		if (numAdjacents > 0) {
			int j = 0;
			for (int col = 0; col < numVertices; col++) {
				adjacents[j] = col;
				j++;
			}
		}
		return adjacents;
	}

}
