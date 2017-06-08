package projetoAds.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import projetoAds.classesBasicas.Produto;
import projetoAds.conexao.Conectar;
import projetoAds.conexao.ConexaoBD;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;

/**
 *
 * @author Grupo
 */
public class DAOProdutoImpl implements DAOProduto {

    private ConexaoBD con;

    public DAOProdutoImpl() {
        con = Conectar.getInstancia();
    }

    @Override
    public void incluir(Produto produto) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "INSERT INTO produto (prd_desc, prd_estoqueminimo, prd_estoqueatual) VALUES (?,?,?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, produto.getPrd_desc());   //Referente ao indice da interogação
            pstm.setInt(2, produto.getPrd_estoqueminimo());
            pstm.setInt(3, produto.getPrd_estoqueatual());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {          //o bloco do finally será sempre executado, sempre. 
            con.desconectar(c);
        }
    }

    @Override
    public void excluir(Produto produto) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "DELETE FROM produto WHERE (prd_id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, produto.getPrd_id());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public void alterar(Produto produto) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "UPDATE produto SET prd_desc=?, prd_estoqueminimo=?, prd_estoqueatual=?  WHERE (prd_id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, produto.getPrd_desc());
            pstm.setInt(2, produto.getPrd_estoqueminimo());
            pstm.setInt(3, produto.getPrd_estoqueatual());
            pstm.setInt(4, produto.getPrd_id());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public Produto pesquisar(Integer prd_id) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT prd_id, prd_desc, prd_estoqueminimo, prd_estoqueatual FROM produto WHERE (prd_id=?)";
        Produto prd = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, prd_id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                prd = new Produto();
                prd.setPrd_id(rs.getInt("prd_id"));
                prd.setPrd_desc(rs.getString("prd_desc"));
                prd.setPrd_estoqueminimo(rs.getInt("prd_estoqueminimo"));
                prd.setPrd_estoqueatual(rs.getInt("prd_estoqueatual"));
            }
            return prd;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public Produto pesquisar(String prd_desc) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT prd_id, prd_desc, prd_estoqueminimo, prd_estoqueatual FROM produto WHERE (prd_id=?)";
        Produto prd = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, prd_desc);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                prd = new Produto();
                prd.setPrd_id(rs.getInt("prd_id"));
                prd.setPrd_desc(rs.getString("prd_desc"));
                prd.setPrd_estoqueminimo(rs.getInt("prd_estoqueminimo"));
                prd.setPrd_estoqueatual(rs.getInt("prd_estoqueatual"));
            }
            return prd;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public ArrayList<Produto> listar() throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT prd_id, prd_desc, prd_estoqueminimo, prd_estoqueatual FROM produto";
        ArrayList<Produto> lista = new ArrayList();
        Produto prd;
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                prd = new Produto();
                prd.setPrd_id(rs.getInt("prd_id"));
                prd.setPrd_desc(rs.getString("prd_desc"));
                prd.setPrd_estoqueminimo(rs.getInt("prd_estoqueminimo"));
                prd.setPrd_estoqueatual(rs.getInt("prd_estoqueatual"));
                lista.add(prd);
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }
}
