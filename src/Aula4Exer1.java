class Veiculo {
    public void acelerar() {
        System.out.println("Aceler veículo...");
    }
}

class Carro extends Veiculo {
    @Override
    public void acelerar() {
        System.out.println("Velocidade máxima carro: 100 km/h");
    }
}

class Moto extends Veiculo {
    @Override
    public void acelerar() {
        System.out.println("Velocidade máxima moto: 60 km/h");
    }
}

public class Aula4Exer1 {
    public static void main(String[] args) {
        Carro meuCarro = new Carro();
        meuCarro.acelerar();

        Moto minhaMoto = new Moto();
        minhaMoto.acelerar();
    }
}
