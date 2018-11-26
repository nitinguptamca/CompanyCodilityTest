package company.TechMahendra;

import java.util.stream.IntStream;

public class GetLengthOfStringWithoutUsingExistingFunctionality {
	// How to get length of String without using existing String.length()
	public static void main(String[] args) {
		String s = "Auto"; /// "Auto-generated method stub";
		System.out.println(length(s));
		char ar[] = s.toCharArray();
		int count = 0;
		for (char c : ar) {
			++count;
		}
		System.out.println("Length of the string is : " + count);
		
		int counter = 0;
		String s1 = "something something";

		try{
		    for(; s.charAt(counter)!='\0'; counter++) ;

		}catch(Exception e){
		   //ArrayIndexOutOfBoundsException
		   System.out.println("Length: " + counter);
		}
		
		
	}

	static int length(String p) {
		int i = 0;
		boolean flag = true;
		try {
			while (flag) {
				char ch = p.charAt(i);
				i++;
				System.out.print("  " + ch);
			}

		} catch (Exception e) {
			return i;
		}
		return i;
	}
}
