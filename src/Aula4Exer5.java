interface ProcessadorPagamento {
    void processarPagamento(double valor);
}

class PagamentoCartao implements ProcessadorPagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento via cartão de crédito no valor de R$" + valor);
        // Lógica específica para processamento de pagamento via cartão de crédito
    }
}

class PagamentoBoleto implements ProcessadorPagamento {
    @Override
    public void processarPagamento(double valor) {
        System.out.println("Processando pagamento via boleto bancário no valor de R$" + valor);
        // Lógica específica para processamento de pagamento via boleto bancário
    }
}

public class Aula4Exer5 {
    public static void main(String[] args) {
        ProcessadorPagamento processadorCartao = new PagamentoCartao();
        processadorCartao.processarPagamento(100.0);

        ProcessadorPagamento processadorBoleto = new PagamentoBoleto();
        processadorBoleto.processarPagamento(150.0);
    }
}
