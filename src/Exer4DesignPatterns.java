// Interface DescontoStrategy
interface DescontoStrategy {
    double calcularDesconto(double valor);
}

// Classe concreta DescontoClienteRegular
class DescontoClienteRegular implements DescontoStrategy {
    private static final double DESCONTO_REGULAR = 0.05;

    @Override
    public double calcularDesconto(double valor) {
        return valor * DESCONTO_REGULAR;
    }
}

// Classe concreta DescontoClienteVIP
class DescontoClienteVIP implements DescontoStrategy {
    private static final double DESCONTO_VIP = 0.1;

    @Override
    public double calcularDesconto(double valor) {
        return valor * DESCONTO_VIP;
    }
}

// Classe concreta DescontoClientePremium
class DescontoClientePremium implements DescontoStrategy {
    private static final double DESCONTO_PREMIUM = 0.15;

    @Override
    public double calcularDesconto(double valor) {
        return valor * DESCONTO_PREMIUM;
    }
}

// Classe que utiliza a estratégia de desconto
class SistemaPagamento {
    private DescontoStrategy descontoStrategy;

    public void setDescontoStrategy(DescontoStrategy descontoStrategy) {
        this.descontoStrategy = descontoStrategy;
    }

    public double calcularValorComDesconto(double valor) {
        if (descontoStrategy == null) {
            throw new IllegalStateException("Estratégia de desconto não definida");
        }
        return valor - descontoStrategy.calcularDesconto(valor);
    }
}

// Exemplo de uso do Strategy
public class Exer4DesignPatterns {
    public static void main(String[] args) {
        // Criando instâncias das estratégias de desconto
        DescontoStrategy descontoRegular = new DescontoClienteRegular();
        DescontoStrategy descontoVIP = new DescontoClienteVIP();
        DescontoStrategy descontoPremium = new DescontoClientePremium();

        // Criando instância do sistema de pagamento
        SistemaPagamento sistemaPagamento = new SistemaPagamento();

        // Definindo a estratégia de desconto para clientes regulares
        sistemaPagamento.setDescontoStrategy(descontoRegular);
        double valorComDescontoRegular = sistemaPagamento.calcularValorComDesconto(100.0);
        System.out.println("Valor com desconto para cliente regular: " + valorComDescontoRegular);

        // Definindo a estratégia de desconto para clientes VIP
        sistemaPagamento.setDescontoStrategy(descontoVIP);
        double valorComDescontoVIP = sistemaPagamento.calcularValorComDesconto(100.0);
        System.out.println("Valor com desconto para cliente VIP: " + valorComDescontoVIP);

        // Definindo a estratégia de desconto para clientes premium
        sistemaPagamento.setDescontoStrategy(descontoPremium);
        double valorComDescontoPremium = sistemaPagamento.calcularValorComDesconto(100.0);
        System.out.println("Valor com desconto para cliente premium: " + valorComDescontoPremium);
    }
}
