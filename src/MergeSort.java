

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.RecursiveAction;

public class MergeSort<T extends Comparable<T>> extends RecursiveAction {

	public static int TH = 10;
	private T[] array;
	private int low;
	private int high;

	public MergeSort(T[] a, int l, int h) {
		array = a;
		low = l;
		high = h;
	}

	public void compute() {
		//CASO BASE
		if ((high - low) < TH) {
			Arrays.sort(array, low, high,Collections.reverseOrder());
		}
		//CASO RECURSIVO
		else {
			int mid = low + ((int)(high-low)/2);			
			MergeSort<T> left = new MergeSort<T>(array, low, mid);
			MergeSort<T> right = new MergeSort<T>(array, mid, high);
			
			left.fork();
			right.compute();
			left.join();

			merge(mid);
		}
	}
	
	private void merge(int mid) {
		if (array[mid - 1].compareTo(array[mid]) < 0) {
			int totalLength = high - low;
			int firstLength = mid - low;
			T[] copy = (T[])new Comparable[totalLength];
			System.arraycopy(array, low, copy, 0, copy.length);
			int p = 0;
			int q = firstLength;
			for (int i = low; i < high; ++i) {
				if (q >= totalLength || (p < firstLength && copy[p].compareTo(copy[q]) > 0))
					array[i] = copy[p++];
				else
					array[i] = copy[q++];
			}
		}
	}
}
