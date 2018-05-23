package io.icyhins.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Some examples:
 *
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * @author Silver.Kan
 */
public class EvaluateReversePolishNotation {
    /**
     * Solution main idea:
     *  loop the array
     *  if see a digit, store it.
     *  if see a operator, pop last 2 digits & store the calculation result
     *
     * */
    public int evalRPN(String[] tokens) {

        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i< tokens.length; i++){
         switch (tokens[i]){
             case "+": stack.push(stack.pop() + stack.pop());
                 break;
             case "-":
                 int a1 = stack.pop();
                 int b1 = stack.pop();
                 stack.push( b1- a1);
                 break;
             case "*": stack.push(stack.pop() * stack.pop());
                 break;
             case "/":
                 int a2 = stack.pop();
                 int b2 = stack.pop();
                 stack.push( b2/ a2);
                 break;
             default: stack.push(Integer.valueOf(tokens[i]));
                break;
         }
        }
        return stack.pop();
    }
}
