package projetoAds.classesBasicas;

/**
  * @author Grupo Programação Orientada a Objetos
  */
public class Venda {

        private Double precoUnitario;
        private Integer quantidadeProduto;
        private Produto produto;
        private Pedido pedido;
    /**
      * usado por padrão para que seja criada uma instancia
      * dos objetos utilizados
      */
        public Venda() {
            produto = new Produto();
            pedido = new Pedido();
        }

    /**
      * @return the precoUnitario
      */
    public Double getPrecoUnitario() {
        return precoUnitario;
    }
    
    /**
      * @param precoUnitario the precoUnitario to set
      */
    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    /**
      * @return the quantidadeProduto
      */
    public Integer getQuantidadeProduto() {
        return quantidadeProduto;
    }

    /**
      * @param quantidadeProduto the quantidadeProduto to set
      */
    public void setQuantidadeProduto(Integer quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
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