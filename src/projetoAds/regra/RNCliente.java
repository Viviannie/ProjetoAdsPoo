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
    private final DAOCliente dao = new DAOClienteImpl();
    
    public void validar(Cliente c)throws RegraException{
        if((c.getNome()==null)||(c.getNome().trim().equals(""))){
            throw new RegraException("Nome inválido");
        }
        if((c.getCpf()==null)||(c.getCpf().trim().equals(""))||(c.getCpf().trim().length()!=11)){
            throw new RegraException("CPF inválido");
        }
    }
    
    public void verificaDuplicidade(Cliente  c)throws RegraException{
        try{
            Cliente x = dao.pesquisar(c.getCpf());
            if(x!=null){
                throw new RegraException("Cliente já existe.");
            }
        }catch(ConexaoException | DAOException e){
            throw new RegraException(e.getMessage());
        }
    }
    
    public void incluir(Cliente  c)throws RegraException{
         try{
            dao.incluir(c);
        }catch(ConexaoException | DAOException e){
            throw new RegraException();
        }
    }
    
    public void excluir(Cliente c)throws RegraException{
        if(c.getCpf()==null){
            throw new RegraException("CPF inválido!");
        }
        
        try{
            Cliente x = dao.pesquisar(c.getCpf());
            if(x==null){
                throw new RegraException("CPF informado não existe.");
            }
        }catch(ConexaoException | DAOException e){
            throw new RegraException(e.getMessage());
        }
        
        try{
            dao.excluir(c);
        }catch(ConexaoException | DAOException e){
            throw new RegraException(e.getMessage());
        }
    }
}
