import java.util.Arrays;


public class Driver {
	//TODO make a function that will generate random graphs
	// needs to make n amount of nodes(specified), and e amount of edges
	//idea: create a node, then add new nodes until n is satisfied each node connects to the first one generated, this is n-1 e, then keep adding edges randomly till e is staisfied.
	public static void main(String[] args) {
		int[] a = {1, 210, 5, 20, 200, 49, 2029320, 20010, 10, 13};
		Kruskal k = new Kruskal();
		
		k.heapSort(a);
		
		System.out.println(Arrays.toString(a));
	}

}
