import java.util.Scanner;

public class Exer5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite uma palavra ou frase: ");
        String input = scanner.nextLine();

        
        String frase = input.replaceAll("\\s+", "").toLowerCase();
        
        boolean isPalindrome = checkPalindrome(frase);

        if (isPalindrome) {
            System.out.println("É um palíndromo!");
        } else {
            System.out.println("Não é um palíndromo!");
        }

        scanner.close();
    }

    private static boolean checkPalindrome(String input) {
        int length = input.length();

        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
