package projetoAds.DAO;

import java.util.ArrayList;
import projetoAds.classesBasicas.Cliente;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;

/**
 *
 * @author Grupo Programação Orientada a Objetos
 */
public interface DAOCliente {

    /**
     * Inclui uma novo cliente no BD
     *
     * @param cliente Objeto com os dados validados
     * @throws ConexaoException
     * @throws DAOException
     */
    public void incluir(Cliente cliente) throws ConexaoException, DAOException;

    /**
     * Exclui um registro do BD
     *
     * @param cliente Objeto com o ID do registro
     * @throws ConexaoException
     * @throws DAOException
     */
    public void excluir(Cliente cliente) throws ConexaoException, DAOException;

    /**
     * Altera um registro do BD
     *
     * @param cliente Objeto com todos os dados validados
     * @throws ConexaoException
     * @throws DAOException
     */
    public void alterar(Cliente cliente) throws ConexaoException, DAOException;

    /**
     * Busca um registro no BD com a Descricao informada
     *
     * @param cli_nome Parametro da busca
     * @return Objeto encontrado ou null
     * @throws ConexaoException
     * @throws DAOException
     */
    public Cliente pesquisarNome(String cli_nome) throws ConexaoException, DAOException;
    
    /**
     * Busca um registro no BD com a Descricao informada
     *
     * @param cli_cpf Parametro da busca
     * @return Objeto encontrado ou null
     * @throws ConexaoException
     * @throws DAOException
     */
    public Cliente pesquisar(String cli_cpf) throws ConexaoException, DAOException;

    /**
     * Retorna uma lista com todos os registros de Clientes
     *
     * @return Objeto contendo todos os registros encontrados
     * @throws ConexaoException
     * @throws DAOException
     */
    public ArrayList<Cliente> listar() throws ConexaoException, DAOException;
}
