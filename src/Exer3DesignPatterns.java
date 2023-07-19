import java.util.ArrayList;
import java.util.List;

// Classe abstrata Componente
abstract class Componente {
    protected String nome;

    public Componente(String nome) {
        this.nome = nome;
    }

    public abstract void exibir();
}

// Classe Departamento que herda de Componente
class Departamento extends Componente {
    private List<Componente> componentes;

    public Departamento(String nome) {
        super(nome);
        componentes = new ArrayList<>();
    }

    public void adicionarComponente(Componente componente) {
        componentes.add(componente);
    }

    public void removerComponente(Componente componente) {
        componentes.remove(componente);
    }

    @Override
    public void exibir() {
        System.out.println("Departamento: " + nome);
        for (Componente componente : componentes) {
            componente.exibir();
        }
    }
}

// Classe Funcionario que herda de Componente
class Funcionario extends Componente {
    public Funcionario(String nome) {
        super(nome);
    }

    @Override
    public void exibir() {
        System.out.println("Funcionário: " + nome);
    }
}

// Exemplo de uso do Composite
public class Exer3DesignPatterns {
    public static void main(String[] args) {
        // Criando a estrutura organizacional
        Departamento departamentoRH = new Departamento("Recursos Humanos");
        Departamento departamentoTI = new Departamento("Tecnologia da Informação");
        Departamento departamentoVendas = new Departamento("Vendas");

        Funcionario funcionario1 = new Funcionario("João");
        Funcionario funcionario2 = new Funcionario("Maria");
        Funcionario funcionario3 = new Funcionario("Pedro");

        departamentoRH.adicionarComponente(funcionario1);
        departamentoRH.adicionarComponente(funcionario2);
        departamentoTI.adicionarComponente(funcionario3);

        departamentoVendas.adicionarComponente(funcionario1);

        // Exibindo a estrutura organizacional
        departamentoRH.exibir();
        System.out.println("---------------------");
        departamentoTI.exibir();
        System.out.println("---------------------");
        departamentoVendas.exibir();
    }
}
