package com.gustavotrevisol.estoque.domain.ingredienteReceita;
import com.gustavotrevisol.estoque.domain.Receita.Receita;
import com.gustavotrevisol.estoque.domain.ingrediente.Ingrediente;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;

@Entity
@Table(name = "ingrediente_receita")
@Getter
@Setter
@NoArgsConstructor
public class IngredienteReceita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Muitas linhas para uma receita
    @ManyToOne(optional = false)
    @JoinColumn(name = "receita_id")
    private Receita receita;

    // Muitas linhas usam o mesmo ingrediente
    @ManyToOne(optional = false)
    @JoinColumn(name = "ingrediente_id")
    private Ingrediente ingrediente;

    // Quantidade necessária para 1 unidade da receita
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal quantidadeUsada;
}
