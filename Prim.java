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
			//find closest (based on edge weight) node to the current node, and save it to near array
			int tmpcost = 999;
			for(int j = 0; j < near.length; j++){
				if(near[j] != -1){
					if(cost[j][near[j]] < tmpcost){
						minIndex = j;
						tmpcost = cost[j][near[j]];
					}
				}
			}
			
			//if the node is near a node called -1 then it is not connect to anything, and we don't have a spanning tree.
			if(near[minIndex] == -1){
				System.out.println("No spanning tree");
				break;
			}

			
//			e.add(new Edge(near[minIndex], minIndex));
			System.out.println(near[minIndex] + " connects to " + minIndex);			
			
			//find the min cost of the spanning tree
			minCost = minCost + cost[minIndex][near[minIndex]];
			
			//set the nearest node to the one we just selected to -1 so we don't select it again
			near[minIndex] = -1;
			//update all nodes in the near array to see if the new node we added can provide a shorter path
			for(int k = 0; k < near.length; k++){
				if(near[k] != -1 && cost[k][near[k]] > cost[k][minIndex])
					near[k] = minIndex;
			}
		}
		
		//print the min cost of the graph
		System.out.println(minCost);
		return e;
	}
}
