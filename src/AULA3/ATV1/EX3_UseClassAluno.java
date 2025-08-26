package AULA3.ATV1;

public class EX3_UseClassAluno {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("João", "2023001", 8.5f, 7.0f);
        aluno.imprimir();
        System.out.println("Situação: " + aluno.aprovado());
    }
}
