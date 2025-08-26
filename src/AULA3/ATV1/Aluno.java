package AULA3.ATV1;

public class Aluno {
    String nome;
    String matricula;
    float nota1;
    float nota2;

    public Aluno(String nome, String matricula, float nota1, float nota2) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public float calcularMedia() {
        return (nota1 + nota2) / 2;
    }

    public void imprimir() {
        System.out.println("Nome: " + this.nome);
        System.out.println("Matrícula: " + this.matricula);
        System.out.println("Nota 1: " + this.nota1);
        System.out.println("Nota 2: " + this.nota2);
        System.out.println("Média: " + calcularMedia());
    }

    public String aprovado() {
        float media = calcularMedia();
        if (media >= 7) {
            return "Aprovado";
        } else if (media >= 4) {
            return "Exame";
        } else {
            return "Reprovado";
        }
    }
}