package br.com.segundo_java.sistema_pontos_alunos;

import javax.swing.JOptionPane;

public class Principal {
    public static void main (String[] args) {
        Aluno[] aluno = new Aluno[3];
        Metodos m = new Metodos();

        for (int i = 0; i < 3; i++) {
            aluno[i] = new Aluno();
        }

        int opc = 0;
        while (opc != 9) {
            opc = Integer.parseInt(JOptionPane.showInputDialog
                    ("1 -  Cadastra Alunos \n 2 - Consulta Registros \n 9 - Finaliza"));
            switch (opc) {
                case 1:
                    aluno = m.Cadastra(aluno);
                    break;
                case 2:
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