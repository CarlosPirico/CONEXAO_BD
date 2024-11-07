package br.com.aula.conexao.app;

import java.util.Scanner;

import br.com.aula.conexao.service.AtualizarAluno;
import br.com.aula.conexao.service.ConexaoDB;
import br.com.aula.conexao.service.DeletarAluno;
import br.com.aula.conexao.service.InserirAluno;
import br.com.aula.conexao.service.LerDadosAlunos;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection conexao = ConexaoDB.conectar();
        if (conexao != null) {
            Scanner scanner = new Scanner(System.in);
            int opcao;
            do {
                System.out.println("=== Menu Principal ===");
                System.out.println("1. Inserir Aluno");
                System.out.println("2. Atualizar Aluno");
                System.out.println("3. Deletar Aluno");
                System.out.println("4. Ler Registros de Alunos");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); // Consumir quebra de linha

                switch (opcao) {
                    case 1:
                    	new InserirAluno(conexao, scanner);
                        break;
                    case 2:
                    	new AtualizarAluno(conexao, scanner);
                        break;
                    case 3:
                    	new DeletarAluno(conexao, scanner);
                        break;
                    case 4:
                    	new LerDadosAlunos(conexao);
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } while (opcao != 0);
            scanner.close();
        }
    }

}
