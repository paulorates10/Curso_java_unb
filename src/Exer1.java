import java.util.Scanner;

public class Exer1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int rd;
		int somatorioPar=0;
		for (int i = 0; i <= n; i++) {

			rd = i % 2;
			if (rd == 0) {
				somatorioPar = somatorioPar + i;
			}
		}
		System.out.println("Somatório de numero pares até N:" + somatorioPar);
	sc.close();
	}
}
