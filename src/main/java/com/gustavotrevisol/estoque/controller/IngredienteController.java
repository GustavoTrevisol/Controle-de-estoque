package com.gustavotrevisol.estoque.controller;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gustavotrevisol.estoque.service.IngredienteService;
import com.gustavotrevisol.estoque.domain.ingrediente.Ingrediente;
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

    @GetMapping("/id")
    public ResponseEntity<Ingrediente> getIngredienteById(@PathVariable Long id){
        return ingredienteService.buscarPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
