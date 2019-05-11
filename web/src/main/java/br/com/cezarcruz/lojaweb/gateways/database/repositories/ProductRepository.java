package br.com.cezarcruz.lojaweb.gateways.database.repositories;

import br.com.cezarcruz.lojaweb.gateways.database.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
