package projetoAds;

import projetoAds.conexao.ConexaoBD;
import projetoAds.conexao.Conectar;
import projetoAds.excecao.ConexaoException;

/**
 *
 * @author Grupo Programação Orientada a Objetos
 */
public class ProjetoPoo {
    
    /**
     * @testanto
     * @param args
     */
    public static void main(String[] args){
        ConexaoBD c;
        c = Conectar.getInstancia();
        
        
    try{
        c.conectar();
        System.out.println("Massa!");
    }catch(ConexaoException e){
        System.out.println("Não foi dessa vez!");
    }
        
    }
    
}
