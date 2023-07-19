
// Exercício 1
interface Armazenamento {
    void salvar(String dados) throws IOException;
    String recuperar() throws IOException;

    static Armazenamento createArmazenamento(String tipo) {
        if (tipo.equalsIgnoreCase("Arquivo")) {
            return new ArmazenamentoArquivo();
        } else if (tipo.equalsIgnoreCase("H2")) {
            return new ArmazenamentoH2();
        } else {
            throw new IllegalArgumentException("Tipo de armazenamento inválido");
        }
    }
}

