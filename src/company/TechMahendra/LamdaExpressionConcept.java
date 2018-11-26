package company.TechMahendra;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

///String.length using Lambda expression 
///Check lambda concept.

public class LamdaExpressionConcept {
	public static void main(String[] args) {
		String s223 = "java lambda concept check";
		/**********************************************************/
		/// int length =(String s) ->s.length();///The target type of this expression
		/// must be a functional interface
		// but when we use inside stream its perfectly valid
		/**********************************************************/
		List<String> l = new ArrayList<>();
		l.add("successfully");
		l.add("easy");
		l.add("fortune");
		List<String> filtered = l.stream().filter(s -> s.length() > 5).collect(Collectors.toList());
		System.out.println(filtered);
		
		
	}
}
