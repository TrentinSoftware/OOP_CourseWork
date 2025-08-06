package AULA1.ATV1;
import java.util.Scanner;

public class EX2_SendHelloUser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Qual seu nome? ");
        String userInput = scanner.nextLine();

        System.out.println("Olá, " + userInput);

        scanner.close();
    }
}
