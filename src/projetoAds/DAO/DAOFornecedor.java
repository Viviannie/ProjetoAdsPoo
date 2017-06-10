package projetoAds.DAO;
import java.util.ArrayList;//Importe de classe para retorno de vários objetos
import projetoAds.classesBasicas.Fornecedor;//Clase que vai receber a entidade
import projetoAds.excecao.DAOException;
import projetoAds.excecao.ConexaoException;//Classe de Erro
/**
 *
 * @author Grupo Programação Orientada a Objetos
 */
public interface DAOFornecedor {
    /**
      * Inclui uma novo fornecedor no BD
      * @param fornecedor Objeto com os dados validados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void incluir(Fornecedor fornecedor) throws ConexaoException,DAOException;
    
    /**
      * Exclui um fornecedor do BD
      * @param fornecedor Objeto
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void excluir(Fornecedor fornecedor) throws ConexaoException,DAOException;
    
    /**
      * Altera um registro do BD
      * @param fornecedor Objeto com todos os dados validados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public void alterar(Fornecedor fornecedor) throws ConexaoException,DAOException;
    
    /**
      * Busca um registro no BD com o Codigo do fornecedor informado
      * @param frn_cnpj Parametro da busca
      * @return Objeto encontrado ou null
      * @throws ConexaoException
      * @throws DAOException 
      */
    public Fornecedor pesquisar(String frn_cnpj) throws ConexaoException,DAOException;

    /**
      * Retorna uma lista com todos os registros dos fornecedores
      * @return Objeto contendo todos os registros encontrados
      * @throws ConexaoException
      * @throws DAOException 
      */
    public ArrayList<Fornecedor> listar() throws ConexaoException,DAOException;
}
