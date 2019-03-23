package br.com.cezarcruz.lojaweb.controllers;


import br.com.cezarcruz.lojaweb.entities.Seller;
import br.com.cezarcruz.lojaweb.fixtures.IncludeSellerRequestFixture;
import br.com.cezarcruz.lojaweb.fixtures.SellerFixture;
import br.com.cezarcruz.lojaweb.gateways.rest.request.CreateSellerRequest;
import br.com.cezarcruz.lojaweb.usecases.CreateSeller;
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
public class SellerControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateSeller createSeller;

    @Test
    public void shouldCreateSellerCallingController() throws Exception {

        final CreateSellerRequest sellerRequest = IncludeSellerRequestFixture.withDefaultValues();
        final ObjectMapper objectMapper = new ObjectMapper();

        final Seller seller = SellerFixture.withDefaultValues();

        when(createSeller.execute(any())).thenReturn(seller);

        mockMvc.perform(
                post("/sellers")
                        .content(objectMapper.writeValueAsString(sellerRequest))
                        .contentType(MediaType.APPLICATION_JSON_UTF8)
        )
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(sellerRequest.getName()))
                .andExpect(jsonPath("$.document").value(sellerRequest.getDocument()));

    }

}
