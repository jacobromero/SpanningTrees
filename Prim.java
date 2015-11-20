
public class Prim {
	public int[] near;
	public int[][] cost;
	
	public void prim(){
		int[][] ret = new int[near.length][near.length];
		int minCost = 0;
		near[0] = -1;
		
		for(int i = 1; i < near.length; i++) near[i] = 0;
		
		for(int i = 0; i < near.length - 1; i++){
			//find closest (based on edge weight to i element and call it 'j'
			int min = -1;
			for(int j = 0; j < cost.length; j++){				
				if(j != i && near[j] != -1){
					if(min == -1 || cost[i][j] < cost[min][j])
						min = j;
				}
			}
			
			//TODO figure out using (T(), T())
			
			minCost = minCost + cost[min][near[min]];
			near[min] = -1;
			
			for(int k = 0; k < near.length; k++){
				if(near[k] != 0 && cost[k][near[k]] > cost[k][min])
					near[k] = min;
			}
		}
	}
}
