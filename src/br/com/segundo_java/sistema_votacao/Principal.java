package br.com.segundo_java.sistema_votacao;

import javax.swing.JOptionPane;
import java.io.IOException;

public class Principal {
    public static void main (String[] args) throws IOException {
        Votacao[] votacao = new Votacao[200];
        Metodos m = new Metodos();

        int opc = 0, opc4 = 0;

        for(int i = 0; i < 200; i++){
            votacao[i] = new Votacao();
        }

        while(opc != 9){
            opc = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção desejada: \n Digite: \n 1 - Cadastrar Votação. \n 2 - Classificar por número de Seção. \n 3 - Gravar dados da votação em arquivo .txt \n 4 - Consultar Estatisticas. \n 9 - Finalizar programa."));
            switch(opc){
                case 1:
                    votacao = m.Cadastra(votacao);
                    break;
                case 2:
                    votacao = m.ClassificaSecao(votacao);
                    break;
                case 3:
                    votacao = m.GravarArquivo(votacao);
                    break;
                case 4:
                    while(opc4 != 8){
                        opc4 = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção desejada: \n 1 - Quantidade de eleitores por eleição. \n 2 - Seção com maior e menor número de eleitores. \n 3 - Quantidade de votos por candidato. \n 4 - 10 candidatos mais votados. \n 8 - Voltar ao menu anterior. \n 9 - Finalizar programa."));
                        switch(opc4){
                            case 1:
                                m.QtdEleitoresPorSecao(votacao);
                                break;
                            case 2:
                                m.MaiorMenorSecao();
                                break;
                            case 3:
                                m.QtdVotosPorCandidato(votacao);
                                break;
                            case 4:
                                m.DezMaisVotados();
                                break;
                            case 8:
                                break;
                            case 9:
                                JOptionPane.showMessageDialog(null, "Programa Finalizado!");
                                opc4 = 8;
                                opc = 9;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção Inválida!");
                        }
                    }
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Programa Finalizado!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
            }
        }
    }
}
