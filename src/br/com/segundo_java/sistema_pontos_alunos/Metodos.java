package br.com.segundo_java.sistema_pontos_alunos;

import javax.swing.JOptionPane;
import java.io.*;

public class Metodos {
    public Aluno[] Cadastra(Aluno[] aluno){
        for(int i = 0; i < 3; i++){
            aluno[i].setPnome(JOptionPane.showInputDialog("Informe o nome do aluno: "));
            aluno[i].setUnome(JOptionPane.showInputDialog("Informe o sobrenome do aluno: "));
            aluno[i].setPontos(Integer.parseInt(JOptionPane.showInputDialog("Informe os pontos do aluno: ")));
        }
        return aluno;
    }

    public Aluno[] GravarArquivo(Aluno[] aluno) throws IOException{
        String fileName = "Alunos2024.txt";

        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));

        for(int i = 0; i < 3; i++){
            gravar.write(aluno[i].getPnome());
            gravar.newLine();
            gravar.write(aluno[i].getUnome());
            gravar.newLine();
            gravar.write(Integer.toString(aluno[i].getPontos()));
            gravar.newLine();
        }

        System.out.println("GRAVAÇÃO FEITA COM SUCESSO!");

        gravar.close();

        return aluno;
    }

    public void Consulta(Aluno[] aluno){
        for(int i = 0; i < 3; i++){
            System.out.println(aluno[i].getPnome()+" "+ aluno[i].getUnome()+" | Pontos: " +aluno[i].getPontos());
        }
    }
}