package projetoAds.classesBasicas;

/**
 *
 * @author Grupo Programação Orientada a Objetos
 */
public class Pagamento {

    private Double valor;
    private Integer id;
    private FormaPag formapag;

    public Pagamento() {
        formapag = new FormaPag();
    }

    /**
     * @return the FormaPag
     */
    public FormaPag getFormaPag() {
        return formapag;
    }

    /**
     * @param formapag the valor to set
     */
    public void setFormaPag(FormaPag formapag) {
        this.formapag = formapag;
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
