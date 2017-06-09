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
 * @author Grupo Programação Orientada a Objetos
 */
public class DAOClienteImpl implements DAOCliente {

    private ConexaoBD con;

    public DAOClienteImpl() {
        con = Conectar.getInstancia();
    }

    @Override
    public void incluir(Cliente cliente) throws ConexaoException, DAOException {

        Connection c = con.conectar();
        String sql = "INSERT INTO cliente (nome, cpf) VALUES (?,?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cliente.getNome());   //Referente ao indice da interrogação
            pstm.setString(2, cliente.getCpf());
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
        String sql = "DELETE FROM cliente WHERE (cpf=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cliente.getCpf());
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
        String sql = "UPDATE Cliente SET Cpf=?, Nome=? WHERE (cpf=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);   //Traduz a linguagem para SQL
            pstm.setString(1, cliente.getCpf());
            pstm.setString(2, cliente.getNome());
            pstm.setString(3, cliente.getCpf());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public Cliente pesquisar(String cpf) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT cpf, nome FROM cliente WHERE (cpf=?)";
        Cliente cli = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cpf);
            ResultSet rs = pstm.executeQuery(); //variável que recebe resultado do select
            if (rs.next()) {
                cli = new Cliente();
                cli.setCpf(rs.getString("cpf"));
                cli.setNome(rs.getString("nome"));
            }
            return cli;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }
    
    @Override
    public Cliente pesquisarNome(String nome) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT cpf, nome FROM cliente WHERE (nome like ?)";
        Cliente cli = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, nome);
            ResultSet rs = pstm.executeQuery(); //variável que recebe resultado do select
            if (rs.next()) {
                cli = new Cliente();
                cli.setCpf(rs.getString("cpf"));
                cli.setNome(rs.getString("nome"));
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
        String sql = "SELECT cpf, nome FROM cliente";
        ArrayList<Cliente> lista = new ArrayList();
        Cliente cli;
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                cli = new Cliente();
                cli.setCpf(rs.getString("cpf"));
                cli.setNome(rs.getString("nome"));
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
