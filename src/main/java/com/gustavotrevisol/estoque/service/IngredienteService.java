package com.gustavotrevisol.estoque.service;
import java.util.List;
import org.springframework.stereotype.Service;
import com.gustavotrevisol.estoque.repository.IngredienteRepository;
import com.gustavotrevisol.estoque.domain.ingrediente.Ingrediente;
import java.util.Optional;
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

    public Optional<Ingrediente> buscarPorId(Long id){
        return repository.findById(id);
    }

    
}
