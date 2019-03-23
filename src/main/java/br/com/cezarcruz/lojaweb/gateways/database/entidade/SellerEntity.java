package br.com.cezarcruz.lojaweb.gateways.database.entidade;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "sellers")
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class SellerEntity {

    @Id
    private String document;
    private String name;

}
