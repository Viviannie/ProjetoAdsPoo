package projetoAds.classesBasicas;

/**
 *
 * @author Grupo Programação Orientada a Objetos
 */
public class FormaPag {

    private String desc;
    private Integer id;
    private Pagamento pagamento;

    public FormaPag() {
        pagamento = new Pagamento();    //Criando a ligação entre as entidades
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
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
