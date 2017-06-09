package projetoAds.fachada;

import java.util.ArrayList;
import projetoAds.classesBasicas.Cliente;
import projetoAds.classesBasicas.FormaPag;
import projetoAds.classesBasicas.Pagamento;
import projetoAds.excecao.RegraException;
import projetoAds.regra.RNCliente;
import projetoAds.regra.RNFormaPag;
import projetoAds.regra.RNPagamento;

/**
 *
 * @author Grupo Programação Orientada a Objetos
 */
public class Fachada {

    private static Fachada instancia;
    private static RNCliente rnCliente;
    private static RNPagamento rnPagamento;
    private static RNFormaPag rnFormaPag;

    private Fachada() {
        rnCliente = new RNCliente();
        rnPagamento = new RNPagamento();
        rnFormaPag = new RNFormaPag();
    }

    public static Fachada getInstancia() {
        if (instancia == null) {
            instancia = new Fachada();
        }
        return instancia;
    }

    /*#########################################################################
     * CLIENTE
     *########################################################################*/
    
    public void salvarCliente(Cliente c) throws RegraException {
        rnCliente.validar(c);
        rnCliente.verificaDuplicidade(c);
        rnCliente.incluir(c);
    }

    public void excluirCliente(Cliente c) throws RegraException {
        rnCliente.validaCpf(c.getCpf());
        rnCliente.excluir(c);
    }

    public void alterarCliente(Cliente c) throws RegraException {
        rnCliente.validar(c);
        rnCliente.validaCpf(c.getCpf());
        rnCliente.alterar(c);
    }

    public Cliente pesquisarClienteNome(Cliente c) throws RegraException {
        rnCliente.validar(c);
        return rnCliente.pesquisar(c.getNome());
    }

    public Cliente pesquisarClienteCpf(Cliente c) throws RegraException {
        rnCliente.validaCpf(c.getCpf());
        return rnCliente.pesquisar(c.getCpf());
    }

    public ArrayList<Cliente> listarCliente() throws RegraException {
        return rnCliente.listar();
    }

    /*#########################################################################
     * PAGAMENTO
     *########################################################################*/
    
    public void salvarPagamento(Pagamento g) throws RegraException { //por que teve que colocar a exceção?
        rnPagamento.validar(g);
        rnPagamento.verificaDuplicidade(g);
        rnPagamento.incluir(g);
    }

    public void excluirPagamento(Pagamento g) throws RegraException {
        rnPagamento.validaId(g.getId());
        rnPagamento.excluir(g);
    }

    public void alterarPagamento(Pagamento g) throws RegraException {
        rnPagamento.validar(g);
        rnPagamento.validaId(g.getId());
        rnPagamento.alterar(g);
    }

    public Pagamento pesquisarPagamentoPorId(Pagamento g) throws RegraException {
        rnPagamento.validaId(g.getId());
        return rnPagamento.pesquisar(g.getId());
    }

    public ArrayList<Pagamento> listarPagamentos() throws RegraException {
        return rnPagamento.listar();
    }

    /*#########################################################################
     * FORMAPAG
     *########################################################################*/
    
    public void salvarFormaPag(FormaPag f) throws RegraException{
        rnFormaPag.validar(f);
        rnFormaPag.verificaDuplicidade(f);
        rnFormaPag.incluir(f);
    }
    
    public void excluirFormaPag(FormaPag f) throws RegraException{
        rnFormaPag.validaId(f.getId());
        rnFormaPag.excluir(f);
    }
    
    public void alterarFormaPag(FormaPag f) throws RegraException{
        rnFormaPag.validar(f);
        rnFormaPag.validaId(f.getId());
        rnFormaPag.alterar(f);
    }
    
    public FormaPag pesquisarFormaPagPorId(FormaPag f) throws RegraException {
        rnFormaPag.validaId(f.getId());
        return rnFormaPag.pesquisar(f.getId());
    }
    
    public FormaPag pesquisarFormaPagPorDesc(FormaPag f) throws RegraException{
        rnFormaPag.validar(f);
        return rnFormaPag.pesquisar(f.getDesc());
    }
    
    public ArrayList<FormaPag> listarFormaPag() throws RegraException {
        return rnFormaPag.listar();
    }
}    
