package br.com.segundo_java.sistema_conta_corrente;

public class ContasAtualizadas {

    int codContaA;
    String nomeClienteA;
    double saldoContaA;
    double limiteContaA;
    int tipoContaA;

    ContasAtualizadas(){
        this(0, " ", 0.0, 0, 0);
    }

    ContasAtualizadas(int codContaA, String nomeClienteA, double saldoContaA, double limiteContaA, int tipoContaA){
        this.codContaA = codContaA;
        this.nomeClienteA = nomeClienteA;
        this.saldoContaA = saldoContaA;
        this.limiteContaA = limiteContaA;
        this.tipoContaA = tipoContaA;
    }
}
