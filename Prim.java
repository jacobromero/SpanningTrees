import java.util.ArrayList;

public class Prim {
	public int[] near;
	public int[][] cost;
	ArrayList<Edge> e = new ArrayList<Edge>();
	
	public Prim(int[][] matrix){
		cost = matrix;
		near = new int[cost.length];
	}
	
	public ArrayList<Edge> prim(){
		int minCost = 0;
		near[0] = -1;
		
		for(int i = 1; i < near.length; i++) near[i] = 0;
		for(int i = 0; i < near.length - 1; i++){
			int minIndex = 1;
			//find closest (based on edge weight) and store indecies to u, v
			int tmpcost = 999;
			for(int j = 0; j < near.length; j++){
				if(near[j] != -1){
					if(cost[j][near[j]] < tmpcost){
						minIndex = j;
						tmpcost = cost[j][near[j]];
					}
				}
			}
			
			
			if(near[minIndex] == -1){
				System.out.println("No spanning tree");
				break;
			}
			if(cost[minIndex][near[minIndex]] == Integer.MAX_VALUE){
				System.out.println("No Spanning tree");
				break;
			}
//			e.add(new Edge(near[minIndex], minIndex));
			System.out.println(near[minIndex] + " connects to " + minIndex);
			//TODO figure out using (T(), T())
			
			
			minCost = minCost + cost[minIndex][near[minIndex]];
			near[minIndex] = -1;
			for(int k = 0; k < near.length; k++){
				if(near[k] != -1 && cost[k][near[k]] > cost[k][minIndex])
					near[k] = minIndex;
			}
		}
		
		System.out.println(minCost);
		return e;
	}
}
