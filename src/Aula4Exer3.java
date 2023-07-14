interface Comparavel {
    int comparar(Comparavel outro);
}

abstract class ObjetoComparavel implements Comparavel {
    // Implementação padrão do método comparar
    @Override
    public int comparar(Comparavel outro) {
        if (this == outro) {
            return 0;
        }
        return -1; // Implementação padrão retorna -1
    }
}

class Aluno extends ObjetoComparavel {
    private String nome;
    private int idade;

    public Aluno(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    // Implementação personalizada do método comparar para comparar a idade dos alunos
    @Override
    public int comparar(Comparavel outro) {
        if (outro instanceof Aluno) {
            Aluno outroAluno = (Aluno) outro;
            return Integer.compare(this.idade, outroAluno.idade);
        }
        return super.comparar(outro);
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }
}

public class Aula4Exer3 {
    public static void main(String[] args) {
        Aluno[] alunos = new Aluno[10];
        alunos[0] = new Aluno("Alice", 20);
        alunos[1] = new Aluno("Bob", 22);
        alunos[2] = new Aluno("Carol", 19);
        alunos[3] = new Aluno("David", 21);
        alunos[4] = new Aluno("Emma", 23);
        alunos[5] = new Aluno("Frank", 18);
        alunos[6] = new Aluno("Grace", 24);
        alunos[7] = new Aluno("Henry", 22);
        alunos[8] = new Aluno("Isabella", 20);
        alunos[9] = new Aluno("Jack", 19);

        Aluno alunoMaisVelho = maxIdade(alunos);
        Aluno alunoMaisNovo = minIdade(alunos);

        System.out.println("Aluno mais velho: " + alunoMaisVelho.getNome() + " (" + alunoMaisVelho.getIdade() + " anos)");
        System.out.println("Aluno mais novo: " + alunoMaisNovo.getNome() + " (" + alunoMaisNovo.getIdade() + " anos)");
    }

    public static Aluno maxIdade(Aluno[] alunos) {
        Aluno maxIdadeAluno = alunos[0];
        for (int i = 1; i < alunos.length; i++) {
            if (alunos[i].comparar(maxIdadeAluno) > 0) {
                maxIdadeAluno = alunos[i];
            }
        }
        return maxIdadeAluno;
    }

    public static Aluno minIdade(Aluno[] alunos) {
        Aluno minIdadeAluno = alunos[0];
        for (int i = 1; i < alunos.length; i++) {
            if (alunos[i].comparar(minIdadeAluno) < 0) {
                minIdadeAluno = alunos[i];
            }
        }
        return minIdadeAluno;
    }
}
