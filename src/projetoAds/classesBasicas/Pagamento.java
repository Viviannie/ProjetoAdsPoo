package projetoAds.classesBasicas;

/**
 *
 * @author aluno
 */
public class Pagamento {

    private String pag_cod;
    private Double pag_valor;
    private Pedido pedido;
    private Integer pag_id;

    public Pagamento() {
        pedido = new Pedido();
    }

    /**
     * @return the pag_cod
     */
    public String getPag_cod() {
        return pag_cod;
    }

    /**
     * @param pag_cod the pag_cod to set
     */
    public void setPag_cod(String pag_cod) {
        this.pag_cod = pag_cod;
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
