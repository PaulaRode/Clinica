package controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Medico;


public class MedicoController {

    public boolean inserirMedico(Medico medico) {
        String sql = "INSERT INTO medico(nome, especialidade, CRM) "
                + "VALUES (?, ?, ?)";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setString(1, medico.getNome());
            comando.setString(2, medico.getEspecialidade());
            comando.setString(3, medico.getCRM());

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

    
    public List<Medico> listarMedico() {
    String sql = "SELECT * FROM medico";

    // Cria a lista de médicos que será retornada
    List<Medico> listaMedicos = new ArrayList<>();

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

        // Percorre o resultado e monta os objetos Medico
        while (resultado.next()) {
            Medico medico = new Medico();
            medico.setId(resultado.getInt("id"));
            medico.setNome(resultado.getString("nome"));
            medico.setEspecialidade(resultado.getString("especialidade"));
            medico.setCRM(resultado.getString("crm"));

            listaMedicos.add(medico);
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Erro ao listar médicos: " + ex.getMessage());
    }

    return listaMedicos;
} 
     
    public boolean alterarMedico(Medico medico) {
        String sql = "UPDATE medico SET nome = ?, especialidade = ?, CRM = ? WHERE ID = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setString(1, medico.getNome());
            comando.setString(2, medico.getEspecialidade());
            comando.setString(3, medico.getCRM());
            comando.setInt(4, medico.getId());

            comando.executeUpdate();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

    public Medico buscarPorId(int idMedico) {
        String sql = "SELECT * FROM medico WHERE ID = ?";

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;
        Medico medico = new Medico();

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setInt(1, idMedico);

            resultado = comando.executeQuery();

            if (resultado.next()) {
                medico.setId(resultado.getInt("ID"));
                medico.setNome(resultado.getString("nome"));
                medico.setEspecialidade(resultado.getString("especialidade"));
                medico.setCRM(resultado.getString("CRM"));
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar médico: " + e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }
        return medico;
    }

    public List<Medico> listarMedicos() {
        List<Medico> listaMedicos = new ArrayList<>();
        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;
        ResultSet resultado = null;
        
        try {
             String sql = "SELECT * FROM medico";
            comando = gerenciador.prepararComando(sql);
            resultado = comando.executeQuery();

            while (resultado.next()) {
                Medico medico = new Medico();
                medico.setId(resultado.getInt("ID"));
                medico.setNome(resultado.getString("nome"));
                medico.setEspecialidade(resultado.getString("especialidade"));
                medico.setCRM(resultado.getString("CRM"));

                listaMedicos.add(medico);
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar médicos: " + e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando, resultado);
        }

        return listaMedicos;
    }

    public boolean deletar(int idMedico) {
        // Coluna ID em maiúsculas (conforme O banco)
        String sql = "DELETE FROM medico WHERE ID = ?"; // Coluna ID em maiúsculas (conforme seu banco)

        GerenciadorConexao gerenciador = new GerenciadorConexao();
        PreparedStatement comando = null;

        try {
            comando = gerenciador.prepararComando(sql);
            comando.setInt(1, idMedico);

            // retorna número de linhas excluídas
            int linhasAfetadas = comando.executeUpdate();
            return linhasAfetadas > 0;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir médico: " + e.getMessage());
        } finally {
            gerenciador.fecharConexao(comando);
        }
        return false;
    }

}
