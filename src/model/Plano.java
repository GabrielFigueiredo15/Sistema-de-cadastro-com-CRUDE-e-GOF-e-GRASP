package model;

//Expert calculos
public class Plano {

    private int id;
    private String nome;
    private double precoMensal;
    private int quantidadeAssinantes;

    public Plano(int id, String nome, double precoMensal, int quantidadeAssinantes) {
        this.id = id;
        this.nome = nome;
        this.precoMensal = precoMensal;
        this.quantidadeAssinantes = quantidadeAssinantes;
    }

    public double calcularReceitaMensal() {
        return precoMensal * quantidadeAssinantes;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrecoMensal() {
        return precoMensal;
    }

    public void setPrecoMensal(double precoMensal) {
        this.precoMensal = precoMensal;
    }

    public int getQuantidadeAssinantes() {
        return quantidadeAssinantes;
    }

    public void setQuantidadeAssinantes(int quantidadeAssinantes) {
        this.quantidadeAssinantes = quantidadeAssinantes;
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Plano: %-15s | Preço mensal: R$ %8.2f | Assinantes: %6d | Receita mensal: R$ %12.2f",
                id, nome, precoMensal, quantidadeAssinantes, calcularReceitaMensal());
    }
}
