package projetoAds.classesBasicas;

/**
 *
 * @author aluno
 */
public class Fornecedor {

    private String frn_razao;
    private String frn_cnpj;
    private Integer frn_id;

    /**
     * @return the frn_razao
     */
    public String getFrn_razao() {
        return frn_razao;
    }

    /**
     * @param frn_razao the frn_razao to set
     */
    public void setFrn_razao(String frn_razao) {
        this.frn_razao = frn_razao;
    }

    /**
     * @return the frn_cnpj
     */
    public String getFrn_cnpj() {
        return frn_cnpj;
    }

    /**
     * @param frn_cnpj the frn_cnpj to set
     */
    public void setFrn_cnpj(String frn_cnpj) {
        this.frn_cnpj = frn_cnpj;
    }

    /**
     * @return the frn_id
     */
    public Integer getFrn_id() {
        return frn_id;
    }

    /**
     * @param frn_id the frn_id to set
     */
    public void setFrn_id(Integer frn_id) {
        this.frn_id = frn_id;
    }

    
}
