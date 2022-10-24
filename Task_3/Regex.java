public class Regex {
	
	public static boolean isNum(String token) {
    if (token == null)
            return false;

    return token.matches("\\d+");
  }
	
	public static boolean isOP(String token) {
    if (token == null)
      return false;

    return token.matches("[\\*|\\/|\\+|\\-]");
  }

}