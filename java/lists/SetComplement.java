package lists;

import lists.implementations.LinkedList;

public class SetComplement {

  public static String setComplement(String setA, String setB) {
    if (setB == null) return setA;
    if (setA == null) return "";

    LinkedList<String> list = new LinkedList<>();
    list.appendEnd(setA.split(" "));

    for (String val: setB.split(" ")) list.remove(val);

    list.distinct();
    return list.join(" ");
  }

  public static void main(String[] args) {
    String[][] textCases = {
      {"1 2 3 4 5" ,"2 3 5"},
      {"2 2 4 6 6 8" ,"4"},
    };

    String[] expectedResults = {"1 4", "2 6 8"};

    for (int i = 0, textCasesLength = textCases.length; i < textCasesLength; i++) {

      String[] input = textCases[i];

      String result = setComplement(input[0],input[1]);
      String status = result.equals(expectedResults[i]) ? "\u001B[32m RIGHT!\u001B[0m" : "\u001B[31m WRONG!\u001B[0m";

      System.out.println(String.join(" <> ",input) + " : [ " +  result + " ] " + status);
    }
  }
}
