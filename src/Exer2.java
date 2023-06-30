import java.util.Scanner;

public class Exer2 {

	public static void main(String[] args) {

		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		int m = sc1.nextInt();
		int n = sc1.nextInt();
		int rd;
		int somatorioPar=0;
		for (int i = m; i <= n; i++) {

			rd = i % 2;
			if (rd == 0) {
				somatorioPar = somatorioPar + i;
			}
		}
		
	System.out.println("Somatório de numero pares até N:" + somatorioPar);
	sc1.close();
	sc2.close();
	}
}
