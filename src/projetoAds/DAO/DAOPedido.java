package projetoAds.DAO;
import java.util.ArrayList;
import projetoAds.classesBasicas.Pedido;
import projetoAds.excecao.DAOException;
import projetoAds.excecao.ConexaoException;

/**
  * @author Grupo Programação Orientada a Objetos
  */

public interface DAOPedido {
    
    /**
      * Inclui um novo pedido no BD
      * @param pedido Objeto com os dados validados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void incluir(Pedido pedido) throws ConexaoException,DAOException;
    
    /**
      * Exclui um pedido do BD
      * @param pedido Objeto
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void excluir(Pedido pedido) throws ConexaoException, DAOException;
    
    /**
      * Altera um registro pedido no BD
      * @param pedido Objeto com todos os dados validados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void alterar(Pedido pedido) throws ConexaoException, DAOException;
    
    /**
      * Busca um registro no BD com o id do Pedido informado
      * @param id Parametro da busca
      * @return Objeto encontrado ou null
      * @throws ConexaoException
      * @throws DAOException 
      */
    public Pedido pesquisar(Integer id) throws ConexaoException, DAOException;
        
    /**
      * Retorna uma lista com todos os registros dos Pedidos
      * @return Objeto contendo todos os registros encontrados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public ArrayList<Pedido> listar() throws ConexaoException, DAOException;
    
}
