package Aula01_Exercicio_Gerenciador_de_Notas;

public class Aplicacao {
    public static void main(String[] args) {
        Aluno aluno = new Aluno("Naruto Uzumaki", 7);
        System.out.println("Situação de aprovação: " + aluno.isAprovado());
    }
}
