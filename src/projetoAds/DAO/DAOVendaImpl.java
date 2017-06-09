package projetoAds.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import projetoAds.classesBasicas.Venda;
import projetoAds.conexao.Conectar;
import projetoAds.conexao.ConexaoBD;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;

/**
  * @author Grupo Programação Orientada a Objetos
  */
public class DAOVendaImpl implements DAOVenda {
    private final ConexaoBD con; //why final?
    
    public DAOVendaImpl(){
        con = Conectar.getInstancia();
    }

    @Override
    public void incluir(Venda venda) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "INSERT INTO venda (ped_id, prd_id, prc_unitario, qtd_produtos) VALUES (?,?,?,?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, venda.getPedido().getId());   //Referente ao indice da interogação
            pstm.setInt(2, venda.getProduto().getId());
            pstm.setDouble(3, venda.getPrecoUnitario());
            pstm.setInt(4, venda.getQuantidadeProduto());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {          //o bloco do finally será sempre executado, sempre. 
            con.desconectar(c);
        }
    }

    @Override
    public void excluir(Venda pedidoProduto) throws ConexaoException, DAOException {
       Connection c = con.conectar();
        String sql = "DELETE FROM venda WHERE (ped_id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, pedidoProduto.getPedido().getId());           
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public void alterar(Venda venda) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "UPDATE pedido SET ped_id=?, prd_id=?, prc_unitario=?, qtd_produtos=? WHERE (ped_id=?, prd_id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, venda.getPedido().getId());
            pstm.setInt(2, venda.getProduto().getId());
            pstm.setDouble(3, venda.getPrecoUnitario());
            pstm.setInt(4, venda.getQuantidadeProduto());
            pstm.setInt(5, venda.getPedido().getId());
            pstm.setInt(6, venda.getProduto().getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public Venda pesquisar(Integer id) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql;
        sql = "SELECT venda.ped_id, venda.prd_id, venda.prc_unitario, venda.qtd_produtos FROM pedido JOIN venda ON venda.ped_id = pedido.id WHERE (ped_id=?)";
        Venda vend = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                vend = new Venda();
                vend.getPedido().setId(rs.getInt("ped_id"));
                vend.getProduto().setId(rs.getInt("prd_id"));
                vend.getPrecoUnitario(rs.getDouble("prc_unitario"));
                vend.getQuantidadeProduto(rs.getInt("qtd_produtos"));
            }
            return vend;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }
    
    // primeiro devo saber quem é o id e ai listar a partir desse id
    @Override
    public ArrayList<Venda> listar() throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT ped_id, prd_id, prc_unitario, qtd_produtos FROM pedido";
        ArrayList<Venda> lista = new ArrayList();
        Venda vend;
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                vend = new Venda();
                vend.getPedido().setId(rs.getInt("ped_id"));
                vend.getProduto().setId(rs.getInt("prd_id"));
                vend.getPrecoUnitario(rs.getDouble("prc_unitario"));
                vend.getQuantidadeProduto(rs.getInt("qtd_produtos"));
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
