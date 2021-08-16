package lists;

import lists.implementations.LinkedList;

public class RecursiveFibonacciList {


  public static int fib(int n, LinkedList<Integer> memo) {
    if(n < memo.size()) { return memo.getAt(n);}
    int numero =  fib(n - 2,memo) + fib(n - 1,memo);
    memo.appendEnd(numero);
    return numero;
  }

  public static String fibonacci(int n) {
    if (n <= 1) return "0";
    if (n == 2) return "0 -> 1";

    LinkedList<Integer> fibList = new LinkedList<>();
    fibList.appendEnd(0);
    fibList.appendEnd(1);
    fibList.appendEnd(1);

    fib(n - 1,fibList);
    return fibList.join(" -> ");
  }

  public static void main(String[] args) {
    int[] inputs          = { 1,2,5 };
    String[] expectedResults = {
      "0",
      "0 -> 1",
      "0 -> 1 -> 1 -> 2 -> 3"
    };

    for (int i = 0, inputsLength = inputs.length; i < inputsLength; i++) {
      int input = inputs[i];
      String result = fibonacci(input);

      String status = result.equals(expectedResults[i]) ? "\u001B[32m RIGHT!\u001B[0m" : "\u001B[31m WRONG!\u001B[0m";
      System.out.println(input + ": " +  result + status);
    }
  }
}
