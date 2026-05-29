package Stack;

import java.util.Stack;

public class ReversePolishNotation {

    // Problem Statement
    // You are given an array of strings tokens that represents a valid arithmetic
    // expression in Reverse Polish Notation.
    // Return the integer that represents the evaluation of the expression.

    // The operands may be integers or the results of other operations.
    // The operators include '+', '-', '*', and '/'.
    // Assume that division between integers always truncates toward zero.

    // Example 1:
    // Input: tokens = ["1","2","+","3","*","4","-"]

    // Output: 5

    // Explanation: ((1 + 2) * 3) - 4 = 5
    // ie, operations are evaluated in order of appearance, not in the order of
    // precedence. operator after the operands.

    // Constraints:
    // 1 <= tokens.length <= 1000.
    // tokens[i] is "+", "-", "*", or "/", or a string representing an integer in
    // the range [-200, 200].

    public static void main(String[] args) {
        ReversePolishNotation solution = new ReversePolishNotation();
        String[] tokens = { "1", "2", "+", "3", "*", "4", "-" };
        int result = solution.evalRPN(tokens);
        System.out.println(result); // Output: 5
    }

    // Approach is to use a stack to keep track of the operands, when we encounter
    // an
    // operator, we pop the last two operands from the stack, perform the operation
    // and push the result back to the stack, at the end we should have only one
    // operand in the stack which is the final result of the expression
    // Time complexity is O(n) where n is the number of tokens in the input array,
    // since we need to iterate through all the tokens once
    // Space complexity is O(n) in the worst case when all the tokens are operands,
    // we will have n/2 operands in the stack at the end of the iteration, which is
    // O(n) space complexity
    public int evalRPN(String[] tokens) {
        Stack<Integer> arithmeticStack = new Stack<>();

        for (String token : tokens) {
            if (!isValidOperator(token)) {
                arithmeticStack.push(Integer.parseInt(token));
            } else {
                int numOne = arithmeticStack.pop();
                int numTwo = arithmeticStack.pop();
                int result = doOperation(numTwo, numOne, token);
                arithmeticStack.push(result);
            }
        }

        return arithmeticStack.isEmpty() ? 0 : arithmeticStack.pop();
    }

    private boolean isValidOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private int doOperation(int numOne, int numTwo, String operator) {
        return switch (operator) {
            case "+" -> numOne + numTwo;
            case "-" -> numOne - numTwo;
            case "*" -> numOne * numTwo;
            default -> numOne / numTwo;
        };
    }

}
