	package regex;
	
	import java.util.regex.Pattern;
	
	public class Example02 {
	public static void main(String[] args) {
		String text="SugamPoudel5$$€@gmail.com";
		String regex="^[a-zA-Z0-9._$€]+@[a-zA-Z0-9]+\\.[a-zA-Z]{2,3}$";
		if(Pattern.matches(regex, text)) {
			System.out.println("EL texto es valido");
		}else {
			System.out.println("NO es valido!!");
		}
	}
	}
