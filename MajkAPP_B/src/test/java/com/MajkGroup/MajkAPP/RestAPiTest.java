package com.MajkGroup.MajkAPP;

import com.MajkGroup.MajkAPP.Domain.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.lang.reflect.Type;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@AutoConfigureMockMvc
class RestAPiTest {
	User user;
	@Autowired
	private MockMvc mockMvc;

	private final ObjectMapper objectMapper = new ObjectMapper();

	@BeforeEach
	void pred(){
		user = new User("Michal Kroslak","xMajk","Krpci11","majk@gmail.com");
		user.setId(1);
		final String baseUrl = ServletUriComponentsBuilder.fromCurrentContextPath().build().toUriString();
		System.out.println(baseUrl);
	}



	@Test
	void postM() throws Exception{
		String id = mockMvc.perform(post("/user")
						.contentType(MediaType.APPLICATION_JSON)
								.content(objectMapper.writeValueAsString(user)))
				.andExpect(status().isCreated())
				.andReturn().getResponse().getContentAsString();
	    user.setId(Integer.parseInt(id));
			}

	@Test
	void getM() throws Exception {
		String getMet = mockMvc.perform(get("/user/" + user.getId())
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		User userDb = objectMapper.readValue(getMet, User.class);
		Assertions.assertEquals(user,userDb);
	}

	@Test
	void getLogName() throws Exception {
		String listJson = mockMvc.perform(get("/user")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andReturn().getResponse().getContentAsString();
		List<User> userList= objectMapper.readValue(listJson, new TypeReference<List<User>>() {});
		System.out.println(userList);
//		Assertions.assertEquals(userList, userList);

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 5; j++) {

			}
		}
	}

}
