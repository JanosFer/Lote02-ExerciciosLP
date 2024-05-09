package br.com.segundo_java.sistema_conta_corrente;

import javax.swing.JOptionPane;

public class Principal {
    public static void main (String[] args){
        ContaCorrente[] contaCorrente = new ContaCorrente[5];
        Metodos m = new Metodos();

        for(int i = 0; i < 5; i++){
            contaCorrente[i] = new ContaCorrente();
        }

        int opc = 0;
        int opc4 = 0;

//        while(opc != 9){
//            opc = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção desejada: \n 1 - Cadastrar Conta Corrente; \n 2 - Cadastrar Movimento; \n 3 - Gerar Contas Atualizadas; \n 4 - Consultar Cadastros; \n 9 - Finalizar Programa."));
//            switch(opc){
//                case 1:
//                    m.CadastraContaCorrente();
//                    break;
//                case 2:
//                    m.CadastraMovimento();
//                    break;
//                case 3:
//                    m.GeraContasAtualizadas();
//                    break;
//                case 4:
//                    while(opc4 != 8){
//                        opc4 = Integer.parseInt(JOptionPane.showInputDialog("Informe a opção desejada: \n 1 - Consultar Conta Corrente; \n 2 - Consultar Movimento; \n 3 - Consultar Atualização; \n 8 - Voltar ao Menu Anterior; \n 9 - Finalizar Programa."));
//                        switch(opc4){
//                            case 1:
//                                m.ConsultaContaCorrente();
//                                break;
//                            case 2:
//                                m.ConsultaMovimento();
//                                break;
//                            case 3:
//                                m.ConsultaAtualizacao();
//                                break;
//                            case 8:
//                                break;
//                            case 9:
//                                JOptionPane.showMessageDialog(null,"Programa Finalizado!");
//                                opc = 9;
//                                opc4 = 8;
//                                break;
//                            default:
//                                JOptionPane.showMessageDialog(null,"Opção Inválida!");
//                        }
//                    }
//                    break;
//                case 9:
//                    JOptionPane.showMessageDialog(null, "Programa Finalizado!");
//                    break;
//                default:
//                    JOptionPane.showMessageDialog(null, "Opção Inválida!");
//            }
//        }
    }
}
