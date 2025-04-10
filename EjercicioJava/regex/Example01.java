package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Example01 {
	public static void main(String[] args) {
		String text = "hola";
		String regex = "[A-Za-z]*a+";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(text);
		boolean res = matcher.matches();
		System.out.println(res?"Sí":"NO");

	}
}
