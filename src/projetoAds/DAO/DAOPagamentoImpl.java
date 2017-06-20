package projetoAds.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import projetoAds.classesBasicas.Pagamento;
import projetoAds.conexao.Conectar;
import projetoAds.conexao.ConexaoBD;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;

/**
 *
 * @author Grupo Programação Orientada a Objetos
 */
public class DAOPagamentoImpl implements DAOPagamento {

    private ConexaoBD con;

    public DAOPagamentoImpl() {
        con = Conectar.getInstancia();
    }

    @Override
    public void incluir(Pagamento pagamento) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "INSERT INTO pagamento (pag_valor, pag_formaPag, ped_id) VALUES (?,?,?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setDouble(1, pagamento.getValor());
            pstm.setString(2, pagamento.getFormaPag());
            pstm.setInt(3, pagamento.getPedido().getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public void excluir(Pagamento pagamento) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "DELETE FROM pagamento WHERE pag_id=?";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, pagamento.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public void alterar(Pagamento pagamento) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "UPDATE pagamento SET pag_valor=?, pag_formaPag=?, ped_id=? WHERE (pag_id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setDouble(1, pagamento.getValor());
            pstm.setString(2, pagamento.getFormaPag());
            pstm.setInt(3, pagamento.getPedido().getId());
            pstm.setInt(4, pagamento.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public Pagamento pesquisar(Integer pag_id) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT pag_id, pag_valor, ped_id, pag_formaPag FROM pagamento WHERE (pag_id=?)";
        Pagamento pagamento = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, pag_id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                pagamento = new Pagamento();
                pagamento.setId(rs.getInt("pag_id"));
                pagamento.setValor(rs.getDouble("pag_valor"));
                pagamento.getPedido().setId(rs.getInt("ped_id"));
                pagamento.setFormaPag(rs.getString("pag_formaPag"));
            }
            return pagamento;
        } catch (SQLException e) {
            throw new DAOException("Erro ao buscar Pagamento!");
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public ArrayList<Pagamento> listar() throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT pag_id, pag_valor, ped_id, pag_formaPag FROM pagamento";
        ArrayList<Pagamento> lista = new ArrayList();
        Pagamento pagamento;
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                pagamento = new Pagamento();
                pagamento.setId(rs.getInt("pag_id"));
                pagamento.setValor(rs.getDouble("pag_valor"));
                pagamento.getPedido().setId(rs.getInt("ped_id"));
                pagamento.setFormaPag(rs.getString("pag_formaPag"));
                lista.add(pagamento);
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

}
