import java.util.Scanner;

public class Exer4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o endereço de email: ");
        String email = scanner.nextLine();
        
        int marcador = email.indexOf("@");
        String dominio = email.substring(marcador + 1);

        System.out.println("Domínio: " + dominio);

        scanner.close();
    }
}