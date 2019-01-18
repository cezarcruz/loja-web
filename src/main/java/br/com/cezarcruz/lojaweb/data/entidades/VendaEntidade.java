package br.com.cezarcruz.lojaweb.data.entidades;

import br.com.cezarcruz.lojaweb.data.enums.TipoPagamento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "vendas")
public class VendaEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_total")
    private Double valorTotal;

    @Column(name = "data_venda")
    private Date dataVenda;

    @ManyToOne
    private VendedorEntidade vendedor;

    @ManyToMany
    private List<ProdutoEntidade> produtos;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

}
