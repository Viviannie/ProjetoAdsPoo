package projetoAds.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import projetoAds.classesBasicas.Vendedor;
import projetoAds.conexao.Conectar;
import projetoAds.conexao.ConexaoBD;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;

/**
 *
 * @author Grupo Programação Orientada a Objetos
 */
public class DAOVendedorImpl implements DAOVendedor {

    private ConexaoBD con;

    public DAOVendedorImpl() {
        con = Conectar.getInstancia();
    }

    @Override
    public void incluir(Vendedor vendedor) throws ConexaoException, DAOException {

        Connection c = con.conectar();
        String sql = "INSERT INTO vendedor (vend_nome) VALUES (?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, vendedor.getVend_nome()); //Referente ao indice da interogação
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {             //o bloco do finally será sempre executado, sempre. 
            con.desconectar(c);
        }
    }

    @Override
    public void excluir(Vendedor vendedor) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "DELETE FROM vendedor WHERE (id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, vendedor.getVend_nome());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public void alterar(Vendedor vendedor) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "UPDATE vendedor SET descricao=? WHERE (id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, vendedor.getVend_nome());
            pstm.setInt(2, vendedor.getVend_id());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public Vendedor pesquisar(Integer vend_cod) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT id, descricao FROM vendedor WHERE (cod=?)";
        Vendedor vend = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, vend_cod);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                vend = new Vendedor();
                vend.setVend_cod(rs.getInt("id"));
            }
            return vend;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public ArrayList<Vendedor> listar() throws ConexaoException,DAOException {
        Connection c = con.conectar();
        String sql = "SELECT id, descricao FROM vendedor WHERE (id=?)";
        ArrayList<Vendedor> lista = new ArrayList();
        Vendedor vend;
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                vend = new Vendedor();
                vend.setVend_id(rs.getInt("id"));
                lista.add(vend);
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }
}
