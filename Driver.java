import java.util.Arrays;
import java.util.Random;


public class Driver {
	//TODO make a function that will generate random graphs
	// needs to make n amount of nodes(specified), and e amount of edges
	//idea: create a node, then add new nodes until n is satisfied each node connects to the first one generated, this is n-1 e, then keep adding edges randomly till e is staisfied.
	public static void main(String[] args) {
		int[] a = {1, 210, 5, 20, 200, 49, 2029320, 20010, 10, 13};

		int[][] rand = randomGraph(5, 1f);
		
		Prim p = new Prim();
		
		p.cost = rand;
		
		p.prim();
		
//		for(int i = 0; i < rand.length; i++){
//			for(int j = 0; j < rand.length; j++){
//				System.out.print(rand[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		
//		Kruskal k = new Kruskal();
//		
//		k.heapSort(a);
//		
//		System.out.println(Arrays.toString(a));
	}
	
	public static int[][] randomGraph(int numNodes, float conRatio){
		Random rng = new Random();
		
		//calculate max connections possible
		int maxCon = (numNodes * (numNodes - 1))/2;
		
		//find out how many connections we want
		int con = (int)(maxCon * conRatio);
		
		
		int[][] matrix = new int[numNodes][numNodes];
		
		//initialize adjacency matrix to specified size with values -1
		for(int i = 0; i < numNodes; i++)
			for(int j = 0; j < numNodes; j++)
				matrix[i][j] = -1;
		
		//create random graph
		int count = 0;
		for(int i = 0; i < numNodes; i++){
			for(int j = i; j < numNodes; j++){
				if(i == j){
					matrix[i][j] = 0;
				}
				else if(count >= con)
					continue;
				else{
					int random = rng.nextInt(9) + 1;
					
					matrix[i][j] = random;
					matrix[j][i] = random;
					
					count++;
				}
			}
		}
		
		return matrix;
	}

}
