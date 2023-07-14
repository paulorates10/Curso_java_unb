interface FormatoAudio {
    void abrir(String arquivo);
    void reproduzir();
    void pausar();
    void parar();
}

class MP3Player implements FormatoAudio {
    private String arquivo;

    @Override
    public void abrir(String arquivo) {
        System.out.println("MP3Player: Abrindo arquivo " + arquivo);
        this.arquivo = arquivo;
    }

    @Override
    public void reproduzir() {
        System.out.println("MP3Player: Reproduzindo arquivo " + arquivo);
    }

    @Override
    public void pausar() {
        System.out.println("MP3Player: Pausando reprodução do arquivo " + arquivo);
    }

    @Override
    public void parar() {
        System.out.println("MP3Player: Parando reprodução do arquivo " + arquivo);
    }
}

class WAVPlayer implements FormatoAudio {
    private String arquivo;

    @Override
    public void abrir(String arquivo) {
        System.out.println("WAVPlayer: Abrindo arquivo " + arquivo);
        this.arquivo = arquivo;
    }

    @Override
    public void reproduzir() {
        System.out.println("WAVPlayer: Reproduzindo arquivo " + arquivo);
    }

    @Override
    public void pausar() {
        System.out.println("WAVPlayer: Pausando reprodução do arquivo " + arquivo);
    }

    @Override
    public void parar() {
        System.out.println("WAVPlayer: Parando reprodução do arquivo " + arquivo);
    }
}

public class Aula4Exer2 {
    public static void main(String[] args) {
        MP3Player mp3Player = new MP3Player();
        mp3Player.abrir("musica.mp3");
        mp3Player.reproduzir();
        mp3Player.pausar();
        mp3Player.parar();

        WAVPlayer wavPlayer = new WAVPlayer();
        wavPlayer.abrir("audio.wav");
        wavPlayer.reproduzir();
        wavPlayer.pausar();
        wavPlayer.parar();
    }
}
