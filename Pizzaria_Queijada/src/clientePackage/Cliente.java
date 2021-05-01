package clientePackage;

import pedidoPackege.pedido;

public class Cliente extends pedido {

    private int codigoCliente;
    private String nome;
    private String endereco;
    private String tel;

    @Override
    public int getCodigoCliente() {
        return codigoCliente;
    }

    @Override
    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
