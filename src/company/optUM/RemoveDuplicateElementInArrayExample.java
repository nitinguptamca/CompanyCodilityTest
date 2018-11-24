package company.optUM;

import java.util.Arrays;

/*Remove duplicate element optimize solution
* I have written this program to remove the duplicates from an unsorted array.
* First Approach sorting array using quick sort and then remove duplicate.
*/
public class RemoveDuplicateElementInArrayExample {
	public static void main(String[] args) {
		int[] arr = { 4, 3, 4, 2, 6, 1, 1, 7, 6, 8, 9, 9, 1, 1, 3, 4, 7, 8, 2 };
		System.out.println(Arrays.toString(arr));
		// perform quick sort for o(n log n) time.
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
		// now remove the duplicate elements.
		// arr = removeDuplicates(arr);
		arr = removeDuplicatesUp1(arr);
		System.out.println("Unique elements in Array :" + Arrays.toString(arr));
	}

	private static int[] removeDuplicatesUp1(int[] arr) {
		if (arr.length <= 1) {
			return arr;
		}
		int lastFound = arr[0];
		int currPos = 1;
		for (int i = 1; i < arr.length; ++i) {
			int num = arr[i];
			if (lastFound != num) {
				lastFound = num;
				arr[currPos++] = num;
			}
		}

		return Arrays.copyOf(arr, currPos);
	}

	/** Quick sort function **/
	public static void quickSort(int arr[], int low, int high) {
		int i = low, j = high;
		int pivot = arr[(low + high) / 2];

		/** partition **/
		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				/** swap **/
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

				i++;
				j--;
			}
		}

		/** recursively sort lower half **/
		if (low < j)
			quickSort(arr, low, j);
		/** recursively sort upper half **/
		if (i < high)
			quickSort(arr, i, high);
	}

}
