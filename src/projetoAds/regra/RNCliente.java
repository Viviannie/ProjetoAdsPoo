package projetoAds.regra;

import java.util.ArrayList;
import projetoAds.DAO.DAOCliente;
import projetoAds.DAO.DAOClienteImpl;
import projetoAds.classesBasicas.Cliente;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;
import projetoAds.excecao.RegraException;

/**
  * @author Grupo Programação Orientada a Objetos
  */
public class RNCliente {

    //precisa validar
    private final DAOCliente dao = new DAOClienteImpl();

    public void incluir(Cliente c) throws RegraException {
        try {
            dao.incluir(c);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public void excluir(Cliente c) throws RegraException {
        try {
            dao.excluir(c);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public void alterar(Cliente c) throws RegraException {
        try {
            dao.alterar(c);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
    public Cliente pesquisarNome (String nome) throws RegraException {
        try {
            return dao.pesquisar(nome);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
    public Cliente pesquisar(String cpf) throws RegraException {
        try {
            return dao.pesquisar(cpf);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public ArrayList<Cliente> listar() throws RegraException {
        try {
            return dao.listar();
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    /**
     * Verifica se os campos estão preenchidos corretamente
     *
     * @param c Objeto com os dados
     * @throws RegraException
     */
    public void validar(Cliente c) throws RegraException {

        if ((c.getNome() == null) || (c.getNome().trim().equals(""))) {
            throw new RegraException("Nome inválido");
        }
        if ((c.getCpf() == null) || (c.getCpf().trim().equals("")) || (c.getCpf().trim().length() != 11)) {
            throw new RegraException("CPF inválido");
        }
    }

    /**
     * Verifica se uma nova descrição já existe no BD
     *
     * @param c Objeto com os dados
     * @throws RegraException
     */
    public void verificaDuplicidade(Cliente c) throws RegraException {

        try {

            Cliente x = dao.pesquisar(c.getCpf());
            if (x != null) {
                throw new RegraException("Cliente existente.");
            }
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    /**
     * Verifica se um ID passado é válido e existe no BD
     *
     * @param cpf Para validação
     * @throws RegraException Caso o ID não seja localizado
     */
    public void validaCpf(String cpf) throws RegraException {
        
        if (cpf == null) {
            throw new RegraException("CPF inválido!");
        }
        try {
            Cliente x = dao.pesquisar(cpf);
            if (x == null) {
                throw new RegraException("CPF informado não existe.");
            }
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
}
