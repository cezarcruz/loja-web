package br.com.cezarcruz.lojaweb.data.entidades.caixa;

import br.com.cezarcruz.lojaweb.data.enums.TipoFluxo;
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
import javax.persistence.Table;

@Entity
@Table(name = "fluxo")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FluxoEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double valor;

    @Column(name = "tipo_fluxo")
    @Enumerated(EnumType.STRING)
    private TipoFluxo tipoFluxo;

    private String motivo;
}
