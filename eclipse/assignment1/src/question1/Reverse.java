package question1;

public class Reverse {
    public static String inverse(String s) {
        NodeStack<Character> stack = new NodeStack<Character>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(inverse(s)); 
    }
}
