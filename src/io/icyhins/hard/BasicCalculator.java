package io.icyhins.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 *
 * The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .
 *
 * You may assume that the given expression is always valid.
 *
 * Some examples:
 *      "1 + 1" = 2
 *      " 2-1 + 2 " = 3
 *      "(1+(4+5+2)-3)+(6+8)" = 23
 *
 * Note: Do not use the eval built-in library function.
 */
public class BasicCalculator {

    public static void main(String[] args){
        BasicCalculator obj = new BasicCalculator();
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(obj.calculate(s));
        System.out.println(obj.evalInFix(s.toCharArray()));

    }

    /**
     * Solution main idea:
     *  Such as  ((3+4)*5-4*6)+1
     *  we use 2 stacks to store "(",")" & operator "+","-","*","/"
     *
     *  [(,(,+] -> meet ")" -> [(] -> [(,*] -> meet "-" lower than "*"
     *  [3,4]                  [7]    [7,5]
     *
     *  -> [(,-] -> [(,-,*] -> meet ")" -> [(,-]    ->[]    -> [+]   -> []
     *     [35,4]   [35,4,6]               [35,24]    [11]     [11,1] -> [12]
     *
     *
     *
     * */
    public int calculate(String s) {

        Deque<Character> opStack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();

        for(int i = 0;i < s.length(); i++){
            switch (s.charAt(i)){
                case '(':
                    opStack.push(s.charAt(i));
                    break;
                case ')':
                    //Calculate before ')'
                    while (opStack.peek() != '('){
                        numStack.push(cal(opStack.pop(), numStack.pop(), numStack.pop()));
                    }
                    opStack.pop();//Pop '('
                    break;
                //Calculate for priority
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!opStack.isEmpty() && isLowerThan(s.charAt(i), opStack.peek())){
                        numStack.push(cal(opStack.pop(), numStack.pop(), numStack.pop()));
                    }
                    opStack.push(s.charAt(i));
                    break;
                default:
                    numStack.push(Character.getNumericValue(s.charAt(i)));
                    break;
            }
        }

        //Calculate all numbers rest in stack
        while (!opStack.isEmpty()){
            numStack.push(cal(opStack.pop(), numStack.pop(), numStack.pop()));
        }

        return  numStack.pop();
    }

    //Mini Calculate
    private int cal(char op, Integer num1, Integer num2){
        if( op == '+'){
            return num1 + num2;
        }else if(op == '-'){
            return num2 - num1;
        }else if(op == '*'){
            return num1 * num2;
        } else {
            return num2 / num1;
        }
    }

    //Compare operator priority
    private boolean isLowerThan(char current, char toPeek){
        return ((toPeek == '*' || toPeek == '/') && (current == '+' || current == '-'))
                || ((toPeek == '+' || toPeek == '-') && (current == '+' || current == '-'))
                || ((toPeek == '*' || toPeek == '/') && (current == '*' || current == '/'));
    }

    public int evalInFix(char[] tokens) {
        //Corner Case Checked
        Deque<Integer> valStack = new LinkedList<Integer>();//Stack to store numbers
        Deque<Character> opStack = new LinkedList<Character>();//Stack to store operators
        for(int i = 0; i < tokens.length; i++){

            if (tokens[i] == '(') { //Case 1: '('​
                opStack.offerLast(tokens[i]);
            } else if (tokens[i] == ')') { //Case 2: ')'​
                while (opStack.peekLast() != '(') {
                    valStack.offerLast(cal(opStack.pollLast(), valStack.pollLast(), valStack.pollLast()));
                }
                opStack.pollLast();//Poll '('​
            } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {// Case 3: Operators other than parentheses ​
                while (!opStack.isEmpty() && isLowerThan2(tokens[i], opStack.peekLast())) {
                    valStack.offerLast(cal(opStack.pollLast(), valStack.pollLast(), valStack.pollLast()));
                }
                opStack.offerLast(tokens[i]);//Offer current operator
            } else {//Case 4: number
                valStack.offerLast(Integer.parseInt(Character.toString(tokens[i])));
            }
        }
        //Calculate all numbers rest in stack
        while (!opStack.isEmpty()) {
            valStack.offerLast(cal(opStack.pollLast(), valStack.pollLast(), valStack.pollLast()));
        }

        return valStack.pollLast();
    }

    private boolean isLowerThan2(char cur, char toPeek) {
        return (toPeek == '*' || toPeek == '/') && (cur == '+' || cur == '-');
    }



}
