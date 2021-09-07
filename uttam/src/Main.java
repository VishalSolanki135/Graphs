import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Main {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("c");
        stack.push("a");
        stack.push("b");
        System.out.println((char)'a' + stack.pop());
    }
}
