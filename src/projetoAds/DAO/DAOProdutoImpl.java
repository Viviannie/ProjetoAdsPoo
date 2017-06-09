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
 * @author Grupo Programação Orientada a Objetos
 */
public class DAOProdutoImpl implements DAOProduto {

    private ConexaoBD con;

    public DAOProdutoImpl() {
        con = Conectar.getInstancia();
    }

    @Override
    public void incluir(Produto produto) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "INSERT INTO produto (prd_desc, prd_estoqueminimo, prd_estoqueatual, fbr_cnpj) VALUES (?,?,?,?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, produto.getDesc());   //Referente ao indice da interogação
            pstm.setInt(2, produto.getEstoqueMinimo());
            pstm.setInt(3, produto.getEstoqueAtual());
            pstm.setString(4, produto.getFabricante().getCnpj());
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
            pstm.setInt(1, produto.getId());
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
        String sql = "UPDATE produto SET prd_desc=?, prd_estoqueminimo=?, prd_estoqueatual=? fbr_cnpj=? WHERE (prd_id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, produto.getDesc());
            pstm.setInt(2, produto.getEstoqueMinimo());
            pstm.setInt(3, produto.getEstoqueAtual());
            pstm.setString(4, produto.getFabricante().getCnpj());
            pstm.setInt(5, produto.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public Produto pesquisar(Integer id) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT prd_id, prd_desc, prd_estoqueminimo, prd_estoqueatual, fbr_cnpj FROM produto WHERE (prd_id=?)";
        Produto prd = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                prd = new Produto();
                prd.setId(rs.getInt("prd_id"));
                prd.setDesc(rs.getString("prd_desc"));
                prd.setEstoqueMinimo(rs.getInt("prd_estoqueminimo"));
                prd.setEstoqueAtual(rs.getInt("prd_estoqueatual"));
                prd.getFabricante().setCnpj(rs.getString("fbr_cnpj"));
            }
            return prd;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public Produto pesquisar(String desc) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT prd_id, prd_desc, prd_estoqueminimo, prd_estoqueatual, fbr_cnpj FROM produto WHERE (prd_id=?)";
        Produto prd = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, desc);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                prd = new Produto();
                prd.setId(rs.getInt("prd_id"));
                prd.setDesc(rs.getString("prd_desc"));
                prd.setEstoqueMinimo(rs.getInt("prd_estoqueminimo"));
                prd.setEstoqueAtual(rs.getInt("prd_estoqueatual"));
                prd.getFabricante().setCnpj(rs.getString("fbr_cnpj"));
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
        String sql = "SELECT prd_id, prd_desc, prd_estoqueminimo, prd_estoqueatual, fbr_cnpj FROM produto";
        ArrayList<Produto> lista = new ArrayList();
        Produto prd;
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                prd = new Produto();
                prd.setId(rs.getInt("prd_id"));
                prd.setDesc(rs.getString("prd_desc"));
                prd.setEstoqueMinimo(rs.getInt("prd_estoqueminimo"));
                prd.setEstoqueAtual(rs.getInt("prd_estoqueatual"));
                prd.getFabricante().setCnpj(rs.getString("fbr_cnpj"));
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
