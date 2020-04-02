package com.interview.rewardscalculator.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.interview.rewardscalculator.domain.Customer;
import com.interview.rewardscalculator.domain.Product;
import com.interview.rewardscalculator.domain.Transaction;
import com.interview.rewardscalculator.dto.PurchaseResponseDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RewardsController.class)
public class RewardsControllerTest {

  @Autowired private MockMvc mockMvc;

  @MockBean private RewardsController rewardsController;

  @Test
  public void purchaseTransaction() throws Exception {
    Transaction transaction = new Transaction();
    Customer customer = new Customer("Kapil", "Nimje");
    Product product = new Product("Apple iPhone 10", "Electronics", 120);
    transaction.setCustomer(customer);
    transaction.setProduct(product);

    PurchaseResponseDTO purchaseResponseDTO = new PurchaseResponseDTO();
    purchaseResponseDTO.setMessage("Item Purchased Successfully");
    purchaseResponseDTO.setRewardsEarned(90);
    ResponseEntity<PurchaseResponseDTO> responseDTOResponseEntity =
        new ResponseEntity<>(purchaseResponseDTO, HttpStatus.OK);

    // given(rewardsController.purchaseProduct(transaction)).willReturn(responseDTOResponseEntity);

    ResultActions resultActions =
        mockMvc
            .perform(
                MockMvcRequestBuilders.post("/purchase")
                    .content(asJsonString(transaction))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    MvcResult mvcResult = resultActions.andReturn();
    assertNotNull(mvcResult);
  }

  @Test
  public void searchRewardsTest() throws Exception {
    ResultActions resultActions =
        mockMvc
            .perform(
                MockMvcRequestBuilders.get("/rewards/search")
                    .param("firstName", "Kapil")
                    .param("lastName", "Nimje")
                    .param("filterDays", "2")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    MvcResult mvcResult = resultActions.andReturn();
    assertNotNull(mvcResult);
  }

  @Test
  public void getAllRewardsTransactionTest() throws Exception {
    ResultActions resultActions =
        mockMvc
            .perform(
                MockMvcRequestBuilders.get("/rewards/transaction")
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    MvcResult mvcResult = resultActions.andReturn();
    assertNotNull(mvcResult);
  }

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
