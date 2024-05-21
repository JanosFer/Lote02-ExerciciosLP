package br.com.segundo_java.sistema_conta_corrente;

import java.io.*;
import java.util.Scanner;

public class Metodos {

    Scanner scanner = new Scanner();

    String fileName = "ContasCorrentes.txt";
    String fileName2 = "Movimentos.txt";
    String fileName3 = "ContasAtualizadas.txt";

    public ContaCorrente[] CadastraContas(ContaCorrente[] conta) throws IOException{

        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));

        for(int i = 0; i < 5; i++){
            conta[i].codConta = scanner.nextInt();
            gravar.write(Integer.toString(conta[i].codConta));
            gravar.newLine();

            conta[i].nomeCliente = scanner.nextLine();
            gravar.write(conta[i].nomeCliente);
            gravar.newLine();

            conta[i].saldoConta = scanner.nextDouble();
            gravar.write(Double.toString(conta[i].saldoConta));
            gravar.newLine();

            conta[i].limiteConta = scanner.nextDouble();
            gravar.write(Double.toString(conta[i].limiteConta));
            gravar.newLine();

            conta[i].tipoConta = scanner.nextInt();
            gravar.write(Integer.toString(conta[i].tipoConta));
            gravar.newLine();
        }

        gravar.close();
        return conta;
    }

    public MovimentoContas[] CadastraMovimentos(MovimentoContas[] movimento) throws IOException{

        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName2));

        for(int i = 0; i < 10; i++){
            movimento[i].codContaM = scanner.nextInt();
            gravar.write(Integer.toString(movimento[i].codContaM));
            gravar.newLine();

            movimento[i].valorMovimentoM = scanner.nextDouble();
            gravar.write(Double.toString(movimento[i].valorMovimentoM));
            gravar.newLine();

            movimento[i].tipoMovimentoM = scanner.nextInt();
            gravar.write(Integer.toString(movimento[i].tipoMovimentoM));
            gravar.newLine();

            movimento[i].statusM = scanner.nextInt();
            gravar.write(Integer.toString(movimento[i].statusM));
            gravar.newLine();
        }

        gravar.close();
        return movimento;
    }

    public ContasAtualizadas[] CadastraAtualizacoes(ContasAtualizadas[] atualizacao) throws IOException{

        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName3));

        for(int i = 0; i < 5; i++){
            atualizacao[i].codContaA = scanner.nextInt();
            gravar.write(Integer.toString(atualizacao[i].codContaA));
            gravar.newLine();

            atualizacao[i].nomeClienteA = scanner.nextLine();
            gravar.write(atualizacao[i].nomeClienteA);
            gravar.newLine();

            atualizacao[i].saldoContaA = scanner.nextDouble();
            gravar.write(Double.toString(atualizacao[i].saldoContaA));
            gravar.newLine();

            atualizacao[i].limiteContaA = scanner.nextDouble();
            gravar.write(Double.toString(atualizacao[i].limiteContaA));
            gravar.newLine();

            atualizacao[i].tipoContaA = scanner.nextInt();
            gravar.write(Integer.toString(atualizacao[i].tipoContaA));
            gravar.newLine();
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
            System.out.println("Status da Movimentação: " +Integer.parseInt(ler.readLine()));
        }

        ler.close();
    }

    public void ConsultaAtualizacoes() throws IOException{
        BufferedReader ler = new BufferedReader(new FileReader(fileName3));

        System.out.println("\n -----------------CONTA CORRENTE ATUALIZADA----------------- \n");
        for(int i = 0; i < 5; i++){
            System.out.println("Código da Conta Atualizada: " +Integer.parseInt(ler.readLine()));
            System.out.println("Nome do Cliente: " +ler.readLine());
            System.out.println("Saldo da Conta Atualizado: " +Double.parseDouble(ler.readLine()));
            System.out.println("Limite da Conta Atualizado: " +Double.parseDouble(ler.readLine()));
            System.out.println("Tipo da Conta Atualizado: " +Integer.parseInt(ler.readLine())+ "\n");
        }

        ler.close();
    }
}
