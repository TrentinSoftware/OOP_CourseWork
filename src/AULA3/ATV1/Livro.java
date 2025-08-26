package AULA3.ATV1;

public class Livro {
    String titulo;
    String autor;
    int anoPublicacao;

    public Livro() {
    }

    public void imprimir() {
        System.out.println("Título: " + this.titulo);
        System.out.println("Autor: " + this.autor);
        System.out.println("Ano: " + this.anoPublicacao);
    }
}