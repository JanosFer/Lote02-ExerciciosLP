package br.com.segundo_java.sistema_estatistica_transito;

public class Estatistica {
    int codigoCidade;
    String nomeCidade;
    int qtdAcidentes;

    Estatistica(){
        this(0, "", 0);
    }

    Estatistica(int codigoCidade, String nomeCidade, int qtdAcidentes){
        this.codigoCidade = codigoCidade;
        this.nomeCidade = nomeCidade;
        this.qtdAcidentes = qtdAcidentes;
    }
}