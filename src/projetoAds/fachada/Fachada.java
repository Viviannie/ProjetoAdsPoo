package projetoAds.fachada;

import java.util.ArrayList;
import projetoAds.classesBasicas.Cliente;
import projetoAds.excecao.RegraException;
import projetoAds.regra.RNCliente;

/**
 *
 * @author Grupo Programação Orientada a Objetos
 */
public class Fachada {
    
    private static Fachada instancia;
    private static RNCliente rnCliente;
    
    private Fachada(){
        rnCliente = new RNCliente();
    }
    
    public static Fachada getInstancia(){
        if(instancia == null){
            instancia = new Fachada();
        }
        return instancia;
    }
    
    public void salvarCliente(Cliente c) throws RegraException{
        rnCliente.validar(c);
        rnCliente.verificaDuplicidade(c);
        rnCliente.incluir(c);
    }
    
    public void excluirCliente(Cliente c)throws RegraException{
        rnCliente.validaCpf(c.getCpf());
        rnCliente.excluir(c);
    }
    
    public void alterarCliente(Cliente c)throws RegraException{
        rnCliente.validar(c);
        rnCliente.validaCpf(c.getCpf());
        rnCliente.alterar(c);
    }
    
    public Cliente pesquisarClienteNome(Cliente c)throws RegraException{
        rnCliente.validar(c);
        return rnCliente.pesquisar(c.getNome());
    }
    
    public Cliente pesquisarClienteCpf(Cliente c)throws RegraException{
        rnCliente.validaCpf(c.getCpf());
        return rnCliente.pesquisar(c.getCpf());
    }
    
    public ArrayList<Cliente> listarCliente()throws RegraException{
        return rnCliente.listar();
    }
}

