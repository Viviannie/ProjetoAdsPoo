package projetoAds.classesBasicas;

import java.util.ArrayList;

/**
  * @author Grupo Programação Orientada a Objetos
  */
public class Pedido {

    private String data;
    private Integer codigo;
    private Cliente cliente;
    private Vendedor vendedor;
    private PedidoProduto pedidoProduto;

    public Pedido() {
        cliente = new Cliente();
        vendedor = new Vendedor();
        pedidoProduto = new PedidoProduto();
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the vendedor
     */
    public Vendedor getVendedor() {
        return vendedor;
    }

    /**
     * @param vendedor the vendedor to set
     */
    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    /**
     * @return the pedidoProduto
     */
    public PedidoProduto getPedidoProduto() {
        return pedidoProduto;
    }

    /**
     * @param pedidoProduto the pedidoProduto to set
     */
    public void setPedidoProduto(PedidoProduto pedidoProduto) {
        this.pedidoProduto = pedidoProduto;
    }
 
}
