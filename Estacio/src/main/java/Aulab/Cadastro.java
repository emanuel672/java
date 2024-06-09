package Aulab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;
 
public class Cadastro {
 
    public void adicionarPessoa(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa(nome, sexo, dataNascimento, endereco, telefone) VALUES(?,?,?,?,?)";
        try (Connection con = ConectionFabric.getConection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setString(3, pessoa.getDataNascimento().toString());
            stmt.setString(4, pessoa.getEndereco());
            stmt.setString(5, pessoa.getTelefone());
            stmt.executeUpdate();
            System.out.println("Pessoa adicionada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao adicionar pessoa: " + e.getMessage());
        }
    }
 
    public void listarPessoas() {
        String sql = "SELECT * FROM pessoa";
        try (Connection con = ConectionFabric.getConection(); Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Pessoa pessoa = new Pessoa(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("sexo"),
                        rs.getDate("dataNascimento").toLocalDate(),
                        rs.getString("endereco"),
                        rs.getString("telefone")
                );
                System.out.println(pessoa);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar pessoas: " + e.getMessage());
        }
    }
 
    public void atualizarPessoa(Pessoa pessoa) {
        String sql = "UPDATE pessoa SET nome=?, sexo=?, dataNascimento=?, endereco=?, telefone=? WHERE id=?";
        try (Connection con = ConectionFabric.getConection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, pessoa.getNome());
            stmt.setString(2, pessoa.getSexo());
            stmt.setString(3, pessoa.getDataNascimento().toString());
            stmt.setString(4, pessoa.getEndereco());
            stmt.setString(5, pessoa.getTelefone());
            stmt.setInt(6, pessoa.getId());
            stmt.executeUpdate();
            System.out.println("Pessoa atualizada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pessoa: " + e.getMessage());
        }
    }
 
    public void deletarPessoa(int id) {
        String sql = "DELETE FROM pessoa WHERE id=?";
        try (Connection con = ConectionFabric.getConection(); PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("Pessoa deletada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao deletar pessoa: " + e.getMessage());
        }
    }
 
    public static void main(String[] args) {
        Cadastro cadastro = new Cadastro();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Adicionar Pessoa");
            System.out.println("2. Listar Pessoas");
            System.out.println("3. Atualizar Pessoa");
            System.out.println("4. Deletar Pessoa");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consome a nova linha
 
            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();
                    System.out.print("Sexo: ");
                    String sexo = scanner.nextLine();
                    System.out.print("Data de Nascimento (AAAA-MM-DD): ");
                    LocalDate dataNascimento = LocalDate.parse(scanner.nextLine());
                    System.out.print("Endereço: ");
                    String endereco = scanner.nextLine();
                    System.out.print("Telefone: ");
                    String telefone = scanner.nextLine();
                    Pessoa novaPessoa = new Pessoa(nome, sexo, dataNascimento, endereco, telefone);
                    cadastro.adicionarPessoa(novaPessoa);
                    break;
                case 2:
                    cadastro.listarPessoas();
                    break;
                case 3:
                    System.out.print("ID da Pessoa a ser atualizada: ");
                    int idAtualizar = scanner.nextInt();
                    scanner.nextLine(); // Consome a nova linha
                    System.out.print("Nome: ");
                    nome = scanner.nextLine();
                    System.out.print("Sexo: ");
                    sexo = scanner.nextLine();
                    System.out.print("Data de Nascimento (AAAA-MM-DD): ");
                    dataNascimento = LocalDate.parse(scanner.nextLine());
                    System.out.print("Endereço: ");
                    endereco = scanner.nextLine();
                    System.out.print("Telefone: ");
                    telefone = scanner.nextLine();
                    Pessoa pessoaAtualizada = new Pessoa(idAtualizar, nome, sexo, dataNascimento, endereco, telefone);
                    cadastro.atualizarPessoa(pessoaAtualizada);
                    break;
                case 4:
                    System.out.print("ID da Pessoa a ser deletada: ");
                    int idDeletar = scanner.nextInt();
                    cadastro.deletarPessoa(idDeletar);
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
