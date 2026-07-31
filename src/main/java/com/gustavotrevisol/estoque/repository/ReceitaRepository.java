package com.gustavotrevisol.estoque.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gustavotrevisol.estoque.domain.Receita.Receita;

public interface ReceitaRepository extends JpaRepository<Receita, Long>{
    
}
