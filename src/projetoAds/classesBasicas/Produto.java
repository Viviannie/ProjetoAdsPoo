package projetoAds.classesBasicas;

import java.util.ArrayList;

/**
 *
 * @author aluno
 */
public class Produto {
    private Integer prd_estoqueminimo;
    private Integer prd_estoqueatual;
    private String prd_desc;
    private Integer prd_cod;
    private ArrayList<Fornecedor> fornecedor;

    /**
     * @return the prd_estoqueminimo
     */
    public Integer getPrd_estoqueminimo() {
        return prd_estoqueminimo;
    }

    /**
     * @param prd_estoqueminimo the prd_estoqueminimo to set
     */
    public void setPrd_estoqueminimo(Integer prd_estoqueminimo) {
        this.prd_estoqueminimo = prd_estoqueminimo;
    }

    /**
     * @return the prd_estoqueatual
     */
    public Integer getPrd_estoqueatual() {
        return prd_estoqueatual;
    }

    /**
     * @param prd_estoqueatual the prd_estoqueatual to set
     */
    public void setPrd_estoqueatual(Integer prd_estoqueatual) {
        this.prd_estoqueatual = prd_estoqueatual;
    }

    /**
     * @return the prd_desc
     */
    public String getPrd_desc() {
        return prd_desc;
    }

    /**
     * @param prd_desc the prd_desc to set
     */
    public void setPrd_desc(String prd_desc) {
        this.prd_desc = prd_desc;
    }

    /**
     * @return the prd_cod
     */
    public Integer getPrd_cod() {
        return prd_cod;
    }

    /**
     * @param prd_cod the prd_cod to set
     */
    public void setPrd_cod(Integer prd_cod) {
        this.prd_cod = prd_cod;
    }

    /**
     * @return the fornecedor
     */
    public ArrayList<Fornecedor> getFornecedor() {
        return fornecedor;
    }

    /**
     * @param fornecedor the fornecedor to set
     */
    public void setFornecedor(ArrayList<Fornecedor> fornecedor) {
        this.fornecedor = fornecedor;
    }
    
}
