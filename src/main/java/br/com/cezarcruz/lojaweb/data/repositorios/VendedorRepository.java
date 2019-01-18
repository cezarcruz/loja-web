package br.com.cezarcruz.lojaweb.data.repositorios;

import br.com.cezarcruz.lojaweb.data.entidades.VendedorEntidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendedorRepository extends JpaRepository<VendedorEntidade, Long> {
    Page<VendedorEntidade> findByNomeContaining(final Pageable pageable, final String nome);
    List<VendedorEntidade> findAllByNomeIgnoreCase(String nome);
}
