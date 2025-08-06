package AULA1.ATV1;
import java.util.Scanner;
import java.util.Locale;

public class EX4_CalcIMC {
    public static void main(String[] args) {
        // Tive que fazer isso professor pois meu JAVA da máquina tava reconhecendo padrão BR
        // aí para não dar BO na sua maquina passei como arg definindo mesmo
        Scanner scanner = new Scanner(System.in).useLocale(Locale.forLanguageTag("pt-BR"));

        System.out.print("Em KG qual seu peso (Ex: 84,5):\n");
        double peso = scanner.nextDouble();

        System.out.print("Em Metros qual sua altura (use vírgula, EX: 1,78):\n");
        double altura = scanner.nextDouble();

        double resultado = peso / (altura * altura);
        System.out.println("O seu IMC é: " + resultado);
    }
}
