public class Aula2Exer2 { // Classe conta
    private int numero;
    private double saldo;

    public Aula2Exer2(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }
}


class ContaCorrente extends Aula2Exer2 {
    private double limite;

    public ContaCorrente(int numero, double saldo, double limite) {
        super(numero, saldo);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public void sacar(double valor) {
        if (valor <= getSaldo() + limite) {
            super.sacar(valor);
        } else {
            System.out.println("Saldo insuficiente!");
        }
    }
}
