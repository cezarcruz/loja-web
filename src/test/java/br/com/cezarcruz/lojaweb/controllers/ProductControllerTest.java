package br.com.cezarcruz.lojaweb.controllers;

import br.com.cezarcruz.lojaweb.entities.Product;
import br.com.cezarcruz.lojaweb.entities.Stock;
import br.com.cezarcruz.lojaweb.exceptions.ProductNotFoundException;
import br.com.cezarcruz.lojaweb.fixtures.IncludeProductRequestFixture;
import br.com.cezarcruz.lojaweb.fixtures.StockFixture;
import br.com.cezarcruz.lojaweb.gateways.rest.request.IncludeProductRequest;
import br.com.cezarcruz.lojaweb.gateways.rest.request.IncludeStockRequest;
import br.com.cezarcruz.lojaweb.usecases.CreateProduct;
import br.com.cezarcruz.lojaweb.usecases.IncludeInStock;
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

    @MockBean
    private IncludeInStock includeInStock;

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

    @Test
    public void shouldCreateStock() throws Exception {
        final Stock stock = StockFixture.withDefaultValues();

        final ObjectMapper objectMapper = new ObjectMapper();

        when(includeInStock.execute(any()))
                .thenReturn(stock);

        final IncludeStockRequest includeStockRequest = IncludeStockRequest.builder().quantity(10).build();

        mockMvc.perform(
                post("/products/1/stock")
                        .content(objectMapper.writeValueAsString(includeStockRequest))
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
        ).andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.quantity").value(includeStockRequest.getQuantity()))
                .andExpect(jsonPath("$.product.name").value(stock.getProduct().getName()))
                ;
    }

    @Test
    public void shouldHandleProductNotFoundWhenAddStock() throws Exception {

        final ObjectMapper objectMapper = new ObjectMapper();

        when(includeInStock.execute(any()))
                .thenThrow(new ProductNotFoundException());

        final IncludeStockRequest includeStockRequest = IncludeStockRequest.builder().quantity(10).build();

        mockMvc.perform(
                post("/products/2/stock")
                        .content(objectMapper.writeValueAsString(includeStockRequest))
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
        ).andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.code").value(404))
                .andExpect(jsonPath("$.message").value("Product not found"))
        ;
    }

}
