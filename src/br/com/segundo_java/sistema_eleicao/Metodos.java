package br.com.segundo_java.sistema_eleicao;

import javax.swing.JOptionPane;
import java.io.*;

public class Metodos {

    String fileName3 = "Apuração.txt";
    Votacao[] apuracao = new Votacao[10];
    int[] votados = new int[10];
    int[] resultado = new int[100];

    public CadastroEleitor[] CadastrarEleitor (CadastroEleitor[] cadastroEleitor) throws IOException{
        String fileName = "Eleitores.txt";
        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName));

        for(int i = 0; i < 10; i++){
            cadastroEleitor[i].numeroEleitor = Integer.parseInt(JOptionPane.showInputDialog("Informe o Número de Eleitor: "));
            gravar.write(Integer.toString(cadastroEleitor[i].numeroEleitor));
            gravar.newLine();
            cadastroEleitor[i].nomeEleitor = JOptionPane.showInputDialog("Informe o Nome do Eleitor: ");
            gravar.write(cadastroEleitor[i].nomeEleitor);
            gravar.newLine();
            while(true){
                cadastroEleitor[i].secao = Integer.parseInt(JOptionPane.showInputDialog("Informe o Número da Seção: "));
                if(cadastroEleitor[i].secao <= 0 || cadastroEleitor[i].secao > 10 || cadastroEleitor[i].secao == 2 || cadastroEleitor[i].secao == 6 || cadastroEleitor[i].secao == 7 || cadastroEleitor[i].secao == 8){
                    JOptionPane.showMessageDialog(null, "Número de Seção Inválido!");
                }else{
                    break;
                }
            }
            gravar.write(Integer.toString(cadastroEleitor[i].secao));
            gravar.newLine();
        }
        gravar.close();

        return cadastroEleitor;
    }

    public Votacao[] CadastraVotacao (Votacao[] votacao, CadastroEleitor[] cadastroEleitor) throws IOException{
        String fileName2 = "Votacao.txt";
        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName2));

        for(int i = 0; i < 5; i++){
            boolean verificaNumEleitor = false;

            votacao[i].secao = Integer.parseInt(JOptionPane.showInputDialog("Informe o Número da Seção: "));
            gravar.write(Integer.toString(votacao[i].secao));
            gravar.newLine();

            while(true) {
                votacao[i].codCandidato = Integer.parseInt(JOptionPane.showInputDialog("1 - José \n 2 - Maria \n 3 - Branco \n 4 - Nulo "));
                if(votacao[i].codCandidato >= 100 || votacao[i].codCandidato <= 0){
                    JOptionPane.showMessageDialog(null, "Valor Inválido, informe um valor entre 1 e 99 para concluir a votação.");
                }else {
                    gravar.write(Integer.toString(votacao[i].codCandidato));
                    gravar.newLine();
                    break;
                }
            }

            while(!verificaNumEleitor){
                votacao[i].numeroEleitor = Integer.parseInt(JOptionPane.showInputDialog("Informe o Número do Eleitor"));
                for(int j = 0; j < 10; j++){
                    if(verificar(votacao,i)){
                        if(votacao[i].numeroEleitor == cadastroEleitor[j].numeroEleitor ){
                            gravar.write(Integer.toString(votacao[i].numeroEleitor));
                            gravar.newLine();
                            votados[i] = votacao[i].numeroEleitor;
                            verificaNumEleitor = true;
                            break;
                        }
                    }

                }

                if(!verificaNumEleitor){
                JOptionPane.showMessageDialog(null, "Número de Eleitor Inválido");
                }
            }
        }
        gravar.close();
        return votacao;
    }

    public boolean verificar(Votacao[] votacao, int k){
        for(int i = 0; i <= k; i++){
            for (int j = 0; j <= k; j++) {
                if(votados[i] != votacao[j].numeroEleitor){
                    return true;
                }
            }

        }
        return false;
    }

    public void AgrupaVotacao(Votacao[] votacao1, Votacao[] votacao2) throws IOException{
        BufferedWriter gravar = new BufferedWriter(new FileWriter(fileName3));

        for(int i = 0; i < 10; i++){
            apuracao[i] = new Votacao();
        }

        for(int i = 0; i < 5; i++){
            apuracao[i].secao = votacao1[i].secao;
            gravar.write(Integer.toString(apuracao[i].secao));
            gravar.newLine();
            apuracao[i].codCandidato = votacao1[i].codCandidato;
            gravar.write(Integer.toString(apuracao[i].codCandidato));
            gravar.newLine();
            apuracao[i].numeroEleitor = votacao1[i].numeroEleitor;
            gravar.write(Integer.toString(apuracao[i].numeroEleitor));
            gravar.newLine();
            apuracao[i + 5].secao = votacao2[i].secao;
            gravar.write(Integer.toString(apuracao[i + 5].secao));
            gravar.newLine();
            apuracao[i + 5].codCandidato = votacao2[i].codCandidato;
            gravar.write(Integer.toString(apuracao[i + 5].codCandidato));
            gravar.newLine();
            apuracao[i + 5].numeroEleitor = votacao2[i].numeroEleitor;
            gravar.write(Integer.toString(apuracao[i + 5].numeroEleitor));
        }
        gravar.close();
        System.out.println("GRAVAÇÃO FEITA COM SUCESSO!");


        for(int i = 0; i < 10; i++){
            resultado[apuracao[i].codCandidato - 1]++;
        }
    }

    public void PrimeiroColocado(){
        if(resultado[0] > resultado[1]){
            JOptionPane.showMessageDialog(null, "A eleição foi vencida por José com: " +resultado[0]+ " votos.");
        }else if(resultado[0] < resultado[1]){
            JOptionPane.showMessageDialog(null, "A eleição foi vencida por Maria com: " +resultado[1]+ " votos.");
        }else{
            JOptionPane.showMessageDialog(null, "Houve um empate na Eleição.");
        }
    }

    public void SegundoColocado(){
        if(resultado[0] > resultado[1]){
            JOptionPane.showMessageDialog(null, "A Segunda Colocação foi ocupada por Maria com: " +resultado[1]+ " votos.");
        }else if(resultado[0] < resultado[1]){
            JOptionPane.showMessageDialog(null, "A Segunda Colocação foi ocupada por José com: " +resultado[0]+ " votos.");
        }else{
            JOptionPane.showMessageDialog(null, "Houve um empate na Eleição.");
        }
    }

    public void VotosBrancos(){
        JOptionPane.showMessageDialog(null, "Foram somados " +resultado[2]+ " votos brancos.");
    }

    public void VotosNulos(){
        for(int i = 4; i < 100; i++){
            resultado[3] += resultado[i];
        }
        JOptionPane.showMessageDialog(null,"Foram somados " +resultado[3]+ " votos nulos.");
    }

    public void ExibeEleitores(){
        for(int i = 0; i < 10; i++) {
            System.out.println("Eleitor: " +apuracao[i].numeroEleitor);
        }
    }

    public void ExibeApuracao() throws IOException{
        BufferedReader ler = new BufferedReader(new FileReader(fileName3));

        System.out.println("\n -----------------APURAÇÃO DA VOTAÇÃO----------------- \n");
        for(int i = 0; i < 10; i++){
            System.out.println("Número da Seção: " +Integer.parseInt(ler.readLine()));
            System.out.println("Código do Candidato: " +Integer.parseInt(ler.readLine()));
            System.out.println("Número de Eleitor: " +Integer.parseInt(ler.readLine())+ "\n");
        }
        ler.close();
    }
}