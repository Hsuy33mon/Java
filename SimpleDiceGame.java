package classEx5;
import java.util.Scanner;

public class SimpleDiceGame {

	public static void main(String[] args) {
		System.out.println("SImple Dice Game");
		System.out.println("----------------");
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter your name: ");
		String name = sc.next();
		Dice d1 = new Dice();
		d1.roll();
		d1.whoWon(name);
		sc.close();
	}
}
