package AULA1.ATV1;

import java.util.Locale;
import java.util.Scanner;

public class EX5_ConvertCelsiusToFahrenheitAndKelvin {
    public static void main(String[] args) {
        // Tive que fazer isso professor pois meu JAVA da máquina tava reconhecendo padrão BR
        // aí para não dar BO na sua maquina passei como arg definindo mesmo
        Scanner scanner = new Scanner(System.in).useLocale(Locale.forLanguageTag("pt-BR"));

        System.out.print("Quantos graus Celsius?\n");
        double celso = scanner.nextDouble();

        // F = C * 9 / 5 + 32
        double farido = celso * 9 / 5 + 32;
        System.out.println("Em Fahrenheit são: " + farido);

        // K = C + 273.15
        double kelvin = celso + 273.15;
        System.out.println("Em Kelvin é: " + kelvin);
    }
}
