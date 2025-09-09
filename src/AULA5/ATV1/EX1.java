package AULA5.ATV1;

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

        public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getValorFIPE() {
        return valorFIPE;
    }

    public void setValorFIPE(double valorFIPE) {
        this.valorFIPE = valorFIPE;
    }
}

class Carro extends Veiculo {
    private int cavalos;
    private int quantidadePortas;

        public Carro(int ano, String modelo, String cor, String placa, double valorFIPE,
                 int cavalos, int quantidadePortas) {
        super(ano, modelo, cor, placa, valorFIPE);
        this.cavalos = cavalos;
        this.quantidadePortas = quantidadePortas;
    }

        @Override
    public double calcularIPVA() {
        int anoAtual = 2024;         int idade = anoAtual - ano;

        if (idade > 20) {
            return 0.0;         }

        return valorFIPE * 0.02;
    }

        public int getCavalos() {
        return cavalos;
    }

    public void setCavalos(int cavalos) {
        this.cavalos = cavalos;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }
}

class Moto extends Veiculo {
    private int cilindradas;

        public Moto(int ano, String modelo, String cor, String placa, double valorFIPE,
                int cilindradas) {
        super(ano, modelo, cor, placa, valorFIPE);
        this.cilindradas = cilindradas;
    }

    @Override
    public double calcularIPVA() {
        if (cilindradas < 170) {
            return 0.0;         }

        return valorFIPE * 0.02;
    }
    
    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }
}

public class EX1 {
    public static void main(String[] args) {
        Carro carroNovo = new Carro(2023, "Golf", "Preto", "ABC1234", 120000.0, 150, 4);
        Carro carroAntigo = new Carro(2000, "Fusca", "Azul", "DEF5678", 15000.0, 60, 2);
        Moto motoPequena = new Moto(2022, "CG 160", "Vermelha", "GHI9012", 15000.0, 160);
        Moto motoGrande = new Moto(2023, "XJ6", "Preta", "JKL3456", 35000.0, 600);

        System.out.println("IPVA do Golf: R$ " + carroNovo.calcularIPVA());
        System.out.println("IPVA do Fusca: R$ " + carroAntigo.calcularIPVA());
        System.out.println("IPVA da CG 160: R$ " + motoPequena.calcularIPVA());
        System.out.println("IPVA da XJ6: R$ " + motoGrande.calcularIPVA());
    }
}