package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Consulta;
import model.Medico;

public class ConsultaController {

    public boolean inserirConsulta(Consulta consulta) {
        String sql = "INSERT INTO consulta(cliente_id, medico_id, data_consulta, hora_consulta) VALUES (?, ?, ?, ?)";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setInt(1, consulta.getCliente().getId());
            comando.setInt(2, consulta.getMedico().getId());
            comando.setDate(3, new java.sql.Date(consulta.getData().getTime()));
            comando.setTime(4, consulta.getHora());
            comando.executeUpdate();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir consulta: " + ex.getMessage());
            return false;
        }
    }

    // Atualiza uma consulta existente
    public boolean alterarConsulta(Consulta consulta) {
        String sql = "UPDATE consulta SET cliente_id = ?, medico_id = ?, data_consulta = ?, hora_consulta = ? WHERE id = ?";

        try (PreparedStatement comando = new GerenciadorConexao().prepararComando(sql)) {
            comando.setInt(1, consulta.getCliente().getId());
            comando.setInt(2, consulta.getMedico().getId());
            comando.setDate(3, new java.sql.Date(consulta.getData().getTime()));
            comando.setTime(4, consulta.getHora());
            comando.setInt(5, consulta.getId());
            comando.executeUpdate();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar consulta: " + ex.getMessage());
            return false;
        }
    }

    public boolean excluirConsulta(int id) {
        String sql = "DELETE FROM consulta WHERE id = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setInt(1, id);
            comando.executeUpdate();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir consulta: " + ex.getMessage());
            return false;
        }
    }

    public Consulta buscarPorId(int id) {
        String sql = "SELECT * FROM consulta WHERE id = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setInt(1, id);
            resultado = comando.executeQuery();

            if (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultado.getInt("id_cliente"));

                Medico medico = new Medico();
                medico.setId(resultado.getInt("id_medico"));

                return new Consulta(
                        resultado.getInt("id"),
                        cliente,
                        medico,
                        resultado.getDate("data"),
                        resultado.getTime("hora")
                );
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar consulta: " + ex.getMessage());
        }

        return null;
    }

    public List<Cliente> listarClientes() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        GerenciadorConexao g = new GerenciadorConexao();
        try (PreparedStatement comando = g.prepararComando(sql);
                ResultSet rs = comando.executeQuery()) {

            while (rs.next()) {
                Cliente c = new Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                lista.add(c);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes: " + ex.getMessage());
        }

        return lista;
    }

    public List<Medico> listarMedicos() {
        List<Medico> lista = new ArrayList<>();
        String sql = "SELECT * FROM medicos";

        GerenciadorConexao g = new GerenciadorConexao();
        try (PreparedStatement comando = g.prepararComando(sql);
                ResultSet rs = comando.executeQuery()) {

            while (rs.next()) {
                Medico m = new Medico();
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setEspecialidade(rs.getString("especialidade"));
                m.setCRM(rs.getString("crm"));
                lista.add(m);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar médicos: " + ex.getMessage());
        }

        return lista;
    }

    // Lista simples de consultas (com apenas IDs de cliente/médico)
    public List<Consulta> listarConsultas() {
        List<Consulta> listaConsultas = new ArrayList<>();
        String sql = "SELECT * FROM consulta";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            comando = gerenciador.prepararComando(sql);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultado.getInt("id_cliente"));

                Medico medico = new Medico();
                medico.setId(resultado.getInt("id_medico"));

                Consulta consulta = new Consulta(
                        resultado.getInt("id"),
                        cliente,
                        medico,
                        resultado.getDate("data"),
                        resultado.getTime("hora")
                );

                listaConsultas.add(consulta);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar consultas: " + ex.getMessage());
        }

        return listaConsultas;
    }

    // Lista de consultas com nomes de cliente e médico
    public List<Consulta> listarConsultasComNomes() {
        List<Consulta> listaConsultas = new ArrayList<>();

        String sql = "Select c.id, c.data_consulta, c.hora_consulta,\n"
                + "       cli.id AS cliente_id, cli.nome AS cliente_nome,\n"
                + "       med.id AS medico_id, med.nome AS medico_nome "
                + "FROM consulta c "
                + "JOIN cliente cli ON c.cliente_id = cli.id "
                + "JOIN medico med ON c.medico_id = med.id";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;

        try {
            comando = gerenciador.prepararComando(sql);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(resultado.getInt("cliente_id"));
                cliente.setNome(resultado.getString("cliente_nome"));

                Medico medico = new Medico();
                medico.setId(resultado.getInt("medico_id"));
                medico.setNome(resultado.getString("medico_nome"));

                Consulta consulta = new Consulta();
                consulta.setId(resultado.getInt("id"));
                consulta.setData(resultado.getDate("data_consulta"));
                consulta.setHora(resultado.getTime("hora_consulta"));
                consulta.setCliente(cliente);
                consulta.setMedico(medico);

                listaConsultas.add(consulta);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao listar consultas com nomes: " + ex.getMessage());
        }

        return listaConsultas;
    }
}
