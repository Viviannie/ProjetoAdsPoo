/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetoAds.classesBasicas;

/**
 *
 * @author aluno
 */
public class PedidoProduto {

        private Double prc_unitario;
        private Integer qtd_produtos;
        private Produto produto;
        private Pedido pedido;

        public PedidoProduto() {
            produto = new Produto();
            pedido = new Pedido();
        }

        public Double getPrc_unitario() {
            return prc_unitario;
        }

        public void setPrc_unitario(Double prc_unitario) {
            this.prc_unitario = prc_unitario;
        }

        public Integer getQtd_produtos() {
            return qtd_produtos;
        }

        public void setQtd_produtos(Integer qtd_produtos) {
            this.qtd_produtos = qtd_produtos;
        }

        public Produto getProduto() {
            return produto;
        }

        public void setProduto(Produto produto) {
            this.produto = produto;
        }

        public Pedido getPedido() {
            return pedido;
        }

        public void setPedido(Pedido pedido) {
            this.pedido = pedido;
        }

    }