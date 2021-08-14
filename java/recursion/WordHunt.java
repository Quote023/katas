package recursion;

/**
 *<strong>Description</strong>
 * <p>
 * Implement the method wordHunt such that it returns how many times the given <i>Word</i> appears in the given <i>Text</i> while not being followed by the <i>Restriction</i> <br/>
 * <u>it should be case-insensitive.</u>
 * </p>
 * <br/>
 *<strong>Input Format:</strong>
 *<p>input: <font color="#91D37A">{@code "{Text} {Word} {Restriction}"}</font></p>
 *<strong>Output Format:</strong>
 *<p>occurrences:  <font color="#54BED8">int</font></p>
 *<br/>
 *<strong>Constraints:</strong>
 *<ul>
 *    <li><i>Word</i> and <i>Restriction</i> should never be the same;</li>
 *    <li><i>Word</i> should always be a non-blank string;</li>
 *    <li><i>Text</i>, <i>Word</i> and <i>Restriction</i> should not countain spaces;</li>
 *    <li>You're not allowed to use any special data-structure implementation from the stdlib;</li>
 *    <li>The solution should be entirely recursive;</li>
 *</ul>
 *<br/>
 *<strong>Sample Inputs:</strong>
 * <font color="#91D37A">
 * <ol>
 *  <li>"EstruturaDeDados Dados java"</li>
 *  <li>"EstruturaDeDados dados java"</li>
 *  <li>"textorecursivotexto texto recursivo"</li>
 *  <li>"vovovo ovo omelete"</li>
 *  <li>"codigoDErecursaoRecursaoDeCODIGO codigo de"</li>
 *</ol>
 *</font>
 *<br/>
 *<strong>Sample Outputs:</strong>
 * <ol>
 *  <li>1</li>
 *  <li>1</li>
 *  <li>1</li>
 *  <li>2</li>
 *  <li>1</li>
 *  </ol>
 */
class WordHunt {

    public static int wordHunt(String input) {
      String[] fields = input.toLowerCase().split(" ");
        if (fields.length <= 1) return 0;
        // Optional Value
        String restriction  = fields.length >= 3 ? fields[2] : "";

        return wordHunt(fields[0],fields[1],restriction,0,-1);
    }

    private static int wordHunt(String text, String word, String restriction, int quantity, int lastIndex){
      int newIndex = text.indexOf(word, lastIndex + 1);
      if (newIndex == -1) return quantity;

      boolean valid  = text.substring(newIndex + word.length()).startsWith(restriction);

      return wordHunt(text , word , restriction , (quantity + (valid ? 0 : 1)), newIndex);
    }

    public static void main(String[] args) {
        String[] textCases = {
            "EstruturaDeDados Dados java",
            "EstruturaDeDados dados java",
            "textorecursivotexto texto recursivo",
            "vovovo ovo omelete",
            "codigoDErecursaoRecursaoDeCODIGO codigo de"
        };

        int[] expectedResults = {1,1,1,2,1};

        for (int i = 0, textCasesLength = textCases.length; i < textCasesLength; i++) {
            String input = textCases[i];
            int result = wordHunt(input);
            String status = result == expectedResults[i] ? "\u001B[32m RIGHT!\u001B[0m" : "\u001B[31m WRONG!\u001B[0m";

            System.out.println(input + ": " +  result + status);
        }
    }

}
