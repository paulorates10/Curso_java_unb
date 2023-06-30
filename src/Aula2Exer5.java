import java.util.Scanner;

public class Aula2Exer5 { // Classe CadastroContas
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Aula2Exer2 conta1 = new Aula2Exer2(1, 100.0); // Classe conta
        Aula2Exer2 conta2 = new Aula2Exer2(2, 100.0); // Classe conta
        ContaCorrente contaCorrente1 = new ContaCorrente(3, 100.0, 10000.0);
        ContaCorrente contaCorrente2 = new ContaCorrente(4, 100.0, 10000.0);

        System.out.println("Saldo inicial das contas:");
        System.out.println("Conta 1: R$" + conta1.getSaldo());
        System.out.println("Conta 2: R$" + conta2.getSaldo());
        System.out.println("Conta Corrente 1: R$" + contaCorrente1.getSaldo());
        System.out.println("Conta Corrente 2: R$" + contaCorrente2.getSaldo());

        System.out.print("\nDigite o valor para depósito na Conta 1: ");
        double valorDepositoConta1 = scanner.nextDouble();
        conta1.depositar(valorDepositoConta1);

        System.out.print("Digite o valor para saque na Conta 2: ");
        double valorSaqueConta2 = scanner.nextDouble();
        conta2.sacar(valorSaqueConta2);

        System.out.print("Digite o valor para depósito na Conta Corrente 1: ");
        double valorDepositoContaCorrente1 = scanner.nextDouble();
        contaCorrente1.depositar(valorDepositoContaCorrente1);

        System.out.print("Digite o valor para saque na Conta Corrente 2: ");
        double valorSaqueContaCorrente2 = scanner.nextDouble();
        contaCorrente2.sacar(valorSaqueContaCorrente2);

        System.out.println("\nSaldo atual das contas:");
        System.out.println("Conta 1: R$" + conta1.getSaldo());
        System.out.println("Conta 2: R$" + conta2.getSaldo());
        System.out.println("Conta Corrente 1: R$" + contaCorrente1.getSaldo());
        System.out.println("Conta Corrente 2: R$" + contaCorrente2.getSaldo());

        scanner.close();
    }
}
