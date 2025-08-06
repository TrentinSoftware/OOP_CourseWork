package AULA1.ATV1;
import java.util.Locale;
import java.util.Scanner;

public class EX3_CalcPI {
    public static void main(String[] args) {
        // CONST PI
        final double PI = 3.141592653589793;

        // Tive que fazer isso professor pois meu JAVA da máquina tava reconhecendo padrão BR
        // aí para não dar BO na sua maquina passei como arg definindo mesmo
        Scanner scanner = new Scanner(System.in).useLocale(Locale.forLanguageTag("pt-BR"));

        System.out.print("Digite o raio do círculo: ");
        double raio = scanner.nextDouble();

        // CALC PERIMETRO
        double perimetro = 2 * PI * raio;

        // CALC AREA
        double area = PI * Math.pow(raio, 2);

        System.out.printf("\nResultados para o círculo de raio %.2f:%n", raio);
        System.out.printf("Perímetro (circunferência): %.2f%n", perimetro);
        System.out.printf("Área: %.2f%n", area);

        scanner.close();
    }
}
