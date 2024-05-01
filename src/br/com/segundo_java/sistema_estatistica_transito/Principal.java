package br.com.segundo_java.sistema_estatistica_transito;

import javax.swing.JOptionPane;

public class Principal {
    public static void main (String[] args){
        Estatistica[] estatistica = new Estatistica[10];
        Metodos m = new Metodos();

        int  opc = 0;

        for(int i = 0; i < 10; i++){
            estatistica[i] = new Estatistica();
        }

        while(opc != 9){
            opc = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção desejada: \n Digite: \n 1 -  Cadastrar Acidentes. \n 2 - Consultar cidades com mais de 100 acidentes e menos de 500 acidentes. \n 3 - Consultar as cidades com o maior número de acidentes e com o menor número de acidentes. \n 4 - Consultar cidades com número de acidentes acima da média. \n 9 - Finalizar."));
            switch(opc){
                case 1:
                    estatistica = m.Cadastra(estatistica);
                    break;
                case 2:
                    m.nAcidentes(estatistica);
                    break;
                case 3:
                    m.MaiorOuMenor(estatistica);
                case 4:
                    m.Media(estatistica);
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Programa Finalizado!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }
}
