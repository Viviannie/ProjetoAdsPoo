/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoAds.regra;

import projetoAds.DAO.DAOProduto;
import projetoAds.DAO.DAOProdutoImpl;
import projetoAds.classesBasicas.Produto;
import projetoAds.excecao.RegraException;

/**
 *
 * @author Annie
 */
public class RNProduto {

    private final DAOProduto dao = new DAOProdutoImpl();

    public void validar(Produto p) throws RegraException {

        if ((p.getPrd_desc() == null) || (p.getPrd_desc().trim().equals(""))) {
            throw new RegraException("Descrição inválida.");
        }
        if (p.getPrd_id() == null) {
            throw new RegraException("ID inválido");
        }
        if (p.getFornecedor().get(0) == null) {
            throw new RegraException("Turma inválida");
        }
    }

    public void verificaDuplicidade(Aluno t) throws RegraException {
        try {
            Aluno x = dao.pesquisar(t.getCpf());
            if (x != null) {
                throw new RegraException("Aluno já existe.");
            }
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public void incluir(Aluno t) throws RegraException {
        try {
            dao.incluir(t);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException();
        }
    }

    public void excluir(Aluno t) throws RegraException {
        if (t.getId() == null) {
            throw new RegraException("ID inválido!");
        }

        try {
            Aluno x = dao.pesquisar(t.getId());
            if (x == null) {
                throw new RegraException("ID informado não existe.");
            }
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }

        try {
            dao.excluir(t);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
}
