package company.Tipco;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Given a collection of 1 million integers ranging from 1 to 9, how would you
 * sort them in Big O(n) time?
 * 
 * This is a typical Integer Sorting problem with a constraint that the number
 * range to sort is very limited in spite 1 million total entries. Integer
 * Sorting with limited range is achieved efficiently with Bucket Sorting.
 * 
 * @author nitin Using BucketSort
 */

public class SortingBigO_n {

	static public class BucketSort {
		public static int[] sort(int[] array, int min, int max) {
			int range = max - min + 1;
			int[] result = new int[range];
			System.out.println("arrays value" + Arrays.toString(result));
			for (int i : array) {
				System.out.println("Value" + result[i]);
				result[i]++;
				System.out.println("arrays value" + Arrays.toString(result));
			}
			return result;
		}
	}

	public static void main(String[] args) {
		SortingBigO_n bigO_n = new SortingBigO_n();
		bigO_n.testBucketSortFor1To9();
	}

	public void testBucketSortFor1To9() {
		int[] array = { 3, 4, 1, 3, 5, 6, 7, 2, 8, 10, 9 };
		BucketSort bucketSort = null;
		// int[] sort = new BucketSort().sort(array, 0, 15);
		// int[] sort = BucketSort.sort(array, 0, 15);
		int[] sort = bucketSort.sort(array, 0, 15);
		for (int i = 0; i < sort.length; i++) {
			for (int j = 0; j < sort[i]; j++) {
				System.out.println(i);
			}
		}
	}

}
