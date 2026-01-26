package com.gustavotrevisol.estoque.domain.ingrediente;
import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="ingredientes")
@Getter
@Setter
@NoArgsConstructor
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal quantidade;

    @Column(nullable = false)
    private String unidade;

//     Estou continuando um projeto em Java com Spring Boot para controle de estoque.
// Uso Postgres, Maven e Docker.
// Já tenho Ingrediente, Repository, Service e Controller funcionando.
// O CRUD de Ingrediente está em andamento e já resolvi erros de POST e validação.
// Quero seguir evoluindo a arquitetura e aprender boas práticas de backend.
}
