package company.parkarConsultant;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringReverseOrder {
	public static void main1(String[] args) {
		String name="NitinKumarGupta";
		byte[]  nameByte=name.getBytes();
		byte [] result =  new byte [nameByte.length]; 
		 for (int i = 0; i<nameByte.length; i++) 
	            result[i] =  
	            		nameByte[nameByte.length-i-1]; 
	  
	        System.out.println(new String(result)); 
	}
	
	public static void main2(String[] args) {
		String input = "GeeksForGeeks"; 
	    // convert String to character array 
        // by using toCharArray 
        char[] try1 = input.toCharArray(); 
  
        for (int i = try1.length-1; i>=0; i--) 
            System.out.print(try1[i]); 
	}
	
	public static void main(String[] args) {
		String input = "GeeksForGeeks"; 
	    
		IntStream try1 = input.chars();
		Stream<Integer> try2=input.chars().boxed();
		Map<Character, Long> frequencies=input.chars().boxed().collect(Collectors.groupingBy(k -> Character.valueOf((char)k.intValue()),  LinkedHashMap::new, Collectors.counting()));
		Map<Character, Integer> frequencies1=input.chars().boxed().collect(Collectors.toMap(k -> Character.valueOf((char) k.intValue()) , v ->1 ,Integer::sum));
		Map<Character, Long> freqqquencies2 = input.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
	}


}
