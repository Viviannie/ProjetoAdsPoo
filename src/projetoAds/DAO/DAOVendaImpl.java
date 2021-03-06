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
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public void excluir(Venda venda) throws ConexaoException, DAOException {
       Connection c = con.conectar();
        String sql = "DELETE FROM venda WHERE (ped_id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, venda.getPedido().getId());           
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
        String sql = "UPDATE venda SET ped_id=?, prd_id=?, prc_unitario=?, qtd_produtos=? WHERE (ped_id=?, prd_id=?)";
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
        sql = "SELECT venda.* FROM venda JOIN pedido ON venda.ped_id = pedido.id WHERE (pedido.ped_id=?)";
        Venda venda = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                venda = new Venda();
                venda.getPedido().setId(rs.getInt("ped_id"));
                venda.getProduto().setId(rs.getInt("prd_id"));
                venda.setPrecoUnitario(rs.getDouble("prc_unitario"));
                venda.setQuantidadeProduto(rs.getInt("qtd_produtos"));
            }
            return venda;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }
    
    @Override
    public ArrayList<Venda> listar() throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT * FROM venda";
        ArrayList<Venda> lista = new ArrayList();
        Venda venda;
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                venda = new Venda();
                venda.getPedido().setId(rs.getInt("ped_id"));
                venda.getProduto().setId(rs.getInt("prd_id"));
                venda.setPrecoUnitario(rs.getDouble("prc_unitario"));
                venda.setQuantidadeProduto(rs.getInt("qtd_produtos"));
                lista.add(venda );
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }
    
}
