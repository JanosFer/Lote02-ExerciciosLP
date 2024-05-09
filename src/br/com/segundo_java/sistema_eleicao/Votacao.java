package br.com.segundo_java.sistema_eleicao;

public class Votacao {
    int secao;
    int codCandidato;
    int numeroEleitor;

    Votacao(){
        this(0, 0, 0);
    }

    Votacao(int secao, int codCandidato, int numeroEleitor){
        this.secao = secao;
        this.codCandidato = codCandidato;
        this.numeroEleitor = numeroEleitor;
    }
}
