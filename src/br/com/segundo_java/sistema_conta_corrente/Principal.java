package br.com.segundo_java.sistema_conta_corrente;

import javax.swing.JOptionPane;
import java.io.IOException;

public class Principal {
    public static void main (String[] args) throws IOException{
        ContaCorrente[] conta = new ContaCorrente[5];
        MovimentoContas[] movimento = new MovimentoContas[10];
        ContasAtualizadas[] atualizacao = new ContasAtualizadas[5];
        Metodos m = new Metodos();

        for(int i = 0; i < 5; i++){
            conta[i] = new ContaCorrente();
            atualizacao[i] = new ContasAtualizadas();
        }

        for(int i = 0; i < 10; i++){
            movimento[i] = new MovimentoContas();
        }

        int opc = 0;
        int opc4 = 0;

        while(opc != 9){
            opc = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção desejada: \n 1 - Cadastrar Conta Corrente; \n 2 - Cadastrar Movimento; \n 3 - Gerar Contas Atualizadas; \n 4 - Consultar Cadastros; \n 9 - Finalizar Programa."));
            switch(opc){
                case 1:
                    conta = m.CadastraContas(conta);
                    break;
                case 2:
                    movimento = m.CadastraMovimentos(movimento);
                    break;
                case 3:
                    atualizacao = m.CadastraAtualizacoes(atualizacao);
                    break;
                case 4:
                    while(opc4 != 8){
                        opc4 = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção desejada: \n 1 - Consultar Conta Corrente; \n 2 - Consultar Movimento; \n 3 - Consultar Atualização; \n 8 - Voltar ao Menu Anterior; \n 9 - Finalizar Programa."));
                        switch(opc4){
                            case 1:
                                m.ConsultaContas();
                                break;
                            case 2:
                                m.ConsultaMovimentos();
                                break;
                            case 3:
                                m.ConsultaAtualizacoes();
                                break;
                            case 8:
                                break;
                            case 9:
                                JOptionPane.showMessageDialog(null,"Programa Finalizado!");
                                opc = 9;
                                opc4 = 8;
                                break;
                            default:
                                JOptionPane.showMessageDialog(null,"Opção Inválida!");
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
