package projetoAds.DAO;
import java.util.ArrayList;
import projetoAds.classesBasicas.Pagamento;
import projetoAds.excecao.DAOException;
import projetoAds.excecao.ConexaoException;
/**
 *
 * @author Grupo Programação Orientada a Objetos
 */
public interface DAOPagamento {
    /**
      * Inclui uma novo pagamento no BD
      * @param pagamento Objeto com os dados validados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void incluir(Pagamento pagamento) throws ConexaoException,DAOException;
    
    /**
      * Exclui um pagamento do BD
      * @param pagamento Objeto
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void excluir(Pagamento pagamento) throws ConexaoException,DAOException;
    
    /**
      * Altera um registro do BD
      * @param pagamento Objeto com todos os dados validados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void alterar(Pagamento pagamento) throws ConexaoException,DAOException;
    
    /**
      * Busca um registro no BD com o Codigo do pagamento informado
      * @param pag_id Parametro da busca
      * @return Objeto encontrado ou null
      * @throws ConexaoException
      * @throws DAOException 
      */
    public Pagamento pesquisar(String pag_id) throws ConexaoException,DAOException;

    /**
      * Retorna uma lista com todos os registros dos pagamentos
      * @return Objeto contendo todos os registros encontrados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public ArrayList<Pagamento> listar() throws ConexaoException,DAOException;
}
