package com.gustavotrevisol.estoque.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gustavotrevisol.estoque.domain.producao.Producao;

public interface ProducaoRepository extends JpaRepository<Producao, Long>{
    
}
