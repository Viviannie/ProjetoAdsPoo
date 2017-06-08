/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoAds.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import projetoAds.classesBasicas.PedidoProduto;
import projetoAds.conexao.Conectar;
import projetoAds.conexao.ConexaoBD;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;

/**
 *
 * @author aluno
 */
public class DAOPedidoProdutoImpl implements DAOPedidoProduto {
    private ConexaoBD con;
    
    public DAOPedidoProdutoImpl(){
        con = Conectar.getInstancia();
    }

    @Override
    public void incluir(PedidoProduto pedidoProduto) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "INSERT INTO pedidoproduto (ped_id, prd_id, prc_unitario, qtd_produtos) VALUES (?,?,?,?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, pedidoProduto.getPedido().getPed_id());   //Referente ao indice da interogação
            pstm.setInt(2, pedidoProduto.getProduto().getPrd_id());
            pstm.setDouble(3, pedidoProduto.getPrc_unitario());
            pstm.setInt(4, pedidoProduto.getQtd_produtos());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {          //o bloco do finally será sempre executado, sempre. 
            con.desconectar(c);
        }
    }

    @Override
    public void excluir(PedidoProduto pedidoProduto) throws ConexaoException, DAOException {
       Connection c = con.conectar();
        String sql = "DELETE FROM pedidoproduto WHERE (ped_id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, pedidoProduto.getPedido().getPed_id());           
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public void alterar(PedidoProduto pedidoProduto) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "UPDATE pedido SET ped_id=?, prd_id=?, prc_unitario=?, qtd_produtos=? WHERE (ped_id=?, prd_id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, pedidoProduto.getPedido().getPed_id());
            pstm.setInt(2, pedidoProduto.getProduto().getPrd_id());
            pstm.setDouble(3, pedidoProduto.getPrc_unitario());
            pstm.setInt(4, pedidoProduto.getQtd_produtos());
            pstm.setInt(5, pedidoProduto.getPedido().getPed_id());
            pstm.setInt(6, pedidoProduto.getProduto().getPrd_id());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public PedidoProduto pesquisar(Integer ped_id) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT ped_id, prd_id, prc_unitario, qtd_produtos FROM pedido WHERE (ped_id=?)";
        PedidoProduto pedPrd = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, ped_id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                pedPrd = new PedidoProduto();
                pedPrd.getPedido().setPed_id(rs.getInt("ped_id"));
                pedPrd.getProduto().setPrd_id(rs.getInt("prd_id"));
                pedPrd.setPrc_unitario(rs.getDouble("prc_unitario"));
                pedPrd.setQtd_produtos(rs.getInt("qtd_produtos"));
            }
            return pedPrd;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public ArrayList<PedidoProduto> listar() throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT ped_id, prd_id, prc_unitario, qtd_produtos FROM pedido";
        ArrayList<PedidoProduto> lista = new ArrayList();
        PedidoProduto pedPrd;
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                pedPrd = new PedidoProduto();
                pedPrd.getPedido().setPed_id(rs.getInt("ped_id"));
                pedPrd.getProduto().setPrd_id(rs.getInt("prd_id"));
                pedPrd.setPrc_unitario(rs.getDouble("prc_unitario"));
                pedPrd.setQtd_produtos(rs.getInt("qtd_produtos"));
                lista.add(pedPrd);
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }
    
}
