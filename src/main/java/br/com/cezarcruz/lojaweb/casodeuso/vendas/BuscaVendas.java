package br.com.cezarcruz.lojaweb.casodeuso.vendas;

import br.com.cezarcruz.lojaweb.data.repositorios.VendaRepository;
import br.com.cezarcruz.lojaweb.data.model.response.VendaResponse;
import br.com.cezarcruz.lojaweb.transformacao.VendaParaVendaResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuscaVendas {

    private VendaRepository vendaRepository;

    public BuscaVendas(final VendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public List<VendaResponse> executa() {
        return vendaRepository.findAll()
                .stream()
                .map(VendaParaVendaResponse::para)
                .collect(Collectors.toList());
    }

}
