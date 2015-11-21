import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class Driver {
	static //TODO make a function that will generate random graphs
	// needs to make n amount of nodes(specified), and e amount of edges
	//idea: create a node, then add new nodes until n is satisfied each node connects to the first one generated, this is n-1 e, then keep adding edges randomly till e is staisfied.
	Edge[] e;
	public static void main(String[] args) {
		int nodes = 20;
		float connectedRatio = 1f; 

		int[][] rand = randomGraph(nodes, connectedRatio);
		
		getEdges(rand);
		
//		System.out.println(e[1].cost);
		
		Prim p = new Prim(rand);
		
		p.cost = rand;

		p.prim();
		
//		for(int i = 0; i < rand.length; i++){
//			for(int j = 0; j < rand.length; j++){
//				System.out.print(rand[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
//		ArrayList<Edge> e = p.prim();
//		
//		for(Edge ed : e){
//			System.out.println(ed.u + " connects to " + ed.v);
//		}
		
		for(int i = 0; i < rand.length; i++){
			for(int j = 0; j < rand.length; j++){
				if(rand[i][j] == Integer.MAX_VALUE){
					System.out.print("_ ");
				}
				else
					System.out.print(rand[i][j] + " ");
			}
			System.out.println();
		}
		
//		System.out.println(rand[v][u]);
		
		Kruskal k = new Kruskal(rand, nodes, connectedRatio);
//
		k.krusAlgo();
		
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
		e = new Edge[con];
		
		int[][] matrix = new int[numNodes][numNodes];
		
		//initialize adjacency matrix to specified size with values -1
		for(int i = 0; i < numNodes; i++)
			for(int j = 0; j < numNodes; j++)
				matrix[i][j] = Integer.MAX_VALUE;
		
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
					int random = rng.nextInt(100) + 1;
					
					matrix[i][j] = random;
					matrix[j][i] = random;
					
					count++;
				}
			}
		}
		
		return matrix;
	}
	
	public static void getEdges(int[][] costMatrix){
		int count = 0;
		for(int i = 0; i < costMatrix.length; i++){
			for(int j = i; j < costMatrix.length; j++){
				if(i == j){
					continue;
				}
				else if(costMatrix[i][j] != Integer.MAX_VALUE){
					e[count] = new Edge(i, j, costMatrix[i][j]);
					count++;
				}
			}
		}
	}

}
