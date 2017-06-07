package projetoAds.regra;

import java.util.ArrayList;
import projetoAds.DAO.DAOPedido;
import projetoAds.DAO.DAOPedidoImpl;
import projetoAds.classesBasicas.Pedido;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;
import projetoAds.excecao.RegraException;

/**
 *
 * @author Annie
 */
public class RNPedido {
    
    private final DAOPedido dao = new DAOPedidoImpl();

    public void incluir(Pedido d) throws RegraException {
        try {
            dao.incluir(d);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public void excluir(Pedido d) throws RegraException {
        try {
            dao.excluir(d);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public void alterar(Pedido d) throws RegraException {
        try {
            dao.alterar(d);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public Pedido pesquisar(Integer peg_id) throws RegraException {
        try {
            return dao.pesquisar(peg_id);
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
     * @param d Objeto com os dados
     * @throws RegraException
     */
    public void validar(Pedido d) throws RegraException {

        if (d.getPed_id() == null) {
            throw new RegraException("ID inválido.");
        }
        
        if (d.getPed_data() == null) {
            throw new RegraException("Data inválida.");
        }
        
        if(d.getCliente().getCli_cpf() == null){
            throw new RegraException("CPF inválido.");
        }
        
        if(d.getVendedor().getVend_id() == null){
            throw new RegraException("ID inválido.");
        }
    }

    /**
     * Verifica se uma nova descrição já existe no BD
     *
     * @param d Objeto com os dados
     * @throws RegraException
     */
    public void verificaDuplicidade(Pedido d) throws RegraException {

        try {

            Pedido x = dao.pesquisar(d.getPed_id());
            if (x != null) {
                throw new RegraException("Pedido já realizado.");
            }
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    /**
     * Verifica se um ID passado é válido e existe no BD
     *
     * @param ped_id Para validação
     * @throws RegraException Caso o ID não seja localizado
     */
    public void validaId(Integer ped_id) throws RegraException {

        if (ped_id == null) {
            throw new RegraException("ID inválido!");
        }
        try {
            Pedido x = dao.pesquisar(ped_id);
            if (x == null) {
                throw new RegraException("ID informado não existe.");
            }
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
}
