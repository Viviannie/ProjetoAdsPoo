package projetoAds.classesBasicas;

import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class Produto {

    private Integer prd_estoqueminino;
    private Integer prd_estoqueatual;
    private String prd_desc;
    private Integer prd_id;
    private ArrayList<Fornecedor> fornecedor;

    /**
     * @return the prd_estoqueminimo
     */
    public Integer getPrd_estoqueminimo() {
        return prd_estoqueminino;
    }

    /**
     * @param prd_estoqueminimo the prd_estoqueminimo to set
     */
    public void setPrd_estoqueminimo(Integer prd_estoqueminimo) {
        this.prd_estoqueminino = prd_estoqueminimo;
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
     * @return the prd_id
     */
    public Integer getPrd_id() {
        return prd_id;
    }

    /**
     * @param prd_id the prd_id to set
     */
    public void setPrd_id(Integer prd_id) {
        this.prd_id = prd_id;
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
