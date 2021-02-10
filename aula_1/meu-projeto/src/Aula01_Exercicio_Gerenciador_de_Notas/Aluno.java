package Aula01_Exercicio_Gerenciador_de_Notas;

public class Aluno {
    private String nomeAluno;
    private float notaFinal;


    public Aluno (String nomeAluno, float notaFinal) {
        this.nomeAluno = nomeAluno;
        this.notaFinal = notaFinal;
        System.out.println("Nome do aluno: " + nomeAluno);
        System.out.println("Nota final: " + notaFinal);
    }

    boolean isAprovado() {
        if (notaFinal >= 7) {
            return true;
        } else {
            return false;
        }
    }
}
