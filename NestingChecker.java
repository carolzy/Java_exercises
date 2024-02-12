/*
 * I attest that the code in this file is entirely my own except for the starter
 * code provided with the assignment and the following exceptions:
 * <Enter all external resources and collaborations here.>
 *
 * Note external code may reduce your score but appropriate citation is required
 * to avoid academic integrity violations. Please see the Course Syllabus as
 * well as the university code of academic integrity:
 *    https://catalog.upenn.edu/pennbook/code-of-academic-integrity/
 *
 * Signed,
 * Author: carol zhu    
 * Penn email: <zhu24y@seas.upenn.edu>
 * Date: 2024-02-11
 */

import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Arrays;


public class NestingChecker {

    public static NestingReport checkNesting(Queue<? extends Nestable> elements) {
        Stack<Nestable> stack = new Stack<>();

        if (elements == null) {
            // Return report for null input
            return new NestingReport(NestingReport.Status.NULL_INPUT, null, new Stack<>());
        }

        for (Nestable element : elements) {
            if (element == null) {
                // Return report for null item in the queue
                return new NestingReport(NestingReport.Status.NULL_ITEM, null, stack);
            }

            // Use NestEffect to determine if the element is an open or close marker
            if (element.getEffect() == Nestable.NestEffect.OPEN) {
                stack.push(element);
            } else if (element.getEffect() == Nestable.NestEffect.CLOSE) {
                if (stack.isEmpty() || !element.matches(stack.peek())) {
                    // Return report for invalid close
                    return new NestingReport(NestingReport.Status.INVALID_CLOSE, element, stack);
                } else {
                    stack.pop();
                }
            }
            // No need to check for NEUTRAL as it doesn't affect the nesting directly
        }

        if (!stack.isEmpty()) {
            // Return report for not terminated sequence
            return new NestingReport(NestingReport.Status.NOT_TERMINATED, null, stack);
        }

        // If none of the conditions are met, the sequence is valid
        return new NestingReport(NestingReport.Status.VALID, null, new Stack<>());
    }
}
