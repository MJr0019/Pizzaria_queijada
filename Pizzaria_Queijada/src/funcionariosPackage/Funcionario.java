package funcionariosPackage;

import java.util.Scanner;
import pedidoPackage.Pedido;

public class Funcionario extends Pedido {

    private int matricula;
    private String nome;
    private String endereco;
    private String senha;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

//    public booleanToString logar(int matricula) {
//        return matricula;
//    }
//
    public boolean setMatricula(Scanner sc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
