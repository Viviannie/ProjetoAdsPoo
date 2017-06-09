/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoAds.regra;

import java.util.ArrayList;
import projetoAds.DAO.DAOProduto;
import projetoAds.DAO.DAOProdutoImpl;
import projetoAds.classesBasicas.Produto;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;
import projetoAds.excecao.RegraException;

/**
 *
 * @author Grupo Programação Orientada a Objetos
 */
public class RNProduto {

    private final DAOProduto dao = new DAOProdutoImpl();

    public void incluir(Produto p) throws RegraException {
        try {
            dao.incluir(p);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public void excluir(Produto p) throws RegraException {
        try {
            dao.excluir(p);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
    
    public void alterar(Produto p) throws RegraException {
        try {
            dao.alterar(p);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
    
    public Produto pesquisar(Integer id) throws RegraException {
        try {
            return dao.pesquisar(id);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
    
    public Produto pesquisar(String desc) throws RegraException {
        try {
            return dao.pesquisar(desc);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
    
    public ArrayList<Produto> listar() throws RegraException {
        try {
            return dao.listar();
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    
    }
    
}
