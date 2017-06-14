package projetoAds.regra;

import java.util.ArrayList;
import projetoAds.DAO.DAOPedido;
import projetoAds.DAO.DAOPedidoImpl;
import projetoAds.classesBasicas.Pedido;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;
import projetoAds.excecao.RegraException;

/**
 * @author Grupo Programação Orientada a Objetos
 */
public class RNPedido {

    private final DAOPedido dao = new DAOPedidoImpl();

    public void incluir(Pedido pedido) throws RegraException {
        try {
            dao.incluir(pedido);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public void excluir(Pedido pedido) throws RegraException {
        try {
            dao.excluir(pedido);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public void alterar(Pedido pedido) throws RegraException {
        try {
            dao.alterar(pedido);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public Pedido pesquisar(Integer id) throws RegraException {
        try {
            return dao.pesquisar(id);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public ArrayList<Pedido> listar() throws RegraException {
        try {
            return dao.listar();
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    /**
     * Verifica se os campos estão preenchidos corretamente
     *
     * @param pedido Objeto com os dados
     * @throws RegraException
     */
    public void validar(Pedido pedido) throws RegraException {

        try {
            Pedido ped = dao.pesquisar(pedido.getId());
            if (ped != null) {
                throw new RegraException("Pedido existente.");
            } else {
                if ((ped == null) | (pedido.getId() == 0)) {
                    throw new RegraException("ID inválido.");
                }

                if ((ped.getData() == null) | (ped.getData().trim().equals(""))) {
                    throw new RegraException("Data inválida.");
                }
            }
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    /**
     * Verifica se um ID passado existe no BD
     *
     * @param id Para validação
     * @throws RegraException Caso o ID não seja localizado
     */
    public void validaId(Integer id) throws RegraException {

        if ((id == null) | (id == 0)) {
            throw new RegraException("ID inválido!");
        }
        try {
            Pedido ped = dao.pesquisar(id);
            if (ped == null) {
                throw new RegraException("ID informado não existe.");
            }
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    /**
     * Verifica se uma nova pedido já existe no BD
     *
     * @param pedido Objeto com os dados
     * @throws RegraException
     */
    public void verificaDuplicidade(Pedido pedido) throws RegraException {

        try {
            Pedido ped = dao.pesquisar(pedido.getId());
            if (ped != null) {
                throw new RegraException("Pedido já existe.");
            }
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
}
