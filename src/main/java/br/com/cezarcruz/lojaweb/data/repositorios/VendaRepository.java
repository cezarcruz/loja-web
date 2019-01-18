package br.com.cezarcruz.lojaweb.data.repositorios;

import br.com.cezarcruz.lojaweb.data.entidades.VendaEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<VendaEntidade, Long> {
}
