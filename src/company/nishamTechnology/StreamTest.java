package company.nishamTechnology;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
	public static void main(String[] args) {
		String str = "zzzzzbbbccccddehhhhiii";
		// first not repetable charactor

		Stream<Character> sss = str.chars().mapToObj(i -> (char) i);
		System.out.println(sss);
		char eee = str.chars().mapToObj(i -> Character.valueOf((char) i))
				.collect(Collectors.groupingBy((Function.identity()), Collectors.counting())).entrySet().stream()
				.filter(a -> a.getValue() == 1).map(b -> b.getKey()).findFirst().get();
		System.out.println(eee);

	}

}
