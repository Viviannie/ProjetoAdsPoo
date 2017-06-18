package projetoAds.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import projetoAds.classesBasicas.Fabricante;
import projetoAds.conexao.Conectar;
import projetoAds.conexao.ConexaoBD;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;


/**
 *
 * @author Grupo Programação Orientada a Objetos
 */
public class DAOFabricanteImpl implements DAOFabricante {
    private ConexaoBD con;
    
    public DAOFabricanteImpl(){
        con = Conectar.getInstancia();
    }


    @Override
    public void incluir(Fabricante fabricante) throws ConexaoException, DAOException {
        Connection c = con.conectar();
        String sql = "INSERT INTO fabricante (fbr_cnpj, fbr_razao) VALUES (?,?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, fabricante.getCnpj());   //Referente ao indice da interogação
            pstm.setString(2, fabricante.getRazao());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {          //o bloco do finally será sempre executado, sempre. 
            con.desconectar(c);
        }
    }

    @Override
    public void excluir(Fabricante fabricante) throws ConexaoException, DAOException {
    Connection c = con.conectar();
        String sql = "DELETE FROM fabricante WHERE (fbr_cnpj=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, fabricante.getCnpj());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public void alterar(Fabricante fabricante) throws ConexaoException, DAOException {
    Connection c = con.conectar();
        String sql = "UPDATE abricante SET fbr_cnpj=?, fbr_razao=? WHERE (fbr_cnpj=?)";
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, fabricante.getCnpj());
            pstm.setString(2, fabricante.getRazao());
            pstm.setString(3, fabricante.getCnpj());
            pstm.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public Fabricante pesquisar(String cnpj) throws ConexaoException, DAOException {
    Connection c = con.conectar();
        String sql = "SELECT fbr_cnpj, fbr_razao FROM fabricante WHERE (fbr_cnpj=?)";
        Fabricante fbr = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, cnpj);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                fbr = new Fabricante();
                fbr.setCnpj(rs.getString("fbr_cnpj"));
                fbr.setRazao(rs.getString("fbr_razao"));
            }
            return fbr;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }
    
    @Override
    public Fabricante pesquisarRazao(String razao) throws ConexaoException, DAOException {
    Connection c = con.conectar();
        String sql = "SELECT fbr_cnpj, fbr_razao FROM fabricante WHERE (fbr_cnpj=?)";
        Fabricante fbr = null;
        try {
            PreparedStatement pstm = c.prepareStatement(sql);
            pstm.setString(1, razao);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                fbr = new Fabricante();
                fbr.setCnpj(rs.getString("fbr_cnpj"));
                fbr.setRazao(rs.getString("fbr_razao"));
            }
            return fbr;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }

    @Override
    public ArrayList<Fabricante> listar() throws ConexaoException, DAOException {
    Connection c = con.conectar();
        String sql = "SELECT fbr_cnpj, fbr_razao FROM fabricante";
        ArrayList<Fabricante> lista = new ArrayList();
        Fabricante fbr;
        try {
            Statement stm = c.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                fbr = new Fabricante();
                fbr.setCnpj(rs.getString("fbr_cnpj"));
                fbr.setRazao(rs.getString("fbr_razao"));
                lista.add(fbr);
            }
            return lista;
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            con.desconectar(c);
        }
    }
    }

    
    
    
     
