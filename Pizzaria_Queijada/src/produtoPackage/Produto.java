package produtoPackage;

import ItemDePedidoPackage.ItemDePedido;

public class Produto extends ItemDePedido {

    private int codigoProduto;
    private String nome;
    private double precoUnitario;

    @Override
    public int getCodigoProduto() {
        return codigoProduto;
    }

    @Override
    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    @Override
    public String toString() {
        return "Produto [codigoProduto=" + codigoProduto + ", nome=" + nome + ", precoUnitario=" + precoUnitario + "]";
    }
}
