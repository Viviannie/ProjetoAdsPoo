package projetoAds.classesBasicas;

/**
 *
 * @author Grupo Programação Orientada a Objetos
 */
public class Pagamento {

    private Double valor;
    private Integer id;
    private Pedido pedido;
    private FormaPag formaPag;

    public Pagamento() {
        formaPag = new FormaPag();
        pedido = new Pedido();
    }
    
    /**
     * @return the pedido
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * @param pedido the valor to set
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * @return the FormaPag
     */
    public FormaPag getFormaPag() {
        return formaPag;
    }

    /**
     * @param formaPag the valor to set
     */
    public void setFormaPag(FormaPag formaPag) {
        this.formaPag = formaPag;
    }

    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
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

}
