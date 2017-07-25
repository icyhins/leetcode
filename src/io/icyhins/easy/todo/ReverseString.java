package io.icyhins.easy.todo;

/**
 * Write a function that takes a string as input and returns the string reversed.

 Example:
 Given s = "hello", return "olleh".
 */
public class ReverseString {

    /**
     * This problem examines the knowledge points of StringBuilder
     * */
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }

}
