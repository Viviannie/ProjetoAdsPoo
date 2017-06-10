package projetoAds.regra;

import projetoAds.DAO.DAOFabricante;
import projetoAds.DAO.DAOFabricanteImpl;
import projetoAds.classesBasicas.Fabricante;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;
import projetoAds.excecao.RegraException;

/**
 *
 * @author Annie
 */
public class RNFabricante {
    private final DAOFabricante dao = new DAOFabricanteImpl();
    
    public void validar(Fabricante f)throws RegraException{
        if((f.getRazao()==null)||(f.getRazao().trim().equals(""))){
            throw new RegraException("Razao inválida");
        }
        if((f.getCnpj()==null)||(f.getCnpj().trim().equals(""))||(f.getCnpj().trim().length()!=11)){
            throw new RegraException("CNPJ inválido");
        }
    }
    
    public void verificaDuplicidade(Fabricante  f)throws RegraException{
        try{
            Fabricante x = dao.pesquisar(f.getCnpj());
            if(x!=null){
                throw new RegraException("Fabricante já existe.");
            }
        }catch(ConexaoException | DAOException e){
            throw new RegraException(e.getMessage());
        }
    }
    
    public void incluir(Fabricante  f)throws RegraException{
         try{
            dao.incluir(f);
        }catch(ConexaoException | DAOException e){
            throw new RegraException();
        }
    }
    
    public void excluir(Fabricante  f)throws RegraException{
        if(f.getCnpj()==null){
            throw new RegraException("CNPJ inválido!");
        }
        
        try{
            Fabricante x = dao.pesquisar(f.getCnpj());
            if(x==null){
                throw new RegraException("CNPJ informado não existe.");
            }
        }catch(ConexaoException | DAOException e){
            throw new RegraException(e.getMessage());
        }
        
        try{
            dao.excluir(f);
        }catch(ConexaoException | DAOException e){
            throw new RegraException(e.getMessage());
        }
    }
}