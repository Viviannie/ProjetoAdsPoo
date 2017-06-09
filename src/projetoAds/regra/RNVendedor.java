/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoAds.regra;

import java.util.ArrayList;
import projetoAds.DAO.DAOVendedor;
import projetoAds.DAO.DAOVendedorImpl;
import projetoAds.classesBasicas.Vendedor;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;
import projetoAds.excecao.RegraException;

/**
 *
 * @author Annie
 */
public class RNVendedor {

    private final DAOVendedor dao = new DAOVendedorImpl();

    public void incluir(Vendedor v) throws RegraException {
        try {
            dao.incluir(v);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public void excluir(Vendedor v) throws RegraException {
        try {
            dao.excluir(v);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
    
    public void alterar(Vendedor v) throws RegraException {
        try {
            dao.alterar(v);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
    
    public Vendedor pesquisar(Integer id) throws RegraException {
        try {
            return dao.pesquisar(id);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
    
    public Vendedor pesquisar(String nome) throws RegraException {
        try {
            return dao.pesquisar(nome);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
    
    public ArrayList<Vendedor> listar() throws RegraException {
        try {
            return dao.listar();
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
    
}
