package br.com.segundo_java.sistema_eleicao;

import javax.swing.JOptionPane;
import java.io.IOException;

public class Principal {
    public static void main (String[] args) throws IOException{
        CadastroEleitor[] cadastroEleitor = new CadastroEleitor[10];
        Votacao[] votacao1 = new Votacao[5];
        Votacao[] votacao2 = new Votacao[5];
        Metodos m = new Metodos();

        for(int i = 0; i < 10; i++){
            cadastroEleitor[i] = new CadastroEleitor();
        }

        for(int i = 0; i < 5; i++){
            votacao1[i] = new Votacao();
            votacao2[i] = new Votacao();
        }

        int opc = 0;
        int opc2 = 0;
        int opc4 = 0;

        while(opc != 9){
            opc =  Integer.parseInt(JOptionPane.showInputDialog("Informe a opção desejada: \n 1 - Cadastrar Eleitor; \n 2 - Cadastrar Votação 1 e 2; \n 3 - Agrupar Apuração; \n 4 - Menu de Estatísticas; \n 9 - Finalizar Programa."));
            switch(opc){
                case 1:
                    cadastroEleitor = m.CadastrarEleitor(cadastroEleitor);
                    break;
                case 2:
                    while(opc2 != 8){
                        opc2 = Integer.parseInt(JOptionPane.showInputDialog("Qual votação deseja cadastrar? \n 1 - Cadastrar Votação 1; \n 2 - Cadastrar Votação 2; \n 8 - Voltar ao Menu Anterior; \n 9 - Finalizar Programa."));
                        switch(opc2){
                            case 1:
                                votacao1 = m.CadastraVotacao(votacao1, cadastroEleitor);
                                break;
                            case 2:
                                votacao2 = m.CadastraVotacao(votacao2, cadastroEleitor);
                                break;
                            case 8:
                                break;
                            case 9:
                                JOptionPane.showMessageDialog(null, "Programa Finalizado!");
                                opc2 = 8;
                                opc = 9;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opção Inválida!");
                        }
                    }
                    break;
                case 3:
                    m.AgrupaVotacao(votacao1, votacao2);
                    break;
                case 4:
                    while(opc4 != 8){
                        opc4 = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção desejada: \n 1 - Exibir Vencedor; \n 2 - Exibir Segundo Colocado; \n 3 - Quantidade de votos em Branco; \n 4 - Quantidade de votos Nulos; \n 5 - Mostrar Eleitores; \n 6 - Mostrar Apuração \n 8 - Voltar ao menu anterior; \n 9 - Finalizar programa."));
                        switch(opc4){
                            case 1:
                                m.PrimeiroColocado();
                                break;
                            case 2:
                                m.SegundoColocado();
                                break;
                            case 3:
                                m.VotosBrancos();
                                break;
                            case 4:
                                m.VotosNulos();
                                break;
                            case 5:
                                m.ExibeEleitores();
                                break;
                            case 6:
                                m.ExibeApuracao();
                                break;
                            case 8:
                                break;
                            case 9:
                                JOptionPane.showMessageDialog(null, "Programa Finalizado!");
                                opc = 9;
                                opc4 = 8;
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
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }
}