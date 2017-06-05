package projetoAds.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import projetoAds.classesBasicas.FormaPag;
import projetoAds.conexao.Conectar;
import projetoAds.conexao.ConexaoBD;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;

/**
 *
 * @author Grupo
 */
public class DAOFormaPagImpl implements DAOFormaPag {

    private ConexaoBD con;
    
    public DAOFormaPagImpl() {
        con = Conectar.getInstancia();
    }
    
    @Override
    public void incluir(FormaPag formaPag) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "INSERT INTO forma_pag (frm_id, frm_desc, pag_id) VALUES (?,?,?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, formaPag.getFrm_id());
            pstm.setString(2, formaPag.getFrm_desc());
            pstm.setInt(3, formaPag.getPagamento().getPag_id());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public void excluir(FormaPag formaPag) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "DELETE FROM forma_pag WHERE frm_id = ?";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, formaPag.getFrm_id());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public void alterar(FormaPag formaPag) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "UPDATE forma_pag SET frm_desc=?, pag_id=? WHERE frm_id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, formaPag.getFrm_desc());
            pstm.setInt(2, formaPag.getPagamento().getPag_id());
            pstm.setInt(3, formaPag.getFrm_id());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public FormaPag pesquisar(Integer frm_id) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT frm_id, frm_desc, pag_id FROM forma_pag WHERE frm_id=?)";
        FormaPag formaPag = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, frm_id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                formaPag = new FormaPag();
                formaPag.setFrm_id(rs.getInt("frm_id"));
                formaPag.setFrm_desc(rs.getString("frm_desc"));
                formaPag.getPagamento().setPag_id(rs.getInt("pag_id"));
            }
            return formaPag;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public ArrayList<FormaPag> listar() throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT frm_id, frm_desc, pag_id FROM forma_pag";
        ArrayList<FormaPag> lista = new ArrayList();
        FormaPag formaPag;
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery("sql");
            while (rs.next()) {
                formaPag = new FormaPag();
                formaPag.setFrm_id(rs.getInt("frm_id"));
                formaPag.setFrm_desc(rs.getString("frm_desc"));
                formaPag.getPagamento().setPag_id(rs.getInt("pag_id"));
                lista.add(formaPag);
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    
}
