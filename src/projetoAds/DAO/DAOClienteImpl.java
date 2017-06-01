
package projetoAds.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class DAOClienteImpl implements DAOCliente{
    
   @Override
   public void incluir(Cliente cliente) throws ConexaoException, DAOException {
    ConexaoBD g = Conectar.getInstancia();
    Connection c = g.conectar();
    String sql = "INSERT INTO cliente (cli_nome) VALUES (?)";
    try{
        PreparedStatement pstm = c.prepareStatement(sql);
        pstm.setString(1,cliente.getCli_nome());
        pstm.executeUpdate();
    }catch(SQLException e){
        throw new DAOException(e);
    } finally{
        g.desconectar(c);
    }  
}
    
    @Override
    public void excluir(Cliente cliente) throws ConexaoException, DAOException {
        ConexaoBD g = Conectar.getInstancia();
        Connection c = g.conectar();
        String sql = "DELETE FROM clientes WHERE (id=?)";
        try{
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1,cliente.getCli_nome());
            pstm.executeUpdate();
        }catch(SQLException e){
            throw new DAOException(e);
        } finally{
            g.desconectar(c);
        }    
}
    
    @Override
    public void alterar(Cliente cliente) throws ConexaoException, DAOException {
    
}
    
    public Cliente pesquisar(Cliente cpf) throws ConexaoException, DAOException {
       return null;
}
    
    @Override
    public ArrayList<Cliente> listar() throws ConexaoException, DAOException {
        return null;
}

    @Override
    public Cliente pesquisar(String cli_cpf) throws ConexaoException, DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
