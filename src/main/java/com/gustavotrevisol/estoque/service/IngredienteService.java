package com.gustavotrevisol.estoque.service;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;
import com.gustavotrevisol.estoque.repository.IngredienteRepository;
import com.gustavotrevisol.estoque.domain.ingrediente.Ingrediente;
import java.util.Optional;
import java.util.NoSuchElementException;




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

    public Ingrediente buscarPorId(Long id){
        Optional<Ingrediente> ingrediente = repository.findById(id);
        return ingrediente.orElseThrow(() -> new NoSuchElementException("Ingrediente com id: " + id + " não foi encontrado"));
    }

    public void deletar(Long id){
        Ingrediente ingrediente = buscarPorId(id);
        repository.delete(ingrediente);
    }

    public void atualizarQuantidade(Long id, BigDecimal quantidade){
        Ingrediente ingrediente = buscarPorId(id);
        ingrediente.setQuantidade(quantidade);
        repository.save(ingrediente);
    }
    
}
