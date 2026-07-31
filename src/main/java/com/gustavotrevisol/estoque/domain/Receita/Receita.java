package com.gustavotrevisol.estoque.domain.Receita;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;
import com.gustavotrevisol.estoque.domain.ingredienteReceita.IngredienteReceita;
import com.gustavotrevisol.estoque.domain.producao.Producao;


@Entity
@Table(name= "receita")
@Getter
@Setter
@NoArgsConstructor
public class Receita {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true)
    private String nome;

    @ManyToMany(mappedBy = "receita")
    private List<IngredienteReceita> ingredientes;

    @ManyToMany(mappedBy = "receita")
    private List<Producao> producoes;

}
