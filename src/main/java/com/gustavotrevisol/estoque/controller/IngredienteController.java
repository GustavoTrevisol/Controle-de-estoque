package com.gustavotrevisol.estoque.controller;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gustavotrevisol.estoque.service.IngredienteService;
import com.gustavotrevisol.estoque.domain.ingrediente.Ingrediente;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/ingredientes")
public class IngredienteController {
    private final IngredienteService ingredienteService;

    public IngredienteController(IngredienteService ingredienteService){
        this.ingredienteService = ingredienteService;
    }

    @GetMapping
    public List<Ingrediente> getIngredientes(){
        return ingredienteService.listarTodos();
    }

    @PostMapping
    public Ingrediente postIngrediente (@RequestBody Ingrediente ingrediente){
        return ingredienteService.salvar(ingrediente);
        
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingrediente> getIngredienteById(@PathVariable Long id){
        Ingrediente ingrediente = ingredienteService.buscarPorId(id);
        return ResponseEntity.ok(ingrediente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteIngredienteById(@PathVariable Long id){
        ingredienteService.deletar(id);
        return ResponseEntity.noContent().build();
        
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> setQuantidadeById(@PathVariable Long id, @RequestBody BigDecimal quantidade){
        ingredienteService.atualizarQuantidade(id, quantidade);
        return ResponseEntity.noContent().build();
    }
}
