package projetoAds.regra;

import java.util.ArrayList;
import projetoAds.DAO.DAOPagamento;
import projetoAds.DAO.DAOPagamentoImpl;
import projetoAds.classesBasicas.Pagamento;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;
import projetoAds.excecao.RegraException;

/**
 *
 * @author Grupo Programa Orientada a Objetos
 */
public class RNPagamento {

    private final DAOPagamento dao = new DAOPagamentoImpl();

    public void incluir(Pagamento g) throws RegraException {
        try {
            dao.incluir(g);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public void excluir(Pagamento g) throws RegraException {
        try {
            dao.excluir(g);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public void alterar(Pagamento g) throws RegraException {
        try {
            dao.alterar(g);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public Pagamento pesquisar(Integer pag_id) throws RegraException {
        try {
            return dao.pesquisar(pag_id);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public ArrayList<Pagamento> listar() throws RegraException {
        try {
            return dao.listar();
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    /**
     * Verifica se os campos estão preenchidos corretamente
     *
     * @param g Objeto com os dados
     * @throws RegraException
     */
    public void validar(Pagamento g) throws RegraException {

        if (g.getValor() == 0.0) {
            throw new RegraException("Valor inválido.");
        }
        
        if (g.geId() == null) {
            throw new RegraException("ID inválido.");
        }
        
        if(g.getPedido().getId()== null){
            throw new RegraException("Pedido inválido.");
        }
    }

    /**
     * Verifica se uma nova descrição já existe no BD
     *
     * @param g Objeto com os dados
     * @throws RegraException
     */
    public void verificaDuplicidade(Pagamento g) throws RegraException {

        try {

            Pagamento x = dao.pesquisar(g.getId());
            if (x != null) {
                throw new RegraException("Pagamento já efetuado.");
            }
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
            Pagamento x = dao.pesquisar(id);
            if (x == null) {
                throw new RegraException("ID informado não existe.");
            }
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
}
