package projetoAds.DAO;
import java.util.ArrayList;//Importe de classe para retorno de vários objetos
import projetoAds.classesBasicas.Fabricante;//Clase que vai receber a entidade
import projetoAds.excecao.DAOException;
import projetoAds.excecao.ConexaoException;//Classe de Erro
/**
 *
 * @author Grupo Programação Orientada a Objetos
 */
public interface DAOFabricante {
    /**
      * Inclui uma novo fornecedor no BD
      * @param fabricante Objeto com os dados validados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void incluir(Fabricante fabricante) throws ConexaoException,DAOException;
    
    /**
      * Exclui um fornecedor do BD
      * @param fabricante Objeto
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void excluir(Fabricante fabricante) throws ConexaoException,DAOException;
    
    /**
      * Altera um registro do BD
      * @param fabricante Objeto com todos os dados validados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void alterar(Fabricante fabricante) throws ConexaoException,DAOException;
    
    /**
      * Busca um registro no BD com o Codigo do fornecedor informado
      * @param cnpj Parametro da busca
      * @return Objeto encontrado ou null
      * @throws ConexaoException
      * @throws DAOException 
      */
    public Fabricante pesquisarCnpj(String cnpj) throws ConexaoException,DAOException;

    /**
      * Busca um registro no BD com o Codigo do fornecedor informado
      * @param razao Parametro da busca
      * @return Objeto encontrado ou null
      * @throws ConexaoException
      * @throws DAOException 
      */
    public Fabricante pesquisarRazao(String razao) throws ConexaoException,DAOException;

    /**
      * Retorna uma lista com todos os registros dos fornecedores
      * @return Objeto contendo todos os registros encontrados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public ArrayList<Fabricante> listar() throws ConexaoException,DAOException;
}
