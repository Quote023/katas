package recursion;


/**
 *<strong>Description</strong>
 * <p>
 * A recursive algorithm that takes a String and returns true if it contains no brackets or all of them are balanced <br/>
 * Ex: <font color="#91D37A">"[[[]]]"</font>
 * </p>
 * <br/>
 *<strong>Input Format:</strong>
 *<p>input: <font color="#54BED8">String?</font></p>
 *<strong>Output Format:</strong>
 *<p>balanced:  <font color="#54BED8">boolean</font></p>
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
 *  <li>"[[]]"</li>
 *  <li>"[[[x]]"</li>
 *  <li>"[[[][]"</li>
 *</ol>
 *</font>
 *<br/>
 *<strong>Sample Outputs:</strong>
 *
 * <ol>
 *  <li><font color="#54BED8">True</font></li>
 *  <li><font color="#D27982">False</font></li>
 *  <li><font color="#D27982">False</font></li>
 *  </ol>
 */
public class BalancedBrackets {
  // every non-bracket characeter
  public static final String INVALID_CHARS = "[^\\[\\]]+";


  public static boolean isBalanced(String input) {
    if(input == null) return true;

    String parsetInput = input.matches(".*" + INVALID_CHARS + ".*")
        ? input.replaceAll(INVALID_CHARS, "")
        : input;

    return isBalancedRec(parsetInput);
  }

  private static boolean isBalancedRec(String input){
    int length = input.length();
    // Base cases
    if (length == 0) return true;
    if (length == 1) return false;
    if (input.charAt(0) == ']' || input.charAt(length - 1) == '[') return false;

    return isBalancedRec(input.replace("[]", ""));
  }

  public static void main(String[] args) {
    String[] textCases = {
        "[[]]",
        "[[[x]]",
        "[[[][]",
    };

    boolean[] expectedResults = {true,false,false};

    for (int i = 0, textCasesLength = textCases.length; i < textCasesLength; i++) {
      String input = textCases[i];
      boolean result = isBalanced(input);

      String status = result == expectedResults[i] ? "\u001B[32m RIGHT!\u001B[0m" : "\u001B[31m WRONG!\u001B[0m";
      System.out.println(input + ": " +  result + status);
    }
  }
}
