package br.com.cezarcruz.lojaweb.controllers;

import br.com.cezarcruz.lojaweb.entities.Product;
import br.com.cezarcruz.lojaweb.fixtures.IncludeProductRequestFixture;
import br.com.cezarcruz.lojaweb.gateways.rest.request.IncludeProductRequest;
import br.com.cezarcruz.lojaweb.usecases.CreateProduct;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateProduct createProduct;

    @Test
    public void shouldCreateNewProduct() throws Exception {

        final IncludeProductRequest includeProductRequest = IncludeProductRequestFixture.withDefaultValues();
        final ObjectMapper objectMapper = new ObjectMapper();

        final Product product
                = Product.builder()
                    .name(includeProductRequest.getName())
                    .price(includeProductRequest.getPrice())
                    .id(1L)
                    .build();

        when(createProduct.execute(any())).thenReturn(product);

        mockMvc.perform(
                    post("/products")
                        .content(objectMapper.writeValueAsString(includeProductRequest))
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
                )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value(includeProductRequest.getName()))
                .andExpect(jsonPath("$.price").value(includeProductRequest.getPrice()));

    }

}
