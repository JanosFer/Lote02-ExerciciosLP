package br.com.segundo_java.sistema_conta_corrente;

import java.io.*;
import java.util.Scanner;

public class Metodos {

    Scanner scanner = new Scanner(System.in);

    String fileName = "ContasCorrentes.txt";
    String fileName2 = "Movimentos.txt";
    String fileName3 = "ContasAtualizadas.txt";

    public ContaCorrente[] CadastraContas(ContaCorrente[] conta) throws IOException{

        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));

        for(int i = 0; i < 5; i++){
            System.out.println("Informe o Código da Conta: ");
            conta[i].codConta = scanner.nextInt();
            System.out.println("Informe o Nome do Cliente: ");
            conta[i].nomeCliente = scanner.next();
            System.out.println("Informe o Saldo da Conta: ");
            conta[i].saldoConta = scanner.nextDouble();
            System.out.println("Informe o Limite da Conta: ");
            conta[i].limiteConta = scanner.nextDouble();
            System.out.println("Informe o Tipo da Conta: \n 1 - Física \n 2 - Conjunta \n 3 - Jurídica \n 4 - especial");
            conta[i].tipoConta = scanner.nextInt();
        }

        for (int i = 0; i < 4; i++) {
            for (int j = (i+1); j < 5 ; j++) {
                if(conta[i].codConta > conta[j].codConta){
                    ContaCorrente aux = conta[i];
                    conta[i] = conta[j];
                    conta[j] = aux;
                }
            }
        }

        for(int i = 0; i < 5; i++){
            gravar.write(Integer.toString(conta[i].codConta));
            gravar.newLine();
            gravar.write(conta[i].nomeCliente);
            gravar.newLine();
            gravar.write(Double.toString(conta[i].saldoConta));
            gravar.newLine();
            gravar.write(Double.toString(conta[i].limiteConta));
            gravar.newLine();
        }

        gravar.close();
        return conta;
    }

    public MovimentoContas[] CadastraMovimentos(MovimentoContas[] movimento, ContaCorrente[] conta) throws IOException{

        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName2));

        for(int i = 0; i < 5; i++){
            boolean verificaConta = false;

            while(!verificaConta) {
                System.out.println("Informe o Código da Conta: ");
                movimento[i].codContaM = scanner.nextInt();
                for (int j = 0; j < 10; j++) {
                    if (conta[i].codConta == movimento[j].codContaM){
                        verificaConta = true;
                        break;
                    }
                }
                if(!verificaConta){
                    System.err.println("Código de Conta Inválido!");
                }
            }
            System.out.println("Informe o Valor do Movimento: ");
            movimento[i].valorMovimentoM = scanner.nextDouble();
            System.out.println("Informe o Tipo do Movimento: \n 1 - Crédito \n 2 - Débito");
            movimento[i].tipoMovimentoM = scanner.nextInt();
            System.out.println("Informe o Status do Movimento: \n 1 - Realizado \n 2 - Pendente");
            movimento[i].statusM = scanner.nextInt();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = (i+1); j < 10 ; j++) {
                if(movimento[i].codContaM > movimento[j].codContaM){
                    MovimentoContas aux = movimento[i];
                    movimento[i] = movimento[j];
                    movimento[j] = aux;
                }
            }
        }

        for (int i = 0; i < 10; i++) {
            gravar.write(Integer.toString(movimento[i].codContaM));
            gravar.newLine();
            gravar.write(Integer.toString(movimento[i].codContaM));
            gravar.newLine();
            gravar.write(Double.toString(movimento[i].valorMovimentoM));
            gravar.newLine();
            gravar.write(Integer.toString(movimento[i].tipoMovimentoM));
            gravar.newLine();
            gravar.write(Integer.toString(movimento[i].statusM));
            gravar.newLine();
        }

        gravar.close();
        return movimento;
    }

    public ContasAtualizadas[] CadastraAtualizacoes(ContasAtualizadas[] atualizacao) throws IOException{

        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName3));
        BufferedReader ler = new BufferedReader(new FileReader(fileName));
        BufferedReader ler2 = new BufferedReader(new FileReader(fileName2));

        int[] cod = new int[5];
        String[] nome = new String[5];
        double[] saldo = new double[5];
        double[] limite = new double[5];
        int[] tipo = new int[5];

        int[] codM = new int[10];
        double[] movimentacao = new double[10];
        int[] tipoM = new int[10];
        int[] status = new int[10];

        for (int i = 0; i < 5; i++) {
            cod[i] = Integer.parseInt(ler.readLine());
            nome[i] = ler.readLine();
            saldo[i] = Double.parseDouble(ler.readLine());
            limite[i] = Double.parseDouble(ler.readLine());
            tipo[i] = Integer.parseInt(ler.readLine());
        }
        for (int i = 0; i < 10; i++) {
            codM[i] = Integer.parseInt(ler2.readLine());
            movimentacao[i] = Double.parseDouble(ler2.readLine());
            tipoM[i] = Integer.parseInt(ler2.readLine());
            status[i] = Integer.parseInt(ler2.readLine());
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 10; j++) {
                if(cod[i] == codM[j]) {
                    if(status[j] == 2){
                        if(saldo[i] > limite[i]){
                            switch(tipo[i]){
                                case 1:
                                    atualizacao[i].limiteContaA = 0;
                                    break;
                                case 2:
                                    atualizacao[i].limiteContaA = limite[i];
                                    break;
                                case 3:
                                    atualizacao[i].limiteContaA = limite[i] + (saldo[i] * 0.5);
                                    break;
                                case 4:
                                    atualizacao[i].limiteContaA = limite[i] +  saldo[i];
                                    break;
                            }
                        }
                        if(tipoM[j] == 1){
                            atualizacao[i].saldoContaA = saldo[i] + movimentacao[j];
                        } else if(tipoM[j] == 2){
                            if(atualizacao[i].limiteContaA == 0){
                                if(movimentacao[j] > saldo[i]){
                                    movimentacao[j] = saldo[i];
                                }
                                atualizacao[i].saldoContaA = saldo[i] - movimentacao[j];
                            }else if(atualizacao[i].limiteContaA > 0){
                                if(movimentacao[j] > atualizacao[i].limiteContaA){
                                    System.out.println("O limite da Conta de código " +atualizacao[i].codContaA+ " foi usado por completo para efetuar a operação!");
                                    movimentacao[j] -= atualizacao[i].limiteContaA;
                                    if(movimentacao[j] > saldo[i]){
                                        System.out.println("E será necessário usar R$" +movimentacao[j]+ " do saldo da conta de código " +atualizacao[i].codContaA);
                                        movimentacao[j] = saldo[i];
                                    }
                                    atualizacao[i].saldoContaA = saldo[i] - movimentacao[j];
                                }else if(movimentacao[j] < atualizacao[i].limiteContaA){
                                    double limiteA = atualizacao[i].limiteContaA;
                                    atualizacao[i].limiteContaA -= movimentacao[j];
                                    System.out.println("Foi consumido R$" +movimentacao[j]+ " do limite da conta de codigo " +atualizacao[i].codContaA+ "\n O limite restante é de R$" +atualizacao[i].limiteContaA);
                                    movimentacao[j] -= limiteA;
                                }
                            }
                            atualizacao[i].saldoContaA = saldo[i] - movimentacao[j];
                        }
                    }
                }
                atualizacao[i].codContaA = cod[i];
                gravar.write(Integer.toString(atualizacao[i].codContaA));
                gravar.newLine();
                atualizacao[i].nomeClienteA = nome[i];
                gravar.write(atualizacao[i].nomeClienteA);
                gravar.newLine();
                gravar.write(Double.toString(atualizacao[i].saldoContaA));
                gravar.newLine();
                gravar.write(Double.toString(atualizacao[i].limiteContaA));
                gravar.newLine();
                gravar.write(Integer.toString(atualizacao[i].tipoContaA));
                gravar.newLine();
            }
        }
        gravar.close();
        return atualizacao;
    }

    public void ConsultaContas() throws IOException{
        BufferedReader ler = new BufferedReader(new FileReader(fileName));

        System.out.println("\n -----------------CONTA CORRENTE----------------- \n");
        for(int i = 0; i < 5; i++){
            System.out.println("Código da Conta: " +Integer.parseInt(ler.readLine()));
            System.out.println("Nome da Conta: " +ler.readLine());
            System.out.println("Saldo da Conta: " +Double.parseDouble(ler.readLine()));
            System.out.println("Limite da Conta: " +Double.parseDouble(ler.readLine()));
            System.out.println("Tipo da Conta: " +Integer.parseInt(ler.readLine())+ "\n");
        }

        ler.close();
    }

    public void ConsultaMovimentos() throws IOException{
        BufferedReader ler = new BufferedReader(new FileReader(fileName2));

        System.out.println("\n -----------------MOVIMENTAÇÕES DA CONTA----------------- \n");
        for(int i = 0; i < 10; i++){
            System.out.println("Código da Conta Movimentada: " +Integer.parseInt(ler.readLine()));
            System.out.println("Valor da Movimentação: " +Double.parseDouble(ler.readLine()));
            System.out.println("Tipo da Movimentação: " +Integer.parseInt(ler.readLine()));
            System.out.println("Status da Movimentação: " +Integer.parseInt(ler.readLine())+ "\n");
        }

        ler.close();
    }

    public void ConsultaAtualizacoes() throws IOException{
        BufferedReader ler = new BufferedReader(new FileReader(fileName3));

        System.out.println("\n -----------------CONTA CORRENTE ATUALIZADA----------------- \n");
        for(int i = 0; i < 5; i++){
            System.out.println("Código da Conta Atualizado: " +Integer.parseInt(ler.readLine()));
            System.out.println("Nome do Cliente: " +ler.readLine());
            System.out.println("Saldo da Conta Atualizado: " +Double.parseDouble(ler.readLine()));
            System.out.println("Limite da Conta Atualizado: " +Double.parseDouble(ler.readLine()));
            System.out.println("Tipo da Conta Atualizado: " +Integer.parseInt(ler.readLine())+ "\n");
        }

        ler.close();
    }
}
