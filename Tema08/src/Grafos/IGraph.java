package Grafos;

public interface IGraph {

	public int sizeVertices();
	public int sizeEdges();
	
	public int getDegrees(int i);
	public int getInDegrees(int i);
	public int getOutDegrees(int i);
	
	public void addVertex();
	public void addEdge(int i, int j);
	public void removeEdge(int i, int j);
	
	public boolean isEdge(int i, int j);
	public int[] getAdjacents(int i);
	
}
