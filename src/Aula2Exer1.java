import aula3oo.heranca.Forma;

public class Aula2Exer1 extends Forma { // Classe Circulo
    private double raio;

    public Aula2Exer1(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double calcularArea() {
        return Math.PI * raio * raio;
    }

    public double calcularPerimetro() {
        return 2 * Math.PI * raio;
    }
}
