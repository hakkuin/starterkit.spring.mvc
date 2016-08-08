package com.capgemini.chess.service.rest;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.anyLong;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.capgemini.chess.ChessApplication;
import com.capgemini.chess.service.ChallengeService;
import com.capgemini.chess.service.to.ChallengeTo;

/**
 * Test class for testing {@link ChallengeRestService}
 * 
 * @author PPATRONI
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ChessApplication.class)
@WebAppConfiguration
public class ChallengeRestServiceTest {
	
	@Mock
	private ChallengeService challengeService;

	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
	    MockitoAnnotations.initMocks(this);
		Mockito.reset(challengeService);
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		ReflectionTestUtils.setField(wac.getBean(ChallengeRestService.class), "challengeService", challengeService);
	}
	
	@Test
	public void shouldGetAllChallenges() throws Exception {
		// given
		ChallengeTo testChallenge = new ChallengeTo(1L, new Date());
		HashSet<ChallengeTo> testSet = new HashSet<>();
		testSet.add(testChallenge);
		
		// when
		Mockito.when(challengeService.readAllChallenges()).thenReturn(testSet);
		ResultActions response = this.mockMvc
				.perform(get("/rest/all")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content("1"));
		
		// then
		verify(challengeService).readAllChallenges();
		response.andExpect(status().isOk())
				.andExpect(jsonPath("[0].id").value(1));
				
	}
	
	@Test
	public void shouldGetChallengeById() throws Exception {
		// given
		ChallengeTo testChallenge = new ChallengeTo(1L, new Date());
		
		// when
		Mockito.when(challengeService.readChallengeById(anyLong())).thenReturn(testChallenge);
		ResultActions response = mockMvc
				.perform(get("/rest/by-id").param("challengeId", "1")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content("1"));
		
		// then
		verify(challengeService).readChallengeById(anyLong());
		response.andExpect(status().isOk())
				.andExpect(jsonPath("id").value(1));
	}
	
	@Test
	public void shouldGetChallengeByTwoPlayers() throws Exception {
		// given
		HashSet<ChallengeTo> testChallenges = new HashSet<>();
		testChallenges.add(new ChallengeTo(2, 3, null));
		
		// when
		Mockito.when(challengeService.readChallengesByPlayersId(2, 3)).thenReturn(testChallenges);
		ResultActions response = mockMvc
				.perform(get("/rest/by-two-players")
						.param("firstPlayerId", "2")
						.param("secondPlayerId", "3")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content("1"));
		
		// then
		verify(challengeService).readChallengesByPlayersId(2, 3);
		response.andExpect(status().isOk())
				.andExpect(jsonPath("[0].firstPlayerId").value(2))
				.andExpect(jsonPath("[0].secondPlayerId").value(3));
	}
	
	@Test
	public void shouldGetChallengeByOnePlayer() throws Exception {
		// given
		HashSet<ChallengeTo> testChallenges = new HashSet<>();
		testChallenges.add(new ChallengeTo(2, 3, null));
		
		// when
		Mockito.when(challengeService.readChallengesByPlayerId(2)).thenReturn(testChallenges);
		ResultActions response = mockMvc
				.perform(get("/rest/by-one-player")
						.param("playerId", "2")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content("1"));
		
		// then
		verify(challengeService).readChallengesByPlayerId(2);
		response.andExpect(status().isOk())
				.andExpect(jsonPath("[0].firstPlayerId").value(2));
	}
	
	@Test
	public void shouldDeleteChallenge() throws Exception {
		// given
		HashSet<ChallengeTo> testChallenges = new HashSet<>();
		testChallenges.add(new ChallengeTo(69, null));
		
		// when
		ResultActions response = mockMvc
				.perform(delete("/rest/delete")
						.param("challengeId", "69")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content("1"));
		
		// then
		verify(challengeService).readChallengeById(69);
		response.andExpect(status().isOk());
	}
	
	@Test
	public void shouldAddChallenge() throws Exception {
		// given
		ChallengeTo testChallenge = new ChallengeTo(69, 1, null);
		
		// when
		Mockito.when(challengeService.createChallenge(69, 1)).thenReturn(testChallenge);
		ResultActions response = mockMvc
				.perform(post("/rest/add")
						.param("firstPlayerId", "69")
						.param("secondPlayerId", "1")
						.accept(MediaType.APPLICATION_JSON)
						.contentType(MediaType.APPLICATION_JSON)
						.content("1"));
		
		// then
		verify(challengeService).createChallenge(69, 1);
		response.andExpect(status().isOk())
				.andExpect(jsonPath("firstPlayerId").value(69))
				.andExpect(jsonPath("secondPlayerId").value(1));
	}
	
}
