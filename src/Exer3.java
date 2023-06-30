import java.util.Scanner;
import java.util.Random;

public class Exer3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		
		int nRandom = rd.nextInt(100)+1;
		int n;
		System.out.println("numero secreto: " + nRandom);
		do {
			System.out.println("Advinhe o numero de 0 a 100 sorteado: ");
			n = sc.nextInt();
			
			if (n< nRandom ) {
					System.out.println("Você errou! DICA: O numéro é maior!");
			}else if(n> nRandom){
					System.out.println("Você errou! DICA: O numéro é menor! ");
			}else{
				System.out.println("Parabéns, você acertou!");				
			}
			
		}while (nRandom != n);
		
	sc.close();
	}
}
