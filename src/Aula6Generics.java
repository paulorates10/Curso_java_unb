 import java.io.File;
 import java.io.FileWriter;
 import java.io.IOException;
 import java.nio.file.Files;
 import java.nio.file.Path;
 import java.nio.file.Paths;
 import java.sql.Connection;
 import java.sql.DriverManager;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;


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
         try {
             FileWriter fileWriter = new FileWriter(nomeArquivo, true);
             fileWriter.write(dados + "\n");
             fileWriter.close();
             System.out.println("Dados salvos no arquivo: " + dados);
         } catch (IOException e) {
             System.out.println("Erro ao salvar os dados no arquivo.");
             e.printStackTrace();
         }
     }

     @Override
     public String recuperar() {
         try {
             Path path = Paths.get(nomeArquivo);
             byte[] bytes = Files.readAllBytes(path);
             String dados = new String(bytes);
             System.out.println("Dados recuperados do arquivo: " + dados);
             return dados;
         } catch (IOException e) {
             System.out.println("Erro ao recuperar os dados do arquivo.");
             e.printStackTrace();
             return null;
         }
     }
 }



 // Classe ArmazenamentoH2
 class ArmazenamentoH2 implements Armazenamento {
     private Connection connection;

     public ArmazenamentoH2() {
         // Configurar a conexão com o banco de dados H2
         try {
             connection = DriverManager.getConnection("jdbc:h2:~/meubanco", "usuario", "senha");
         } catch (SQLException e) {
             System.out.println("Erro ao conectar ao banco de dados H2.");
             e.printStackTrace();
         }
     }

     @Override
     public void salvar(String dados) {
         try {
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO tabela (dados) VALUES (?)");
             preparedStatement.setString(1, dados);
             preparedStatement.executeUpdate();
             preparedStatement.close();
             System.out.println("Dados salvos no banco H2: " + dados);
         } catch (SQLException e) {
             System.out.println("Erro ao salvar os dados no banco H2.");
             e.printStackTrace();
         }
     }

     @Override
     public String recuperar() {
         try {
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT dados FROM tabela");
             ResultSet resultSet = preparedStatement.executeQuery();
             String dados = "";
             while (resultSet.next()) {
                 dados += resultSet.getString("dados") + "\n";
             }
             resultSet.close();
             preparedStatement.close();
             System.out.println("Dados recuperados do banco H2: " + dados);
             return dados;
         } catch (SQLException e) {
             System.out.println("Erro ao recuperar os dados do banco H2.");
             e.printStackTrace();
             return null;
         }
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
