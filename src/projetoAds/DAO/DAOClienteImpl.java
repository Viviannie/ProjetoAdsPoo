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
        String sql = "INSERT INTO Cliente (cli_cpf, cli_nome) VALUES (?,?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cliente.getCpf());
            pstm.setString(2, cliente.getNome());   //Referente ao indice da interrogação            
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
        String sql = "DELETE FROM cliente WHERE (cli_cpf=?)";
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
        String sql = "UPDATE Cliente SET cli_cpf=?, cli_nome=? WHERE (cli_cpf=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);//Traduz a linguagem para SQL
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
    public Cliente pesquisarCpf(String cpf) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT cli_cpf, cli_nome FROM cliente WHERE (cli_cpf=?)";
        Cliente cliente = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cpf);
            ResultSet rs = pstm.executeQuery(); //variável que recebe resultado do select
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setCpf(rs.getString("cli_cpf"));
                cliente.setNome(rs.getString("cli_nome"));
            }
            return cliente;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }
    
    @Override
    public Cliente pesquisarNome(String nome) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT cli_cpf, cli_nome FROM cliente WHERE (cli_nome like ?)";
        Cliente cliente = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, nome);
            ResultSet rs = pstm.executeQuery(); //variável que recebe resultado do select
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setCpf(rs.getString("cli_cpf"));
                cliente.setNome(rs.getString("cli_nome"));
            }
            return cliente;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public ArrayList<Cliente> listar() throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "SELECT cli_cpf, cli_nome FROM cliente";
        ArrayList<Cliente> lista = new ArrayList();
        Cliente cliente;
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                cliente = new Cliente();
                cliente.setCpf(rs.getString("cli_cpf"));
                cliente.setNome(rs.getString("cli_nome"));
                lista.add(cliente);
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException("Erra na hora de preencher o ArrayList!");
        } finally {
            con.desconectar(c);
        }
    }

}
