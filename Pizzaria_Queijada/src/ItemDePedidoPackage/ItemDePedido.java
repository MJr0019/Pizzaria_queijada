package ItemDePedidoPackage;

import pedidoPackage.Pedido;

public class ItemDePedido extends Pedido {

    private int codigoPedido;
    private int codigoProduto;
    private int quantidade;

    @Override
    public int getCodigoPedido() {
        return codigoPedido;
    }

    @Override
    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
