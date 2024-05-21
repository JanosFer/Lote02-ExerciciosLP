package br.com.segundo_java.sistema_conta_corrente;

public class MovimentoContas {

    int codContaM;
    double valorMovimentoM;
    int tipoMovimentoM;
    int statusM;

    MovimentoContas(){
        this(0, 0.0, 0, 0);
    }

    MovimentoContas(int codContaM, double valorMovimentoM, int tipoMovimentoM, int statusM){
        this.codContaM = codContaM;
        this.valorMovimentoM = valorMovimentoM;
        this.tipoMovimentoM = tipoMovimentoM;
        this.statusM = statusM;
    }
}
