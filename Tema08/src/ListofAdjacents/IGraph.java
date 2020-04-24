package ListofAdjacents;

public interface IGraph {

	public int sizeVertices();
	
	public int getDegree(int i);
	public int getInDegree(int i);
	public int getOutDegree(int i);

	public void addEdge(int i, int j, float w);
	public void removeEdge(int i, int j);
	
	public boolean isEdge(int i, int j);
	public int[] getAdjacents(int i);
	
}