// Classe abstrata Operacao
 abstract class Operacao {
    public abstract double executa(double num1, double num2);
}

// Classe Soma
 class Soma extends Operacao {
    @Override
    public double executa(double num1, double num2) {
        return num1 + num2;
    }
}

// Classe Subtracao
 class Subtracao extends Operacao {
    @Override
    public double executa(double num1, double num2) {
        return num1 - num2;
    }
}

// Classe Multiplicacao
 class Multiplicacao extends Operacao {
    @Override
    public double executa(double num1, double num2) {
        return num1 * num2;
    }
}

// Classe Divisao
 class Divisao extends Operacao {
    @Override
    public double executa(double num1, double num2) {
        return num1 / num2;
    }
}

// Classe Exponenciacao
 class Exponenciacao extends Operacao {
    @Override
    public double executa(double num1, double num2) {
        return Math.pow(num1, num2);
    }
}

// Classe Percent
 class Percent extends Operacao {
    @Override
    public double executa(double num1, double num2) {
        return (num1 / 100) * num2;
    }
}

// Interface Armazenamento
 interface Armazenamento {
    void salvar(String dados);
    String recuperar();
}

// Classe ArmazenamentoArquivo
 class ArmazenamentoArquivo implements Armazenamento {
    private String nomeArquivo;

    public ArmazenamentoArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    @Override
    public void salvar(String dados) {
        // Lógica para salvar os dados em arquivo
        System.out.println("Dados salvos no arquivo: " + dados);
    }

    @Override
    public String recuperar() {
        // Lógica para recuperar os dados do arquivo
        return "Dados recuperados do arquivo";
    }
}

// Classe ArmazenamentoH2
 class ArmazenamentoH2 implements Armazenamento {
    @Override
    public void salvar(String dados) {
        // Lógica para salvar os dados no banco H2
        System.out.println("Dados salvos no banco H2: " + dados);
    }

    @Override
    public String recuperar() {
        // Lógica para recuperar os dados do banco H2
        return "Dados recuperados do banco H2";
    }
}

// Classe Calculadora
class Calculadora {
    private Operacao operacao;

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }

    public double calcular(double num1, double num2) {
        return operacao.executa(num1, num2);
    }
}

// Classe principal
public class Aula6Generics {
    public static void main(String[] args) {
        // Exercício 1: Operações básicas
        Calculadora calculadora = new Calculadora();

        // Soma
        calculadora.setOperacao(new Soma());
        double resultadoSoma = calculadora.calcular(10, 5);
        System.out.println("Resultado da soma: " + resultadoSoma);

        // Subtração
        calculadora.setOperacao(new Subtracao());
        double resultadoSubtracao = calculadora.calcular(10, 5);
        System.out.println("Resultado da subtração: " + resultadoSubtracao);

        // Multiplicação
        calculadora.setOperacao(new Multiplicacao());
        double resultadoMultiplicacao = calculadora.calcular(6, 2);
        System.out.println("Resultado da multiplicação: " + resultadoMultiplicacao);

        // Divisão
        calculadora.setOperacao(new Divisao());
        double resultadoDivisao = calculadora.calcular(15, 3);
        System.out.println("Resultado da divisão: " + resultadoDivisao);

        // Exercício 2: Operações adicionais
        // Exponenciação
        calculadora.setOperacao(new Exponenciacao());
        double resultadoExponenciacao = calculadora.calcular(2, 3);
        System.out.println("Resultado da exponenciação: " + resultadoExponenciacao);

        // Percentual
        calculadora.setOperacao(new Percent());
        double resultadoPercent = calculadora.calcular(10, 40);
        System.out.println("Resultado do percentual: " + resultadoPercent);

        // Exercício 3: Armazenamento em arquivo
        Armazenamento arquivo = new ArmazenamentoArquivo("dados.txt");
        arquivo.salvar("Dados importantes");
        String dadosArquivo = arquivo.recuperar();
        System.out.println("Dados recuperados do arquivo: " + dadosArquivo);

        // Exercício 4: Armazenamento no banco H2
        Armazenamento banco = new ArmazenamentoH2();
        banco.salvar("Dados confidenciais");
        String dadosBanco = banco.recuperar();
        System.out.println("Dados recuperados do banco H2: " + dadosBanco);
    }
}
