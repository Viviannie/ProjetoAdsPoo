package projetoAds.regra;

import java.util.ArrayList;
import projetoAds.DAO.DAOFormaPag;
import projetoAds.DAO.DAOFormaPagImpl;
import projetoAds.classesBasicas.FormaPag;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;
import projetoAds.excecao.RegraException;

/**
 *
 * @author Annie
 */
public class RNFormaPag {

    private final DAOFormaPag dao = new DAOFormaPagImpl();

    public void incluir(FormaPag f) throws RegraException {
        try {
            dao.incluir(f);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public void excluir(FormaPag f) throws RegraException {
        try {
            dao.excluir(f);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public void alterar(FormaPag f) throws RegraException {
        try {
            dao.alterar(f);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public FormaPag pesquisar(String frm_desc) throws RegraException {
        try {
            return dao.pesquisar(frm_desc);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public FormaPag pesquisar(Integer frm_id) throws RegraException {
        try {
            return dao.pesquisar(frm_id);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public ArrayList<FormaPag> listar() throws RegraException {
        try {
            return dao.listar();
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    /**
     * Verifica se os campos estão preenchidos corretamente
     *
     * @param f Objeto com os dados
     * @throws RegraException
     */
    public void validar(FormaPag f) throws RegraException {

        if (f.getFrm_id() == null) {
            throw new RegraException("ID inválida.");
        }

        if ((f.getFrm_desc() == null) || (f.getFrm_desc().trim().equals("")))  {
            throw new RegraException("Descrição inválida.");
        }
        
        if(f.getPagamento().getPag_id() == null){
            throw new RegraException("Pagamento inválido.");
        }
    }

    /**
     * Verifica se uma nova descrição já existe no BD
     *
     * @param f Objeto com os dados
     * @throws RegraException
     */
    public void verificaDuplicidade(FormaPag f) throws RegraException {

        try {

            FormaPag x = dao.pesquisar(f.getFrm_id());
            if (x != null) {
                throw new RegraException("Forma de pagamento existente.");
            }
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    /**
     * Verifica se um ID passado é válido e existe no BD
     *
     * @param cli_cpf Para validação
     * @throws RegraException Caso o ID não seja localizado
     */
    public void validaCpf(String cli_cpf) throws RegraException {

        if (cli_cpf == null) {
            throw new RegraException("CPF inválido!");
        }

        try {
            FormaPag x = dao.pesquisar(cli_cpf);
            if (x == null) {
                throw new RegraException("CPF informado não existe.");
            }

        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
}
