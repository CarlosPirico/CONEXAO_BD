package br.com.aula.conexao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AtualizarAluno {
	
    public AtualizarAluno(Connection conexao, Scanner scanner) {
        String sql = "UPDATE alunos SET nome = ?, idade = ? WHERE id = ?";
        try {
            System.out.print("Digite o ID do aluno que deseja atualizar: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consumir quebra de linha
            System.out.print("Digite o novo nome do aluno: ");
            String nome = scanner.nextLine();
            System.out.print("Digite a nova idade do aluno: ");
            int idade = scanner.nextInt();

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setInt(2, idade);
            stmt.setInt(3, id);
            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Registro atualizado com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado com o ID especificado.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar dados: " + e.getMessage());
        }
    }

}
