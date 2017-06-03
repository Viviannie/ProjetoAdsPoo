package projetoAds.classesBasicas;

/**
 *
 * @author Aluno
 */
public class Pagamento {

    private Double pag_valor;
    private Integer pag_id;
    private Pedido pedido;

    public Pagamento() {
        pedido = new Pedido();
    }

    /**
     * @return the pag_valor
     */
    public double getPag_valor() {
        return pag_valor;
    }

    /**
     * @param pag_valor the pag_valor to set
     */
    public void setPag_valor(Double pag_valor) {
        this.pag_valor = pag_valor;
    }

    /**
     * @return the pedido
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * @return the pag_id
     */
    public Integer getPag_id() {
        return pag_id;
    }

    /**
     * @param pag_id the pag_id to set
     */
    public void setPag_id(Integer pag_id) {
        this.pag_id = pag_id;
    }

}
