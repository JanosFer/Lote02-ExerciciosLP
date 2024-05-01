package br.com.segundo_java.sistema_pontos_alunos;

public class Aluno {
    private String pnome;
    private String unome;
    private int pontos;

    //Método Construtor
    Aluno() {
        this("" ,"" , 0);
    }

    //Método Procedimento
    Aluno(String pnome, String unome, int pontos) {
        this.pnome = pnome;
        this.unome = unome;
        this.pontos = pontos;
    }

    public String getPnome() {
        return pnome;
    }

    public void setPnome(String pnome) {
        this.pnome = pnome;
    }

    public String getUnome() {
        return unome;
    }

    public void setUnome(String unome) {
        this.unome = unome;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }
}