import java.util.Arrays;


public class Kruskal {
	//???????????????????
	public int[] edges;
	
	
	public void krusAlgo(){
		
	}
	
	public void heapSort(int[] array){
		for(int i = (array.length)/2; i >= 0; i--){
			heapifiy(array, i, array.length - 1);
		}
		System.out.println(Arrays.toString(array));
		for(int i = array.length - 1; i > 0; i--){
			swap(array, i, 0);
			heapifiy(array, 0, i-1);
			System.out.println(Arrays.toString(array));
		}
	}
	
	private void swap(int[] array, int i, int j) {
		int tmp = array[j];
		array[j] = array[i];
		array[i] = tmp;
	}

	public void heapifiy(int[] array, int i, int end) {
		int leftchild = 2 * (i) + 1;
		int rightchild = 2 * (i) + 2;
		
		int largest = i;
		
		if(leftchild <= end && array[leftchild] > array[i])
			largest = leftchild;
		
		if(rightchild <= end && array[rightchild] > array[largest])
			largest = rightchild;
		
		if(largest != i){
			swap(array, i, largest);
			heapifiy(array, largest, end);
		}
	}
	

	
	public void merge3(int indexA, int indexB){
		
	}
}
