package projetoAds.regra;

import java.util.ArrayList;
import projetoAds.DAO.DAOVenda;
import projetoAds.DAO.DAOVendaImpl;
import projetoAds.classesBasicas.Venda;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;
import projetoAds.excecao.RegraException;

/**
  * @author Grupo Programação Orientada a Objetos
  */
public class RNVenda {
    private final DAOVenda dao = new DAOVendaImpl();

    public void incluir(Venda venda) throws RegraException {
        try {
            dao.incluir(venda);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public void excluir(Venda venda) throws RegraException {
        try {
            dao.excluir(venda);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public void alterar(Venda venda) throws RegraException {
        try {
            dao.alterar(venda);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public Venda pesquisar(Integer id) throws RegraException {
        try {
            return dao.pesquisar(id);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public ArrayList<Venda> listar() throws RegraException {
        try {
            return dao.listar();
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

}
