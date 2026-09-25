package repository;

import model.Plano;
import factory.PlanoFactory;
import java.util.ArrayList;
import java.util.List;

// CRUDe e Singleton e Creator
public class PlanoRepository {

    private static PlanoRepository instancia;
    private List<Plano> planos;
    private int proximoId;

    // Construtor privado: impede criação externa (essencial no Singleton)
    private PlanoRepository() {
        this.planos = new ArrayList<>();
        this.proximoId = 1;
    }

    public static PlanoRepository getInstance() {
        if (instancia == null) {
            instancia = new PlanoRepository();
        }
        return instancia;
    }

    // CREATE - GRASP Creator: o repositório cria e agrega o novo plano
    public Plano criar(String nome, double precoMensal, int quantidadeAssinantes) {
        Plano plano = PlanoFactory.criarPlano(proximoId, nome, precoMensal, quantidadeAssinantes);
        planos.add(plano);
        proximoId++;
        return plano;
    }

    // READ (todos)
    public List<Plano> listarTodos() {
        return planos;
    }

    // READ (por id)
    public Plano buscarPorId(int id) {
        for (Plano p : planos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // UPDATE
    public boolean atualizar(int id, String nome, double precoMensal, int quantidadeAssinantes) {
        Plano plano = buscarPorId(id);
        if (plano == null) {
            return false;
        }
        plano.setNome(nome);
        plano.setPrecoMensal(precoMensal);
        plano.setQuantidadeAssinantes(quantidadeAssinantes);
        return true;
    }

    // DELETE
    public boolean deletar(int id) {
        Plano plano = buscarPorId(id);
        if (plano == null) {
            return false;
        }
        planos.remove(plano);
        return true;
    }
}
