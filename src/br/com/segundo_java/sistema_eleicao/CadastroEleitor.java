package br.com.segundo_java.sistema_eleicao;

public class CadastroEleitor {
    int numeroEleitor;
    String nomeEleitor;
    int secao;

    CadastroEleitor(){
        this(0, " ", 0);
    }

    CadastroEleitor(int numeroEleitor, String nomeEleitor, int secao){
        this.numeroEleitor = numeroEleitor;
        this.nomeEleitor = nomeEleitor;
        this.secao = secao;
    }
}
