package projetoAds.classesBasicas;

/**
  * @author Grupo Programação Orientada a Objetos
  */
public class PedidoProduto {

        private Double preco_unitario;
        private Integer quantidade_produtos;
        private Produto produto;
        private Pedido pedido;

        public PedidoProduto() {
            produto = new Produto();
            pedido = new Pedido();
        }

    /**
     * @return the preco_unitario
     */
    public Double getPreco_unitario() {
        return preco_unitario;
    }

    /**
     * @param preco_unitario the preco_unitario to set
     */
    public void setPreco_unitario(Double preco_unitario) {
        this.preco_unitario = preco_unitario;
    }

    /**
     * @return the quantidade_produtos
     */
    public Integer getQuantidade_produtos() {
        return quantidade_produtos;
    }

    /**
     * @param quantidade_produtos the quantidade_produtos to set
     */
    public void setQuantidade_produtos(Integer quantidade_produtos) {
        this.quantidade_produtos = quantidade_produtos;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
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

    }