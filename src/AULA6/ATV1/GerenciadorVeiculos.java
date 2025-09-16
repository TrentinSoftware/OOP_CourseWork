import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe base Veículo
class Veiculo {
    protected int ano;
    protected String modelo;
    protected String cor;
    protected String placa;
    protected double valorFIPE;

    public Veiculo(int ano, String modelo, String cor, String placa, double valorFIPE) {
        this.ano = ano;
        this.modelo = modelo;
        this.cor = cor;
        this.placa = placa;
        this.valorFIPE = valorFIPE;
    }

    public double calcularIPVA() {
        return valorFIPE * 0.02;
    }

    public String toFileString() {
        return ano + ";" + modelo + ";" + cor + ";" + placa + ";" + valorFIPE;
    }

    public static Veiculo fromFileString(String linha) {
        String[] dados = linha.split(";");
        if (dados.length != 5) return null;

        try {
            int ano = Integer.parseInt(dados[0]);
            String modelo = dados[1];
            String cor = dados[2];
            String placa = dados[3];
            double valorFIPE = Double.parseDouble(dados[4]);

            return new Veiculo(ano, modelo, cor, placa, valorFIPE);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Ano: " + ano +
                ", Modelo: " + modelo +
                ", Cor: " + cor +
                ", Placa: " + placa +
                ", Valor FIPE: R$" + String.format("%.2f", valorFIPE) +
                ", IPVA: R$" + String.format("%.2f", calcularIPVA());
    }
}

// Subclasse Carro
class Carro extends Veiculo {
    private int cavalos;
    private int portas;

    public Carro(int ano, String modelo, String cor, String placa, double valorFIPE, int cavalos, int portas) {
        super(ano, modelo, cor, placa, valorFIPE);
        this.cavalos = cavalos;
        this.portas = portas;
    }

    @Override
    public double calcularIPVA() {
        int anoAtual = 2024; // Supondo o ano atual como 2024
        if ((anoAtual - ano) > 20) {
            return 0; // Isento para carros com mais de 20 anos
        }
        return super.calcularIPVA();
    }

    @Override
    public String toFileString() {
        return "C;" + super.toFileString() + ";" + cavalos + ";" + portas;
    }

    public static Carro fromFileString(String linha) {
        String[] dados = linha.split(";");
        if (dados.length != 8 || !dados[0].equals("C")) return null;

        try {
            int ano = Integer.parseInt(dados[1]);
            String modelo = dados[2];
            String cor = dados[3];
            String placa = dados[4];
            double valorFIPE = Double.parseDouble(dados[5]);
            int cavalos = Integer.parseInt(dados[6]);
            int portas = Integer.parseInt(dados[7]);

            return new Carro(ano, modelo, cor, placa, valorFIPE, cavalos, portas);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "CARRO - " + super.toString() +
                ", Cavalos: " + cavalos +
                ", Portas: " + portas;
    }
}

// Subclasse Moto
class Moto extends Veiculo {
    private int cilindradas;

    public Moto(int ano, String modelo, String cor, String placa, double valorFIPE, int cilindradas) {
        super(ano, modelo, cor, placa, valorFIPE);
        this.cilindradas = cilindradas;
    }

    @Override
    public double calcularIPVA() {
        if (cilindradas < 170) {
            return 0; // Isento para motos com menos de 170 cilindradas
        }
        return super.calcularIPVA();
    }

    @Override
    public String toFileString() {
        return "M;" + super.toFileString() + ";" + cilindradas;
    }

    public static Moto fromFileString(String linha) {
        String[] dados = linha.split(";");
        if (dados.length != 7 || !dados[0].equals("M")) return null;

        try {
            int ano = Integer.parseInt(dados[1]);
            String modelo = dados[2];
            String cor = dados[3];
            String placa = dados[4];
            double valorFIPE = Double.parseDouble(dados[5]);
            int cilindradas = Integer.parseInt(dados[6]);

            return new Moto(ano, modelo, cor, placa, valorFIPE, cilindradas);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "MOTO - " + super.toString() +
                ", Cilindradas: " + cilindradas;
    }
}

// Classe principal para manipulação de arquivos e execução
public class GerenciadorVeiculos {
    private static List<Veiculo> veiculos = new ArrayList<>();

    public static void main(String[] args) {
        // Cadastrar 5 carros e 5 motos
        cadastrarVeiculos();

        // Salvar em arquivos
        salvarTodosVeiculos("veiculos.txt");
        salvarCarros("carros.txt");
        salvarMotos("motos.txt");

        System.out.println("Veículos cadastrados e salvos nos arquivos!");

        // Menu para leitura de arquivos
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== MENU DE LEITURA ===");
            System.out.println("1. Ler arquivo veiculos.txt");
            System.out.println("2. Ler arquivo carros.txt");
            System.out.println("3. Ler arquivo motos.txt");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    lerEExibirArquivo("veiculos.txt");
                    break;
                case 2:
                    lerEExibirArquivo("carros.txt");
                    break;
                case 3:
                    lerEExibirArquivo("motos.txt");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    private static void cadastrarVeiculos() {
        // Cadastrar 5 carros
        veiculos.add(new Carro(2020, "Fiesta", "Vermelho", "ABC1D23", 45000, 120, 4));
        veiculos.add(new Carro(2015, "Civic", "Preto", "DEF4G56", 70000, 170, 4));
        veiculos.add(new Carro(2000, "Gol", "Branco", "GHI7J89", 15000, 100, 2));
        veiculos.add(new Carro(2022, "Corolla", "Prata", "JKL0M12", 120000, 150, 4));
        veiculos.add(new Carro(1995, "Fusca", "Azul", "MNO3P45", 10000, 65, 2));

        // Cadastrar 5 motos
        veiculos.add(new Moto(2021, "CG 160", "Preta", "PQR6S78", 15000, 160));
        veiculos.add(new Moto(2019, "XRE 300", "Verde", "STU9V01", 25000, 300));
        veiculos.add(new Moto(2023, "Biz 125", "Vermelha", "VWX2Y34", 12000, 125));
        veiculos.add(new Moto(2018, "Titan 160", "Azul", "YZA5B67", 14000, 160));
        veiculos.add(new Moto(2020, "CB 250", "Preta", "BCD8E90", 18000, 250));
    }

    private static void salvarTodosVeiculos(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (Veiculo veiculo : veiculos) {
                if (veiculo instanceof Carro) {
                    writer.println(((Carro) veiculo).toFileString());
                } else if (veiculo instanceof Moto) {
                    writer.println(((Moto) veiculo).toFileString());
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar arquivo " + nomeArquivo + ": " + e.getMessage());
        }
    }

    private static void salvarCarros(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (Veiculo veiculo : veiculos) {
                if (veiculo instanceof Carro) {
                    writer.println(((Carro) veiculo).toFileString());
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar arquivo " + nomeArquivo + ": " + e.getMessage());
        }
    }

    private static void salvarMotos(String nomeArquivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nomeArquivo))) {
            for (Veiculo veiculo : veiculos) {
                if (veiculo instanceof Moto) {
                    writer.println(((Moto) veiculo).toFileString());
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar arquivo " + nomeArquivo + ": " + e.getMessage());
        }
    }

    private static void lerEExibirArquivo(String nomeArquivo) {
        System.out.println("\n=== CONTEÚDO DO ARQUIVO " + nomeArquivo + " ===");

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("C;")) {
                    Carro carro = Carro.fromFileString(linha);
                    if (carro != null) {
                        System.out.println(carro);
                    }
                } else if (linha.startsWith("M;")) {
                    Moto moto = Moto.fromFileString(linha);
                    if (moto != null) {
                        System.out.println(moto);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo " + nomeArquivo + " não encontrado!");
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo " + nomeArquivo + ": " + e.getMessage());
        }
    }
}