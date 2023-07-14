import java.util.Stack;

public class Aula5Exer4 {
    public static void main(String[] args) {
        String input1 = "(){[()]}";
        String input2 = "()[]{";
        String input3 = "[{}()]";

        System.out.println("A string " + input1 + " é válida? " + isValid(input1));
        System.out.println("A string " + input2 + " é válida? " + isValid(input2));
        System.out.println("A string " + input3 + " é válida? " + isValid(input3));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else if (c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else {
                return false; // Encontrou um caractere de fechamento sem correspondência
            }
        }

        return stack.isEmpty(); // A string é válida se a pilha estiver vazia no final
    }
}
