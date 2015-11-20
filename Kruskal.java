import java.util.Arrays;


public class Kruskal {
	//edge object that has a cost, and two int's one being u, the other v
	public int[][] costMatrix;
	
	//temp array
	public int[] nodes;
	public Edge[] edges;
	public int [] height;
	
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
		System.out.println(con);
		edges = new Edge[con];
		
		getEdges();
		
		
	}
	public void krusAlgo(){
		heapSort(edges);
		int i = 0;
		int minCost = 0;
		
		int count = 0;
		while(i < nodes.length && count < edges.length){
			Edge nextSmallest = edges[count++];
			
			int j = find2(nextSmallest.u);
			int k = find2(nextSmallest.v);
			
			if(j != k){
				i++;
				
				//TODO figure out how to use (T(), T())
				System.out.println(j + " connects to " + k);
				
				minCost = minCost + nextSmallest.cost;
				merge3(j,k);
			}
		}
		
	}
	
	//will be used to select minimum cost edge
	public void heapSort(Edge[] array){
		for(int i = (array.length)/2; i >= 0; i--){
			heapifiy(array, i, array.length - 1);
		}
//		System.out.println(Arrays.toString(array));
		for(int i = array.length - 1; i > 0; i--){
			swap(array, i, 0);
			heapifiy(array, 0, i-1);

//			System.out.println(Arrays.toString(array));
		}
	}
	
	private void swap(Edge[] array, int i, int j) {
		Edge tmp = array[j];
		array[j] = array[i];
		array[i] = tmp;
	}

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
	
	public int find2(int x){
		int i = x;
		while(nodes[i] != i)
			i = nodes[i];
		
		return i;
	}
	
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
	
	public void initHeight(){
		for(int i = 0; i < height.length; i++)
			height[i] = 0;
	}
	
	public void initNodes(){
		for(int i = 0; i < nodes.length; i++)
			nodes[i] = i;
	}
	
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
