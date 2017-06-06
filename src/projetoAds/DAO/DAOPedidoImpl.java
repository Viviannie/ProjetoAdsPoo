package projetoAds.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import projetoAds.classesBasicas.Pedido;
import projetoAds.classesBasicas.Produto;
import projetoAds.conexao.Conectar;
import projetoAds.conexao.ConexaoBD;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matheus
 */
public class DAOPedidoImpl implements DAOPedido {
      private ConexaoBD con;
    
    public DAOPedidoImpl(){
        con = Conectar.getInstancia();
    }

    @Override
    public void incluir(Pedido pedido) throws ConexaoException, DAOException {
    Connection c = con.conectar();
        String sql = "INSERT INTO pedido (ped_id, ped_data) VALUES (?,?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, pedido.getPed_id());   //Referente ao indice da interogação
            pstm.setString(2, pedido.getPed_data());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {          //o bloco do finally será sempre executado, sempre. 
            con.desconectar(c);
        }
    }

    @Override
    public void excluir(Pedido pedido) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "DELETE FROM pedido WHERE (prd_id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, pedido.getPed_id());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    
    }

    @Override
    public void alterar(Pedido pedido) throws ConexaoException, DAOException {
    Connection c = con.conectar();
        String sql = "UPDATE pedido SET ped_id=?, ped_data WHERE (ped_id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, pedido.getPed_id());
            pstm.setString(2, pedido.getPed_data());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }}

    @Override
    public Pedido pesquisar(Integer ped_id) throws ConexaoException, DAOException {
    Connection c = con.conectar();
        String sql = "SELECT ped_id, ped_data FROM pedido WHERE (ped_id=?)";
        Pedido ped = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, ped_id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                ped = new Pedido();
                ped.setPed_id(rs.getInt("ped_id"));
                ped.setPed_data(rs.getString("prd_data"));
            }
            return ped;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }}

    @Override
    public ArrayList<Pedido> listar() throws ConexaoException, DAOException {
    Connection c = con.conectar();
        String sql = "SELECT ped_id, ped_data FROM pedido";
        ArrayList<Pedido> lista = new ArrayList();
        Pedido ped;
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ped = new Pedido();
                ped.setPed_id(rs.getInt("ped_id"));
                ped.setPed_data(rs.getString("ped_data"));
                lista.add(ped);
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    
    }
}
