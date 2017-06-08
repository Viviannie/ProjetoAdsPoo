/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoAds.DAO;

import java.util.ArrayList;
import projetoAds.classesBasicas.PedidoProduto;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;

/**
 *
 * @author aluno
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
      * Exclui um pedido do BD
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
      * Busca um registro no BD com o Codigo do fornecedor informado
      * @param ped_id Parametro da busca
      * @return Objeto encontrado ou null
      * @throws ConexaoException
      * @throws DAOException 
      */
    public PedidoProduto pesquisar(Integer ped_id) throws ConexaoException, DAOException;

    
    /**
      * Retorna uma lista com todos os registros dos Pedidos
      * @return Objeto contendo todos os registros encontrados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public ArrayList<PedidoProduto> listar() throws ConexaoException, DAOException;
}
