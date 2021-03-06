package projetoAds.classesBasicas;

import java.util.ArrayList;

/**
  * @author Grupo Programação Orientada a Objetos
  */
public class Pedido {

    private String data;
    private Integer id;
    private Cliente cliente;
    private Vendedor vendedor;
    private ArrayList<Venda> venda;
    
    /**
      * usado por padrão para que seja criada uma instancia 
      * dos objetos utilizados
      */
    public Pedido() {
        cliente = new Cliente();
        vendedor = new Vendedor();
        venda = new ArrayList<>();
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
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @return the venda
     */
    public ArrayList<Venda> getVenda() {
        return venda;
    }

    /**
     * @param venda the venda to set
     */
    public void setVenda(ArrayList<Venda> venda) {
        this.venda = venda;
    }
 
}
