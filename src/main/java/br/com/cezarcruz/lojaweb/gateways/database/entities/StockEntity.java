package br.com.cezarcruz.lojaweb.gateways.database.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "stock")
@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class StockEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.DETACH)
    private ProductEntity product;

    private Integer quantity;

}
