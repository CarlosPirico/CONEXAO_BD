package br.com.aula.conexao.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeletarAluno {
	
    public DeletarAluno(Connection conexao, Scanner scanner) {
        String sql = "DELETE FROM alunos WHERE id = ?";
        try {
            System.out.print("Digite o ID do aluno que deseja deletar: ");
            int id = scanner.nextInt();

            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Registro deletado com sucesso!");
            } else {
                System.out.println("Nenhum registro encontrado com o ID especificado.");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao deletar dados: " + e.getMessage());
        }
    }

}
