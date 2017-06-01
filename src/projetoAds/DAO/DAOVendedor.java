package projetoAds.DAO;
import java.util.ArrayList;
import projetoAds.classesBasicas.Vendedor;
import projetoAds.excecao.DAOException;
import projetoAds.excecao.ConexaoException;
/**
 *
 * @author Jefferson Fabrício
 */
public interface DAOVendedor {
    /**
      * Inclui uma novo vendedor no BD
      * @param vendedor Objeto com os dados validados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void incluir(Vendedor vendedor) throws ConexaoException,DAOException;
    
    /**
      * Exclui um registro do BD
      * @param vendedor Objeto com o ID do registro
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void excluir(Vendedor vendedor) throws ConexaoException,DAOException;
    
    /**
      * Altera um registro do BD
      * @param vendedor Objeto com todos os dados validados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void alterar(Vendedor vendedor) throws ConexaoException,DAOException;
    
    /**
      * Busca um registro no BD com o CPF informado
      * @param vend_cod Parametro da busca
      * @return Objeto encontrado ou null
      * @throws ConexaoException
      * @throws DAOException 
      */
    public Vendedor pesquisar(Integer vend_cod) throws ConexaoException,DAOException;

    /**
      * Retorna uma lista com todos os registros do vendedor
      * @return Objeto contendo todos os registros encontrados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public ArrayList<Vendedor> listar() throws ConexaoException,DAOException;
}
