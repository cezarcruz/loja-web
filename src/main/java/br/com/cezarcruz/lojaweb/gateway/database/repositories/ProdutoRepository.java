package br.com.cezarcruz.lojaweb.gateway.database.repositories;

import br.com.cezarcruz.lojaweb.gateway.database.entidade.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

}
