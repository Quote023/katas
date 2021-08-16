package lists;

import lists.implementations.LinkedList;

public class ReverseAtIndex {

  public static String reverseAtIndex(String numbers, int n) {
    String[] numArr = numbers.split(" ");
    if (n >= numArr.length) return numbers;

    LinkedList<String> list = new LinkedList<>();
    list.appendEnd(numArr);
    list.reverse(Math.max(n,0));

    return list.join(" ");
  }

  public static void main(String[] args) {
    String[][] textCases = {
      {"1 2 3 4 5 6 7 8" ," 2"},
      {"1 2 3 4 5 6 7 8" ," 7"},
      {"1 2 3 4 5 6 7 8" ,"-2"},
    };

    String[] expectedResults = {
      "1 2 8 7 6 5 4 3",
      "1 2 3 4 5 6 7 8",
      "8 7 6 5 4 3 2 1"
    };

    for (int i = 0, textCasesLength = textCases.length; i < textCasesLength; i++) {

      String[] input = textCases[i];

      String result = reverseAtIndex(input[0],Integer.parseInt(input[1].trim()));
      String status = result.equals(expectedResults[i]) ? "\u001B[32m RIGHT!\u001B[0m" : "\u001B[31m WRONG!\u001B[0m";

      System.out.println(String.join(" <> ",input) + " : [ " +  result + " ] " + status);
    }
  }

}
