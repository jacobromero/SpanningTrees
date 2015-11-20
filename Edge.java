
public class Edge {
	int u;
	int v;
	
	int cost;
	
	public Edge(int u, int v){
		this.u = u;
		this.v = v;
	}
	
	public Edge(int u, int v, int cost){
		this.u = u;
		this.v = v;
		this.cost = cost;
	}
}
