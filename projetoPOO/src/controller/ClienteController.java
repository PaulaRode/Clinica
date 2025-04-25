package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Cliente;

public class ClienteController {

    public boolean inserirCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente(nome, emailCli, cpf, dataNasc) VALUES (?, ?, ?, ?)";

        //Cria uma instância do gerenciador de conexão(conexão com o banco de dados),
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        //Declara as variáveis como nulas antes do try para poder usar no finally
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            //prepara o sql, analisando o formato e as váriaveis
            comando = gerenciador.prepararComando(sql);

            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEmailCli());
            comando.setString(3, cliente.getCpf());
            comando.setDate(4, new java.sql.Date(cliente.getDataNasc().getTime()));
            comando.executeUpdate();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir cliente: " + ex.getMessage());
            return false;
        }
    }

    public List<Cliente> listarClientes() {
        String sql = "SELECT * FROM cliente";

        // Cria a lista de clientes que será retornada
        List<Cliente> listaClientes = new ArrayList<>();

        // Instancia o gerenciador de conexão
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        // Declara as variáveis como nulas para usar no finally (se necessário)
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            // Prepara o comando SQL
            comando = gerenciador.prepararComando(sql);
            // Executa a consulta
            resultado = comando.executeQuery();

            // Percorre o resultado e monta os objetos Cliente
            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultado.getInt("id"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setEmailCli(resultado.getString("emailCli"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setDataNasc(resultado.getDate("dataNasc"));

                listaClientes.add(cliente);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes: " + ex.getMessage());
        }

        return listaClientes;
    }

    public boolean alterarCliente(Cliente cliente) {
        // Método para alterar os dados de um cliente no banco de dados
        String sql = "UPDATE cliente SET nome = ?,"
                + " emailCli = ?, cpf = ?, dataNasc = ? WHERE id = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            // Prepara o comando SQL
            comando = gerenciador.prepararComando(sql);

            // Define os parâmetros para a query
            comando.setString(1, cliente.getNome());
            comando.setString(2, cliente.getEmailCli());
            comando.setString(3, cliente.getCpf());
            comando.setDate(4, new java.sql.Date(cliente.getDataNasc().getTime()));
            comando.setInt(5, cliente.getId());

            //Executa o insert
            comando.executeUpdate();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar " + ex.getMessage());
            return false;
        }
    }

    public boolean deletar(int id) {
        String sql = "DELETE FROM cliente WHERE id = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setInt(1, id);
            comando.executeUpdate();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex.getMessage());
            return false;
        }
    }

    public Cliente buscarPorId(int id) {
        //Guarda o sql
        String sql = "SELECT * FROM cliente "
                + " WHERE id = ? ";
        //Cria um gerenciador de conexão
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            //Preparo do comando sql
            comando = gerenciador.prepararComando(sql);
            comando.setInt(1, id);

            //Executo o comando e guardo o resultado
            resultado = comando.executeQuery();

            //Irá percorrer os registros do resultado do sql
            //A cada next() a variavel resultado aponta para o próximo registro 
            //enquanto next() == true quer dizer que tem registros
            if (resultado.next()) {

                //Crio um cliente vazio
                Cliente cliente = new Cliente();
                cliente.setId(resultado.getInt("id"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setEmailCli(resultado.getString("emailCli"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setDataNasc(resultado.getDate("dataNasc"));
                return cliente;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar cliente: " + ex.getMessage());
        }
        return null;
    }

    public List<Cliente> consultar() {
        //Guarda o sql
        String sql = "SELECT * FROM cliente;";
        //Crio a lista de usuários vazia
        List<Cliente> listaClientes = new ArrayList<>();

        //Cria um gerenciador de conexão
        GerenciadorConexao gerenciador = new GerenciadorConexao();

        //Cria as variáveis vazias antes do try pois vão ser usadas no finally
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            //Preparo do comando sql
            comando = gerenciador.prepararComando(sql);
            //Como não há parâmetros já executo direto
            resultado = comando.executeQuery();

            while (resultado.next()) {

                //Crio um novo cliente vazio
                Cliente cliente = new Cliente();
                //Leio as informações da variável resultado e guardo no cliente
                cliente.setId(resultado.getInt("id"));
                cliente.setNome(resultado.getString("nome"));
                cliente.setEmailCli(resultado.getString("emailCli"));
                cliente.setCpf(resultado.getString("cpf"));
                cliente.setDataNasc(resultado.getDate("dataNasc"));
                //adiciono o cliente na lista
                listaClientes.add(cliente);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes: " + ex.getMessage());
        }

        return listaClientes;
    }
}
