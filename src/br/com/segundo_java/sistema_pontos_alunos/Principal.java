package br.com.segundo_java.sistema_pontos_alunos;

import javax.swing.JOptionPane;
import java.io.IOException;

public class Principal {
    public static void main (String[] args) throws IOException {
        Aluno[] aluno = new Aluno[3];
        Metodos m = new Metodos();

        for (int i = 0; i < 3; i++) {
            aluno[i] = new Aluno();
        }

        int opc = 0;
        while (opc != 9) {
            opc = Integer.parseInt(JOptionPane.showInputDialog("Informa a opção desejada: \n 1 -  Cadastra Alunos \n 2 - Gravar Arquivo; \n 3 - Consulta Registros \n 9 - Finaliza"));
            switch (opc) {
                case 1:
                    aluno = m.Cadastra(aluno);
                    break;
                case 2:
                    aluno = m.GravarArquivo(aluno);
                case 3:
                    m.Consulta(aluno);
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Programa finalizado");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida");

            }
        }
    }
}