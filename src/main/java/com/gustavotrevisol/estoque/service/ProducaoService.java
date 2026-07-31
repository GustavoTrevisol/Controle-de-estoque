package com.gustavotrevisol.estoque.service;

import com.gustavotrevisol.estoque.domain.ingrediente.Ingrediente;
import com.gustavotrevisol.estoque.domain.producao.Producao;
import com.gustavotrevisol.estoque.domain.ingredienteReceita.IngredienteReceita;
import com.gustavotrevisol.estoque.domain.Receita.Receita;
import com.gustavotrevisol.estoque.repository.IngredienteRepository;
import com.gustavotrevisol.estoque.repository.IngredienteReceitaRepository;
import com.gustavotrevisol.estoque.repository.ProducaoRepository;
import com.gustavotrevisol.estoque.repository.ReceitaRepository;
import com.gustavotrevisol.estoque.service.IngredienteService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProducaoService {

    private final ReceitaRepository receitaRepository;
    private final IngredienteReceitaRepository ingredienteReceitaRepository;
    private final IngredienteRepository ingredienteRepository;
    private final ProducaoRepository producaoRepository;

    public ProducaoService(ReceitaRepository receitaRepository, IngredienteReceitaRepository ingredienteReceitaRepository, IngredienteRepository ingredienteRepository, ProducaoRepository producaoRepository) {
        this.receitaRepository = receitaRepository;
        this.ingredienteReceitaRepository = ingredienteReceitaRepository;
        this.ingredienteRepository = ingredienteRepository;
        this.producaoRepository = producaoRepository;
    }

    @Transactional
    public void RegistrarProducao(Long receita_id, Integer quantidadeProduzida){
        Receita receita = receitaRepository.findById(receita_id)
                .orElseThrow(() -> new NoSuchElementException("Receita não encontrada"));

        List<IngredienteReceita> listaIngredientesReceita = ingredienteReceitaRepository.findAll();

        for (IngredienteReceita ingredienteReceita : listaIngredientesReceita) {
            if (ingredienteReceita.getReceita() != null && receita_id.equals(ingredienteReceita.getReceita().getId())) {
                Ingrediente ingrediente = ingredienteReceita.getIngrediente();
                BigDecimal quantidadeNecessaria = ingredienteReceita.getQuantidadeUsada()
                        .multiply(BigDecimal.valueOf(quantidadeProduzida));

                if (ingrediente.getQuantidade().compareTo(quantidadeNecessaria) < 0) {
                    throw new IllegalStateException("Estoque insuficiente para o ingrediente: " + ingrediente.getNome());
                }

                ingrediente.setQuantidade(ingrediente.getQuantidade().subtract(quantidadeNecessaria));
                ingredienteRepository.save(ingrediente);
            }
        }

        Producao producao = new Producao();
        producao.setReceita(receita);
        producao.setQuantidadeProduzida(quantidadeProduzida);
        producao.setData(LocalDate.now());
        producaoRepository.save(producao);
    }


}
