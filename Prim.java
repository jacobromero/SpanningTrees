
public class Prim {
	public int[] near;
	public int[][] cost;
	
	public void prim(){
		int minCost = 0;
		near[0] = -1;
		
		for(int i = 1; i < near.length; i++) near[i] = 0;
		
		for(int i = 0; i < near.length - 1; i++){
			//find closest (based on edge weight to i element and call it 'j'
			int j = -1; //placeholder
			//
			minCost = minCost + cost[j][near[j]];
			near[j] = -1;
			
			for(int k = 0; k < near.length; k++){
				if(near[k] != 0 && cost[k][near[k]] > cost[k][j])
					near[k] = j;
			}
		}
	}
}
