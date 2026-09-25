package controller;

import model.Plano;
import repository.PlanoRepository;
import java.util.List;

    //chamar funçoes
public class PlanoController {

    private PlanoRepository repository;

    public PlanoController() {
        this.repository = PlanoRepository.getInstance();
    }

    public Plano cadastrar(String nome, double precoMensal, int quantidadeAssinantes) {
        return repository.criar(nome, precoMensal, quantidadeAssinantes);
    }

    public List<Plano> listar() {
        return repository.listarTodos();
    }

    public Plano buscar(int id) {
        return repository.buscarPorId(id);
    }

    public boolean atualizar(int id, String nome, double precoMensal, int quantidadeAssinantes) {
        return repository.atualizar(id, nome, precoMensal, quantidadeAssinantes);
    }

    public boolean remover(int id) {
        return repository.deletar(id);
    }
}
