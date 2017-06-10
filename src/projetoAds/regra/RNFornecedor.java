package projetoAds.regra;

import projetoAds.DAO.DAOFornecedor;
import projetoAds.DAO.DAOFornecedorImpl;
import projetoAds.classesBasicas.Fornecedor;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;
import projetoAds.excecao.RegraException;

/**
 *
 * @author Annie
 */
public class RNFornecedor {
    
    private final DAOFornecedor dao = new DAOFornecedorImpl();

    public void incluir(Fornecedor r) throws RegraException {
        try {
            dao.incluir(r);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public void excluir(Fornecedor r) throws RegraException {
        try {
            dao.excluir(r);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public void alterar(Fornecedor r) throws RegraException {
        try {
            dao.alterar(r);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public Fornecedor pesquisar(String frn_cnpj) throws RegraException {
        try {
            return dao.pesquisar(frn_cnpj);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    
    /**
     * Verifica se os campos estão preenchidos corretamente
     *
     * @param r Objeto com os dados
     * @throws RegraException
     */
    public void validar(Fornecedor r) throws RegraException {

        if ((r.getFrn_razao() == null) || (r.getFrn_razao().trim().equals(""))) {
            throw new RegraException("Razão social inválida.");
        }
        if ((r.getFrn_cnpj() == null) || (r.getFrn_cnpj().trim().equals(""))) {
            throw new RegraException("CNPJ inválido.");
        }
    }

    /**
     * Verifica se uma nova descrição já existe no BD
     *
     * @param r Objeto com os dados
     * @throws RegraException
     */
    public void verificaDuplicidade(Fornecedor r) throws RegraException {

        try {

            Fornecedor x = dao.pesquisar(r.getFrn_cnpj());
            if (x != null) {
                throw new RegraException("Fornecedor existente.");
            }
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    /**
     * Verifica se um CNPJ passado é válido e existe no BD
     *
     * @param frn_cnpj Para validação
     * @throws RegraException Caso o ID não seja localizado
     */
    public void validaCnpj(String frn_cnpj) throws RegraException {
        
        if (frn_cnpj == null) {
            throw new RegraException("CNPJ inválido!");
        }
        try {
            Fornecedor x = dao.pesquisar(frn_cnpj);
            if (x == null) {
                throw new RegraException("CNPJ informado não existe.");
            }
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
}
