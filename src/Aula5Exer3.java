import java.util.HashMap;
import java.util.Map;

public class Aula5Exer3 {
    public static void main(String[] args) {
        Map<String, Integer> tabelaPontuacao = new HashMap<>();
        tabelaPontuacao.put("Time A", 10);
        tabelaPontuacao.put("Time B", 15);
        tabelaPontuacao.put("Time C", 8);
        tabelaPontuacao.put("Time D", 12);
        tabelaPontuacao.put("Time E", 9);

        String timeComMaiorPontuacao = findTeamWithHighestScore(tabelaPontuacao);
        System.out.println("Time com maior pontuação: " + timeComMaiorPontuacao);
    }

    public static String findTeamWithHighestScore(Map<String, Integer> tabelaPontuacao) {
        String timeComMaiorPontuacao = null;
        int maiorPontuacao = Integer.MIN_VALUE;

        for (Map.Entry<String, Integer> entry : tabelaPontuacao.entrySet()) {
            if (entry.getValue() > maiorPontuacao) {
                maiorPontuacao = entry.getValue();
                timeComMaiorPontuacao = entry.getKey();
            }
        }

        return timeComMaiorPontuacao;
    }
}
