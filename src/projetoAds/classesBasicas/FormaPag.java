package projetoAds.classesBasicas;

/**
 *
 * @author aluno
 */
public class FormaPag {

    private String forma_cod;
    private String forma_desc;
    private Pagamento pagamento;

    public FormaPag() {
        pagamento = new Pagamento();    //Criando a ligação entre as entidades
    }

    /**
     * @return the forma_cod
     */
    public String getForma_cod() {
        return forma_cod;
    }

    /**
     * @param forma_cod the forma_cod to set
     */
    public void setForma_cod(String forma_cod) {
        this.forma_cod = forma_cod;
    }

    /**
     * @return the forma_desc
     */
    public String getForma_desc() {
        return forma_desc;
    }

    /**
     * @param forma_desc the forma_desc to set
     */
    public void setForma_desc(String forma_desc) {
        this.forma_desc = forma_desc;
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

}
