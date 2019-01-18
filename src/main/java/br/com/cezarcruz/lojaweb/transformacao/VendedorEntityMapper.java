package br.com.cezarcruz.lojaweb.transformacao;

import br.com.cezarcruz.lojaweb.data.entidades.VendedorEntidade;
import br.com.cezarcruz.lojaweb.data.model.Vendedor;
import br.com.cezarcruz.lojaweb.data.model.request.IncluiVendedorRequest;

public class VendedorEntityMapper {

    private VendedorEntityMapper() {}

    public static VendedorEntidade fromRequest(final IncluiVendedorRequest incluiVendedorRequest) {

        if (incluiVendedorRequest != null) {
            return VendedorEntidade.builder()
                    .nome(incluiVendedorRequest.getNome())
                    .cpf(incluiVendedorRequest.getCpf())
                    .build();
        }

        return null;
    }

    public static Vendedor fromEntidade(final VendedorEntidade vendedor) {

        if (vendedor != null) {
            return Vendedor.builder()
                    .id(vendedor.getId())
                    .nome(vendedor.getNome())
                    .cpf(vendedor.getCpf())
                    .build();
        }

        return null;
    }

}
