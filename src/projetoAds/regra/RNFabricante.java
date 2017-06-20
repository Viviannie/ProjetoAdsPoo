/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoAds.regra;

import java.util.ArrayList;
import projetoAds.DAO.DAOFabricante;
import projetoAds.DAO.DAOFabricanteImpl;
import projetoAds.classesBasicas.Fabricante;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;
import projetoAds.excecao.RegraException;

/**
 *
 * @author Grupo Programação Orientada a Objetos
 */
public class RNFabricante {

    //precisa validar
    private final DAOFabricante dao = new DAOFabricanteImpl();

    public void incluir(Fabricante f) throws RegraException {
        try {
            dao.incluir(f);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public void excluir(Fabricante f) throws RegraException {
        try {
            dao.excluir(f);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public void alterar(Fabricante f) throws RegraException {
        try {
            dao.alterar(f);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
    public Fabricante pesquisarRazao (String razao) throws RegraException {
        try {
            return dao.pesquisarRazao(razao);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
    public Fabricante pesquisar(String cnpj) throws RegraException {
        try {
            return dao.pesquisar(cnpj);
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    public ArrayList<Fabricante> listar() throws RegraException {
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
    public void validar(Fabricante f) throws RegraException {

        if ((f.getRazao() == null) || (f.getRazao().trim().equals(""))) {
            throw new RegraException("Razao inválido");
        }
        if ((f.getCnpj() == null) || (f.getCnpj().trim().equals("")) || (f.getCnpj().trim().length() != 14)) {
            throw new RegraException("CPF inválido");
        }
    }

    /**
     * Verifica se uma nova descrição já existe no BD
     *
     * @param f Objeto com os dados
     * @throws RegraException
     */
    public void verificaDuplicidade(Fabricante f) throws RegraException {

        try {

            Fabricante x = dao.pesquisar(f.getCnpj());
            if (x != null) {
                throw new RegraException("Fabricante existente.");
            }
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }

    /**
     * Verifica se um ID passado é válido e existe no BD
     *
     * @param cnpj Para validação
     * @throws RegraException Caso o ID não seja localizado
     */
    public void validaCnpj(String cnpj) throws RegraException {
        
        if (cnpj == null) {
            throw new RegraException("CNPJ inválido!");
        }
        try {
            Fabricante x = dao.pesquisar(cnpj);
            if (x == null) {
                throw new RegraException("CNPJ informado não existe.");
            }
        } catch (ConexaoException | DAOException e) {
            throw new RegraException(e.getMessage());
        }
    }
}

