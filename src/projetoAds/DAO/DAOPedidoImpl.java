package projetoAds.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import projetoAds.classesBasicas.Pedido;
import projetoAds.conexao.Conectar;
import projetoAds.conexao.ConexaoBD;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;

/**
 * @author Grupo Programação Orientada a Objetos
 */
public class DAOPedidoImpl implements DAOPedido {

    private final ConexaoBD con; //why final?

    public DAOPedidoImpl() {
        con = Conectar.getInstancia();
    }

    @Override
    public void incluir(Pedido pedido) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "INSERT INTO pedido (ped_data, cli_cpf, vend_id) VALUES (?,?,?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, pedido.getData());     //Referente ao indice da interogação
            pstm.setString(2, pedido.getCliente().getCpf());
            pstm.setInt(3, pedido.getVendedor().getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public void excluir(Pedido pedido) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "DELETE FROM pedido WHERE (ped_id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, pedido.getId());
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
        String sql = "UPDATE pedido SET ped_data=?, cli_cpf=?, vend_id=? WHERE (ped_id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);          
            pstm.setString(1, pedido.getData());
            pstm.setString(2, pedido.getCliente().getCpf());
            pstm.setInt(3, pedido.getVendedor().getId());
            pstm.setInt(4, pedido.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public Pedido pesquisar(Integer ped_id) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT ped_id, ped_data, cli_cpf, vend_id FROM pedido WHERE (ped_id=?)";
        Pedido pedido = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, ped_id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                pedido = new Pedido();
                pedido.setId(rs.getInt("ped_id"));
                pedido.setData(rs.getString("ped_data"));                
                pedido.getCliente().setCpf(rs.getString("cli_cpf"));
                pedido.getVendedor().setId(rs.getInt("vend_id"));
            }
            return pedido;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public ArrayList<Pedido> listar() throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT ped_id, ped_data, cli_cpf, vend_id FROM pedido";
        ArrayList<Pedido> lista = new ArrayList();
        Pedido ped;
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                ped = new Pedido();
                ped.setId(rs.getInt("ped_id"));
                ped.setData(rs.getString("ped_data"));
                ped.getCliente().setCpf(rs.getString("cli_cpf"));
                ped.getVendedor().setId(rs.getInt("vend_id"));
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
