import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Interface Armazenamento
interface Armazenamento {
    void salvar(String dados) throws IOException;
    String recuperar() throws IOException;
}

// Classe ArmazenamentoArquivo que implementa a interface Armazenamento
class ArmazenamentoArquivo implements Armazenamento {
    @Override
    public void salvar(String dados) throws IOException {
        // Implementação para salvar dados em arquivo
        System.out.println("Salvando dados em arquivo: " + dados);
    }

    @Override
    public String recuperar() throws IOException {
        // Implementação para recuperar dados de arquivo
        return "Dados recuperados do arquivo";
    }
}

// Classe ArmazenamentoH2 que implementa a interface Armazenamento
class ArmazenamentoH2 implements Armazenamento {
    @Override
    public void salvar(String dados) throws IOException {
        // Implementação para salvar dados no banco H2
        System.out.println("Salvando dados no H2: " + dados);
    }

    @Override
    public String recuperar() throws IOException {
        // Implementação para recuperar dados do banco H2
        return "Dados recuperados do H2";
    }
}

// Classe Calculadora
class Calculadora {
    private Armazenamento armazenamento;

    public Calculadora(Armazenamento armazenamento) {
        this.armazenamento = armazenamento;
    }

    public void salvarDados(String dados) throws IOException {
        armazenamento.salvar(dados);
    }

    public String recuperarDados() throws IOException {
        return armazenamento.recuperar();
    }
}

// Interface ArmazenamentoFactory
interface ArmazenamentoFactory {
    Armazenamento criarArmazenamento();
}

// Classe ArmazenamentoArquivoFactory que implementa a interface ArmazenamentoFactory
class ArmazenamentoArquivoFactory implements ArmazenamentoFactory {
    @Override
    public Armazenamento criarArmazenamento() {
        return new ArmazenamentoArquivo();
    }
}

// Classe ArmazenamentoH2Factory que implementa a interface ArmazenamentoFactory
class ArmazenamentoH2Factory implements ArmazenamentoFactory {
    @Override
    public Armazenamento criarArmazenamento() {
        return new ArmazenamentoH2();
    }
}

// Exemplo de uso do Factory Pattern
public class Exer5DesignPatterns2 {
    public static void main(String[] args) {
        // Criando a Calculadora com Armazenamento em Arquivo
        ArmazenamentoFactory armazenamentoArquivoFactory = new ArmazenamentoArquivoFactory();
        Calculadora calculadoraArquivo = new Calculadora(armazenamentoArquivoFactory.criarArmazenamento());

        try {
            calculadoraArquivo.salvarDados("Dados importantes");
            String dadosArquivo = calculadoraArquivo.recuperarDados();
            System.out.println("Dados recuperados do arquivo: " + dadosArquivo);
        } catch (IOException e) {
            System.out.println("Erro ao manipular arquivo: " + e.getMessage());
        }

        // Criando a Calculadora com Armazenamento no H2
        ArmazenamentoFactory armazenamentoH2Factory = new ArmazenamentoH2Factory();
        Calculadora calculadoraH2 = new Calculadora(armazenamentoH2Factory.criarArmazenamento());

        try {
            calculadoraH2.salvarDados("Dados confidenciais");
            String dadosH2 = calculadoraH2.recuperarDados();
            System.out.println("Dados recuperados do H2: " + dadosH2);
        } catch (IOException e) {
            System.out.println("Erro ao manipular H2: " + e.getMessage());
        }
    }
}
