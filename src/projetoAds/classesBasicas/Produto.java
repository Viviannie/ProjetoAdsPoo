package projetoAds.classesBasicas;

/**
 *
 * @author Grupo Programação Orientada a Objetos
 */
public class Produto {

    private Integer estoqueMinino;
    private Integer estoqueAtual;
    private String desc;
    private Integer id;
    private Fabricante fabricante;

    /**
     * @return the estoqueMinino
     */
    public Integer getEstoqueMinino() {
        return estoqueMinino;
    }

    /**
     * @param estoqueMinino the estoqueMinino to set
     */
    public void setEstoqueMinino(Integer estoqueMinino) {
        this.estoqueMinino = estoqueMinino;
    }

    /**
     * @return the estoqueAtual
     */
    public Integer getEstoqueAtual() {
        return estoqueAtual;
    }

    /**
     * @param estoqueAtual the estoqueAtual to set
     */
    public void setEstoqueAtual(Integer estoqueAtual) {
        this.estoqueAtual = estoqueAtual;
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

    /**
     * @return the fabricante
     */
    public Fabricante getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

}
