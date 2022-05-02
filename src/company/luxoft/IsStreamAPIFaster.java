package company.luxoft;

import java.util.Arrays;
import java.util.stream.Stream;

import CtCI6thEdition1.CtCILibrary.AssortedMethods;

public class  {
	IsStreamAPIFaster
	public static int[] array = AssortedMethods.randomArray(9999999, 1, 9);

	public static void main(String[] args) {
		int[] a = array;
		int e = a.length;
		int m = Integer.MIN_VALUE;
		System.out.println(System.nanoTime());
		Long start = System.nanoTime();
		for (int i = 0; i < e; i++)
			if (a[i] > m)
				m = a[i];

		System.out.println((System.nanoTime() - start) / 100000 + " calculation time" + m);
		start = System.nanoTime();
		m=Arrays.stream(array).reduce(Integer.MIN_VALUE, Math::max);
		System.out.println((System.nanoTime() - start) / 100000 + " calculation time" + m);
		Stream<Integer> aaa=Arrays.stream(array).boxed();
		start = System.nanoTime();
		m=aaa.parallel().reduce(Integer.MIN_VALUE, Math::max);
		System.out.println((System.nanoTime() - start) / 100000 + " calculation time" + m);

	}

}
