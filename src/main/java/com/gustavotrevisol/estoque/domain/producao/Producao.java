package com.gustavotrevisol.estoque.domain.producao;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import com.gustavotrevisol.estoque.domain.Receita.Receita;

@Entity
@Table(name="producao")
@Getter
@Setter
@NoArgsConstructor
public class Producao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "receita_id")
    private Receita receita;

    @Column(nullable = false)
    private Integer quantidadeProduzida;
    
    @Column(nullable = false)
    private LocalDate data;


}
