package projetoAds.DAO;

import java.sql.Connection; //Gera conexão
import java.sql.PreparedStatement;  //usado para CRUD no bd passando parametros (?)
import java.sql.ResultSet;  //coletor dos resultados.
import java.sql.SQLException;   //Excexão padrão de sql
import java.sql.Statement;  //Usado para CRUD no bd
import java.util.ArrayList; //Lista
import projetoAds.classesBasicas.Cliente;   //Classe ao qual essa DAO está implementando
import projetoAds.conexao.Conectar; //Gera Conexão
import projetoAds.conexao.ConexaoBD;    //Gerenciador da conexão
import projetoAds.excecao.ConexaoException; //Classe de erro para Conexão
import projetoAds.excecao.DAOException; //Classe de erro para as DAO

/**
 *
 * @author Aluno
 */
public class DAOClienteImpl implements DAOCliente {

    private ConexaoBD con;

    public DAOClienteImpl() {
        con = Conectar.getInstancia();
    }

    @Override
    public void incluir(Cliente cliente) throws ConexaoException, DAOException {

        Connection c = con.conectar();
        String sql = "INSERT INTO cliente (cli_nome) VALUES (?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cliente.getCli_nome());//Referente ao indice da interogação
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {          //o bloco do finally será sempre executado, sempre. 
            con.desconectar(c);
        }
    }

    @Override
    public void excluir(Cliente cliente) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "DELETE FROM clientes WHERE (id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cliente.getCli_nome());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public void alterar(Cliente cliente) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "UPDATE turmas SET descricao=? WHERE (id=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cliente.getCli_nome());
            pstm.setInt(2, cliente.getCli_id());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public Cliente pesquisar(String cli_cpf) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT id, descricao FROM turmas WHERE (cpf=?)";
        Cliente cli = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cli_cpf);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                cli = new Cliente();
                cli.setCli_id(rs.getInt("id"));
                cli.setCli_cpf(rs.getString("cpf"));
            }
            return cli;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public Cliente pesquisar(Integer cli_id) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT id, descricao FROM turmas WHERE (id=?)";
        Cliente cli = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setInt(1, cli_id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                cli = new Cliente();
                cli.setCli_id(rs.getInt("id"));
                cli.setCli_cpf(rs.getString("cpf"));
            }
            return cli;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public ArrayList<Cliente> listar() throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT id, descricao FROM turmas WHERE (cpf=?)";
        ArrayList<Cliente> lista = new ArrayList();
        Cliente cli;
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                cli = new Cliente();
                cli.setCli_id(rs.getInt("id"));
                cli.setCli_cpf(rs.getString("cpf"));
                lista.add(cli);
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

}
