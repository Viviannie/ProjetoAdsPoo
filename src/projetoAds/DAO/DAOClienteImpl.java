package projetoAds.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import projetoAds.classesBasicas.Cliente;
import projetoAds.conexao.Conectar;
import projetoAds.conexao.ConexaoBD;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;

/**
 *
 * @author Aluno
 */
public class DAOClienteImpl implements DAOCliente {

    private ConexaoBD g;

    public DAOClienteImpl() {
        g = Conectar.getInstancia();
    }

    @Override
    public void incluir(Cliente cliente) throws ConexaoException, DAOException {

        Connection c = g.conectar();
        String sql = "INSERT INTO cliente (cli_nome) VALUES (?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cliente.getCli_nome());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {                      //o bloco do finally será sempre executado, sempre. 
            g.desconectar(c);
        }
    }

    @Override
    public void excluir(Cliente cliente) throws ConexaoException, DAOException {
        Connection c = g.conectar();
        String sql = "DELETE FROM clientes WHERE (id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cliente.getCli_nome());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            g.desconectar(c);
        }
    }

    @Override
    public void alterar(Cliente cliente) throws ConexaoException, DAOException {
        Connection c = g.conectar();
        String sql = "UPDATE turmas SET descricao=? WHERE (id=?)";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cliente.getCli_nome());
            pstm.setInt(2, cliente.getCli_id());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            g.desconectar(c);
    }

    @Override
    public Cliente pesquisar(String cli_cpf) throws ConexaoException, DAOException {
        Connection c = g.conectar();
        String sql = "SELECT id, descricao FROM turmas WHERE (registro=?)";
        Cliente a = null;
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cli_cpf);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                a = new Cliente();
                a.setCli_id(rs.getInt("id") );
                a.setCli_cpf(rs.getString("registro") );
            }
            return ;
        }catch(SQLException e){
            throw new DAOException(e);
        }finally{
            g.desconectar(c);
        }
    }

    @Override
    public ArrayList<Cliente> listar() throws ConexaoException, DAOException {
        return null;
    }

}
