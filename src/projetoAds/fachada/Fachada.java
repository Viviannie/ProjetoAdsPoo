package projetoAds.fachada;

import java.util.ArrayList;
import projetoAds.classesBasicas.Cliente;
import projetoAds.classesBasicas.Fabricante;
import projetoAds.classesBasicas.FormaPag;
import projetoAds.classesBasicas.Pagamento;
import projetoAds.classesBasicas.Pedido;
import projetoAds.classesBasicas.Produto;
import projetoAds.classesBasicas.Venda;
import projetoAds.classesBasicas.Vendedor;
import projetoAds.excecao.RegraException;
import projetoAds.regra.RNCliente;
import projetoAds.regra.RNFabricante;
import projetoAds.regra.RNFormaPag;
import projetoAds.regra.RNPagamento;
import projetoAds.regra.RNPedido;
import projetoAds.regra.RNProduto;
import projetoAds.regra.RNVenda;
import projetoAds.regra.RNVendedor;

/**
 *
 * @author Grupo Programação Orientada a Objetos
 */
public class Fachada {

    private static Fachada instancia;
    private static RNCliente rnCliente;
    private static RNPagamento rnPagamento;
    private static RNFormaPag rnFormaPag;
    private static RNVendedor rnVendedor;
    private static RNVenda rnVenda;
    private static RNPedido rnPedido;
    private static RNFabricante rnFabricante;
    private static RNProduto rnProduto;

    private Fachada() {
        rnCliente = new RNCliente();
        rnPagamento = new RNPagamento();
        rnFormaPag = new RNFormaPag();
        rnVendedor = new RNVendedor();
        rnVenda = new RNVenda();
        rnPedido = new RNPedido();
        rnFabricante = new RNFabricante();
        rnProduto = new RNProduto();
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

    /**
     *
     * @return
     * @throws RegraException
     */
    public ArrayList<Pagamento> listarPagamentos() throws RegraException {
        return rnPagamento.listar();
    }

    /*#########################################################################
     * FORMAPAG
     *########################################################################*/
    
    public void salvarFormaPag(FormaPag f) throws RegraException{
        rnFormaPag.validar(f);
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
    
    /*#########################################################################
     * VENDEDOR
     *########################################################################*/
    
    public void salvarCliente(Vendedor v) throws RegraException {
        rnVendedor.validar(v);
        rnVendedor.incluir(v);
    }

    public void excluirCliente(Vendedor v) throws RegraException {
        rnVendedor.validaId(v.getId());
        rnVendedor.excluir(v);
    }

    public void alterarCliente(Vendedor v) throws RegraException {
        rnVendedor.validar(v);
        rnVendedor.validaId(v.getId());
        rnVendedor.alterar(v);
    }

    public Vendedor pesquisarClienteNome(Vendedor v) throws RegraException {
        rnVendedor.validar(v);
        return rnVendedor.pesquisar(v.getNome());
    }

    public Vendedor pesquisarVendedorId(Vendedor c) throws RegraException {
        rnVendedor.validaId(c.getId());
        return rnVendedor.pesquisar(c.getId());
    }

    public ArrayList<Vendedor> listarVendedor() throws RegraException {
        return rnVendedor.listar();
    }
    
    /*#########################################################################
     * Pedido
     *########################################################################*/
    
    public void incluir(Pedido pedido) throws RegraException {
        rnPedido.incluir(pedido); // falta implementar
    }
    
    public void excluir(Pedido pedido) throws RegraException {
        rnPedido.excluir(pedido); // falta implementar
    }
    public void alterar(Pedido pedido) throws RegraException {
        rnPedido.alterar(pedido); // falta implementar
    }
    public Pedido pesquisar(Integer id) throws RegraException {
        return null; // falta implementar
    }
    public ArrayList<Pedido> listarPedido() throws RegraException {
        return rnPedido.listar(); // falta implementar
    }
    
    /*#########################################################################
     * Venda
     *########################################################################*/
    public void incluir(Venda venda) throws RegraException {
        rnVenda.incluir(venda); // falta implementar
    }
    
    public void excluir(Venda venda) throws RegraException {
        rnVenda.excluir(venda); // falta implementar
    }
    public void alterar(Venda venda) throws RegraException {
        rnVenda.alterar(venda); // falta implementar
    }
    public Venda pesquisarVenda(Integer id) throws RegraException {
        return null; // falta implementar
    }
    public ArrayList<Venda> listarVenda() throws RegraException {
        return rnVenda.listar(); // falta implementar
    }
    
    /*#########################################################################
     * Fabricante
     *########################################################################*/
    
    public void salvarFabricante(Fabricante f) throws RegraException {
        rnFabricante.validar(f);
        rnFabricante.verificaDuplicidade(f);
        rnFabricante.incluir(f);
    }

    public void excluirFabricante(Fabricante f) throws RegraException {
        rnFabricante.validaCnpj(f.getCnpj());
        rnFabricante.excluir(f);
    }

    public void alterarFabricante(Fabricante f) throws RegraException {
        rnFabricante.validar(f);
        rnFabricante.validaCnpj(f.getCnpj());
        rnFabricante.alterar(f);
    }

    public Fabricante pesquisarFabricanteRazao(Fabricante f) throws RegraException {
        rnFabricante.validar(f);
        return rnFabricante.pesquisar(f.getRazao());
    }

    public Fabricante pesquisarFabricanteCnpj(Fabricante f) throws RegraException {
        rnFabricante.validaCnpj(f.getCnpj());
        return rnFabricante.pesquisar(f.getCnpj());
    }

    public ArrayList<Fabricante> listarFabricante() throws RegraException {
        return rnFabricante.listar();
    }
    
    /*#########################################################################
     * PRODUTO
     *########################################################################*/
    
    public void salvarProduto(Produto p) throws RegraException {
        rnProduto.validar(p);
        rnFabricante.validaCnpj(p.getFabricante().getCnpj());
        rnProduto.verificaDuplicidade(p);
        rnProduto.incluir(p);
    }

    public void excluirProduto(Produto p) throws RegraException {
        rnProduto.validaId(p.getId());
        rnProduto.excluir(p);
    }

    public void alterarProduto(Produto p) throws RegraException {
        rnProduto.validar(p);
        rnFabricante.validaCnpj(p.getFabricante().getCnpj());
        rnProduto.validaId(p.getId());
        rnProduto.alterar(p);
    }

    public Produto pesquisarProdutoDesc(Produto p) throws RegraException {
        rnProduto.validaDesc(p.getDesc());
        return rnProduto.pesquisar(p.getDesc());
    }

    public Produto pesquisarProdutoId(Produto p) throws RegraException {
        rnProduto.validaId(p.getId());
        return rnProduto.pesquisar(p.getId());
    }

    public ArrayList<Produto> listarProduto() throws RegraException {
        return rnProduto.listar();
    }
    
}    
