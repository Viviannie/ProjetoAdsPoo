package projetoAds.DAO;

import java.util.ArrayList;
import projetoAds.classesBasicas.Produto;
import projetoAds.excecao.DAOException;
import projetoAds.excecao.ConexaoException;

/**
 *
 * @author Grupo Programação Orientada a Objetos
 */
public interface DAOProduto {

    /**
     * Inclui uma novo produto no BD
     * @param produto Objeto com os dados validados
     * @throws ConexaoException
     * @throws DAOException
     */
    public void incluir(Produto produto) throws ConexaoException, DAOException;

    /**
     * Exclui um produto do BD
     * @param produto Objeto com o ID do registro
     * @throws ConexaoException
     * @throws DAOException
     */
    public void excluir(Produto produto) throws ConexaoException, DAOException;

    /**
     * Altera um registro do BD
     * @param produto Objeto com o ID do registro
     * @throws ConexaoException
     * @throws DAOException
     */
    public void alterar(Produto produto) throws ConexaoException, DAOException;

    /**
     * Busca um registro no BD com o ID do produto informado
     * @param id Parametro da busca
     * @return Objeto encontrado ou null
     * @throws ConexaoException
     * @throws DAOException
     */
    public Produto pesquisar(Integer id) throws ConexaoException, DAOException;

    /**
     * Busca um registro no BD com a descrição do produto informado
     * @param desc Parametro da busca
     * @return Objeto encontrado ou null
     * @throws ConexaoException
     * @throws DAOException
     */
    public Produto pesquisar(String desc) throws ConexaoException, DAOException;

    /**
     * Retorna uma lista com todos os registros dos produtos
     * @return Objeto contendo todos os registros encontrados
     * @throws ConexaoException
     * @throws DAOException
     */
    public ArrayList<Produto> listar() throws ConexaoException, DAOException;
}
