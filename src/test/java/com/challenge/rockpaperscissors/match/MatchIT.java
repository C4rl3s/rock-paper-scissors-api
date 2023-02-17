package com.challenge.rockpaperscissors.match;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;

import com.challenge.rockpaperscissors.dto.match.MatchDto;
import com.challenge.rockpaperscissors.dto.match.MatchSummaryDto;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class MatchIT {

	private static final String LOCALHOST = "http://localhost:";
	private static final String PLAY_MATCH_SERVICE_PATH = "/match/play/";
	private static final String MATCH_SUMMARY_SERVICE_PATH = "/match/summary/";

	private static final String VALID_MOVE = "Rock";
	private static final String NOT_VALID_MOVE = "Gomu-Gomu no Pistol";

	@Autowired
	protected TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	@Test
	public void playMatchWithValidMoveShouldSaveMatch() {

		ResponseEntity<MatchDto> response = restTemplate
				.getForEntity(LOCALHOST + port + PLAY_MATCH_SERVICE_PATH + VALID_MOVE, MatchDto.class);

		assertNotNull(response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	public void playMatchWithNotValidMoveShouldThrowException() {

		ResponseEntity<MatchDto> response = restTemplate
				.getForEntity(LOCALHOST + port + PLAY_MATCH_SERVICE_PATH + NOT_VALID_MOVE, MatchDto.class);

		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}

	@Test
	public void getMatchSummaryShouldReturnMatchSummaryDto() {

		ResponseEntity<MatchSummaryDto> response = restTemplate
				.getForEntity(LOCALHOST + port + MATCH_SUMMARY_SERVICE_PATH, MatchSummaryDto.class);

		assertNotNull(response.getBody());
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}
}
