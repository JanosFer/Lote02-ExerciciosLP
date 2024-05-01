package br.com.segundo_java.sistema_votacao;

import java.io.*;
import java.util.Random;


public class Metodos {
    Random aleat = new Random();

    int[] qtdEleitores = new int[10];

    public Votacao[] Cadastra (Votacao[] votacao){
        for(int i = 0; i < 200; i++){
            votacao[i].numeroSecao = aleat.nextInt(10);
            votacao[i].numeroCandidato = aleat.nextInt(300);
        }
        return votacao;
    }

    public Votacao[] ClassificaSecao (Votacao[] votacao){
        for(int i = 0; i < 199; i++){
            for(int j = (i + 1); j < 200; j++) {
                if (votacao[i].numeroSecao > votacao[j].numeroSecao) {
                    int aux = votacao[i].numeroSecao;
                    votacao[i].numeroSecao = votacao[j].numeroSecao;
                    votacao[j].numeroSecao = aux;
                }
            }
        }
        return votacao;
    }

    public Votacao[] GravarArquivo (Votacao[] votacao) throws IOException {
        String fileName = "Votação2024.txt";

        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));

        for(int i = 0; i < 200; i++){
            gravar.write(votacao[i].numeroSecao); gravar.newLine();
            gravar.write(votacao[i].numeroCandidato); gravar.newLine();
        }

        System.out.println("GRAVAÇÃO FEITA COM SUCESSO!");

        gravar.close();

        return votacao;
    }

    public void QtdEleitoresPorSecao (Votacao[] votacao){
        for(int i = 0; i < 200; i++){
            qtdEleitores[votacao[i].numeroSecao]++;
        }


        for(int i = 0; i < 10; i++){
            System.out.println("A quantidade de eleitores na seção " +i+ " é: " +qtdEleitores[i]);
        }
    }

    public void MaiorMenorSecao (Votacao[] votacao){
        int maior, menor, maiorI, menorI;
        System.out.println("A seção com menor número de eleitores foi a seção " +qtdEleitores);
    }

    public void QtdVotosPorCandidato (Votacao[] votacao){

    }

    public void DezMaisVotados (Votacao[] votacao){

    }
}