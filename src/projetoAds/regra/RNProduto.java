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

    /**
     * Verifica se um ID passado é válido e existe no BD
     *
     * @param id Para validação
     * @throws RegraException Caso o ID não seja localizado
     */
    public void validaId(Integer id) throws RegraException {
        if (id == null) {
            throw new RegraException("ID inválido!");
        }
        try {
            Produto x = dao.pesquisar(id);
            if (x == null) {
                throw new RegraException("ID informado não existe.");
            }
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    /**
     * Verifica se os campos estão preenchidos corretamente
     *
     * @param p Objeto com os dados
     * @throws RegraException
     */
    public void validar(Produto p) throws RegraException {
        if ((p.getDesc() == null) || (p.getDesc().trim().equals(""))) {
            throw new RegraException("Descrição inválida");
        }
        
        if (p.getEstoqueAtual() == null) {
            throw new RegraException("Estoque atual inválido");
        }
        
        if (p.getEstoqueMinimo() == null) {
            throw new RegraException("Estoque minimo inválido");
        }
    }
    
    /**
     * Verifica se uma nova descrição já existe no BD
     *
     * @param p Objeto com os dados
     * @throws RegraException
     */
    public void verificaDuplicidade(Produto p) throws RegraException {
        try {
            Produto x = dao.pesquisar(p.getDesc());
            if (x != null) {
                throw new RegraException("Produto já existe.");
            }
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

}
