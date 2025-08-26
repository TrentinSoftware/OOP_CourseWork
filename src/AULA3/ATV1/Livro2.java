package AULA3.ATV1;

public class Livro2 {
    String titulo;
    String autor;
    int anoPublicacao;
    String editora;

    public Livro2() {
    }

    public void imprimir() {
        System.out.println("Título: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Ano: " + this.anoPublicacao);
        System.out.println("Editora: " + this.editora);
    }
}