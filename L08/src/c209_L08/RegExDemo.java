package c209_L08;

import java.util.regex.Pattern;

public class RegExDemo {

	public static void main(String[] args) {
		
		String pattern = "[abc][0-9]{3}";
//		String input = "abc";
//
//		boolean matched = Pattern.matches(pattern, input);
//		System.out.println("Result: "+ matched);

		String s = Helper.readStringRegEx("Enter >", pattern);
		System.out.println("You will see this if your pattern matched!");
	}
}

