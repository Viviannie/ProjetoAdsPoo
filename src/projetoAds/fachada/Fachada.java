package projetoAds.fachada;

import java.util.ArrayList;
import projetoAds.classesBasicas.Cliente;
import projetoAds.classesBasicas.Fabricante;
import projetoAds.classesBasicas.Pagamento;
import projetoAds.classesBasicas.Pedido;
import projetoAds.classesBasicas.Produto;
import projetoAds.classesBasicas.Venda;
import projetoAds.classesBasicas.Vendedor;
import projetoAds.excecao.ConexaoException;
import projetoAds.excecao.DAOException;
import projetoAds.excecao.RegraException;
import projetoAds.regra.RNCliente;
import projetoAds.regra.RNFabricante;
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
    private static RNVendedor rnVendedor;
    private static RNVenda rnVenda;
    private static RNPedido rnPedido;
    private static RNFabricante rnFabricante;
    private static RNProduto rnProduto;

    private Fachada() {
        rnCliente = new RNCliente();
        rnPagamento = new RNPagamento();
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
    public void salvarCliente(Cliente cliente) throws RegraException {
        rnCliente.validarNome(cliente);
        rnCliente.validarCpf(cliente);
        rnCliente.verificaDuplicidade(cliente);
        rnCliente.incluir(cliente);
    }

    public void excluirCliente(Cliente cliente) throws RegraException {
        rnCliente.validaCpf(cliente.getCpf());
        rnCliente.excluir(cliente);
    }

    public void alterarCliente(Cliente cliente) throws RegraException {
        rnCliente.validarNome(cliente);
        rnCliente.validarCpf(cliente);
        rnCliente.alterar(cliente);
    }

    public Cliente pesquisarClienteNome(Cliente cliente) throws RegraException {
        rnCliente.validarNome(cliente);
        return rnCliente.pesquisarNome(cliente.getNome());
    }

    public Cliente pesquisarClienteCpf(Cliente cliente) throws RegraException {
        rnCliente.validaCpf(cliente.getCpf());
        return rnCliente.pesquisarCpf(cliente.getCpf());
    }

    public ArrayList<Cliente> listarCliente() throws RegraException {
        return rnCliente.listar();
    }

    /*#########################################################################
     * PAGAMENTO
     *########################################################################*/
    public void salvarPagamento(Pagamento pagamento) throws RegraException {
        rnPagamento.validar(pagamento);
        rnPagamento.incluir(pagamento);
        // rnPagamento.incluirDouble(pagamento);
    }

    public void excluirPagamento(Pagamento pagamento) throws RegraException {
        rnPagamento.validaId(pagamento.getId());
        rnPagamento.excluir(pagamento);
    }

    public void alterarPagamento(Pagamento pagamento) throws RegraException {
        rnPagamento.validar(pagamento);
        rnPagamento.validaId(pagamento.getId());
        rnPagamento.alterar(pagamento);
    }

    public Pagamento pesquisarPagamento(Pagamento pagamento) throws RegraException {
        rnPagamento.validaId(pagamento.getId());
        return rnPagamento.pesquisar(pagamento.getId());
    }

    /**
     *
     * @return @throws RegraException
     */
    public ArrayList<Pagamento> listarPagamentos() throws RegraException {
        return rnPagamento.listar();
    }

    /*#########################################################################
     * VENDEDOR
     *########################################################################*/
    public void salvarVendedor(Vendedor vendedor) throws RegraException {
        rnVendedor.validar(vendedor);
        rnVendedor.incluir(vendedor);
    }

    public void excluirVendedor(Vendedor vendedor) throws RegraException {
        rnVendedor.validaId(vendedor.getId());
        rnVendedor.excluir(vendedor);
    }

    public void alterarVendedor(Vendedor vendedor) throws RegraException {
        rnVendedor.validar(vendedor);
        rnVendedor.alterar(vendedor);
    }

    public Vendedor pesquisarVendedorNome(Vendedor vendedor) throws RegraException {
        rnVendedor.validar(vendedor);
        return rnVendedor.pesquisarNome(vendedor.getNome());
    }

    public Vendedor pesquisarVendedorId(Vendedor vendedor) throws RegraException {
        rnVendedor.validaId(vendedor.getId());
        return rnVendedor.pesquisarId(vendedor.getId());
    }

    public ArrayList<Vendedor> listarVendedor() throws RegraException {
        return rnVendedor.listar();
    }

    /*#########################################################################
     * Pedido
     *########################################################################*/
    /**
     *
     * @param pedido
     * @throws RegraException
     */
    public void salvarPedido(Pedido pedido) throws RegraException {
        rnPedido.validar(pedido);
        rnPedido.incluir(pedido);
    }

    public void excluirPedido(Pedido pedido) throws RegraException {
        rnPedido.validar(pedido);
        rnPedido.excluir(pedido);
    }

    public void alterarPedido(Pedido pedido) throws RegraException {
        rnPedido.validar(pedido);
        rnPedido.alterar(pedido);
    }

    public Pedido pesquisarPedidoId(Integer id) throws RegraException {
        rnPedido.validaId(id);
        return rnPedido.pesquisarId(id);
    }
    
    public ArrayList<Pedido> listarPedido() throws RegraException {
        return rnPedido.listar();
    }

    /*#########################################################################
     * Venda
     *########################################################################*/
    public void salvarVenda(Venda venda) throws RegraException {
        rnVenda.incluir(venda);
    }

    public void excluirVenda(Venda venda) throws RegraException {
        rnVenda.excluir(venda);
    }

    public void alterarVenda(Venda venda) throws RegraException {
        rnVenda.alterar(venda);
    }

    public Venda pesquisarVenda(Integer id) throws RegraException {
        return rnVenda.pesquisar(id);
    }

    public ArrayList<Venda> listarVenda() throws RegraException {
        return rnVenda.listar();
    }

    /*#########################################################################
     * Fabricante
     *########################################################################*/
    public void salvarFabricante(Fabricante fabricante) throws RegraException {
        rnFabricante.validar(fabricante);
        rnFabricante.verificaDuplicidade(fabricante);
        rnFabricante.incluir(fabricante);
    }

    public void excluirFabricante(Fabricante fabricante) throws RegraException {
        rnFabricante.validaCnpj(fabricante.getCnpj());
        rnFabricante.excluir(fabricante);
    }

    public void alterarFabricante(Fabricante fabricante) throws RegraException {
        rnFabricante.validar(fabricante);
        rnFabricante.alterar(fabricante);
    }

    public Fabricante pesquisarFabricanteRazao(Fabricante fabricante) throws RegraException {
        rnFabricante.validar(fabricante);
        return rnFabricante.pesquisar(fabricante.getRazao());
    }

    public Fabricante pesquisarFabricanteCnpj(Fabricante fabricante) throws RegraException {
        rnFabricante.validaCnpj(fabricante.getCnpj());
        return rnFabricante.pesquisar(fabricante.getCnpj());
    }

    public ArrayList<Fabricante> listarFabricante() throws RegraException {
        return rnFabricante.listar();
    }

    /*#########################################################################
     * PRODUTO
     *########################################################################*/
    public void salvarProduto(Produto produto) throws RegraException {
        rnProduto.validar(produto);
        rnFabricante.validaCnpj(produto.getFabricante().getCnpj());
        rnProduto.verificaDuplicidade(produto);
        rnProduto.incluir(produto);
    }

    public void excluirProduto(Produto produto) throws RegraException {
        rnProduto.validaId(produto.getId());
        rnProduto.excluir(produto);
    }

    public void alterarProduto(Produto produto) throws RegraException {
        rnProduto.validar(produto);
        rnFabricante.validaCnpj(produto.getFabricante().getCnpj());
        rnProduto.validaId(produto.getId());
        rnProduto.alterar(produto);
    }

    public Produto pesquisarProdutoDesc(Produto produto) throws RegraException {
        rnProduto.validaDesc(produto.getDesc());
        return rnProduto.pesquisar(produto.getDesc());
    }

    public Produto pesquisarProdutoId(Produto produto) throws RegraException {
        rnProduto.validaId(produto.getId());
        return rnProduto.pesquisar(produto.getId());
    }

    public ArrayList<Produto> listarProduto() throws RegraException {
        return rnProduto.listar();
    }

}
