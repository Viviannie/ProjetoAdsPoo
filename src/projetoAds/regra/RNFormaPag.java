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
 * @author Grupo Programação Orientada a Objetos
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

    public FormaPag pesquisar(Integer id) throws RegraException {
        try {
            return dao.pesquisar(id);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public FormaPag pesquisar(String desc) throws RegraException {
        try {
            return dao.pesquisar(desc);
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

        if (f.getId() == null) {
            throw new RegraException("ID inválida.");
        }

        if ((f.getDesc() == null) || (f.getDesc().trim().equals(" "))) {
            throw new RegraException("Descrição inválida.");
        }        
        
        if (f.getId() == 1){
            f.setDesc("Cartão");
        } else if(f.getId() == 2) {
            f.setDesc("Dinheiro");
        }

    }

    public void verificaDuplicidade(FormaPag f) throws RegraException {

        try {

            FormaPag x = dao.pesquisar(f.getDesc());
            if (x != null) {
                throw new RegraException("Forma de pagamento já escolhida.");
            }

        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
    
    /**
     * Verifica se um ID passado é válido e existe no BD
     *
     * @param id Para validação
     * @throws RegraException Caso o ID não seja localizado
     */
    public void validaId(Integer id) throws RegraException {

        if (id == null) {
            throw new RegraException("ID inválida.");
        }
        
        try {
            FormaPag x = dao.pesquisar(id);
            if (x == null) {
                throw new RegraException("ID informado não existe.");
            }

        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
    
    public void validaDesc(String desc) throws RegraException {

        if (desc == null) {
            throw new RegraException("Descrição inválida.");
        }

        try {
            FormaPag x = dao.pesquisar(desc);
            if (x == null) {
                throw new RegraException("Descrição informada não existe.");
            }

        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
}
