

public class Kruskal {
	//cost adjacency matrix, representing the graph
	public int[][] costMatrix;
	
	//array representing the nodes or their parents
	public int[] nodes;
	//array representing an edge between two nodes
	public Edge[] edges;
	public int [] height;
	
	//constructor for creating a kruskal graph
	public Kruskal(int[][] mat, int nodeNum, float f){
		costMatrix = mat;
		nodes = new int[nodeNum];
		height = new int[nodeNum];
		initNodes();
		initHeight();
		
		//calculate max connections possible
		int maxCon = (nodeNum * (nodeNum - 1))/2;
		
		//find out how many connections we want
		int con = (int)(maxCon * f);
		edges = new Edge[con];
		
		//get the edges of each node
		getEdges();
	}
	public void krusAlgo(){
		//sort the edges by their cost
		heapSort(edges);
		
		//start from the first edge
		int i = 0;
		int minCost = 0;
		
		//see if a spanning tree is even possible, min edges should = n - 1 edges
		int minEdges = nodes.length - 1;
		if(edges.length  < minEdges){
			System.out.println("No spanning tree");
			return;
		}
		
		//search through nodes all nodes, while we still have edges left
		int count = 0;
		while(i < nodes.length && count < edges.length){
			//find the smallest edge, and then "delete it by increasing the counting index
			Edge nextSmallest = edges[count++];
			
			//get the root of the tree that nodes u and v are in
			int j = find2(nextSmallest.u);
			int k = find2(nextSmallest.v);
			
			//if the nodes are not parents of each other
			if(j != k){
				i++;
				
				//TODO figure out how to use (T(), T())
				System.out.println(j + " connects to " + k);
				
				//calculate min cost
				minCost = minCost + nextSmallest.cost;
				//merge the trees
				merge3(j,k);
			}
		}
		
		System.out.println(minCost);
	}
	
	//will be used to select minimum cost edge
	public void heapSort(Edge[] array){
		//heapifiy the entire array
		for(int i = (array.length)/2; i >= 0; i--){
			heapifiy(array, i, array.length - 1);
		}
		
		//swap the largest element to the top of the array, and heapifiy everything else
		for(int i = array.length - 1; i > 0; i--){
			swap(array, i, 0);
			heapifiy(array, 0, i-1);
		}
	}
	
	//swap two edges
	private void swap(Edge[] array, int i, int j) {
		Edge tmp = array[j];
		array[j] = array[i];
		array[i] = tmp;
	}
	
	//create a heap out of the array
	public void heapifiy(Edge[] array, int i, int end) {
		int leftchild = 2 * (i) + 1;
		int rightchild = 2 * (i) + 2;
		
		int largest = i;
		
		if(leftchild <= end && array[leftchild].cost > array[i].cost)
			largest = leftchild;
		
		if(rightchild <= end && array[rightchild].cost > array[largest].cost)
			largest = rightchild;
		
		if(largest != i){
			swap(array, i, largest);
			heapifiy(array, largest, end);
		}
	}
	
	//find the parent of the node passed in
	public int find2(int x){
		int i = x;
		while(nodes[i] != i)
			i = nodes[i];
		
		return i;
	}
	
	//merge the the nodes into one tree, selecting the one with the lowest height
	public void merge3(int indexA, int indexB){
		if(height[indexA] == height[indexB]){
			nodes[indexB] = indexA;
			height[indexA] = height[indexA] + 1;
		}
		else if(height[indexA] > height[indexB]){
			nodes[indexB] = indexA;
		}
		else{
			nodes[indexA] = indexB;
		}
	}
	
	//initialize the height array of each to 0
	public void initHeight(){
		for(int i = 0; i < height.length; i++)
			height[i] = 0;
	}
	
	//initialize the node array to themselves
	public void initNodes(){
		for(int i = 0; i < nodes.length; i++)
			nodes[i] = i;
	}
	
	//get the edges from the cost adjacency matrix
	public void getEdges(){
		int count = 0;
		for(int i = 0; i < costMatrix.length; i++){
			for(int j = i; j < costMatrix.length; j++){
				if(i == j){
					continue;
				}
				else if(costMatrix[i][j] != Integer.MAX_VALUE){
					edges[count] = new Edge(i, j, costMatrix[i][j]);
					count++;
				}
			}
		}
	}
}
