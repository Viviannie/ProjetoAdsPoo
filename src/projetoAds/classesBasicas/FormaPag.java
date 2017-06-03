package projetoAds.classesBasicas;

/**
 *
 * @author Aluno
 */
public class FormaPag {

    private String frm_desc;
    private Integer frm_id;
    private Pagamento pagamento;

    public FormaPag() {
        pagamento = new Pagamento();    //Criando a ligação entre as entidades
    }

    /**
     * @return the forma_desc
     */
    public String getFrm_desc() {
        return frm_desc;
    }

    /**
     * @param frm_desc the frm_desc to set
     */
    public void setFem_desc(String frm_desc) {
        this.frm_desc = frm_desc;
    }

    /**
     * @return the pagamento
     */
    public Pagamento getPagamento() {
        return pagamento;
    }

    /**
     * @param pagamento the pagamento to set
     */
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    /**
     * @return the frm_id
     */
    public Integer getFrm_id() {
        return frm_id;
    }

    /**
     * @param frm_id the frm_id to set
     */
    public void setFrm_id(Integer frm_id) {
        this.frm_id = frm_id;
    }

}
