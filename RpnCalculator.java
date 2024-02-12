/*
 * I attest that the code in this file is entirely my own except for the starter
 * code provided with the assignment and the following exceptions:
 * <Enter all external resources and collaborations here. Note external code may
 * reduce your score but appropriate citation is required to avoid academic
 * integrity violations. Please see the Course Syllabus as well as the
 * university code of academic integrity:
 *  https://catalog.upenn.edu/pennbook/code-of-academic-integrity/ >
 * Signed,
 * Author: Carol Zhu	
 * Penn email: <zhu24y@seas.upenn.edu>
 * Date: 2024-02-11
 */

import java.util.List;
import java.util.Stack;

public class RpnCalculator {

    public Integer evaluateExpression(List<String> expression) {
        // Check for null input list
        if (expression == null) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();

        for (String token : expression) {
            // Check for null elements in the list
            if (token == null) {
                return null;
            }

            // Check if the token is an operator
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // Operator needs at least two numbers in the stack
                if (stack.size() < 2) {
                    return null; // Invalid expression
                }

                int b = stack.pop(); // Second operand
                int a = stack.pop(); // First operand

                switch (token) {
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        if (b == 0) {
                            return null; // Division by zero
                        }
                        stack.push(a / b);
                        break;
                }
            } else {
                // The token should be a number
                try {
                    stack.push(Integer.parseInt(token));
                } catch (NumberFormatException e) {
                    return null; // Not a valid number
                }
            }
        }

        // After processing all tokens, there should be exactly one number left in the stack
        if (stack.size() != 1) {
            return null; // Invalid expression
        }

        return stack.pop(); // This is the result of the expression
    }
}