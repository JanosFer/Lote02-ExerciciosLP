package br.com.segundo_java.sistema_conta_corrente;

public class ContaCorrente {
    int codConta;
    String nomeCliente;
    double saldoConta;
    double limiteConta;
    int tipoConta;

    ContaCorrente(){
        this(0, " ", 0.0, 0.0, 0);
    }

    ContaCorrente(int codConta, String nomeCliente, double saldoConta, double limiteConta, int tipoConta){
        this.codConta = codConta;
        this.nomeCliente = nomeCliente;
        this.saldoConta = saldoConta;
        this.limiteConta = limiteConta;
        this.tipoConta = tipoConta;
    }
}
