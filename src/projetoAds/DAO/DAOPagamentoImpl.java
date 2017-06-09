package projetoAds.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    
    public DAOPagamentoImpl(){
        con = Conectar.getInstancia();
    }

    @Override
    public void incluir(Pagamento pagamento) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "INSERT INTO pagamento (pag_id, pag_valor, ped_id) VALUES (?,?,?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, pagamento.getId());
            pstm.setDouble(2, pagamento.getValor());
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
        String sql = "UPDATE pagamento SET pag_valor=?, ped_id=? WHERE pag_id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setDouble(1, pagamento.getValor());
            pstm.setInt(2, pagamento.getPedido().getId());
            pstm.setInt(3, pagamento.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public Pagamento pesquisar(Integer id) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT pag_id, pag_valor, ped_id FROM pagamento WHERE pag_id=?)";
        Pagamento pagamento = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                pagamento = new Pagamento();
                pagamento.setId(rs.getInt("pag_id"));
                pagamento.setValor(rs.getDouble("pag_valor"));
                pagamento.getPedido().setId(rs.getInt("ped_id"));
            }
            return pagamento;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public ArrayList<Pagamento> listar() throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT pag_id, pag_valor, ped_id FROM pagamento";
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
                lista.add(pagamento);
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
}
