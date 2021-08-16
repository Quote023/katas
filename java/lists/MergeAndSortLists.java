package lists;

import lists.implementations.LinkedList;

public class MergeAndSortLists {

  public static String mergeLists(String list1, String list2) {
    LinkedList<Integer> numbers = new LinkedList<>();

    for(String val : (list1 + " " + list2).split(" ")){
      Integer num = Integer.parseInt(val);
      if(!numbers.contains(num)) numbers.appendEnd(num);
    }

    numbers.sort((A,B) -> A > B);
    return numbers.join(" ");
  }

  public static void main(String[] args) {
    String[][] textCases = {
      {"1 4 2 6 7 9 10" ,"2 3 5 7 8 10"},
      {"231 50 92 501 4 334" ,"4 714 68 92 666"},
    };

    String[] expectedResults = {"1 2 3 4 5 6 7 8 9 10", "4 50 68 92 231 334 501 666 714"};

    for (int i = 0, textCasesLength = textCases.length; i < textCasesLength; i++) {

      String[] input = textCases[i];

      String result = mergeLists(input[0],input[1]);
      String status = result.equals(expectedResults[i]) ? "\u001B[32m RIGHT!\u001B[0m" : "\u001B[31m WRONG!\u001B[0m";

      System.out.println(String.join(" <> ",input) + " : [ " +  result + " ] " + status);
    }
  }

}
