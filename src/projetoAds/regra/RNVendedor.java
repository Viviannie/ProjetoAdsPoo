/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoAds.regra;

import projetoAds.DAO.DAOVendedor;
import projetoAds.DAO.DAOVendedorImpl;
import projetoAds.classesBasicas.Vendedor;
import projetoAds.excecao.RegraException;

/**
 *
 * @author Annie
 */
public class RNVendedor {
    
    private final DAOVendedor dao = new DAOVendedorImpl();
    
    public void validar(Vendedor a)throws RegraException{
        if((a.getVend_Id()==null)||(a.getNome().trim().equals(""))){
            throw new RegraException("Nome inválido");
        }
        if((a.getCpf()==null)||(a.getCpf().trim().equals(""))||(a.getCpf().trim().length()!=11)){
            throw new RegraException("CPF inválido");
        }
        if(a.getTurma().getId()==null){
            throw new RegraException("Turma inválida");
        }
    }
    
    public void verificaDuplicidade(Aluno  t)throws RegraException{
        try{
            Aluno x = dao.pesquisar(t.getCpf());
            if(x!=null){
                throw new RegraException("Aluno já existe.");
            }
        }catch(ConexaoException | DAOException e){
            throw new RegraException(e.getMessage());
        }
    }
    
    public void incluir(Aluno  t)throws RegraException{
         try{
            dao.incluir(t);
        }catch(ConexaoException | DAOException e){
            throw new RegraException();
        }
    }
    
    public void excluir(Aluno t)throws RegraException{
        if(t.getId()==null){
            throw new RegraException("ID inválido!");
        }
        
        try{
            Aluno x = dao.pesquisar(t.getId());
            if(x==null){
                throw new RegraException("ID informado não existe.");
            }
        }catch(ConexaoException | DAOException e){
            throw new RegraException(e.getMessage());
        }
        
        try{
            dao.excluir(t);
        }catch(ConexaoException | DAOException e){
            throw new RegraException(e.getMessage());
        }
    }
}
