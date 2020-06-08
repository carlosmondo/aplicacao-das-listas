package br.univille;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int countNormais = 0;
        int countPrioritarias = 0;
        Senha senha = new Senha();

        SLinkedList<String> historico = new SLinkedList<String>();
        SLinkedList<Senha> normais = new SLinkedList<Senha>();
        SLinkedList<Senha> prioritarias = new SLinkedList<Senha>();

        boolean keep = true;

        while(keep){

            Object[] historicoArray = historico.toArray();

            if (historico.size > 6){
                historicoArray = Arrays.copyOfRange(historicoArray, 0, 5);
            }

            System.out.print("\n\nHistórico de senhas :: " + Arrays.toString(historicoArray));

            System.out.print("\n\nInforme a opção: " +
                    "\n1 - Senha Normal;" +
                    "\n2 - Senha Prioritária;" +
                    "\n3 - Próxima Senha;" +
                    "\n4 - Encerrar linha de comando;" +
                    "\n\nOpção :: ");

            input.hasNext();

            switch (input.nextInt()){
                case 1:
                    System.out.println("Imprimindo senha normal...");

                    countNormais++;
                    senha = new Senha(countNormais, new Date(),false);
                    normais.addLast(senha);

                    System.out.println("SENHA :: " + senha.getNumero() +
                        "\nDATA :: " + senha.getData() +
                        "\nPRIORITÁRIA :: " + senha.isPrioritaria());

                    break;
                case 2:
                    System.out.println("Imprimindo senha prioritária...");

                    countPrioritarias++;
                    senha = new Senha(countPrioritarias, new Date(),true);
                    prioritarias.addLast(senha);

                    System.out.println("SENHA :: " + senha.getNumero() +
                            "DATA :: " + senha.getData() +
                            "PRIORITÁRIA :: " + senha.isPrioritaria());

                    break;
                case 3:
                    System.out.println("Chamando próxima senha...");
                    Senha proximaSenha = null;
                    String prioriadade = null;

                    if (!prioritarias.isEmpty()){
                        proximaSenha = prioritarias.removeFirst();
                        prioriadade = "S-"+proximaSenha.getNumero();
                    } else {
                        if (normais.isEmpty()){
                            System.out.println("NÃO EXISTEM MAIS SENHAS A SEREM CHAMADAS!");
                            break;
                        }

                        proximaSenha = normais.removeFirst();
                        prioriadade = "N-"+proximaSenha.getNumero();
                    }

                    System.out.print("PROXIMA SENHA :: ");
                    historico.addFirst(prioriadade);

                    break;
                case 4:
                    System.out.println("Encerrando linha de comando...");
                    keep = false;

                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }
}
