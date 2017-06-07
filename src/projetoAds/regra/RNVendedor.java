/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoAds.regra;

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

    public void validar(Vendedor a) throws RegraException {
        if ((a.getVend_id() == null) || (a.getVend_nome().trim().equals(" "))) {
            throw new RegraException("Nome inválido");
        }
    }

    public void verificaDuplicidade(Vendedor v) throws RegraException {
        try {
            Vendedor x = dao.pesquisar(v.getVend_id());
            if (x != null) {
                throw new RegraException("Vendedor já existe.");
            }
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public void incluir(Vendedor v) throws RegraException {
        try {
            dao.incluir(v);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException();
        }
    }

    public void excluir(Vendedor v) throws RegraException {
        if (v.getVend_id() == null) {
            throw new RegraException("ID inválido!");
        }

        try {
            Vendedor x = dao.pesquisar(v.getVend_id());
            if (x == null) {
                throw new RegraException("ID informado não existe.");
            }
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }

        try {
            dao.excluir(v);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
}
