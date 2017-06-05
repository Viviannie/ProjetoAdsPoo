package projetoAds.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import projetoAds.classesBasicas.Fornecedor;
import projetoAds.classesBasicas.Pagamento;
import projetoAds.conexao.Conectar;
import projetoAds.conexao.ConexaoBD;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;


/**
 *
 * @author Matheus
 */
public class DAOFornecedorImpl implements DAOFornecedor {
    private ConexaoBD con;
    
    public DAOFornecedorImpl(){
        con = Conectar.getInstancia();
    }


    @Override
    public void incluir(Fornecedor fornecedor) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "INSERT INTO fornecedor (frn_cnpj, frn_razao) VALUES (?,?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, fornecedor.getFrn_cnpj());   //Referente ao indice da interogação
            pstm.setString(2, fornecedor.getFrn_razao());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {          //o bloco do finally será sempre executado, sempre. 
            con.desconectar(c);
        }
    
    }

    @Override
    public void excluir(Fornecedor fornecedor) throws ConexaoException, DAOException {
    Connection c = con.conectar();
        String sql = "DELETE FROM fornecedor WHERE (frn_cnpj=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, fornecedor.getFrn_cnpj());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }}

    @Override
    public void alterar(Fornecedor fornecedor) throws ConexaoException, DAOException {
    Connection c = con.conectar();
        String sql = "UPDATE fornecedor SET frn_cnpj=?, frn_razao WHERE (frn_cnpj=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, fornecedor.getFrn_cnpj());
            pstm.setString(2, fornecedor.getFrn_razao());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }}

    @Override
    public Fornecedor pesquisar(String frn_cnpj) throws ConexaoException, DAOException {
    Connection c = con.conectar();
        String sql = "SELECT frn_cnpj, frn_razao FROM fornecedor WHERE (frn_cnpj=?)";
        Fornecedor frn = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, frn_cnpj);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                frn = new Fornecedor();
                frn.setFrn_cnpj(rs.getString("frn_cnpj"));
                frn.setFrn_razao(rs.getString("frn_razao"));
            }
            return frn;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }}

    @Override
    public ArrayList<Fornecedor> listar() throws ConexaoException, DAOException {
    Connection c = con.conectar();
        String sql = "SELECT frn_cnpj, frn_razao FROM fornecedor";
        ArrayList<Fornecedor> lista = new ArrayList();
        Fornecedor frn;
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                frn = new Fornecedor();
                frn.setFrn_cnpj(rs.getString("frn_cnpj"));
                frn.setFrn_razao(rs.getString("frn_razao"));
                lista.add(frn);
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }}
    }

    
    
    
     
