package com.dkl.chapter7;

public class Sort {

	
	public static void main(String[] args) {
		Integer a[] = { 1, 2, 53, 2, 34, 59, 0, 90, -1 };
		Character b[] = { 'Q', 'H', 'C', 'Y', 'P', 'A', 'M', 'S', 'R', 'D',
				'F', 'X' };
		// Integer a[] = { 90, 1, 32, 123, 2, 89, 76, 31, 90, 100 };
		quickSort(b);
		// for (int i = 0; i < a.length; i++) {
		// System.out.print(a[i] + " ");
		// }
		for (Character s : b) {
			System.out.print(s + " ");
		}
	}

	public static <T extends Comparable<? super T>> void insertionSort(T[] a) {

		int j;

		for (int i = 1; i < a.length; i++) {
			T temp = a[i];

			for (j = i; j > 0 && temp.compareTo(a[j - 1]) < 0; j--)
				a[j] = a[j - 1];
			a[j] = temp;
		}

	}

	/**
	 * Internal method for heapsort.
	 * 
	 * @param i
	 *            the index of an item in the heap.
	 * @return the index of the left child.
	 */
	private static int leftChild(int i) {
		return 2 * i + 1;
	}

	/**
	 * Internal method for heapsort that is used in deleteMax and buildHeap.
	 * 
	 * @param a
	 *            an array of Comparable items.
	 * @index i the position from which to percolate down.
	 * @int n the logical size of the binary heap.
	 */
	private static <T extends Comparable<? super T>> void percDown(T[] a,
			int i, int n) {
		int child;
		T temp;
		for (temp = a[i]; leftChild(i) < n; i = child) {
			child = leftChild(i);
			if (child != n - 1 && a[child].compareTo(a[child + 1]) < 0)
				child++;
			if (temp.compareTo(a[child]) < 0)
				a[i] = a[child];
			else
				break;
		}

		a[i] = temp;
	}

	/**
	 * Standard heapsort.
	 * 
	 * @param a
	 *            an array of Comparable items.
	 */
	public static <T extends Comparable<? super T>> void heapsort(T a[]) {
		/*
		 * bulid heap max
		 */
		for (int i = a.length / 2 - 1; i >= 0; i--)
			percDown(a, i, a.length);

		for (int i = 1; i < a.length; i++) {

			swapReferences(a, 0, a.length - i);
			percDown(a, 0, a.length - i);
		}
	}

	/**
	 * Method to swap to elements in an array.
	 * 
	 * @param a
	 *            an array of objects.
	 * @param index1
	 *            the index of the first object.
	 * @param index2
	 *            the index of the second object.
	 */
	private static <T> void swapReferences(T[] a, int left, int right) {

		T temp;
		temp = a[left];
		a[left] = a[right];
		a[right] = temp;

	}

	private static <T extends Comparable<? super T>> void mergeSort(T[] a,
			T[] temArray, int left, int right) {

		if (left < right) {
			int center = (left + right) / 2;

			mergeSort(a, temArray, left, center);
			mergeSort(a, temArray, center + 1, right);
			merge(a, temArray, left, center + 1, right);

		}
	}

	private static <T extends Comparable<? super T>> void merge(T[] a,
			T[] temArray, int leftPos, int rightPos, int rightEnd) {

		int temPos = leftPos;
		int leftEnd = rightPos - 1;
		int elementsNum = rightEnd - leftPos + 1;

		while (leftPos <= leftEnd && rightPos <= rightEnd)
			if (a[leftPos].compareTo(a[rightPos]) < 0)
				temArray[temPos++] = a[leftPos++];
			else
				temArray[temPos++] = a[rightPos++];

		while (leftPos <= leftEnd)
			temArray[temPos++] = a[leftPos++];
		while (rightPos <= rightEnd)
			temArray[temPos++] = a[rightPos++];

		for (int i = 0; i < elementsNum; i++, rightEnd--)
			a[rightEnd] = temArray[rightEnd];

	}

	private static <T extends Comparable<? super T>> void mergeSort(T[] a) {

		T[] temArray = (T[]) new Comparable[a.length];
		mergeSort(a, temArray, 0, a.length - 1);
	}

	public static <T extends Comparable<? super T>> void shellSort(T[] a) {
		for (int gap = a.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < a.length; i++) {
				T temp = a[i];
				int j;
				for (j = i; j >= gap; j -= gap) {
					if (temp.compareTo(a[j - gap]) < 0)
						a[j] = a[j - gap];
					else
						break;
				}
				a[j] = temp;
			}
		}
	}

	public static <T extends Comparable<? super T>> void quickSort(T[] a) {
		quickSort(a, 0, a.length - 1);
	}

	private static <T extends Comparable<? super T>> void quickSort(T[] a,
			int left, int right) {
		if (left + 3 <= right) {

			T pivot = median3(a, left, right);
			int i = left;
			int j = right - 1;
			for (;;) {
				/*
				 * 此处必须是 < 不能用 <=， 因为若 <= i递增会超过 right-1，也就是把 right -1 和 i
				 * 交换的时候，会违背了当初的意愿，这样会把中间数（分姐元素）交换到后面而不是中间
				 */
				while (a[++i].compareTo(pivot) < 0)
					;
				while (a[--j].compareTo(pivot) > 0)
					;
				if (i < j) {
					swapReferences(a, i, j);
				} else
					break;
			}
			swapReferences(a, i, right - 1);
			quickSort(a, left, i - 1);
			quickSort(a, i + 1, right);
		} else {

			insertionSort(a, left, right);
		}

	}

	private static <AnyType extends Comparable<? super AnyType>> void insertionSort(
			AnyType[] a, int left, int right) {
		for (int p = left + 1; p <= right; p++) {
			AnyType tmp = a[p];
			int j;

			for (j = p; j > left && tmp.compareTo(a[j - 1]) < 0; j--)
				a[j] = a[j - 1];
			a[j] = tmp;
		}
	}

	private static <T extends Comparable<? super T>> T median3(T[] a, int left,
			int right) {
		int center = (left + right) / 2;
		if (a[center].compareTo(a[left]) < 0)
			swapReferences(a, left, center);
		if (a[right].compareTo(a[left]) < 0)
			swapReferences(a, left, right);
		if (a[right].compareTo(a[center]) < 0)
			swapReferences(a, center, right);

		swapReferences(a, center, right - 1);

		return a[right - 1];

	}
}
/**
 * F H C D P A M Q R S Y X A D C F P H M Q R S Y X A D C F P H M Q R S Y X A C D
 * F P H M Q R S Y X A C D F M H P Q R S Y X A C D F H M P Q R S Y X A C D F H M
 * P Q R S Y X A C D F H M P Q R S Y X A C D F H M P Q R S X Y
 */
