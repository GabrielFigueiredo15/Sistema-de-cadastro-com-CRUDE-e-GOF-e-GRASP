package factory;

import model.Plano;


public class PlanoFactory {

    public static Plano criarPlano(int id, String nome, double precoMensal, int quantidadeAssinantes) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do plano não pode ser vazio.");
        }
        if (precoMensal < 0) {
            throw new IllegalArgumentException("Preço mensal não pode ser negativo.");
        }
        if (quantidadeAssinantes < 0) {
            throw new IllegalArgumentException("Quantidade de assinantes não pode ser negativa.");
        }
        return new Plano(id, nome.trim(), precoMensal, quantidadeAssinantes);
    }
}
