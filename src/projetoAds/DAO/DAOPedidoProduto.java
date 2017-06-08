package projetoAds.DAO;

import java.util.ArrayList;
import projetoAds.classesBasicas.PedidoProduto;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;

/**
  * @author Grupo Programação Orientada a Objetos
  */
public interface DAOPedidoProduto {
    /**
      * Inclui uma novo pedido no BD
      * @param pedidoProduto Objeto com os dados validados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void incluir(PedidoProduto pedidoProduto) throws ConexaoException,DAOException;
    /**
      * Exclui um pedido com produots no BD
      * @param pedidoProduto Objeto
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void excluir(PedidoProduto pedidoProduto) throws ConexaoException, DAOException;
    
    /**
      * Altera um registro do BD
      * @param pedidoProduto Objeto com todos os dados validados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void alterar(PedidoProduto pedidoProduto) throws ConexaoException, DAOException;
    
    /**
      * Busca um registro no BD com o id do Pedido informado
      * @param ped_id Parametro da busca
      * @return Objeto encontrado ou null
      * @throws ConexaoException                  ######CAUTION##### -- REVIEW
      * @throws DAOException 
      */
    public PedidoProduto pesquisar(Integer ped_id) throws ConexaoException, DAOException;

    
    /**
      * Retorna uma lista com todos os registros os Produtos referente aquele Pedido
      * @return Objeto contendo todos os registros encontrados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public ArrayList<PedidoProduto> listar() throws ConexaoException, DAOException;
}
