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
        String sql = "INSERT INTO cliente (cli_nome, cli_cpf) VALUES (?,?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cliente.getCli_nome());//Referente ao indice da interrogação
            pstm.setString(2, cliente.getCli_cpf());
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
            pstm.setString(1, cliente.getCli_cpf());
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
        String sql = "UPDATE Cliente SET Cli_nome=? WHERE (cli_cpf=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);   //Traduz a linguagem para SQL
            pstm.setString(1, cliente.getCli_nome());
            pstm.setString(2, cliente.getCli_cpf());
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
        String sql = "SELECT cli_cpf, cli_nome FROM cliente WHERE (cli_cpf=?)";
        Cliente cli = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cli_cpf);
            ResultSet rs = pstm.executeQuery(); //variável que recebe resultado do select
            if (rs.next()) {
                cli = new Cliente();
                cli.setCli_cpf(rs.getString("cli_cpf"));
                cli.setCli_nome(rs.getString("cli_nome"));
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
        String sql = "SELECT cli_cpf, cli_nome FROM cliente WHERE (cli_cpf=?)";
        ArrayList<Cliente> lista = new ArrayList();
        Cliente cli;
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                cli = new Cliente();
                cli.setCli_cpf(rs.getString("cli_cpf"));
                cli.setCli_nome(rs.getString("cli_nome"));
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
