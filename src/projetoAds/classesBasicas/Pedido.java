package projetoAds.classesBasicas;

import java.util.ArrayList;

/**
 *
 * @author Grupo Programação Orientada a Objetos
 */
public class Pedido {

    private String ped_data;
    private Integer ped_id;
    private Cliente cliente;
    private Vendedor vendedor;
    private PedidoProduto pedidoProduto;

    public Pedido() {
        cliente = new Cliente();
        vendedor = new Vendedor();
        pedidoProduto = new PedidoProduto();
    }
    

    /**
     * @return the ped_data
     */
    public String getPed_data() {
        return ped_data;
    }

    /**
     * @param ped_data the ped_data to set
     */
    public void setPed_data(String ped_data) {
        this.ped_data = ped_data;
    }

    /**
     * @return the ped_id
     */
    public Integer getPed_id() {
        return ped_id;
    }

    /**
     * @param ped_id the ped_id to set
     */
    public void setPed_id(Integer ped_id) {
        this.ped_id = ped_id;
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
     * @param pedidoProduto the pedido/produto to set
     */
    public void setPedidoProduto(PedidoProduto pedidoProduto) {
        this.pedidoProduto = pedidoProduto;
    }
}
