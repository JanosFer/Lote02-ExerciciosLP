package br.com.segundo_java.sistema_estatistica_transito;

import javax.swing.JOptionPane;

public class Metodos {
    public Estatistica[] Cadastra(Estatistica[] estatistica){//Método para cadastrar Cidades, seu código e sua quantidade de acidentes.
        for(int i = 0; i < 10; i++){
            estatistica[i].codigoCidade =Integer.parseInt(JOptionPane.showInputDialog("Informe o código da cidade: "));
            estatistica[i].nomeCidade = JOptionPane.showInputDialog("Informe o nome da cidade: ");
            estatistica[i].qtdAcidentes = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de acidentes: "));
        }
        return estatistica;
    }

    public void nAcidentes(Estatistica[] estatistica){//Método para consultar cidades com mais de 100 acidentes e menos de 500.
        System.out.println("As cidades com mais de 100 acidentes e menos de 500 acidentes, são: ");
        for(int i = 0; i < 10; i++){
            if(estatistica[i].qtdAcidentes > 100 && estatistica[i].qtdAcidentes < 500){
                System.out.println(estatistica[i].codigoCidade+ " " +estatistica[i].nomeCidade+ " com " +estatistica[i].qtdAcidentes+ " acidentes.");
            }
        }
    }

    public void MaiorOuMenor(Estatistica[] estatistica){//Método para consultar o MAIOR e o MENOR indice de acidentes.
        for(int i = 0; i < 9; i++){
            for(int j = (i+1); j < 10; j++){
                if(estatistica[i].qtdAcidentes > estatistica[j].qtdAcidentes){
                    int aux = estatistica[i].qtdAcidentes;
                    estatistica[i].qtdAcidentes = estatistica[j].qtdAcidentes;
                    estatistica[j].qtdAcidentes = aux;
                }
            }
        }

        JOptionPane.showMessageDialog(null, "A cidade com maior número de acidentes foi " +estatistica[9].codigoCidade+ " " +estatistica[9].nomeCidade+ " com: " +estatistica[9].qtdAcidentes+ " acidentes. \n A cidade com menor número de acidentes foi " +estatistica[0].codigoCidade+ " " +estatistica[0].nomeCidade+ " com: " +estatistica[0].qtdAcidentes+ " acidentes.");
    }

    public void Media(Estatistica[] estatistica){//Método para calcular a média de acidentes e exibir cidades acima da mesma.
        double media = 0;

        for(int i = 0; i < 10; i++){
            media += estatistica[i].qtdAcidentes;
        }

        media /= 10;

        System.out.println("As cidades que estão acima da média de acidentes são: ");
        for(int i = 0; i < 10; i++){
            if(estatistica[i].qtdAcidentes > media) {
                System.out.println(estatistica[i].codigoCidade + " " + estatistica[i].nomeCidade + " com " + estatistica[i].qtdAcidentes + " acidentes.");
            }
        }
    }
}