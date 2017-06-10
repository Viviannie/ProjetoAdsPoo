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
 * @author Grupo Programação Orientada a Objetos
 */
public class DAOFormaPagImpl implements DAOFormaPag {

    private final ConexaoBD con;        //por que o netbeans pede para colocar como final?
    
    public DAOFormaPagImpl() {
        con = Conectar.getInstancia();
    }
    
    @Override
    public void incluir(FormaPag formaPag) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "INSERT INTO Forma_Pag (frm_id, frm_desc) VALUES (?,?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, formaPag.getId());
            pstm.setString(2, formaPag.getDesc());
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
        String sql = "DELETE FROM Forma_Pag WHERE (frm_id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, formaPag.getId());
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
        String sql = "UPDATE Forma_Pag SET frm_id=?, frm_desc=? WHERE (frm_id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, formaPag.getId());
            pstm.setString(2, formaPag.getDesc());
            pstm.setInt(3, formaPag.getId());            
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public FormaPag pesquisar(Integer id) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT frm_id, frm_desc FROM Forma_Pag WHERE (frm_id=?)";
        FormaPag formaPag = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                formaPag = new FormaPag();
                formaPag.setId(rs.getInt("frm_id"));
                formaPag.setDesc(rs.getString("frm_desc"));
            }
            return formaPag;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public FormaPag pesquisar(String desc) throws ConexaoException,DAOException {
        Connection c = con.conectar();
        String sql = "SELECT frm_id, frm_desc FROM Forma_Pag WHERE (frm_desc=?)";
        FormaPag formaPag = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, desc);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                formaPag = new FormaPag();
                formaPag.setId(rs.getInt("frm_id"));
                formaPag.setDesc(rs.getString("frm_desc"));
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
        String sql = "SELECT frm_id, frm_desc FROM Forma_Pag";
        ArrayList<FormaPag> lista = new ArrayList();
        FormaPag formaPag;
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                formaPag = new FormaPag();
                formaPag.setId(rs.getInt("frm_id"));
                formaPag.setDesc(rs.getString("frm_desc"));
                lista.add(formaPag);
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }
    
    
}
