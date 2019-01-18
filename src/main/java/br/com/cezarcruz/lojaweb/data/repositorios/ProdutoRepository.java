package br.com.cezarcruz.lojaweb.data.repositorios;

import br.com.cezarcruz.lojaweb.data.entidades.ProdutoEntidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntidade, Long> {
    Optional<ProdutoEntidade> findById(final Long id);
    Page<ProdutoEntidade> findByNomeContainingIgnoreCase(final Pageable pageable, final String nome);
}
