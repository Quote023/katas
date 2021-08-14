package recursion;


/**
 *<strong>Description</strong>
 * <p>
 * A recursive algorithm that takes a String and returns true if it is a palindrome <br/>
 * <u>it should be case-insensitive.</u>
 * </p>
 *<br/>
 *<strong>Input Format:</strong>
 *<p>input: <font color="#54BED8">String</font></p>
 *<strong>Output Format:</strong>
 *<p>isPalindrome:  <font color="#54BED8">boolean</font></p>
 *<br/>
 *<strong>Constraints:</strong>
 *<ul>
 *    <li>You're not allowed to use any special data-structure implementation from the stdlib;</li>
 *    <li>The solution should be entirely recursive;</li>
 *</ul>
 *<br/>
 *<strong>Sample Inputs:</strong>
 * <font color="#91D37A">
 * <ol>
 *  <li>"osso"</li>
 *  <li>"O romano acata amores a damas amadas e Roma ataca o namoro."</li>
 *  <li>"Qualquer outra coisa que nao se encaixe."</li>
 *  <li>"Ole:\nMaracuja, caju, caramelo!"</li>
 *</ol>
 *</font>
 *<br/>
 *<strong>Sample Outputs:</strong>
 * <ol>
 *  <li><font color="#54BED8">True</font></li>
 *  <li><font color="#54BED8">True</font></li>
 *  <li><font color="#D27982">False</font></li>
 *  <li><font color="#54BED8">True</font></li>
 *  </ol>
 */
public class RecursivePalindromeChecker {

  public static final String INVALID_CHARS = "[^a-zA-Z]+";

  public static boolean checkPalindrome(String s) {
    String parsedWord = s.matches(".*" + INVALID_CHARS + ".*")
        ? s.replaceAll(INVALID_CHARS, "")
        : s;

    return checkPalindromeRec(parsedWord.toLowerCase());
  }

  private static boolean checkPalindromeRec(String s){
    if (s.length() <= 1) return true;
    if (s.charAt(0) != s.charAt(s.length() - 1)) return false;

    return checkPalindromeRec(s.substring(1, s.length() - 1));
  }


  public static void main(String[] args) {
    String[] textCases = {
        "osso",
        "O romano acata amores a damas amadas e Roma ataca o namoro.",
        "Qualquer outra coisa que nao se encaixe.",
        "Ole:\n Maracuja, caju, caramelo!",
    };

    boolean[] expectedResults = {true,true,false,true};

    for (int i = 0, textCasesLength = textCases.length; i < textCasesLength; i++) {
      String input = textCases[i];
      boolean result = checkPalindrome(input);

      String status = result == expectedResults[i] ? "\u001B[32m RIGHT!\u001B[0m" : "\u001B[31m WRONG!\u001B[0m";
      System.out.println(input + ": " +  result + status);
    }
  }
}
