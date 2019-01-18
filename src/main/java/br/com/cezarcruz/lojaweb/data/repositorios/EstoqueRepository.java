package br.com.cezarcruz.lojaweb.data.repositorios;

import br.com.cezarcruz.lojaweb.data.entidades.EstoqueEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstoqueRepository extends JpaRepository<EstoqueEntidade, Long> {
    Optional<EstoqueEntidade> findByProdutoId(final Long produtoId);
}
