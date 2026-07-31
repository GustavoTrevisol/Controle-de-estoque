package com.gustavotrevisol.estoque.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gustavotrevisol.estoque.domain.ingredienteReceita.IngredienteReceita;

public interface IngredienteReceitaRepository extends JpaRepository<IngredienteReceita, Long>{
    
}
