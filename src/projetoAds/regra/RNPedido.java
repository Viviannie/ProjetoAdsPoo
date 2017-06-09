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

        if (pedido.getId() == null) {
            throw new RegraException("ID inválido.");
        }
        
        if (pedido.getData() == null) {
            throw new RegraException("Data inválida.");
        }
    }

    /**
     * Verifica se uma nova descrição já existe no BD
     *
     * @param pedido Objeto com os dados
     * @throws RegraException
     */
    public void verificaDuplicidade(Pedido pedido) throws RegraException {

        try {

            Pedido ped = dao.pesquisar(pedido.getId());
            if (ped != null) {
                throw new RegraException("Pedido já realizado.");
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
            Pedido x = dao.pesquisar(id);
            if (x == null) {
                throw new RegraException("ID informado não existe.");
            }
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
}