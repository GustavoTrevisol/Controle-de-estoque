package com.gustavotrevisol.estoque.service;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class IngredienteService {
    private final IngredienteRepository repository;

    public IngredienteService(IngredienteRepository repository){
        this.repository = repository;
    }

    public Ingrediente salvar(Ingrediente ingrediente){
        return repository.save(ingrediente);
    }

    public List<Ingrediente> listarTodos(){
        return repository.findAll();
    }
}
