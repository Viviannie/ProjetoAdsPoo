package projetoAds.DAO;

import java.util.ArrayList;
import projetoAds.classesBasicas.Pedido;
import projetoAds.classesBasicas.Venda;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;

/**
  * @author Grupo Programação Orientada a Objetos
  */
public interface DAOVenda {
    /**
      * Inclui uma novo pedido no BD
      * @param venda Objeto com os dados validados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void incluir(Venda venda) throws ConexaoException,DAOException;
    /**
      * Exclui um pedido com produots no BD
      * @param venda Objeto
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void excluir(Venda venda) throws ConexaoException, DAOException;
    
    /**
      * Altera um registro do BD
      * @param venda Objeto com todos os dados validados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void alterar(Venda venda) throws ConexaoException, DAOException;
    
    /**
      * Busca um registro no BD com o id do Pedido informado
      * @param id Parametro da busca
      * @return Objeto encontrado ou null
      * @throws ConexaoException
      * @throws DAOException 
      */
    public Pedido pesquisar(Integer id) throws ConexaoException, DAOException;

    
    /**
      * Retorna uma lista com todos os registros os Produtos referente aquele Pedido
      * @return Objeto contendo todos os registros encontrados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public ArrayList<Venda> listar() throws ConexaoException, DAOException;
}
