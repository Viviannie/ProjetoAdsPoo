package projetoAds.classesBasicas;

import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Pedido {

    private String ped_data;
    private Integer ped_cod;
    private Cliente cliente;
    private Vendedor vendedor;
    private ArrayList<PedidoProduto> pedidoProduto;

    public Pedido() {
        cliente = new Cliente();
        vendedor = new Vendedor();
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
     * @return the ped_numero
     */
    public Integer getPed_cod() {
        return ped_cod;
    }

    /**
     * @param ped_cod the ped_numero to set
     */
    public void setPed_cod(Integer ped_cod) {
        this.ped_cod = ped_cod;
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
    public ArrayList<PedidoProduto> getPedidoProduto() {
        return pedidoProduto;
    }

    /**
     * @param pedidoProduto the pedidoProduto to set
     */
    public void setPedidoProduto(ArrayList<PedidoProduto> pedidoProduto) {
        this.pedidoProduto = pedidoProduto;
    }

}

class PedidoProduto {

    private Double prc_unitario;
    private Integer qtd_produtos;
    private Integer prd_cod;                    //isso não entra aqui?
    private Integer ped_cod;

    /**
     * @return the prc_unitario
     */
    public Double getPrc_unitario() {
        return prc_unitario;
    }

    /**
     * @param prc_unitario the prc_unitario to set
     */
    public void setPrc_unitario(Double prc_unitario) {
        this.prc_unitario = prc_unitario;
    }

    /**
     * @return the qtd_produtos
     */
    public Integer getQtd_produtos() {
        return qtd_produtos;
    }

    /**
     * @param qtd_produtos the qtd_produtos to set
     */
    public void setQtd_produtos(Integer qtd_produtos) {
        this.qtd_produtos = qtd_produtos;
    }

}
