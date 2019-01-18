package br.com.cezarcruz.lojaweb.controllers;

import br.com.cezarcruz.lojaweb.casodeuso.vendedores.BuscaVendedor;
import br.com.cezarcruz.lojaweb.casodeuso.vendedores.IncluiVendedor;
import br.com.cezarcruz.lojaweb.data.entidades.VendedorEntidade;
import br.com.cezarcruz.lojaweb.data.model.Vendedor;
import br.com.cezarcruz.lojaweb.data.model.request.IncluiVendedorRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class VendedorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IncluiVendedor incluiVendedor;

    @MockBean
    private BuscaVendedor buscaVendedor;

    @Test
    public void incluiVendedor() throws Exception {
        final IncluiVendedorRequest vendedorRequest
                = IncluiVendedorRequest.builder().nome("Son Goku").build();

        final ObjectMapper mapper = new ObjectMapper();
        final String jsonInString = mapper.writeValueAsString(vendedorRequest);

        BDDMockito.given(this.incluiVendedor.executa(vendedorRequest))
                .willReturn(Vendedor.builder().nome("Son Goku").id(1L).build());

        mockMvc.perform(MockMvcRequestBuilders.post("/vendedores")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonInString)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json("{\"id\":1,\"nome\":\"Son Goku\"}"));
    }


    @Test
    public void incluiVendedorNulo() throws Exception {
        final IncluiVendedorRequest vendedorRequest
                = IncluiVendedorRequest.builder().nome("Son Goku").build();

        final ObjectMapper mapper = new ObjectMapper();
        final String jsonInString = mapper.writeValueAsString(vendedorRequest);

        BDDMockito.given(this.incluiVendedor.executa(vendedorRequest)).willReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.post("/vendedores")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonInString)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    public void buscaVendedorPorNome() throws Exception {

        BDDMockito.given(this.buscaVendedor.porNome("goku"))
                .willReturn(List.of(VendedorEntidade.builder().nome("Goku").id(1L).build()));

        BDDMockito.given(this.buscaVendedor.porNome("bulma"))
                .willReturn(List.of());

        mockMvc.perform(MockMvcRequestBuilders.get("/vendedores/nome/goku")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());

        mockMvc.perform(MockMvcRequestBuilders.get("/vendedores/nome/vejeta")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());

        mockMvc.perform(MockMvcRequestBuilders.get("/vendedores/nome/bulma")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());

    }

}
