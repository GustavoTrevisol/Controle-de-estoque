package com.gustavotrevisol.estoque.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gustavotrevisol.estoque.domain.ingrediente.Ingrediente;

public interface IngredienteRepository
    extends JpaRepository<Ingrediente,Long>{
}
