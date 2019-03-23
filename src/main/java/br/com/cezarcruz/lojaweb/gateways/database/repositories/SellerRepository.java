package br.com.cezarcruz.lojaweb.gateways.database.repositories;

import br.com.cezarcruz.lojaweb.gateways.database.entidade.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, Long> {
}
