package company.optUM;

//Find missing number in series
public class FindMissingNumber {

	public static void main(String[] args) {
		int a[] = { 1, 2, 4, 5, 6 };
		int miss = getMissingNo(a, 5);
		System.out.println(miss);

		int a1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 10 };
		int missnumber = getMissingNo(a1, 9);
		System.out.println(missnumber);

	}

	// Function to ind missing number
	// sum of all natural number;
	static int getMissingNo(int a[], int n) {
		int i, total;
		total = (n + 1) * (n + 2) / 2;
		for (i = 0; i < n; i++)
			total -= a[i];
		return total;
	}
}
