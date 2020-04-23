package com.qa.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.demo.data.domain.Train;
import com.qa.demo.dto.TrainDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TrainControllerIntegrationTest {

	@Autowired
	private MockMvc mvc;

	private ObjectMapper mapper = new ObjectMapper();

	private Train train = new Train("Henry", "Green");

	private TrainDTO dto = new TrainDTO(1L, train.getName(), train.getColour());

	@Test
	public void create() throws JsonProcessingException, Exception {
		String dtoString = mapper.writeValueAsString(dto);
		
		RequestBuilder request = request(HttpMethod.POST, "/train/create")
				.content(mapper.writeValueAsString(train))
				.contentType(MediaType.APPLICATION_JSON);
		
		String responseBody = this.mvc
				.perform(request)
				.andExpect(status().is(200))
				.andReturn().getResponse().getContentAsString();

		assertEquals(responseBody, dtoString);
	}

}
