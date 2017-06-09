package projetoAds.DAO;
import java.util.ArrayList;
import projetoAds.classesBasicas.FormaPag;
import projetoAds.excecao.DAOException;
import projetoAds.excecao.ConexaoException;
/**
 *
 * @author Grupo Programação Orientada a Objetos
 */
public interface DAOFormaPag {
    /**
      * Inclui uma nova forma de pagamento ao BD
      * @param formaPag Objeto com os dados validados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void incluir(FormaPag formaPag) throws ConexaoException,DAOException;
    
    /**
      * Exclui um registro do BD
      * @param formaPag Objeto com o chave primaria do registro
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void excluir(FormaPag formaPag) throws ConexaoException,DAOException;
    
    /**
      * Altera um registro do BD
      * @param formaPag Objeto com todos os dados validados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void alterar(FormaPag formaPag) throws ConexaoException,DAOException;
    
    /**
      * Busca um registro no BD com o codigo do pagamento informado
      * @param id Parametro da busca
      * @return Objeto encontrado ou null
      * @throws ConexaoException
      * @throws DAOException 
      */
    public FormaPag pesquisar(Integer id) throws ConexaoException,DAOException;

    /**
      * Busca um registro no BD com o codigo do pagamento informado
      * @param desc Parametro da busca
      * @return Objeto encontrado ou null
      * @throws ConexaoException
      * @throws DAOException 
      */
    public FormaPag pesquisar(String desc) throws ConexaoException,DAOException;
    
    /**
      * Retorna uma lista com todos os registros do Pagamento
      * @return Objeto contendo todos os registros encontrados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public ArrayList<FormaPag> listar() throws ConexaoException,DAOException;
}
