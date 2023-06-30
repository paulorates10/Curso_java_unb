public class Aula2Exer4 { // Classe CadastroAlunos
	
    public static void main(String[] args) {
        
        Aluno aluno1 = new Aluno();
        Aluno aluno2 = new Aluno("João", "2021001", "Engenharia Civil");

        System.out.println("Informações do aluno 1:");
        aluno1.exibirInformacoes();

        System.out.println("\nInformações do aluno 2:");
        aluno2.exibirInformacoes();
    }
}



class Aluno {
    private String nome;
    private String matricula;
    private String curso;

    public Aluno() {
        this.nome = "";
        this.matricula = "";
        this.curso = "";
    }

    public Aluno(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    public void exibirInformacoes() {
        System.out.println("Nome: " + nome);
        System.out.println("Matrícula: " + matricula);
        System.out.println("Curso: " + curso);
    }
}


